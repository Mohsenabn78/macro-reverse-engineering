package com.android.dx.cf.code;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Bits;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class BytecodeArray {
    public static final Visitor EMPTY_VISITOR = new BaseVisitor();
    private final ByteArray bytes;
    private final ConstantPool pool;

    /* loaded from: classes2.dex */
    public interface Visitor {
        int getPreviousOffset();

        void setPreviousOffset(int i4);

        void visitBranch(int i4, int i5, int i6, int i7);

        void visitConstant(int i4, int i5, int i6, Constant constant, int i7);

        void visitInvalid(int i4, int i5, int i6);

        void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8);

        void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList);

        void visitNoArgs(int i4, int i5, int i6, Type type);

        void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7);
    }

    public BytecodeArray(ByteArray byteArray, ConstantPool constantPool) {
        if (byteArray != null) {
            if (constantPool != null) {
                this.bytes = byteArray;
                this.pool = constantPool;
                return;
            }
            throw new NullPointerException("pool == null");
        }
        throw new NullPointerException("bytes == null");
    }

    private int parseLookupswitch(int i4, Visitor visitor) {
        int i5 = (i4 + 4) & (-4);
        int i6 = 0;
        for (int i7 = i4 + 1; i7 < i5; i7++) {
            i6 = (i6 << 8) | this.bytes.getUnsignedByte(i7);
        }
        int i8 = this.bytes.getInt(i5) + i4;
        int i9 = this.bytes.getInt(i5 + 4);
        int i10 = i5 + 8;
        SwitchList switchList = new SwitchList(i9);
        for (int i11 = 0; i11 < i9; i11++) {
            i10 += 8;
            switchList.add(this.bytes.getInt(i10), this.bytes.getInt(i10 + 4) + i4);
        }
        switchList.setDefaultTarget(i8);
        switchList.removeSuperfluousDefaults();
        switchList.setImmutable();
        int i12 = i10 - i4;
        visitor.visitSwitch(171, i4, i12, switchList, i6);
        return i12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a7, code lost:
        if (r8 != 80) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
        if (r8 != 79) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
        if (r8 != 86) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
        if (r8 != 82) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bb, code lost:
        if (r8 != 81) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c0, code lost:
        if (r8 != 85) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
        if (r8 != 84) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c8, code lost:
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseNewarray(int r13, com.android.dx.cf.code.BytecodeArray.Visitor r14) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.cf.code.BytecodeArray.parseNewarray(int, com.android.dx.cf.code.BytecodeArray$Visitor):int");
    }

    private int parseTableswitch(int i4, Visitor visitor) {
        int i5 = (i4 + 4) & (-4);
        int i6 = 0;
        for (int i7 = i4 + 1; i7 < i5; i7++) {
            i6 = (i6 << 8) | this.bytes.getUnsignedByte(i7);
        }
        int i8 = this.bytes.getInt(i5) + i4;
        int i9 = this.bytes.getInt(i5 + 4);
        int i10 = this.bytes.getInt(i5 + 8);
        int i11 = (i10 - i9) + 1;
        int i12 = i5 + 12;
        if (i9 <= i10) {
            SwitchList switchList = new SwitchList(i11);
            for (int i13 = 0; i13 < i11; i13++) {
                i12 += 4;
                switchList.add(i9 + i13, this.bytes.getInt(i12) + i4);
            }
            switchList.setDefaultTarget(i8);
            switchList.removeSuperfluousDefaults();
            switchList.setImmutable();
            int i14 = i12 - i4;
            visitor.visitSwitch(171, i4, i14, switchList, i6);
            return i14;
        }
        throw new SimException("low / high inversion");
    }

    private int parseWide(int i4, Visitor visitor) {
        int unsignedByte = this.bytes.getUnsignedByte(i4 + 1);
        int unsignedShort = this.bytes.getUnsignedShort(i4 + 2);
        if (unsignedByte != 132) {
            if (unsignedByte != 169) {
                switch (unsignedByte) {
                    case 21:
                        visitor.visitLocal(21, i4, 4, unsignedShort, Type.INT, 0);
                        return 4;
                    case 22:
                        visitor.visitLocal(21, i4, 4, unsignedShort, Type.LONG, 0);
                        return 4;
                    case 23:
                        visitor.visitLocal(21, i4, 4, unsignedShort, Type.FLOAT, 0);
                        return 4;
                    case 24:
                        visitor.visitLocal(21, i4, 4, unsignedShort, Type.DOUBLE, 0);
                        return 4;
                    case 25:
                        visitor.visitLocal(21, i4, 4, unsignedShort, Type.OBJECT, 0);
                        return 4;
                    default:
                        switch (unsignedByte) {
                            case 54:
                                visitor.visitLocal(54, i4, 4, unsignedShort, Type.INT, 0);
                                return 4;
                            case 55:
                                visitor.visitLocal(54, i4, 4, unsignedShort, Type.LONG, 0);
                                return 4;
                            case 56:
                                visitor.visitLocal(54, i4, 4, unsignedShort, Type.FLOAT, 0);
                                return 4;
                            case 57:
                                visitor.visitLocal(54, i4, 4, unsignedShort, Type.DOUBLE, 0);
                                return 4;
                            case 58:
                                visitor.visitLocal(54, i4, 4, unsignedShort, Type.OBJECT, 0);
                                return 4;
                            default:
                                visitor.visitInvalid(196, i4, 1);
                                return 1;
                        }
                }
            }
            visitor.visitLocal(unsignedByte, i4, 4, unsignedShort, Type.RETURN_ADDRESS, 0);
            return 4;
        }
        visitor.visitLocal(unsignedByte, i4, 6, unsignedShort, Type.INT, this.bytes.getShort(i4 + 4));
        return 6;
    }

    public int byteLength() {
        return this.bytes.size() + 4;
    }

    public void forEach(Visitor visitor) {
        int size = this.bytes.size();
        int i4 = 0;
        while (i4 < size) {
            i4 += parseInstruction(i4, visitor);
        }
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    public int[] getInstructionOffsets() {
        int size = this.bytes.size();
        int[] makeBitSet = Bits.makeBitSet(size);
        int i4 = 0;
        while (i4 < size) {
            Bits.set(makeBitSet, i4, true);
            i4 += parseInstruction(i4, null);
        }
        return makeBitSet;
    }

    public int parseInstruction(int i4, Visitor visitor) {
        int i5;
        int i6;
        int i7;
        if (visitor == null) {
            visitor = EMPTY_VISITOR;
        }
        Visitor visitor2 = visitor;
        try {
            int unsignedByte = this.bytes.getUnsignedByte(i4);
            ByteOps.opInfo(unsignedByte);
            switch (unsignedByte) {
                case 0:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.VOID);
                    break;
                case 1:
                    visitor2.visitConstant(18, i4, 1, CstKnownNull.THE_ONE, 0);
                    return 1;
                case 2:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_M1, -1);
                    return 1;
                case 3:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_0, 0);
                    return 1;
                case 4:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_1, 1);
                    return 1;
                case 5:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_2, 2);
                    return 1;
                case 6:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_3, 3);
                    return 1;
                case 7:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_4, 4);
                    return 1;
                case 8:
                    visitor2.visitConstant(18, i4, 1, CstInteger.VALUE_5, 5);
                    return 1;
                case 9:
                    visitor2.visitConstant(18, i4, 1, CstLong.VALUE_0, 0);
                    return 1;
                case 10:
                    visitor2.visitConstant(18, i4, 1, CstLong.VALUE_1, 0);
                    return 1;
                case 11:
                    visitor2.visitConstant(18, i4, 1, CstFloat.VALUE_0, 0);
                    return 1;
                case 12:
                    visitor2.visitConstant(18, i4, 1, CstFloat.VALUE_1, 0);
                    return 1;
                case 13:
                    visitor2.visitConstant(18, i4, 1, CstFloat.VALUE_2, 0);
                    return 1;
                case 14:
                    visitor2.visitConstant(18, i4, 1, CstDouble.VALUE_0, 0);
                    return 1;
                case 15:
                    visitor2.visitConstant(18, i4, 1, CstDouble.VALUE_1, 0);
                    return 1;
                case 16:
                    int i8 = this.bytes.getByte(i4 + 1);
                    visitor2.visitConstant(18, i4, 2, CstInteger.make(i8), i8);
                    return 2;
                case 17:
                    int i9 = this.bytes.getShort(i4 + 1);
                    visitor2.visitConstant(18, i4, 3, CstInteger.make(i9), i9);
                    return 3;
                case 18:
                    Constant constant = this.pool.get(this.bytes.getUnsignedByte(i4 + 1));
                    if (constant instanceof CstInteger) {
                        i5 = ((CstInteger) constant).getValue();
                    } else {
                        i5 = 0;
                    }
                    visitor2.visitConstant(18, i4, 2, constant, i5);
                    return 2;
                case 19:
                    Constant constant2 = this.pool.get(this.bytes.getUnsignedShort(i4 + 1));
                    if (constant2 instanceof CstInteger) {
                        i6 = ((CstInteger) constant2).getValue();
                    } else {
                        i6 = 0;
                    }
                    visitor2.visitConstant(18, i4, 3, constant2, i6);
                    return 3;
                case 20:
                    visitor2.visitConstant(20, i4, 3, this.pool.get(this.bytes.getUnsignedShort(i4 + 1)), 0);
                    return 3;
                case 21:
                    visitor2.visitLocal(21, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.INT, 0);
                    return 2;
                case 22:
                    visitor2.visitLocal(21, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.LONG, 0);
                    return 2;
                case 23:
                    visitor2.visitLocal(21, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.FLOAT, 0);
                    return 2;
                case 24:
                    visitor2.visitLocal(21, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.DOUBLE, 0);
                    return 2;
                case 25:
                    visitor2.visitLocal(21, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.OBJECT, 0);
                    return 2;
                case 26:
                case 27:
                case 28:
                case 29:
                    visitor2.visitLocal(21, i4, 1, unsignedByte - 26, Type.INT, 0);
                    return 1;
                case 30:
                case 31:
                case 32:
                case 33:
                    visitor2.visitLocal(21, i4, 1, unsignedByte - 30, Type.LONG, 0);
                    return 1;
                case 34:
                case 35:
                case 36:
                case 37:
                    visitor2.visitLocal(21, i4, 1, unsignedByte - 34, Type.FLOAT, 0);
                    return 1;
                case 38:
                case 39:
                case 40:
                case 41:
                    visitor2.visitLocal(21, i4, 1, unsignedByte - 38, Type.DOUBLE, 0);
                    return 1;
                case 42:
                case 43:
                case 44:
                case 45:
                    visitor2.visitLocal(21, i4, 1, unsignedByte - 42, Type.OBJECT, 0);
                    return 1;
                case 46:
                    visitor2.visitNoArgs(46, i4, 1, Type.INT);
                    return 1;
                case 47:
                    visitor2.visitNoArgs(46, i4, 1, Type.LONG);
                    return 1;
                case 48:
                    visitor2.visitNoArgs(46, i4, 1, Type.FLOAT);
                    return 1;
                case 49:
                    visitor2.visitNoArgs(46, i4, 1, Type.DOUBLE);
                    return 1;
                case 50:
                    visitor2.visitNoArgs(46, i4, 1, Type.OBJECT);
                    return 1;
                case 51:
                    visitor2.visitNoArgs(46, i4, 1, Type.BYTE);
                    return 1;
                case 52:
                    visitor2.visitNoArgs(46, i4, 1, Type.CHAR);
                    return 1;
                case 53:
                    visitor2.visitNoArgs(46, i4, 1, Type.SHORT);
                    return 1;
                case 54:
                    visitor2.visitLocal(54, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.INT, 0);
                    return 2;
                case 55:
                    visitor2.visitLocal(54, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.LONG, 0);
                    return 2;
                case 56:
                    visitor2.visitLocal(54, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.FLOAT, 0);
                    return 2;
                case 57:
                    visitor2.visitLocal(54, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.DOUBLE, 0);
                    return 2;
                case 58:
                    visitor2.visitLocal(54, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.OBJECT, 0);
                    return 2;
                case 59:
                case 60:
                case 61:
                case 62:
                    visitor2.visitLocal(54, i4, 1, unsignedByte - 59, Type.INT, 0);
                    return 1;
                case 63:
                case 64:
                case 65:
                case 66:
                    visitor2.visitLocal(54, i4, 1, unsignedByte - 63, Type.LONG, 0);
                    return 1;
                case 67:
                case 68:
                case 69:
                case 70:
                    visitor2.visitLocal(54, i4, 1, unsignedByte - 67, Type.FLOAT, 0);
                    return 1;
                case 71:
                case 72:
                case 73:
                case 74:
                    visitor2.visitLocal(54, i4, 1, unsignedByte - 71, Type.DOUBLE, 0);
                    return 1;
                case 75:
                case 76:
                case 77:
                case 78:
                    visitor2.visitLocal(54, i4, 1, unsignedByte - 75, Type.OBJECT, 0);
                    return 1;
                case 79:
                    visitor2.visitNoArgs(79, i4, 1, Type.INT);
                    return 1;
                case 80:
                    visitor2.visitNoArgs(79, i4, 1, Type.LONG);
                    return 1;
                case 81:
                    visitor2.visitNoArgs(79, i4, 1, Type.FLOAT);
                    return 1;
                case 82:
                    visitor2.visitNoArgs(79, i4, 1, Type.DOUBLE);
                    return 1;
                case 83:
                    visitor2.visitNoArgs(79, i4, 1, Type.OBJECT);
                    return 1;
                case 84:
                    visitor2.visitNoArgs(79, i4, 1, Type.BYTE);
                    return 1;
                case 85:
                    visitor2.visitNoArgs(79, i4, 1, Type.CHAR);
                    return 1;
                case 86:
                    visitor2.visitNoArgs(79, i4, 1, Type.SHORT);
                    return 1;
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.VOID);
                    return 1;
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 116:
                case 120:
                case 122:
                case 124:
                case 126:
                case 128:
                case 130:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.INT);
                    return 1;
                case 97:
                case 101:
                case 105:
                case 109:
                case 113:
                case 117:
                case 121:
                case 123:
                case 125:
                case 127:
                case 129:
                case 131:
                    visitor2.visitNoArgs(unsignedByte - 1, i4, 1, Type.LONG);
                    return 1;
                case 98:
                case 102:
                case 106:
                case 110:
                case 114:
                case 118:
                    visitor2.visitNoArgs(unsignedByte - 2, i4, 1, Type.FLOAT);
                    return 1;
                case 99:
                case 103:
                case 107:
                case 111:
                case 115:
                case 119:
                    visitor2.visitNoArgs(unsignedByte - 3, i4, 1, Type.DOUBLE);
                    return 1;
                case 132:
                    visitor2.visitLocal(unsignedByte, i4, 3, this.bytes.getUnsignedByte(i4 + 1), Type.INT, this.bytes.getByte(i4 + 2));
                    return 3;
                case 133:
                case 140:
                case 143:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.LONG);
                    return 1;
                case 134:
                case 137:
                case 144:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.FLOAT);
                    return 1;
                case 135:
                case 138:
                case 141:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.DOUBLE);
                    return 1;
                case 136:
                case 139:
                case 142:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 190:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.INT);
                    return 1;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 198:
                case 199:
                    visitor2.visitBranch(unsignedByte, i4, 3, this.bytes.getShort(i4 + 1) + i4);
                    return 3;
                case 169:
                    visitor2.visitLocal(unsignedByte, i4, 2, this.bytes.getUnsignedByte(i4 + 1), Type.RETURN_ADDRESS, 0);
                    return 2;
                case 170:
                    return parseTableswitch(i4, visitor2);
                case 171:
                    return parseLookupswitch(i4, visitor2);
                case 172:
                    visitor2.visitNoArgs(172, i4, 1, Type.INT);
                    return 1;
                case 173:
                    visitor2.visitNoArgs(172, i4, 1, Type.LONG);
                    return 1;
                case 174:
                    visitor2.visitNoArgs(172, i4, 1, Type.FLOAT);
                    return 1;
                case 175:
                    visitor2.visitNoArgs(172, i4, 1, Type.DOUBLE);
                    return 1;
                case 176:
                    visitor2.visitNoArgs(172, i4, 1, Type.OBJECT);
                    return 1;
                case 177:
                case 191:
                case 194:
                case 195:
                    visitor2.visitNoArgs(unsignedByte, i4, 1, Type.VOID);
                    return 1;
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    visitor2.visitConstant(unsignedByte, i4, 3, this.pool.get(this.bytes.getUnsignedShort(i4 + 1)), 0);
                    return 3;
                case 185:
                    visitor2.visitConstant(unsignedByte, i4, 5, this.pool.get(this.bytes.getUnsignedShort(i4 + 1)), this.bytes.getUnsignedByte(i4 + 3) | (this.bytes.getUnsignedByte(i4 + 4) << 8));
                    return 5;
                case 186:
                    throw new ParseException("invokedynamic not supported");
                case 188:
                    return parseNewarray(i4, visitor2);
                case 196:
                    return parseWide(i4, visitor2);
                case 197:
                    int unsignedShort = this.bytes.getUnsignedShort(i4 + 1);
                    visitor2.visitConstant(unsignedByte, i4, 4, this.pool.get(unsignedShort), this.bytes.getUnsignedByte(i4 + 3));
                    return 4;
                case 200:
                case 201:
                    int i10 = this.bytes.getInt(i4 + 1) + i4;
                    if (unsignedByte == 200) {
                        i7 = 167;
                    } else {
                        i7 = 168;
                    }
                    visitor2.visitBranch(i7, i4, 5, i10);
                    return 5;
                default:
                    visitor2.visitInvalid(unsignedByte, i4, 1);
                    break;
            }
            return 1;
        } catch (SimException e4) {
            e4.addContext("...at bytecode offset " + Hex.u4(i4));
            throw e4;
        } catch (RuntimeException e5) {
            SimException simException = new SimException(e5);
            simException.addContext("...at bytecode offset " + Hex.u4(i4));
            throw simException;
        }
    }

    public void processWorkSet(int[] iArr, Visitor visitor) {
        if (visitor == null) {
            throw new NullPointerException("visitor == null");
        }
        while (true) {
            int findFirst = Bits.findFirst(iArr, 0);
            if (findFirst < 0) {
                return;
            }
            Bits.clear(iArr, findFirst);
            parseInstruction(findFirst, visitor);
            visitor.setPreviousOffset(findFirst);
        }
    }

    public int size() {
        return this.bytes.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ConstantParserVisitor extends BaseVisitor {
        Constant cst;
        int length;
        int value;

        ConstantParserVisitor() {
        }

        private void clear() {
            this.length = 0;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public int getPreviousOffset() {
            return -1;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitBranch(int i4, int i5, int i6, int i7) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitConstant(int i4, int i5, int i6, Constant constant, int i7) {
            this.cst = constant;
            this.length = i6;
            this.value = i7;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitInvalid(int i4, int i5, int i6) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitNoArgs(int i4, int i5, int i6, Type type) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7) {
            clear();
        }

        @Override // com.android.dx.cf.code.BytecodeArray.BaseVisitor, com.android.dx.cf.code.BytecodeArray.Visitor
        public void setPreviousOffset(int i4) {
        }
    }

    /* loaded from: classes2.dex */
    public static class BaseVisitor implements Visitor {
        private int previousOffset = -1;

        BaseVisitor() {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public int getPreviousOffset() {
            return this.previousOffset;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void setPreviousOffset(int i4) {
            this.previousOffset = i4;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitInvalid(int i4, int i5, int i6) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitBranch(int i4, int i5, int i6, int i7) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitNoArgs(int i4, int i5, int i6, Type type) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitConstant(int i4, int i5, int i6, Constant constant, int i7) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7) {
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8) {
        }
    }
}
