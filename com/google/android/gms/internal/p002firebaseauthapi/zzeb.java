package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb  reason: invalid package */
/* loaded from: classes4.dex */
final class zzeb extends zzkl {
    final /* synthetic */ zzec zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzec zzecVar, Class cls) {
        super(cls);
        this.zza = zzecVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpy zzpyVar = (zzpy) zzaiiVar;
        zzpu zzb = zzpv.zzb();
        byte[] zzb2 = zzlx.zzb(zzpyVar.zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(zzpyVar.zze());
        zzb.zzc(0);
        return (zzpv) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzpy.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzec.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzec.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzec.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzec.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpy zzpyVar = (zzpy) zzaiiVar;
        zzwf.zzb(zzpyVar.zza());
        if (zzpyVar.zze().zza() != 12 && zzpyVar.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
