package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
/* loaded from: classes5.dex */
public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final Runnable f28521a = new DoNothingRunnable();

    /* renamed from: b  reason: collision with root package name */
    private static final Runnable f28522b = new DoNothingRunnable();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        public String toString() {
            return this.task.toString();
        }

        private Blocker(InterruptibleTask<?> interruptibleTask) {
            this.task = interruptibleTask;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private void h(Thread thread) {
        Runnable runnable = get();
        Blocker blocker = null;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            boolean z4 = runnable instanceof Blocker;
            if (!z4 && runnable != f28522b) {
                break;
            }
            if (z4) {
                blocker = (Blocker) runnable;
            }
            i4++;
            if (i4 > 1000) {
                Runnable runnable2 = f28522b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    if (!Thread.interrupted() && !z3) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z3) {
            thread.interrupt();
        }
    }

    abstract void a(Throwable th);

    abstract void b(@ParametricNullness T t3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.b(Thread.currentThread());
            if (compareAndSet(runnable, blocker)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(f28521a) == f28522b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    abstract boolean e();

    @ParametricNullness
    abstract T f() throws Exception;

    abstract String g();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (!compareAndSet(null, currentThread)) {
            return;
        }
        boolean z3 = !e();
        if (z3) {
            try {
                obj = f();
            } catch (Throwable th) {
                try {
                    Platform.b(th);
                    if (!compareAndSet(currentThread, f28521a)) {
                        h(currentThread);
                    }
                    if (z3) {
                        a(th);
                        return;
                    }
                    return;
                } finally {
                    if (!compareAndSet(currentThread, f28521a)) {
                        h(currentThread);
                    }
                    if (z3) {
                        b(NullnessCasts.a(null));
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f28521a) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + g();
    }

    /* loaded from: classes5.dex */
    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
