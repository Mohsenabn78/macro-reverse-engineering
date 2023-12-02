package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.ssa.SsaInsn;

/* loaded from: classes2.dex */
public final class NormalSsaInsn extends SsaInsn {
    private Insn insn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NormalSsaInsn(Insn insn, SsaBasicBlock ssaBasicBlock) {
        super(insn.getResult(), ssaBasicBlock);
        this.insn = insn;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public void accept(SsaInsn.Visitor visitor) {
        if (isNormalMoveInsn()) {
            visitor.visitMoveInsn(this);
        } else {
            visitor.visitNonMoveInsn(this);
        }
    }

    @Override // com.android.dx.ssa.SsaInsn
    public boolean canThrow() {
        return this.insn.canThrow();
    }

    public final void changeOneSource(int i4, RegisterSpec registerSpec) {
        RegisterSpec registerSpec2;
        RegisterSpecList sources = this.insn.getSources();
        int size = sources.size();
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 == i4) {
                registerSpec2 = registerSpec;
            } else {
                registerSpec2 = sources.get(i5);
            }
            registerSpecList.set(i5, registerSpec2);
        }
        registerSpecList.setImmutable();
        RegisterSpec registerSpec3 = sources.get(i4);
        if (registerSpec3.getReg() != registerSpec.getReg()) {
            getBlock().getParent().onSourceChanged(this, registerSpec3, registerSpec);
        }
        this.insn = this.insn.withNewRegisters(getResult(), registerSpecList);
    }

    @Override // com.android.dx.ssa.SsaInsn
    public RegisterSpec getLocalAssignment() {
        RegisterSpec result;
        if (this.insn.getOpcode().getOpcode() == 54) {
            result = this.insn.getSources().get(0);
        } else {
            result = getResult();
        }
        if (result == null || result.getLocalItem() == null) {
            return null;
        }
        return result;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public Rop getOpcode() {
        return this.insn.getOpcode();
    }

    @Override // com.android.dx.ssa.SsaInsn
    public Insn getOriginalRopInsn() {
        return this.insn;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public RegisterSpecList getSources() {
        return this.insn.getSources();
    }

    @Override // com.android.dx.ssa.SsaInsn
    public boolean hasSideEffect() {
        boolean z3;
        Rop opcode = getOpcode();
        if (opcode.getBranchingness() != 1) {
            return true;
        }
        if (Optimizer.getPreserveLocals() && getLocalAssignment() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        int opcode2 = opcode.getOpcode();
        if (opcode2 != 2 && opcode2 != 5 && opcode2 != 55) {
            return true;
        }
        return z3;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public boolean isMoveException() {
        if (this.insn.getOpcode().getOpcode() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public boolean isNormalMoveInsn() {
        if (this.insn.getOpcode().getOpcode() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.ssa.SsaInsn
    public boolean isPhiOrMove() {
        return isNormalMoveInsn();
    }

    @Override // com.android.dx.ssa.SsaInsn
    public final void mapSourceRegisters(RegisterMapper registerMapper) {
        RegisterSpecList sources = this.insn.getSources();
        RegisterSpecList map = registerMapper.map(sources);
        if (map != sources) {
            this.insn = this.insn.withNewRegisters(getResult(), map);
            getBlock().getParent().onSourcesChanged(this, sources);
        }
    }

    public final void setNewSources(RegisterSpecList registerSpecList) {
        if (this.insn.getSources().size() == registerSpecList.size()) {
            this.insn = this.insn.withNewRegisters(getResult(), registerSpecList);
            return;
        }
        throw new RuntimeException("Sources counts don't match");
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return toRopInsn().toHuman();
    }

    @Override // com.android.dx.ssa.SsaInsn
    public Insn toRopInsn() {
        return this.insn.withNewRegisters(getResult(), this.insn.getSources());
    }

    public void upgradeToLiteral() {
        RegisterSpecList sources = this.insn.getSources();
        this.insn = this.insn.withSourceLiteral();
        getBlock().getParent().onSourcesChanged(this, sources);
    }

    @Override // com.android.dx.ssa.SsaInsn
    /* renamed from: clone */
    public NormalSsaInsn mo4142clone() {
        return (NormalSsaInsn) super.mo4142clone();
    }
}
