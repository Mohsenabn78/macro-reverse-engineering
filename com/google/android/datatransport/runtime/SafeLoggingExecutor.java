package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class SafeLoggingExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f18676a;

    /* loaded from: classes.dex */
    static class SafeLoggingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f18677a;

        SafeLoggingRunnable(Runnable runnable) {
            this.f18677a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f18677a.run();
            } catch (Exception e4) {
                Logging.e("Executor", "Background execution failure.", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeLoggingExecutor(Executor executor) {
        this.f18676a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f18676a.execute(new SafeLoggingRunnable(runnable));
    }
}
