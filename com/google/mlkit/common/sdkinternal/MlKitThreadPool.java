package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzbe;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class MlKitThreadPool extends zzbe {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f32966b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f32967a;

    public MlKitThreadPool() {
        final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.google.mlkit.common.sdkinternal.zzj
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return defaultThreadFactory.newThread(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzi
                    @Override // java.lang.Runnable
                    public final void run() {
                        MlKitThreadPool.b(runnable);
                    }
                });
            }
        });
        this.f32967a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Runnable runnable) {
        f32966b.set(new ArrayDeque());
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Deque deque, Runnable runnable) {
        Preconditions.checkNotNull(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = (Runnable) deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbe, java.util.concurrent.Executor
    public final void execute(@NonNull final Runnable runnable) {
        Deque deque = (Deque) f32966b.get();
        if (deque != null && deque.size() <= 1) {
            c(deque, runnable);
        } else {
            this.f32967a.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzk
                @Override // java.lang.Runnable
                public final void run() {
                    MlKitThreadPool.c((Deque) MlKitThreadPool.f32966b.get(), runnable);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbe, com.google.android.gms.internal.mlkit_common.zzag
    @NonNull
    protected final /* synthetic */ Object zza() {
        return this.f32967a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbe
    @NonNull
    protected final ExecutorService zzb() {
        return this.f32967a;
    }
}
