package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcz  reason: invalid package */
/* loaded from: classes4.dex */
final class zzcz implements zzbd {
    private final zzcm zza;
    private final zzon zzb;
    private final zzon zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcz(zzcm zzcmVar, zzcy zzcyVar) {
        zzon zzonVar;
        this.zza = zzcmVar;
        if (zzcmVar.zzf()) {
            zzoo zzb = zzkv.zza().zzb();
            zzot zza = zzks.zza(zzcmVar);
            this.zzb = zzb.zza(zza, "aead", "encrypt");
            zzonVar = zzb.zza(zza, "aead", "decrypt");
        } else {
            zzonVar = zzks.zza;
            this.zzb = zzonVar;
        }
        this.zzc = zzonVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Logger logger;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzci zzciVar : this.zza.zze(copyOf)) {
                try {
                    byte[] zza = ((zzbd) zzciVar.zze()).zza(copyOfRange, bArr2);
                    zzciVar.zza();
                    int length2 = copyOfRange.length;
                    return zza;
                } catch (GeneralSecurityException e4) {
                    logger = zzda.zza;
                    logger.logp(Level.INFO, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e4.toString()));
                }
            }
        }
        for (zzci zzciVar2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza2 = ((zzbd) zzciVar2.zze()).zza(bArr, bArr2);
                zzciVar2.zza();
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
