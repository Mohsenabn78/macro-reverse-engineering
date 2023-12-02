package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgcg implements zzfxh {
    private static final byte[] zza = new byte[0];
    private final zzgkp zzb;
    private final zzfxh zzc;

    public zzgcg(zzgkp zzgkpVar, zzfxh zzfxhVar) {
        this.zzb = zzgkpVar;
        this.zzc = zzfxhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxh
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i4 = wrap.getInt();
            if (i4 > 0 && i4 <= bArr.length - 4) {
                byte[] bArr3 = new byte[i4];
                wrap.get(bArr3, 0, i4);
                byte[] bArr4 = new byte[wrap.remaining()];
                wrap.get(bArr4, 0, wrap.remaining());
                byte[] zza2 = this.zzc.zza(bArr3, zza);
                String zzh = this.zzb.zzh();
                int i5 = zzfyp.zza;
                zzgoe zzgoeVar = zzgoe.zzb;
                return ((zzfxh) zzfyp.zzc(zzh, zzgoe.zzv(zza2, 0, zza2.length), zzfxh.class)).zza(bArr4, bArr2);
            }
            throw new GeneralSecurityException("invalid ciphertext");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e4) {
            throw new GeneralSecurityException("invalid ciphertext", e4);
        }
    }
}
