package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzee  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzee {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzef zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzee(zzed zzedVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzef.zzc;
    }

    public final zzee zza(int i4) throws GeneralSecurityException {
        if (i4 != 12 && i4 != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i4)));
        }
        this.zzb = Integer.valueOf(i4);
        return this;
    }

    public final zzee zzb(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 24 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzee zzc(int i4) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzee zzd(zzef zzefVar) {
        this.zzd = zzefVar;
        return this;
    }

    public final zzeh zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                if (this.zzd != null) {
                    if (this.zzc != null) {
                        int intValue = num.intValue();
                        int intValue2 = this.zzb.intValue();
                        this.zzc.intValue();
                        return new zzeh(intValue, intValue2, 16, this.zzd, null);
                    }
                    throw new GeneralSecurityException("Tag size is not set");
                }
                throw new GeneralSecurityException("Variant is not set");
            }
            throw new GeneralSecurityException("IV size is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzee() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
