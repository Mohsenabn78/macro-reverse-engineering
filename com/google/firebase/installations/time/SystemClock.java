package com.google.firebase.installations.time;

/* loaded from: classes5.dex */
public class SystemClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private static SystemClock f31598a;

    private SystemClock() {
    }

    public static SystemClock getInstance() {
        if (f31598a == null) {
            f31598a = new SystemClock();
        }
        return f31598a;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
