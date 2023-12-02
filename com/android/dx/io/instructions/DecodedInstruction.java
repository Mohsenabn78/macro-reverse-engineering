package com.android.dx.io.instructions;

import androidx.core.view.InputDeviceCompat;
import com.android.dex.DexException;
import com.android.dx.io.IndexType;
import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.Opcodes;
import com.android.dx.util.Hex;
import java.io.EOFException;

/* loaded from: classes2.dex */
public abstract class DecodedInstruction {
    private final InstructionCodec format;
    private final int index;
    private final IndexType indexType;
    private final long literal;
    private final int opcode;
    private final int target;

    public DecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4) {
        if (instructionCodec != null) {
            if (Opcodes.isValidShape(i4)) {
                this.format = instructionCodec;
                this.opcode = i4;
                this.index = i5;
                this.indexType = indexType;
                this.target = i6;
                this.literal = j4;
                return;
            }
            throw new IllegalArgumentException("invalid opcode");
        }
        throw new NullPointerException("format == null");
    }

    public static DecodedInstruction decode(CodeInput codeInput) throws EOFException {
        int read = codeInput.read();
        return OpcodeInfo.getFormat(Opcodes.extractOpcodeFromUnit(read)).decode(read, codeInput);
    }

    public static DecodedInstruction[] decodeAll(short[] sArr) {
        DecodedInstruction[] decodedInstructionArr = new DecodedInstruction[sArr.length];
        ShortArrayCodeInput shortArrayCodeInput = new ShortArrayCodeInput(sArr);
        while (shortArrayCodeInput.hasMore()) {
            try {
                decodedInstructionArr[shortArrayCodeInput.cursor()] = decode(shortArrayCodeInput);
            } catch (EOFException e4) {
                throw new DexException(e4);
            }
        }
        return decodedInstructionArr;
    }

    public final void encode(CodeOutput codeOutput) {
        this.format.encode(this, codeOutput);
    }

    public int getA() {
        return 0;
    }

    public final short getAByte() {
        int a4 = getA();
        if ((a4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) a4;
        }
        throw new DexException("Register A out of range: " + Hex.u8(a4));
    }

    public final short getANibble() {
        int a4 = getA();
        if ((a4 & (-16)) == 0) {
            return (short) a4;
        }
        throw new DexException("Register A out of range: " + Hex.u8(a4));
    }

    public final short getAUnit() {
        int a4 = getA();
        if (((-65536) & a4) == 0) {
            return (short) a4;
        }
        throw new DexException("Register A out of range: " + Hex.u8(a4));
    }

    public int getB() {
        return 0;
    }

    public final short getBByte() {
        int b4 = getB();
        if ((b4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) b4;
        }
        throw new DexException("Register B out of range: " + Hex.u8(b4));
    }

    public final short getBNibble() {
        int b4 = getB();
        if ((b4 & (-16)) == 0) {
            return (short) b4;
        }
        throw new DexException("Register B out of range: " + Hex.u8(b4));
    }

    public final short getBUnit() {
        int b4 = getB();
        if (((-65536) & b4) == 0) {
            return (short) b4;
        }
        throw new DexException("Register B out of range: " + Hex.u8(b4));
    }

    public int getC() {
        return 0;
    }

    public final short getCByte() {
        int c4 = getC();
        if ((c4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) c4;
        }
        throw new DexException("Register C out of range: " + Hex.u8(c4));
    }

    public final short getCNibble() {
        int c4 = getC();
        if ((c4 & (-16)) == 0) {
            return (short) c4;
        }
        throw new DexException("Register C out of range: " + Hex.u8(c4));
    }

    public final short getCUnit() {
        int c4 = getC();
        if (((-65536) & c4) == 0) {
            return (short) c4;
        }
        throw new DexException("Register C out of range: " + Hex.u8(c4));
    }

    public int getD() {
        return 0;
    }

    public final short getDByte() {
        int d4 = getD();
        if ((d4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) d4;
        }
        throw new DexException("Register D out of range: " + Hex.u8(d4));
    }

    public final short getDNibble() {
        int d4 = getD();
        if ((d4 & (-16)) == 0) {
            return (short) d4;
        }
        throw new DexException("Register D out of range: " + Hex.u8(d4));
    }

    public final short getDUnit() {
        int d4 = getD();
        if (((-65536) & d4) == 0) {
            return (short) d4;
        }
        throw new DexException("Register D out of range: " + Hex.u8(d4));
    }

    public int getE() {
        return 0;
    }

    public final short getENibble() {
        int e4 = getE();
        if ((e4 & (-16)) == 0) {
            return (short) e4;
        }
        throw new DexException("Register E out of range: " + Hex.u8(e4));
    }

    public final InstructionCodec getFormat() {
        return this.format;
    }

    public final int getIndex() {
        return this.index;
    }

    public final IndexType getIndexType() {
        return this.indexType;
    }

    public final short getIndexUnit() {
        return (short) this.index;
    }

    public final long getLiteral() {
        return this.literal;
    }

    public final int getLiteralByte() {
        long j4 = this.literal;
        if (j4 == ((byte) j4)) {
            return ((int) j4) & 255;
        }
        throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }

    public final int getLiteralInt() {
        long j4 = this.literal;
        if (j4 == ((int) j4)) {
            return (int) j4;
        }
        throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }

    public final int getLiteralNibble() {
        long j4 = this.literal;
        if (j4 >= -8 && j4 <= 7) {
            return ((int) j4) & 15;
        }
        throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }

    public final short getLiteralUnit() {
        long j4 = this.literal;
        if (j4 == ((short) j4)) {
            return (short) j4;
        }
        throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }

    public final int getOpcode() {
        return this.opcode;
    }

    public final short getOpcodeUnit() {
        return (short) this.opcode;
    }

    public abstract int getRegisterCount();

    public final short getRegisterCountUnit() {
        int registerCount = getRegisterCount();
        if (((-65536) & registerCount) == 0) {
            return (short) registerCount;
        }
        throw new DexException("Register count out of range: " + Hex.u8(registerCount));
    }

    public final int getTarget() {
        return this.target;
    }

    public final int getTargetByte(int i4) {
        int target = getTarget(i4);
        if (target == ((byte) target)) {
            return target & 255;
        }
        throw new DexException("Target out of range: " + Hex.s4(target));
    }

    public final short getTargetUnit(int i4) {
        int target = getTarget(i4);
        short s3 = (short) target;
        if (target == s3) {
            return s3;
        }
        throw new DexException("Target out of range: " + Hex.s4(target));
    }

    public abstract DecodedInstruction withIndex(int i4);

    public final int getTarget(int i4) {
        return this.target - i4;
    }
}
