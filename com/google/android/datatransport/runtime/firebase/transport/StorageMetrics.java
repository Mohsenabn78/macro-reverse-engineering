package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class StorageMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final StorageMetrics f18765c = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final long f18766a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18767b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f18768a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f18769b = 0;

        Builder() {
        }

        public StorageMetrics build() {
            return new StorageMetrics(this.f18768a, this.f18769b);
        }

        public Builder setCurrentCacheSizeBytes(long j4) {
            this.f18768a = j4;
            return this;
        }

        public Builder setMaxCacheSizeBytes(long j4) {
            this.f18769b = j4;
            return this;
        }
    }

    StorageMetrics(long j4, long j5) {
        this.f18766a = j4;
        this.f18767b = j5;
    }

    public static StorageMetrics getDefaultInstance() {
        return f18765c;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long getCurrentCacheSizeBytes() {
        return this.f18766a;
    }

    @Protobuf(tag = 2)
    public long getMaxCacheSizeBytes() {
        return this.f18767b;
    }
}
