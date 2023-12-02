package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzxc {
    private final String[] zza;
    private final int[] zzb;
    private final zzvn[] zzc;
    private final int[] zzd;
    private final int[][][] zze;
    private final zzvn zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzxc(String[] strArr, int[] iArr, zzvn[] zzvnVarArr, int[] iArr2, int[][][] iArr3, zzvn zzvnVar) {
        this.zza = strArr;
        this.zzb = iArr;
        this.zzc = zzvnVarArr;
        this.zze = iArr3;
        this.zzd = iArr2;
        this.zzf = zzvnVar;
    }

    public final int zza(int i4, int i5, boolean z3) {
        int i6 = this.zzc[i4].zzb(i5).zzb;
        int[] iArr = new int[1];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 <= 0; i9++) {
            if ((this.zze[i4][i5][i9] & 7) == 4) {
                iArr[i8] = i9;
                i8++;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, i8);
        String str = null;
        boolean z4 = false;
        int i10 = 0;
        int i11 = 16;
        while (i7 < copyOf.length) {
            String str2 = this.zzc[i4].zzb(i5).zzb(copyOf[i7]).zzm;
            int i12 = i10 + 1;
            if (i10 == 0) {
                str = str2;
            } else {
                z4 |= !zzfj.zzC(str, str2);
            }
            i11 = Math.min(i11, this.zze[i4][i5][i7] & 24);
            i7++;
            i10 = i12;
        }
        if (z4) {
            return Math.min(i11, this.zzd[i4]);
        }
        return i11;
    }

    public final int zzb(int i4, int i5, int i6) {
        return this.zze[i4][i5][i6];
    }

    public final int zzc(int i4) {
        return this.zzb[i4];
    }

    public final zzvn zzd(int i4) {
        return this.zzc[i4];
    }

    public final zzvn zze() {
        return this.zzf;
    }
}
