package com.android.dx.dex.code;

import com.android.dx.dex.DexOptions;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class OutputCollector {
    private final OutputFinisher finisher;
    private ArrayList<DalvInsn> suffix;

    public OutputCollector(DexOptions dexOptions, int i4, int i5, int i6, int i7) {
        this.finisher = new OutputFinisher(dexOptions, i4, i6, i7);
        this.suffix = new ArrayList<>(i5);
    }

    private void appendSuffixToOutput() {
        int size = this.suffix.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.finisher.add(this.suffix.get(i4));
        }
        this.suffix = null;
    }

    public void add(DalvInsn dalvInsn) {
        this.finisher.add(dalvInsn);
    }

    public void addSuffix(DalvInsn dalvInsn) {
        this.suffix.add(dalvInsn);
    }

    public OutputFinisher getFinisher() {
        if (this.suffix != null) {
            appendSuffixToOutput();
            return this.finisher;
        }
        throw new UnsupportedOperationException("already processed");
    }

    public void reverseBranch(int i4, CodeAddress codeAddress) {
        this.finisher.reverseBranch(i4, codeAddress);
    }
}
