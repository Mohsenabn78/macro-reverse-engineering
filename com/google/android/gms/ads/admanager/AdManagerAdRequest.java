package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdRequest;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class AdManagerAdRequest extends AdRequest {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder extends AdRequest.Builder {
        @NonNull
        public Builder addCategoryExclusion(@NonNull String str) {
            this.f18961a.zzp(str);
            return this;
        }

        @NonNull
        public Builder addCustomTargeting(@NonNull String str, @NonNull String str2) {
            this.f18961a.zzr(str, str2);
            return this;
        }

        @NonNull
        public Builder setPublisherProvidedId(@NonNull String str) {
            this.f18961a.zzE(str);
            return this;
        }

        @NonNull
        public Builder addCustomTargeting(@NonNull String str, @NonNull List<String> list) {
            if (list != null) {
                this.f18961a.zzr(str, TextUtils.join(",", list));
            }
            return this;
        }

        @Override // com.google.android.gms.ads.AdRequest.Builder
        @NonNull
        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, null);
        }
    }

    /* synthetic */ AdManagerAdRequest(Builder builder, zza zzaVar) {
        super(builder);
    }

    @Override // com.google.android.gms.ads.AdRequest
    @NonNull
    public Bundle getCustomTargeting() {
        return this.f18960a.zze();
    }

    @NonNull
    public String getPublisherProvidedId() {
        return this.f18960a.zzl();
    }
}
