package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.BitSet;

/* loaded from: classes2.dex */
public abstract class InsnFormat {
    public static boolean ALLOW_EXTENDED_OPCODES = true;

    protected static int argIndex(DalvInsn dalvInsn) {
        int value = ((CstInteger) ((CstInsn) dalvInsn).getConstant()).getValue();
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException("bogus insn");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String branchComment(DalvInsn dalvInsn) {
        int targetOffset = ((TargetInsn) dalvInsn).getTargetOffset();
        if (targetOffset == ((short) targetOffset)) {
            return Hex.s2(targetOffset);
        }
        return Hex.s4(targetOffset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String branchString(DalvInsn dalvInsn) {
        int targetAddress = ((TargetInsn) dalvInsn).getTargetAddress();
        if (targetAddress == ((char) targetAddress)) {
            return Hex.u2(targetAddress);
        }
        return Hex.u4(targetAddress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static short codeUnit(int i4, int i5) {
        if ((i4 & 255) == i4) {
            if ((i5 & 255) == i5) {
                return (short) (i4 | (i5 << 8));
            }
            throw new IllegalArgumentException("high out of range 0..255");
        }
        throw new IllegalArgumentException("low out of range 0..255");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cstComment(DalvInsn dalvInsn) {
        CstInsn cstInsn = (CstInsn) dalvInsn;
        if (!cstInsn.hasIndex()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(20);
        int index = cstInsn.getIndex();
        sb.append(cstInsn.getConstant().typeName());
        sb.append('@');
        if (index < 65536) {
            sb.append(Hex.u2(index));
        } else {
            sb.append(Hex.u4(index));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String cstString(DalvInsn dalvInsn) {
        Constant constant = ((CstInsn) dalvInsn).getConstant();
        if (constant instanceof CstString) {
            return ((CstString) constant).toQuoted();
        }
        return constant.toHuman();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isRegListSequential(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        if (size < 2) {
            return true;
        }
        int reg = registerSpecList.get(0).getReg();
        for (int i4 = 0; i4 < size; i4++) {
            RegisterSpec registerSpec = registerSpecList.get(i4);
            if (registerSpec.getReg() != reg) {
                return false;
            }
            reg += registerSpec.getCategory();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String literalBitsComment(CstLiteralBits cstLiteralBits, int i4) {
        long intBits;
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("#");
        if (cstLiteralBits instanceof CstLiteral64) {
            intBits = ((CstLiteral64) cstLiteralBits).getLongBits();
        } else {
            intBits = cstLiteralBits.getIntBits();
        }
        if (i4 != 4) {
            if (i4 != 8) {
                if (i4 != 16) {
                    if (i4 != 32) {
                        if (i4 == 64) {
                            stringBuffer.append(Hex.u8(intBits));
                        } else {
                            throw new RuntimeException("shouldn't happen");
                        }
                    } else {
                        stringBuffer.append(Hex.u4((int) intBits));
                    }
                } else {
                    stringBuffer.append(Hex.u2((int) intBits));
                }
            } else {
                stringBuffer.append(Hex.u1((int) intBits));
            }
        } else {
            stringBuffer.append(Hex.uNibble((int) intBits));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String literalBitsString(CstLiteralBits cstLiteralBits) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('#');
        if (cstLiteralBits instanceof CstKnownNull) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(cstLiteralBits.typeName());
            stringBuffer.append(' ');
            stringBuffer.append(cstLiteralBits.toHuman());
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int makeByte(int i4, int i5) {
        if ((i4 & 15) == i4) {
            if ((i5 & 15) == i5) {
                return i4 | (i5 << 4);
            }
            throw new IllegalArgumentException("high out of range 0..15");
        }
        throw new IllegalArgumentException("low out of range 0..15");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static short opcodeUnit(DalvInsn dalvInsn, int i4) {
        if ((i4 & 255) == i4) {
            int opcode = dalvInsn.getOpcode().getOpcode();
            if ((opcode & 255) == opcode) {
                return (short) (opcode | (i4 << 8));
            }
            throw new IllegalArgumentException("opcode out of range 0..255");
        }
        throw new IllegalArgumentException("arg out of range 0..255");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String regListString(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        StringBuffer stringBuffer = new StringBuffer((size * 5) + 2);
        stringBuffer.append('{');
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(registerSpecList.get(i4).regString());
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String regRangeString(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        StringBuilder sb = new StringBuilder(30);
        sb.append("{");
        if (size != 0) {
            if (size != 1) {
                RegisterSpec registerSpec = registerSpecList.get(size - 1);
                if (registerSpec.getCategory() == 2) {
                    registerSpec = registerSpec.withOffset(1);
                }
                sb.append(registerSpecList.get(0).regString());
                sb.append("..");
                sb.append(registerSpec.regString());
            } else {
                sb.append(registerSpecList.get(0).regString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean signedFitsInByte(int i4) {
        if (((byte) i4) == i4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean signedFitsInNibble(int i4) {
        if (i4 >= -8 && i4 <= 7) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean signedFitsInShort(int i4) {
        if (((short) i4) == i4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean unsignedFitsInByte(int i4) {
        if (i4 == (i4 & 255)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean unsignedFitsInNibble(int i4) {
        if (i4 == (i4 & 15)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean unsignedFitsInShort(int i4) {
        if (i4 == (65535 & i4)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void write(AnnotatedOutput annotatedOutput, short s3) {
        annotatedOutput.writeShort(s3);
    }

    public boolean branchFits(TargetInsn targetInsn) {
        return false;
    }

    public abstract int codeSize();

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        return new BitSet();
    }

    public abstract String insnArgString(DalvInsn dalvInsn);

    public abstract String insnCommentString(DalvInsn dalvInsn, boolean z3);

    public abstract boolean isCompatible(DalvInsn dalvInsn);

    public final String listingString(DalvInsn dalvInsn, boolean z3) {
        String name = dalvInsn.getOpcode().getName();
        String insnArgString = insnArgString(dalvInsn);
        String insnCommentString = insnCommentString(dalvInsn, z3);
        StringBuilder sb = new StringBuilder(100);
        sb.append(name);
        if (insnArgString.length() != 0) {
            sb.append(' ');
            sb.append(insnArgString);
        }
        if (insnCommentString.length() != 0) {
            sb.append(" // ");
            sb.append(insnCommentString);
        }
        return sb.toString();
    }

    public abstract void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn);

    /* JADX INFO: Access modifiers changed from: protected */
    public static void write(AnnotatedOutput annotatedOutput, short s3, short s4) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static short codeUnit(int i4, int i5, int i6, int i7) {
        if ((i4 & 15) == i4) {
            if ((i5 & 15) == i5) {
                if ((i6 & 15) == i6) {
                    if ((i7 & 15) == i7) {
                        return (short) (i4 | (i5 << 4) | (i6 << 8) | (i7 << 12));
                    }
                    throw new IllegalArgumentException("n3 out of range 0..15");
                }
                throw new IllegalArgumentException("n2 out of range 0..15");
            }
            throw new IllegalArgumentException("n1 out of range 0..15");
        }
        throw new IllegalArgumentException("n0 out of range 0..15");
    }

    protected static short opcodeUnit(DalvInsn dalvInsn) {
        int opcode = dalvInsn.getOpcode().getOpcode();
        if (opcode < 256 || opcode > 65535) {
            throw new IllegalArgumentException("opcode out of range 0..65535");
        }
        return (short) opcode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void write(AnnotatedOutput annotatedOutput, short s3, short s4, short s5) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s4);
        annotatedOutput.writeShort(s5);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s3, short s4, short s5, short s6) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s4);
        annotatedOutput.writeShort(s5);
        annotatedOutput.writeShort(s6);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s3, short s4, short s5, short s6, short s7) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s4);
        annotatedOutput.writeShort(s5);
        annotatedOutput.writeShort(s6);
        annotatedOutput.writeShort(s7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void write(AnnotatedOutput annotatedOutput, short s3, int i4) {
        write(annotatedOutput, s3, (short) i4, (short) (i4 >> 16));
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s3, int i4, short s4) {
        write(annotatedOutput, s3, (short) i4, (short) (i4 >> 16), s4);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s3, int i4, short s4, short s5) {
        write(annotatedOutput, s3, (short) i4, (short) (i4 >> 16), s4, s5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void write(AnnotatedOutput annotatedOutput, short s3, long j4) {
        write(annotatedOutput, s3, (short) j4, (short) (j4 >> 16), (short) (j4 >> 32), (short) (j4 >> 48));
    }
}
