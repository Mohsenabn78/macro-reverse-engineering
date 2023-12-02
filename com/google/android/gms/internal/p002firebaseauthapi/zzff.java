package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzff  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzff {
    @Nullable
    private zzfp zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzff(zzfe zzfeVar) {
    }

    public final zzff zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzff zzb(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzff zzc(zzfp zzfpVar) {
        this.zza = zzfpVar;
        return this;
    }

    public final zzfh zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zzfp zzfpVar = this.zza;
        if (zzfpVar != null && (zzwjVar = this.zzb) != null) {
            if (zzfpVar.zza() == zzwjVar.zza()) {
                if (zzfpVar.zzc() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzc() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzb() == zzfn.zzc) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzb() == zzfn.zzb) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzb() == zzfn.zza) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
                }
                return new zzfh(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzff() {
    }
}
