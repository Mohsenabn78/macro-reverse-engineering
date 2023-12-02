package com.google.android.gms.internal.mlkit_translate;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public abstract class zzpw {
    public static zzpv zzh() {
        zzpg zzpgVar = new zzpg();
        zzpgVar.zzg("NA");
        zzpgVar.zzf(false);
        zzpgVar.zze(false);
        zzpgVar.zzd(ModelType.UNKNOWN);
        zzpgVar.zzb(zzld.NO_ERROR);
        zzpgVar.zza(zzlj.UNKNOWN_STATUS);
        zzpgVar.zzc(0);
        return zzpgVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzld zzc();

    public abstract zzlj zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
