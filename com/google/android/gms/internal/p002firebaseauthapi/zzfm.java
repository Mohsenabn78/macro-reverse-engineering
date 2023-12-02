package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzfm {
    @Nullable
    private Integer zza;
    private zzfn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfm(zzfl zzflVar) {
        this.zza = null;
        this.zzb = zzfn.zzc;
    }

    public final zzfm zza(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzfm zzb(zzfn zzfnVar) {
        this.zzb = zzfnVar;
        return this;
    }

    public final zzfp zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                return new zzfp(num.intValue(), this.zzb, null);
            }
            throw new GeneralSecurityException("Variant is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzfm() {
        this.zza = null;
        throw null;
    }
}
