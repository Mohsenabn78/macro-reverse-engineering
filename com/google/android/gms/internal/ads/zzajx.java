package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajx {
    public static int zza(byte[] bArr, int i4, int i5) {
        while (i4 < i5 && bArr[i4] != 71) {
            i4++;
        }
        return i4;
    }

    public static long zzb(zzfa zzfaVar, int i4, int i5) {
        zzfaVar.zzF(i4);
        if (zzfaVar.zza() < 5) {
            return -9223372036854775807L;
        }
        int zze = zzfaVar.zze();
        if ((8388608 & zze) != 0 || ((zze >> 8) & 8191) != i5 || (zze & 32) == 0 || zzfaVar.zzk() < 7 || zzfaVar.zza() < 7 || (zzfaVar.zzk() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzfaVar.zzB(bArr, 0, 6);
        long j4 = bArr[3] & 255;
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | (j4 + j4) | ((bArr[4] & 255) >> 7);
    }
}
