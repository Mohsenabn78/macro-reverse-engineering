package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;

@Beta
/* loaded from: classes5.dex */
public class MockSleeper implements Sleeper {

    /* renamed from: a  reason: collision with root package name */
    private int f26053a;

    /* renamed from: b  reason: collision with root package name */
    private long f26054b;

    public final int getCount() {
        return this.f26053a;
    }

    public final long getLastMillis() {
        return this.f26054b;
    }

    @Override // com.google.api.client.util.Sleeper
    public void sleep(long j4) throws InterruptedException {
        this.f26053a++;
        this.f26054b = j4;
    }
}
