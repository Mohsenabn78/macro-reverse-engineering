package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class WithinAppServiceConnection implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31766a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f31767b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f31768c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<BindRequest> f31769d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private WithinAppServiceBinder f31770e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private boolean f31771f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class BindRequest {

        /* renamed from: a  reason: collision with root package name */
        final Intent f31772a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskCompletionSource<Void> f31773b = new TaskCompletionSource<>();

        BindRequest(Intent intent) {
            this.f31772a = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w(Constants.TAG, "Service took too long to process intent: " + this.f31772a.getAction() + " finishing.");
            d();
        }

        void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.g0
                @Override // java.lang.Runnable
                public final void run() {
                    WithinAppServiceConnection.BindRequest.this.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.h0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    schedule.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.f31773b.trySetResult(null);
        }

        Task<Void> e() {
            return this.f31773b.getTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public WithinAppServiceConnection(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @GuardedBy("this")
    private void a() {
        while (!this.f31769d.isEmpty()) {
            this.f31769d.poll().d();
        }
    }

    private synchronized void b() {
        Log.isLoggable(Constants.TAG, 3);
        while (!this.f31769d.isEmpty()) {
            Log.isLoggable(Constants.TAG, 3);
            WithinAppServiceBinder withinAppServiceBinder = this.f31770e;
            if (withinAppServiceBinder != null && withinAppServiceBinder.isBinderAlive()) {
                Log.isLoggable(Constants.TAG, 3);
                this.f31770e.c(this.f31769d.poll());
            } else {
                d();
                return;
            }
        }
    }

    @GuardedBy("this")
    private void d() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f31771f);
        }
        if (this.f31771f) {
            return;
        }
        this.f31771f = true;
        try {
        } catch (SecurityException e4) {
            Log.e(Constants.TAG, "Exception while binding the service", e4);
        }
        if (ConnectionTracker.getInstance().bindService(this.f31766a, this.f31767b, this, 65)) {
            return;
        }
        Log.e(Constants.TAG, "binding to the service failed");
        this.f31771f = false;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public synchronized Task<Void> c(Intent intent) {
        BindRequest bindRequest;
        Log.isLoggable(Constants.TAG, 3);
        bindRequest = new BindRequest(intent);
        bindRequest.c(this.f31768c);
        this.f31769d.add(bindRequest);
        b();
        return bindRequest.e();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected: ");
            sb.append(componentName);
        }
        this.f31771f = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            Log.e(Constants.TAG, "Invalid service connection: " + iBinder);
            a();
            return;
        }
        this.f31770e = (WithinAppServiceBinder) iBinder;
        b();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceDisconnected: ");
            sb.append(componentName);
        }
        b();
    }

    @VisibleForTesting
    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f31769d = new ArrayDeque();
        this.f31771f = false;
        Context applicationContext = context.getApplicationContext();
        this.f31766a = applicationContext;
        this.f31767b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f31768c = scheduledExecutorService;
    }
}
