package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcua implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzcua(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final zzbzx zza = ((zzchm) this.zzb).zza();
        final zzfai zza2 = ((zzcux) this.zzc).zza();
        return new zzfov() { // from class: com.google.android.gms.internal.ads.zzctz
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                Context context2 = context;
                zzbzx zzbzxVar = zza;
                zzfai zzfaiVar = zza2;
                zzezn zzeznVar = (zzezn) obj;
                com.google.android.gms.ads.internal.util.zzas zzasVar = new com.google.android.gms.ads.internal.util.zzas(context2);
                zzasVar.zzp(zzeznVar.zzC);
                zzasVar.zzq(zzeznVar.zzD.toString());
                zzasVar.zzo(zzbzxVar.zza);
                zzasVar.zzn(zzfaiVar.zzf);
                return zzasVar;
            }
        };
    }
}
