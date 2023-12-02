package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* loaded from: classes5.dex */
public final class zzd implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zze f28759a;

    public zzd(zze zzeVar) {
        this.f28759a = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzhg
    public final void onEvent(String str, String str2, Bundle bundle, long j4) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (!this.f28759a.f28760a.contains(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        int i4 = zzc.zza;
        String zza = zzhc.zza(str2);
        if (zza != null) {
            str2 = zza;
        }
        bundle2.putString("events", str2);
        analyticsConnectorListener = this.f28759a.f28761b;
        analyticsConnectorListener.onMessageTriggered(2, bundle2);
    }
}
