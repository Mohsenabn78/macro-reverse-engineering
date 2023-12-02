package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzh {
    public static final zzh zza;
    public static final zzh zzb;
    private final boolean zzc;
    private final boolean zzd = false;
    private final zzao zze;

    static {
        zzf zzfVar = new zzf(null);
        zzfVar.zza();
        zza = zzfVar.zzc();
        zzf zzfVar2 = new zzf(null);
        zzfVar2.zzb();
        zzb = zzfVar2.zzc();
    }

    public /* synthetic */ zzh(boolean z3, boolean z4, zzao zzaoVar, zzg zzgVar) {
        this.zzc = z3;
        this.zze = zzaoVar;
    }

    public static /* bridge */ /* synthetic */ boolean zza(zzh zzhVar) {
        boolean z3 = zzhVar.zzd;
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zzb(zzh zzhVar) {
        return zzhVar.zzc;
    }

    public static /* bridge */ /* synthetic */ int zzc(zzh zzhVar, Context context, zzq zzqVar) {
        zzao zzaoVar = zzhVar.zze;
        int size = zzaoVar.size();
        int i4 = 0;
        while (i4 < size) {
            int zza2 = ((zzr) zzaoVar.get(i4)).zza();
            int i5 = zza2 - 1;
            if (zza2 != 0) {
                i4++;
                if (i5 == 0) {
                    return 1;
                }
                if (i5 == 1) {
                    return 2;
                }
            } else {
                throw null;
            }
        }
        return 3;
    }
}
