package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlu {
    private final zzah zza;
    private final SparseArray zzb;

    public zzlu(zzah zzahVar, SparseArray sparseArray) {
        this.zza = zzahVar;
        SparseArray sparseArray2 = new SparseArray(zzahVar.zzb());
        for (int i4 = 0; i4 < zzahVar.zzb(); i4++) {
            int zza = zzahVar.zza(i4);
            zzlt zzltVar = (zzlt) sparseArray.get(zza);
            zzltVar.getClass();
            sparseArray2.append(zza, zzltVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i4) {
        return this.zza.zza(i4);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzlt zzc(int i4) {
        zzlt zzltVar = (zzlt) this.zzb.get(i4);
        zzltVar.getClass();
        return zzltVar;
    }

    public final boolean zzd(int i4) {
        return this.zza.zzc(i4);
    }
}
