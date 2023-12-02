package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfx  reason: invalid package */
/* loaded from: classes4.dex */
final class zzfx extends zzkl {
    final /* synthetic */ zzfy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfx(zzfy zzfyVar, Class cls) {
        super(cls);
        this.zza = zzfyVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqz zzqzVar = (zzqz) zzaiiVar;
        zzqv zzb = zzqw.zzb();
        zzb.zzb(0);
        byte[] zzb2 = zzlx.zzb(32);
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        return (zzqw) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzqz.zzc(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzkk(zzqz.zzb(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzkk(zzqz.zzb(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqz zzqzVar = (zzqz) zzaiiVar;
    }
}
