package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhu {
    @Nullable
    private Integer zza;
    private zzhv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhu(zzht zzhtVar) {
        this.zza = null;
        this.zzb = zzhv.zzc;
    }

    public final zzhu zza(int i4) throws GeneralSecurityException {
        if (i4 != 32 && i4 != 48 && i4 != 64) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzhu zzb(zzhv zzhvVar) {
        this.zzb = zzhvVar;
        return this;
    }

    public final zzhx zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                return new zzhx(num.intValue(), this.zzb, null);
            }
            throw new GeneralSecurityException("Variant is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzhu() {
        this.zza = null;
        throw null;
    }
}
