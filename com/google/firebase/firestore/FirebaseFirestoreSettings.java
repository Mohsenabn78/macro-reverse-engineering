package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public final class FirebaseFirestoreSettings {
    public static final long CACHE_SIZE_UNLIMITED = -1;
    public static final String DEFAULT_HOST = "firestore.googleapis.com";

    /* renamed from: a  reason: collision with root package name */
    private final String f30175a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30176b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30177c;

    /* renamed from: d  reason: collision with root package name */
    private final long f30178d;

    /* renamed from: e  reason: collision with root package name */
    private LocalCacheSettings f30179e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FirebaseFirestoreSettings.class != obj.getClass()) {
            return false;
        }
        FirebaseFirestoreSettings firebaseFirestoreSettings = (FirebaseFirestoreSettings) obj;
        if (this.f30176b != firebaseFirestoreSettings.f30176b || this.f30177c != firebaseFirestoreSettings.f30177c || this.f30178d != firebaseFirestoreSettings.f30178d || !this.f30175a.equals(firebaseFirestoreSettings.f30175a)) {
            return false;
        }
        return Objects.equals(this.f30179e, firebaseFirestoreSettings.f30179e);
    }

    @Nullable
    public LocalCacheSettings getCacheSettings() {
        return this.f30179e;
    }

    @Deprecated
    public long getCacheSizeBytes() {
        LocalCacheSettings localCacheSettings = this.f30179e;
        if (localCacheSettings != null) {
            if (localCacheSettings instanceof PersistentCacheSettings) {
                return ((PersistentCacheSettings) localCacheSettings).getSizeBytes();
            }
            MemoryCacheSettings memoryCacheSettings = (MemoryCacheSettings) localCacheSettings;
            if (memoryCacheSettings.getGarbageCollectorSettings() instanceof MemoryLruGcSettings) {
                return ((MemoryLruGcSettings) memoryCacheSettings.getGarbageCollectorSettings()).getSizeBytes();
            }
            return -1L;
        }
        return this.f30178d;
    }

    @NonNull
    public String getHost() {
        return this.f30175a;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f30178d;
        int hashCode = ((((((this.f30175a.hashCode() * 31) + (this.f30176b ? 1 : 0)) * 31) + (this.f30177c ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        LocalCacheSettings localCacheSettings = this.f30179e;
        if (localCacheSettings != null) {
            i4 = localCacheSettings.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    @Deprecated
    public boolean isPersistenceEnabled() {
        LocalCacheSettings localCacheSettings = this.f30179e;
        if (localCacheSettings != null) {
            return localCacheSettings instanceof PersistentCacheSettings;
        }
        return this.f30177c;
    }

    public boolean isSslEnabled() {
        return this.f30176b;
    }

    @NonNull
    public String toString() {
        if (("FirebaseFirestoreSettings{host=" + this.f30175a + ", sslEnabled=" + this.f30176b + ", persistenceEnabled=" + this.f30177c + ", cacheSizeBytes=" + this.f30178d + ", cacheSettings=" + this.f30179e) == null) {
            return "null";
        }
        return this.f30179e.toString() + "}";
    }

    private FirebaseFirestoreSettings(Builder builder) {
        this.f30175a = builder.f30180a;
        this.f30176b = builder.f30181b;
        this.f30177c = builder.f30182c;
        this.f30178d = builder.f30183d;
        this.f30179e = builder.f30184e;
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f30180a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30181b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f30182c;

        /* renamed from: d  reason: collision with root package name */
        private long f30183d;

        /* renamed from: e  reason: collision with root package name */
        private LocalCacheSettings f30184e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f30185f;

        public Builder() {
            this.f30185f = false;
            this.f30180a = FirebaseFirestoreSettings.DEFAULT_HOST;
            this.f30181b = true;
            this.f30182c = true;
            this.f30183d = 104857600L;
        }

        @NonNull
        public FirebaseFirestoreSettings build() {
            if (!this.f30181b && this.f30180a.equals(FirebaseFirestoreSettings.DEFAULT_HOST)) {
                throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
            }
            return new FirebaseFirestoreSettings(this);
        }

        @Deprecated
        public long getCacheSizeBytes() {
            return this.f30183d;
        }

        @NonNull
        public String getHost() {
            return this.f30180a;
        }

        @Deprecated
        public boolean isPersistenceEnabled() {
            return this.f30182c;
        }

        public boolean isSslEnabled() {
            return this.f30181b;
        }

        @NonNull
        @Deprecated
        public Builder setCacheSizeBytes(long j4) {
            if (this.f30184e == null) {
                if (j4 != -1 && j4 < 1048576) {
                    throw new IllegalArgumentException("Cache size must be set to at least 1048576 bytes");
                }
                this.f30183d = j4;
                this.f30185f = true;
                return this;
            }
            throw new IllegalStateException("New cache config API setLocalCacheSettings() is already used.");
        }

        @NonNull
        public Builder setHost(@NonNull String str) {
            this.f30180a = (String) Preconditions.checkNotNull(str, "Provided host must not be null.");
            return this;
        }

        @NonNull
        public Builder setLocalCacheSettings(@NonNull LocalCacheSettings localCacheSettings) {
            if (!this.f30185f) {
                if (!(localCacheSettings instanceof MemoryCacheSettings) && !(localCacheSettings instanceof PersistentCacheSettings)) {
                    throw new IllegalArgumentException("Only MemoryCacheSettings and PersistentCacheSettings are accepted");
                }
                this.f30184e = localCacheSettings;
                return this;
            }
            throw new IllegalStateException("Deprecated setPersistenceEnabled() or setCacheSizeBytes() is already used, remove those first.");
        }

        @NonNull
        @Deprecated
        public Builder setPersistenceEnabled(boolean z3) {
            if (this.f30184e == null) {
                this.f30182c = z3;
                this.f30185f = true;
                return this;
            }
            throw new IllegalStateException("New cache config API setLocalCacheSettings() is already used.");
        }

        @NonNull
        public Builder setSslEnabled(boolean z3) {
            this.f30181b = z3;
            return this;
        }

        public Builder(@NonNull FirebaseFirestoreSettings firebaseFirestoreSettings) {
            this.f30185f = false;
            Preconditions.checkNotNull(firebaseFirestoreSettings, "Provided settings must not be null.");
            this.f30180a = firebaseFirestoreSettings.f30175a;
            this.f30181b = firebaseFirestoreSettings.f30176b;
            this.f30182c = firebaseFirestoreSettings.f30177c;
            long j4 = firebaseFirestoreSettings.f30178d;
            this.f30183d = j4;
            if (!this.f30182c || j4 != 104857600) {
                this.f30185f = true;
            }
            if (!this.f30185f) {
                this.f30184e = firebaseFirestoreSettings.f30179e;
            } else {
                Assert.hardAssert(firebaseFirestoreSettings.f30179e == null, "Given settings object mixes both cache config APIs, which is impossible.", new Object[0]);
            }
        }
    }
}
