package com.android.dx.rop.type;

import androidx.exifinterface.media.ExifInterface;
import com.android.dx.util.Hex;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class Type implements TypeBearer, Comparable<Type> {
    public static final Type ANNOTATION;
    public static final Type BOOLEAN;
    public static final Type BOOLEAN_ARRAY;
    public static final Type BOOLEAN_CLASS;
    public static final int BT_ADDR = 10;
    public static final int BT_BOOLEAN = 1;
    public static final int BT_BYTE = 2;
    public static final int BT_CHAR = 3;
    public static final int BT_COUNT = 11;
    public static final int BT_DOUBLE = 4;
    public static final int BT_FLOAT = 5;
    public static final int BT_INT = 6;
    public static final int BT_LONG = 7;
    public static final int BT_OBJECT = 9;
    public static final int BT_SHORT = 8;
    public static final int BT_VOID = 0;
    public static final Type BYTE;
    public static final Type BYTE_ARRAY;
    public static final Type BYTE_CLASS;
    public static final Type CHAR;
    public static final Type CHARACTER_CLASS;
    public static final Type CHAR_ARRAY;
    public static final Type CLASS;
    public static final Type CLONEABLE;
    public static final Type DOUBLE;
    public static final Type DOUBLE_ARRAY;
    public static final Type DOUBLE_CLASS;
    public static final Type FLOAT;
    public static final Type FLOAT_ARRAY;
    public static final Type FLOAT_CLASS;
    public static final Type INT;
    public static final Type INTEGER_CLASS;
    public static final Type INT_ARRAY;
    public static final Type KNOWN_NULL;
    public static final Type LONG;
    public static final Type LONG_ARRAY;
    public static final Type LONG_CLASS;
    public static final Type OBJECT;
    public static final Type OBJECT_ARRAY;
    public static final Type RETURN_ADDRESS;
    public static final Type SERIALIZABLE;
    public static final Type SHORT;
    public static final Type SHORT_ARRAY;
    public static final Type SHORT_CLASS;
    public static final Type STRING;
    public static final Type THROWABLE;
    public static final Type VOID;
    public static final Type VOID_CLASS;
    private static final HashMap<String, Type> internTable = new HashMap<>(500);
    private Type arrayType;
    private final int basicType;
    private String className;
    private Type componentType;
    private final String descriptor;
    private Type initializedType;
    private final int newAt;

    static {
        Type type = new Type("Z", 1);
        BOOLEAN = type;
        Type type2 = new Type("B", 2);
        BYTE = type2;
        Type type3 = new Type("C", 3);
        CHAR = type3;
        Type type4 = new Type("D", 4);
        DOUBLE = type4;
        Type type5 = new Type("F", 5);
        FLOAT = type5;
        Type type6 = new Type("I", 6);
        INT = type6;
        Type type7 = new Type("J", 7);
        LONG = type7;
        Type type8 = new Type(ExifInterface.LATITUDE_SOUTH, 8);
        SHORT = type8;
        VOID = new Type(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 0);
        KNOWN_NULL = new Type("<null>", 9);
        RETURN_ADDRESS = new Type("<addr>", 10);
        putIntern(type);
        putIntern(type2);
        putIntern(type3);
        putIntern(type4);
        putIntern(type5);
        putIntern(type6);
        putIntern(type7);
        putIntern(type8);
        ANNOTATION = intern("Ljava/lang/annotation/Annotation;");
        CLASS = intern("Ljava/lang/Class;");
        CLONEABLE = intern("Ljava/lang/Cloneable;");
        Type intern = intern(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        OBJECT = intern;
        SERIALIZABLE = intern("Ljava/io/Serializable;");
        STRING = intern("Ljava/lang/String;");
        THROWABLE = intern("Ljava/lang/Throwable;");
        BOOLEAN_CLASS = intern("Ljava/lang/Boolean;");
        BYTE_CLASS = intern("Ljava/lang/Byte;");
        CHARACTER_CLASS = intern("Ljava/lang/Character;");
        DOUBLE_CLASS = intern("Ljava/lang/Double;");
        FLOAT_CLASS = intern("Ljava/lang/Float;");
        INTEGER_CLASS = intern("Ljava/lang/Integer;");
        LONG_CLASS = intern("Ljava/lang/Long;");
        SHORT_CLASS = intern("Ljava/lang/Short;");
        VOID_CLASS = intern("Ljava/lang/Void;");
        BOOLEAN_ARRAY = type.getArrayType();
        BYTE_ARRAY = type2.getArrayType();
        CHAR_ARRAY = type3.getArrayType();
        DOUBLE_ARRAY = type4.getArrayType();
        FLOAT_ARRAY = type5.getArrayType();
        INT_ARRAY = type6.getArrayType();
        LONG_ARRAY = type7.getArrayType();
        OBJECT_ARRAY = intern.getArrayType();
        SHORT_ARRAY = type8.getArrayType();
    }

    private Type(String str, int i4, int i5) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (i4 < 0 || i4 >= 11) {
            throw new IllegalArgumentException("bad basicType");
        }
        if (i5 >= -1) {
            this.descriptor = str;
            this.basicType = i4;
            this.newAt = i5;
            this.arrayType = null;
            this.componentType = null;
            this.initializedType = null;
            return;
        }
        throw new IllegalArgumentException("newAt < -1");
    }

    public static Type intern(String str) {
        Type type;
        HashMap<String, Type> hashMap = internTable;
        synchronized (hashMap) {
            type = hashMap.get(str);
        }
        if (type != null) {
            return type;
        }
        try {
            char charAt = str.charAt(0);
            if (charAt == '[') {
                return intern(str.substring(1)).getArrayType();
            }
            int length = str.length();
            if (charAt == 'L') {
                int i4 = length - 1;
                if (str.charAt(i4) == ';') {
                    for (int i5 = 1; i5 < i4; i5++) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 != '(' && charAt2 != ')' && charAt2 != '.') {
                            if (charAt2 != '/') {
                                if (charAt2 != ';' && charAt2 != '[') {
                                }
                            } else if (i5 == 1 || i5 == i4 || str.charAt(i5 - 1) == '/') {
                                throw new IllegalArgumentException("bad descriptor: " + str);
                            }
                        }
                        throw new IllegalArgumentException("bad descriptor: " + str);
                    }
                    return putIntern(new Type(str, 9));
                }
            }
            throw new IllegalArgumentException("bad descriptor: " + str);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("descriptor is empty");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("descriptor == null");
        }
    }

    public static Type internClassName(String str) {
        if (str != null) {
            if (str.startsWith("[")) {
                return intern(str);
            }
            return intern('L' + str + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        }
        throw new NullPointerException("name == null");
    }

    public static Type internReturnType(String str) {
        try {
            if (str.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                return VOID;
            }
            return intern(str);
        } catch (NullPointerException unused) {
            throw new NullPointerException("descriptor == null");
        }
    }

    private static Type putIntern(Type type) {
        HashMap<String, Type> hashMap = internTable;
        synchronized (hashMap) {
            String descriptor = type.getDescriptor();
            Type type2 = hashMap.get(descriptor);
            if (type2 != null) {
                return type2;
            }
            hashMap.put(descriptor, type);
            return type;
        }
    }

    public Type asUninitialized(int i4) {
        if (i4 >= 0) {
            if (isReference()) {
                if (!isUninitialized()) {
                    Type type = new Type('N' + Hex.u2(i4) + this.descriptor, 9, i4);
                    type.initializedType = this;
                    return putIntern(type);
                }
                throw new IllegalArgumentException("already uninitialized: " + this.descriptor);
            }
            throw new IllegalArgumentException("not a reference type: " + this.descriptor);
        }
        throw new IllegalArgumentException("newAt < 0");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        return this.descriptor.equals(((Type) obj).descriptor);
    }

    public Type getArrayType() {
        if (this.arrayType == null) {
            this.arrayType = putIntern(new Type(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + this.descriptor, 9));
        }
        return this.arrayType;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public int getBasicFrameType() {
        int i4 = this.basicType;
        if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 6 || i4 == 8) {
            return 6;
        }
        return i4;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public int getBasicType() {
        return this.basicType;
    }

    public int getCategory() {
        int i4 = this.basicType;
        if (i4 != 4 && i4 != 7) {
            return 1;
        }
        return 2;
    }

    public String getClassName() {
        if (this.className == null) {
            if (isReference()) {
                if (this.descriptor.charAt(0) == '[') {
                    this.className = this.descriptor;
                } else {
                    String str = this.descriptor;
                    this.className = str.substring(1, str.length() - 1);
                }
            } else {
                throw new IllegalArgumentException("not an object type: " + this.descriptor);
            }
        }
        return this.className;
    }

    public Type getComponentType() {
        if (this.componentType == null) {
            if (this.descriptor.charAt(0) == '[') {
                this.componentType = intern(this.descriptor.substring(1));
            } else {
                throw new IllegalArgumentException("not an array type: " + this.descriptor);
            }
        }
        return this.componentType;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public Type getInitializedType() {
        Type type = this.initializedType;
        if (type != null) {
            return type;
        }
        throw new IllegalArgumentException("initialized type: " + this.descriptor);
    }

    public int getNewAt() {
        return this.newAt;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public boolean isArray() {
        if (this.descriptor.charAt(0) != '[') {
            return false;
        }
        return true;
    }

    public boolean isArrayOrKnownNull() {
        if (!isArray() && !equals(KNOWN_NULL)) {
            return false;
        }
        return true;
    }

    public boolean isCategory1() {
        int i4 = this.basicType;
        if (i4 != 4 && i4 != 7) {
            return true;
        }
        return false;
    }

    public boolean isCategory2() {
        int i4 = this.basicType;
        if (i4 != 4 && i4 != 7) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public boolean isConstant() {
        return false;
    }

    public boolean isIntlike() {
        int i4 = this.basicType;
        if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 6 || i4 == 8) {
            return true;
        }
        return false;
    }

    public boolean isPrimitive() {
        switch (this.basicType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public boolean isReference() {
        if (this.basicType == 9) {
            return true;
        }
        return false;
    }

    public boolean isUninitialized() {
        if (this.newAt >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        switch (this.basicType) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "byte";
            case 3:
                return "char";
            case 4:
                return "double";
            case 5:
                return "float";
            case 6:
                return HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT;
            case 7:
                return HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG;
            case 8:
                return "short";
            case 9:
                if (isArray()) {
                    return getComponentType().toHuman() + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
                return getClassName().replace(RemoteSettings.FORWARD_SLASH_STRING, ".");
            default:
                return this.descriptor;
        }
    }

    public String toString() {
        return this.descriptor;
    }

    @Override // java.lang.Comparable
    public int compareTo(Type type) {
        return this.descriptor.compareTo(type.descriptor);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getFrameType() {
        int i4 = this.basicType;
        return (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 6 || i4 == 8) ? INT : this;
    }

    private Type(String str, int i4) {
        this(str, i4, -1);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return this;
    }
}
