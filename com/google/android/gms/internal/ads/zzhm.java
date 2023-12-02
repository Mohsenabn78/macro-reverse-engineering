package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzhm {
    @Nullable
    public byte[] zza;
    @Nullable
    public byte[] zzb;
    public int zzc;
    @Nullable
    public int[] zzd;
    @Nullable
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi;
    @Nullable
    private final zzhl zzj;

    public zzhm() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.zzi = cryptoInfo;
        this.zzj = zzfj.zza >= 24 ? new zzhl(cryptoInfo, null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i4) {
        if (i4 == 0) {
            return;
        }
        if (this.zzd == null) {
            int[] iArr = new int[1];
            this.zzd = iArr;
            this.zzi.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.zzd;
        iArr2[0] = iArr2[0] + i4;
    }

    public final void zzc(int i4, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i5, int i6, int i7) {
        this.zzf = i4;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i5;
        this.zzg = i6;
        this.zzh = i7;
        MediaCodec.CryptoInfo cryptoInfo = this.zzi;
        cryptoInfo.numSubSamples = i4;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i5;
        if (zzfj.zza >= 24) {
            zzhl zzhlVar = this.zzj;
            zzhlVar.getClass();
            zzhl.zza(zzhlVar, i6, i7);
        }
    }
}
