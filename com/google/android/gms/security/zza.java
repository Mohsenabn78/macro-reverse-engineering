package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zza extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f22568a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ProviderInstaller.ProviderInstallListener f22569b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f22568a = context;
        this.f22569b = providerInstallListener;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.installIfNeeded(this.f22568a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e4) {
            return Integer.valueOf(e4.errorCode);
        } catch (GooglePlayServicesRepairableException e5) {
            return Integer.valueOf(e5.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Integer num = (Integer) obj;
        if (num.intValue() != 0) {
            googleApiAvailabilityLight = ProviderInstaller.f22564a;
            this.f22569b.onProviderInstallFailed(num.intValue(), googleApiAvailabilityLight.getErrorResolutionIntent(this.f22568a, num.intValue(), "pi"));
            return;
        }
        this.f22569b.onProviderInstalled();
    }
}
