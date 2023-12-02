package com.facebook.stetho.common;

/* loaded from: classes3.dex */
public interface ThreadBound {
    boolean checkThreadAccess();

    <V> V postAndWait(UncheckedCallable<V> uncheckedCallable);

    void postAndWait(Runnable runnable);

    void postDelayed(Runnable runnable, long j4);

    void removeCallbacks(Runnable runnable);

    void verifyThreadAccess();
}
