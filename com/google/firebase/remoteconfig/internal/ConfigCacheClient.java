package com.google.firebase.remoteconfig.internal;

import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AnyThread
/* loaded from: classes5.dex */
public class ConfigCacheClient {
    @GuardedBy("ConfigCacheClient.class")

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, ConfigCacheClient> f31923d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f31924e = new androidx.biometric.auth.a();

    /* renamed from: a  reason: collision with root package name */
    private final Executor f31925a;

    /* renamed from: b  reason: collision with root package name */
    private final ConfigStorageClient f31926b;
    @Nullable
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private Task<ConfigContainer> f31927c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f31928a;

        private AwaitListener() {
            this.f31928a = new CountDownLatch(1);
        }

        public boolean a(long j4, TimeUnit timeUnit) throws InterruptedException {
            return this.f31928a.await(j4, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.f31928a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            this.f31928a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.f31928a.countDown();
        }
    }

    private ConfigCacheClient(Executor executor, ConfigStorageClient configStorageClient) {
        this.f31925a = executor;
        this.f31926b = configStorageClient;
    }

    private static <TResult> TResult c(Task<TResult> task, long j4, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = f31924e;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (awaitListener.a(j4, timeUnit)) {
            if (task.isSuccessful()) {
                return task.getResult();
            }
            throw new ExecutionException(task.getException());
        }
        throw new TimeoutException("Task await timed out.");
    }

    @VisibleForTesting
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            f31923d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void e(ConfigContainer configContainer) throws Exception {
        return this.f31926b.write(configContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task f(boolean z3, ConfigContainer configContainer, Void r32) throws Exception {
        if (z3) {
            g(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    private synchronized void g(ConfigContainer configContainer) {
        this.f31927c = Tasks.forResult(configContainer);
    }

    public static synchronized ConfigCacheClient getInstance(Executor executor, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String a4 = configStorageClient.a();
            Map<String, ConfigCacheClient> map = f31923d;
            if (!map.containsKey(a4)) {
                map.put(a4, new ConfigCacheClient(executor, configStorageClient));
            }
            configCacheClient = map.get(a4);
        }
        return configCacheClient;
    }

    public void clear() {
        synchronized (this) {
            this.f31927c = Tasks.forResult(null);
        }
        this.f31926b.clear();
    }

    @Nullable
    @VisibleForTesting
    ConfigContainer d(long j4) {
        synchronized (this) {
            Task<ConfigContainer> task = this.f31927c;
            if (task != null && task.isSuccessful()) {
                return this.f31927c.getResult();
            }
            try {
                return (ConfigContainer) c(get(), j4, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                return null;
            }
        }
    }

    public synchronized Task<ConfigContainer> get() {
        Task<ConfigContainer> task = this.f31927c;
        if (task == null || (task.isComplete() && !this.f31927c.isSuccessful())) {
            Executor executor = this.f31925a;
            final ConfigStorageClient configStorageClient = this.f31926b;
            Objects.requireNonNull(configStorageClient);
            this.f31927c = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConfigStorageClient.this.read();
                }
            });
        }
        return this.f31927c;
    }

    @Nullable
    public ConfigContainer getBlocking() {
        return d(5L);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    public Task<ConfigContainer> put(final ConfigContainer configContainer, final boolean z3) {
        return Tasks.call(this.f31925a, new Callable() { // from class: com.google.firebase.remoteconfig.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void e4;
                e4 = ConfigCacheClient.this.e(configContainer);
                return e4;
            }
        }).onSuccessTask(this.f31925a, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task f4;
                f4 = ConfigCacheClient.this.f(z3, configContainer, (Void) obj);
                return f4;
            }
        });
    }
}
