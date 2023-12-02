package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcqq implements zzcwu, zzcwa {
    private final Context zza;
    @Nullable
    private final zzcez zzb;
    private final zzezn zzc;
    private final zzbzx zzd;
    @Nullable
    private zzfgw zze;
    private boolean zzf;

    public zzcqq(Context context, @Nullable zzcez zzcezVar, zzezn zzeznVar, zzbzx zzbzxVar) {
        this.zza = context;
        this.zzb = zzcezVar;
        this.zzc = zzeznVar;
        this.zzd = zzbzxVar;
    }

    private final synchronized void zza() {
        zzeca zzecaVar;
        zzecb zzecbVar;
        if (!this.zzc.zzU) {
            return;
        }
        if (this.zzb == null) {
            return;
        }
        if (!com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zza)) {
            return;
        }
        zzbzx zzbzxVar = this.zzd;
        String str = zzbzxVar.zzb + "." + zzbzxVar.zzc;
        String zza = this.zzc.zzW.zza();
        if (this.zzc.zzW.zzb() == 1) {
            zzecaVar = zzeca.VIDEO;
            zzecbVar = zzecb.DEFINED_BY_JAVASCRIPT;
        } else {
            zzecaVar = zzeca.HTML_DISPLAY;
            if (this.zzc.zzf == 1) {
                zzecbVar = zzecb.ONE_PIXEL;
            } else {
                zzecbVar = zzecb.BEGIN_TO_RENDER;
            }
        }
        zzfgw zza2 = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzb.zzG(), "", "javascript", zza, zzecbVar, zzecaVar, this.zzc.zzam);
        this.zze = zza2;
        zzcez zzcezVar = this.zzb;
        if (zza2 != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zze, (View) zzcezVar);
            this.zzb.zzap(this.zze);
            com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zze);
            this.zzf = true;
            this.zzb.zzd("onSdkLoaded", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final synchronized void zzl() {
        zzcez zzcezVar;
        if (!this.zzf) {
            zza();
        }
        if (this.zzc.zzU && this.zze != null && (zzcezVar = this.zzb) != null) {
            zzcezVar.zzd("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final synchronized void zzn() {
        if (this.zzf) {
            return;
        }
        zza();
    }
}
