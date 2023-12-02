package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbnp {
    private static zzbnp zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    @VisibleForTesting
    zzbnp() {
    }

    public static zzbnp zza() {
        if (zza == null) {
            zza = new zzbnp();
        }
        return zza;
    }

    @Nullable
    public final Thread zzb(final Context context, @Nullable final String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbno
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                String str2 = str;
                zzbbm.zza(context2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzai)).booleanValue());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzap)).booleanValue()) {
                    bundle.putString("ad_storage", "denied");
                    bundle.putString("analytics_storage", "denied");
                }
                try {
                    ((zzcgt) zzbzv.zzb(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new zzbzt() { // from class: com.google.android.gms.internal.ads.zzbnn
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.android.gms.internal.ads.zzbzt
                        public final Object zza(Object obj) {
                            return zzcgs.zzb(obj);
                        }
                    })).zze(ObjectWrapper.wrap(context2), new zzbnm(AppMeasurementSdk.getInstance(context2, "FA-Ads", "am", str2, bundle)));
                } catch (RemoteException | zzbzu | NullPointerException e4) {
                    zzbzr.zzl("#007 Could not call remote method.", e4);
                }
            }
        });
        thread.start();
        return thread;
    }
}
