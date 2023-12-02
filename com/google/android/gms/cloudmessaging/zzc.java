package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzc extends ClassLoader {
    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z3) throws ClassNotFoundException {
        if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
            if (!Log.isLoggable("CloudMessengerCompat", 3) && Build.VERSION.SDK_INT == 23) {
                Log.isLoggable("CloudMessengerCompat", 3);
                return zzd.class;
            }
            return zzd.class;
        }
        return super.loadClass(str, z3);
    }
}
