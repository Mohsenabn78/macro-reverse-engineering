package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgal {
    @Nullable
    private zzgav zza = null;
    @Nullable
    private zzgnl zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgal(zzgak zzgakVar) {
    }

    public final zzgal zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgal zzb(zzgnl zzgnlVar) {
        this.zzb = zzgnlVar;
        return this;
    }

    public final zzgal zzc(zzgav zzgavVar) {
        this.zza = zzgavVar;
        return this;
    }

    public final zzgan zzd() throws GeneralSecurityException {
        zzgnl zzgnlVar;
        zzgnk zzb;
        zzgav zzgavVar = this.zza;
        if (zzgavVar != null && (zzgnlVar = this.zzb) != null) {
            if (zzgavVar.zza() == zzgnlVar.zza()) {
                if (zzgavVar.zzc() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzc() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzb() == zzgat.zzc) {
                    zzb = zzgnk.zzb(new byte[0]);
                } else if (this.zza.zzb() == zzgat.zzb) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzb() == zzgat.zza) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
                }
                return new zzgan(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzgal() {
    }
}
