package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgop extends zzgot {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgop(byte[] bArr, int i4, int i5) {
        super(null);
        int length = bArr.length;
        if (((length - i5) | i5) >= 0) {
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i5;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzJ(byte b4) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr[i4] = b4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzK(int i4, boolean z3) throws IOException {
        zzs(i4 << 3);
        zzJ(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzL(int i4, zzgoe zzgoeVar) throws IOException {
        zzs((i4 << 3) | 2);
        zzs(zzgoeVar.zzd());
        zzgoeVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgot, com.google.android.gms.internal.ads.zzgnt
    public final void zza(byte[] bArr, int i4, int i5) throws IOException {
        zze(bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i4, int i5) throws IOException {
        try {
            System.arraycopy(bArr, i4, this.zza, this.zzc, i5);
            this.zzc += i5;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i5)), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzh(int i4, int i5) throws IOException {
        zzs((i4 << 3) | 5);
        zzi(i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzi(int i4) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i5 = this.zzc;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.zzc = i8 + 1;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzj(int i4, long j4) throws IOException {
        zzs((i4 << 3) | 1);
        zzk(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzk(long j4) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i4 = this.zzc;
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) j4) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j4 >> 8)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j4 >> 16)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j4 >> 24)) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
            this.zzc = i11 + 1;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzl(int i4, int i5) throws IOException {
        zzs(i4 << 3);
        zzm(i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzm(int i4) throws IOException {
        if (i4 >= 0) {
            zzs(i4);
        } else {
            zzu(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzn(int i4, zzgqw zzgqwVar, zzgrp zzgrpVar) throws IOException {
        zzs((i4 << 3) | 2);
        zzs(((zzgnn) zzgqwVar).zzat(zzgrpVar));
        zzgrpVar.zzm(zzgqwVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzo(int i4, String str) throws IOException {
        zzs((i4 << 3) | 2);
        zzp(str);
    }

    public final void zzp(String str) throws IOException {
        int i4 = this.zzc;
        try {
            int zzA = zzgot.zzA(str.length() * 3);
            int zzA2 = zzgot.zzA(str.length());
            if (zzA2 == zzA) {
                int i5 = i4 + zzA2;
                this.zzc = i5;
                int zzd = zzgsv.zzd(str, this.zza, i5, this.zzb - i5);
                this.zzc = i4;
                zzs((zzd - i4) - zzA2);
                this.zzc = zzd;
                return;
            }
            zzs(zzgsv.zze(str));
            byte[] bArr = this.zza;
            int i6 = this.zzc;
            this.zzc = zzgsv.zzd(str, bArr, i6, this.zzb - i6);
        } catch (zzgsu e4) {
            this.zzc = i4;
            zzE(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzgoq(e5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzq(int i4, int i5) throws IOException {
        zzs((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzr(int i4, int i5) throws IOException {
        zzs(i4 << 3);
        zzs(i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzs(int i4) throws IOException {
        while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
            try {
                byte[] bArr = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                bArr[i5] = (byte) ((i4 & 127) | 128);
                i4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e4);
            }
        }
        byte[] bArr2 = this.zza;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        bArr2[i6] = (byte) i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzt(int i4, long j4) throws IOException {
        zzs(i4 << 3);
        zzu(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzu(long j4) throws IOException {
        boolean z3;
        z3 = zzgot.zzb;
        if (z3 && this.zzb - this.zzc >= 10) {
            while ((j4 & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzgsq.zzq(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            zzgsq.zzq(bArr2, i5, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                j4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e4);
            }
        }
        byte[] bArr4 = this.zza;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        bArr4[i7] = (byte) j4;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzI() {
    }
}
