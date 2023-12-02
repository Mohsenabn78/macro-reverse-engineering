package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzxh {
    public final int zza;
    public final zzll[] zzb;
    public final zzxa[] zzc;
    public final zzdh zzd;
    @Nullable
    public final Object zze;

    public zzxh(zzll[] zzllVarArr, zzxa[] zzxaVarArr, zzdh zzdhVar, @Nullable Object obj) {
        this.zzb = zzllVarArr;
        this.zzc = (zzxa[]) zzxaVarArr.clone();
        this.zzd = zzdhVar;
        this.zze = obj;
        this.zza = zzllVarArr.length;
    }

    public final boolean zza(@Nullable zzxh zzxhVar, int i4) {
        if (zzxhVar == null || !zzfj.zzC(this.zzb[i4], zzxhVar.zzb[i4]) || !zzfj.zzC(this.zzc[i4], zzxhVar.zzc[i4])) {
            return false;
        }
        return true;
    }

    public final boolean zzb(int i4) {
        if (this.zzb[i4] != null) {
            return true;
        }
        return false;
    }
}
