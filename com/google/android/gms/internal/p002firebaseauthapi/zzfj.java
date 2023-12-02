package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfj  reason: invalid package */
/* loaded from: classes4.dex */
final class zzfj extends zzkl {
    final /* synthetic */ zzfk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfj(zzfk zzfkVar, Class cls) {
        super(cls);
        this.zza = zzfkVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqj zzb = zzqk.zzb();
        byte[] zzb2 = zzlx.zzb(((zzqn) zzaiiVar).zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(0);
        return (zzqk) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzqn.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzfk.zzh(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfk.zzh(16, 3));
        hashMap.put("AES256_GCM_SIV", zzfk.zzh(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfk.zzh(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzwf.zzb(((zzqn) zzaiiVar).zza());
    }
}
