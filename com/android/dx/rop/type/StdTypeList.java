package com.android.dx.rop.type;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class StdTypeList extends FixedSizeList implements TypeList {
    public static final StdTypeList BOOLEANARR_INT;
    public static final StdTypeList BYTEARR_INT;
    public static final StdTypeList CHARARR_INT;
    public static final StdTypeList DOUBLE;
    public static final StdTypeList DOUBLEARR_INT;
    public static final StdTypeList DOUBLE_DOUBLE;
    public static final StdTypeList DOUBLE_DOUBLEARR_INT;
    public static final StdTypeList DOUBLE_OBJECT;
    public static final StdTypeList EMPTY = new StdTypeList(0);
    public static final StdTypeList FLOAT;
    public static final StdTypeList FLOATARR_INT;
    public static final StdTypeList FLOAT_FLOAT;
    public static final StdTypeList FLOAT_FLOATARR_INT;
    public static final StdTypeList FLOAT_OBJECT;
    public static final StdTypeList INT;
    public static final StdTypeList INTARR_INT;
    public static final StdTypeList INT_BOOLEANARR_INT;
    public static final StdTypeList INT_BYTEARR_INT;
    public static final StdTypeList INT_CHARARR_INT;
    public static final StdTypeList INT_INT;
    public static final StdTypeList INT_INTARR_INT;
    public static final StdTypeList INT_OBJECT;
    public static final StdTypeList INT_SHORTARR_INT;
    public static final StdTypeList LONG;
    public static final StdTypeList LONGARR_INT;
    public static final StdTypeList LONG_INT;
    public static final StdTypeList LONG_LONG;
    public static final StdTypeList LONG_LONGARR_INT;
    public static final StdTypeList LONG_OBJECT;
    public static final StdTypeList OBJECT;
    public static final StdTypeList OBJECTARR_INT;
    public static final StdTypeList OBJECT_OBJECT;
    public static final StdTypeList OBJECT_OBJECTARR_INT;
    public static final StdTypeList RETURN_ADDRESS;
    public static final StdTypeList SHORTARR_INT;
    public static final StdTypeList THROWABLE;

    static {
        Type type = Type.INT;
        INT = make(type);
        Type type2 = Type.LONG;
        LONG = make(type2);
        Type type3 = Type.FLOAT;
        FLOAT = make(type3);
        Type type4 = Type.DOUBLE;
        DOUBLE = make(type4);
        Type type5 = Type.OBJECT;
        OBJECT = make(type5);
        RETURN_ADDRESS = make(Type.RETURN_ADDRESS);
        THROWABLE = make(Type.THROWABLE);
        INT_INT = make(type, type);
        LONG_LONG = make(type2, type2);
        FLOAT_FLOAT = make(type3, type3);
        DOUBLE_DOUBLE = make(type4, type4);
        OBJECT_OBJECT = make(type5, type5);
        INT_OBJECT = make(type, type5);
        LONG_OBJECT = make(type2, type5);
        FLOAT_OBJECT = make(type3, type5);
        DOUBLE_OBJECT = make(type4, type5);
        LONG_INT = make(type2, type);
        Type type6 = Type.INT_ARRAY;
        INTARR_INT = make(type6, type);
        Type type7 = Type.LONG_ARRAY;
        LONGARR_INT = make(type7, type);
        Type type8 = Type.FLOAT_ARRAY;
        FLOATARR_INT = make(type8, type);
        Type type9 = Type.DOUBLE_ARRAY;
        DOUBLEARR_INT = make(type9, type);
        Type type10 = Type.OBJECT_ARRAY;
        OBJECTARR_INT = make(type10, type);
        Type type11 = Type.BOOLEAN_ARRAY;
        BOOLEANARR_INT = make(type11, type);
        Type type12 = Type.BYTE_ARRAY;
        BYTEARR_INT = make(type12, type);
        Type type13 = Type.CHAR_ARRAY;
        CHARARR_INT = make(type13, type);
        Type type14 = Type.SHORT_ARRAY;
        SHORTARR_INT = make(type14, type);
        INT_INTARR_INT = make(type, type6, type);
        LONG_LONGARR_INT = make(type2, type7, type);
        FLOAT_FLOATARR_INT = make(type3, type8, type);
        DOUBLE_DOUBLEARR_INT = make(type4, type9, type);
        OBJECT_OBJECTARR_INT = make(type5, type10, type);
        INT_BOOLEANARR_INT = make(type, type11, type);
        INT_BYTEARR_INT = make(type, type12, type);
        INT_CHARARR_INT = make(type, type13, type);
        INT_SHORTARR_INT = make(type, type14, type);
    }

    public StdTypeList(int i4) {
        super(i4);
    }

    public static int compareContents(TypeList typeList, TypeList typeList2) {
        int size = typeList.size();
        int size2 = typeList2.size();
        int min = Math.min(size, size2);
        for (int i4 = 0; i4 < min; i4++) {
            int compareTo = typeList.getType(i4).compareTo(typeList2.getType(i4));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static boolean equalContents(TypeList typeList, TypeList typeList2) {
        int size = typeList.size();
        if (typeList2.size() != size) {
            return false;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (!typeList.getType(i4).equals(typeList2.getType(i4))) {
                return false;
            }
        }
        return true;
    }

    public static int hashContents(TypeList typeList) {
        int size = typeList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = (i4 * 31) + typeList.getType(i5).hashCode();
        }
        return i4;
    }

    public static StdTypeList make(Type type) {
        StdTypeList stdTypeList = new StdTypeList(1);
        stdTypeList.set(0, type);
        return stdTypeList;
    }

    public static String toHuman(TypeList typeList) {
        int size = typeList.size();
        if (size == 0) {
            return "<empty>";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(typeList.getType(i4).toHuman());
        }
        return stringBuffer.toString();
    }

    public Type get(int i4) {
        return (Type) get0(i4);
    }

    @Override // com.android.dx.rop.type.TypeList
    public Type getType(int i4) {
        return get(i4);
    }

    @Override // com.android.dx.rop.type.TypeList
    public int getWordCount() {
        int size = size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += get(i5).getCategory();
        }
        return i4;
    }

    public void set(int i4, Type type) {
        set0(i4, type);
    }

    @Override // com.android.dx.rop.type.TypeList
    public TypeList withAddedType(Type type) {
        int size = size();
        StdTypeList stdTypeList = new StdTypeList(size + 1);
        for (int i4 = 0; i4 < size; i4++) {
            stdTypeList.set0(i4, get0(i4));
        }
        stdTypeList.set(size, type);
        stdTypeList.setImmutable();
        return stdTypeList;
    }

    public StdTypeList withFirst(Type type) {
        int size = size();
        StdTypeList stdTypeList = new StdTypeList(size + 1);
        int i4 = 0;
        stdTypeList.set0(0, type);
        while (i4 < size) {
            int i5 = i4 + 1;
            stdTypeList.set0(i5, getOrNull0(i4));
            i4 = i5;
        }
        return stdTypeList;
    }

    public static StdTypeList make(Type type, Type type2) {
        StdTypeList stdTypeList = new StdTypeList(2);
        stdTypeList.set(0, type);
        stdTypeList.set(1, type2);
        return stdTypeList;
    }

    public static StdTypeList make(Type type, Type type2, Type type3) {
        StdTypeList stdTypeList = new StdTypeList(3);
        stdTypeList.set(0, type);
        stdTypeList.set(1, type2);
        stdTypeList.set(2, type3);
        return stdTypeList;
    }

    public static StdTypeList make(Type type, Type type2, Type type3, Type type4) {
        StdTypeList stdTypeList = new StdTypeList(4);
        stdTypeList.set(0, type);
        stdTypeList.set(1, type2);
        stdTypeList.set(2, type3);
        stdTypeList.set(3, type4);
        return stdTypeList;
    }
}
