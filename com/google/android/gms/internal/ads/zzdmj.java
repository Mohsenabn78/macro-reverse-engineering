package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmj implements zzbiy {
    private final zzcwn zza;
    @Nullable
    private final zzbvg zzb;
    private final String zzc;
    private final String zzd;

    public zzdmj(zzcwn zzcwnVar, zzezn zzeznVar) {
        this.zza = zzcwnVar;
        this.zzb = zzeznVar.zzm;
        this.zzc = zzeznVar.zzk;
        this.zzd = zzeznVar.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    @ParametersAreNonnullByDefault
    public final void zza(zzbvg zzbvgVar) {
        int i4;
        String str;
        zzbvg zzbvgVar2 = this.zzb;
        if (zzbvgVar2 != null) {
            zzbvgVar = zzbvgVar2;
        }
        if (zzbvgVar != null) {
            str = zzbvgVar.zza;
            i4 = zzbvgVar.zzb;
        } else {
            i4 = 1;
            str = "";
        }
        this.zza.zzd(new zzbur(str, i4), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    public final void zzc() {
        this.zza.zzf();
    }
}
