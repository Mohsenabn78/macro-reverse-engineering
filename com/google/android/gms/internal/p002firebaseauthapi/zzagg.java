package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.nearby.uwb.RangingPosition;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
/* loaded from: classes4.dex */
abstract class zzagg extends zzagl {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagg(int i4) {
        super(null);
        if (i4 >= 0) {
            byte[] bArr = new byte[Math.max(i4, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagl
    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(byte b4) {
        byte[] bArr = this.zza;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        bArr[i4] = b4;
        this.zzd++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i4) {
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
        this.zzd += 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(long j4) {
        byte[] bArr = this.zza;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j4 >> 8) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j4 >> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (255 & (j4 >> 24));
        int i9 = i8 + 1;
        bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
        this.zzc = i11 + 1;
        bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
        this.zzd += 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(int i4) {
        boolean z3;
        z3 = zzagl.zzb;
        if (z3) {
            long j4 = this.zzc;
            while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                byte[] bArr = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzajy.zzn(bArr, i5, (byte) ((i4 & 127) | 128));
                i4 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i6 = this.zzc;
            this.zzc = i6 + 1;
            zzajy.zzn(bArr2, i6, (byte) i4);
            this.zzd += (int) (this.zzc - j4);
            return;
        }
        while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
            byte[] bArr3 = this.zza;
            int i7 = this.zzc;
            this.zzc = i7 + 1;
            bArr3[i7] = (byte) ((i4 & 127) | 128);
            this.zzd++;
            i4 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i8 = this.zzc;
        this.zzc = i8 + 1;
        bArr4[i8] = (byte) i4;
        this.zzd++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(long j4) {
        boolean z3;
        z3 = zzagl.zzb;
        if (z3) {
            long j5 = this.zzc;
            while ((j4 & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzajy.zzn(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            zzajy.zzn(bArr2, i5, (byte) j4);
            this.zzd += (int) (this.zzc - j5);
            return;
        }
        while ((j4 & (-128)) != 0) {
            byte[] bArr3 = this.zza;
            int i6 = this.zzc;
            this.zzc = i6 + 1;
            bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
            this.zzd++;
            j4 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        bArr4[i7] = (byte) j4;
        this.zzd++;
    }
}
