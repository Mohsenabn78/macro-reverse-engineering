package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstLiteral32;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ArrayData extends VariableSizeInsn {
    private final Constant arrayType;
    private final int elemWidth;
    private final int initLength;
    private final CodeAddress user;
    private final ArrayList<Constant> values;

    public ArrayData(SourcePosition sourcePosition, CodeAddress codeAddress, ArrayList<Constant> arrayList, Constant constant) {
        super(sourcePosition, RegisterSpecList.EMPTY);
        if (codeAddress != null) {
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    this.arrayType = constant;
                    if (constant != CstType.BYTE_ARRAY && constant != CstType.BOOLEAN_ARRAY) {
                        if (constant != CstType.SHORT_ARRAY && constant != CstType.CHAR_ARRAY) {
                            if (constant != CstType.INT_ARRAY && constant != CstType.FLOAT_ARRAY) {
                                if (constant != CstType.LONG_ARRAY && constant != CstType.DOUBLE_ARRAY) {
                                    throw new IllegalArgumentException("Unexpected constant type");
                                }
                                this.elemWidth = 8;
                            } else {
                                this.elemWidth = 4;
                            }
                        } else {
                            this.elemWidth = 2;
                        }
                    } else {
                        this.elemWidth = 1;
                    }
                    this.user = codeAddress;
                    this.values = arrayList;
                    this.initLength = arrayList.size();
                    return;
                }
                throw new IllegalArgumentException("Illegal number of init values");
            }
            throw new NullPointerException("values == null");
        }
        throw new NullPointerException("user == null");
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String argString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.values.size();
        for (int i4 = 0; i4 < size; i4++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(i4);
            stringBuffer.append(": ");
            stringBuffer.append(this.values.get(i4).toHuman());
        }
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public int codeSize() {
        return (((this.initLength * this.elemWidth) + 1) / 2) + 4;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String listingString0(boolean z3) {
        int address = this.user.getAddress();
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.values.size();
        stringBuffer.append("fill-array-data-payload // for fill-array-data @ ");
        stringBuffer.append(Hex.u2(address));
        for (int i4 = 0; i4 < size; i4++) {
            stringBuffer.append("\n  ");
            stringBuffer.append(i4);
            stringBuffer.append(": ");
            stringBuffer.append(this.values.get(i4).toHuman());
        }
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        return new ArrayData(getPosition(), this.user, this.values, this.arrayType);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public void writeTo(AnnotatedOutput annotatedOutput) {
        int size = this.values.size();
        annotatedOutput.writeShort(768);
        annotatedOutput.writeShort(this.elemWidth);
        annotatedOutput.writeInt(this.initLength);
        int i4 = this.elemWidth;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 == 8) {
                        for (int i5 = 0; i5 < size; i5++) {
                            annotatedOutput.writeLong(((CstLiteral64) this.values.get(i5)).getLongBits());
                        }
                    }
                } else {
                    for (int i6 = 0; i6 < size; i6++) {
                        annotatedOutput.writeInt(((CstLiteral32) this.values.get(i6)).getIntBits());
                    }
                }
            } else {
                for (int i7 = 0; i7 < size; i7++) {
                    annotatedOutput.writeShort((short) ((CstLiteral32) this.values.get(i7)).getIntBits());
                }
            }
        } else {
            for (int i8 = 0; i8 < size; i8++) {
                annotatedOutput.writeByte((byte) ((CstLiteral32) this.values.get(i8)).getIntBits());
            }
        }
        if (this.elemWidth == 1 && size % 2 != 0) {
            annotatedOutput.writeByte(0);
        }
    }
}
