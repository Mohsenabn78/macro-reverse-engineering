package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzghg implements zzfye {
    private final zzfym zza;
    private final zzgho zzb;
    private final zzgho zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzghg(zzfym zzfymVar, zzghf zzghfVar) {
        zzgho zzghoVar;
        this.zza = zzfymVar;
        if (zzfymVar.zzf()) {
            zzghp zzb = zzged.zza().zzb();
            zzghu zza = zzgea.zza(zzfymVar);
            this.zzb = zzb.zza(zza, "mac", "compute");
            zzghoVar = zzb.zza(zza, "mac", "verify");
        } else {
            zzghoVar = zzgea.zza;
            this.zzb = zzghoVar;
        }
        this.zzc = zzghoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        Logger logger;
        byte[] bArr4;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzfyi zzfyiVar : this.zza.zze(copyOf)) {
                if (zzfyiVar.zzc().equals(zzglq.LEGACY)) {
                    bArr4 = zzghh.zzb;
                    bArr3 = zzgmg.zzb(bArr2, bArr4);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzfye) zzfyiVar.zze()).zza(copyOfRange, bArr3);
                    zzfyiVar.zza();
                    return;
                } catch (GeneralSecurityException e4) {
                    logger = zzghh.zza;
                    logger.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e4.toString()));
                }
            }
            for (zzfyi zzfyiVar2 : this.zza.zze(zzfxm.zza)) {
                try {
                    ((zzfye) zzfyiVar2.zze()).zza(bArr, bArr2);
                    zzfyiVar2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
