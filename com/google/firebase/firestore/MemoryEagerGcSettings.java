package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class MemoryEagerGcSettings implements MemoryGarbageCollectorSettings {

    /* loaded from: classes5.dex */
    public static class Builder {
        private Builder() {
        }

        @NonNull
        public MemoryEagerGcSettings build() {
            return new MemoryEagerGcSettings();
        }
    }

    private MemoryEagerGcSettings() {
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MemoryEagerGcSettings.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public String toString() {
        return "MemoryEagerGcSettings{}";
    }
}
