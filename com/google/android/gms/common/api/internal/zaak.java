package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f20142a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaak(zaaw zaawVar) {
        this.f20142a = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        zaaw zaawVar = this.f20142a;
        googleApiAvailabilityLight = zaawVar.f20161d;
        context = zaawVar.f20160c;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}
