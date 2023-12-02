package com.android.dx.cf.direct;

import com.android.dx.cf.code.ByteOps;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.SwitchList;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class CodeObserver implements BytecodeArray.Visitor {
    private final ByteArray bytes;
    private final ParseObserver observer;

    public CodeObserver(ByteArray byteArray, ParseObserver parseObserver) {
        if (byteArray != null) {
            if (parseObserver != null) {
                this.bytes = byteArray;
                this.observer = parseObserver;
                return;
            }
            throw new NullPointerException("observer == null");
        }
        throw new NullPointerException("bytes == null");
    }

    private String header(int i4) {
        int unsignedByte = this.bytes.getUnsignedByte(i4);
        String opName = ByteOps.opName(unsignedByte);
        if (unsignedByte == 196) {
            int unsignedByte2 = this.bytes.getUnsignedByte(i4 + 1);
            opName = opName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ByteOps.opName(unsignedByte2);
        }
        return Hex.u2(i4) + ": " + opName;
    }

    private void visitLiteralDouble(int i4, int i5, int i6, long j4) {
        String str;
        if (i6 != 1) {
            str = " #" + Hex.u8(j4);
        } else {
            str = "";
        }
        this.observer.parsed(this.bytes, i5, i6, header(i5) + str + " // " + Double.longBitsToDouble(j4));
    }

    private void visitLiteralFloat(int i4, int i5, int i6, int i7) {
        String str;
        if (i6 != 1) {
            str = " #" + Hex.u4(i7);
        } else {
            str = "";
        }
        this.observer.parsed(this.bytes, i5, i6, header(i5) + str + " // " + Float.intBitsToFloat(i7));
    }

    private void visitLiteralInt(int i4, int i5, int i6, int i7) {
        String str;
        String str2;
        if (i6 == 1) {
            str = " // ";
        } else {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        int unsignedByte = this.bytes.getUnsignedByte(i5);
        if (i6 != 1 && unsignedByte != 16) {
            if (unsignedByte == 17) {
                str2 = "#" + Hex.s2(i7);
            } else {
                str2 = "#" + Hex.s4(i7);
            }
        } else {
            str2 = "#" + Hex.s1(i7);
        }
        this.observer.parsed(this.bytes, i5, i6, header(i5) + str + str2);
    }

    private void visitLiteralLong(int i4, int i5, int i6, long j4) {
        String str;
        String s8;
        if (i6 == 1) {
            str = " // ";
        } else {
            str = " #";
        }
        if (i6 == 1) {
            s8 = Hex.s1((int) j4);
        } else {
            s8 = Hex.s8(j4);
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        parseObserver.parsed(byteArray, i5, i6, header(i5) + str + s8);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public int getPreviousOffset() {
        return -1;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitBranch(int i4, int i5, int i6, int i7) {
        String u4;
        if (i6 <= 3) {
            u4 = Hex.u2(i7);
        } else {
            u4 = Hex.u4(i7);
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        parseObserver.parsed(byteArray, i5, i6, header(i5) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + u4);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitConstant(int i4, int i5, int i6, Constant constant, int i7) {
        String str;
        if (constant instanceof CstKnownNull) {
            visitNoArgs(i4, i5, i6, null);
        } else if (constant instanceof CstInteger) {
            visitLiteralInt(i4, i5, i6, i7);
        } else if (constant instanceof CstLong) {
            visitLiteralLong(i4, i5, i6, ((CstLong) constant).getValue());
        } else if (constant instanceof CstFloat) {
            visitLiteralFloat(i4, i5, i6, ((CstFloat) constant).getIntBits());
        } else if (constant instanceof CstDouble) {
            visitLiteralDouble(i4, i5, i6, ((CstDouble) constant).getLongBits());
        } else {
            if (i7 != 0) {
                if (i4 == 197) {
                    str = ", " + Hex.u1(i7);
                } else {
                    str = ", " + Hex.u2(i7);
                }
            } else {
                str = "";
            }
            this.observer.parsed(this.bytes, i5, i6, header(i5) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + constant + str);
        }
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitInvalid(int i4, int i5, int i6) {
        this.observer.parsed(this.bytes, i5, i6, header(i5));
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8) {
        String u22;
        String str;
        String str2;
        String str3;
        String s22;
        if (i6 <= 3) {
            u22 = Hex.u1(i7);
        } else {
            u22 = Hex.u2(i7);
        }
        boolean z3 = true;
        if (i6 != 1) {
            z3 = false;
        }
        String str4 = "";
        if (i4 != 132) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(", #");
            if (i6 <= 3) {
                s22 = Hex.s1(i8);
            } else {
                s22 = Hex.s2(i8);
            }
            sb.append(s22);
            str = sb.toString();
        }
        if (type.isCategory2()) {
            StringBuilder sb2 = new StringBuilder();
            if (z3) {
                str3 = ",";
            } else {
                str3 = " //";
            }
            sb2.append(str3);
            sb2.append(" category-2");
            str4 = sb2.toString();
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(header(i5));
        if (z3) {
            str2 = " // ";
        } else {
            str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        sb3.append(str2);
        sb3.append(u22);
        sb3.append(str);
        sb3.append(str4);
        parseObserver.parsed(byteArray, i5, i6, sb3.toString());
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList) {
        String str;
        if (i5 == 1) {
            str = " // ";
        } else {
            str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        String human = cstType.getClassType().getComponentType().toHuman();
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        parseObserver.parsed(byteArray, i4, i5, header(i4) + str + human);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNoArgs(int i4, int i5, int i6, Type type) {
        this.observer.parsed(this.bytes, i5, i6, header(i5));
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7) {
        int size = switchList.size();
        StringBuffer stringBuffer = new StringBuffer((size * 20) + 100);
        stringBuffer.append(header(i5));
        if (i7 != 0) {
            stringBuffer.append(" // padding: " + Hex.u4(i7));
        }
        stringBuffer.append('\n');
        for (int i8 = 0; i8 < size; i8++) {
            stringBuffer.append("  ");
            stringBuffer.append(Hex.s4(switchList.getValue(i8)));
            stringBuffer.append(": ");
            stringBuffer.append(Hex.u2(switchList.getTarget(i8)));
            stringBuffer.append('\n');
        }
        stringBuffer.append("  default: ");
        stringBuffer.append(Hex.u2(switchList.getDefaultTarget()));
        this.observer.parsed(this.bytes, i5, i6, stringBuffer.toString());
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void setPreviousOffset(int i4) {
    }
}
