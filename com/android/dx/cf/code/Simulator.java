package com.android.dx.cf.code;

import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Simulator {
    private static final String LOCAL_MISMATCH_ERROR = "This is symptomatic of .class transformation tools that ignore local variable information.";
    private final BytecodeArray code;
    private final LocalVariableList localVariables;
    private final Machine machine;
    private final SimVisitor visitor;

    /* loaded from: classes2.dex */
    private class SimVisitor implements BytecodeArray.Visitor {
        private Frame frame = null;
        private final Machine machine;
        private int previousOffset;

        public SimVisitor() {
            this.machine = Simulator.this.machine;
        }

        private void checkReturnType(Type type) {
            Type returnType = this.machine.getPrototype().getReturnType();
            if (Merger.isPossiblyAssignableFrom(returnType, type)) {
                return;
            }
            throw new SimException("return type mismatch: prototype indicates " + returnType.toHuman() + ", but encountered type " + type.toHuman());
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public int getPreviousOffset() {
            return this.previousOffset;
        }

        public void setFrame(Frame frame) {
            if (frame != null) {
                this.frame = frame;
                return;
            }
            throw new NullPointerException("frame == null");
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void setPreviousOffset(int i4) {
            this.previousOffset = i4;
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitBranch(int i4, int i5, int i6, int i7) {
            switch (i4) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                    this.machine.popArgs(this.frame, Type.INT);
                    break;
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                    Machine machine = this.machine;
                    Frame frame = this.frame;
                    Type type = Type.INT;
                    machine.popArgs(frame, type, type);
                    break;
                case 165:
                case 166:
                    Machine machine2 = this.machine;
                    Frame frame2 = this.frame;
                    Type type2 = Type.OBJECT;
                    machine2.popArgs(frame2, type2, type2);
                    break;
                default:
                    switch (i4) {
                        case 198:
                        case 199:
                            this.machine.popArgs(this.frame, Type.OBJECT);
                            break;
                        case 200:
                        case 201:
                            break;
                        default:
                            visitInvalid(i4, i5, i6);
                            return;
                    }
                case 167:
                case 168:
                    this.machine.clearArgs();
                    break;
            }
            this.machine.auxTargetArg(i7);
            this.machine.run(this.frame, i5, i4);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitConstant(int i4, int i5, int i6, Constant constant, int i7) {
            if (i4 != 189) {
                if (i4 != 197) {
                    if (i4 != 192 && i4 != 193) {
                        switch (i4) {
                            case 179:
                                this.machine.popArgs(this.frame, ((CstFieldRef) constant).getType());
                                break;
                            case 180:
                                break;
                            case 181:
                                this.machine.popArgs(this.frame, Type.OBJECT, ((CstFieldRef) constant).getType());
                                break;
                            case 182:
                            case 183:
                                this.machine.popArgs(this.frame, ((CstMethodRef) constant).getPrototype(false));
                                break;
                            case 184:
                                this.machine.popArgs(this.frame, ((CstMethodRef) constant).getPrototype(true));
                                break;
                            case 185:
                                constant = ((CstInterfaceMethodRef) constant).toMethodRef();
                                this.machine.popArgs(this.frame, ((CstMethodRef) constant).getPrototype(false));
                                break;
                            default:
                                this.machine.clearArgs();
                                break;
                        }
                    }
                    this.machine.popArgs(this.frame, Type.OBJECT);
                } else {
                    this.machine.popArgs(this.frame, Prototype.internInts(Type.VOID, i7));
                }
            } else {
                this.machine.popArgs(this.frame, Type.INT);
            }
            this.machine.auxIntArg(i7);
            this.machine.auxCstArg(constant);
            this.machine.run(this.frame, i5, i4);
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitInvalid(int i4, int i5, int i6) {
            throw new SimException("invalid opcode " + Hex.u1(i4));
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8) {
            int i9;
            Type type2;
            boolean z3;
            if (i4 == 54) {
                i9 = i5 + i6;
            } else {
                i9 = i5;
            }
            LocalVariableList.Item pcAndIndexToLocal = Simulator.this.localVariables.pcAndIndexToLocal(i9, i7);
            if (pcAndIndexToLocal != null) {
                type2 = pcAndIndexToLocal.getType();
                if (type2.getBasicFrameType() != type.getBasicFrameType()) {
                    BaseMachine.throwLocalMismatch(type, type2);
                    return;
                }
            } else {
                type2 = type;
            }
            if (i4 != 21) {
                LocalItem localItem = null;
                if (i4 != 54) {
                    if (i4 != 132) {
                        if (i4 != 169) {
                            visitInvalid(i4, i5, i6);
                            return;
                        }
                    } else {
                        if (pcAndIndexToLocal != null) {
                            localItem = pcAndIndexToLocal.getLocalItem();
                        }
                        this.machine.localArg(this.frame, i7);
                        this.machine.localTarget(i7, type2, localItem);
                        this.machine.auxType(type);
                        this.machine.auxIntArg(i8);
                        this.machine.auxCstArg(CstInteger.make(i8));
                    }
                } else {
                    if (pcAndIndexToLocal != null) {
                        localItem = pcAndIndexToLocal.getLocalItem();
                    }
                    this.machine.popArgs(this.frame, type);
                    this.machine.auxType(type);
                    this.machine.localTarget(i7, type2, localItem);
                }
                this.machine.run(this.frame, i5, i4);
            }
            this.machine.localArg(this.frame, i7);
            Machine machine = this.machine;
            if (pcAndIndexToLocal != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            machine.localInfo(z3);
            this.machine.auxType(type);
            this.machine.run(this.frame, i5, i4);
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList) {
            this.machine.popArgs(this.frame, Type.INT);
            this.machine.auxInitValues(arrayList);
            this.machine.auxCstArg(cstType);
            this.machine.run(this.frame, i4, 188);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:116:0x02b8  */
        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void visitNoArgs(int r9, int r10, int r11, com.android.dx.rop.type.Type r12) {
            /*
                Method dump skipped, instructions count: 1002
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.dx.cf.code.Simulator.SimVisitor.visitNoArgs(int, int, int, com.android.dx.rop.type.Type):void");
        }

        @Override // com.android.dx.cf.code.BytecodeArray.Visitor
        public void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7) {
            this.machine.popArgs(this.frame, Type.INT);
            this.machine.auxIntArg(i7);
            this.machine.auxSwitchArg(switchList);
            this.machine.run(this.frame, i5, i4);
        }
    }

    public Simulator(Machine machine, ConcreteMethod concreteMethod) {
        if (machine != null) {
            if (concreteMethod != null) {
                this.machine = machine;
                this.code = concreteMethod.getCode();
                this.localVariables = concreteMethod.getLocalVariables();
                this.visitor = new SimVisitor();
                return;
            }
            throw new NullPointerException("method == null");
        }
        throw new NullPointerException("machine == null");
    }

    static /* synthetic */ SimException access$100() {
        return illegalTos();
    }

    private static SimException illegalTos() {
        return new SimException("stack mismatch: illegal top-of-stack for opcode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type requiredArrayTypeFor(Type type, Type type2) {
        Type type3;
        Type type4 = Type.KNOWN_NULL;
        if (type2 == type4) {
            if (!type.isReference()) {
                return type.getArrayType();
            }
            return type4;
        } else if (type == Type.OBJECT && type2.isArray() && type2.getComponentType().isReference()) {
            return type2;
        } else {
            if (type == Type.BYTE && type2 == (type3 = Type.BOOLEAN_ARRAY)) {
                return type3;
            }
            return type.getArrayType();
        }
    }

    public void simulate(ByteBlock byteBlock, Frame frame) {
        int end = byteBlock.getEnd();
        this.visitor.setFrame(frame);
        try {
            int start = byteBlock.getStart();
            while (start < end) {
                int parseInstruction = this.code.parseInstruction(start, this.visitor);
                this.visitor.setPreviousOffset(start);
                start += parseInstruction;
            }
        } catch (SimException e4) {
            frame.annotate(e4);
            throw e4;
        }
    }

    public int simulate(int i4, Frame frame) {
        this.visitor.setFrame(frame);
        return this.code.parseInstruction(i4, this.visitor);
    }
}
