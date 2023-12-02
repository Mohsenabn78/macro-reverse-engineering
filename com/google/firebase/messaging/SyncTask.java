package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SyncTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f31730a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f31731b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseMessaging f31732c;
    @SuppressLint({"ThreadPoolCreation"})
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    ExecutorService f31733d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private SyncTask f31734a;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f31734a = syncTask;
        }

        public void a() {
            SyncTask.c();
            this.f31734a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f31734a;
            if (syncTask == null || !syncTask.d()) {
                return;
            }
            SyncTask.c();
            this.f31734a.f31732c.o(this.f31734a, 0L);
            this.f31734a.b().unregisterReceiver(this);
            this.f31734a = null;
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    @VisibleForTesting
    public SyncTask(FirebaseMessaging firebaseMessaging, long j4) {
        this.f31732c = firebaseMessaging;
        this.f31730a = j4;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f31731b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        if (!Log.isLoggable(Constants.TAG, 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable(Constants.TAG, 3))) {
            return false;
        }
        return true;
    }

    Context b() {
        return this.f31732c.p();
    }

    boolean d() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean e() throws IOException {
        try {
            if (this.f31732c.n() == null) {
                Log.e(Constants.TAG, "Token retrieval failed: null");
                return false;
            }
            Log.isLoggable(Constants.TAG, 3);
            return true;
        } catch (IOException e4) {
            if (GmsRpc.h(e4.getMessage())) {
                Log.w(Constants.TAG, "Token retrieval failed: " + e4.getMessage() + ". Will retry token retrieval");
                return false;
            } else if (e4.getMessage() == null) {
                Log.w(Constants.TAG, "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e4;
            }
        } catch (SecurityException unused) {
            Log.w(Constants.TAG, "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (ServiceStarter.b().e(b())) {
            this.f31731b.acquire();
        }
        try {
            try {
                this.f31732c.G(true);
            } catch (IOException e4) {
                Log.e(Constants.TAG, "Topic sync or token retrieval failed on hard failure exceptions: " + e4.getMessage() + ". Won't retry the operation.");
                this.f31732c.G(false);
                if (!ServiceStarter.b().e(b())) {
                    return;
                }
            }
            if (!this.f31732c.u()) {
                this.f31732c.G(false);
                if (ServiceStarter.b().e(b())) {
                    this.f31731b.release();
                }
            } else if (ServiceStarter.b().d(b()) && !d()) {
                new ConnectivityChangeReceiver(this).a();
                if (ServiceStarter.b().e(b())) {
                    this.f31731b.release();
                }
            } else {
                if (e()) {
                    this.f31732c.G(false);
                } else {
                    this.f31732c.J(this.f31730a);
                }
                if (!ServiceStarter.b().e(b())) {
                    return;
                }
                this.f31731b.release();
            }
        } catch (Throwable th) {
            if (ServiceStarter.b().e(b())) {
                this.f31731b.release();
            }
            throw th;
        }
    }
}
