package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzdc {
    @Nullable
    private zzdn zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private zzwj zzc = null;
    @Nullable
    private Integer zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdc(zzdb zzdbVar) {
    }

    public final zzdc zza(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzdc zzb(zzwj zzwjVar) {
        this.zzc = zzwjVar;
        return this;
    }

    public final zzdc zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzdc zzd(zzdn zzdnVar) {
        this.zza = zzdnVar;
        return this;
    }

    public final zzde zze() throws GeneralSecurityException {
        zzwi zzb;
        zzdn zzdnVar = this.zza;
        if (zzdnVar != null) {
            zzwj zzwjVar = this.zzb;
            if (zzwjVar != null && this.zzc != null) {
                if (zzdnVar.zza() == zzwjVar.zza()) {
                    if (zzdnVar.zzb() == this.zzc.zza()) {
                        if (this.zza.zzg() && this.zzd == null) {
                            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                        }
                        if (!this.zza.zzg() && this.zzd != null) {
                            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                        }
                        if (this.zza.zzf() == zzdl.zzc) {
                            zzb = zzwi.zzb(new byte[0]);
                        } else if (this.zza.zzf() == zzdl.zzb) {
                            zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                        } else if (this.zza.zzf() == zzdl.zza) {
                            zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                        } else {
                            throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                        }
                        return new zzde(this.zza, this.zzb, this.zzc, zzb, this.zzd, null);
                    }
                    throw new GeneralSecurityException("HMAC key size mismatch");
                }
                throw new GeneralSecurityException("AES key size mismatch");
            }
            throw new GeneralSecurityException("Cannot build without key material");
        }
        throw new GeneralSecurityException("Cannot build without parameters");
    }

    private zzdc() {
    }
}
