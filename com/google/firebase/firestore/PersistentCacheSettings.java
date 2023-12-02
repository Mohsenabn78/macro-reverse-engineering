package com.google.firebase.firestore;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class PersistentCacheSettings implements LocalCacheSettings {

    /* renamed from: a  reason: collision with root package name */
    private final long f30215a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f30216a;

        @NonNull
        public PersistentCacheSettings build() {
            return new PersistentCacheSettings(this.f30216a);
        }

        @NonNull
        public Builder setSizeBytes(long j4) {
            this.f30216a = j4;
            return this;
        }

        private Builder() {
            this.f30216a = 104857600L;
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
        if (obj != null && PersistentCacheSettings.class == obj.getClass() && this.f30215a == ((PersistentCacheSettings) obj).f30215a) {
            return true;
        }
        return false;
    }

    public long getSizeBytes() {
        return this.f30215a;
    }

    public int hashCode() {
        long j4 = this.f30215a;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.f30215a + '}';
    }

    private PersistentCacheSettings(long j4) {
        this.f30215a = j4;
    }
}
