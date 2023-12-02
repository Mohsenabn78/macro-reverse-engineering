package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgft extends zzgdt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgft(zzgfu zzgfuVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgib zzgibVar = (zzgib) zzgqwVar;
        zzghx zzc = zzghy.zzc();
        zzc.zzc(0);
        byte[] zza = zzgng.zza(zzgibVar.zza());
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        zzc.zzb(zzgibVar.zzf());
        return (zzghy) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgib.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzgia zzc = zzgib.zzc();
        zzc.zza(32);
        zzgid zzc2 = zzgie.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgie) zzc2.zzal());
        hashMap.put("AES_CMAC", new zzgds((zzgib) zzc.zzal(), 1));
        zzgia zzc3 = zzgib.zzc();
        zzc3.zza(32);
        zzgid zzc4 = zzgie.zzc();
        zzc4.zza(16);
        zzc3.zzb((zzgie) zzc4.zzal());
        hashMap.put("AES256_CMAC", new zzgds((zzgib) zzc3.zzal(), 1));
        zzgia zzc5 = zzgib.zzc();
        zzc5.zza(32);
        zzgid zzc6 = zzgie.zzc();
        zzc6.zza(16);
        zzc5.zzb((zzgie) zzc6.zzal());
        hashMap.put("AES256_CMAC_RAW", new zzgds((zzgib) zzc5.zzal(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgib zzgibVar = (zzgib) zzgqwVar;
        zzgfu.zzn(zzgibVar.zzf());
        zzgfu.zzo(zzgibVar.zza());
    }
}
