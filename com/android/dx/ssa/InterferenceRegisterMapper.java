package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.ssa.back.InterferenceGraph;
import com.android.dx.util.BitIntSet;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class InterferenceRegisterMapper extends BasicRegisterMapper {
    private final ArrayList<BitIntSet> newRegInterference;
    private final InterferenceGraph oldRegInterference;

    public InterferenceRegisterMapper(InterferenceGraph interferenceGraph, int i4) {
        super(i4);
        this.newRegInterference = new ArrayList<>();
        this.oldRegInterference = interferenceGraph;
    }

    private void addInterfence(int i4, int i5) {
        int i6 = i4 + 1;
        this.newRegInterference.ensureCapacity(i6);
        while (i4 >= this.newRegInterference.size()) {
            this.newRegInterference.add(new BitIntSet(i6));
        }
        this.oldRegInterference.mergeInterferenceSet(i5, this.newRegInterference.get(i4));
    }

    @Override // com.android.dx.ssa.BasicRegisterMapper
    public void addMapping(int i4, int i5, int i6) {
        super.addMapping(i4, i5, i6);
        addInterfence(i5, i4);
        if (i6 == 2) {
            addInterfence(i5 + 1, i4);
        }
    }

    public boolean areAnyPinned(RegisterSpecList registerSpecList, int i4, int i5) {
        int size = registerSpecList.size();
        for (int i6 = 0; i6 < size; i6++) {
            RegisterSpec registerSpec = registerSpecList.get(i6);
            int oldToNew = oldToNew(registerSpec.getReg());
            if (oldToNew != i4) {
                if (registerSpec.getCategory() != 2 || oldToNew + 1 != i4) {
                    if (i5 == 2 && oldToNew == i4 + 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean interferes(int i4, int i5, int i6) {
        BitIntSet bitIntSet;
        if (i5 < this.newRegInterference.size() && (bitIntSet = this.newRegInterference.get(i5)) != null) {
            if (i6 == 1) {
                return bitIntSet.has(i4);
            }
            return bitIntSet.has(i4) || interferes(i4, i5 + 1, i6 - 1);
        }
        return false;
    }

    public boolean interferes(RegisterSpec registerSpec, int i4) {
        return interferes(registerSpec.getReg(), i4, registerSpec.getCategory());
    }
}
