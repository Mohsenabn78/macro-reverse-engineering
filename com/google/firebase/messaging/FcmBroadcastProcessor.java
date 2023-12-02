package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@KeepForSdk
/* loaded from: classes5.dex */
public class FcmBroadcastProcessor {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f31636c = new Object();
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private static WithinAppServiceConnection f31637d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f31638a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f31639b;

    public FcmBroadcastProcessor(Context context) {
        this.f31638a = context;
        this.f31639b = new androidx.biometric.auth.a();
    }

    private static Task<Integer> e(Context context, Intent intent, boolean z3) {
        Log.isLoggable(Constants.TAG, 3);
        WithinAppServiceConnection f4 = f(context, com.google.firebase.iid.ServiceStarter.ACTION_MESSAGING_EVENT);
        if (z3) {
            if (ServiceStarter.b().e(context)) {
                WakeLockHolder.f(context, f4, intent);
            } else {
                f4.c(intent);
            }
            return Tasks.forResult(-1);
        }
        return f4.c(intent).continueWith(new androidx.biometric.auth.a(), new Continuation() { // from class: com.google.firebase.messaging.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Integer g4;
                g4 = FcmBroadcastProcessor.g(task);
                return g4;
            }
        });
    }

    private static WithinAppServiceConnection f(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (f31636c) {
            if (f31637d == null) {
                f31637d = new WithinAppServiceConnection(context, str);
            }
            withinAppServiceConnection = f31637d;
        }
        return withinAppServiceConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer g(Task task) throws Exception {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer h(Context context, Intent intent) throws Exception {
        return Integer.valueOf(ServiceStarter.b().startMessagingService(context, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer i(Task task) throws Exception {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task j(Context context, Intent intent, boolean z3, Task task) throws Exception {
        if (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) {
            return e(context, intent, z3).continueWith(new androidx.biometric.auth.a(), new Continuation() { // from class: com.google.firebase.messaging.e
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    Integer i4;
                    i4 = FcmBroadcastProcessor.i(task2);
                    return i4;
                }
            });
        }
        return task;
    }

    @VisibleForTesting
    public static void reset() {
        synchronized (f31636c) {
            f31637d = null;
        }
    }

    @VisibleForTesting
    public static void setServiceConnection(WithinAppServiceConnection withinAppServiceConnection) {
        synchronized (f31636c) {
            f31637d = withinAppServiceConnection;
        }
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.f31638a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(final Context context, final Intent intent) {
        boolean z3;
        final boolean z4 = true;
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((intent.getFlags() & 268435456) == 0) {
            z4 = false;
        }
        if (z3 && !z4) {
            return e(context, intent, z4);
        }
        return Tasks.call(this.f31639b, new Callable() { // from class: com.google.firebase.messaging.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer h4;
                h4 = FcmBroadcastProcessor.h(context, intent);
                return h4;
            }
        }).continueWithTask(this.f31639b, new Continuation() { // from class: com.google.firebase.messaging.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task j4;
                j4 = FcmBroadcastProcessor.j(context, intent, z4, task);
                return j4;
            }
        });
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.f31638a = context;
        this.f31639b = executorService;
    }
}
