package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvl {
    private int zza;
    private final SparseArray zzb;
    private final zzec zzc;

    public zzvl() {
        zzvk zzvkVar = new zzec() { // from class: com.google.android.gms.internal.ads.zzvk
        };
        throw null;
    }

    public final Object zza(int i4) {
        if (this.zza == -1) {
            this.zza = 0;
        }
        while (true) {
            int i5 = this.zza;
            if (i5 > 0 && i4 < this.zzb.keyAt(i5)) {
                this.zza--;
            }
        }
        while (this.zza < this.zzb.size() - 1 && i4 >= this.zzb.keyAt(this.zza + 1)) {
            this.zza++;
        }
        return this.zzb.valueAt(this.zza);
    }

    public final Object zzb() {
        SparseArray sparseArray = this.zzb;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public final void zzc(int i4, Object obj) {
        boolean z3;
        boolean z4 = true;
        if (this.zza == -1) {
            if (this.zzb.size() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzdy.zzf(z3);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            SparseArray sparseArray = this.zzb;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i4 < keyAt) {
                z4 = false;
            }
            zzdy.zzd(z4);
            if (keyAt == i4) {
                SparseArray sparseArray2 = this.zzb;
                zzve.zzl((zzvc) sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.zzb.append(i4, obj);
    }

    public final void zzd() {
        for (int i4 = 0; i4 < this.zzb.size(); i4++) {
            zzve.zzl((zzvc) this.zzb.valueAt(i4));
        }
        this.zza = -1;
        this.zzb.clear();
    }

    public final void zze(int i4) {
        int i5 = 0;
        while (i5 < this.zzb.size() - 1) {
            int i6 = i5 + 1;
            if (i4 >= this.zzb.keyAt(i6)) {
                zzve.zzl((zzvc) this.zzb.valueAt(i5));
                this.zzb.removeAt(i5);
                int i7 = this.zza;
                if (i7 > 0) {
                    this.zza = i7 - 1;
                }
                i5 = i6;
            } else {
                return;
            }
        }
    }

    public final boolean zzf() {
        if (this.zzb.size() == 0) {
            return true;
        }
        return false;
    }

    public zzvl(zzec zzecVar) {
        this.zzb = new SparseArray();
        this.zzc = zzecVar;
        this.zza = -1;
    }
}
