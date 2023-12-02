package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.NanoClock;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes5.dex */
public class ExponentialBackOffPolicy implements BackOffPolicy {
    public static final int DEFAULT_INITIAL_INTERVAL_MILLIS = 500;
    public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
    public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
    public static final double DEFAULT_MULTIPLIER = 1.5d;
    public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5d;

    /* renamed from: a  reason: collision with root package name */
    private final ExponentialBackOff f25757a;

    @Beta
    @Deprecated
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final ExponentialBackOff.Builder f25758a = new ExponentialBackOff.Builder();

        protected Builder() {
        }

        public ExponentialBackOffPolicy build() {
            return new ExponentialBackOffPolicy(this);
        }

        public final int getInitialIntervalMillis() {
            return this.f25758a.getInitialIntervalMillis();
        }

        public final int getMaxElapsedTimeMillis() {
            return this.f25758a.getMaxElapsedTimeMillis();
        }

        public final int getMaxIntervalMillis() {
            return this.f25758a.getMaxIntervalMillis();
        }

        public final double getMultiplier() {
            return this.f25758a.getMultiplier();
        }

        public final NanoClock getNanoClock() {
            return this.f25758a.getNanoClock();
        }

        public final double getRandomizationFactor() {
            return this.f25758a.getRandomizationFactor();
        }

        public Builder setInitialIntervalMillis(int i4) {
            this.f25758a.setInitialIntervalMillis(i4);
            return this;
        }

        public Builder setMaxElapsedTimeMillis(int i4) {
            this.f25758a.setMaxElapsedTimeMillis(i4);
            return this;
        }

        public Builder setMaxIntervalMillis(int i4) {
            this.f25758a.setMaxIntervalMillis(i4);
            return this;
        }

        public Builder setMultiplier(double d4) {
            this.f25758a.setMultiplier(d4);
            return this;
        }

        public Builder setNanoClock(NanoClock nanoClock) {
            this.f25758a.setNanoClock(nanoClock);
            return this;
        }

        public Builder setRandomizationFactor(double d4) {
            this.f25758a.setRandomizationFactor(d4);
            return this;
        }
    }

    public ExponentialBackOffPolicy() {
        this(new Builder());
    }

    public static Builder builder() {
        return new Builder();
    }

    public final int getCurrentIntervalMillis() {
        return this.f25757a.getCurrentIntervalMillis();
    }

    public final long getElapsedTimeMillis() {
        return this.f25757a.getElapsedTimeMillis();
    }

    public final int getInitialIntervalMillis() {
        return this.f25757a.getInitialIntervalMillis();
    }

    public final int getMaxElapsedTimeMillis() {
        return this.f25757a.getMaxElapsedTimeMillis();
    }

    public final int getMaxIntervalMillis() {
        return this.f25757a.getMaxIntervalMillis();
    }

    public final double getMultiplier() {
        return this.f25757a.getMultiplier();
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public long getNextBackOffMillis() throws IOException {
        return this.f25757a.nextBackOffMillis();
    }

    public final double getRandomizationFactor() {
        return this.f25757a.getRandomizationFactor();
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public boolean isBackOffRequired(int i4) {
        if (i4 != 500 && i4 != 503) {
            return false;
        }
        return true;
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public final void reset() {
        this.f25757a.reset();
    }

    protected ExponentialBackOffPolicy(Builder builder) {
        this.f25757a = builder.f25758a.build();
    }
}
