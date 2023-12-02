package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class ServiceStarter {
    public static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    @KeepForSdk
    public static final int ERROR_UNKNOWN = 500;

    /* renamed from: c  reason: collision with root package name */
    private static ServiceStarter f31491c;

    /* renamed from: a  reason: collision with root package name */
    private Boolean f31492a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f31493b = null;

    private ServiceStarter() {
    }

    @KeepForSdk
    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (f31491c == null) {
                f31491c = new ServiceStarter();
            }
            serviceStarter = f31491c;
        }
        return serviceStarter;
    }

    @VisibleForTesting
    public static void setForTesting(ServiceStarter serviceStarter) {
        f31491c = serviceStarter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context) {
        boolean z3;
        if (this.f31493b == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f31493b = Boolean.valueOf(z3);
        }
        if (!this.f31492a.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f31493b.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Context context) {
        boolean z3;
        if (this.f31492a == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f31492a = Boolean.valueOf(z3);
        }
        if (!this.f31492a.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f31492a.booleanValue();
    }
}
