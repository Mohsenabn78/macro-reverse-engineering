package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* loaded from: classes.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* renamed from: b  reason: collision with root package name */
    private final long f18865b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18866c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18867d;

    /* renamed from: e  reason: collision with root package name */
    private final long f18868e;

    /* renamed from: f  reason: collision with root package name */
    private final int f18869f;

    /* loaded from: classes.dex */
    static final class Builder extends EventStoreConfig.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f18870a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f18871b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f18872c;

        /* renamed from: d  reason: collision with root package name */
        private Long f18873d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f18874e;

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig a() {
            String str = "";
            if (this.f18870a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f18871b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f18872c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f18873d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f18874e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.f18870a.longValue(), this.f18871b.intValue(), this.f18872c.intValue(), this.f18873d.longValue(), this.f18874e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder b(int i4) {
            this.f18872c = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder c(long j4) {
            this.f18873d = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder d(int i4) {
            this.f18871b = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder e(int i4) {
            this.f18874e = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder f(long j4) {
            this.f18870a = Long.valueOf(j4);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int b() {
        return this.f18867d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long c() {
        return this.f18868e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int d() {
        return this.f18866c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int e() {
        return this.f18869f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        if (this.f18865b == eventStoreConfig.f() && this.f18866c == eventStoreConfig.d() && this.f18867d == eventStoreConfig.b() && this.f18868e == eventStoreConfig.c() && this.f18869f == eventStoreConfig.e()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long f() {
        return this.f18865b;
    }

    public int hashCode() {
        long j4 = this.f18865b;
        long j5 = this.f18868e;
        return this.f18869f ^ ((((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f18866c) * 1000003) ^ this.f18867d) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f18865b + ", loadBatchSize=" + this.f18866c + ", criticalSectionEnterTimeoutMs=" + this.f18867d + ", eventCleanUpAge=" + this.f18868e + ", maxBlobByteSizePerRow=" + this.f18869f + "}";
    }

    private AutoValue_EventStoreConfig(long j4, int i4, int i5, long j5, int i6) {
        this.f18865b = j4;
        this.f18866c = i4;
        this.f18867d = i5;
        this.f18868e = j5;
        this.f18869f = i6;
    }
}
