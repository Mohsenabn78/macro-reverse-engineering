package com.google.android.gms.internal.ads;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzavg extends zzavb {
    private MessageDigest zzb;

    @Override // com.google.android.gms.internal.ads.zzavb
    public final byte[] zzb(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        int length = split.length;
        int i4 = 4;
        if (length == 1) {
            int zza = zzavf.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr2 = allocate.array();
        } else {
            if (length < 5) {
                bArr = new byte[length + length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zza2 = zzavf.zza(split[i5]);
                    int i6 = (zza2 >> 16) ^ ((char) zza2);
                    byte b4 = (byte) i6;
                    byte[] bArr3 = {b4, (byte) (i6 >> 8)};
                    int i7 = i5 + i5;
                    bArr[i7] = b4;
                    bArr[i7 + 1] = bArr3[1];
                }
            } else {
                bArr = new byte[length];
                for (int i8 = 0; i8 < split.length; i8++) {
                    int zza3 = zzavf.zza(split[i8]);
                    bArr[i8] = (byte) ((zza3 >> 24) ^ (((zza3 & 255) ^ ((zza3 >> 8) & 255)) ^ ((zza3 >> 16) & 255)));
                }
            }
            bArr2 = bArr;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                return new byte[0];
            }
            messageDigest.reset();
            this.zzb.update(bArr2);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i4 = length2;
            }
            byte[] bArr4 = new byte[i4];
            System.arraycopy(digest, 0, bArr4, 0, i4);
            return bArr4;
        }
    }
}
