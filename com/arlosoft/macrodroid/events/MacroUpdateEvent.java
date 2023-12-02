package com.arlosoft.macrodroid.events;

/* loaded from: classes3.dex */
public class MacroUpdateEvent {
    public static final int ADD = 0;
    public static final int DELETE = 1;
    public static final int MOVE = 2;
    public static final int NO_POSITION = -1;
    public static final int UPDATED = 3;
    public final int eventType;
    public final int itemType;
    public final int position1;
    public final int position2;

    public MacroUpdateEvent(int i4, int i5, int i6, int i7) {
        this.eventType = i4;
        this.itemType = i5;
        this.position1 = i6;
        this.position2 = i7;
    }
}
