package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzmu {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzmv zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmu(zzmt zzmtVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzmv.zzd;
    }

    public final zzmu zza(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i4 * 8)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzmu zzb(int i4) throws GeneralSecurityException {
        if (i4 >= 10 && i4 <= 16) {
            this.zzb = Integer.valueOf(i4);
            return this;
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i4);
    }

    public final zzmu zzc(zzmv zzmvVar) {
        this.zzc = zzmvVar;
        return this;
    }

    public final zzmx zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                if (this.zzc != null) {
                    return new zzmx(num.intValue(), this.zzb.intValue(), this.zzc, null);
                }
                throw new GeneralSecurityException("variant not set");
            }
            throw new GeneralSecurityException("tag size not set");
        }
        throw new GeneralSecurityException("key size not set");
    }

    private zzmu() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }
}
