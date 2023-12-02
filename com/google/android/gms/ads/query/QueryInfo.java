package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzem;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class QueryInfo {

    /* renamed from: a  reason: collision with root package name */
    private final zzem f19576a;

    public QueryInfo(zzem zzemVar) {
        this.f19576a = zzemVar;
    }

    public static void generate(@NonNull final Context context, @NonNull final AdFormat adFormat, @Nullable final AdRequest adRequest, @NonNull final QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzdx zza;
        zzbbm.zza(context);
        if (((Boolean) zzbdd.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.query.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdx zza2;
                        Context context2 = context;
                        AdFormat adFormat2 = adFormat;
                        AdRequest adRequest2 = adRequest;
                        QueryInfoGenerationCallback queryInfoGenerationCallback2 = queryInfoGenerationCallback;
                        if (adRequest2 == null) {
                            zza2 = null;
                        } else {
                            zza2 = adRequest2.zza();
                        }
                        new zzbsk(context2, adFormat2, zza2).zzb(queryInfoGenerationCallback2);
                    }
                });
                return;
            }
        }
        if (adRequest == null) {
            zza = null;
        } else {
            zza = adRequest.zza();
        }
        new zzbsk(context, adFormat, zza).zzb(queryInfoGenerationCallback);
    }

    @NonNull
    public String getQuery() {
        return this.f19576a.zzb();
    }

    @NonNull
    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.f19576a.zza();
    }

    @NonNull
    @KeepForSdk
    public String getRequestId() {
        return this.f19576a.zzc();
    }
}
