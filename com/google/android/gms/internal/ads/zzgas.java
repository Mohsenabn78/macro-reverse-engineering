package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgas {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzgat zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgas(zzgar zzgarVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgat.zzc;
    }

    public final zzgas zza(int i4) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzgas zzb(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 24 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzgas zzc(int i4) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgas zzd(zzgat zzgatVar) {
        this.zzd = zzgatVar;
        return this;
    }

    public final zzgav zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzd != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        int intValue = num.intValue();
                        this.zzb.intValue();
                        this.zzc.intValue();
                        return new zzgav(intValue, 12, 16, this.zzd, null);
                    }
                    throw new GeneralSecurityException("Tag size is not set");
                }
                throw new GeneralSecurityException("IV size is not set");
            }
            throw new GeneralSecurityException("Variant is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzgas() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
