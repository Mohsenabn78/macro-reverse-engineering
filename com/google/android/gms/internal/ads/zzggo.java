package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzggo extends zzget {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzggo(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final /* bridge */ /* synthetic */ Object zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgjz zzgjzVar = (zzgjz) zzgqwVar;
        int zzg = zzgjzVar.zzg().zzg();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzgjzVar.zzh().zzA(), "HMAC");
        int zza = zzgjzVar.zzg().zza();
        int i4 = zzg - 2;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 == 5) {
                            return new zzgne(new zzgnd("HMACSHA224", secretKeySpec), zza);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new zzgne(new zzgnd("HMACSHA512", secretKeySpec), zza);
                }
                return new zzgne(new zzgnd("HMACSHA256", secretKeySpec), zza);
            }
            return new zzgne(new zzgnd("HMACSHA384", secretKeySpec), zza);
        }
        return new zzgne(new zzgnd("HMACSHA1", secretKeySpec), zza);
    }
}
