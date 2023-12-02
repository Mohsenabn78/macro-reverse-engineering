package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.Date;

/* loaded from: classes5.dex */
public class ExponentialBackoff {
    public static final double DEFAULT_BACKOFF_FACTOR = 1.5d;
    public static final long DEFAULT_BACKOFF_INITIAL_DELAY_MS = 1000;
    public static final long DEFAULT_BACKOFF_MAX_DELAY_MS = 60000;

    /* renamed from: a  reason: collision with root package name */
    private final AsyncQueue f31286a;

    /* renamed from: b  reason: collision with root package name */
    private final AsyncQueue.TimerId f31287b;

    /* renamed from: c  reason: collision with root package name */
    private final long f31288c;

    /* renamed from: d  reason: collision with root package name */
    private final double f31289d;

    /* renamed from: e  reason: collision with root package name */
    private final long f31290e;

    /* renamed from: f  reason: collision with root package name */
    private long f31291f;

    /* renamed from: g  reason: collision with root package name */
    private long f31292g;

    /* renamed from: h  reason: collision with root package name */
    private long f31293h;

    /* renamed from: i  reason: collision with root package name */
    private AsyncQueue.DelayedTask f31294i;

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, long j4, double d4, long j5) {
        this.f31286a = asyncQueue;
        this.f31287b = timerId;
        this.f31288c = j4;
        this.f31289d = d4;
        this.f31290e = j5;
        this.f31291f = j5;
        this.f31293h = new Date().getTime();
        reset();
    }

    private long b() {
        return (long) ((Math.random() - 0.5d) * this.f31292g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        this.f31293h = new Date().getTime();
        runnable.run();
    }

    public void backoffAndRun(final Runnable runnable) {
        cancel();
        long b4 = this.f31292g + b();
        long max = Math.max(0L, new Date().getTime() - this.f31293h);
        long max2 = Math.max(0L, b4 - max);
        if (this.f31292g > 0) {
            Logger.debug(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(this.f31292g), Long.valueOf(b4), Long.valueOf(max));
        }
        this.f31294i = this.f31286a.enqueueAfterDelay(this.f31287b, max2, new Runnable() { // from class: com.google.firebase.firestore.util.m
            @Override // java.lang.Runnable
            public final void run() {
                ExponentialBackoff.this.c(runnable);
            }
        });
        long j4 = (long) (this.f31292g * this.f31289d);
        this.f31292g = j4;
        long j5 = this.f31288c;
        if (j4 < j5) {
            this.f31292g = j5;
        } else {
            long j6 = this.f31291f;
            if (j4 > j6) {
                this.f31292g = j6;
            }
        }
        this.f31291f = this.f31290e;
    }

    public void cancel() {
        AsyncQueue.DelayedTask delayedTask = this.f31294i;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.f31294i = null;
        }
    }

    public void reset() {
        this.f31292g = 0L;
    }

    public void resetToMax() {
        this.f31292g = this.f31291f;
    }

    public void setTemporaryMaxDelay(long j4) {
        this.f31291f = j4;
    }

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        this(asyncQueue, timerId, 1000L, 1.5d, DEFAULT_BACKOFF_MAX_DELAY_MS);
    }
}
