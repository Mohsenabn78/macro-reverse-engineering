package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzdx {
    @Nullable
    private zzeh zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdx(zzdw zzdwVar) {
    }

    public final zzdx zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzdx zzb(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzdx zzc(zzeh zzehVar) {
        this.zza = zzehVar;
        return this;
    }

    public final zzdz zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zzeh zzehVar = this.zza;
        if (zzehVar != null && (zzwjVar = this.zzb) != null) {
            if (zzehVar.zzb() == zzwjVar.zza()) {
                if (zzehVar.zzd() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzd() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzc() == zzef.zzc) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzc() == zzef.zzb) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzc() == zzef.zza) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zzc())));
                }
                return new zzdz(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzdx() {
    }
}
