package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: classes5.dex */
public class FirebaseRemoteConfigSettings {

    /* renamed from: a  reason: collision with root package name */
    private final long f31887a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31888b;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f31889a = 60;

        /* renamed from: b  reason: collision with root package name */
        private long f31890b = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;

        @NonNull
        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings(this);
        }

        public long getFetchTimeoutInSeconds() {
            return this.f31889a;
        }

        public long getMinimumFetchIntervalInSeconds() {
            return this.f31890b;
        }

        @NonNull
        public Builder setFetchTimeoutInSeconds(long j4) throws IllegalArgumentException {
            if (j4 >= 0) {
                this.f31889a = j4;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j4)));
        }

        @NonNull
        public Builder setMinimumFetchIntervalInSeconds(long j4) {
            if (j4 >= 0) {
                this.f31890b = j4;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j4 + " is an invalid argument");
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.f31887a;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.f31888b;
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f31887a = builder.f31889a;
        this.f31888b = builder.f31890b;
    }
}
