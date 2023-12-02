package com.google.android.gms.internal.icing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzdh {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzci zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zzch zzchVar = new zzch(bArr, 0, 0, false, null);
        try {
            zzchVar.zza(0);
            zze = zzchVar;
        } catch (zzdj e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t3) {
        t3.getClass();
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzb(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzc(byte[] bArr) {
        return zzfr.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static int zzf(boolean z3) {
        if (z3) {
            return 1231;
        }
        return 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int zzh = zzh(length, bArr, 0, length);
        if (zzh == 0) {
            return 1;
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzi(Object obj, Object obj2) {
        return ((zzee) obj).zzy().zzf((zzee) obj2).zzl();
    }
}
