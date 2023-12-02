package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class SmoothRateLimiter extends RateLimiter {

    /* renamed from: c  reason: collision with root package name */
    double f28607c;

    /* renamed from: d  reason: collision with root package name */
    double f28608d;

    /* renamed from: e  reason: collision with root package name */
    double f28609e;

    /* renamed from: f  reason: collision with root package name */
    private long f28610f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SmoothBursty extends SmoothRateLimiter {

        /* renamed from: g  reason: collision with root package name */
        final double f28611g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d4) {
            super(sleepingStopwatch);
            this.f28611g = d4;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double l() {
            return this.f28609e;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void m(double d4, double d5) {
            double d6 = this.f28608d;
            double d7 = this.f28611g * d4;
            this.f28608d = d7;
            if (d6 == Double.POSITIVE_INFINITY) {
                this.f28607c = d7;
                return;
            }
            double d8 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (d6 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d8 = (this.f28607c * d7) / d6;
            }
            this.f28607c = d8;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long o(double d4, double d5) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SmoothWarmingUp extends SmoothRateLimiter {

        /* renamed from: g  reason: collision with root package name */
        private final long f28612g;

        /* renamed from: h  reason: collision with root package name */
        private double f28613h;

        /* renamed from: i  reason: collision with root package name */
        private double f28614i;

        /* renamed from: j  reason: collision with root package name */
        private double f28615j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j4, TimeUnit timeUnit, double d4) {
            super(sleepingStopwatch);
            this.f28612g = timeUnit.toMicros(j4);
            this.f28615j = d4;
        }

        private double p(double d4) {
            return this.f28609e + (d4 * this.f28613h);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double l() {
            return this.f28612g / this.f28608d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void m(double d4, double d5) {
            double d6 = this.f28608d;
            double d7 = this.f28615j * d5;
            long j4 = this.f28612g;
            double d8 = (j4 * 0.5d) / d5;
            this.f28614i = d8;
            double d9 = ((j4 * 2.0d) / (d5 + d7)) + d8;
            this.f28608d = d9;
            this.f28613h = (d7 - d5) / (d9 - d8);
            if (d6 == Double.POSITIVE_INFINITY) {
                this.f28607c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                return;
            }
            if (d6 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d9 = (this.f28607c * d9) / d6;
            }
            this.f28607c = d9;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long o(double d4, double d5) {
            long j4;
            double d6 = d4 - this.f28614i;
            if (d6 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double min = Math.min(d6, d5);
                j4 = (long) (((p(d6) + p(d6 - min)) * min) / 2.0d);
                d5 -= min;
            } else {
                j4 = 0;
            }
            return j4 + ((long) (this.f28609e * d5));
        }
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double e() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f28609e;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final void f(double d4, long j4) {
        n(j4);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d4;
        this.f28609e = micros;
        m(d4, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long h(long j4) {
        return this.f28610f;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long k(int i4, long j4) {
        n(j4);
        long j5 = this.f28610f;
        double d4 = i4;
        double min = Math.min(d4, this.f28607c);
        this.f28610f = LongMath.saturatedAdd(this.f28610f, o(this.f28607c, min) + ((long) ((d4 - min) * this.f28609e)));
        this.f28607c -= min;
        return j5;
    }

    abstract double l();

    abstract void m(double d4, double d5);

    void n(long j4) {
        long j5 = this.f28610f;
        if (j4 > j5) {
            this.f28607c = Math.min(this.f28608d, this.f28607c + ((j4 - j5) / l()));
            this.f28610f = j4;
        }
    }

    abstract long o(double d4, double d5);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.f28610f = 0L;
    }
}
