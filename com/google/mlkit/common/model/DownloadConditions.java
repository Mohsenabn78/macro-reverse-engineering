package com.google.mlkit.common.model;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public class DownloadConditions {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32931a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32932b;

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f32933a = false;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32934b = false;

        @NonNull
        public DownloadConditions build() {
            return new DownloadConditions(this.f32933a, this.f32934b, null);
        }

        @NonNull
        @RequiresApi(24)
        @TargetApi(24)
        public Builder requireCharging() {
            this.f32933a = true;
            return this;
        }

        @NonNull
        public Builder requireWifi() {
            this.f32934b = true;
            return this;
        }
    }

    /* synthetic */ DownloadConditions(boolean z3, boolean z4, zzb zzbVar) {
        this.f32931a = z3;
        this.f32932b = z4;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadConditions)) {
            return false;
        }
        DownloadConditions downloadConditions = (DownloadConditions) obj;
        if (this.f32931a == downloadConditions.f32931a && this.f32932b == downloadConditions.f32932b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f32931a), Boolean.valueOf(this.f32932b));
    }

    public boolean isChargingRequired() {
        return this.f32931a;
    }

    public boolean isWifiRequired() {
        return this.f32932b;
    }
}
