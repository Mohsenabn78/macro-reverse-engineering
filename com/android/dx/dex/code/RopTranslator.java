package com.android.dx.dex.code;

import com.android.dx.dex.DexOptions;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.FillArrayDataInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalVariableInfo;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.SwitchInsn;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class RopTranslator {
    private final BlockAddresses addresses;
    private final DexOptions dexOptions;
    private final LocalVariableInfo locals;
    private final RopMethod method;
    private int[] order = null;
    private final OutputCollector output;
    private final int paramSize;
    private boolean paramsAreInOrder;
    private final int positionInfo;
    private final int regCount;
    private final TranslationVisitor translationVisitor;

    /* loaded from: classes2.dex */
    private class LocalVariableAwareTranslationVisitor extends TranslationVisitor {
        private LocalVariableInfo locals;

        public LocalVariableAwareTranslationVisitor(OutputCollector outputCollector, LocalVariableInfo localVariableInfo) {
            super(outputCollector);
            this.locals = localVariableInfo;
        }

        public void addIntroductionIfNecessary(Insn insn) {
            RegisterSpec assignment = this.locals.getAssignment(insn);
            if (assignment != null) {
                addOutput(new LocalStart(insn.getPosition(), assignment));
            }
        }

        @Override // com.android.dx.dex.code.RopTranslator.TranslationVisitor, com.android.dx.rop.code.Insn.Visitor
        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
            super.visitPlainCstInsn(plainCstInsn);
            addIntroductionIfNecessary(plainCstInsn);
        }

        @Override // com.android.dx.dex.code.RopTranslator.TranslationVisitor, com.android.dx.rop.code.Insn.Visitor
        public void visitPlainInsn(PlainInsn plainInsn) {
            super.visitPlainInsn(plainInsn);
            addIntroductionIfNecessary(plainInsn);
        }

        @Override // com.android.dx.dex.code.RopTranslator.TranslationVisitor, com.android.dx.rop.code.Insn.Visitor
        public void visitSwitchInsn(SwitchInsn switchInsn) {
            super.visitSwitchInsn(switchInsn);
            addIntroductionIfNecessary(switchInsn);
        }

        @Override // com.android.dx.dex.code.RopTranslator.TranslationVisitor, com.android.dx.rop.code.Insn.Visitor
        public void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn) {
            super.visitThrowingCstInsn(throwingCstInsn);
            addIntroductionIfNecessary(throwingCstInsn);
        }

        @Override // com.android.dx.dex.code.RopTranslator.TranslationVisitor, com.android.dx.rop.code.Insn.Visitor
        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
            super.visitThrowingInsn(throwingInsn);
            addIntroductionIfNecessary(throwingInsn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TranslationVisitor implements Insn.Visitor {
        private BasicBlock block;
        private CodeAddress lastAddress;
        private final OutputCollector output;

        public TranslationVisitor(OutputCollector outputCollector) {
            this.output = outputCollector;
        }

        private RegisterSpec getNextMoveResultPseudo() {
            int primarySuccessor = this.block.getPrimarySuccessor();
            if (primarySuccessor < 0) {
                return null;
            }
            Insn insn = RopTranslator.this.method.getBlocks().labelToBlock(primarySuccessor).getInsns().get(0);
            if (insn.getOpcode().getOpcode() != 56) {
                return null;
            }
            return insn.getResult();
        }

        protected void addOutput(DalvInsn dalvInsn) {
            this.output.add(dalvInsn);
        }

        protected void addOutputSuffix(DalvInsn dalvInsn) {
            this.output.addSuffix(dalvInsn);
        }

        public void setBlock(BasicBlock basicBlock, CodeAddress codeAddress) {
            this.block = basicBlock;
            this.lastAddress = codeAddress;
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitFillArrayDataInsn(FillArrayDataInsn fillArrayDataInsn) {
            SourcePosition position = fillArrayDataInsn.getPosition();
            Constant constant = fillArrayDataInsn.getConstant();
            ArrayList<Constant> initValues = fillArrayDataInsn.getInitValues();
            if (fillArrayDataInsn.getOpcode().getBranchingness() == 1) {
                CodeAddress codeAddress = new CodeAddress(position);
                DalvInsn arrayData = new ArrayData(position, this.lastAddress, initValues, constant);
                DalvInsn targetInsn = new TargetInsn(Dops.FILL_ARRAY_DATA, position, RopTranslator.getRegs(fillArrayDataInsn), codeAddress);
                addOutput(this.lastAddress);
                addOutput(targetInsn);
                addOutputSuffix(new OddSpacer(position));
                addOutputSuffix(codeAddress);
                addOutputSuffix(arrayData);
                return;
            }
            throw new RuntimeException("shouldn't happen");
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
            SourcePosition position = plainCstInsn.getPosition();
            Dop dopFor = RopToDop.dopFor(plainCstInsn);
            Rop opcode = plainCstInsn.getOpcode();
            int opcode2 = opcode.getOpcode();
            if (opcode.getBranchingness() == 1) {
                if (opcode2 == 3) {
                    if (!RopTranslator.this.paramsAreInOrder) {
                        RegisterSpec result = plainCstInsn.getResult();
                        addOutput(new SimpleInsn(dopFor, position, RegisterSpecList.make(result, RegisterSpec.make((RopTranslator.this.regCount - RopTranslator.this.paramSize) + ((CstInteger) plainCstInsn.getConstant()).getValue(), result.getType()))));
                        return;
                    }
                    return;
                }
                addOutput(new CstInsn(dopFor, position, RopTranslator.getRegs(plainCstInsn), plainCstInsn.getConstant()));
                return;
            }
            throw new RuntimeException("shouldn't happen");
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitPlainInsn(PlainInsn plainInsn) {
            DalvInsn simpleInsn;
            Rop opcode = plainInsn.getOpcode();
            if (opcode.getOpcode() == 54 || opcode.getOpcode() == 56) {
                return;
            }
            SourcePosition position = plainInsn.getPosition();
            Dop dopFor = RopToDop.dopFor(plainInsn);
            int branchingness = opcode.getBranchingness();
            if (branchingness != 1 && branchingness != 2) {
                if (branchingness != 3) {
                    if (branchingness != 4) {
                        if (branchingness != 6) {
                            throw new RuntimeException("shouldn't happen");
                        }
                    } else {
                        simpleInsn = new TargetInsn(dopFor, position, RopTranslator.getRegs(plainInsn), RopTranslator.this.addresses.getStart(this.block.getSuccessors().get(1)));
                        addOutput(simpleInsn);
                    }
                } else {
                    return;
                }
            }
            simpleInsn = new SimpleInsn(dopFor, position, RopTranslator.getRegs(plainInsn));
            addOutput(simpleInsn);
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitSwitchInsn(SwitchInsn switchInsn) {
            Dop dop;
            SourcePosition position = switchInsn.getPosition();
            IntList cases = switchInsn.getCases();
            IntList successors = this.block.getSuccessors();
            int size = cases.size();
            int size2 = successors.size();
            int primarySuccessor = this.block.getPrimarySuccessor();
            if (size == size2 - 1 && primarySuccessor == successors.get(size)) {
                CodeAddress[] codeAddressArr = new CodeAddress[size];
                for (int i4 = 0; i4 < size; i4++) {
                    codeAddressArr[i4] = RopTranslator.this.addresses.getStart(successors.get(i4));
                }
                CodeAddress codeAddress = new CodeAddress(position);
                CodeAddress codeAddress2 = new CodeAddress(this.lastAddress.getPosition(), true);
                SwitchData switchData = new SwitchData(position, codeAddress2, cases, codeAddressArr);
                if (switchData.isPacked()) {
                    dop = Dops.PACKED_SWITCH;
                } else {
                    dop = Dops.SPARSE_SWITCH;
                }
                DalvInsn targetInsn = new TargetInsn(dop, position, RopTranslator.getRegs(switchInsn), codeAddress);
                addOutput(codeAddress2);
                addOutput(targetInsn);
                addOutputSuffix(new OddSpacer(position));
                addOutputSuffix(codeAddress);
                addOutputSuffix(switchData);
                return;
            }
            throw new RuntimeException("shouldn't happen");
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn) {
            boolean z3;
            DalvInsn cstInsn;
            SourcePosition position = throwingCstInsn.getPosition();
            Dop dopFor = RopToDop.dopFor(throwingCstInsn);
            Rop opcode = throwingCstInsn.getOpcode();
            Constant constant = throwingCstInsn.getConstant();
            if (opcode.getBranchingness() == 6) {
                addOutput(this.lastAddress);
                if (opcode.isCallLike()) {
                    addOutput(new CstInsn(dopFor, position, throwingCstInsn.getSources(), constant));
                    return;
                }
                RegisterSpec nextMoveResultPseudo = getNextMoveResultPseudo();
                RegisterSpecList regs = RopTranslator.getRegs(throwingCstInsn, nextMoveResultPseudo);
                boolean z4 = false;
                if (!dopFor.hasResult() && opcode.getOpcode() != 43) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (nextMoveResultPseudo != null) {
                    z4 = true;
                }
                if (z3 == z4) {
                    if (opcode.getOpcode() == 41 && dopFor.getOpcode() != 35) {
                        cstInsn = new SimpleInsn(dopFor, position, regs);
                    } else {
                        cstInsn = new CstInsn(dopFor, position, regs, constant);
                    }
                    addOutput(cstInsn);
                    return;
                }
                throw new RuntimeException("Insn with result/move-result-pseudo mismatch " + throwingCstInsn);
            }
            throw new RuntimeException("shouldn't happen");
        }

        @Override // com.android.dx.rop.code.Insn.Visitor
        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
            boolean z3;
            SourcePosition position = throwingInsn.getPosition();
            Dop dopFor = RopToDop.dopFor(throwingInsn);
            if (throwingInsn.getOpcode().getBranchingness() == 6) {
                RegisterSpec nextMoveResultPseudo = getNextMoveResultPseudo();
                boolean hasResult = dopFor.hasResult();
                if (nextMoveResultPseudo != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (hasResult == z3) {
                    addOutput(this.lastAddress);
                    addOutput(new SimpleInsn(dopFor, position, RopTranslator.getRegs(throwingInsn, nextMoveResultPseudo)));
                    return;
                }
                throw new RuntimeException("Insn with result/move-result-pseudo mismatch" + throwingInsn);
            }
            throw new RuntimeException("shouldn't happen");
        }
    }

    private RopTranslator(RopMethod ropMethod, int i4, LocalVariableInfo localVariableInfo, int i5, DexOptions dexOptions) {
        int i6;
        this.dexOptions = dexOptions;
        this.method = ropMethod;
        this.positionInfo = i4;
        this.locals = localVariableInfo;
        this.addresses = new BlockAddresses(ropMethod);
        this.paramSize = i5;
        this.paramsAreInOrder = calculateParamsAreInOrder(ropMethod, i5);
        BasicBlockList blocks = ropMethod.getBlocks();
        int size = blocks.size();
        int i7 = size * 3;
        int instructionCount = blocks.getInstructionCount() + i7;
        int assignmentCount = localVariableInfo != null ? instructionCount + size + localVariableInfo.getAssignmentCount() : instructionCount;
        int regCount = blocks.getRegCount();
        if (this.paramsAreInOrder) {
            i6 = 0;
        } else {
            i6 = i5;
        }
        int i8 = regCount + i6;
        this.regCount = i8;
        OutputCollector outputCollector = new OutputCollector(dexOptions, assignmentCount, i7, i8, i5);
        this.output = outputCollector;
        if (localVariableInfo != null) {
            this.translationVisitor = new LocalVariableAwareTranslationVisitor(outputCollector, localVariableInfo);
        } else {
            this.translationVisitor = new TranslationVisitor(outputCollector);
        }
    }

    private static boolean calculateParamsAreInOrder(RopMethod ropMethod, final int i4) {
        final boolean[] zArr = {true};
        final int regCount = ropMethod.getBlocks().getRegCount();
        ropMethod.getBlocks().forEachInsn(new Insn.BaseVisitor() { // from class: com.android.dx.dex.code.RopTranslator.1
            @Override // com.android.dx.rop.code.Insn.BaseVisitor, com.android.dx.rop.code.Insn.Visitor
            public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
                boolean z3;
                if (plainCstInsn.getOpcode().getOpcode() == 3) {
                    int value = ((CstInteger) plainCstInsn.getConstant()).getValue();
                    boolean[] zArr2 = zArr;
                    if (zArr2[0] && (regCount - i4) + value == plainCstInsn.getResult().getReg()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zArr2[0] = z3;
                }
            }
        });
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RegisterSpecList getRegs(Insn insn) {
        return getRegs(insn, insn.getResult());
    }

    private void outputBlock(BasicBlock basicBlock, int i4) {
        CodeAddress start = this.addresses.getStart(basicBlock);
        this.output.add(start);
        LocalVariableInfo localVariableInfo = this.locals;
        if (localVariableInfo != null) {
            this.output.add(new LocalSnapshot(start.getPosition(), localVariableInfo.getStarts(basicBlock)));
        }
        this.translationVisitor.setBlock(basicBlock, this.addresses.getLast(basicBlock));
        basicBlock.getInsns().forEach(this.translationVisitor);
        this.output.add(this.addresses.getEnd(basicBlock));
        int primarySuccessor = basicBlock.getPrimarySuccessor();
        Insn lastInsn = basicBlock.getLastInsn();
        if (primarySuccessor >= 0 && primarySuccessor != i4) {
            if (lastInsn.getOpcode().getBranchingness() == 4 && basicBlock.getSecondarySuccessor() == i4) {
                this.output.reverseBranch(1, this.addresses.getStart(primarySuccessor));
                return;
            }
            this.output.add(new TargetInsn(Dops.GOTO, lastInsn.getPosition(), RegisterSpecList.EMPTY, this.addresses.getStart(primarySuccessor)));
        }
    }

    private void outputInstructions() {
        int i4;
        BasicBlockList blocks = this.method.getBlocks();
        int[] iArr = this.order;
        int length = iArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            if (i6 == iArr.length) {
                i4 = -1;
            } else {
                i4 = iArr[i6];
            }
            outputBlock(blocks.labelToBlock(iArr[i5]), i4);
            i5 = i6;
        }
    }

    private void pickOrder() {
        int i4;
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        int maxLabel = blocks.getMaxLabel();
        int[] makeBitSet = Bits.makeBitSet(maxLabel);
        int[] makeBitSet2 = Bits.makeBitSet(maxLabel);
        for (int i5 = 0; i5 < size; i5++) {
            Bits.set(makeBitSet, blocks.get(i5).getLabel());
        }
        int[] iArr = new int[size];
        int firstLabel = this.method.getFirstLabel();
        int i6 = 0;
        while (firstLabel != -1) {
            while (true) {
                IntList labelToPredecessors = this.method.labelToPredecessors(firstLabel);
                int size2 = labelToPredecessors.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    i4 = labelToPredecessors.get(i7);
                    if (Bits.get(makeBitSet2, i4)) {
                        break;
                    } else if (Bits.get(makeBitSet, i4) && blocks.labelToBlock(i4).getPrimarySuccessor() == firstLabel) {
                        break;
                    }
                }
                Bits.set(makeBitSet2, i4);
                firstLabel = i4;
            }
            while (firstLabel != -1) {
                Bits.clear(makeBitSet, firstLabel);
                Bits.clear(makeBitSet2, firstLabel);
                iArr[i6] = firstLabel;
                i6++;
                BasicBlock labelToBlock = blocks.labelToBlock(firstLabel);
                BasicBlock preferredSuccessorOf = blocks.preferredSuccessorOf(labelToBlock);
                if (preferredSuccessorOf == null) {
                    break;
                }
                int label = preferredSuccessorOf.getLabel();
                int primarySuccessor = labelToBlock.getPrimarySuccessor();
                if (Bits.get(makeBitSet, label)) {
                    firstLabel = label;
                } else if (primarySuccessor != label && primarySuccessor >= 0 && Bits.get(makeBitSet, primarySuccessor)) {
                    firstLabel = primarySuccessor;
                } else {
                    IntList successors = labelToBlock.getSuccessors();
                    int size3 = successors.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 < size3) {
                            int i9 = successors.get(i8);
                            if (Bits.get(makeBitSet, i9)) {
                                firstLabel = i9;
                                break;
                            }
                            i8++;
                        } else {
                            firstLabel = -1;
                            break;
                        }
                    }
                }
            }
            firstLabel = Bits.findFirst(makeBitSet, 0);
        }
        if (i6 == size) {
            this.order = iArr;
            return;
        }
        throw new RuntimeException("shouldn't happen");
    }

    public static DalvCode translate(RopMethod ropMethod, int i4, LocalVariableInfo localVariableInfo, int i5, DexOptions dexOptions) {
        return new RopTranslator(ropMethod, i4, localVariableInfo, i5, dexOptions).translateAndGetResult();
    }

    private DalvCode translateAndGetResult() {
        pickOrder();
        outputInstructions();
        return new DalvCode(this.positionInfo, this.output.getFinisher(), new StdCatchBuilder(this.method, this.order, this.addresses));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RegisterSpecList getRegs(Insn insn, RegisterSpec registerSpec) {
        RegisterSpecList sources = insn.getSources();
        if (insn.getOpcode().isCommutative() && sources.size() == 2 && registerSpec.getReg() == sources.get(1).getReg()) {
            sources = RegisterSpecList.make(sources.get(1), sources.get(0));
        }
        return registerSpec == null ? sources : sources.withFirst(registerSpec);
    }
}
