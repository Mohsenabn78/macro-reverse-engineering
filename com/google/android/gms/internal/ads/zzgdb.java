package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzgdb {
    private final zzgcz zza;
    private final zzgcz zzb;

    public zzgdb(byte[] bArr) throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            this.zza = zza(bArr, 1);
            this.zzb = zza(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    abstract zzgcz zza(byte[] bArr, int i4) throws InvalidKeyException;

    public final byte[] zzb(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i4;
        int i5;
        if (byteBuffer.remaining() >= 16) {
            int position = byteBuffer.position();
            byte[] bArr3 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr3);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                byte[] bArr4 = new byte[32];
                this.zzb.zzc(bArr, 0).get(bArr4);
                int length = bArr2.length;
                int i6 = length & 15;
                if (i6 == 0) {
                    i4 = length;
                } else {
                    i4 = (length + 16) - i6;
                }
                int remaining = byteBuffer.remaining();
                int i7 = remaining % 16;
                if (i7 == 0) {
                    i5 = remaining;
                } else {
                    i5 = (remaining + 16) - i7;
                }
                int i8 = i5 + i4;
                ByteBuffer order = ByteBuffer.allocate(i8 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(i4);
                order.put(byteBuffer);
                order.position(i8);
                order.putLong(length);
                order.putLong(remaining);
                if (MessageDigest.isEqual(zzgde.zza(bArr4, order.array()), bArr3)) {
                    byteBuffer.position(position);
                    return this.zza.zzd(bArr, byteBuffer);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e4) {
                throw new AEADBadTagException(e4.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
