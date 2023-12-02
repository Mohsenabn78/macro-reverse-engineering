package com.arlosoft.macrodroid.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Debouncer {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f16018a = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Object, Future<?>> f16019b = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f16020a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f16021b;

        a(Runnable runnable, Object obj) {
            this.f16020a = runnable;
            this.f16021b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f16020a.run();
            } finally {
                Debouncer.this.f16019b.remove(this.f16021b);
            }
        }
    }

    public void debounce(Object obj, Runnable runnable, long j4, TimeUnit timeUnit) {
        Future<?> put = this.f16019b.put(obj, this.f16018a.schedule(new a(runnable, obj), j4, timeUnit));
        if (put != null) {
            put.cancel(true);
        }
    }

    public void shutdown() {
        this.f16018a.shutdownNow();
    }
}
