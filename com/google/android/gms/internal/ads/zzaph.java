package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaph {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    public static String zza(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] zzg;
        Vector zzb2 = zzb(bArr, 255);
        if (zzb2 != null && zzb2.size() != 0) {
            zzaoz zza2 = zzapa.zza();
            int size = zzb2.size();
            for (int i4 = 0; i4 < size; i4++) {
                zza2.zza(zzgoe.zzv(zzg((byte[]) zzb2.get(i4), str, false), 0, 256));
            }
            byte[] zze2 = zze(bArr);
            zzgoe zzgoeVar = zzgoe.zzb;
            zza2.zzb(zzgoe.zzv(zze2, 0, zze2.length));
            zzg = ((zzapa) zza2.zzal()).zzax();
        } else {
            zzg = zzg(zzf(4096).zzax(), str, true);
        }
        return zzapd.zza(zzg, true);
    }

    static Vector zzb(byte[] bArr, int i4) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i5 = length + 254;
        Vector vector = new Vector();
        for (int i6 = 0; i6 < i5 / 255; i6++) {
            int i7 = i6 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i7 > 255) {
                    length2 = i7 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i7, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static void zzd() {
        synchronized (zzf) {
            if (!zza) {
                zza = true;
                new Thread(new zzapg(null)).start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001e, code lost:
        r1.reset();
        r1.update(r6);
        r6 = com.google.android.gms.internal.ads.zzaph.zzd.digest();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] zze(byte[] r6) throws java.security.NoSuchAlgorithmException {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaph.zze
            monitor-enter(r0)
            zzd()     // Catch: java.lang.Throwable -> L34
            r1 = 0
            java.util.concurrent.CountDownLatch r2 = com.google.android.gms.internal.ads.zzaph.zzb     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            r4 = 2
            boolean r2 = r2.await(r4, r3)     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            if (r2 != 0) goto L14
            goto L1c
        L14:
            java.security.MessageDigest r2 = com.google.android.gms.internal.ads.zzaph.zzd     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L19
            goto L1c
        L19:
            r1 = r2
            goto L1c
        L1b:
        L1c:
            if (r1 == 0) goto L2c
            r1.reset()     // Catch: java.lang.Throwable -> L34
            r1.update(r6)     // Catch: java.lang.Throwable -> L34
            java.security.MessageDigest r6 = com.google.android.gms.internal.ads.zzaph.zzd     // Catch: java.lang.Throwable -> L34
            byte[] r6 = r6.digest()     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return r6
        L2c:
            java.security.NoSuchAlgorithmException r6 = new java.security.NoSuchAlgorithmException     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "Cannot compute hash"
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L34
            throw r6     // Catch: java.lang.Throwable -> L34
        L34:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaph.zze(byte[]):byte[]");
    }

    static zzaon zzf(int i4) {
        zzanq zza2 = zzaon.zza();
        zza2.zzD(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return (zzaon) zza2.zzal();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z3) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int i4;
        byte[] array;
        int length = bArr.length;
        if (true != z3) {
            i4 = 255;
        } else {
            i4 = 239;
        }
        if (length > i4) {
            bArr = zzf(4096).zzax();
        }
        int length2 = bArr.length;
        if (length2 < i4) {
            byte[] bArr2 = new byte[i4 - length2];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i4 + 1).put((byte) length2).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i4 + 1).put((byte) length2).put(bArr).array();
        }
        if (z3) {
            array = ByteBuffer.allocate(256).put(zze(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        zzapi[] zzapiVarArr = new zzaqh().zzcG;
        int length3 = zzapiVarArr.length;
        for (int i5 = 0; i5 < 12; i5++) {
            zzapiVarArr[i5].zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzapb(str.getBytes("UTF-8")).zza(bArr3);
        }
        return bArr3;
    }
}
