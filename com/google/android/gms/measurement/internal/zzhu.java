package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f21800a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21801b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhu(zzik zzikVar, Bundle bundle) {
        this.f21801b = zzikVar;
        this.f21800a = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzik zzikVar = this.f21801b;
        Bundle bundle = this.f21800a;
        zzikVar.zzg();
        zzikVar.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzikVar.f21734a.zzJ()) {
            zzikVar.f21734a.zzaA().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzikVar.f21734a.zzt().g(new zzac(bundle.getString("app_id"), "", new zzlk(checkNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzikVar.f21734a.zzv().V(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
