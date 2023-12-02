package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public class ProviderInstaller {
    @NonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";

    /* renamed from: a  reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f22564a = GoogleApiAvailabilityLight.getInstance();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f22565b = new Object();
    @GuardedBy("ProviderInstaller.lock")

    /* renamed from: c  reason: collision with root package name */
    private static Method f22566c = null;
    @GuardedBy("ProviderInstaller.lock")

    /* renamed from: d  reason: collision with root package name */
    private static Method f22567d = null;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes4.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i4, @Nullable Intent intent);

        void onProviderInstalled();
    }

    private static Method b(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    @GuardedBy("ProviderInstaller.lock")
    private static void c(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        String message;
        try {
            if (f22566c == null) {
                f22566c = b(context, str, "insertProvider", new Class[]{Context.class});
            }
            f22566c.invoke(null, context);
        } catch (Exception e4) {
            Throwable cause = e4.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                if (cause == null) {
                    message = e4.getMessage();
                } else {
                    message = cause.getMessage();
                }
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(message)));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }

    public static void installIfNeeded(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        f22564a.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (f22565b) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e4) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e4.getMessage())));
                context2 = null;
            }
            if (context2 == null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext != null) {
                    try {
                        if (f22567d == null) {
                            Class cls = Long.TYPE;
                            f22567d = b(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                        }
                        f22567d.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                    } catch (Exception e5) {
                        Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e5.getMessage())));
                    }
                }
                if (remoteContext != null) {
                    c(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                } else {
                    Log.e("ProviderInstaller", "Failed to get remote context");
                    throw new GooglePlayServicesNotAvailableException(8);
                }
            }
            c(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
        }
    }

    public static void installIfNeededAsync(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }
}
