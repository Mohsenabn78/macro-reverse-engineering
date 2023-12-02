package com.google.api.client.util;

import androidx.compose.animation.core.AnimationKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ExponentialBackOff implements BackOff {
    public static final int DEFAULT_INITIAL_INTERVAL_MILLIS = 500;
    public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
    public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
    public static final double DEFAULT_MULTIPLIER = 1.5d;
    public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5d;

    /* renamed from: a  reason: collision with root package name */
    private int f26101a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26102b;

    /* renamed from: c  reason: collision with root package name */
    private final double f26103c;

    /* renamed from: d  reason: collision with root package name */
    private final double f26104d;

    /* renamed from: e  reason: collision with root package name */
    private final int f26105e;

    /* renamed from: f  reason: collision with root package name */
    long f26106f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26107g;

    /* renamed from: h  reason: collision with root package name */
    private final NanoClock f26108h;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        int f26109a = 500;

        /* renamed from: b  reason: collision with root package name */
        double f26110b = 0.5d;

        /* renamed from: c  reason: collision with root package name */
        double f26111c = 1.5d;

        /* renamed from: d  reason: collision with root package name */
        int f26112d = 60000;

        /* renamed from: e  reason: collision with root package name */
        int f26113e = 900000;

        /* renamed from: f  reason: collision with root package name */
        NanoClock f26114f = NanoClock.SYSTEM;

        public ExponentialBackOff build() {
            return new ExponentialBackOff(this);
        }

        public final int getInitialIntervalMillis() {
            return this.f26109a;
        }

        public final int getMaxElapsedTimeMillis() {
            return this.f26113e;
        }

        public final int getMaxIntervalMillis() {
            return this.f26112d;
        }

        public final double getMultiplier() {
            return this.f26111c;
        }

        public final NanoClock getNanoClock() {
            return this.f26114f;
        }

        public final double getRandomizationFactor() {
            return this.f26110b;
        }

        public Builder setInitialIntervalMillis(int i4) {
            this.f26109a = i4;
            return this;
        }

        public Builder setMaxElapsedTimeMillis(int i4) {
            this.f26113e = i4;
            return this;
        }

        public Builder setMaxIntervalMillis(int i4) {
            this.f26112d = i4;
            return this;
        }

        public Builder setMultiplier(double d4) {
            this.f26111c = d4;
            return this;
        }

        public Builder setNanoClock(NanoClock nanoClock) {
            this.f26114f = (NanoClock) Preconditions.checkNotNull(nanoClock);
            return this;
        }

        public Builder setRandomizationFactor(double d4) {
            this.f26110b = d4;
            return this;
        }
    }

    public ExponentialBackOff() {
        this(new Builder());
    }

    static int a(double d4, double d5, int i4) {
        double d6 = i4;
        double d7 = d4 * d6;
        double d8 = d6 - d7;
        return (int) (d8 + (d5 * (((d6 + d7) - d8) + 1.0d)));
    }

    private void b() {
        int i4 = this.f26101a;
        int i5 = this.f26105e;
        double d4 = this.f26104d;
        if (i4 >= i5 / d4) {
            this.f26101a = i5;
        } else {
            this.f26101a = (int) (i4 * d4);
        }
    }

    public final int getCurrentIntervalMillis() {
        return this.f26101a;
    }

    public final long getElapsedTimeMillis() {
        return (this.f26108h.nanoTime() - this.f26106f) / AnimationKt.MillisToNanos;
    }

    public final int getInitialIntervalMillis() {
        return this.f26102b;
    }

    public final int getMaxElapsedTimeMillis() {
        return this.f26107g;
    }

    public final int getMaxIntervalMillis() {
        return this.f26105e;
    }

    public final double getMultiplier() {
        return this.f26104d;
    }

    public final double getRandomizationFactor() {
        return this.f26103c;
    }

    @Override // com.google.api.client.util.BackOff
    public long nextBackOffMillis() throws IOException {
        if (getElapsedTimeMillis() > this.f26107g) {
            return -1L;
        }
        int a4 = a(this.f26103c, Math.random(), this.f26101a);
        b();
        return a4;
    }

    @Override // com.google.api.client.util.BackOff
    public final void reset() {
        this.f26101a = this.f26102b;
        this.f26106f = this.f26108h.nanoTime();
    }

    protected ExponentialBackOff(Builder builder) {
        int i4 = builder.f26109a;
        this.f26102b = i4;
        double d4 = builder.f26110b;
        this.f26103c = d4;
        double d5 = builder.f26111c;
        this.f26104d = d5;
        int i5 = builder.f26112d;
        this.f26105e = i5;
        int i6 = builder.f26113e;
        this.f26107g = i6;
        this.f26108h = builder.f26114f;
        Preconditions.checkArgument(i4 > 0);
        Preconditions.checkArgument(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE <= d4 && d4 < 1.0d);
        Preconditions.checkArgument(d5 >= 1.0d);
        Preconditions.checkArgument(i5 >= i4);
        Preconditions.checkArgument(i6 > 0);
        reset();
    }
}
