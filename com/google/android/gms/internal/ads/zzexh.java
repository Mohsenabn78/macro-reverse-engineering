package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzexh implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzexh(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final zzexe zzb() {
        zzbyu zzi;
        Context context = (Context) this.zza.zzb();
        zzfbq zzfbqVar = (zzfbq) this.zzb.zzb();
        zzfci zzfciVar = (zzfci) this.zzc.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzge)).booleanValue()) {
            zzi = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh();
        } else {
            zzi = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzi();
        }
        boolean z3 = false;
        if (zzi != null && zzi.zzh()) {
            z3 = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgg)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgd)).booleanValue() || z3) {
                zzfch zza = zzfciVar.zza(zzfby.Rewarded, context, zzfbqVar, new zzewi(new zzewf()));
                zzewu zzewuVar = new zzewu(new zzewt());
                zzfbu zzfbuVar = zza.zza;
                zzfwn zzfwnVar = zzcae.zza;
                return new zzewk(zzewuVar, new zzewq(zzfbuVar, zzfwnVar), zza.zzb, zza.zza.zza().zzf, zzfwnVar);
            }
        }
        return new zzewt();
    }
}
