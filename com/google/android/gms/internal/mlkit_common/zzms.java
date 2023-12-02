package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public abstract class zzms {
    public static zzmr zzh() {
        zzme zzmeVar = new zzme();
        zzmeVar.zzg("NA");
        zzmeVar.zzf(false);
        zzmeVar.zze(false);
        zzmeVar.zzd(ModelType.UNKNOWN);
        zzmeVar.zzb(zziy.NO_ERROR);
        zzmeVar.zza(zzje.UNKNOWN_STATUS);
        zzmeVar.zzc(0);
        return zzmeVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zziy zzc();

    public abstract zzje zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
