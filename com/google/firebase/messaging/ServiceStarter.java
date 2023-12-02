package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayDeque;
import java.util.Queue;

@KeepForSdk
/* loaded from: classes5.dex */
public class ServiceStarter {
    @KeepForSdk
    public static final int ERROR_UNKNOWN = 500;
    public static final int SUCCESS = -1;

    /* renamed from: e  reason: collision with root package name */
    private static ServiceStarter f31714e;
    @Nullable
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private String f31715a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f31716b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f31717c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f31718d = new ArrayDeque();

    private ServiceStarter() {
    }

    private int a(Context context, Intent intent) {
        ComponentName startService;
        String f4 = f(context, intent);
        if (f4 != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Restricting intent to a specific service: ");
                sb.append(f4);
            }
            intent.setClassName(context.getPackageName(), f4);
        }
        try {
            if (e(context)) {
                startService = WakeLockHolder.h(context, intent);
            } else {
                startService = context.startService(intent);
            }
            if (startService == null) {
                Log.e(Constants.TAG, "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            return -1;
        } catch (IllegalStateException e4) {
            Log.e(Constants.TAG, "Failed to start service while in background: " + e4);
            return 402;
        } catch (SecurityException e5) {
            Log.e(Constants.TAG, "Error while delivering the message to the serviceIntent", e5);
            return 401;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized ServiceStarter b() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (f31714e == null) {
                f31714e = new ServiceStarter();
            }
            serviceStarter = f31714e;
        }
        return serviceStarter;
    }

    @Nullable
    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.f31715a;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    this.f31715a = context.getPackageName() + serviceInfo.name;
                } else {
                    this.f31715a = serviceInfo.name;
                }
                return this.f31715a;
            }
            Log.e(Constants.TAG, "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + RemoteSettings.FORWARD_SLASH_STRING + serviceInfo.name);
            return null;
        }
        Log.e(Constants.TAG, "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    @VisibleForTesting
    public static void setForTesting(ServiceStarter serviceStarter) {
        f31714e = serviceStarter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public Intent c() {
        return this.f31718d.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Context context) {
        boolean z3;
        if (this.f31717c == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f31717c = Boolean.valueOf(z3);
        }
        if (!this.f31716b.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.f31717c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context) {
        boolean z3;
        if (this.f31716b == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f31716b = Boolean.valueOf(z3);
        }
        if (!this.f31716b.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.f31716b.booleanValue();
    }

    @MainThread
    public int startMessagingService(Context context, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        this.f31718d.offer(intent);
        Intent intent2 = new Intent(com.google.firebase.iid.ServiceStarter.ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
