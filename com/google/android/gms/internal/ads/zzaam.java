package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaam implements zzaax {
    private final zzt zzb;
    private final long zzc;
    private long zzd;
    private int zzf;
    private int zzg;
    private byte[] zze = new byte[65536];
    private final byte[] zza = new byte[4096];

    static {
        zzbq.zzb("media3.extractor");
    }

    public zzaam(zzt zztVar, long j4, long j5) {
        this.zzb = zztVar;
        this.zzd = j4;
        this.zzc = j5;
    }

    private final int zzp(byte[] bArr, int i4, int i5) {
        int i6 = this.zzg;
        if (i6 == 0) {
            return 0;
        }
        int min = Math.min(i6, i5);
        System.arraycopy(this.zze, 0, bArr, i4, min);
        zzu(min);
        return min;
    }

    private final int zzq(byte[] bArr, int i4, int i5, int i6, boolean z3) throws IOException {
        if (!Thread.interrupted()) {
            int zza = this.zzb.zza(bArr, i4 + i6, i5 - i6);
            if (zza == -1) {
                if (i6 == 0 && z3) {
                    return -1;
                }
                throw new EOFException();
            }
            return i6 + zza;
        }
        throw new InterruptedIOException();
    }

    private final int zzr(int i4) {
        int min = Math.min(this.zzg, i4);
        zzu(min);
        return min;
    }

    private final void zzs(int i4) {
        if (i4 != -1) {
            this.zzd += i4;
        }
    }

    private final void zzt(int i4) {
        int i5 = this.zzf + i4;
        int length = this.zze.length;
        if (i5 > length) {
            this.zze = Arrays.copyOf(this.zze, Math.max(65536 + i5, Math.min(length + length, i5 + 524288)));
        }
    }

    private final void zzu(int i4) {
        byte[] bArr;
        int i5 = this.zzg - i4;
        this.zzg = i5;
        this.zzf = 0;
        byte[] bArr2 = this.zze;
        if (i5 < bArr2.length - 524288) {
            bArr = new byte[65536 + i5];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i4, bArr, 0, i5);
        this.zze = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        int zzp = zzp(bArr, i4, i5);
        if (zzp == 0) {
            zzp = zzq(bArr, i4, i5, 0, true);
        }
        zzs(zzp);
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final int zzb(byte[] bArr, int i4, int i5) throws IOException {
        int min;
        zzt(i5);
        int i6 = this.zzg;
        int i7 = this.zzf;
        int i8 = i6 - i7;
        if (i8 == 0) {
            min = zzq(this.zze, i7, i5, 0, true);
            if (min == -1) {
                return -1;
            }
            this.zzg += min;
        } else {
            min = Math.min(i5, i8);
        }
        System.arraycopy(this.zze, this.zzf, bArr, i4, min);
        this.zzf += min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final int zzc(int i4) throws IOException {
        int zzr = zzr(1);
        if (zzr == 0) {
            zzr = zzq(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzs(zzr);
        return zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final long zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final long zze() {
        return this.zzd + this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final long zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzg(int i4) throws IOException {
        zzl(i4, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzh(byte[] bArr, int i4, int i5) throws IOException {
        zzm(bArr, i4, i5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzi(byte[] bArr, int i4, int i5) throws IOException {
        zzn(bArr, i4, i5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzj() {
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzk(int i4) throws IOException {
        zzo(i4, false);
    }

    public final boolean zzl(int i4, boolean z3) throws IOException {
        zzt(i4);
        int i5 = this.zzg - this.zzf;
        while (i5 < i4) {
            i5 = zzq(this.zze, this.zzf, i4, i5, z3);
            if (i5 == -1) {
                return false;
            }
            this.zzg = this.zzf + i5;
        }
        this.zzf += i4;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final boolean zzm(byte[] bArr, int i4, int i5, boolean z3) throws IOException {
        if (!zzl(i5, z3)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i5, bArr, i4, i5);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final boolean zzn(byte[] bArr, int i4, int i5, boolean z3) throws IOException {
        int zzp = zzp(bArr, i4, i5);
        while (zzp < i5 && zzp != -1) {
            zzp = zzq(bArr, i4, i5, zzp, z3);
        }
        zzs(zzp);
        if (zzp != -1) {
            return true;
        }
        return false;
    }

    public final boolean zzo(int i4, boolean z3) throws IOException {
        int zzr = zzr(i4);
        while (zzr < i4 && zzr != -1) {
            zzr = zzq(this.zza, -zzr, Math.min(i4, zzr + 4096), zzr, false);
        }
        zzs(zzr);
        if (zzr != -1) {
            return true;
        }
        return false;
    }
}
