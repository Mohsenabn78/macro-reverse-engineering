package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class CstType extends TypedConstant {
    private CstString descriptor;
    private final Type type;
    private static final HashMap<Type, CstType> interns = new HashMap<>(100);
    public static final CstType OBJECT = intern(Type.OBJECT);
    public static final CstType BOOLEAN = intern(Type.BOOLEAN_CLASS);
    public static final CstType BYTE = intern(Type.BYTE_CLASS);
    public static final CstType CHARACTER = intern(Type.CHARACTER_CLASS);
    public static final CstType DOUBLE = intern(Type.DOUBLE_CLASS);
    public static final CstType FLOAT = intern(Type.FLOAT_CLASS);
    public static final CstType LONG = intern(Type.LONG_CLASS);
    public static final CstType INTEGER = intern(Type.INTEGER_CLASS);
    public static final CstType SHORT = intern(Type.SHORT_CLASS);
    public static final CstType VOID = intern(Type.VOID_CLASS);
    public static final CstType BOOLEAN_ARRAY = intern(Type.BOOLEAN_ARRAY);
    public static final CstType BYTE_ARRAY = intern(Type.BYTE_ARRAY);
    public static final CstType CHAR_ARRAY = intern(Type.CHAR_ARRAY);
    public static final CstType DOUBLE_ARRAY = intern(Type.DOUBLE_ARRAY);
    public static final CstType FLOAT_ARRAY = intern(Type.FLOAT_ARRAY);
    public static final CstType LONG_ARRAY = intern(Type.LONG_ARRAY);
    public static final CstType INT_ARRAY = intern(Type.INT_ARRAY);
    public static final CstType SHORT_ARRAY = intern(Type.SHORT_ARRAY);

    public CstType(Type type) {
        if (type != null) {
            if (type != Type.KNOWN_NULL) {
                this.type = type;
                this.descriptor = null;
                return;
            }
            throw new UnsupportedOperationException("KNOWN_NULL is not representable");
        }
        throw new NullPointerException("type == null");
    }

    public static CstType forBoxedPrimitiveType(Type type) {
        switch (type.getBasicType()) {
            case 0:
                return VOID;
            case 1:
                return BOOLEAN;
            case 2:
                return BYTE;
            case 3:
                return CHARACTER;
            case 4:
                return DOUBLE;
            case 5:
                return FLOAT;
            case 6:
                return INTEGER;
            case 7:
                return LONG;
            case 8:
                return SHORT;
            default:
                throw new IllegalArgumentException("not primitive: " + type);
        }
    }

    public static CstType intern(Type type) {
        CstType cstType;
        HashMap<Type, CstType> hashMap = interns;
        synchronized (hashMap) {
            cstType = hashMap.get(type);
            if (cstType == null) {
                cstType = new CstType(type);
                hashMap.put(type, cstType);
            }
        }
        return cstType;
    }

    @Override // com.android.dx.rop.cst.Constant
    protected int compareTo0(Constant constant) {
        return this.type.getDescriptor().compareTo(((CstType) constant).type.getDescriptor());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CstType) || this.type != ((CstType) obj).type) {
            return false;
        }
        return true;
    }

    public Type getClassType() {
        return this.type;
    }

    public CstString getDescriptor() {
        if (this.descriptor == null) {
            this.descriptor = new CstString(this.type.getDescriptor());
        }
        return this.descriptor;
    }

    public String getPackageName() {
        String string = getDescriptor().getString();
        int lastIndexOf = string.lastIndexOf(47);
        int lastIndexOf2 = string.lastIndexOf(91);
        if (lastIndexOf == -1) {
            return "default";
        }
        return string.substring(lastIndexOf2 + 2, lastIndexOf).replace('/', '.');
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.CLASS;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.type.toHuman();
    }

    public String toString() {
        return "type{" + toHuman() + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "type";
    }
}
