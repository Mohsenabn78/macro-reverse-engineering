package com.koushikdutta.async;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class SelectorWrapper {

    /* renamed from: a  reason: collision with root package name */
    private Selector f34822a;

    /* renamed from: b  reason: collision with root package name */
    boolean f34823b;

    /* renamed from: c  reason: collision with root package name */
    Semaphore f34824c = new Semaphore(0);

    public SelectorWrapper(Selector selector) {
        this.f34822a = selector;
    }

    public void close() throws IOException {
        this.f34822a.close();
    }

    public Selector getSelector() {
        return this.f34822a;
    }

    public boolean isOpen() {
        return this.f34822a.isOpen();
    }

    public Set<SelectionKey> keys() {
        return this.f34822a.keys();
    }

    public void select() throws IOException {
        select(0L);
    }

    public int selectNow() throws IOException {
        return this.f34822a.selectNow();
    }

    public Set<SelectionKey> selectedKeys() {
        return this.f34822a.selectedKeys();
    }

    public void wakeupOnce() {
        boolean z3 = !this.f34824c.tryAcquire();
        this.f34822a.wakeup();
        if (z3) {
            return;
        }
        synchronized (this) {
            if (this.f34823b) {
                return;
            }
            this.f34823b = true;
            for (int i4 = 0; i4 < 100; i4++) {
                try {
                    try {
                        if (this.f34824c.tryAcquire(10L, TimeUnit.MILLISECONDS)) {
                            synchronized (this) {
                                this.f34823b = false;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f34823b = false;
                            throw th;
                        }
                    }
                } catch (InterruptedException unused) {
                }
                this.f34822a.wakeup();
            }
            synchronized (this) {
                this.f34823b = false;
            }
        }
    }

    public void select(long j4) throws IOException {
        try {
            this.f34824c.drainPermits();
            this.f34822a.select(j4);
        } finally {
            this.f34824c.release(Integer.MAX_VALUE);
        }
    }
}
