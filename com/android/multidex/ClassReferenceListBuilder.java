package com.android.multidex;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public class ClassReferenceListBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CLASS_EXTENSION = ".class";
    private final Set<String> classNames = new HashSet();
    private final Path path;

    public ClassReferenceListBuilder(Path path) {
        this.path = path;
    }

    private void addClassWithHierachy(String str) {
        if (this.classNames.contains(str)) {
            return;
        }
        try {
            Path path = this.path;
            DirectClassFile directClassFile = path.getClass(str + ".class");
            this.classNames.add(str);
            CstType superclass = directClassFile.getSuperclass();
            if (superclass != null) {
                addClassWithHierachy(superclass.getClassType().getClassName());
            }
            TypeList interfaces = directClassFile.getInterfaces();
            int size = interfaces.size();
            for (int i4 = 0; i4 < size; i4++) {
                addClassWithHierachy(interfaces.getType(i4).getClassName());
            }
        } catch (FileNotFoundException unused) {
        }
    }

    private void addDependencies(DirectClassFile directClassFile) {
        Constant[] entries;
        for (Constant constant : directClassFile.getConstantPool().getEntries()) {
            if (constant instanceof CstType) {
                checkDescriptor(((CstType) constant).getClassType().getDescriptor());
            } else if (constant instanceof CstFieldRef) {
                checkDescriptor(((CstFieldRef) constant).getType().getDescriptor());
            } else if (constant instanceof CstBaseMethodRef) {
                checkPrototype(((CstBaseMethodRef) constant).getPrototype());
            }
        }
        FieldList fields = directClassFile.getFields();
        int size = fields.size();
        for (int i4 = 0; i4 < size; i4++) {
            checkDescriptor(fields.get(i4).getDescriptor().getString());
        }
        MethodList methods = directClassFile.getMethods();
        int size2 = methods.size();
        for (int i5 = 0; i5 < size2; i5++) {
            checkPrototype(Prototype.intern(methods.get(i5).getDescriptor().getString()));
        }
    }

    private void checkDescriptor(String str) {
        if (str.endsWith(";")) {
            int lastIndexOf = str.lastIndexOf(91);
            if (lastIndexOf < 0) {
                addClassWithHierachy(str.substring(1, str.length() - 1));
            } else {
                addClassWithHierachy(str.substring(lastIndexOf + 2, str.length() - 1));
            }
        }
    }

    private void checkPrototype(Prototype prototype) {
        checkDescriptor(prototype.getReturnType().getDescriptor());
        StdTypeList parameterTypes = prototype.getParameterTypes();
        for (int i4 = 0; i4 < parameterTypes.size(); i4++) {
            checkDescriptor(parameterTypes.get(i4).getDescriptor());
        }
    }

    @Deprecated
    public static void main(String[] strArr) {
        MainDexListBuilder.main(strArr);
    }

    public void addRoots(ZipFile zipFile) throws IOException {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String name = entries.nextElement().getName();
            if (name.endsWith(".class")) {
                this.classNames.add(name.substring(0, name.length() - 6));
            }
        }
        Enumeration<? extends ZipEntry> entries2 = zipFile.entries();
        while (entries2.hasMoreElements()) {
            String name2 = entries2.nextElement().getName();
            if (name2.endsWith(".class")) {
                try {
                    addDependencies(this.path.getClass(name2));
                } catch (FileNotFoundException e4) {
                    throw new IOException("Class " + name2 + " is missing form original class path " + this.path, e4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> getClassNames() {
        return this.classNames;
    }
}
