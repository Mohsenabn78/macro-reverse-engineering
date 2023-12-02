package com.google.android.gms.internal.ads;

import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdus implements zzgwe {
    public static zzdus zza() {
        zzdus zzdusVar;
        zzdusVar = zzdur.zza;
        return zzdusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* synthetic */ Object zzb() {
        com.google.android.gms.ads.internal.zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzgwm.zzb(uuid);
        return uuid;
    }
}
