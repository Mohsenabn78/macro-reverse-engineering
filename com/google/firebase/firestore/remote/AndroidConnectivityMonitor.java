package com.google.firebase.firestore.remote;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class AndroidConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31045a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f31046b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Runnable f31047c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Consumer<ConnectivityMonitor.NetworkStatus>> f31048d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes5.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        private DefaultNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            AndroidConnectivityMonitor.this.j(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            AndroidConnectivityMonitor.this.j(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class NetworkReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31054a;

        private NetworkReceiver() {
            this.f31054a = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean g4 = AndroidConnectivityMonitor.this.g();
            if (AndroidConnectivityMonitor.this.g() && !this.f31054a) {
                AndroidConnectivityMonitor.this.j(true);
            } else if (!g4 && this.f31054a) {
                AndroidConnectivityMonitor.this.j(false);
            }
            this.f31054a = g4;
        }
    }

    public AndroidConnectivityMonitor(Context context) {
        boolean z3;
        if (context != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Context must be non-null", new Object[0]);
        this.f31045a = context;
        this.f31046b = (ConnectivityManager) context.getSystemService("connectivity");
        e();
        f();
    }

    private void e() {
        Application application = (Application) this.f31045a.getApplicationContext();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.google.firebase.firestore.remote.AndroidConnectivityMonitor.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
                if (atomicBoolean.compareAndSet(true, false)) {
                    AndroidConnectivityMonitor.this.raiseForegroundNotification();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
                if (atomicBoolean.compareAndSet(true, false)) {
                    AndroidConnectivityMonitor.this.raiseForegroundNotification();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
                if (atomicBoolean.compareAndSet(true, false)) {
                    AndroidConnectivityMonitor.this.raiseForegroundNotification();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.google.firebase.firestore.remote.AndroidConnectivityMonitor.2
            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i4) {
                if (i4 == 20) {
                    atomicBoolean.set(true);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(@NonNull Configuration configuration) {
            }
        });
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 24 && this.f31046b != null) {
            final DefaultNetworkCallback defaultNetworkCallback = new DefaultNetworkCallback();
            this.f31046b.registerDefaultNetworkCallback(defaultNetworkCallback);
            this.f31047c = new Runnable() { // from class: com.google.firebase.firestore.remote.g
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidConnectivityMonitor.this.h(defaultNetworkCallback);
                }
            };
            return;
        }
        final NetworkReceiver networkReceiver = new NetworkReceiver();
        this.f31045a.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f31047c = new Runnable() { // from class: com.google.firebase.firestore.remote.h
            @Override // java.lang.Runnable
            public final void run() {
                AndroidConnectivityMonitor.this.i(networkReceiver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f31045a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(DefaultNetworkCallback defaultNetworkCallback) {
        this.f31046b.unregisterNetworkCallback(defaultNetworkCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(NetworkReceiver networkReceiver) {
        this.f31045a.unregisterReceiver(networkReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z3) {
        ConnectivityMonitor.NetworkStatus networkStatus;
        synchronized (this.f31048d) {
            for (Consumer<ConnectivityMonitor.NetworkStatus> consumer : this.f31048d) {
                if (z3) {
                    networkStatus = ConnectivityMonitor.NetworkStatus.REACHABLE;
                } else {
                    networkStatus = ConnectivityMonitor.NetworkStatus.UNREACHABLE;
                }
                consumer.accept(networkStatus);
            }
        }
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void addCallback(Consumer<ConnectivityMonitor.NetworkStatus> consumer) {
        synchronized (this.f31048d) {
            this.f31048d.add(consumer);
        }
    }

    public void raiseForegroundNotification() {
        Logger.debug("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (g()) {
            j(true);
        }
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void shutdown() {
        Runnable runnable = this.f31047c;
        if (runnable != null) {
            runnable.run();
            this.f31047c = null;
        }
    }
}
