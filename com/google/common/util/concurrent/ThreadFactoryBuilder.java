package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class ThreadFactoryBuilder {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private String f28631a = null;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private Boolean f28632b = null;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private Integer f28633c = null;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f28634d = null;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private ThreadFactory f28635e = null;

    private static ThreadFactory b(ThreadFactoryBuilder threadFactoryBuilder) {
        AtomicLong atomicLong;
        final String str = threadFactoryBuilder.f28631a;
        final Boolean bool = threadFactoryBuilder.f28632b;
        final Integer num = threadFactoryBuilder.f28633c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.f28634d;
        ThreadFactory threadFactory = threadFactoryBuilder.f28635e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory2 = threadFactory;
        if (str != null) {
            atomicLong = new AtomicLong(0L);
        } else {
            atomicLong = null;
        }
        final AtomicLong atomicLong2 = atomicLong;
        return new ThreadFactory() { // from class: com.google.common.util.concurrent.ThreadFactoryBuilder.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory2.newThread(runnable);
                Objects.requireNonNull(newThread);
                String str2 = str;
                if (str2 != null) {
                    AtomicLong atomicLong3 = atomicLong2;
                    Objects.requireNonNull(atomicLong3);
                    newThread.setName(ThreadFactoryBuilder.c(str2, Long.valueOf(atomicLong3.getAndIncrement())));
                }
                Boolean bool2 = bool;
                if (bool2 != null) {
                    newThread.setDaemon(bool2.booleanValue());
                }
                Integer num2 = num;
                if (num2 != null) {
                    newThread.setPriority(num2.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler2 != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                }
                return newThread;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory build() {
        return b(this);
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setDaemon(boolean z3) {
        this.f28632b = Boolean.valueOf(z3);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setNameFormat(String str) {
        c(str, 0);
        this.f28631a = str;
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setPriority(int i4) {
        boolean z3;
        boolean z4 = false;
        if (i4 >= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Thread priority (%s) must be >= %s", i4, 1);
        if (i4 <= 10) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "Thread priority (%s) must be <= %s", i4, 10);
        this.f28633c = Integer.valueOf(i4);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.f28635e = (ThreadFactory) Preconditions.checkNotNull(threadFactory);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f28634d = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
}
