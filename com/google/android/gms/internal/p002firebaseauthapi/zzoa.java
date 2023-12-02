package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoa  reason: invalid package */
/* loaded from: classes4.dex */
final class zzoa implements zzce {
    private final zzcm zza;
    private final zzon zzb;
    private final zzon zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzoa(zzcm zzcmVar, zznz zznzVar) {
        zzon zzonVar;
        this.zza = zzcmVar;
        if (zzcmVar.zzf()) {
            zzoo zzb = zzkv.zza().zzb();
            zzot zza = zzks.zza(zzcmVar);
            this.zzb = zzb.zza(zza, "mac", "compute");
            zzonVar = zzb.zza(zza, "mac", "verify");
        } else {
            zzonVar = zzks.zza;
            this.zzb = zzonVar;
        }
        this.zzc = zzonVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        Logger logger;
        byte[] bArr4;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzci zzciVar : this.zza.zze(copyOf)) {
                if (zzciVar.zzc().equals(zzui.LEGACY)) {
                    bArr4 = zzob.zzb;
                    bArr3 = zzuz.zzb(bArr2, bArr4);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzce) zzciVar.zze()).zza(copyOfRange, bArr3);
                    zzciVar.zza();
                    return;
                } catch (GeneralSecurityException e4) {
                    logger = zzob.zza;
                    logger.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e4.toString()));
                }
            }
            for (zzci zzciVar2 : this.zza.zze(zzbi.zza)) {
                try {
                    ((zzce) zzciVar2.zze()).zza(bArr, bArr2);
                    zzciVar2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
