package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfw {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzgfx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgfw(zzgfv zzgfvVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzgfx.zzd;
    }

    public final zzgfw zza(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i4 * 8)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzgfw zzb(int i4) throws GeneralSecurityException {
        if (i4 >= 10 && i4 <= 16) {
            this.zzb = Integer.valueOf(i4);
            return this;
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i4);
    }

    public final zzgfw zzc(zzgfx zzgfxVar) {
        this.zzc = zzgfxVar;
        return this;
    }

    public final zzgfz zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                if (this.zzc != null) {
                    return new zzgfz(num.intValue(), this.zzb.intValue(), this.zzc, null);
                }
                throw new GeneralSecurityException("variant not set");
            }
            throw new GeneralSecurityException("tag size not set");
        }
        throw new GeneralSecurityException("key size not set");
    }

    private zzgfw() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }
}
