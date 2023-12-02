package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Hex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public final class Rop {
    public static final int BRANCH_GOTO = 3;
    public static final int BRANCH_IF = 4;
    public static final int BRANCH_MAX = 6;
    public static final int BRANCH_MIN = 1;
    public static final int BRANCH_NONE = 1;
    public static final int BRANCH_RETURN = 2;
    public static final int BRANCH_SWITCH = 5;
    public static final int BRANCH_THROW = 6;
    private final int branchingness;
    private final TypeList exceptions;
    private final boolean isCallLike;
    private final String nickname;
    private final int opcode;
    private final Type result;
    private final TypeList sources;

    public Rop(int i4, Type type, TypeList typeList, TypeList typeList2, int i5, boolean z3, String str) {
        if (type == null) {
            throw new NullPointerException("result == null");
        }
        if (typeList == null) {
            throw new NullPointerException("sources == null");
        }
        if (typeList2 == null) {
            throw new NullPointerException("exceptions == null");
        }
        if (i5 >= 1 && i5 <= 6) {
            if (typeList2.size() != 0 && i5 != 6) {
                throw new IllegalArgumentException("exceptions / branchingness mismatch");
            }
            this.opcode = i4;
            this.result = type;
            this.sources = typeList;
            this.exceptions = typeList2;
            this.branchingness = i5;
            this.isCallLike = z3;
            this.nickname = str;
            return;
        }
        throw new IllegalArgumentException("bogus branchingness");
    }

    public final boolean canThrow() {
        if (this.exceptions.size() != 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rop)) {
            return false;
        }
        Rop rop = (Rop) obj;
        if (this.opcode == rop.opcode && this.branchingness == rop.branchingness && this.result == rop.result && this.sources.equals(rop.sources) && this.exceptions.equals(rop.exceptions)) {
            return true;
        }
        return false;
    }

    public int getBranchingness() {
        return this.branchingness;
    }

    public TypeList getExceptions() {
        return this.exceptions;
    }

    public String getNickname() {
        String str = this.nickname;
        if (str != null) {
            return str;
        }
        return toString();
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Type getResult() {
        return this.result;
    }

    public TypeList getSources() {
        return this.sources;
    }

    public int hashCode() {
        return (((((((this.opcode * 31) + this.branchingness) * 31) + this.result.hashCode()) * 31) + this.sources.hashCode()) * 31) + this.exceptions.hashCode();
    }

    public boolean isCallLike() {
        return this.isCallLike;
    }

    public boolean isCommutative() {
        int i4 = this.opcode;
        if (i4 == 14 || i4 == 16) {
            return true;
        }
        switch (i4) {
            case 20:
            case 21:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("Rop{");
        stringBuffer.append(RegOps.opName(this.opcode));
        if (this.result != Type.VOID) {
            stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuffer.append(this.result);
        } else {
            stringBuffer.append(" .");
        }
        stringBuffer.append(" <-");
        int size = this.sources.size();
        if (size == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i4 = 0; i4 < size; i4++) {
                stringBuffer.append(' ');
                stringBuffer.append(this.sources.getType(i4));
            }
        }
        if (this.isCallLike) {
            stringBuffer.append(" call");
        }
        int size2 = this.exceptions.size();
        if (size2 != 0) {
            stringBuffer.append(" throws");
            for (int i5 = 0; i5 < size2; i5++) {
                stringBuffer.append(' ');
                if (this.exceptions.getType(i5) == Type.THROWABLE) {
                    stringBuffer.append("<any>");
                } else {
                    stringBuffer.append(this.exceptions.getType(i5));
                }
            }
        } else {
            int i6 = this.branchingness;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 != 5) {
                                stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Hex.u1(this.branchingness));
                            } else {
                                stringBuffer.append(" switches");
                            }
                        } else {
                            stringBuffer.append(" ifs");
                        }
                    } else {
                        stringBuffer.append(" gotos");
                    }
                } else {
                    stringBuffer.append(" returns");
                }
            } else {
                stringBuffer.append(" flows");
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public Rop(int i4, Type type, TypeList typeList, TypeList typeList2, int i5, String str) {
        this(i4, type, typeList, typeList2, i5, false, str);
    }

    public Rop(int i4, Type type, TypeList typeList, int i5, String str) {
        this(i4, type, typeList, StdTypeList.EMPTY, i5, false, str);
    }

    public Rop(int i4, Type type, TypeList typeList, String str) {
        this(i4, type, typeList, StdTypeList.EMPTY, 1, false, str);
    }

    public Rop(int i4, Type type, TypeList typeList, TypeList typeList2, String str) {
        this(i4, type, typeList, typeList2, 6, false, str);
    }

    public Rop(int i4, TypeList typeList, TypeList typeList2) {
        this(i4, Type.VOID, typeList, typeList2, 6, true, null);
    }
}
