package com.h6ah4i.android.widget.advrecyclerview.expandable;

/* loaded from: classes6.dex */
public class ExpandableItemState {

    /* renamed from: a  reason: collision with root package name */
    private int f33858a;

    public int getFlags() {
        return this.f33858a;
    }

    public boolean hasExpandedStateChanged() {
        if ((this.f33858a & 8) != 0) {
            return true;
        }
        return false;
    }

    public boolean isChild() {
        if ((this.f33858a & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isExpanded() {
        if ((this.f33858a & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isGroup() {
        if ((this.f33858a & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isSwiping() {
        if ((this.f33858a & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isUpdated() {
        if ((this.f33858a & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public void setFlags(int i4) {
        this.f33858a = i4;
    }
}
