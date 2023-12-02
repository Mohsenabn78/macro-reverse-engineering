package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhn  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhn {
    @Nullable
    private zzhx zza = null;
    @Nullable
    private zzwj zzb = null;
    @Nullable
    private Integer zzc = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhn(zzhm zzhmVar) {
    }

    public final zzhn zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhn zzb(zzwj zzwjVar) {
        this.zzb = zzwjVar;
        return this;
    }

    public final zzhn zzc(zzhx zzhxVar) {
        this.zza = zzhxVar;
        return this;
    }

    public final zzhp zzd() throws GeneralSecurityException {
        zzwj zzwjVar;
        zzwi zzb;
        zzhx zzhxVar = this.zza;
        if (zzhxVar != null && (zzwjVar = this.zzb) != null) {
            if (zzhxVar.zza() == zzwjVar.zza()) {
                if (zzhxVar.zzc() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (!this.zza.zzc() && this.zzc != null) {
                    throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                }
                if (this.zza.zzb() == zzhv.zzc) {
                    zzb = zzwi.zzb(new byte[0]);
                } else if (this.zza.zzb() == zzhv.zzb) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzb() == zzhv.zza) {
                    zzb = zzwi.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
                }
                return new zzhp(this.zza, this.zzb, zzb, this.zzc, null);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
        throw new IllegalArgumentException("Cannot build without parameters and/or key material");
    }

    private zzhn() {
    }
}
