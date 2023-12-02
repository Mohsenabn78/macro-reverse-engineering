package com.google.common.util.concurrent;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
/* loaded from: classes5.dex */
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* renamed from: d  reason: collision with root package name */
    static final boolean f28281d;

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f28282e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicHelper f28283f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f28284g;
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f28285a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private volatile Listener f28286b;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private volatile Waiter f28287c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2);

        abstract boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2);

        abstract boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2);

        abstract Listener d(AbstractFuture<?> abstractFuture, Listener listener);

        abstract Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter);

        abstract void f(Waiter waiter, @CheckForNull Waiter waiter2);

        abstract void g(Waiter waiter, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Cancellation {
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f28288c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f28289d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f28290a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        final Throwable f28291b;

        static {
            if (AbstractFuture.f28281d) {
                f28289d = null;
                f28288c = null;
                return;
            }
            f28289d = new Cancellation(false, null);
            f28288c = new Cancellation(true, null);
        }

        Cancellation(boolean z3, @CheckForNull Throwable th) {
            this.f28290a = z3;
            this.f28291b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f28292b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f28293a;

        Failure(Throwable th) {
            this.f28293a = (Throwable) Preconditions.checkNotNull(th);
        }
    }

    /* loaded from: classes5.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f28298a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f28299b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f28300c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f28301d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f28302e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f28298a = atomicReferenceFieldUpdater;
            this.f28299b = atomicReferenceFieldUpdater2;
            this.f28300c = atomicReferenceFieldUpdater3;
            this.f28301d = atomicReferenceFieldUpdater4;
            this.f28302e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return androidx.concurrent.futures.a.a(this.f28301d, abstractFuture, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f28302e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return androidx.concurrent.futures.a.a(this.f28300c, abstractFuture, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            return this.f28301d.getAndSet(abstractFuture, listener);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            return this.f28300c.getAndSet(abstractFuture, waiter);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            this.f28299b.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            this.f28298a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final AbstractFuture<V> f28303a;

        /* renamed from: b  reason: collision with root package name */
        final ListenableFuture<? extends V> f28304b;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f28303a = abstractFuture;
            this.f28304b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.f28303a).f28285a == this) {
                if (AbstractFuture.f28283f.b(this.f28303a, this, AbstractFuture.u(this.f28304b))) {
                    AbstractFuture.r(this.f28303a, false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f28286b == listener) {
                    ((AbstractFuture) abstractFuture).f28286b = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f28285a == obj) {
                    ((AbstractFuture) abstractFuture).f28285a = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f28287c == waiter) {
                    ((AbstractFuture) abstractFuture).f28287c = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            Listener listener2;
            synchronized (abstractFuture) {
                listener2 = ((AbstractFuture) abstractFuture).f28286b;
                if (listener2 != listener) {
                    ((AbstractFuture) abstractFuture).f28286b = listener;
                }
            }
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            Waiter waiter2;
            synchronized (abstractFuture) {
                waiter2 = ((AbstractFuture) abstractFuture).f28287c;
                if (waiter2 != waiter) {
                    ((AbstractFuture) abstractFuture).f28287c = waiter;
                }
            }
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            waiter.f28313b = waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            waiter.f28312a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Trusted<V> extends ListenableFuture<V> {
    }

    /* loaded from: classes5.dex */
    static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public boolean cancel(boolean z3) {
            return super.cancel(z3);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @ParametricNullness
        public V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get(long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j4, timeUnit);
        }
    }

    /* loaded from: classes5.dex */
    private static final class UnsafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        static final Unsafe f28305a;

        /* renamed from: b  reason: collision with root package name */
        static final long f28306b;

        /* renamed from: c  reason: collision with root package name */
        static final long f28307c;

        /* renamed from: d  reason: collision with root package name */
        static final long f28308d;

        /* renamed from: e  reason: collision with root package name */
        static final long f28309e;

        /* renamed from: f  reason: collision with root package name */
        static final long f28310f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.1
                        @Override // java.security.PrivilegedExceptionAction
                        /* renamed from: a */
                        public Unsafe run() throws Exception {
                            Field[] declaredFields;
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    f28307c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT));
                    f28306b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("b"));
                    f28308d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("a"));
                    f28309e = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("a"));
                    f28310f = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("b"));
                    f28305a = unsafe;
                } catch (NoSuchFieldException e4) {
                    throw new RuntimeException(e4);
                } catch (RuntimeException e5) {
                    throw e5;
                }
            } catch (PrivilegedActionException e6) {
                throw new RuntimeException("Could not initialize intrinsics", e6.getCause());
            }
        }

        private UnsafeAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return com.google.android.gms.internal.ads.r.a(f28305a, abstractFuture, f28306b, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return com.google.android.gms.internal.ads.r.a(f28305a, abstractFuture, f28308d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return com.google.android.gms.internal.ads.r.a(f28305a, abstractFuture, f28307c, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            Listener listener2;
            do {
                listener2 = ((AbstractFuture) abstractFuture).f28286b;
                if (listener == listener2) {
                    return listener2;
                }
            } while (!a(abstractFuture, listener2, listener));
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            Waiter waiter2;
            do {
                waiter2 = ((AbstractFuture) abstractFuture).f28287c;
                if (waiter == waiter2) {
                    return waiter2;
                }
            } while (!c(abstractFuture, waiter2, waiter));
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            f28305a.putObject(waiter, f28310f, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void g(Waiter waiter, Thread thread) {
            f28305a.putObject(waiter, f28309e, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f28311c = new Waiter(false);
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f28312a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f28313b;

        Waiter() {
            AbstractFuture.f28283f.g(this, Thread.currentThread());
        }

        Waiter(boolean z3) {
        }

        void a(@CheckForNull Waiter waiter) {
            AbstractFuture.f28283f.f(this, waiter);
        }

        void b() {
            Thread thread = this.f28312a;
            if (thread != null) {
                this.f28312a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        boolean z3;
        AtomicHelper synchronizedHelper;
        try {
            z3 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z3 = false;
        }
        f28281d = z3;
        f28282e = Logger.getLogger(AbstractFuture.class.getName());
        Throwable th = null;
        try {
            synchronizedHelper = new UnsafeAtomicHelper();
            e = null;
        } catch (Error | RuntimeException e4) {
            e = e4;
            try {
                synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            } catch (Error | RuntimeException e5) {
                synchronizedHelper = new SynchronizedHelper();
                th = e5;
            }
        }
        f28283f = synchronizedHelper;
        if (th != null) {
            Logger logger = f28282e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", e);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        f28284g = new Object();
    }

    private void A(Waiter waiter) {
        waiter.f28312a = null;
        while (true) {
            Waiter waiter2 = this.f28287c;
            if (waiter2 == Waiter.f28311c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f28313b;
                if (waiter2.f28312a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f28313b = waiter4;
                    if (waiter3.f28312a == null) {
                        break;
                    }
                } else if (!f28283f.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private void k(StringBuilder sb) {
        try {
            Object v3 = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, v3);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e5) {
            sb.append("FAILURE, cause=[");
            sb.append(e5.getCause());
            sb.append("]");
        }
    }

    private void l(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f28285a;
        if (obj instanceof SetFuture) {
            sb.append(", setFuture=[");
            o(sb, ((SetFuture) obj).f28304b);
            sb.append("]");
        } else {
            try {
                str = Strings.emptyToNull(y());
            } catch (RuntimeException | StackOverflowError e4) {
                str = "Exception thrown from implementation: " + e4.getClass();
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    private void n(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void o(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e4) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e4.getClass());
        }
    }

    private static CancellationException p(String str, @CheckForNull Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @CheckForNull
    private Listener q(@CheckForNull Listener listener) {
        Listener listener2 = listener;
        Listener d4 = f28283f.d(this, Listener.f28294d);
        while (d4 != null) {
            Listener listener3 = d4.f28297c;
            d4.f28297c = listener2;
            listener2 = d4;
            d4 = listener3;
        }
        return listener2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.util.concurrent.AbstractFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    public static void r(AbstractFuture<?> abstractFuture, boolean z3) {
        Listener listener = null;
        while (true) {
            abstractFuture.z();
            if (z3) {
                abstractFuture.w();
                z3 = false;
            }
            abstractFuture.m();
            Listener q4 = abstractFuture.q(listener);
            while (q4 != null) {
                listener = q4.f28297c;
                Runnable runnable = q4.f28295a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable2;
                    abstractFuture = setFuture.f28303a;
                    if (((AbstractFuture) abstractFuture).f28285a == setFuture) {
                        if (f28283f.b(abstractFuture, setFuture, u(setFuture.f28304b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = q4.f28296b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                q4 = listener;
            }
            return;
        }
    }

    private static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            Logger logger = f28282e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    private V t(Object obj) throws ExecutionException {
        if (!(obj instanceof Cancellation)) {
            if (!(obj instanceof Failure)) {
                if (obj == f28284g) {
                    return (V) NullnessCasts.b();
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f28293a);
        }
        throw p("Task was cancelled.", ((Cancellation) obj).f28291b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object u(ListenableFuture<?> listenableFuture) {
        Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).f28285a;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.f28290a) {
                    obj = cancellation.f28291b != null ? new Cancellation(false, cancellation.f28291b) : Cancellation.f28289d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(tryInternalFastPathGetFailure);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!f28281d) & isCancelled) {
                Cancellation cancellation2 = Cancellation.f28289d;
                Objects.requireNonNull(cancellation2);
                return cancellation2;
            }
            try {
                Object v3 = v(listenableFuture);
                if (isCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
                } else if (v3 == null) {
                    return f28284g;
                } else {
                    return v3;
                }
            } catch (Error e4) {
                e = e4;
                return new Failure(e);
            } catch (CancellationException e5) {
                if (!isCancelled) {
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e5));
                }
                return new Cancellation(false, e5);
            } catch (RuntimeException e6) {
                e = e6;
                return new Failure(e);
            } catch (ExecutionException e7) {
                if (isCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e7));
                }
                return new Failure(e7.getCause());
            }
        }
    }

    @ParametricNullness
    private static <V> V v(Future<V> future) throws ExecutionException {
        V v3;
        boolean z3 = false;
        while (true) {
            try {
                v3 = future.get();
                break;
            } catch (InterruptedException unused) {
                z3 = true;
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return v3;
    }

    private void z() {
        for (Waiter e4 = f28283f.e(this, Waiter.f28311c); e4 != null; e4 = e4.f28313b) {
            e4.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean B() {
        Object obj = this.f28285a;
        if ((obj instanceof Cancellation) && ((Cancellation) obj).f28290a) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @CheckForNull
    public final Throwable a() {
        if (this instanceof Trusted) {
            Object obj = this.f28285a;
            if (obj instanceof Failure) {
                return ((Failure) obj).f28293a;
            }
            return null;
        }
        return null;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (listener = this.f28286b) != Listener.f28294d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f28297c = listener;
                if (f28283f.a(this, listener, listener2)) {
                    return;
                }
                listener = this.f28286b;
            } while (listener != Listener.f28294d);
            s(runnable, executor);
        }
        s(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z3) {
        boolean z4;
        Cancellation cancellation;
        boolean z5;
        Object obj = this.f28285a;
        if (obj == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 | (obj instanceof SetFuture)) {
            if (f28281d) {
                cancellation = new Cancellation(z3, new CancellationException("Future.cancel() was called."));
            } else {
                if (z3) {
                    cancellation = Cancellation.f28288c;
                } else {
                    cancellation = Cancellation.f28289d;
                }
                Objects.requireNonNull(cancellation);
            }
            boolean z6 = false;
            AbstractFuture<V> abstractFuture = this;
            while (true) {
                if (f28283f.b(abstractFuture, obj, cancellation)) {
                    r(abstractFuture, z3);
                    if (!(obj instanceof SetFuture)) {
                        return true;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).f28304b;
                    if (listenableFuture instanceof Trusted) {
                        abstractFuture = (AbstractFuture) listenableFuture;
                        obj = abstractFuture.f28285a;
                        if (obj == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!(z5 | (obj instanceof SetFuture))) {
                            return true;
                        }
                        z6 = true;
                    } else {
                        listenableFuture.cancel(z3);
                        return true;
                    }
                } else {
                    obj = abstractFuture.f28285a;
                    if (!(obj instanceof SetFuture)) {
                        return z6;
                    }
                }
            }
        } else {
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j4, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j4);
        if (!Thread.interrupted()) {
            Object obj = this.f28285a;
            if ((obj != null) & (!(obj instanceof SetFuture))) {
                return t(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                Waiter waiter = this.f28287c;
                if (waiter != Waiter.f28311c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f28283f.c(this, waiter, waiter2)) {
                            do {
                                OverflowAvoidingLockSupport.a(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f28285a;
                                    if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                        return t(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    A(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            A(waiter2);
                        } else {
                            waiter = this.f28287c;
                        }
                    } while (waiter != Waiter.f28311c);
                    Object obj3 = this.f28285a;
                    Objects.requireNonNull(obj3);
                    return t(obj3);
                }
                Object obj32 = this.f28285a;
                Objects.requireNonNull(obj32);
                return t(obj32);
            }
            while (nanos > 0) {
                Object obj4 = this.f28285a;
                if ((obj4 != null) & (!(obj4 instanceof SetFuture))) {
                    return t(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j5 = -nanos;
                long convert = timeUnit.convert(j5, TimeUnit.NANOSECONDS);
                long nanos2 = j5 - timeUnit.toNanos(convert);
                int i4 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z3 = i4 == 0 || nanos2 > 1000;
                if (i4 > 0) {
                    String str3 = str2 + convert + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + lowerCase;
                    if (z3) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                }
                if (z3) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f28285a instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z3;
        Object obj = this.f28285a;
        if (obj != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        return (!(obj instanceof SetFuture)) & z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean set(@ParametricNullness V v3) {
        if (v3 == null) {
            v3 = (V) f28284g;
        }
        if (!f28283f.b(this, null, v3)) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (!f28283f.b(this, null, new Failure((Throwable) Preconditions.checkNotNull(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.f28285a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f28283f.b(this, null, u(listenableFuture))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (f28283f.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Error | RuntimeException e4) {
                    try {
                        failure = new Failure(e4);
                    } catch (Error | RuntimeException unused) {
                        failure = Failure.f28292b;
                    }
                    f28283f.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f28285a;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f28290a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(@CheckForNull Future<?> future) {
        boolean z3;
        if (future != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 & isCancelled()) {
            future.cancel(B());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f28294d = new Listener();
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        final Runnable f28295a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        final Executor f28296b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Listener f28297c;

        Listener(Runnable runnable, Executor executor) {
            this.f28295a = runnable;
            this.f28296b = executor;
        }

        Listener() {
            this.f28295a = null;
            this.f28296b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ForOverride
    public void m() {
    }

    protected void w() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f28285a;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return t(obj2);
            }
            Waiter waiter = this.f28287c;
            if (waiter != Waiter.f28311c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f28283f.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f28285a;
                            } else {
                                A(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return t(obj);
                    }
                    waiter = this.f28287c;
                } while (waiter != Waiter.f28311c);
                Object obj3 = this.f28285a;
                Objects.requireNonNull(obj3);
                return t(obj3);
            }
            Object obj32 = this.f28285a;
            Objects.requireNonNull(obj32);
            return t(obj32);
        }
        throw new InterruptedException();
    }
}
