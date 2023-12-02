package com.android.dx;

import com.android.dex.DexFormat;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.code.RopTranslator;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.EncodedField;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import org.jcodings.exception.ErrorCodes;

/* loaded from: classes2.dex */
public final class DexMaker {
    private DexFile outputDex;
    private ClassLoader sharedClassLoader;
    private final Map<TypeId<?>, TypeDeclaration> types = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FieldDeclaration {
        private final int accessFlags;
        final FieldId<?, ?> fieldId;
        private final Object staticValue;

        FieldDeclaration(FieldId<?, ?> fieldId, int i4, Object obj) {
            if ((i4 & 8) == 0 && obj != null) {
                throw new IllegalArgumentException("instance fields may not have a value");
            }
            this.fieldId = fieldId;
            this.accessFlags = i4;
            this.staticValue = obj;
        }

        public boolean isStatic() {
            if ((this.accessFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        EncodedField toEncodedField() {
            return new EncodedField(this.fieldId.constant, this.accessFlags);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MethodDeclaration {
        private final Code code = new Code(this);
        private final int flags;
        final MethodId<?, ?> method;

        public MethodDeclaration(MethodId<?, ?> methodId, int i4) {
            this.method = methodId;
            this.flags = i4;
        }

        boolean isDirect() {
            if ((this.flags & 65546) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isStatic() {
            if ((this.flags & 8) != 0) {
                return true;
            }
            return false;
        }

        EncodedMethod toEncodedMethod(DexOptions dexOptions) {
            return new EncodedMethod(this.method.constant, this.flags, RopTranslator.translate(new RopMethod(this.code.toBasicBlocks(), 0), 1, null, this.code.paramSize(), dexOptions), StdTypeList.EMPTY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TypeDeclaration {
        private ClassDefItem classDefItem;
        private boolean declared;
        private int flags;
        private TypeList interfaces;
        private String sourceFile;
        private TypeId<?> supertype;
        private final TypeId<?> type;
        private final Map<FieldId, FieldDeclaration> fields = new LinkedHashMap();
        private final Map<MethodId, MethodDeclaration> methods = new LinkedHashMap();

        TypeDeclaration(TypeId<?> typeId) {
            this.type = typeId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ClassDefItem toClassDefItem() {
            if (this.declared) {
                DexOptions dexOptions = new DexOptions();
                dexOptions.targetApiLevel = 13;
                CstType cstType = this.type.constant;
                if (this.classDefItem == null) {
                    this.classDefItem = new ClassDefItem(cstType, this.flags, this.supertype.constant, this.interfaces.ropTypes, new CstString(this.sourceFile));
                    for (MethodDeclaration methodDeclaration : this.methods.values()) {
                        EncodedMethod encodedMethod = methodDeclaration.toEncodedMethod(dexOptions);
                        if (methodDeclaration.isDirect()) {
                            this.classDefItem.addDirectMethod(encodedMethod);
                        } else {
                            this.classDefItem.addVirtualMethod(encodedMethod);
                        }
                    }
                    for (FieldDeclaration fieldDeclaration : this.fields.values()) {
                        EncodedField encodedField = fieldDeclaration.toEncodedField();
                        if (fieldDeclaration.isStatic()) {
                            this.classDefItem.addStaticField(encodedField, Constants.getConstant(fieldDeclaration.staticValue));
                        } else {
                            this.classDefItem.addInstanceField(encodedField);
                        }
                    }
                }
                return this.classDefItem;
            }
            throw new IllegalStateException("Undeclared type " + this.type + " declares members: " + this.fields.keySet() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.methods.keySet());
        }
    }

    private ClassLoader generateClassLoader(File file, File file2, ClassLoader classLoader) {
        try {
            ClassLoader classLoader2 = this.sharedClassLoader;
            if (classLoader2 != null) {
                if (classLoader == null) {
                    classLoader = classLoader2;
                }
                classLoader.getClass().getMethod("addDexPath", String.class).invoke(classLoader, file.getPath());
                return classLoader;
            }
            return (ClassLoader) Class.forName("dalvik.system.DexClassLoader").getConstructor(String.class, String.class, String.class, ClassLoader.class).newInstance(file.getPath(), file2.getAbsolutePath(), null, classLoader);
        } catch (ClassNotFoundException e4) {
            throw new UnsupportedOperationException("load() requires a Dalvik VM", e4);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InstantiationException unused2) {
            throw new AssertionError();
        } catch (NoSuchMethodException unused3) {
            throw new AssertionError();
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5.getCause());
        }
    }

    private String generateFileName() {
        Set<TypeId<?>> keySet = this.types.keySet();
        int size = keySet.size();
        int[] iArr = new int[size];
        int i4 = 0;
        for (TypeId<?> typeId : keySet) {
            TypeDeclaration typeDeclaration = getTypeDeclaration(typeId);
            Set keySet2 = typeDeclaration.methods.keySet();
            if (typeDeclaration.supertype != null) {
                iArr[i4] = (typeDeclaration.supertype.hashCode() * 31) + keySet2.hashCode();
                i4++;
            }
        }
        Arrays.sort(iArr);
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        return "Generated_" + i5 + ".jar";
    }

    public void declare(TypeId<?> typeId, String str, int i4, TypeId<?> typeId2, TypeId<?>... typeIdArr) {
        TypeDeclaration typeDeclaration = getTypeDeclaration(typeId);
        if ((i4 & (-1042)) == 0) {
            if (!typeDeclaration.declared) {
                typeDeclaration.declared = true;
                typeDeclaration.flags = i4;
                typeDeclaration.supertype = typeId2;
                typeDeclaration.sourceFile = str;
                typeDeclaration.interfaces = new TypeList(typeIdArr);
                return;
            }
            throw new IllegalStateException("already declared: " + typeId);
        }
        throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(i4));
    }

    public byte[] generate() {
        if (this.outputDex == null) {
            DexOptions dexOptions = new DexOptions();
            dexOptions.targetApiLevel = 13;
            this.outputDex = new DexFile(dexOptions);
        }
        for (TypeDeclaration typeDeclaration : this.types.values()) {
            this.outputDex.add(typeDeclaration.toClassDefItem());
        }
        try {
            return this.outputDex.toDex(null, false);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public ClassLoader generateAndLoad(ClassLoader classLoader, File file) throws IOException {
        if (file == null) {
            String property = System.getProperty("dexmaker.dexcache");
            if (property != null) {
                file = new File(property);
            } else {
                file = new AppDataDirGuesser().guess();
                if (file == null) {
                    throw new IllegalArgumentException("dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)");
                }
            }
        }
        File file2 = new File(file, generateFileName());
        if (file2.exists()) {
            return generateClassLoader(file2, file, classLoader);
        }
        byte[] generate = generate();
        file2.createNewFile();
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
        JarEntry jarEntry = new JarEntry(DexFormat.DEX_IN_JAR_NAME);
        jarEntry.setSize(generate.length);
        jarOutputStream.putNextEntry(jarEntry);
        jarOutputStream.write(generate);
        jarOutputStream.closeEntry();
        jarOutputStream.close();
        return generateClassLoader(file2, file, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DexFile getDexFile() {
        if (this.outputDex == null) {
            DexOptions dexOptions = new DexOptions();
            dexOptions.targetApiLevel = 13;
            this.outputDex = new DexFile(dexOptions);
        }
        return this.outputDex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeDeclaration getTypeDeclaration(TypeId<?> typeId) {
        TypeDeclaration typeDeclaration = this.types.get(typeId);
        if (typeDeclaration == null) {
            TypeDeclaration typeDeclaration2 = new TypeDeclaration(typeId);
            this.types.put(typeId, typeDeclaration2);
            return typeDeclaration2;
        }
        return typeDeclaration;
    }

    public void setSharedClassLoader(ClassLoader classLoader) {
        this.sharedClassLoader = classLoader;
    }

    public Code declare(MethodId<?, ?> methodId, int i4) {
        TypeDeclaration typeDeclaration = getTypeDeclaration(methodId.declaringType);
        if (typeDeclaration.methods.containsKey(methodId)) {
            throw new IllegalStateException("already declared: " + methodId);
        } else if ((i4 & (-64)) == 0) {
            if ((i4 & 32) != 0) {
                i4 = (i4 & (-33)) | 131072;
            }
            if (methodId.isConstructor() || methodId.isStaticInitializer()) {
                i4 |= 65536;
            }
            MethodDeclaration methodDeclaration = new MethodDeclaration(methodId, i4);
            typeDeclaration.methods.put(methodId, methodDeclaration);
            return methodDeclaration.code;
        } else {
            throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(i4));
        }
    }

    public void declare(FieldId<?, ?> fieldId, int i4, Object obj) {
        TypeDeclaration typeDeclaration = getTypeDeclaration(fieldId.declaringType);
        if (typeDeclaration.fields.containsKey(fieldId)) {
            throw new IllegalStateException("already declared: " + fieldId);
        } else if ((i4 & ErrorCodes.ERR_TOO_MANY_CAPTURE_GROUPS) != 0) {
            throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(i4));
        } else if ((i4 & 8) == 0 && obj != null) {
            throw new IllegalArgumentException("staticValue is non-null, but field is not static");
        } else {
            typeDeclaration.fields.put(fieldId, new FieldDeclaration(fieldId, i4, obj));
        }
    }
}
