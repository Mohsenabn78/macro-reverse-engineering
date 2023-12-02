package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzo implements zzhf {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzci f22085a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f22086b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzci zzciVar) {
        this.f22086b = appMeasurementDynamiteService;
        this.f22085a = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final void interceptEvent(String str, String str2, Bundle bundle, long j4) {
        try {
            this.f22085a.zze(str, str2, bundle, j4);
        } catch (RemoteException e4) {
            zzgd zzgdVar = this.f22086b.f21422a;
            if (zzgdVar != null) {
                zzgdVar.zzaA().zzk().zzb("Event interceptor threw exception", e4);
            }
        }
    }
}
