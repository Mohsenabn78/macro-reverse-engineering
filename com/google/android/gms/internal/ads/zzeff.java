package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeff extends zzefh {
    private final zzcgu zza;
    private final zzdff zzb;
    private final zzcuo zzc;
    private final zzdat zzd;
    private final zzefr zze;
    private final zzech zzf;

    public zzeff(zzcgu zzcguVar, zzdff zzdffVar, zzcuo zzcuoVar, zzdat zzdatVar, zzefr zzefrVar, zzech zzechVar) {
        this.zza = zzcguVar;
        this.zzb = zzdffVar;
        this.zzc = zzcuoVar;
        this.zzd = zzdatVar;
        this.zze = zzefrVar;
        this.zzf = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefh
    protected final zzfwm zzc(zzfai zzfaiVar, Bundle bundle, zzezn zzeznVar, zzezz zzezzVar) {
        zzcuo zzcuoVar = this.zzc;
        zzcuoVar.zzi(zzfaiVar);
        zzcuoVar.zzf(bundle);
        zzcuoVar.zzg(new zzcui(zzezzVar, zzeznVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzdfj zzg = this.zza.zzg();
        zzg.zzf(this.zzc.zzj());
        zzg.zze(this.zzd);
        zzg.zzd(this.zzb);
        zzg.zzc(new zzcoy(null));
        zzcsk zza = zzg.zzg().zza();
        return zza.zzi(zza.zzj());
    }
}
