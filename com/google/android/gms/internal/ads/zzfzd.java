package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfzd extends zzgdt {
    final /* synthetic */ zzfze zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfzd(zzfze zzfzeVar, Class cls) {
        super(cls);
        this.zza = zzfzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgik zzgikVar = (zzgik) zzgqwVar;
        new zzfzs();
        zzgin zzf = zzfzr.zzf(zzgikVar.zze());
        zzgqw zza = new zzggq().zza().zza(zzgikVar.zzf());
        zzgig zzc = zzgih.zzc();
        zzc.zza(zzf);
        zzc.zzb((zzgjz) zza);
        zzc.zzc(0);
        return (zzgih) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgik.zzd(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzfze.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzfze.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzfze.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzfze.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgik zzgikVar = (zzgik) zzgqwVar;
        ((zzfzr) new zzfzs().zza()).zzd(zzgikVar.zze());
        new zzggq().zza().zzd(zzgikVar.zzf());
        zzgni.zza(zzgikVar.zze().zza());
    }
}
