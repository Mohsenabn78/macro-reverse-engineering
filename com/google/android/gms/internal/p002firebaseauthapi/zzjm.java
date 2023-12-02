package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjm implements zzjd {
    private final zziy zza;
    private final int zzb;

    private zzjm(zziy zziyVar, int i4) {
        this.zza = zziyVar;
        this.zzb = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zzc(int i4) throws GeneralSecurityException {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                return new zzjm(new zziy("HmacSha512"), 3);
            }
            return new zzjm(new zziy("HmacSha384"), 2);
        }
        return new zzjm(new zziy("HmacSha256"), 1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjd
    public final byte[] zza(byte[] bArr, zzje zzjeVar) throws GeneralSecurityException {
        byte[] zzf = zzvg.zzf(zzvg.zzg(this.zzb, zzjeVar.zza().zzc()), zzvg.zzh(zzvg.zzi(this.zzb), 1, bArr));
        byte[] zzb = zzuz.zzb(bArr, zzjeVar.zzb().zzc());
        byte[] zzd = zzjl.zzd(zzb());
        zziy zziyVar = this.zza;
        return zziyVar.zzb(null, zzf, "eae_prk", zzb, "shared_secret", zzd, zziyVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjd
    public final byte[] zzb() throws GeneralSecurityException {
        int i4 = this.zzb - 1;
        if (i4 != 0) {
            if (i4 != 1) {
                return zzjl.zze;
            }
            return zzjl.zzd;
        }
        return zzjl.zzc;
    }
}
