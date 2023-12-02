package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgj implements zzbd {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final zzth zzc;
    private final zzbd zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    public zzgj(zzth zzthVar, zzbd zzbdVar) {
        if (zzc(zzthVar.zzg())) {
            this.zzc = zzthVar;
            this.zzd = zzbdVar;
            return;
        }
        String zzg = zzthVar.zzg();
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
    }

    public static boolean zzc(String str) {
        return zzb.contains(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i4 = wrap.getInt();
            if (i4 > 0 && i4 <= bArr.length - 4) {
                byte[] bArr3 = new byte[i4];
                wrap.get(bArr3, 0, i4);
                byte[] bArr4 = new byte[wrap.remaining()];
                wrap.get(bArr4, 0, wrap.remaining());
                byte[] zza2 = this.zzd.zza(bArr3, zza);
                String zzg = this.zzc.zzg();
                int i5 = zzcr.zza;
                zzafy zzafyVar = zzafy.zzb;
                return ((zzbd) zzcr.zzd(zzg, zzafy.zzn(zza2, 0, zza2.length), zzbd.class)).zza(bArr4, bArr2);
            }
            throw new GeneralSecurityException("invalid ciphertext");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e4) {
            throw new GeneralSecurityException("invalid ciphertext", e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
