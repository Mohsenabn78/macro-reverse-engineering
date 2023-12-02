package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {
    @NonNull
    public static final TelemetryLoggingOptions zaa = builder().build();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f20497a;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f20498a;

        private Builder() {
        }

        /* synthetic */ Builder(zaac zaacVar) {
        }

        @NonNull
        @KeepForSdk
        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions(this.f20498a, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setApi(@Nullable String str) {
            this.f20498a = str;
            return this;
        }
    }

    /* synthetic */ TelemetryLoggingOptions(String str, zaad zaadVar) {
        this.f20497a = str;
    }

    @NonNull
    @KeepForSdk
    public static Builder builder() {
        return new Builder(null);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.equal(this.f20497a, ((TelemetryLoggingOptions) obj).f20497a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f20497a);
    }

    @NonNull
    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String str = this.f20497a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }
}
