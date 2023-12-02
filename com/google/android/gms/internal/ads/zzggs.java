package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzggs {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzggt zzc;
    private zzggu zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzggs(zzggr zzggrVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzggu.zzd;
    }

    public final zzggs zza(zzggt zzggtVar) {
        this.zzc = zzggtVar;
        return this;
    }

    public final zzggs zzb(int i4) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzggs zzc(int i4) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i4);
        return this;
    }

    public final zzggs zzd(zzggu zzgguVar) {
        this.zzd = zzgguVar;
        return this;
    }

    public final zzggw zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                if (this.zzc != null) {
                    if (this.zzd != null) {
                        if (num.intValue() >= 16) {
                            int intValue = this.zzb.intValue();
                            zzggt zzggtVar = this.zzc;
                            if (intValue >= 10) {
                                if (zzggtVar == zzggt.zza) {
                                    if (intValue > 20) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(intValue)));
                                    }
                                } else if (zzggtVar == zzggt.zzb) {
                                    if (intValue > 28) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(intValue)));
                                    }
                                } else if (zzggtVar == zzggt.zzc) {
                                    if (intValue > 32) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(intValue)));
                                    }
                                } else if (zzggtVar == zzggt.zzd) {
                                    if (intValue > 48) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(intValue)));
                                    }
                                } else if (zzggtVar == zzggt.zze) {
                                    if (intValue > 64) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(intValue)));
                                    }
                                } else {
                                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                                }
                                return new zzggw(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
                            }
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(intValue)));
                        }
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
                    }
                    throw new GeneralSecurityException("variant is not set");
                }
                throw new GeneralSecurityException("hash type is not set");
            }
            throw new GeneralSecurityException("tag size is not set");
        }
        throw new GeneralSecurityException("key size is not set");
    }

    private zzggs() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
