package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzw implements zzch<zzv> {
    private final zzcl<Application> zza;
    private final zzcl<zzac> zzb;
    private final zzcl<Handler> zzc;
    private final zzcl<Executor> zzd;
    private final zzcl<zzam> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzn> zzg;
    private final zzcl<zzz> zzh;
    private final zzcl<zzh> zzi;

    public zzw(zzcl<Application> zzclVar, zzcl<zzac> zzclVar2, zzcl<Handler> zzclVar3, zzcl<Executor> zzclVar4, zzcl<zzam> zzclVar5, zzcl<zzba> zzclVar6, zzcl<zzn> zzclVar7, zzcl<zzz> zzclVar8, zzcl<zzh> zzclVar9) {
        this.zza = zzclVar;
        this.zzb = zzclVar2;
        this.zzc = zzclVar3;
        this.zzd = zzclVar4;
        this.zze = zzclVar5;
        this.zzf = zzclVar6;
        this.zzg = zzclVar7;
        this.zzh = zzclVar8;
        this.zzi = zzclVar9;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcl
    /* renamed from: zza */
    public final zzv zzb() {
        Handler handler = zzcd.zza;
        zzck.zza(handler);
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzv(this.zza.zzb(), this.zzb.zzb(), handler, executor, this.zze.zzb(), this.zzf.zzb(), ((zzp) this.zzg).zzb(), ((zzab) this.zzh).zzb(), this.zzi.zzb());
    }
}
