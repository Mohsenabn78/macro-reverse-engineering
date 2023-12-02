package com.arlosoft.macrodroid.events;

/* loaded from: classes3.dex */
public class CategoryEnabledStateChangeEvent {
    public final String category;
    public final boolean enable;

    public CategoryEnabledStateChangeEvent(String str, boolean z3) {
        this.category = str;
        this.enable = z3;
    }
}
