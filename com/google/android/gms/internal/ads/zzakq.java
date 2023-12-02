package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzakq {
    public static X509Certificate[][] zza(String str) throws zzakn, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair zzc = zzakr.zzc(randomAccessFile);
            if (zzc != null) {
                ByteBuffer byteBuffer = (ByteBuffer) zzc.first;
                long longValue = ((Long) zzc.second).longValue();
                long j4 = (-20) + longValue;
                if (j4 >= 0) {
                    randomAccessFile.seek(j4);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new zzakn("ZIP64 APK not supported");
                    }
                }
                long zza = zzakr.zza(byteBuffer);
                if (zza < longValue) {
                    if (zzakr.zzb(byteBuffer) + zza == longValue) {
                        if (zza >= 32) {
                            ByteBuffer allocate = ByteBuffer.allocate(24);
                            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                            allocate.order(byteOrder);
                            randomAccessFile.seek(zza - allocate.capacity());
                            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                                int i4 = 0;
                                long j5 = allocate.getLong(0);
                                if (j5 >= allocate.capacity() && j5 <= 2147483639) {
                                    int i5 = (int) (8 + j5);
                                    long j6 = zza - i5;
                                    if (j6 >= 0) {
                                        ByteBuffer allocate2 = ByteBuffer.allocate(i5);
                                        allocate2.order(byteOrder);
                                        randomAccessFile.seek(j6);
                                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                                        long j7 = allocate2.getLong(0);
                                        if (j7 == j5) {
                                            Pair create = Pair.create(allocate2, Long.valueOf(j6));
                                            ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
                                            long longValue2 = ((Long) create.second).longValue();
                                            if (byteBuffer2.order() == byteOrder) {
                                                int capacity = byteBuffer2.capacity() - 24;
                                                if (capacity >= 8) {
                                                    int capacity2 = byteBuffer2.capacity();
                                                    if (capacity <= byteBuffer2.capacity()) {
                                                        int limit = byteBuffer2.limit();
                                                        int position = byteBuffer2.position();
                                                        byteBuffer2.position(0);
                                                        byteBuffer2.limit(capacity);
                                                        byteBuffer2.position(8);
                                                        ByteBuffer slice = byteBuffer2.slice();
                                                        slice.order(byteBuffer2.order());
                                                        byteBuffer2.position(0);
                                                        byteBuffer2.limit(limit);
                                                        byteBuffer2.position(position);
                                                        while (slice.hasRemaining()) {
                                                            i4++;
                                                            if (slice.remaining() >= 8) {
                                                                long j8 = slice.getLong();
                                                                if (j8 >= 4 && j8 <= 2147483647L) {
                                                                    int i6 = (int) j8;
                                                                    int position2 = slice.position() + i6;
                                                                    if (i6 <= slice.remaining()) {
                                                                        if (slice.getInt() == 1896449818) {
                                                                            X509Certificate[][] zzl = zzl(randomAccessFile.getChannel(), new zzakm(zze(slice, i6 - 4), longValue2, zza, longValue, byteBuffer, null));
                                                                            randomAccessFile.close();
                                                                            return zzl;
                                                                        }
                                                                        slice.position(position2);
                                                                    } else {
                                                                        throw new zzakn("APK Signing Block entry #" + i4 + " size out of range: " + i6 + ", available: " + slice.remaining());
                                                                    }
                                                                } else {
                                                                    throw new zzakn("APK Signing Block entry #" + i4 + " size out of range: " + j8);
                                                                }
                                                            } else {
                                                                throw new zzakn("Insufficient data to read size of APK Signing Block entry #" + i4);
                                                            }
                                                        }
                                                        throw new zzakn("No APK Signature Scheme v2 block in APK Signing Block");
                                                    }
                                                    throw new IllegalArgumentException("end > capacity: " + capacity + " > " + capacity2);
                                                }
                                                throw new IllegalArgumentException("end < start: " + capacity + " < 8");
                                            }
                                            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                                        }
                                        throw new zzakn("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j5);
                                    }
                                    throw new zzakn("APK Signing Block offset out of range: " + j6);
                                }
                                throw new zzakn("APK Signing Block size out of range: " + j5);
                            }
                            throw new zzakn("No APK Signing Block before ZIP Central Directory");
                        }
                        throw new zzakn("APK too small for APK Signing Block. ZIP Central Directory offset: " + zza);
                    }
                    throw new zzakn("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                throw new zzakn("ZIP Central Directory offset out of range: " + zza + ". ZIP End of Central Directory offset: " + longValue);
            }
            throw new zzakn("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static int zzb(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                return 64;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i4);
        }
        return 32;
    }

    private static int zzc(int i4) {
        if (i4 != 513) {
            if (i4 != 514) {
                if (i4 != 769) {
                    switch (i4) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i4))));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    private static String zzd(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                return KeyPropertiesCompact.DIGEST_SHA512;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i4);
        }
        return KeyPropertiesCompact.DIGEST_SHA256;
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i4) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i5 = i4 + position;
        if (i5 >= position && i5 <= limit) {
            byteBuffer.limit(i5);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i5);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new BufferUnderflowException();
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i4 = byteBuffer.getInt();
            if (i4 >= 0) {
                if (i4 <= byteBuffer.remaining()) {
                    return zze(byteBuffer, i4);
                }
                int remaining = byteBuffer.remaining();
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i4 + ", remaining: " + remaining);
            }
            throw new IllegalArgumentException("Negative length");
        }
        int remaining2 = byteBuffer.remaining();
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + remaining2);
    }

    private static void zzg(int i4, byte[] bArr, int i5) {
        bArr[1] = (byte) (i4 & 255);
        bArr[2] = (byte) ((i4 >>> 8) & 255);
        bArr[3] = (byte) ((i4 >>> 16) & 255);
        bArr[4] = (byte) (i4 >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j4, long j5, long j6, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            zzakk zzakkVar = new zzakk(fileChannel, 0L, j4);
            zzakk zzakkVar2 = new zzakk(fileChannel, j5, j6 - j5);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            zzakr.zzd(duplicate, j4);
            zzaki zzakiVar = new zzaki(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i4 = 0;
            for (Integer num : map.keySet()) {
                iArr[i4] = num.intValue();
                i4++;
            }
            try {
                byte[][] zzk = zzk(iArr, new zzakj[]{zzakkVar, zzakkVar2, zzakiVar});
                for (int i5 = 0; i5 < size; i5++) {
                    int i6 = iArr[i5];
                    if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i6)), zzk[i5])) {
                        throw new SecurityException(zzd(i6).concat(" digest of contents did not verify"));
                    }
                }
                return;
            } catch (DigestException e4) {
                throw new SecurityException("Failed to compute digest(s) of contents", e4);
            }
        }
        throw new SecurityException("No digests provided");
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i4 = byteBuffer.getInt();
        if (i4 >= 0) {
            if (i4 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i4];
                byteBuffer.get(bArr);
                return bArr;
            }
            int remaining = byteBuffer.remaining();
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i4 + ", available: " + remaining);
        }
        throw new IOException("Negative length");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r11 = zzc(r6);
        r12 = zzc(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r11 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r12 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] zzj(java.nio.ByteBuffer r22, java.util.Map r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakq.zzj(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] zzk(int[] iArr, zzakj[] zzakjVarArr) throws DigestException {
        long j4;
        int i4;
        int length;
        int i5 = 0;
        long j5 = 0;
        long j6 = 0;
        int i6 = 0;
        while (true) {
            j4 = 1048576;
            if (i6 >= 3) {
                break;
            }
            j6 += (zzakjVarArr[i6].zza() + 1048575) / 1048576;
            i6++;
        }
        if (j6 < 2097151) {
            byte[][] bArr = new byte[iArr.length];
            int i7 = 0;
            while (true) {
                length = iArr.length;
                if (i7 >= length) {
                    break;
                }
                int i8 = (int) j6;
                byte[] bArr2 = new byte[(zzb(iArr[i7]) * i8) + 5];
                bArr2[0] = 90;
                zzg(i8, bArr2, 1);
                bArr[i7] = bArr2;
                i7++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i9 = 0; i9 < iArr.length; i9++) {
                String zzd = zzd(iArr[i9]);
                try {
                    messageDigestArr[i9] = MessageDigest.getInstance(zzd);
                } catch (NoSuchAlgorithmException e4) {
                    throw new RuntimeException(zzd.concat(" digest not supported"), e4);
                }
            }
            int i10 = 0;
            int i11 = 0;
            for (i4 = 3; i10 < i4; i4 = 3) {
                zzakj zzakjVar = zzakjVarArr[i10];
                long j7 = j5;
                long zza = zzakjVar.zza();
                while (zza > j5) {
                    int min = (int) Math.min(zza, j4);
                    zzg(min, bArr3, 1);
                    for (int i12 = 0; i12 < length; i12++) {
                        messageDigestArr[i12].update(bArr3);
                    }
                    long j8 = j7;
                    try {
                        zzakjVar.zzb(messageDigestArr, j8, min);
                        byte[] bArr4 = bArr3;
                        int i13 = 0;
                        while (i13 < iArr.length) {
                            int i14 = iArr[i13];
                            zzakj zzakjVar2 = zzakjVar;
                            byte[] bArr5 = bArr[i13];
                            int zzb = zzb(i14);
                            int i15 = length;
                            MessageDigest messageDigest = messageDigestArr[i13];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i11 * zzb) + 5, zzb);
                            if (digest == zzb) {
                                i13++;
                                zzakjVar = zzakjVar2;
                                length = i15;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        long j9 = min;
                        long j10 = j8 + j9;
                        zza -= j9;
                        i11++;
                        j5 = 0;
                        j4 = 1048576;
                        bArr3 = bArr4;
                        j7 = j10;
                        messageDigestArr = messageDigestArr;
                    } catch (IOException e5) {
                        throw new DigestException("Failed to digest chunk #" + i11 + " of section #" + i5, e5);
                    }
                }
                i5++;
                i10++;
                j5 = 0;
                j4 = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i16 = 0; i16 < iArr.length; i16++) {
                int i17 = iArr[i16];
                byte[] bArr7 = bArr[i16];
                String zzd2 = zzd(i17);
                try {
                    bArr6[i16] = MessageDigest.getInstance(zzd2).digest(bArr7);
                } catch (NoSuchAlgorithmException e6) {
                    throw new RuntimeException(zzd2.concat(" digest not supported"), e6);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: " + j6);
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzakm zzakmVar) throws SecurityException {
        ByteBuffer byteBuffer;
        long j4;
        long j5;
        long j6;
        ByteBuffer byteBuffer2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                byteBuffer = zzakmVar.zza;
                ByteBuffer zzf = zzf(byteBuffer);
                int i4 = 0;
                while (zzf.hasRemaining()) {
                    i4++;
                    try {
                        arrayList.add(zzj(zzf(zzf), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e4) {
                        throw new SecurityException("Failed to parse/verify signer #" + i4 + " block", e4);
                    }
                }
                if (i4 > 0) {
                    if (!hashMap.isEmpty()) {
                        j4 = zzakmVar.zzb;
                        j5 = zzakmVar.zzc;
                        j6 = zzakmVar.zzd;
                        byteBuffer2 = zzakmVar.zze;
                        zzh(hashMap, fileChannel, j4, j5, j6, byteBuffer2);
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }
}
