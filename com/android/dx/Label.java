package com.android.dx;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Label {
    Label alternateSuccessor;
    Code code;
    Label primarySuccessor;
    final List<Insn> instructions = new ArrayList();
    boolean marked = false;
    List<Label> catchLabels = Collections.emptyList();
    int id = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void compact() {
        for (int i4 = 0; i4 < this.catchLabels.size(); i4++) {
            while (this.catchLabels.get(i4).isEmpty()) {
                List<Label> list = this.catchLabels;
                list.set(i4, list.get(i4).primarySuccessor);
            }
        }
        while (true) {
            Label label = this.primarySuccessor;
            if (label == null || !label.isEmpty()) {
                break;
            }
            this.primarySuccessor = this.primarySuccessor.primarySuccessor;
        }
        while (true) {
            Label label2 = this.alternateSuccessor;
            if (label2 != null && label2.isEmpty()) {
                this.alternateSuccessor = this.alternateSuccessor.primarySuccessor;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.instructions.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicBlock toBasicBlock() {
        int i4;
        InsnList insnList = new InsnList(this.instructions.size());
        for (int i5 = 0; i5 < this.instructions.size(); i5++) {
            insnList.set(i5, this.instructions.get(i5));
        }
        insnList.setImmutable();
        IntList intList = new IntList();
        for (Label label : this.catchLabels) {
            intList.add(label.id);
        }
        Label label2 = this.primarySuccessor;
        if (label2 != null) {
            i4 = label2.id;
            intList.add(i4);
        } else {
            i4 = -1;
        }
        Label label3 = this.alternateSuccessor;
        if (label3 != null) {
            intList.add(label3.id);
        }
        intList.setImmutable();
        return new BasicBlock(this.id, insnList, intList, i4);
    }
}
