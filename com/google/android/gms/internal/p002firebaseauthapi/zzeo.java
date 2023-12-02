package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzeo {
    @Nullable
    private zzey zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeo(zzen zzenVar) {
    }

    public final zzeo zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzeo zzb(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzeo zzc(zzey zzeyVar) {
        this.zza = zzeyVar;
        return this;
    }

    public final zzeq zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zzey zzeyVar = this.zza;
        if (zzeyVar != null && (zzwjVar = this.zzb) != null) {
            if (zzeyVar.zza() == zzwjVar.zza()) {
                if (zzeyVar.zzc() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzc() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzb() == zzew.zzc) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzb() == zzew.zzb) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzb() == zzew.zza) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
                }
                return new zzeq(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzeo() {
    }
}
