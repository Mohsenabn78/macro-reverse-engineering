package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class InstantApps {

    /* renamed from: a  reason: collision with root package name */
    private static Context f20756a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f20757b;

    @KeepForSdk
    public static synchronized boolean isInstantApp(@NonNull Context context) {
        boolean isInstantApp;
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f20756a;
            if (context2 != null && (bool = f20757b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f20757b = null;
            if (PlatformVersion.isAtLeastO()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                f20757b = Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f20757b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f20757b = Boolean.FALSE;
                }
            }
            f20756a = applicationContext;
            return f20757b.booleanValue();
        }
    }
}
