package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaiy {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zzaiy(int i4, int i5) {
        this.zzc = i4;
        byte[] bArr = new byte[131];
        this.zza = bArr;
        bArr[2] = 1;
    }

    public final void zza(byte[] bArr, int i4, int i5) {
        if (!this.zzd) {
            return;
        }
        int i6 = i5 - i4;
        byte[] bArr2 = this.zza;
        int length = bArr2.length;
        int i7 = this.zzb + i6;
        if (length < i7) {
            this.zza = Arrays.copyOf(bArr2, i7 + i7);
        }
        System.arraycopy(bArr, i4, this.zza, this.zzb, i6);
        this.zzb += i6;
    }

    public final void zzb() {
        this.zzd = false;
        this.zze = false;
    }

    public final void zzc(int i4) {
        boolean z3 = true;
        zzdy.zzf(!this.zzd);
        if (i4 != this.zzc) {
            z3 = false;
        }
        this.zzd = z3;
        if (z3) {
            this.zzb = 3;
            this.zze = false;
        }
    }

    public final boolean zzd(int i4) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= i4;
        this.zzd = false;
        this.zze = true;
        return true;
    }

    public final boolean zze() {
        return this.zze;
    }
}
