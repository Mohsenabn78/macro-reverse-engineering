package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcvc implements zzgwe {
    private final zzcvb zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzcvc(zzcvb zzcvbVar, zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4) {
        this.zza = zzcvbVar;
        this.zzb = zzgwrVar;
        this.zzc = zzgwrVar2;
        this.zzd = zzgwrVar3;
        this.zze = zzgwrVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    @Nullable
    public final /* synthetic */ Object zzb() {
        String str;
        Context context = (Context) this.zzb.zzb();
        zzbzx zza = ((zzchm) this.zzc).zza();
        zzezn zza2 = ((zzcrt) this.zzd).zza();
        zzbwo zzbwoVar = new zzbwo();
        if (zza2.zzB == null) {
            return null;
        }
        zzezs zzezsVar = zza2.zzt;
        if (zzezsVar == null) {
            str = null;
        } else {
            str = zzezsVar.zzb;
        }
        return new zzbwn(context, zza, zza2.zzB, str, zzbwoVar);
    }
}
