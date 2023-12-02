package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzno  reason: invalid package */
/* loaded from: classes4.dex */
final class zzno extends zzkl {
    final /* synthetic */ zznp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzno(zznp zznpVar, Class cls) {
        super(cls);
        this.zza = zznpVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzsg zzsgVar = (zzsg) zzaiiVar;
        zzsc zzb = zzsd.zzb();
        zzb.zzc(0);
        zzb.zzb(zzsgVar.zzg());
        byte[] zzb2 = zzlx.zzb(zzsgVar.zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        return (zzsd) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzsg.zzf(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zznp.zzn(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zznp.zzn(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zznp.zzn(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zznp.zzn(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zznp.zzn(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zznp.zzn(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zznp.zzn(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zznp.zzn(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zznp.zzn(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zznp.zzn(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzsg zzsgVar = (zzsg) zzaiiVar;
        if (zzsgVar.zza() >= 16) {
            zznp.zzo(zzsgVar.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
