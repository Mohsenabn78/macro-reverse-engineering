package com.android.dx.cf.code;

import com.android.dx.util.IntList;
import com.android.dx.util.MutabilityControl;

/* loaded from: classes2.dex */
public final class SwitchList extends MutabilityControl {
    private int size;
    private final IntList targets;
    private final IntList values;

    public SwitchList(int i4) {
        super(true);
        this.values = new IntList(i4);
        this.targets = new IntList(i4 + 1);
        this.size = i4;
    }

    public void add(int i4, int i5) {
        throwIfImmutable();
        if (i5 >= 0) {
            this.values.add(i4);
            this.targets.add(i5);
            return;
        }
        throw new IllegalArgumentException("target < 0");
    }

    public int getDefaultTarget() {
        return this.targets.get(this.size);
    }

    public int getTarget(int i4) {
        return this.targets.get(i4);
    }

    public IntList getTargets() {
        return this.targets;
    }

    public int getValue(int i4) {
        return this.values.get(i4);
    }

    public IntList getValues() {
        return this.values;
    }

    public void removeSuperfluousDefaults() {
        throwIfImmutable();
        int i4 = this.size;
        if (i4 == this.targets.size() - 1) {
            int i5 = this.targets.get(i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = this.targets.get(i7);
                if (i8 != i5) {
                    if (i7 != i6) {
                        this.targets.set(i6, i8);
                        IntList intList = this.values;
                        intList.set(i6, intList.get(i7));
                    }
                    i6++;
                }
            }
            if (i6 != i4) {
                this.values.shrink(i6);
                this.targets.set(i6, i5);
                this.targets.shrink(i6 + 1);
                this.size = i6;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("incomplete instance");
    }

    public void setDefaultTarget(int i4) {
        throwIfImmutable();
        if (i4 >= 0) {
            if (this.targets.size() == this.size) {
                this.targets.add(i4);
                return;
            }
            throw new RuntimeException("non-default elements not all set");
        }
        throw new IllegalArgumentException("target < 0");
    }

    @Override // com.android.dx.util.MutabilityControl
    public void setImmutable() {
        this.values.setImmutable();
        this.targets.setImmutable();
        super.setImmutable();
    }

    public int size() {
        return this.size;
    }
}
