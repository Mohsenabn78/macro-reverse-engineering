package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzip  reason: invalid package */
/* loaded from: classes4.dex */
final class zzip implements zzbk {
    private final zzcm zza;
    private final zzon zzb;

    public zzip(zzcm zzcmVar) {
        zzon zzonVar;
        this.zza = zzcmVar;
        if (zzcmVar.zzf()) {
            zzonVar = zzkv.zza().zzb().zza(zzks.zza(zzcmVar), "hybrid_decrypt", "decrypt");
        } else {
            zzonVar = zzks.zza;
        }
        this.zzb = zzonVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Logger logger;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzci zzciVar : this.zza.zze(copyOfRange)) {
                try {
                    byte[] zza = ((zzbk) zzciVar.zze()).zza(copyOfRange2, null);
                    zzciVar.zza();
                    int length2 = copyOfRange2.length;
                    return zza;
                } catch (GeneralSecurityException e4) {
                    logger = zziq.zza;
                    logger.logp(Level.INFO, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(String.valueOf(e4.toString())));
                }
            }
        }
        for (zzci zzciVar2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza2 = ((zzbk) zzciVar2.zze()).zza(bArr, null);
                zzciVar2.zza();
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
