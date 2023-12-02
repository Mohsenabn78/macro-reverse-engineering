package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class ExecutionList {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f28477c = Logger.getLogger(ExecutionList.class.getName());
    @CheckForNull
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private RunnableExecutorPair f28478a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private boolean f28479b;

    /* loaded from: classes5.dex */
    private static final class RunnableExecutorPair {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f28480a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f28481b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        RunnableExecutorPair f28482c;

        RunnableExecutorPair(Runnable runnable, Executor executor, @CheckForNull RunnableExecutorPair runnableExecutorPair) {
            this.f28480a = runnable;
            this.f28481b = executor;
            this.f28482c = runnableExecutorPair;
        }
    }

    private static void a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            Logger logger = f28477c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f28479b) {
                this.f28478a = new RunnableExecutorPair(runnable, executor, this.f28478a);
            } else {
                a(runnable, executor);
            }
        }
    }

    public void execute() {
        synchronized (this) {
            if (this.f28479b) {
                return;
            }
            this.f28479b = true;
            RunnableExecutorPair runnableExecutorPair = this.f28478a;
            RunnableExecutorPair runnableExecutorPair2 = null;
            this.f28478a = null;
            while (runnableExecutorPair != null) {
                RunnableExecutorPair runnableExecutorPair3 = runnableExecutorPair.f28482c;
                runnableExecutorPair.f28482c = runnableExecutorPair2;
                runnableExecutorPair2 = runnableExecutorPair;
                runnableExecutorPair = runnableExecutorPair3;
            }
            while (runnableExecutorPair2 != null) {
                a(runnableExecutorPair2.f28480a, runnableExecutorPair2.f28481b);
                runnableExecutorPair2 = runnableExecutorPair2.f28482c;
            }
        }
    }
}
