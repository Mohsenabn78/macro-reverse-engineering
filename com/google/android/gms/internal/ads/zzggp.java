package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzggp extends zzgdt {
    final /* synthetic */ zzggq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzggp(zzggq zzggqVar, Class cls) {
        super(cls);
        this.zza = zzggqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgkc zzgkcVar = (zzgkc) zzgqwVar;
        zzgjy zzc = zzgjz.zzc();
        zzc.zzc(0);
        zzc.zzb(zzgkcVar.zzh());
        byte[] zza = zzgng.zza(zzgkcVar.zza());
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        return (zzgjz) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgkc.zzg(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzggq.zzn(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzggq.zzn(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzggq.zzn(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzggq.zzn(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzggq.zzn(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzggq.zzn(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzggq.zzn(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzggq.zzn(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzggq.zzn(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzggq.zzn(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgkc zzgkcVar = (zzgkc) zzgqwVar;
        if (zzgkcVar.zza() >= 16) {
            zzggq.zzo(zzgkcVar.zzh());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
