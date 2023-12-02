package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzaz implements zzch<zzay> {
    private final zzcl<Application> zza;
    private final zzcl<zzac> zzb;
    private final zzcl<zzbi> zzc;
    private final zzcl<zzam> zzd;
    private final zzcl<zzbc> zze;
    private final zzcl<zzbg> zzf;

    public zzaz(zzcl<Application> zzclVar, zzcl<zzac> zzclVar2, zzcl<zzbi> zzclVar3, zzcl<zzam> zzclVar4, zzcl<zzbc> zzclVar5, zzcl<zzbg> zzclVar6) {
        this.zza = zzclVar;
        this.zzb = zzclVar2;
        this.zzc = zzclVar3;
        this.zzd = zzclVar4;
        this.zze = zzclVar5;
        this.zzf = zzclVar6;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcl
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzay(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb(), this.zzf);
    }
}
