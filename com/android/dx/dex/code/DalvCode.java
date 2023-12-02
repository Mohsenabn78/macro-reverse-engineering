package com.android.dx.dex.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Type;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class DalvCode {
    private CatchTable catches;
    private DalvInsnList insns;
    private LocalList locals;
    private final int positionInfo;
    private PositionList positions;
    private CatchBuilder unprocessedCatches;
    private OutputFinisher unprocessedInsns;

    /* loaded from: classes2.dex */
    public interface AssignIndicesCallback {
        int getIndex(Constant constant);
    }

    public DalvCode(int i4, OutputFinisher outputFinisher, CatchBuilder catchBuilder) {
        if (outputFinisher != null) {
            if (catchBuilder != null) {
                this.positionInfo = i4;
                this.unprocessedInsns = outputFinisher;
                this.unprocessedCatches = catchBuilder;
                this.catches = null;
                this.positions = null;
                this.locals = null;
                this.insns = null;
                return;
            }
            throw new NullPointerException("unprocessedCatches == null");
        }
        throw new NullPointerException("unprocessedInsns == null");
    }

    private void finishProcessingIfNecessary() {
        if (this.insns != null) {
            return;
        }
        DalvInsnList finishProcessingAndGetList = this.unprocessedInsns.finishProcessingAndGetList();
        this.insns = finishProcessingAndGetList;
        this.positions = PositionList.make(finishProcessingAndGetList, this.positionInfo);
        this.locals = LocalList.make(this.insns);
        this.catches = this.unprocessedCatches.build();
        this.unprocessedInsns = null;
        this.unprocessedCatches = null;
    }

    public void assignIndices(AssignIndicesCallback assignIndicesCallback) {
        this.unprocessedInsns.assignIndices(assignIndicesCallback);
    }

    public HashSet<Type> getCatchTypes() {
        return this.unprocessedCatches.getCatchTypes();
    }

    public CatchTable getCatches() {
        finishProcessingIfNecessary();
        return this.catches;
    }

    public HashSet<Constant> getInsnConstants() {
        return this.unprocessedInsns.getAllConstants();
    }

    public DalvInsnList getInsns() {
        finishProcessingIfNecessary();
        return this.insns;
    }

    public LocalList getLocals() {
        finishProcessingIfNecessary();
        return this.locals;
    }

    public PositionList getPositions() {
        finishProcessingIfNecessary();
        return this.positions;
    }

    public boolean hasAnyCatches() {
        return this.unprocessedCatches.hasAnyCatches();
    }

    public boolean hasLocals() {
        return this.unprocessedInsns.hasAnyLocalInfo();
    }

    public boolean hasPositions() {
        if (this.positionInfo != 1 && this.unprocessedInsns.hasAnyPositionInfo()) {
            return true;
        }
        return false;
    }
}
