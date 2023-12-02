package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class UncaughtExceptionHandlers {

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static final class Exiter implements Thread.UncaughtExceptionHandler {

        /* renamed from: b  reason: collision with root package name */
        private static final Logger f28646b = Logger.getLogger(Exiter.class.getName());

        /* renamed from: a  reason: collision with root package name */
        private final Runtime f28647a;

        Exiter(Runtime runtime) {
            this.f28647a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                try {
                    f28646b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
                } catch (Error | RuntimeException e4) {
                    System.err.println(th.getMessage());
                    System.err.println(e4.getMessage());
                }
            } finally {
                this.f28647a.exit(1);
            }
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }
}
