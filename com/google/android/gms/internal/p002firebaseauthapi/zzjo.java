package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjo  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjo implements zzjd {
    private final zziy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjd
    public final byte[] zza(byte[] bArr, zzje zzjeVar) throws GeneralSecurityException {
        byte[] zza = zzwg.zza(zzjeVar.zza().zzc(), bArr);
        byte[] zzb = zzuz.zzb(bArr, zzjeVar.zzb().zzc());
        byte[] zzd = zzjl.zzd(zzjl.zzb);
        zziy zziyVar = this.zza;
        return zziyVar.zzb(null, zza, "eae_prk", zzb, "shared_secret", zzd, zziyVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjd
    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzjl.zzf)) {
            return zzjl.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
