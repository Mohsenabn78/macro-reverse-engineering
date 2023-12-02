package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxt {
    private final zzgkp zza;

    private zzfxt(zzgkp zzgkpVar) {
        this.zza = zzgkpVar;
    }

    public static zzfxt zzb(String str, byte[] bArr, int i4) {
        zzglq zzglqVar;
        zzgko zza = zzgkp.zza();
        zza.zzb(str);
        zza.zzc(zzgoe.zzv(bArr, 0, bArr.length));
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                zzglqVar = zzglq.RAW;
            } else {
                zzglqVar = zzglq.LEGACY;
            }
        } else {
            zzglqVar = zzglq.TINK;
        }
        zza.zza(zzglqVar);
        return new zzfxt((zzgkp) zza.zzal());
    }

    public final zzfyf zza() throws GeneralSecurityException {
        try {
            zzgkp zze = zzgkp.zze(this.zza.zzax(), zzgoy.zza());
            zzgeg zzc = zzgeg.zzc();
            zzgfb zza = zzgfb.zza(zze);
            if (!zzc.zzi(zza)) {
                return new zzgdx(zza);
            }
            return zzc.zzb(zza);
        } catch (IOException e4) {
            throw new GeneralSecurityException("Failed to parse proto", e4);
        }
    }
}
