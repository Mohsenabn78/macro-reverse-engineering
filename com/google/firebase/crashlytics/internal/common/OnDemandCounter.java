package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class OnDemandCounter {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f29536a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f29537b = new AtomicInteger();

    public int getDroppedOnDemandExceptions() {
        return this.f29537b.get();
    }

    public int getRecordedOnDemandExceptions() {
        return this.f29536a.get();
    }

    public void incrementDroppedOnDemandExceptions() {
        this.f29537b.getAndIncrement();
    }

    public void incrementRecordedOnDemandExceptions() {
        this.f29536a.getAndIncrement();
    }

    public void resetDroppedOnDemandExceptions() {
        this.f29537b.set(0);
    }
}
