package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes5.dex */
public class SyncTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f31501a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f31502b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f31503c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    ExecutorService f31504d = FirebaseIidExecutors.b();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private SyncTask f31505a;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f31505a = syncTask;
        }

        public void a() {
            FirebaseInstanceId.n();
            this.f31505a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f31505a;
            if (syncTask == null || !syncTask.c()) {
                return;
            }
            FirebaseInstanceId.n();
            this.f31505a.f31503c.f(this.f31505a, 0L);
            this.f31505a.b().unregisterReceiver(this);
            this.f31505a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j4) {
        this.f31503c = firebaseInstanceId;
        this.f31501a = j4;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f31502b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    Context b() {
        return this.f31503c.g().getApplicationContext();
    }

    boolean c() {
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
    boolean d() throws IOException {
        if (!this.f31503c.B(this.f31503c.l())) {
            return true;
        }
        try {
            if (this.f31503c.d() == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            Log.isLoggable("FirebaseInstanceId", 3);
            return true;
        } catch (IOException e4) {
            if (GmsRpc.e(e4.getMessage())) {
                String message = e4.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.w("FirebaseInstanceId", sb.toString());
                return false;
            } else if (e4.getMessage() == null) {
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e4;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (ServiceStarter.getInstance().b(b())) {
            this.f31502b.acquire();
        }
        try {
            try {
                this.f31503c.x(true);
                if (!this.f31503c.isGmsCorePresent()) {
                    this.f31503c.x(false);
                    if (!ServiceStarter.getInstance().b(b())) {
                        return;
                    }
                } else if (ServiceStarter.getInstance().a(b()) && !c()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (!ServiceStarter.getInstance().b(b())) {
                        return;
                    }
                } else {
                    if (d()) {
                        this.f31503c.x(false);
                    } else {
                        this.f31503c.A(this.f31501a);
                    }
                    if (!ServiceStarter.getInstance().b(b())) {
                        return;
                    }
                }
            } catch (IOException e4) {
                String message = e4.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f31503c.x(false);
                if (!ServiceStarter.getInstance().b(b())) {
                    return;
                }
            }
            this.f31502b.release();
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().b(b())) {
                this.f31502b.release();
            }
            throw th;
        }
    }
}
