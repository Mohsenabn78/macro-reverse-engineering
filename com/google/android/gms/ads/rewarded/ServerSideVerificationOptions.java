package com.google.android.gms.ads.rewarded;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class ServerSideVerificationOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f19579a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19580b;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19581a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f19582b = "";

        @NonNull
        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, null);
        }

        @NonNull
        public Builder setCustomData(@NonNull String str) {
            this.f19582b = str;
            return this;
        }

        @NonNull
        public Builder setUserId(@NonNull String str) {
            this.f19581a = str;
            return this;
        }
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, zzd zzdVar) {
        this.f19579a = builder.f19581a;
        this.f19580b = builder.f19582b;
    }

    @NonNull
    public String getCustomData() {
        return this.f19580b;
    }

    @NonNull
    public String getUserId() {
        return this.f19579a;
    }
}
