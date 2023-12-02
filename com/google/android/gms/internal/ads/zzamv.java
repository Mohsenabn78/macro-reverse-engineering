package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamv {
    public static double zza(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return (((((bArr[0] << Ascii.CAN) & (-16777216)) | ((bArr[1] << Ascii.DLE) & 16711680)) | (65280 & (bArr[2] << 8))) | (bArr[3] & 255)) / 1.073741824E9d;
    }

    public static double zzb(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return (((((bArr[0] << Ascii.CAN) & (-16777216)) | ((bArr[1] << Ascii.DLE) & 16711680)) | (65280 & (bArr[2] << 8))) | (bArr[3] & 255)) / 65536.0d;
    }

    public static int zzc(byte b4) {
        if (b4 < 0) {
            return b4 + 256;
        }
        return b4;
    }

    public static int zzd(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static long zze(ByteBuffer byteBuffer) {
        long j4 = byteBuffer.getInt();
        if (j4 < 0) {
            return j4 + 4294967296L;
        }
        return j4;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long zze = zze(byteBuffer) << 32;
        if (zze >= 0) {
            return zze + zze(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
