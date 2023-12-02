package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgn  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgn extends zzcv {
    private final zzgs zza;
    private final zzwj zzb;
    private final zzwi zzc;
    @Nullable
    private final Integer zzd;

    private zzgn(zzgs zzgsVar, zzwj zzwjVar, zzwi zzwiVar, @Nullable Integer num) {
        this.zza = zzgsVar;
        this.zzb = zzwjVar;
        this.zzc = zzwiVar;
        this.zzd = num;
    }

    public static zzgn zza(zzgr zzgrVar, zzwj zzwjVar, @Nullable Integer num) throws GeneralSecurityException {
        zzwi zzb;
        zzgr zzgrVar2 = zzgr.zzc;
        if (zzgrVar != zzgrVar2 && num == null) {
            String obj = zzgrVar.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgrVar == zzgrVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzwjVar.zza() == 32) {
                zzgs zzb2 = zzgs.zzb(zzgrVar);
                if (zzb2.zza() == zzgrVar2) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (zzb2.zza() == zzgr.zzb) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
                } else if (zzb2.zza() == zzgr.zza) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
                }
                return new zzgn(zzb2, zzwjVar, zzb, num);
            }
            int zza = zzwjVar.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza);
        }
    }
}
