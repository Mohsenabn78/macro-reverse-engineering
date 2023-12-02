package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzev  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzev {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzew zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzev(zzeu zzeuVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzew.zzc;
    }

    public final zzev zza(int i4) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzev zzb(int i4) throws GeneralSecurityException {
        if (i4 != 16 && i4 != 24 && i4 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
        }
        this.zza = Integer.valueOf(i4);
        return this;
    }

    public final zzev zzc(int i4) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzev zzd(zzew zzewVar) {
        this.zzd = zzewVar;
        return this;
    }

    public final zzey zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num != null) {
            if (this.zzd != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        int intValue = num.intValue();
                        this.zzb.intValue();
                        this.zzc.intValue();
                        return new zzey(intValue, 12, 16, this.zzd, null);
                    }
                    throw new GeneralSecurityException("Tag size is not set");
                }
                throw new GeneralSecurityException("IV size is not set");
            }
            throw new GeneralSecurityException("Variant is not set");
        }
        throw new GeneralSecurityException("Key size is not set");
    }

    private zzev() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
