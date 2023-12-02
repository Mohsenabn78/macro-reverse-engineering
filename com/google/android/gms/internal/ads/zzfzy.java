package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfzy extends zzgdt {
    final /* synthetic */ zzfzz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfzy(zzfzz zzfzzVar, Class cls) {
        super(cls);
        this.zza = zzfzzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgiz zzgizVar = (zzgiz) zzgqwVar;
        zzgiv zzc = zzgiw.zzc();
        byte[] zza = zzgng.zza(zzgizVar.zza());
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        zzc.zzb(zzgizVar.zzf());
        zzc.zzc(0);
        return (zzgiw) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgiz.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzfzz.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzfzz.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzfzz.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzfzz.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgiz zzgizVar = (zzgiz) zzgqwVar;
        zzgni.zza(zzgizVar.zza());
        if (zzgizVar.zzf().zza() != 12 && zzgizVar.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
