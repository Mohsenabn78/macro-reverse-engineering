package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
/* loaded from: classes4.dex */
final class zzhr extends zzkl {
    final /* synthetic */ zzhs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhr(zzhs zzhsVar, Class cls) {
        super(cls);
        this.zza = zzhsVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqp zzb = zzqq.zzb();
        byte[] zzb2 = zzlx.zzb(((zzqt) zzaiiVar).zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(0);
        return (zzqq) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzqt.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzqs zzc = zzqt.zzc();
        zzc.zza(64);
        hashMap.put("AES256_SIV", new zzkk((zzqt) zzc.zzi(), 1));
        zzqs zzc2 = zzqt.zzc();
        zzc2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzkk((zzqt) zzc2.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqt zzqtVar = (zzqt) zzaiiVar;
        if (zzqtVar.zza() == 64) {
            return;
        }
        int zza = zzqtVar.zza();
        throw new InvalidAlgorithmParameterException("invalid key size: " + zza + ". Valid keys must have 64 bytes.");
    }
}
