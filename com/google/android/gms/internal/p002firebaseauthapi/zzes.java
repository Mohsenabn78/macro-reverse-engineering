package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
/* loaded from: classes4.dex */
final class zzes extends zzkl {
    final /* synthetic */ zzet zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzes(zzet zzetVar, Class cls) {
        super(cls);
        this.zza = zzetVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqd zzb = zzqe.zzb();
        byte[] zzb2 = zzlx.zzb(((zzqh) zzaiiVar).zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(0);
        return (zzqe) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzqh.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzet.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzet.zzg(16, 3));
        hashMap.put("AES256_GCM", zzet.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzet.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzwf.zzb(((zzqh) zzaiiVar).zza());
    }
}
