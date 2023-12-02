package com.arlosoft.macrodroid.events;

import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;

/* loaded from: classes3.dex */
public class DrawerHandleUpdateEvent {

    /* renamed from: a  reason: collision with root package name */
    private DrawerConfiguration f11982a;

    public DrawerHandleUpdateEvent(DrawerConfiguration drawerConfiguration) {
        this.f11982a = drawerConfiguration;
    }

    public DrawerConfiguration getDrawerConfiguration() {
        return this.f11982a;
    }
}
