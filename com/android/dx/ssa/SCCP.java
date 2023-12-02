package com.android.dx.ssa;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.TypedConstant;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SCCP {
    private static final int CONSTANT = 1;
    private static final int TOP = 0;
    private static final int VARYING = 2;
    private ArrayList<SsaInsn> branchWorklist;
    private ArrayList<SsaBasicBlock> cfgPhiWorklist;
    private ArrayList<SsaBasicBlock> cfgWorklist;
    private BitSet executableBlocks;
    private Constant[] latticeConstants;
    private int[] latticeValues;
    private int regCount;
    private SsaMethod ssaMeth;
    private ArrayList<SsaInsn> ssaWorklist;
    private ArrayList<SsaInsn> varyingWorklist;

    private SCCP(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
        int regCount = ssaMethod.getRegCount();
        this.regCount = regCount;
        this.latticeValues = new int[regCount];
        this.latticeConstants = new Constant[regCount];
        this.cfgWorklist = new ArrayList<>();
        this.cfgPhiWorklist = new ArrayList<>();
        this.executableBlocks = new BitSet(ssaMethod.getBlocks().size());
        this.ssaWorklist = new ArrayList<>();
        this.varyingWorklist = new ArrayList<>();
        this.branchWorklist = new ArrayList<>();
        for (int i4 = 0; i4 < this.regCount; i4++) {
            this.latticeValues[i4] = 0;
            this.latticeConstants[i4] = null;
        }
    }

    private void addBlockToWorklist(SsaBasicBlock ssaBasicBlock) {
        if (!this.executableBlocks.get(ssaBasicBlock.getIndex())) {
            this.cfgWorklist.add(ssaBasicBlock);
            this.executableBlocks.set(ssaBasicBlock.getIndex());
            return;
        }
        this.cfgPhiWorklist.add(ssaBasicBlock);
    }

    private void addUsersToWorklist(int i4, int i5) {
        if (i5 == 2) {
            for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(i4)) {
                this.varyingWorklist.add(ssaInsn);
            }
            return;
        }
        for (SsaInsn ssaInsn2 : this.ssaMeth.getUseListForRegister(i4)) {
            this.ssaWorklist.add(ssaInsn2);
        }
    }

    private static String latticeValName(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return "UNKNOWN";
                }
                return "VARYING";
            }
            return "CONSTANT";
        }
        return "TOP";
    }

    public static void process(SsaMethod ssaMethod) {
        new SCCP(ssaMethod).run();
    }

    private void replaceBranches() {
        Iterator<SsaInsn> it = this.branchWorklist.iterator();
        while (it.hasNext()) {
            SsaInsn next = it.next();
            SsaBasicBlock block = next.getBlock();
            int size = block.getSuccessorList().size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = block.getSuccessorList().get(i5);
                if (!this.executableBlocks.get(i6)) {
                    i4 = i6;
                }
            }
            if (size == 2 && i4 != -1) {
                block.replaceLastInsn(new PlainInsn(Rops.GOTO, next.getOriginalRopInsn().getPosition(), (RegisterSpec) null, RegisterSpecList.EMPTY));
                block.removeSuccessor(i4);
            }
        }
    }

    private void replaceConstants() {
        for (int i4 = 0; i4 < this.regCount; i4++) {
            if (this.latticeValues[i4] == 1 && (this.latticeConstants[i4] instanceof TypedConstant)) {
                SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
                if (!definitionForRegister.getResult().getTypeBearer().isConstant()) {
                    definitionForRegister.setResult(definitionForRegister.getResult().withType((TypedConstant) this.latticeConstants[i4]));
                    for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(i4)) {
                        if (!ssaInsn.isPhiOrMove()) {
                            NormalSsaInsn normalSsaInsn = (NormalSsaInsn) ssaInsn;
                            RegisterSpecList sources = ssaInsn.getSources();
                            int indexOfRegister = sources.indexOfRegister(i4);
                            normalSsaInsn.changeOneSource(indexOfRegister, sources.get(indexOfRegister).withType((TypedConstant) this.latticeConstants[i4]));
                        }
                    }
                }
            }
        }
    }

    private void run() {
        addBlockToWorklist(this.ssaMeth.getEntryBlock());
        while (true) {
            if (this.cfgWorklist.isEmpty() && this.cfgPhiWorklist.isEmpty() && this.ssaWorklist.isEmpty() && this.varyingWorklist.isEmpty()) {
                replaceConstants();
                replaceBranches();
                return;
            }
            while (!this.cfgWorklist.isEmpty()) {
                simulateBlock(this.cfgWorklist.remove(this.cfgWorklist.size() - 1));
            }
            while (!this.cfgPhiWorklist.isEmpty()) {
                simulatePhiBlock(this.cfgPhiWorklist.remove(this.cfgPhiWorklist.size() - 1));
            }
            while (!this.varyingWorklist.isEmpty()) {
                SsaInsn remove = this.varyingWorklist.remove(this.varyingWorklist.size() - 1);
                if (this.executableBlocks.get(remove.getBlock().getIndex())) {
                    if (remove instanceof PhiInsn) {
                        simulatePhi((PhiInsn) remove);
                    } else {
                        simulateStmt(remove);
                    }
                }
            }
            while (!this.ssaWorklist.isEmpty()) {
                SsaInsn remove2 = this.ssaWorklist.remove(this.ssaWorklist.size() - 1);
                if (this.executableBlocks.get(remove2.getBlock().getIndex())) {
                    if (remove2 instanceof PhiInsn) {
                        simulatePhi((PhiInsn) remove2);
                    } else {
                        simulateStmt(remove2);
                    }
                }
            }
        }
    }

    private boolean setLatticeValueTo(int i4, int i5, Constant constant) {
        if (i5 != 1) {
            int[] iArr = this.latticeValues;
            if (iArr[i4] == i5) {
                return false;
            }
            iArr[i4] = i5;
            return true;
        } else if (this.latticeValues[i4] == i5 && this.latticeConstants[i4].equals(constant)) {
            return false;
        } else {
            this.latticeValues[i4] = i5;
            this.latticeConstants[i4] = constant;
            return true;
        }
    }

    private void simulateBlock(SsaBasicBlock ssaBasicBlock) {
        Iterator<SsaInsn> it = ssaBasicBlock.getInsns().iterator();
        while (it.hasNext()) {
            SsaInsn next = it.next();
            if (next instanceof PhiInsn) {
                simulatePhi((PhiInsn) next);
            } else {
                simulateStmt(next);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
        if (r1 > 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
        if (r1 <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (r1 >= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (r1 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r1 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r1 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
        if (r1 > r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b8, code lost:
        if (r1 <= r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bb, code lost:
        if (r1 >= r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00be, code lost:
        if (r1 < r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c1, code lost:
        if (r1 != r2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
        if (r1 == r2) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.android.dx.rop.cst.Constant[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.android.dx.rop.cst.Constant[]] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void simulateBranch(com.android.dx.ssa.SsaInsn r10) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.ssa.SCCP.simulateBranch(com.android.dx.ssa.SsaInsn):void");
    }

    private Constant simulateMath(SsaInsn ssaInsn, int i4) {
        Constant constant;
        Constant constant2;
        int i5;
        int i6;
        Insn originalRopInsn = ssaInsn.getOriginalRopInsn();
        int opcode = ssaInsn.getOpcode().getOpcode();
        RegisterSpecList sources = ssaInsn.getSources();
        boolean z3 = false;
        int reg = sources.get(0).getReg();
        if (this.latticeValues[reg] != 1) {
            constant = null;
        } else {
            constant = this.latticeConstants[reg];
        }
        if (sources.size() == 1) {
            constant2 = ((CstInsn) originalRopInsn).getConstant();
        } else {
            int reg2 = sources.get(1).getReg();
            if (this.latticeValues[reg2] != 1) {
                constant2 = null;
            } else {
                constant2 = this.latticeConstants[reg2];
            }
        }
        if (constant == null || constant2 == null || i4 != 6) {
            return null;
        }
        int value = ((CstInteger) constant).getValue();
        int value2 = ((CstInteger) constant2).getValue();
        switch (opcode) {
            case 14:
                i5 = value + value2;
                i6 = i5;
                break;
            case 15:
                if (sources.size() == 1) {
                    i6 = value2 - value;
                    break;
                } else {
                    i5 = value - value2;
                    i6 = i5;
                    break;
                }
            case 16:
                i5 = value * value2;
                i6 = i5;
                break;
            case 17:
                if (value2 != 0) {
                    i5 = value / value2;
                    i6 = i5;
                    break;
                }
                i6 = 0;
                z3 = true;
                break;
            case 18:
                if (value2 != 0) {
                    i5 = value % value2;
                    i6 = i5;
                    break;
                }
                i6 = 0;
                z3 = true;
                break;
            case 19:
            default:
                throw new RuntimeException("Unexpected op");
            case 20:
                i6 = value & value2;
                break;
            case 21:
                i6 = value | value2;
                break;
            case 22:
                i6 = value ^ value2;
                break;
            case 23:
                i6 = value << value2;
                break;
            case 24:
                i6 = value >> value2;
                break;
            case 25:
                i6 = value >>> value2;
                break;
        }
        if (z3) {
            return null;
        }
        return CstInteger.make(i6);
    }

    private void simulatePhi(PhiInsn phiInsn) {
        int reg = phiInsn.getResult().getReg();
        int i4 = 2;
        if (this.latticeValues[reg] == 2) {
            return;
        }
        RegisterSpecList sources = phiInsn.getSources();
        int size = sources.size();
        int i5 = 0;
        Constant constant = null;
        int i6 = 0;
        while (true) {
            if (i5 < size) {
                int predBlockIndexForSourcesIndex = phiInsn.predBlockIndexForSourcesIndex(i5);
                int reg2 = sources.get(i5).getReg();
                int i7 = this.latticeValues[reg2];
                if (this.executableBlocks.get(predBlockIndexForSourcesIndex)) {
                    if (i7 == 1) {
                        if (constant == null) {
                            constant = this.latticeConstants[reg2];
                            i6 = 1;
                        } else if (!this.latticeConstants[reg2].equals(constant)) {
                            break;
                        }
                    } else {
                        i4 = i7;
                        break;
                    }
                }
                i5++;
            } else {
                i4 = i6;
                break;
            }
        }
        if (setLatticeValueTo(reg, i4, constant)) {
            addUsersToWorklist(reg, i4);
        }
    }

    private void simulatePhiBlock(SsaBasicBlock ssaBasicBlock) {
        Iterator<SsaInsn> it = ssaBasicBlock.getInsns().iterator();
        while (it.hasNext()) {
            SsaInsn next = it.next();
            if (next instanceof PhiInsn) {
                simulatePhi((PhiInsn) next);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r8 != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void simulateStmt(com.android.dx.ssa.SsaInsn r8) {
        /*
            r7 = this;
            com.android.dx.rop.code.Insn r0 = r8.getOriginalRopInsn()
            com.android.dx.rop.code.Rop r1 = r0.getOpcode()
            int r1 = r1.getBranchingness()
            r2 = 1
            if (r1 != r2) goto L19
            com.android.dx.rop.code.Rop r1 = r0.getOpcode()
            boolean r1 = r1.isCallLike()
            if (r1 == 0) goto L1c
        L19:
            r7.simulateBranch(r8)
        L1c:
            com.android.dx.rop.code.Rop r1 = r8.getOpcode()
            int r1 = r1.getOpcode()
            com.android.dx.rop.code.RegisterSpec r3 = r8.getResult()
            r4 = 0
            if (r3 != 0) goto L4b
            r3 = 17
            if (r1 == r3) goto L35
            r3 = 18
            if (r1 != r3) goto L34
            goto L35
        L34:
            return
        L35:
            com.android.dx.ssa.SsaBasicBlock r3 = r8.getBlock()
            com.android.dx.ssa.SsaBasicBlock r3 = r3.getPrimarySuccessor()
            java.util.ArrayList r3 = r3.getInsns()
            java.lang.Object r3 = r3.get(r4)
            com.android.dx.ssa.SsaInsn r3 = (com.android.dx.ssa.SsaInsn) r3
            com.android.dx.rop.code.RegisterSpec r3 = r3.getResult()
        L4b:
            int r5 = r3.getReg()
            r6 = 2
            if (r1 == r6) goto L7f
            r4 = 5
            if (r1 == r4) goto L78
            r0 = 56
            if (r1 == r0) goto L6b
            switch(r1) {
                case 14: goto L60;
                case 15: goto L60;
                case 16: goto L60;
                case 17: goto L60;
                case 18: goto L60;
                default: goto L5c;
            }
        L5c:
            switch(r1) {
                case 20: goto L60;
                case 21: goto L60;
                case 22: goto L60;
                case 23: goto L60;
                case 24: goto L60;
                case 25: goto L60;
                default: goto L5f;
            }
        L5f:
            goto L9e
        L60:
            int r0 = r3.getBasicType()
            com.android.dx.rop.cst.Constant r8 = r7.simulateMath(r8, r0)
            if (r8 == 0) goto L9f
            goto La0
        L6b:
            int[] r8 = r7.latticeValues
            r8 = r8[r5]
            if (r8 != r2) goto L9e
            com.android.dx.rop.cst.Constant[] r0 = r7.latticeConstants
            r0 = r0[r5]
            r2 = r8
            r8 = r0
            goto La0
        L78:
            com.android.dx.rop.code.CstInsn r0 = (com.android.dx.rop.code.CstInsn) r0
            com.android.dx.rop.cst.Constant r8 = r0.getConstant()
            goto La0
        L7f:
            com.android.dx.rop.code.RegisterSpecList r0 = r8.getSources()
            int r0 = r0.size()
            if (r0 != r2) goto L9e
            com.android.dx.rop.code.RegisterSpecList r8 = r8.getSources()
            com.android.dx.rop.code.RegisterSpec r8 = r8.get(r4)
            int r8 = r8.getReg()
            int[] r0 = r7.latticeValues
            r2 = r0[r8]
            com.android.dx.rop.cst.Constant[] r0 = r7.latticeConstants
            r8 = r0[r8]
            goto La0
        L9e:
            r8 = 0
        L9f:
            r2 = 2
        La0:
            boolean r8 = r7.setLatticeValueTo(r5, r2, r8)
            if (r8 == 0) goto La9
            r7.addUsersToWorklist(r5, r2)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.ssa.SCCP.simulateStmt(com.android.dx.ssa.SsaInsn):void");
    }
}
