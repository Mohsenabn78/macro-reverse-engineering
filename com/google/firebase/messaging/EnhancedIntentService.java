package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.WithinAppServiceBinder;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes5.dex */
public abstract class EnhancedIntentService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private Binder f31631b;

    /* renamed from: d  reason: collision with root package name */
    private int f31633d;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f31630a = FcmExecutors.d();

    /* renamed from: c  reason: collision with root package name */
    private final Object f31632c = new Object();

    /* renamed from: e  reason: collision with root package name */
    private int f31634e = 0;

    private void d(Intent intent) {
        if (intent != null) {
            WakeLockHolder.c(intent);
        }
        synchronized (this.f31632c) {
            int i4 = this.f31634e - 1;
            this.f31634e = i4;
            if (i4 == 0) {
                i(this.f31633d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Intent intent, Task task) {
        d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public Task<Void> h(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f31630a.execute(new Runnable() { // from class: com.google.firebase.messaging.b
            @Override // java.lang.Runnable
            public final void run() {
                EnhancedIntentService.this.g(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    boolean i(int i4) {
        return stopSelfResult(i4);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.f31631b == null) {
            this.f31631b = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() { // from class: com.google.firebase.messaging.EnhancedIntentService.1
                @Override // com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler
                @KeepForSdk
                public Task<Void> a(Intent intent2) {
                    return EnhancedIntentService.this.h(intent2);
                }
            });
        }
        return this.f31631b;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.f31630a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i4, int i5) {
        synchronized (this.f31632c) {
            this.f31633d = i5;
            this.f31634e++;
        }
        Intent e4 = e(intent);
        if (e4 == null) {
            d(intent);
            return 2;
        }
        Task<Void> h4 = h(e4);
        if (h4.isComplete()) {
            d(intent);
            return 2;
        }
        h4.addOnCompleteListener(new androidx.biometric.auth.a(), new OnCompleteListener() { // from class: com.google.firebase.messaging.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                EnhancedIntentService.this.f(intent, task);
            }
        });
        return 3;
    }

    protected Intent e(Intent intent) {
        return intent;
    }
}
