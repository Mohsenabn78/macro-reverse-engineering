package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class TaskQueue {
    @GuardedBy("lock")

    /* renamed from: b  reason: collision with root package name */
    private boolean f32980b;

    /* renamed from: a  reason: collision with root package name */
    private final Object f32979a = new Object();
    @GuardedBy("lock")

    /* renamed from: c  reason: collision with root package name */
    private final Queue f32981c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference f32982d = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        synchronized (this.f32979a) {
            if (this.f32981c.isEmpty()) {
                this.f32980b = false;
                return;
            }
            zzv zzvVar = (zzv) this.f32981c.remove();
            d(zzvVar.f33049a, zzvVar.f33050b);
        }
    }

    private final void d(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzt
                @Override // java.lang.Runnable
                public final void run() {
                    TaskQueue taskQueue = TaskQueue.this;
                    Runnable runnable2 = runnable;
                    zzx zzxVar = new zzx(taskQueue, null);
                    try {
                        runnable2.run();
                        zzxVar.close();
                    } catch (Throwable th) {
                        try {
                            zzxVar.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            c();
        }
    }

    @KeepForSdk
    public void checkIsRunningOnCurrentThread() {
        Preconditions.checkState(Thread.currentThread().equals(this.f32982d.get()));
    }

    @KeepForSdk
    public void submit(@NonNull Executor executor, @NonNull Runnable runnable) {
        synchronized (this.f32979a) {
            if (this.f32980b) {
                this.f32981c.add(new zzv(executor, runnable, null));
                return;
            }
            this.f32980b = true;
            d(executor, runnable);
        }
    }
}
