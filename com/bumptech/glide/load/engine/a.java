package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveResources.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16824a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f16825b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<Key, c> f16826c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<l<?>> f16827d;

    /* renamed from: e  reason: collision with root package name */
    private l.a f16828e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f16829f;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class ThreadFactoryC0134a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0135a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f16830a;

            RunnableC0135a(Runnable runnable) {
                this.f16830a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f16830a.run();
            }
        }

        ThreadFactoryC0134a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0135a(runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class c extends WeakReference<l<?>> {

        /* renamed from: a  reason: collision with root package name */
        final Key f16833a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f16834b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f16835c;

        c(@NonNull Key key, @NonNull l<?> lVar, @NonNull ReferenceQueue<? super l<?>> referenceQueue, boolean z3) {
            super(lVar, referenceQueue);
            Resource<?> resource;
            this.f16833a = (Key) Preconditions.checkNotNull(key);
            if (lVar.c() && z3) {
                resource = (Resource) Preconditions.checkNotNull(lVar.b());
            } else {
                resource = null;
            }
            this.f16835c = resource;
            this.f16834b = lVar.c();
        }

        void a() {
            this.f16835c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z3) {
        this(z3, Executors.newSingleThreadExecutor(new ThreadFactoryC0134a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Key key, l<?> lVar) {
        c put = this.f16826c.put(key, new c(key, lVar, this.f16827d, this.f16824a));
        if (put != null) {
            put.a();
        }
    }

    void b() {
        while (!this.f16829f) {
            try {
                c((c) this.f16827d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(@NonNull c cVar) {
        Resource<?> resource;
        synchronized (this.f16828e) {
            synchronized (this) {
                this.f16826c.remove(cVar.f16833a);
                if (cVar.f16834b && (resource = cVar.f16835c) != null) {
                    l<?> lVar = new l<>(resource, true, false);
                    lVar.e(cVar.f16833a, this.f16828e);
                    this.f16828e.onResourceReleased(cVar.f16833a, lVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(Key key) {
        c remove = this.f16826c.remove(key);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public synchronized l<?> e(Key key) {
        c cVar = this.f16826c.get(key);
        if (cVar == null) {
            return null;
        }
        l<?> lVar = cVar.get();
        if (lVar == null) {
            c(cVar);
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(l.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f16828e = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public void g() {
        this.f16829f = true;
        Executor executor = this.f16825b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    a(boolean z3, Executor executor) {
        this.f16826c = new HashMap();
        this.f16827d = new ReferenceQueue<>();
        this.f16824a = z3;
        this.f16825b = executor;
        executor.execute(new b());
    }
}
