package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdex implements zzcwu, com.google.android.gms.ads.internal.overlay.zzo, zzcwa {
    @Nullable
    @VisibleForTesting
    zzfgw zza;
    private final Context zzb;
    @Nullable
    private final zzcez zzc;
    private final zzezn zzd;
    private final zzbzx zze;
    private final zzaxj zzf;

    public zzdex(Context context, @Nullable zzcez zzcezVar, zzezn zzeznVar, zzbzx zzbzxVar, zzaxj zzaxjVar) {
        this.zzb = context;
        this.zzc = zzcezVar;
        this.zzd = zzeznVar;
        this.zze = zzbzxVar;
        this.zzf = zzaxjVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzb() {
        if (this.zza != null && this.zzc != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeR)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzf(int i4) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        if (this.zza != null && this.zzc != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeR)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        zzecb zzecbVar;
        zzecb zzecbVar2;
        zzeca zzecaVar;
        zzaxj zzaxjVar = this.zzf;
        if ((zzaxjVar == zzaxj.REWARD_BASED_VIDEO_AD || zzaxjVar == zzaxj.INTERSTITIAL || zzaxjVar == zzaxj.APP_OPEN) && this.zzd.zzU && this.zzc != null && com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zzb)) {
            zzbzx zzbzxVar = this.zze;
            String str = zzbzxVar.zzb + "." + zzbzxVar.zzc;
            String zza = this.zzd.zzW.zza();
            if (this.zzd.zzW.zzb() == 1) {
                zzecaVar = zzeca.VIDEO;
                zzecbVar2 = zzecb.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzZ == 2) {
                    zzecbVar = zzecb.UNSPECIFIED;
                } else {
                    zzecbVar = zzecb.BEGIN_TO_RENDER;
                }
                zzecbVar2 = zzecbVar;
                zzecaVar = zzeca.HTML_DISPLAY;
            }
            zzfgw zza2 = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzc.zzG(), "", "javascript", zza, zzecbVar2, zzecaVar, this.zzd.zzam);
            this.zza = zza2;
            if (zza2 != null) {
                com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zza, (View) this.zzc);
                this.zzc.zzap(this.zza);
                com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zza);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbF() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zze() {
    }
}
