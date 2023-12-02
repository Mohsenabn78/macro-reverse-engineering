package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zznr {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzns zzc;
    private zznt zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zznr(zznq zznqVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zznt.zzd;
    }

    public final zznr zza(zzns zznsVar) {
        this.zzc = zznsVar;
        return this;
    }

    public final zznr zzb(int i4) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zznr zzc(int i4) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i4);
        return this;
    }

    public final zznr zzd(zznt zzntVar) {
        this.zzd = zzntVar;
        return this;
    }

    public final zznv zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzb != null) {
                if (this.zzc != null) {
                    if (this.zzd != null) {
                        if (num.intValue() >= 16) {
                            int intValue = this.zzb.intValue();
                            zzns zznsVar = this.zzc;
                            if (intValue >= 10) {
                                if (zznsVar == zzns.zza) {
                                    if (intValue > 20) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(intValue)));
                                    }
                                } else if (zznsVar == zzns.zzb) {
                                    if (intValue > 28) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(intValue)));
                                    }
                                } else if (zznsVar == zzns.zzc) {
                                    if (intValue > 32) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(intValue)));
                                    }
                                } else if (zznsVar == zzns.zzd) {
                                    if (intValue > 48) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(intValue)));
                                    }
                                } else if (zznsVar == zzns.zze) {
                                    if (intValue > 64) {
                                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(intValue)));
                                    }
                                } else {
                                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                                }
                                return new zznv(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
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

    private zznr() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
