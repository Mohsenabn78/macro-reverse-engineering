package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class ConnectionTracker {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f20696a = new Object();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static volatile ConnectionTracker f20697b;
    @NonNull
    @VisibleForTesting
    public ConcurrentHashMap zza = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    private static void a(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean b(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i4, boolean z3, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (c(serviceConnection)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.zza.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean d4 = d(context, intent, serviceConnection, i4, executor);
                if (!d4) {
                    return false;
                }
                return d4;
            } finally {
                this.zza.remove(serviceConnection, serviceConnection);
            }
        }
        return d(context, intent, serviceConnection, i4, executor);
    }

    private static boolean c(ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof zzs)) {
            return true;
        }
        return false;
    }

    private static final boolean d(Context context, Intent intent, ServiceConnection serviceConnection, int i4, @Nullable Executor executor) {
        boolean bindService;
        if (PlatformVersion.isAtLeastQ() && executor != null) {
            bindService = context.bindService(intent, i4, executor, serviceConnection);
            return bindService;
        }
        return context.bindService(intent, serviceConnection, i4);
    }

    @NonNull
    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (f20697b == null) {
            synchronized (f20696a) {
                if (f20697b == null) {
                    f20697b = new ConnectionTracker();
                }
            }
        }
        ConnectionTracker connectionTracker = f20697b;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    @KeepForSdk
    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i4) {
        return b(context, context.getClass().getName(), intent, serviceConnection, i4, true, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (c(serviceConnection) && this.zza.containsKey(serviceConnection)) {
            try {
                a(context, (ServiceConnection) this.zza.get(serviceConnection));
                return;
            } finally {
                this.zza.remove(serviceConnection);
            }
        }
        a(context, serviceConnection);
    }

    @KeepForSdk
    public void unbindServiceSafe(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean zza(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i4, @Nullable Executor executor) {
        return b(context, str, intent, serviceConnection, i4, true, executor);
    }
}
