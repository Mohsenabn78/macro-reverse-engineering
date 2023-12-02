package com.google.firebase.storage;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.firebase.concurrent.FirebaseExecutors;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class StorageTaskScheduler {

    /* renamed from: a  reason: collision with root package name */
    private static Executor f32275a;

    /* renamed from: b  reason: collision with root package name */
    private static Executor f32276b;

    /* renamed from: c  reason: collision with root package name */
    private static Executor f32277c;

    /* renamed from: d  reason: collision with root package name */
    private static Executor f32278d;

    /* renamed from: e  reason: collision with root package name */
    private static Executor f32279e;
    public static StorageTaskScheduler sInstance = new StorageTaskScheduler();

    public static StorageTaskScheduler getInstance() {
        return sInstance;
    }

    public static void initializeExecutors(@NonNull Executor executor, @NonNull Executor executor2) {
        f32275a = FirebaseExecutors.newLimitedConcurrencyExecutor(executor, 5);
        f32277c = FirebaseExecutors.newLimitedConcurrencyExecutor(executor, 3);
        f32276b = FirebaseExecutors.newLimitedConcurrencyExecutor(executor, 2);
        f32278d = FirebaseExecutors.newSequentialExecutor(executor);
        f32279e = executor2;
    }

    public Executor getCommandPoolExecutor() {
        return f32275a;
    }

    public Executor getMainThreadExecutor() {
        return f32279e;
    }

    public void scheduleCallback(Runnable runnable) {
        f32278d.execute(runnable);
    }

    public void scheduleCommand(Runnable runnable) {
        f32275a.execute(runnable);
    }

    public void scheduleDownload(Runnable runnable) {
        f32277c.execute(runnable);
    }

    public void scheduleUpload(Runnable runnable) {
        f32276b.execute(runnable);
    }
}
