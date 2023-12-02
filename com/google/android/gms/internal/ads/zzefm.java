package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefm extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzehv zzc;
    private final zzdat zzd;
    private final zzefr zze;
    private final zzech zzf;

    public zzefm(zzcgu zzcguVar, zzcuo zzcuoVar, zzehv zzehvVar, zzdat zzdatVar, zzefr zzefrVar, zzech zzechVar) {
        this.zza = zzcguVar;
        this.zzb = zzcuoVar;
        this.zzc = zzehvVar;
        this.zzd = zzdatVar;
        this.zze = zzefrVar;
        this.zzf = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefh
    protected final zzfwm zzc(zzfai zzfaiVar, Bundle bundle, zzezn zzeznVar, zzezz zzezzVar) {
        zzcuo zzcuoVar = this.zzb;
        zzcuoVar.zzi(zzfaiVar);
        zzcuoVar.zzf(bundle);
        zzcuoVar.zzg(new zzcui(zzezzVar, zzeznVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzden zzf = this.zza.zzf();
        zzf.zze(this.zzb.zzj());
        zzf.zzd(this.zzd);
        zzf.zzc(this.zzc);
        zzcsk zza = zzf.zzf().zza();
        return zza.zzi(zza.zzj());
    }
}
