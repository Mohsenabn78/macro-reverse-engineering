package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class ItemDraggableRange {

    /* renamed from: a  reason: collision with root package name */
    private final int f33731a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33732b;

    public ItemDraggableRange(int i4, int i5) {
        if (i4 <= i5) {
            this.f33731a = i4;
            this.f33732b = i5;
            return;
        }
        throw new IllegalArgumentException("end position (= " + i5 + ") is smaller than start position (=" + i4 + ")");
    }

    @NonNull
    protected String a() {
        return "ItemDraggableRange";
    }

    public boolean checkInRange(int i4) {
        if (i4 >= this.f33731a && i4 <= this.f33732b) {
            return true;
        }
        return false;
    }

    public int getEnd() {
        return this.f33732b;
    }

    public int getStart() {
        return this.f33731a;
    }

    @NonNull
    public String toString() {
        return a() + "{mStart=" + this.f33731a + ", mEnd=" + this.f33732b + '}';
    }
}
