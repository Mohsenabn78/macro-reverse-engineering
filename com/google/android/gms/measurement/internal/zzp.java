package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzp implements zzhg {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzci f22087a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f22088b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzci zzciVar) {
        this.f22088b = appMeasurementDynamiteService;
        this.f22087a = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhg
    public final void onEvent(String str, String str2, Bundle bundle, long j4) {
        try {
            this.f22087a.zze(str, str2, bundle, j4);
        } catch (RemoteException e4) {
            zzgd zzgdVar = this.f22088b.f21422a;
            if (zzgdVar != null) {
                zzgdVar.zzaA().zzk().zzb("Event listener threw exception", e4);
            }
        }
    }
}
