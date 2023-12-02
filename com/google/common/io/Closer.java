package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class Closer implements Closeable {

    /* renamed from: d  reason: collision with root package name */
    private static final Suppressor f27994d;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Suppressor f27995a;

    /* renamed from: b  reason: collision with root package name */
    private final Deque<Closeable> f27996b = new ArrayDeque(4);
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private Throwable f27997c;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static final class LoggingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        static final LoggingSuppressor f27998a = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.f27993a;
            Level level = Level.WARNING;
            logger.log(level, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static final class SuppressingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        private final Method f27999a;

        private SuppressingSuppressor(Method method) {
            this.f27999a = method;
        }

        @CheckForNull
        static SuppressingSuppressor b() {
            try {
                return new SuppressingSuppressor(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                this.f27999a.invoke(th, th2);
            } catch (Throwable unused) {
                LoggingSuppressor.f27998a.a(closeable, th, th2);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor b4 = SuppressingSuppressor.b();
        if (b4 == null) {
            b4 = LoggingSuppressor.f27998a;
        }
        f27994d = b4;
    }

    @VisibleForTesting
    Closer(Suppressor suppressor) {
        this.f27995a = (Suppressor) Preconditions.checkNotNull(suppressor);
    }

    public static Closer create() {
        return new Closer(f27994d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th = this.f27997c;
        while (!this.f27996b.isEmpty()) {
            Closeable removeFirst = this.f27996b.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f27995a.a(removeFirst, th, th2);
                }
            }
        }
        if (this.f27997c == null && th != null) {
            Throwables.propagateIfPossible(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <C extends Closeable> C register(@ParametricNullness C c4) {
        if (c4 != null) {
            this.f27996b.addFirst(c4);
        }
        return c4;
    }

    public RuntimeException rethrow(Throwable th) throws IOException {
        Preconditions.checkNotNull(th);
        this.f27997c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th, Class<X> cls) throws IOException, Exception {
        Preconditions.checkNotNull(th);
        this.f27997c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(th);
        this.f27997c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
