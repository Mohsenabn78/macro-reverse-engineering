package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class TestClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f18944a;

    public TestClock(long j4) {
        this.f18944a = new AtomicLong(j4);
    }

    public void advance(long j4) {
        if (j4 >= 0) {
            this.f18944a.addAndGet(j4);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.f18944a.get();
    }

    public void tick() {
        advance(1L);
    }
}
