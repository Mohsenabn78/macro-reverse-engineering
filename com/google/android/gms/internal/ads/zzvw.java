package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzvw implements zzxa {
    protected final zzcy zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzam[] zzd;
    private int zze;

    public zzvw(zzcy zzcyVar, int[] iArr, int i4) {
        boolean z3;
        int length = iArr.length;
        if (length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        zzcyVar.getClass();
        this.zza = zzcyVar;
        this.zzb = length;
        this.zzd = new zzam[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.zzd[i5] = zzcyVar.zzb(iArr[i5]);
        }
        Arrays.sort(this.zzd, new Comparator() { // from class: com.google.android.gms.internal.ads.zzvv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzam) obj2).zzi - ((zzam) obj).zzi;
            }
        });
        this.zzc = new int[this.zzb];
        for (int i6 = 0; i6 < this.zzb; i6++) {
            this.zzc[i6] = zzcyVar.zza(this.zzd[i6]);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzvw zzvwVar = (zzvw) obj;
            if (this.zza == zzvwVar.zza && Arrays.equals(this.zzc, zzvwVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zze;
        if (i4 == 0) {
            int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
            this.zze = identityHashCode;
            return identityHashCode;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zza(int i4) {
        return this.zzc[0];
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzb(int i4) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            if (this.zzc[i5] == i4) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzc() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final zzam zzd(int i4) {
        return this.zzd[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final zzcy zze() {
        return this.zza;
    }
}
