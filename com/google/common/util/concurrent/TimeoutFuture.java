package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes5.dex */
public final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    private ListenableFuture<V> f28642h;
    @CheckForNull

    /* renamed from: i  reason: collision with root package name */
    private ScheduledFuture<?> f28643i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Fire<V> implements Runnable {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        TimeoutFuture<V> f28644a;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.f28644a = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.f28644a;
            if (timeoutFuture == null || (listenableFuture = ((TimeoutFuture) timeoutFuture).f28642h) == null) {
                return;
            }
            this.f28644a = null;
            if (listenableFuture.isDone()) {
                timeoutFuture.setFuture(listenableFuture);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = ((TimeoutFuture) timeoutFuture).f28643i;
                ((TimeoutFuture) timeoutFuture).f28643i = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                timeoutFuture.setException(new TimeoutFutureException(str + ": " + listenableFuture));
            } finally {
                listenableFuture.cancel(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class TimeoutFutureException extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.f28642h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> ListenableFuture<V> F(ListenableFuture<V> listenableFuture, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.f28643i = scheduledExecutorService.schedule(fire, j4, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public void m() {
        x(this.f28642h);
        ScheduledFuture<?> scheduledFuture = this.f28643i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f28642h = null;
        this.f28643i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String y() {
        ListenableFuture<V> listenableFuture = this.f28642h;
        ScheduledFuture<?> scheduledFuture = this.f28643i;
        if (listenableFuture != null) {
            String str = "inputFuture=[" + listenableFuture + "]";
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    return str + ", remaining delay=[" + delay + " ms]";
                }
                return str;
            }
            return str;
        }
        return null;
    }
}
