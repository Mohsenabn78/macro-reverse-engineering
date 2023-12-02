package com.android.dx.ssa.back;

import com.android.dx.ssa.SetFactory;
import com.android.dx.util.IntSet;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class InterferenceGraph {
    private final ArrayList<IntSet> interference;

    public InterferenceGraph(int i4) {
        this.interference = new ArrayList<>(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            this.interference.add(SetFactory.makeInterferenceSet(i4));
        }
    }

    private void ensureCapacity(int i4) {
        this.interference.ensureCapacity(i4);
        for (int size = this.interference.size(); size < i4; size++) {
            this.interference.add(SetFactory.makeInterferenceSet(i4));
        }
    }

    public void add(int i4, int i5) {
        ensureCapacity(Math.max(i4, i5) + 1);
        this.interference.get(i4).add(i5);
        this.interference.get(i5).add(i4);
    }

    public void dumpToStdout() {
        int size = this.interference.size();
        for (int i4 = 0; i4 < size; i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Reg " + i4 + ":" + this.interference.get(i4).toString());
            System.out.println(sb.toString());
        }
    }

    public void mergeInterferenceSet(int i4, IntSet intSet) {
        if (i4 < this.interference.size()) {
            intSet.merge(this.interference.get(i4));
        }
    }
}
