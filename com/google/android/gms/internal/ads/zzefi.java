package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefi extends zzefh {
    private final zzcgu zza;
    private final zzcuo zzb;
    private final zzdat zzc;
    private final zzefr zzd;
    private final zzech zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefi(zzcgu zzcguVar, zzcuo zzcuoVar, zzdat zzdatVar, zzefr zzefrVar, zzech zzechVar) {
        this.zza = zzcguVar;
        this.zzb = zzcuoVar;
        this.zzc = zzdatVar;
        this.zzd = zzefrVar;
        this.zze = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefh
    protected final zzfwm zzc(zzfai zzfaiVar, Bundle bundle, zzezn zzeznVar, zzezz zzezzVar) {
        zzcuo zzcuoVar = this.zzb;
        zzcuoVar.zzi(zzfaiVar);
        zzcuoVar.zzf(bundle);
        zzcuoVar.zzg(new zzcui(zzezzVar, zzeznVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcoo zzc = this.zza.zzc();
        zzc.zzd(this.zzb.zzj());
        zzc.zzc(this.zzc);
        zzcsk zzb = zzc.zze().zzb();
        return zzb.zzi(zzb.zzj());
    }
}
