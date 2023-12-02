package com.google.api.client.testing.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.concurrent.atomic.AtomicLong;

@Beta
/* loaded from: classes5.dex */
public class FixedClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private AtomicLong f26013a;

    public FixedClock() {
        this(0L);
    }

    @Override // com.google.api.client.util.Clock
    public long currentTimeMillis() {
        return this.f26013a.get();
    }

    public FixedClock setTime(long j4) {
        this.f26013a.set(j4);
        return this;
    }

    public FixedClock(long j4) {
        this.f26013a = new AtomicLong(j4);
    }
}
