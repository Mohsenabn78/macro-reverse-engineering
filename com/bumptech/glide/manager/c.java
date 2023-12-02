package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes3.dex */
final class c implements ConnectivityMonitor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17376a;

    /* renamed from: b  reason: collision with root package name */
    final ConnectivityMonitor.ConnectivityListener f17377b;

    /* renamed from: c  reason: collision with root package name */
    boolean f17378c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17379d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f17380e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            c cVar = c.this;
            boolean z3 = cVar.f17378c;
            cVar.f17378c = cVar.a(context);
            if (z3 != c.this.f17378c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("connectivity changed, isConnected: ");
                    sb.append(c.this.f17378c);
                }
                c cVar2 = c.this;
                cVar2.f17377b.onConnectivityChanged(cVar2.f17378c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f17376a = context.getApplicationContext();
        this.f17377b = connectivityListener;
    }

    private void b() {
        if (this.f17379d) {
            return;
        }
        this.f17378c = a(this.f17376a);
        try {
            this.f17376a.registerReceiver(this.f17380e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f17379d = true;
        } catch (SecurityException e4) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e4);
            }
        }
    }

    private void c() {
        if (!this.f17379d) {
            return;
        }
        this.f17376a.unregisterReceiver(this.f17380e);
        this.f17379d = false;
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (RuntimeException e4) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e4);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        b();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        c();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }
}
