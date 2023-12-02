package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgck extends zzfyt {
    private final zzgcp zza;
    private final zzgnl zzb;
    private final zzgnk zzc;
    @Nullable
    private final Integer zzd;

    private zzgck(zzgcp zzgcpVar, zzgnl zzgnlVar, zzgnk zzgnkVar, @Nullable Integer num) {
        this.zza = zzgcpVar;
        this.zzb = zzgnlVar;
        this.zzc = zzgnkVar;
        this.zzd = num;
    }

    public static zzgck zza(zzgco zzgcoVar, zzgnl zzgnlVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgnk zzb;
        zzgco zzgcoVar2 = zzgco.zzc;
        if (zzgcoVar != zzgcoVar2 && num == null) {
            String obj = zzgcoVar.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgcoVar == zzgcoVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzgnlVar.zza() == 32) {
                zzgcp zzb2 = zzgcp.zzb(zzgcoVar);
                if (zzb2.zza() == zzgcoVar2) {
                    zzb = zzgnk.zzb(new byte[0]);
                } else if (zzb2.zza() == zzgco.zzb) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
                } else if (zzb2.zza() == zzgco.zza) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
                }
                return new zzgck(zzb2, zzgnlVar, zzb, num);
            }
            int zza = zzgnlVar.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza);
        }
    }
}
