package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class MemoryCacheSettings implements LocalCacheSettings {

    /* renamed from: a  reason: collision with root package name */
    private MemoryGarbageCollectorSettings f30209a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private MemoryGarbageCollectorSettings f30210a;

        @NonNull
        public MemoryCacheSettings build() {
            return new MemoryCacheSettings(this.f30210a);
        }

        @NonNull
        public Builder setGcSettings(@NonNull MemoryGarbageCollectorSettings memoryGarbageCollectorSettings) {
            this.f30210a = memoryGarbageCollectorSettings;
            return this;
        }

        private Builder() {
            this.f30210a = MemoryEagerGcSettings.newBuilder().build();
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MemoryCacheSettings.class == obj.getClass()) {
            return getGarbageCollectorSettings().equals(((MemoryCacheSettings) obj).getGarbageCollectorSettings());
        }
        return false;
    }

    @NonNull
    public MemoryGarbageCollectorSettings getGarbageCollectorSettings() {
        return this.f30209a;
    }

    public int hashCode() {
        return this.f30209a.hashCode();
    }

    public String toString() {
        return "MemoryCacheSettings{gcSettings=" + getGarbageCollectorSettings() + "}";
    }

    private MemoryCacheSettings(MemoryGarbageCollectorSettings memoryGarbageCollectorSettings) {
        this.f30209a = memoryGarbageCollectorSettings;
    }
}
