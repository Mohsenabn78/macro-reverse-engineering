package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzml  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzml {
    @Nullable
    private zzmx zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzml(zzmk zzmkVar) {
    }

    public final zzml zza(zzwj zzwjVar) throws GeneralSecurityException {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzml zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzml zzc(zzmx zzmxVar) {
        this.zza = zzmxVar;
        return this;
    }

    public final zzmn zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zzmx zzmxVar = this.zza;
        if (zzmxVar != null && (zzwjVar = this.zzb) != null) {
            if (zzmxVar.zzb() == zzwjVar.zza()) {
                if (zzmxVar.zze() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zze() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzd() == zzmv.zzd) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzd() != zzmv.zzc && this.zza.zzd() != zzmv.zzb) {
                    if (this.zza.zzd() == zzmv.zza) {
                        zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    } else {
                        throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                    }
                } else {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                }
                return new zzmn(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new GeneralSecurityException("Cannot build without parameters and/or key material");
    }

    private zzml() {
    }
}
