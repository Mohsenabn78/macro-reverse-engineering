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
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TopicsSyncTask implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f31752f = new Object();
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f31753g;
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f31754h;

    /* renamed from: a  reason: collision with root package name */
    private final Context f31755a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f31756b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f31757c;

    /* renamed from: d  reason: collision with root package name */
    private final TopicsSubscriber f31758d;

    /* renamed from: e  reason: collision with root package name */
    private final long f31759e;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable
        @GuardedBy("this")

        /* renamed from: a  reason: collision with root package name */
        private TopicsSyncTask f31760a;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.f31760a = topicsSyncTask;
        }

        public void a() {
            TopicsSyncTask.b();
            TopicsSyncTask.this.f31755a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.f31760a;
            if (topicsSyncTask == null) {
                return;
            }
            if (!topicsSyncTask.i()) {
                return;
            }
            TopicsSyncTask.b();
            this.f31760a.f31758d.m(this.f31760a, 0L);
            context.unregisterReceiver(this);
            this.f31760a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j4) {
        this.f31758d = topicsSubscriber;
        this.f31755a = context;
        this.f31759e = j4;
        this.f31756b = metadata;
        this.f31757c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, Constants.FCM_WAKE_LOCK);
    }

    static /* synthetic */ boolean b() {
        return j();
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (f31752f) {
            Boolean bool = f31754h;
            if (bool == null) {
                booleanValue = g(context, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f31754h = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        boolean z3;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && Log.isLoggable(Constants.TAG, 3)) {
            e(str);
        }
        return z3;
    }

    private static boolean h(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (f31752f) {
            Boolean bool = f31753g;
            if (bool == null) {
                booleanValue = g(context, "android.permission.WAKE_LOCK", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f31753g = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo networkInfo;
        boolean z3;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f31755a.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                z3 = true;
            }
        }
        z3 = false;
        return z3;
    }

    private static boolean j() {
        if (!Log.isLoggable(Constants.TAG, 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable(Constants.TAG, 3))) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f31755a)) {
            this.f31757c.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            try {
                try {
                    this.f31758d.o(true);
                } catch (IOException e4) {
                    Log.e(Constants.TAG, "Failed to sync topics. Won't retry sync. " + e4.getMessage());
                    this.f31758d.o(false);
                    if (h(this.f31755a)) {
                        wakeLock = this.f31757c;
                    } else {
                        return;
                    }
                }
                if (!this.f31756b.g()) {
                    this.f31758d.o(false);
                    if (h(this.f31755a)) {
                        try {
                            this.f31757c.release();
                        } catch (RuntimeException unused) {
                            Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } else if (f(this.f31755a) && !i()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (h(this.f31755a)) {
                        try {
                            this.f31757c.release();
                        } catch (RuntimeException unused2) {
                            Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } else {
                    if (this.f31758d.s()) {
                        this.f31758d.o(false);
                    } else {
                        this.f31758d.t(this.f31759e);
                    }
                    if (h(this.f31755a)) {
                        wakeLock = this.f31757c;
                        wakeLock.release();
                    }
                }
            } catch (Throwable th) {
                if (h(this.f31755a)) {
                    try {
                        this.f31757c.release();
                    } catch (RuntimeException unused3) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
                throw th;
            }
        } catch (RuntimeException unused4) {
            Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
