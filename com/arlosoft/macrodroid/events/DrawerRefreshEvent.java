package com.arlosoft.macrodroid.events;

/* loaded from: classes3.dex */
public class DrawerRefreshEvent {
    public static final int EVENT_TYPE_ADD = 1;
    public static final int EVENT_TYPE_UPDATE = 0;
    public int eventType;

    public DrawerRefreshEvent(int i4) {
        this.eventType = i4;
    }
}
