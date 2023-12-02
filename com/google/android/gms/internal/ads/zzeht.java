package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeht implements zzecc {
    @Nullable
    private final zzbck zza;
    private final zzfwn zzb;
    private final zzfel zzc;
    private final zzeic zzd;

    public zzeht(zzfel zzfelVar, zzfwn zzfwnVar, @Nullable zzbck zzbckVar, zzeic zzeicVar) {
        this.zzc = zzfelVar;
        this.zzb = zzfwnVar;
        this.zza = zzbckVar;
        this.zzd = zzeicVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(zzezz zzezzVar, zzezn zzeznVar) {
        zzcaj zzcajVar = new zzcaj();
        zzehy zzehyVar = new zzehy();
        zzehyVar.zzd(new zzehs(this, zzcajVar, zzezzVar, zzeznVar, zzehyVar));
        zzezs zzezsVar = zzeznVar.zzt;
        final zzbcf zzbcfVar = new zzbcf(zzehyVar, zzezsVar.zzb, zzezsVar.zza);
        zzfel zzfelVar = this.zzc;
        return zzfdv.zzd(new zzfdp() { // from class: com.google.android.gms.internal.ads.zzehr
            @Override // com.google.android.gms.internal.ads.zzfdp
            public final void zza() {
                zzeht.this.zzc(zzbcfVar);
            }
        }, this.zzb, zzfef.CUSTOM_RENDER_SYN, zzfelVar).zzb(zzfef.CUSTOM_RENDER_ACK).zzd(zzcajVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final boolean zzb(zzezz zzezzVar, zzezn zzeznVar) {
        zzezs zzezsVar;
        if (this.zza != null && (zzezsVar = zzeznVar.zzt) != null && zzezsVar.zza != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbcf zzbcfVar) throws Exception {
        this.zza.zze(zzbcfVar);
    }
}
