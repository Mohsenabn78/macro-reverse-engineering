package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzapb {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzapb(byte[] bArr) {
        for (int i4 = 0; i4 < 256; i4++) {
            this.zza[i4] = (byte) i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            byte[] bArr2 = this.zza;
            byte b4 = bArr2[i6];
            i5 = (i5 + b4 + bArr[i6 % bArr.length]) & 255;
            bArr2[i6] = bArr2[i5];
            bArr2[i5] = b4;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i4 = this.zzb;
        int i5 = this.zzc;
        for (int i6 = 0; i6 < 256; i6++) {
            byte[] bArr2 = this.zza;
            i4 = (i4 + 1) & 255;
            byte b4 = bArr2[i4];
            i5 = (i5 + b4) & 255;
            bArr2[i4] = bArr2[i5];
            bArr2[i5] = b4;
            bArr[i6] = (byte) (bArr2[(bArr2[i4] + b4) & 255] ^ bArr[i6]);
        }
        this.zzb = i4;
        this.zzc = i5;
    }
}
