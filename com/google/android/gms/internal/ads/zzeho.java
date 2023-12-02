package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeho implements zzecc {
    private final Context zza;
    private final zzcpy zzb;
    @Nullable
    private final zzbck zzc;
    private final zzfwn zzd;
    private final zzfel zze;

    public zzeho(Context context, zzcpy zzcpyVar, zzfel zzfelVar, zzfwn zzfwnVar, @Nullable zzbck zzbckVar) {
        this.zza = context;
        this.zzb = zzcpyVar;
        this.zze = zzfelVar;
        this.zzd = zzfwnVar;
        this.zzc = zzbckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(zzezz zzezzVar, zzezn zzeznVar) {
        zzcpc zza = this.zzb.zza(new zzcrs(zzezzVar, zzeznVar, null), new zzehm(this, new View(this.zza), null, new zzcrb() { // from class: com.google.android.gms.internal.ads.zzehk
            @Override // com.google.android.gms.internal.ads.zzcrb
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return null;
            }
        }, (zzezo) zzeznVar.zzv.get(0)));
        zzehn zzk = zza.zzk();
        zzezs zzezsVar = zzeznVar.zzt;
        final zzbcf zzbcfVar = new zzbcf(zzk, zzezsVar.zzb, zzezsVar.zza);
        zzfel zzfelVar = this.zze;
        return zzfdv.zzd(new zzfdp() { // from class: com.google.android.gms.internal.ads.zzehl
            @Override // com.google.android.gms.internal.ads.zzfdp
            public final void zza() {
                zzeho.this.zzc(zzbcfVar);
            }
        }, this.zzd, zzfef.CUSTOM_RENDER_SYN, zzfelVar).zzb(zzfef.CUSTOM_RENDER_ACK).zzd(zzfwc.zzh(zza.zza())).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final boolean zzb(zzezz zzezzVar, zzezn zzeznVar) {
        zzezs zzezsVar;
        if (this.zzc != null && (zzezsVar = zzeznVar.zzt) != null && zzezsVar.zza != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbcf zzbcfVar) throws Exception {
        this.zzc.zze(zzbcfVar);
    }
}
