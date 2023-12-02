package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaur implements Runnable {
    final /* synthetic */ zzaus zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaur(zzaus zzausVar) {
        this.zza = zzausVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z3;
        boolean z4;
        List<zzaut> list;
        obj = this.zza.zzc;
        synchronized (obj) {
            zzaus zzausVar = this.zza;
            z3 = zzausVar.zzd;
            if (z3) {
                z4 = zzausVar.zze;
                if (z4) {
                    zzausVar.zzd = false;
                    zzbzr.zze("App went background");
                    list = this.zza.zzf;
                    for (zzaut zzautVar : list) {
                        try {
                            zzautVar.zza(false);
                        } catch (Exception e4) {
                            zzbzr.zzh("", e4);
                        }
                    }
                }
            }
            zzbzr.zze("App is still foreground");
        }
    }
}
