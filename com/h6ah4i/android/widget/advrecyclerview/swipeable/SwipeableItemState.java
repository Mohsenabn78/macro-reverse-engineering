package com.h6ah4i.android.widget.advrecyclerview.swipeable;

/* loaded from: classes6.dex */
public class SwipeableItemState {

    /* renamed from: a  reason: collision with root package name */
    private int f33954a;

    public int getFlags() {
        return this.f33954a;
    }

    public boolean isActive() {
        if ((this.f33954a & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isSwiping() {
        if ((this.f33954a & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isUpdated() {
        if ((this.f33954a & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public void setFlags(int i4) {
        this.f33954a = i4;
    }
}
