package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgbu extends zzgdt {
    final /* synthetic */ zzgbv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgbu(zzgbv zzgbvVar, Class cls) {
        super(cls);
        this.zza = zzgbvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgju zzgjuVar = (zzgju) zzgqwVar;
        zzgjq zzc = zzgjr.zzc();
        zzc.zzb(0);
        byte[] zza = zzgng.zza(32);
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        return (zzgjr) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgju.zzd(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzgds(zzgju.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzgds(zzgju.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgju zzgjuVar = (zzgju) zzgqwVar;
    }
}
