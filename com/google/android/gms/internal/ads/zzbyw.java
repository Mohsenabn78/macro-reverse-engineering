package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbyw extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzbza zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyw(zzbza zzbzaVar) {
        this.zza = zzbzaVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        Context context;
        zzbzx zzbzxVar;
        Object obj;
        zzbbu zzbbuVar;
        zzbza zzbzaVar = this.zza;
        context = zzbzaVar.zze;
        zzbzxVar = zzbzaVar.zzf;
        zzbbs zzbbsVar = new zzbbs(context, zzbzxVar.zza);
        obj = this.zza.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzt.zze();
                zzbbuVar = this.zza.zzh;
                zzbbv.zza(zzbbuVar, zzbbsVar);
            } catch (IllegalArgumentException e4) {
                zzbzr.zzk("Cannot config CSI reporter.", e4);
            }
        }
    }
}
