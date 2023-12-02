package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class WakeLockHolder {

    /* renamed from: a  reason: collision with root package name */
    static final long f31762a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f31763b = new Object();
    @GuardedBy("WakeLockHolder.syncObject")

    /* renamed from: c  reason: collision with root package name */
    private static WakeLock f31764c;

    WakeLockHolder() {
    }

    @GuardedBy("WakeLockHolder.syncObject")
    private static void b(Context context) {
        if (f31764c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f31764c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@NonNull Intent intent) {
        synchronized (f31763b) {
            if (f31764c != null && d(intent)) {
                g(intent, false);
                f31764c.release();
            }
        }
    }

    @VisibleForTesting
    static boolean d(@NonNull Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"TaskMainThread"})
    public static void f(Context context, WithinAppServiceConnection withinAppServiceConnection, final Intent intent) {
        synchronized (f31763b) {
            b(context);
            boolean d4 = d(intent);
            g(intent, true);
            if (!d4) {
                f31764c.acquire(f31762a);
            }
            withinAppServiceConnection.c(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.e0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WakeLockHolder.c(intent);
                }
            });
        }
    }

    private static void g(@NonNull Intent intent, boolean z3) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName h(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f31763b) {
            b(context);
            boolean d4 = d(intent);
            g(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!d4) {
                f31764c.acquire(f31762a);
            }
            return startService;
        }
    }
}
