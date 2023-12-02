package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzp implements zzch<zzn> {
    private final zzcl<Application> zza;
    private final zzcl<zzb> zzb;
    private final zzcl<zzam> zzc;

    public zzp(zzcl<Application> zzclVar, zzcl<zzb> zzclVar2, zzcl<zzam> zzclVar3) {
        this.zza = zzclVar;
        this.zzb = zzclVar2;
        this.zzc = zzclVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcl
    /* renamed from: zza */
    public final zzn zzb() {
        return new zzn(this.zza.zzb(), ((zzc) this.zzb).zzb(), this.zzc.zzb());
    }
}
