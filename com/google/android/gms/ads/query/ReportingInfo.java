package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbsq;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class ReportingInfo {

    /* renamed from: a  reason: collision with root package name */
    private final zzbsq f19577a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final zzbsp f19578a;

        @KeepForSdk
        public Builder(@NonNull View view) {
            zzbsp zzbspVar = new zzbsp();
            this.f19578a = zzbspVar;
            zzbspVar.zzb(view);
        }

        @NonNull
        @KeepForSdk
        public ReportingInfo build() {
            return new ReportingInfo(this, null);
        }

        @NonNull
        @KeepForSdk
        public Builder setAssetViews(@NonNull Map<String, View> map) {
            this.f19578a.zzc(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzbVar) {
        this.f19577a = new zzbsq(builder.f19578a);
    }

    @KeepForSdk
    public void recordClick(@NonNull List<Uri> list) {
        this.f19577a.zza(list);
    }

    @KeepForSdk
    public void recordImpression(@NonNull List<Uri> list) {
        this.f19577a.zzb(list);
    }

    @KeepForSdk
    public void reportTouchEvent(@NonNull MotionEvent motionEvent) {
        this.f19577a.zzc(motionEvent);
    }

    @KeepForSdk
    public void updateClickUrl(@NonNull Uri uri, @NonNull UpdateClickUrlCallback updateClickUrlCallback) {
        this.f19577a.zzd(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public void updateImpressionUrls(@NonNull List<Uri> list, @NonNull UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.f19577a.zze(list, updateImpressionUrlsCallback);
    }
}
