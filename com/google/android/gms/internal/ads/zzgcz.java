package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzgcz {
    int[] zza;
    private final int zzb;

    public zzgcz(byte[] bArr, int i4) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzgcv.zzd(bArr);
            this.zzb = i4;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    abstract int zza();

    abstract int[] zzb(int[] iArr, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer zzc(byte[] bArr, int i4) {
        int[] zzb = zzb(zzgcv.zzd(bArr), i4);
        int[] iArr = (int[]) zzb.clone();
        zzgcv.zzc(iArr);
        for (int i5 = 0; i5 < 16; i5++) {
            zzb[i5] = zzb[i5] + iArr[i5];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length == zza()) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining / 64;
            int i5 = 0;
            while (true) {
                int i6 = i4 + 1;
                if (i5 < i6) {
                    ByteBuffer zzc = zzc(bArr, this.zzb + i5);
                    if (i5 == i6 - 1) {
                        zzgmg.zza(allocate, byteBuffer, zzc, remaining % 64);
                    } else {
                        zzgmg.zza(allocate, byteBuffer, zzc, 64);
                    }
                    i5++;
                } else {
                    return allocate.array();
                }
            }
        } else {
            int zza = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza);
        }
    }
}
