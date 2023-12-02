package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzlv implements zzlz {
    private final zzwi zza;
    private final zzth zzb;

    private zzlv(zzth zzthVar, zzwi zzwiVar) {
        this.zzb = zzthVar;
        this.zza = zzwiVar;
    }

    public static zzlv zza(zzth zzthVar) throws GeneralSecurityException {
        String zzg = zzthVar.zzg();
        Charset charset = zzmj.zza;
        byte[] bArr = new byte[zzg.length()];
        for (int i4 = 0; i4 < zzg.length(); i4++) {
            char charAt = zzg.charAt(i4);
            if (charAt >= '!' && charAt <= '~') {
                bArr[i4] = (byte) charAt;
            } else {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
        }
        return new zzlv(zzthVar, zzwi.zzb(bArr));
    }

    public static zzlv zzb(zzth zzthVar) {
        return new zzlv(zzthVar, zzmj.zzb(zzthVar.zzg()));
    }

    public final zzth zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlz
    public final zzwi zzd() {
        return this.zza;
    }
}
