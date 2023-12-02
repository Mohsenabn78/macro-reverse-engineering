package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes5.dex */
public abstract class RateLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final SleepingStopwatch f28562a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f28563b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class SleepingStopwatch {
        protected SleepingStopwatch() {
        }

        public static SleepingStopwatch a() {
            return new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1

                /* renamed from: a  reason: collision with root package name */
                final Stopwatch f28564a = Stopwatch.createStarted();

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected long b() {
                    return this.f28564a.elapsed(TimeUnit.MICROSECONDS);
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected void c(long j4) {
                    if (j4 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j4, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        protected abstract long b();

        protected abstract void c(long j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.f28562a = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    private boolean a(long j4, long j5) {
        if (h(j4) - j5 <= j4) {
            return true;
        }
        return false;
    }

    private static void b(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Requested permits (%s) must be positive", i4);
    }

    @VisibleForTesting
    static RateLimiter c(double d4, long j4, TimeUnit timeUnit, double d5, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j4, timeUnit, d5);
        smoothWarmingUp.setRate(d4);
        return smoothWarmingUp;
    }

    public static RateLimiter create(double d4) {
        return d(d4, SleepingStopwatch.a());
    }

    @VisibleForTesting
    static RateLimiter d(double d4, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d4);
        return smoothBursty;
    }

    private Object g() {
        Object obj = this.f28563b;
        if (obj == null) {
            synchronized (this) {
                obj = this.f28563b;
                if (obj == null) {
                    obj = new Object();
                    this.f28563b = obj;
                }
            }
        }
        return obj;
    }

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    abstract double e();

    abstract void f(double d4, long j4);

    public final double getRate() {
        double e4;
        synchronized (g()) {
            e4 = e();
        }
        return e4;
    }

    abstract long h(long j4);

    final long i(int i4) {
        long j4;
        b(i4);
        synchronized (g()) {
            j4 = j(i4, this.f28562a.b());
        }
        return j4;
    }

    final long j(int i4, long j4) {
        return Math.max(k(i4, j4) - j4, 0L);
    }

    abstract long k(int i4, long j4);

    public final void setRate(double d4) {
        boolean z3;
        if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && !Double.isNaN(d4)) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "rate must be positive");
        synchronized (g()) {
            f(d4, this.f28562a.b());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(long j4, TimeUnit timeUnit) {
        return tryAcquire(1, j4, timeUnit);
    }

    public static RateLimiter create(double d4, long j4, TimeUnit timeUnit) {
        Preconditions.checkArgument(j4 >= 0, "warmupPeriod must not be negative: %s", j4);
        return c(d4, j4, timeUnit, 3.0d, SleepingStopwatch.a());
    }

    @CanIgnoreReturnValue
    public double acquire(int i4) {
        long i5 = i(i4);
        this.f28562a.c(i5);
        return (i5 * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public boolean tryAcquire(int i4) {
        return tryAcquire(i4, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i4, long j4, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j4), 0L);
        b(i4);
        synchronized (g()) {
            long b4 = this.f28562a.b();
            if (a(b4, max)) {
                this.f28562a.c(j(i4, b4));
                return true;
            }
            return false;
        }
    }
}
