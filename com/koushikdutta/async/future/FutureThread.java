package com.koushikdutta.async.future;

import java.util.concurrent.ExecutorService;

/* loaded from: classes6.dex */
public class FutureThread<T> extends SimpleFuture<T> {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FutureRunnable f34871a;

        a(FutureRunnable futureRunnable) {
            this.f34871a = futureRunnable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                FutureThread.this.setComplete((FutureThread) this.f34871a.run());
            } catch (Exception e4) {
                FutureThread.this.setComplete(e4);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FutureRunnable f34873a;

        b(FutureRunnable futureRunnable) {
            this.f34873a = futureRunnable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                FutureThread.this.setComplete((FutureThread) this.f34873a.run());
            } catch (Exception e4) {
                FutureThread.this.setComplete(e4);
            }
        }
    }

    public FutureThread(FutureRunnable<T> futureRunnable) {
        this(futureRunnable, "FutureThread");
    }

    public FutureThread(ExecutorService executorService, FutureRunnable<T> futureRunnable) {
        executorService.submit(new a(futureRunnable));
    }

    public FutureThread(FutureRunnable<T> futureRunnable, String str) {
        new Thread(new b(futureRunnable), str).start();
    }
}
