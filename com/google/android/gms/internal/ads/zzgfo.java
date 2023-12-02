package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfo {
    @Nullable
    private zzgfz zza = null;
    @Nullable
    private zzgnl zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgfo(zzgfn zzgfnVar) {
    }

    public final zzgfo zza(zzgnl zzgnlVar) throws GeneralSecurityException {
        this.zzb = zzgnlVar;
        return this;
    }

    public final zzgfo zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgfo zzc(zzgfz zzgfzVar) {
        this.zza = zzgfzVar;
        return this;
    }

    public final zzgfq zzd() throws GeneralSecurityException {
        zzgnl zzgnlVar;
        zzgnk zzb;
        zzgfz zzgfzVar = this.zza;
        if (zzgfzVar != null && (zzgnlVar = this.zzb) != null) {
            if (zzgfzVar.zzb() == zzgnlVar.zza()) {
                if (zzgfzVar.zze() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zze() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzd() == zzgfx.zzd) {
                    zzb = zzgnk.zzb(new byte[0]);
                } else if (this.zza.zzd() != zzgfx.zzc && this.zza.zzd() != zzgfx.zzb) {
                    if (this.zza.zzd() == zzgfx.zza) {
                        zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                    }
                } else {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                }
                return new zzgfq(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzgfo() {
    }
}
