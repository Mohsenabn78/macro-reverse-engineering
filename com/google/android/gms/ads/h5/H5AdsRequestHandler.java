package com.google.android.gms.ads.h5;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbjn;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public final class H5AdsRequestHandler {

    /* renamed from: a  reason: collision with root package name */
    private final zzbjn f19025a;

    public H5AdsRequestHandler(@NonNull Context context, @NonNull OnH5AdsEventListener onH5AdsEventListener) {
        this.f19025a = new zzbjn(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.f19025a.zza();
    }

    public boolean handleH5AdsRequest(@NonNull String str) {
        return this.f19025a.zzb(str);
    }

    public boolean shouldInterceptRequest(@NonNull String str) {
        return zzbjn.zzc(str);
    }
}
