package com.koushikdutta.async.http.spdy;

import java.util.concurrent.CountDownLatch;

/* compiled from: Ping.java */
/* loaded from: classes6.dex */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f35593a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f35594b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f35595c = -1;

    i() {
    }

    public void a() {
        if (this.f35595c == -1 && this.f35594b != -1) {
            this.f35595c = System.nanoTime();
            this.f35593a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f35594b == -1) {
            this.f35594b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
