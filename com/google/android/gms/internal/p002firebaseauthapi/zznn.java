package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznn  reason: invalid package */
/* loaded from: classes4.dex */
final class zznn extends zzlm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zznn(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    public final /* bridge */ /* synthetic */ Object zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzsd zzsdVar = (zzsd) zzaiiVar;
        int zzf = zzsdVar.zzf().zzf();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzsdVar.zzg().zzq(), "HMAC");
        int zza = zzsdVar.zzf().zza();
        int i4 = zzf - 2;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 == 5) {
                            return new zzwd(new zzwc("HMACSHA224", secretKeySpec), zza);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new zzwd(new zzwc("HMACSHA512", secretKeySpec), zza);
                }
                return new zzwd(new zzwc("HMACSHA256", secretKeySpec), zza);
            }
            return new zzwd(new zzwc("HMACSHA384", secretKeySpec), zza);
        }
        return new zzwd(new zzwc("HMACSHA1", secretKeySpec), zza);
    }
}
