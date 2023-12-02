package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgap extends zzgdt {
    final /* synthetic */ zzgaq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgap(zzgaq zzgaqVar, Class cls) {
        super(cls);
        this.zza = zzgaqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgje zzc = zzgjf.zzc();
        byte[] zza = zzgng.zza(((zzgji) zzgqwVar).zza());
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        zzc.zzb(0);
        return (zzgjf) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgji.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgaq.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzgaq.zzg(16, 3));
        hashMap.put("AES256_GCM", zzgaq.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzgaq.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgni.zza(((zzgji) zzgqwVar).zza());
    }
}
