package com.google.firebase.storage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.TaskListenerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public abstract class StorageTask<ResultT extends ProvideError> extends ControllableTask<ResultT> {

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<Integer, HashSet<Integer>> f32259j;

    /* renamed from: k  reason: collision with root package name */
    private static final HashMap<Integer, HashSet<Integer>> f32260k;

    /* renamed from: a  reason: collision with root package name */
    protected final Object f32261a = new Object();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final TaskListenerImpl<OnSuccessListener<? super ResultT>, ResultT> f32262b = new TaskListenerImpl<>(this, 128, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.h
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            StorageTask.this.v((OnSuccessListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final TaskListenerImpl<OnFailureListener, ResultT> f32263c = new TaskListenerImpl<>(this, 64, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.i
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            StorageTask.this.w((OnFailureListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final TaskListenerImpl<OnCompleteListener<ResultT>, ResultT> f32264d = new TaskListenerImpl<>(this, 448, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.j
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            StorageTask.this.x((OnCompleteListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final TaskListenerImpl<OnCanceledListener, ResultT> f32265e = new TaskListenerImpl<>(this, 256, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.k
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            StorageTask.this.y((OnCanceledListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    final TaskListenerImpl<OnProgressListener<? super ResultT>, ResultT> f32266f = new TaskListenerImpl<>(this, -465, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.l
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            ((OnProgressListener) obj).onProgress((StorageTask.ProvideError) obj2);
        }
    });
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final TaskListenerImpl<OnPausedListener<? super ResultT>, ResultT> f32267g = new TaskListenerImpl<>(this, 16, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.m
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void a(Object obj, Object obj2) {
            ((OnPausedListener) obj).onPaused((StorageTask.ProvideError) obj2);
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private volatile int f32268h = 1;

    /* renamed from: i  reason: collision with root package name */
    private ResultT f32269i;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public interface ProvideError {
        Exception getError();
    }

    /* loaded from: classes5.dex */
    public class SnapshotBase implements ProvideError {

        /* renamed from: a  reason: collision with root package name */
        private final Exception f32270a;

        public SnapshotBase(@Nullable Exception exc) {
            if (exc == null) {
                if (StorageTask.this.isCanceled()) {
                    this.f32270a = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
                    return;
                } else if (StorageTask.this.m() == 64) {
                    this.f32270a = StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR);
                    return;
                } else {
                    this.f32270a = null;
                    return;
                }
            }
            this.f32270a = exc;
        }

        @Override // com.google.firebase.storage.StorageTask.ProvideError
        @Nullable
        public Exception getError() {
            return this.f32270a;
        }

        @NonNull
        public StorageReference getStorage() {
            return getTask().q();
        }

        @NonNull
        public StorageTask<ResultT> getTask() {
            return StorageTask.this;
        }
    }

    static {
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        f32259j = hashMap;
        HashMap<Integer, HashSet<Integer>> hashMap2 = new HashMap<>();
        f32260k = hashMap2;
        hashMap.put(1, new HashSet<>(Arrays.asList(16, 256)));
        hashMap.put(2, new HashSet<>(Arrays.asList(8, 32)));
        hashMap.put(4, new HashSet<>(Arrays.asList(8, 32)));
        hashMap.put(16, new HashSet<>(Arrays.asList(2, 256)));
        hashMap.put(64, new HashSet<>(Arrays.asList(2, 256)));
        hashMap2.put(1, new HashSet<>(Arrays.asList(2, 64)));
        hashMap2.put(2, new HashSet<>(Arrays.asList(4, 64, 128)));
        hashMap2.put(4, new HashSet<>(Arrays.asList(4, 64, 128)));
        hashMap2.put(8, new HashSet<>(Arrays.asList(16, 64, 128)));
        hashMap2.put(32, new HashSet<>(Arrays.asList(256, 64, 128)));
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    private <ContinuationResultT> Task<ContinuationResultT> M(@Nullable Executor executor, @NonNull final SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f32262b.d(null, executor, new OnSuccessListener() { // from class: com.google.firebase.storage.n
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                StorageTask.z(SuccessContinuation.this, taskCompletionSource, cancellationTokenSource, (StorageTask.ProvideError) obj);
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    private <ContinuationResultT> Task<ContinuationResultT> i(@Nullable Executor executor, @NonNull final Continuation<ResultT, ContinuationResultT> continuation) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f32264d.d(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StorageTask.this.s(continuation, taskCompletionSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    private <ContinuationResultT> Task<ContinuationResultT> j(@Nullable Executor executor, @NonNull final Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f32264d.d(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StorageTask.this.t(continuation, taskCompletionSource, cancellationTokenSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    private void k() {
        if (!isComplete() && !isPaused() && m() != 2 && !N(256, false)) {
            N(64, false);
        }
    }

    private ResultT l() {
        ResultT resultt = this.f32269i;
        if (resultt != null) {
            return resultt;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.f32269i == null) {
            this.f32269i = K();
        }
        return this.f32269i;
    }

    private String o(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 16) {
                            if (i4 != 32) {
                                if (i4 != 64) {
                                    if (i4 != 128) {
                                        if (i4 != 256) {
                                            return "Unknown Internal State!";
                                        }
                                        return "INTERNAL_STATE_CANCELED";
                                    }
                                    return "INTERNAL_STATE_SUCCESS";
                                }
                                return "INTERNAL_STATE_FAILURE";
                            }
                            return "INTERNAL_STATE_CANCELING";
                        }
                        return "INTERNAL_STATE_PAUSED";
                    }
                    return "INTERNAL_STATE_PAUSING";
                }
                return "INTERNAL_STATE_IN_PROGRESS";
            }
            return "INTERNAL_STATE_QUEUED";
        }
        return "INTERNAL_STATE_NOT_STARTED";
    }

    private String p(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 : iArr) {
            sb.append(o(i4));
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        try {
            Object then = continuation.then(this);
            if (!taskCompletionSource.getTask().isComplete()) {
                taskCompletionSource.setResult(then);
            }
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        try {
            Task task2 = (Task) continuation.then(this);
            if (!taskCompletionSource.getTask().isComplete()) {
                if (task2 == null) {
                    taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                    return;
                }
                task2.addOnSuccessListener(new c(taskCompletionSource));
                task2.addOnFailureListener(new d(taskCompletionSource));
                Objects.requireNonNull(cancellationTokenSource);
                task2.addOnCanceledListener(new e(cancellationTokenSource));
            }
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        try {
            I();
        } finally {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(OnSuccessListener onSuccessListener, ProvideError provideError) {
        StorageTaskManager.c().e(this);
        onSuccessListener.onSuccess(provideError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(OnFailureListener onFailureListener, ProvideError provideError) {
        StorageTaskManager.c().e(this);
        onFailureListener.onFailure(provideError.getError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(OnCompleteListener onCompleteListener, ProvideError provideError) {
        StorageTaskManager.c().e(this);
        onCompleteListener.onComplete(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(OnCanceledListener onCanceledListener, ProvideError provideError) {
        StorageTaskManager.c().e(this);
        onCanceledListener.onCanceled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, ProvideError provideError) {
        try {
            Task then = successContinuation.then(provideError);
            Objects.requireNonNull(taskCompletionSource);
            then.addOnSuccessListener(new c(taskCompletionSource));
            then.addOnFailureListener(new d(taskCompletionSource));
            Objects.requireNonNull(cancellationTokenSource);
            then.addOnCanceledListener(new e(cancellationTokenSource));
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean G() {
        if (!N(2, false)) {
            return false;
        }
        J();
        return true;
    }

    @VisibleForTesting
    abstract void I();

    @VisibleForTesting
    abstract void J();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public ResultT K() {
        ResultT L;
        synchronized (this.f32261a) {
            L = L();
        }
        return L;
    }

    @NonNull
    @VisibleForTesting
    abstract ResultT L();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean N(int i4, boolean z3) {
        return O(new int[]{i4}, z3);
    }

    @VisibleForTesting
    boolean O(int[] iArr, boolean z3) {
        HashMap<Integer, HashSet<Integer>> hashMap;
        if (z3) {
            hashMap = f32259j;
        } else {
            hashMap = f32260k;
        }
        synchronized (this.f32261a) {
            for (int i4 : iArr) {
                HashSet<Integer> hashSet = hashMap.get(Integer.valueOf(m()));
                if (hashSet != null && hashSet.contains(Integer.valueOf(i4))) {
                    this.f32268h = i4;
                    int i5 = this.f32268h;
                    if (i5 != 2) {
                        if (i5 != 4) {
                            if (i5 != 16) {
                                if (i5 != 64) {
                                    if (i5 != 128) {
                                        if (i5 == 256) {
                                            A();
                                        }
                                    } else {
                                        F();
                                    }
                                } else {
                                    B();
                                }
                            } else {
                                C();
                            }
                        } else {
                            D();
                        }
                    } else {
                        StorageTaskManager.c().a(this);
                        E();
                    }
                    this.f32262b.h();
                    this.f32263c.h();
                    this.f32265e.h();
                    this.f32264d.h();
                    this.f32267g.h();
                    this.f32266f.h();
                    if (Log.isLoggable("StorageTask", 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("changed internal state to: ");
                        sb.append(o(i4));
                        sb.append(" isUser: ");
                        sb.append(z3);
                        sb.append(" from state:");
                        sb.append(o(this.f32268h));
                    }
                    return true;
                }
            }
            Log.w("StorageTask", "unable to change internal state to: " + p(iArr) + " isUser: " + z3 + " from state:" + o(this.f32268h));
            return false;
        }
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean cancel() {
        return O(new int[]{256, 32}, true);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(@NonNull Continuation<ResultT, ContinuationResultT> continuation) {
        return i(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(@NonNull Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return j(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public Exception getException() {
        if (l() == null) {
            return null;
        }
        return l().getError();
    }

    @NonNull
    public ResultT getSnapshot() {
        return K();
    }

    @Override // com.google.firebase.storage.CancellableTask, com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        if (m() == 256) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        if ((m() & 448) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean isInProgress() {
        if ((m() & (-465)) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isPaused() {
        if ((m() & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        if ((m() & 128) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public int m() {
        return this.f32268h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public Runnable n() {
        return new Runnable() { // from class: com.google.firebase.storage.f
            @Override // java.lang.Runnable
            public final void run() {
                StorageTask.this.u();
            }
        };
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(@NonNull SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return M(null, successContinuation);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean pause() {
        return O(new int[]{16, 8}, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract StorageReference q();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public Object r() {
        return this.f32261a;
    }

    @NonNull
    public StorageTask<ResultT> removeOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.f32265e.e(onCanceledListener);
        return this;
    }

    @NonNull
    public StorageTask<ResultT> removeOnCompleteListener(@NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.f32264d.e(onCompleteListener);
        return this;
    }

    @NonNull
    public StorageTask<ResultT> removeOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.f32263c.e(onFailureListener);
        return this;
    }

    @NonNull
    public StorageTask<ResultT> removeOnPausedListener(@NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.f32267g.e(onPausedListener);
        return this;
    }

    @NonNull
    public StorageTask<ResultT> removeOnProgressListener(@NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.f32266f.e(onProgressListener);
        return this;
    }

    @NonNull
    public StorageTask<ResultT> removeOnSuccessListener(@NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.f32262b.e(onSuccessListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean resume() {
        if (N(2, true)) {
            H();
            J();
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(@NonNull Executor executor, @NonNull Continuation<ResultT, ContinuationResultT> continuation) {
        return i(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(@NonNull Executor executor, @NonNull Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return j(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(@NonNull Executor executor, @NonNull SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return M(executor, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public ResultT getResult() {
        if (l() != null) {
            Exception error = l().getError();
            if (error == null) {
                return l();
            }
            throw new RuntimeExecutionException(error);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.f32265e.d(null, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.f32264d.d(null, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.f32263c.d(null, null, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    @NonNull
    public StorageTask<ResultT> addOnPausedListener(@NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.f32267g.d(null, null, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    @NonNull
    public StorageTask<ResultT> addOnProgressListener(@NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.f32266f.d(null, null, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.f32262b.d(null, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(executor);
        this.f32265e.d(null, executor, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(executor);
        this.f32264d.d(null, executor, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(executor);
        this.f32263c.d(null, executor, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    @NonNull
    public StorageTask<ResultT> addOnPausedListener(@NonNull Executor executor, @NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(executor);
        this.f32267g.d(null, executor, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    @NonNull
    public StorageTask<ResultT> addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(executor);
        this.f32266f.d(null, executor, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(onSuccessListener);
        this.f32262b.d(null, executor, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <X extends Throwable> ResultT getResult(@NonNull Class<X> cls) throws Throwable {
        if (l() != null) {
            if (!cls.isInstance(l().getError())) {
                Exception error = l().getError();
                if (error == null) {
                    return l();
                }
                throw new RuntimeExecutionException(error);
            }
            throw cls.cast(l().getError());
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(activity);
        this.f32265e.d(activity, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(activity);
        this.f32264d.d(activity, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(activity);
        this.f32263c.d(activity, null, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    @NonNull
    public StorageTask<ResultT> addOnPausedListener(@NonNull Activity activity, @NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(activity);
        this.f32267g.d(activity, null, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    @NonNull
    public StorageTask<ResultT> addOnProgressListener(@NonNull Activity activity, @NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(activity);
        this.f32266f.d(activity, null, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(onSuccessListener);
        this.f32262b.d(activity, null, onSuccessListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
    }

    protected void B() {
    }

    protected void C() {
    }

    protected void D() {
    }

    protected void E() {
    }

    protected void F() {
    }

    @VisibleForTesting
    void H() {
    }
}
