package com.google.firebase.firestore;

import android.app.Activity;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.api.internal.ActivityLifecycleObserver;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class LoadBundleTask extends Task<LoadBundleTaskProgress> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f30194a = new Object();
    @GuardedBy("lock")

    /* renamed from: b  reason: collision with root package name */
    private LoadBundleTaskProgress f30195b = LoadBundleTaskProgress.f30201g;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<LoadBundleTaskProgress> f30196c;

    /* renamed from: d  reason: collision with root package name */
    private final Task<LoadBundleTaskProgress> f30197d;
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private final Queue<ManagedListener> f30198e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ManagedListener {

        /* renamed from: a  reason: collision with root package name */
        Executor f30199a;

        /* renamed from: b  reason: collision with root package name */
        OnProgressListener<LoadBundleTaskProgress> f30200b;

        ManagedListener(@Nullable Executor executor, OnProgressListener<LoadBundleTaskProgress> onProgressListener) {
            this.f30199a = executor == null ? TaskExecutors.MAIN_THREAD : executor;
            this.f30200b = onProgressListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(LoadBundleTaskProgress loadBundleTaskProgress) {
            this.f30200b.onProgress(loadBundleTaskProgress);
        }

        public void b(final LoadBundleTaskProgress loadBundleTaskProgress) {
            this.f30199a.execute(new Runnable() { // from class: com.google.firebase.firestore.n
                @Override // java.lang.Runnable
                public final void run() {
                    LoadBundleTask.ManagedListener.this.c(loadBundleTaskProgress);
                }
            });
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.f30200b.equals(((ManagedListener) obj).f30200b);
            }
            return false;
        }

        public int hashCode() {
            return this.f30200b.hashCode();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LoadBundleTask() {
        TaskCompletionSource<LoadBundleTaskProgress> taskCompletionSource = new TaskCompletionSource<>();
        this.f30196c = taskCompletionSource;
        this.f30197d = taskCompletionSource.getTask();
        this.f30198e = new ArrayDeque();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void b(@NonNull OnProgressListener<LoadBundleTaskProgress> onProgressListener) {
        synchronized (this.f30194a) {
            this.f30198e.remove(new ManagedListener(null, onProgressListener));
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        return this.f30197d.addOnCanceledListener(onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCompleteListener(@NonNull OnCompleteListener<LoadBundleTaskProgress> onCompleteListener) {
        return this.f30197d.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return this.f30197d.addOnFailureListener(onFailureListener);
    }

    @NonNull
    public LoadBundleTask addOnProgressListener(@NonNull OnProgressListener<LoadBundleTaskProgress> onProgressListener) {
        ManagedListener managedListener = new ManagedListener(null, onProgressListener);
        synchronized (this.f30194a) {
            this.f30198e.add(managedListener);
        }
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnSuccessListener(@NonNull OnSuccessListener<? super LoadBundleTaskProgress> onSuccessListener) {
        return this.f30197d.addOnSuccessListener(onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<LoadBundleTaskProgress, TContinuationResult> continuation) {
        return this.f30197d.continueWith(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<LoadBundleTaskProgress, Task<TContinuationResult>> continuation) {
        return this.f30197d.continueWithTask(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public Exception getException() {
        return this.f30197d.getException();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return this.f30197d.isCanceled();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return this.f30197d.isComplete();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return this.f30197d.isSuccessful();
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<LoadBundleTaskProgress, TContinuationResult> successContinuation) {
        return this.f30197d.onSuccessTask(successContinuation);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setException(@NonNull Exception exc) {
        synchronized (this.f30194a) {
            LoadBundleTaskProgress loadBundleTaskProgress = new LoadBundleTaskProgress(this.f30195b.getDocumentsLoaded(), this.f30195b.getTotalDocuments(), this.f30195b.getBytesLoaded(), this.f30195b.getTotalBytes(), exc, LoadBundleTaskProgress.TaskState.ERROR);
            this.f30195b = loadBundleTaskProgress;
            for (ManagedListener managedListener : this.f30198e) {
                managedListener.b(loadBundleTaskProgress);
            }
            this.f30198e.clear();
        }
        this.f30196c.setException(exc);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setResult(@NonNull LoadBundleTaskProgress loadBundleTaskProgress) {
        boolean equals = loadBundleTaskProgress.getTaskState().equals(LoadBundleTaskProgress.TaskState.SUCCESS);
        Assert.hardAssert(equals, "Expected success, but was " + loadBundleTaskProgress.getTaskState(), new Object[0]);
        synchronized (this.f30194a) {
            this.f30195b = loadBundleTaskProgress;
            for (ManagedListener managedListener : this.f30198e) {
                managedListener.b(this.f30195b);
            }
            this.f30198e.clear();
        }
        this.f30196c.setResult(loadBundleTaskProgress);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateProgress(@NonNull LoadBundleTaskProgress loadBundleTaskProgress) {
        synchronized (this.f30194a) {
            this.f30195b = loadBundleTaskProgress;
            for (ManagedListener managedListener : this.f30198e) {
                managedListener.b(loadBundleTaskProgress);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        return this.f30197d.addOnCanceledListener(executor, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<LoadBundleTaskProgress> onCompleteListener) {
        return this.f30197d.addOnCompleteListener(executor, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        return this.f30197d.addOnFailureListener(executor, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super LoadBundleTaskProgress> onSuccessListener) {
        return this.f30197d.addOnSuccessListener(executor, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<LoadBundleTaskProgress, TContinuationResult> continuation) {
        return this.f30197d.continueWith(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<LoadBundleTaskProgress, Task<TContinuationResult>> continuation) {
        return this.f30197d.continueWithTask(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull Executor executor, @NonNull SuccessContinuation<LoadBundleTaskProgress, TContinuationResult> successContinuation) {
        return this.f30197d.onSuccessTask(executor, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        return this.f30197d.addOnCanceledListener(activity, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<LoadBundleTaskProgress> onCompleteListener) {
        return this.f30197d.addOnCompleteListener(activity, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        return this.f30197d.addOnFailureListener(activity, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<LoadBundleTaskProgress> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super LoadBundleTaskProgress> onSuccessListener) {
        return this.f30197d.addOnSuccessListener(activity, onSuccessListener);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public LoadBundleTaskProgress getResult() {
        return this.f30197d.getResult();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <X extends Throwable> LoadBundleTaskProgress getResult(@NonNull Class<X> cls) throws Throwable {
        return this.f30197d.getResult(cls);
    }

    @NonNull
    public LoadBundleTask addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<LoadBundleTaskProgress> onProgressListener) {
        ManagedListener managedListener = new ManagedListener(executor, onProgressListener);
        synchronized (this.f30194a) {
            this.f30198e.add(managedListener);
        }
        return this;
    }

    @NonNull
    public LoadBundleTask addOnProgressListener(@NonNull Activity activity, @NonNull final OnProgressListener<LoadBundleTaskProgress> onProgressListener) {
        ManagedListener managedListener = new ManagedListener(null, onProgressListener);
        synchronized (this.f30194a) {
            this.f30198e.add(managedListener);
        }
        ActivityLifecycleObserver.of(activity).onStopCallOnce(new Runnable() { // from class: com.google.firebase.firestore.m
            @Override // java.lang.Runnable
            public final void run() {
                LoadBundleTask.this.b(onProgressListener);
            }
        });
        return this;
    }
}
