package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzez extends zzku {
    public zzez(zzlh zzlhVar) {
        super(zzlhVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    public final boolean zza() {
        a();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f21734a.zzaw().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
