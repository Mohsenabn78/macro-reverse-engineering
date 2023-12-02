package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzfl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class VideoOptions {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18995a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18996b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18997c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f18998a = true;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18999b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19000c = false;

        @NonNull
        public VideoOptions build() {
            return new VideoOptions(this, null);
        }

        @NonNull
        public Builder setClickToExpandRequested(boolean z3) {
            this.f19000c = z3;
            return this;
        }

        @NonNull
        public Builder setCustomControlsRequested(boolean z3) {
            this.f18999b = z3;
            return this;
        }

        @NonNull
        public Builder setStartMuted(boolean z3) {
            this.f18998a = z3;
            return this;
        }
    }

    /* synthetic */ VideoOptions(Builder builder, zzi zziVar) {
        this.f18995a = builder.f18998a;
        this.f18996b = builder.f18999b;
        this.f18997c = builder.f19000c;
    }

    public boolean getClickToExpandRequested() {
        return this.f18997c;
    }

    public boolean getCustomControlsRequested() {
        return this.f18996b;
    }

    public boolean getStartMuted() {
        return this.f18995a;
    }

    public VideoOptions(zzfl zzflVar) {
        this.f18995a = zzflVar.zza;
        this.f18996b = zzflVar.zzb;
        this.f18997c = zzflVar.zzc;
    }
}
