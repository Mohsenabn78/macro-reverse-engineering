package com.android.dx.util;

/* loaded from: classes2.dex */
public class MutabilityControl {
    private boolean mutable;

    public MutabilityControl() {
        this.mutable = true;
    }

    public final boolean isImmutable() {
        return !this.mutable;
    }

    public final boolean isMutable() {
        return this.mutable;
    }

    public void setImmutable() {
        this.mutable = false;
    }

    public final void throwIfImmutable() {
        if (this.mutable) {
            return;
        }
        throw new MutabilityException("immutable instance");
    }

    public final void throwIfMutable() {
        if (!this.mutable) {
            return;
        }
        throw new MutabilityException("mutable instance");
    }

    public MutabilityControl(boolean z3) {
        this.mutable = z3;
    }
}
