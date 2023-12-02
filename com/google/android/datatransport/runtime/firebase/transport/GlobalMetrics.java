package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class GlobalMetrics {

    /* renamed from: b  reason: collision with root package name */
    private static final GlobalMetrics f18751b = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final StorageMetrics f18752a;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private StorageMetrics f18753a = null;

        Builder() {
        }

        public GlobalMetrics build() {
            return new GlobalMetrics(this.f18753a);
        }

        public Builder setStorageMetrics(StorageMetrics storageMetrics) {
            this.f18753a = storageMetrics;
            return this;
        }
    }

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.f18752a = storageMetrics;
    }

    public static GlobalMetrics getDefaultInstance() {
        return f18751b;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public StorageMetrics getStorageMetrics() {
        StorageMetrics storageMetrics = this.f18752a;
        if (storageMetrics == null) {
            return StorageMetrics.getDefaultInstance();
        }
        return storageMetrics;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "storageMetrics")
    public StorageMetrics getStorageMetricsInternal() {
        return this.f18752a;
    }
}
