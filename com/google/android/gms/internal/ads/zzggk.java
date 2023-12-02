package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzggk {
    @Nullable
    private zzggw zza = null;
    @Nullable
    private zzgnl zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzggk(zzggj zzggjVar) {
    }

    public final zzggk zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggk zzb(zzgnl zzgnlVar) {
        this.zzb = zzgnlVar;
        return this;
    }

    public final zzggk zzc(zzggw zzggwVar) {
        this.zza = zzggwVar;
        return this;
    }

    public final zzggm zzd() throws GeneralSecurityException {
        zzgnl zzgnlVar;
        zzgnk zzb;
        zzggw zzggwVar = this.zza;
        if (zzggwVar != null && (zzgnlVar = this.zzb) != null) {
            if (zzggwVar.zzb() == zzgnlVar.zza()) {
                if (zzggwVar.zzf() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzf() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zze() == zzggu.zzd) {
                    zzb = zzgnk.zzb(new byte[0]);
                } else if (this.zza.zze() != zzggu.zzc && this.zza.zze() != zzggu.zzb) {
                    if (this.zza.zze() == zzggu.zza) {
                        zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
                    }
                } else {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                }
                return new zzggm(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzggk() {
    }
}
