package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbj {
    @Nullable
    private Integer zza;
    private zzgbk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgbj(zzgbi zzgbiVar) {
        this.zza = null;
        this.zzb = zzgbk.zzc;
    }

    public final zzgbj zza(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzgbj zzb(zzgbk zzgbkVar) {
        this.zzb = zzgbkVar;
        return this;
    }

    public final zzgbm zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                return new zzgbm(num.intValue(), this.zzb, null);
            }
            throw new GeneralSecurityException("Variant is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzgbj() {
        this.zza = null;
        throw null;
    }
}
