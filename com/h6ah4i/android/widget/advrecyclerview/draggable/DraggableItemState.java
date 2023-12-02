package com.h6ah4i.android.widget.advrecyclerview.draggable;

/* loaded from: classes6.dex */
public class DraggableItemState {

    /* renamed from: a  reason: collision with root package name */
    private int f33730a;

    public int getFlags() {
        return this.f33730a;
    }

    public boolean isActive() {
        if ((this.f33730a & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isDragging() {
        if ((this.f33730a & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isInRange() {
        if ((this.f33730a & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isUpdated() {
        if ((this.f33730a & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public void setFlags(int i4) {
        this.f33730a = i4;
    }
}
