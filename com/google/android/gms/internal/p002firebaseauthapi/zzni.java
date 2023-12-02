package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzni  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzni {
    @Nullable
    private zznv zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzni(zznh zznhVar) {
    }

    public final zzni zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzni zzb(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzni zzc(zznv zznvVar) {
        this.zza = zznvVar;
        return this;
    }

    public final zznk zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zznv zznvVar = this.zza;
        if (zznvVar != null && (zzwjVar = this.zzb) != null) {
            if (zznvVar.zzb() == zzwjVar.zza()) {
                if (zznvVar.zzg() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzg() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzf() == zznt.zzd) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzf() != zznt.zzc && this.zza.zzf() != zznt.zzb) {
                    if (this.zza.zzf() == zznt.zza) {
                        zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                    }
                } else {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                }
                return new zznk(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzni() {
    }
}
