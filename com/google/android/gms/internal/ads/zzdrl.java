package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdrl implements zzdqz {
    private final long zza;
    private final zzeju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrl(long j4, Context context, zzdre zzdreVar, zzcgu zzcguVar, String str) {
        this.zza = j4;
        zzexs zzt = zzcguVar.zzt();
        zzt.zzc(context);
        zzt.zza(new com.google.android.gms.ads.internal.client.zzq());
        zzt.zzb(str);
        zzeju zza = zzt.zzd().zza();
        this.zzb = zza;
        zza.zzD(new zzdrk(this, zzdreVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzaa(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
