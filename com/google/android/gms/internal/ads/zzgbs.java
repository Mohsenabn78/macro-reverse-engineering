package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbs extends zzfyt {
    private final zzgbx zza;
    private final zzgnl zzb;
    private final zzgnk zzc;
    @Nullable
    private final Integer zzd;

    private zzgbs(zzgbx zzgbxVar, zzgnl zzgnlVar, zzgnk zzgnkVar, @Nullable Integer num) {
        this.zza = zzgbxVar;
        this.zzb = zzgnlVar;
        this.zzc = zzgnkVar;
        this.zzd = num;
    }

    public static zzgbs zza(zzgbw zzgbwVar, zzgnl zzgnlVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgnk zzb;
        zzgbw zzgbwVar2 = zzgbw.zzc;
        if (zzgbwVar != zzgbwVar2 && num == null) {
            String obj = zzgbwVar.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgbwVar == zzgbwVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzgnlVar.zza() == 32) {
                zzgbx zzb2 = zzgbx.zzb(zzgbwVar);
                if (zzb2.zza() == zzgbwVar2) {
                    zzb = zzgnk.zzb(new byte[0]);
                } else if (zzb2.zza() == zzgbw.zzb) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
                } else if (zzb2.zza() == zzgbw.zza) {
                    zzb = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
                }
                return new zzgbs(zzb2, zzgnlVar, zzb, num);
            }
            int zza = zzgnlVar.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza);
        }
    }
}
