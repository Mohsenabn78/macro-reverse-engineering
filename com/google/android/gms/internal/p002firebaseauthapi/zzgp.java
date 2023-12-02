package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgp  reason: invalid package */
/* loaded from: classes4.dex */
final class zzgp extends zzkl {
    final /* synthetic */ zzgq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgp(zzgq zzgqVar, Class cls) {
        super(cls);
        this.zza = zzgqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzur zzurVar = (zzur) zzaiiVar;
        zzun zzb = zzuo.zzb();
        zzb.zzb(0);
        byte[] zzb2 = zzlx.zzb(32);
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        return (zzuo) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzur.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzkk(zzur.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzkk(zzur.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzur zzurVar = (zzur) zzaiiVar;
    }
}
