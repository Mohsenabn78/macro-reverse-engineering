package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* loaded from: classes5.dex */
public final class zzg implements zza {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f28765a;

    /* renamed from: b  reason: collision with root package name */
    private final AppMeasurementSdk f28766b;

    /* renamed from: c  reason: collision with root package name */
    private final zzf f28767c;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f28765a = analyticsConnectorListener;
        this.f28766b = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.f28767c = zzfVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzfVar);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f28765a;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set set) {
    }
}
