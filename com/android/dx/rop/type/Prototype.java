package com.android.dx.rop.type;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class Prototype implements Comparable<Prototype> {
    private static final HashMap<String, Prototype> internTable = new HashMap<>(500);
    private final String descriptor;
    private StdTypeList parameterFrameTypes;
    private final StdTypeList parameterTypes;
    private final Type returnType;

    private Prototype(String str, Type type, StdTypeList stdTypeList) {
        if (str != null) {
            if (type != null) {
                if (stdTypeList != null) {
                    this.descriptor = str;
                    this.returnType = type;
                    this.parameterTypes = stdTypeList;
                    this.parameterFrameTypes = null;
                    return;
                }
                throw new NullPointerException("parameterTypes == null");
            }
            throw new NullPointerException("returnType == null");
        }
        throw new NullPointerException("descriptor == null");
    }

    public static Prototype intern(String str) {
        Prototype prototype;
        int i4;
        if (str != null) {
            HashMap<String, Prototype> hashMap = internTable;
            synchronized (hashMap) {
                prototype = hashMap.get(str);
            }
            if (prototype != null) {
                return prototype;
            }
            Type[] makeParameterArray = makeParameterArray(str);
            int i5 = 1;
            int i6 = 0;
            while (true) {
                char charAt = str.charAt(i5);
                if (charAt == ')') {
                    Type internReturnType = Type.internReturnType(str.substring(i5 + 1));
                    StdTypeList stdTypeList = new StdTypeList(i6);
                    for (int i7 = 0; i7 < i6; i7++) {
                        stdTypeList.set(i7, makeParameterArray[i7]);
                    }
                    return putIntern(new Prototype(str, internReturnType, stdTypeList));
                }
                int i8 = i5;
                while (charAt == '[') {
                    i8++;
                    charAt = str.charAt(i8);
                }
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, i8);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("bad descriptor");
                    }
                    i4 = indexOf + 1;
                } else {
                    i4 = i8 + 1;
                }
                makeParameterArray[i6] = Type.intern(str.substring(i5, i4));
                i6++;
                i5 = i4;
            }
        } else {
            throw new NullPointerException("descriptor == null");
        }
    }

    public static Prototype internInts(Type type, int i4) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('(');
        for (int i5 = 0; i5 < i4; i5++) {
            stringBuffer.append('I');
        }
        stringBuffer.append(')');
        stringBuffer.append(type.getDescriptor());
        return intern(stringBuffer.toString());
    }

    private static Type[] makeParameterArray(String str) {
        int length = str.length();
        int i4 = 0;
        if (str.charAt(0) == '(') {
            int i5 = 1;
            int i6 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                char charAt = str.charAt(i5);
                if (charAt == ')') {
                    i4 = i5;
                    break;
                }
                if (charAt >= 'A' && charAt <= 'Z') {
                    i6++;
                }
                i5++;
            }
            if (i4 != 0 && i4 != length - 1) {
                if (str.indexOf(41, i4 + 1) == -1) {
                    return new Type[i6];
                }
                throw new IllegalArgumentException("bad descriptor");
            }
            throw new IllegalArgumentException("bad descriptor");
        }
        throw new IllegalArgumentException("bad descriptor");
    }

    private static Prototype putIntern(Prototype prototype) {
        HashMap<String, Prototype> hashMap = internTable;
        synchronized (hashMap) {
            String descriptor = prototype.getDescriptor();
            Prototype prototype2 = hashMap.get(descriptor);
            if (prototype2 != null) {
                return prototype2;
            }
            hashMap.put(descriptor, prototype);
            return prototype;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Prototype)) {
            return false;
        }
        return this.descriptor.equals(((Prototype) obj).descriptor);
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public StdTypeList getParameterFrameTypes() {
        if (this.parameterFrameTypes == null) {
            int size = this.parameterTypes.size();
            StdTypeList stdTypeList = new StdTypeList(size);
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                Type type = this.parameterTypes.get(i4);
                if (type.isIntlike()) {
                    type = Type.INT;
                    z3 = true;
                }
                stdTypeList.set(i4, type);
            }
            if (!z3) {
                stdTypeList = this.parameterTypes;
            }
            this.parameterFrameTypes = stdTypeList;
        }
        return this.parameterFrameTypes;
    }

    public StdTypeList getParameterTypes() {
        return this.parameterTypes;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public String toString() {
        return this.descriptor;
    }

    public Prototype withFirstParameter(Type type) {
        String str = "(" + type.getDescriptor() + this.descriptor.substring(1);
        StdTypeList withFirst = this.parameterTypes.withFirst(type);
        withFirst.setImmutable();
        return putIntern(new Prototype(str, this.returnType, withFirst));
    }

    @Override // java.lang.Comparable
    public int compareTo(Prototype prototype) {
        if (this == prototype) {
            return 0;
        }
        int compareTo = this.returnType.compareTo(prototype.returnType);
        if (compareTo != 0) {
            return compareTo;
        }
        int size = this.parameterTypes.size();
        int size2 = prototype.parameterTypes.size();
        int min = Math.min(size, size2);
        for (int i4 = 0; i4 < min; i4++) {
            int compareTo2 = this.parameterTypes.get(i4).compareTo(prototype.parameterTypes.get(i4));
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        if (size < size2) {
            return -1;
        }
        return size > size2 ? 1 : 0;
    }

    public static Prototype intern(String str, Type type, boolean z3, boolean z4) {
        Prototype intern = intern(str);
        if (z3) {
            return intern;
        }
        if (z4) {
            type = type.asUninitialized(Integer.MAX_VALUE);
        }
        return intern.withFirstParameter(type);
    }
}
