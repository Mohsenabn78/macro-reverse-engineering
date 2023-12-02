package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg  reason: invalid package */
/* loaded from: classes4.dex */
final class zzdg extends zzkl {
    final /* synthetic */ zzdh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzdh zzdhVar, Class cls) {
        super(cls);
        this.zza = zzdhVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpj zzpjVar = (zzpj) zzaiiVar;
        new zzdv();
        zzpm zzf = zzdu.zzf(zzpjVar.zzd());
        zzaii zza = new zznp().zza().zza(zzpjVar.zze());
        zzpf zzb = zzpg.zzb();
        zzb.zza(zzf);
        zzb.zzb((zzsd) zza);
        zzb.zzc(0);
        return (zzpg) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzpj.zzc(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzdh.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzdh.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzdh.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdh.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpj zzpjVar = (zzpj) zzaiiVar;
        ((zzdu) new zzdv().zza()).zzd(zzpjVar.zzd());
        new zznp().zza().zzd(zzpjVar.zze());
        zzwf.zzb(zzpjVar.zzd().zza());
    }
}
