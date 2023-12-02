package com.google.android.gms.internal.play_billing;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzbf extends zzbi {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(byte[] bArr, int i4, int i5) {
        super(null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i5) | i5) >= 0) {
                this.zzc = bArr;
                this.zze = 0;
                this.zzd = i5;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
        }
        throw new NullPointerException("buffer");
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzb(byte b4) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr[i4] = b4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e4);
        }
    }

    public final void zzc(byte[] bArr, int i4, int i5) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i5);
            this.zze += i5;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i5)), e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzd(int i4, boolean z3) throws IOException {
        zzq(i4 << 3);
        zzb(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zze(int i4, zzba zzbaVar) throws IOException {
        zzq((i4 << 3) | 2);
        zzq(zzbaVar.zzd());
        zzbaVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzf(int i4, int i5) throws IOException {
        zzq((i4 << 3) | 5);
        zzg(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzg(int i4) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i5 = this.zze;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.zze = i8 + 1;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzh(int i4, long j4) throws IOException {
        zzq((i4 << 3) | 1);
        zzi(j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzi(long j4) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i4 = this.zze;
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
            this.zze = i11 + 1;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzj(int i4, int i5) throws IOException {
        zzq(i4 << 3);
        zzk(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzk(int i4) throws IOException {
        if (i4 >= 0) {
            zzq(i4);
        } else {
            zzs(i4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzl(byte[] bArr, int i4, int i5) throws IOException {
        zzc(bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzm(int i4, String str) throws IOException {
        zzq((i4 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i4 = this.zze;
        try {
            int zzx = zzbi.zzx(str.length() * 3);
            int zzx2 = zzbi.zzx(str.length());
            if (zzx2 == zzx) {
                int i5 = i4 + zzx2;
                this.zze = i5;
                int zzb = zzev.zzb(str, this.zzc, i5, this.zzd - i5);
                this.zze = i4;
                zzq((zzb - i4) - zzx2);
                this.zze = zzb;
                return;
            }
            zzq(zzev.zzc(str));
            byte[] bArr = this.zzc;
            int i6 = this.zze;
            this.zze = zzev.zzb(str, bArr, i6, this.zzd - i6);
        } catch (zzeu e4) {
            this.zze = i4;
            zzB(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzbg(e5);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzo(int i4, int i5) throws IOException {
        zzq((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzp(int i4, int i5) throws IOException {
        zzq(i4 << 3);
        zzq(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzq(int i4) throws IOException {
        while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
            try {
                byte[] bArr = this.zzc;
                int i5 = this.zze;
                this.zze = i5 + 1;
                bArr[i5] = (byte) ((i4 & 127) | 128);
                i4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e4);
            }
        }
        byte[] bArr2 = this.zzc;
        int i6 = this.zze;
        this.zze = i6 + 1;
        bArr2[i6] = (byte) i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzr(int i4, long j4) throws IOException {
        zzq(i4 << 3);
        zzs(j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final void zzs(long j4) throws IOException {
        boolean z3;
        z3 = zzbi.zzd;
        if (z3 && this.zzd - this.zze >= 10) {
            while ((j4 & (-128)) != 0) {
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzeq.zzn(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            byte[] bArr2 = this.zzc;
            int i5 = this.zze;
            this.zze = i5 + 1;
            zzeq.zzn(bArr2, i5, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzc;
                int i6 = this.zze;
                this.zze = i6 + 1;
                bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                j4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e4);
            }
        }
        byte[] bArr4 = this.zzc;
        int i7 = this.zze;
        this.zze = i7 + 1;
        bArr4[i7] = (byte) j4;
    }
}
