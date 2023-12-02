package com.arlosoft.macrodroid.events;

import de.greenrobot.event.EventBus;

/* loaded from: classes3.dex */
public class EventBusUtils {

    /* renamed from: a  reason: collision with root package name */
    private static EventBus f11983a;

    public static EventBus getEventBus() {
        if (f11983a == null) {
            synchronized (EventBus.class) {
                if (f11983a == null) {
                    f11983a = EventBus.builder().logNoSubscriberMessages(false).logSubscriberExceptions(false).build();
                }
            }
        }
        return f11983a;
    }
}
