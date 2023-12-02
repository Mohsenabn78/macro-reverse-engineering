package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;

/* loaded from: classes2.dex */
public final class SwitchData extends VariableSizeInsn {
    private final IntList cases;
    private final boolean packed;
    private final CodeAddress[] targets;
    private final CodeAddress user;

    public SwitchData(SourcePosition sourcePosition, CodeAddress codeAddress, IntList intList, CodeAddress[] codeAddressArr) {
        super(sourcePosition, RegisterSpecList.EMPTY);
        if (codeAddress != null) {
            if (intList != null) {
                if (codeAddressArr != null) {
                    int size = intList.size();
                    if (size == codeAddressArr.length) {
                        if (size <= 65535) {
                            this.user = codeAddress;
                            this.cases = intList;
                            this.targets = codeAddressArr;
                            this.packed = shouldPack(intList);
                            return;
                        }
                        throw new IllegalArgumentException("too many cases");
                    }
                    throw new IllegalArgumentException("cases / targets mismatch");
                }
                throw new NullPointerException("targets == null");
            }
            throw new NullPointerException("cases == null");
        }
        throw new NullPointerException("user == null");
    }

    private static long packedCodeSize(IntList intList) {
        long j4 = (((intList.get(intList.size() - 1) - intList.get(0)) + 1) * 2) + 4;
        if (j4 > 2147483647L) {
            return -1L;
        }
        return j4;
    }

    private static boolean shouldPack(IntList intList) {
        if (intList.size() < 2) {
            return true;
        }
        long packedCodeSize = packedCodeSize(intList);
        long sparseCodeSize = sparseCodeSize(intList);
        if (packedCodeSize >= 0 && packedCodeSize <= (sparseCodeSize * 5) / 4) {
            return true;
        }
        return false;
    }

    private static long sparseCodeSize(IntList intList) {
        return (intList.size() * 4) + 2;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String argString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.targets.length;
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(this.cases.get(i4));
            stringBuffer.append(": ");
            stringBuffer.append(this.targets[i4]);
        }
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public int codeSize() {
        long sparseCodeSize;
        if (this.packed) {
            sparseCodeSize = packedCodeSize(this.cases);
        } else {
            sparseCodeSize = sparseCodeSize(this.cases);
        }
        return (int) sparseCodeSize;
    }

    public boolean isPacked() {
        return this.packed;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String listingString0(boolean z3) {
        String str;
        int address = this.user.getAddress();
        StringBuffer stringBuffer = new StringBuffer(100);
        int length = this.targets.length;
        if (this.packed) {
            str = "packed";
        } else {
            str = "sparse";
        }
        stringBuffer.append(str);
        stringBuffer.append("-switch-payload // for switch @ ");
        stringBuffer.append(Hex.u2(address));
        for (int i4 = 0; i4 < length; i4++) {
            int address2 = this.targets[i4].getAddress();
            stringBuffer.append("\n  ");
            stringBuffer.append(this.cases.get(i4));
            stringBuffer.append(": ");
            stringBuffer.append(Hex.u4(address2));
            stringBuffer.append(" // ");
            stringBuffer.append(Hex.s4(address2 - address));
        }
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        return new SwitchData(getPosition(), this.user, this.cases, this.targets);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public void writeTo(AnnotatedOutput annotatedOutput) {
        int i4;
        int i5;
        int address;
        int address2 = this.user.getAddress();
        int codeSize = Dops.PACKED_SWITCH.getFormat().codeSize();
        int length = this.targets.length;
        int i6 = 0;
        if (this.packed) {
            if (length == 0) {
                i4 = 0;
            } else {
                i4 = this.cases.get(0);
            }
            if (length == 0) {
                i5 = 0;
            } else {
                i5 = this.cases.get(length - 1);
            }
            int i7 = (i5 - i4) + 1;
            annotatedOutput.writeShort(256);
            annotatedOutput.writeShort(i7);
            annotatedOutput.writeInt(i4);
            int i8 = 0;
            while (i6 < i7) {
                if (this.cases.get(i8) > i4 + i6) {
                    address = codeSize;
                } else {
                    address = this.targets[i8].getAddress() - address2;
                    i8++;
                }
                annotatedOutput.writeInt(address);
                i6++;
            }
            return;
        }
        annotatedOutput.writeShort(512);
        annotatedOutput.writeShort(length);
        for (int i9 = 0; i9 < length; i9++) {
            annotatedOutput.writeInt(this.cases.get(i9));
        }
        while (i6 < length) {
            annotatedOutput.writeInt(this.targets[i6].getAddress() - address2);
            i6++;
        }
    }
}
