package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzbn implements zzch<zzbm> {
    private final zzcl<Application> zza;
    private final zzcl<zzbi> zzb;
    private final zzcl<Handler> zzc;
    private final zzcl<Executor> zzd;
    private final zzcl<zzh> zze;
    private final zzcl<zzak> zzf;
    private final zzcl<zzay> zzg;
    private final zzcl<zzam> zzh;

    public zzbn(zzcl<Application> zzclVar, zzcl<zzbi> zzclVar2, zzcl<Handler> zzclVar3, zzcl<Executor> zzclVar4, zzcl<zzh> zzclVar5, zzcl<zzak> zzclVar6, zzcl<zzay> zzclVar7, zzcl<zzam> zzclVar8) {
        this.zza = zzclVar;
        this.zzb = zzclVar2;
        this.zzc = zzclVar3;
        this.zzd = zzclVar4;
        this.zze = zzclVar5;
        this.zzf = zzclVar6;
        this.zzg = zzclVar7;
        this.zzh = zzclVar8;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcl
    /* renamed from: zza */
    public final zzbm zzb() {
        Handler handler = zzcd.zza;
        zzck.zza(handler);
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzbm(this.zza.zzb(), this.zzb.zzb(), handler, executor, this.zze.zzb(), ((zzal) this.zzf).zzb(), this.zzg.zzb(), this.zzh.zzb());
    }
}
