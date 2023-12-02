package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class CustomKeysAndValues {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, String> f29349a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f29350a = new HashMap();

        @NonNull
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z3) {
            this.f29350a.put(str, Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d4) {
            this.f29350a.put(str, Double.toString(d4));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f4) {
            this.f29350a.put(str, Float.toString(f4));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i4) {
            this.f29350a.put(str, Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j4) {
            this.f29350a.put(str, Long.toString(j4));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @NonNull String str2) {
            this.f29350a.put(str, str2);
            return this;
        }
    }

    CustomKeysAndValues(@NonNull Builder builder) {
        this.f29349a = builder.f29350a;
    }
}
