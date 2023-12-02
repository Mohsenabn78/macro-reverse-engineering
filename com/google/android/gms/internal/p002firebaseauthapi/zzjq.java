package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjq {
    private final zzbd zza;
    private final zzbj zzb;

    public zzjq(zzbd zzbdVar) {
        this.zza = zzbdVar;
        this.zzb = null;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbd zzbdVar = this.zza;
        if (zzbdVar != null) {
            return zzbdVar.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }

    public zzjq(zzbj zzbjVar) {
        this.zza = null;
        this.zzb = zzbjVar;
    }
}
