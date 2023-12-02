package com.google.firebase.firestore;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class MemoryLruGcSettings implements MemoryGarbageCollectorSettings {

    /* renamed from: a  reason: collision with root package name */
    private long f30211a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f30212a;

        @NonNull
        public MemoryLruGcSettings build() {
            return new MemoryLruGcSettings(this.f30212a);
        }

        @NonNull
        public Builder setSizeBytes(long j4) {
            this.f30212a = j4;
            return this;
        }

        private Builder() {
            this.f30212a = 104857600L;
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MemoryLruGcSettings.class == obj.getClass() && this.f30211a == ((MemoryLruGcSettings) obj).f30211a) {
            return true;
        }
        return false;
    }

    public long getSizeBytes() {
        return this.f30211a;
    }

    public int hashCode() {
        long j4 = this.f30211a;
        return (int) (j4 ^ (j4 >>> 32));
    }

    @NonNull
    public String toString() {
        return "MemoryLruGcSettings{cacheSize=" + getSizeBytes() + "}";
    }

    private MemoryLruGcSettings(long j4) {
        this.f30211a = j4;
    }
}
