package com.google.android.gms.internal.wearable;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbb extends zzbe {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(byte[] bArr, int i4, int i5) {
        super(null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i5) | i5) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i5;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
        }
        throw new NullPointerException("buffer");
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzb(byte b4) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr[i4] = b4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    public final void zzc(byte[] bArr, int i4, int i5) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i5);
            this.zzd += i5;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i5)), e4);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzd(int i4, boolean z3) throws IOException {
        zzq(i4 << 3);
        zzb(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zze(int i4, zzaw zzawVar) throws IOException {
        zzq((i4 << 3) | 2);
        zzq(zzawVar.zzd());
        zzawVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzf(int i4, int i5) throws IOException {
        zzq((i4 << 3) | 5);
        zzg(i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzg(int i4) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i5 = this.zzd;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.zzd = i8 + 1;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzh(int i4, long j4) throws IOException {
        zzq((i4 << 3) | 1);
        zzi(j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzi(long j4) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
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
            this.zzd = i11 + 1;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzj(int i4, int i5) throws IOException {
        zzq(i4 << 3);
        zzk(i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzk(int i4) throws IOException {
        if (i4 >= 0) {
            zzq(i4);
        } else {
            zzs(i4);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzl(byte[] bArr, int i4, int i5) throws IOException {
        zzc(bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzm(int i4, String str) throws IOException {
        zzq((i4 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i4 = this.zzd;
        try {
            int zzA = zzbe.zzA(str.length() * 3);
            int zzA2 = zzbe.zzA(str.length());
            if (zzA2 == zzA) {
                int i5 = i4 + zzA2;
                this.zzd = i5;
                int zzb = zzet.zzb(str, this.zzb, i5, this.zzc - i5);
                this.zzd = i4;
                zzq((zzb - i4) - zzA2);
                this.zzd = zzb;
                return;
            }
            zzq(zzet.zzc(str));
            byte[] bArr = this.zzb;
            int i6 = this.zzd;
            this.zzd = zzet.zzb(str, bArr, i6, this.zzc - i6);
        } catch (zzes e4) {
            this.zzd = i4;
            zzE(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzbc(e5);
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzo(int i4, int i5) throws IOException {
        zzq((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzp(int i4, int i5) throws IOException {
        zzq(i4 << 3);
        zzq(i5);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzq(int i4) throws IOException {
        while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                bArr[i5] = (byte) ((i4 & 127) | 128);
                i4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
            }
        }
        byte[] bArr2 = this.zzb;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        bArr2[i6] = (byte) i4;
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzr(int i4, long j4) throws IOException {
        zzq(i4 << 3);
        zzs(j4);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    public final void zzs(long j4) throws IOException {
        boolean z3;
        z3 = zzbe.zzc;
        if (z3 && this.zzc - this.zzd >= 10) {
            while ((j4 & (-128)) != 0) {
                byte[] bArr = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                zzeo.zzn(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            byte[] bArr2 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            zzeo.zzn(bArr2, i5, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzb;
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                j4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzbc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e4);
            }
        }
        byte[] bArr4 = this.zzb;
        int i7 = this.zzd;
        this.zzd = i7 + 1;
        bArr4[i7] = (byte) j4;
    }
}
