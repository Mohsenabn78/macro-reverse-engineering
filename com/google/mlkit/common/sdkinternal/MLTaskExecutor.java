package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class MLTaskExecutor {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f32960b = new Object();
    @Nullable
    @GuardedBy("lock")

    /* renamed from: c  reason: collision with root package name */
    private static MLTaskExecutor f32961c;

    /* renamed from: a  reason: collision with root package name */
    private Handler f32962a;

    private MLTaskExecutor(Looper looper) {
        this.f32962a = new com.google.android.gms.internal.mlkit_common.zza(looper);
    }

    @NonNull
    @KeepForSdk
    public static MLTaskExecutor getInstance() {
        MLTaskExecutor mLTaskExecutor;
        synchronized (f32960b) {
            if (f32961c == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                f32961c = new MLTaskExecutor(handlerThread.getLooper());
            }
            mLTaskExecutor = f32961c;
        }
        return mLTaskExecutor;
    }

    @NonNull
    @KeepForSdk
    public static Executor workerThreadExecutor() {
        return zzh.f33047a;
    }

    @NonNull
    @KeepForSdk
    public Handler getHandler() {
        return this.f32962a;
    }

    @NonNull
    @KeepForSdk
    public <ResultT> Task<ResultT> scheduleCallable(@NonNull final Callable<ResultT> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        scheduleRunnable(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzf
            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = callable;
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                try {
                    taskCompletionSource2.setResult(callable2.call());
                } catch (MlKitException e4) {
                    taskCompletionSource2.setException(e4);
                } catch (Exception e5) {
                    taskCompletionSource2.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e5));
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public void scheduleRunnable(@NonNull Runnable runnable) {
        workerThreadExecutor().execute(runnable);
    }

    @KeepForSdk
    public void scheduleRunnableDelayed(@NonNull Runnable runnable, long j4) {
        this.f32962a.postDelayed(runnable, j4);
    }

    @NonNull
    @KeepForSdk
    public <ResultT> Task<ResultT> scheduleTaskCallable(@NonNull Callable<Task<ResultT>> callable) {
        return (Task<ResultT>) scheduleCallable(callable).continueWithTask(zzbf.zza(), new Continuation() { // from class: com.google.mlkit.common.sdkinternal.zzg
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return (Task) task.getResult();
            }
        });
    }
}
