package com.android.dx.rop.code;

import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledItem;

/* loaded from: classes2.dex */
public final class BasicBlock implements LabeledItem {
    private final InsnList insns;
    private final int label;
    private final int primarySuccessor;
    private final IntList successors;

    /* loaded from: classes2.dex */
    public interface Visitor {
        void visitBlock(BasicBlock basicBlock);
    }

    public BasicBlock(int i4, InsnList insnList, IntList intList, int i5) {
        if (i4 >= 0) {
            try {
                insnList.throwIfMutable();
                int size = insnList.size();
                if (size != 0) {
                    for (int i6 = size - 2; i6 >= 0; i6--) {
                        if (insnList.get(i6).getOpcode().getBranchingness() != 1) {
                            throw new IllegalArgumentException("insns[" + i6 + "] is a branch or can throw");
                        }
                    }
                    if (insnList.get(size - 1).getOpcode().getBranchingness() != 1) {
                        try {
                            intList.throwIfMutable();
                            if (i5 >= -1) {
                                if (i5 >= 0 && !intList.contains(i5)) {
                                    throw new IllegalArgumentException("primarySuccessor " + i5 + " not in successors " + intList);
                                }
                                this.label = i4;
                                this.insns = insnList;
                                this.successors = intList;
                                this.primarySuccessor = i5;
                                return;
                            }
                            throw new IllegalArgumentException("primarySuccessor < -1");
                        } catch (NullPointerException unused) {
                            throw new NullPointerException("successors == null");
                        }
                    }
                    throw new IllegalArgumentException("insns does not end with a branch or throwing instruction");
                }
                throw new IllegalArgumentException("insns.size() == 0");
            } catch (NullPointerException unused2) {
                throw new NullPointerException("insns == null");
            }
        }
        throw new IllegalArgumentException("label < 0");
    }

    public boolean canThrow() {
        return this.insns.getLast().canThrow();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }

    public TypeList getExceptionHandlerTypes() {
        return this.insns.getLast().getCatches();
    }

    public Insn getFirstInsn() {
        return this.insns.get(0);
    }

    public InsnList getInsns() {
        return this.insns;
    }

    @Override // com.android.dx.util.LabeledItem
    public int getLabel() {
        return this.label;
    }

    public Insn getLastInsn() {
        return this.insns.getLast();
    }

    public int getPrimarySuccessor() {
        return this.primarySuccessor;
    }

    public int getSecondarySuccessor() {
        if (this.successors.size() == 2) {
            int i4 = this.successors.get(0);
            if (i4 == this.primarySuccessor) {
                return this.successors.get(1);
            }
            return i4;
        }
        throw new UnsupportedOperationException("block doesn't have exactly two successors");
    }

    public IntList getSuccessors() {
        return this.successors;
    }

    public boolean hasExceptionHandlers() {
        if (this.insns.getLast().getCatches().size() != 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        return '{' + Hex.u2(this.label) + '}';
    }

    public BasicBlock withRegisterOffset(int i4) {
        return new BasicBlock(this.label, this.insns.withRegisterOffset(i4), this.successors, this.primarySuccessor);
    }
}
