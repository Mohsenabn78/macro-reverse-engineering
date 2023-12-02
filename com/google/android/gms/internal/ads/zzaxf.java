package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxf {
    @VisibleForTesting
    zzatv zza;
    @VisibleForTesting
    boolean zzb;
    private final ExecutorService zzc;

    public zzaxf() {
        this.zzc = zzbzg.zzb;
    }

    public zzaxf(final Context context) {
        ExecutorService executorService = zzbzg.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxa
            @Override // java.lang.Runnable
            public final void run() {
                zzaxf zzaxfVar = zzaxf.this;
                Context context2 = context;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeG)).booleanValue()) {
                    try {
                        zzaxfVar.zza = (zzatv) zzbzv.zzb(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzbzt() { // from class: com.google.android.gms.internal.ads.zzaxb
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.android.gms.internal.ads.zzbzt
                            public final Object zza(Object obj) {
                                return zzatu.zzb(obj);
                            }
                        });
                        zzaxfVar.zza.zze(ObjectWrapper.wrap(context2), "GMA_SDK");
                        zzaxfVar.zzb = true;
                    } catch (RemoteException | zzbzu | NullPointerException unused) {
                        zzbzr.zze("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}
