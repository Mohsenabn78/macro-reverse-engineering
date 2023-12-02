package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class Subscriber {
    @Weak

    /* renamed from: a  reason: collision with root package name */
    private EventBus f27651a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Object f27652b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f27653c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f27654d;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static final class SynchronizedSubscriber extends Subscriber {
        @Override // com.google.common.eventbus.Subscriber
        void e(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.e(obj);
            }
        }

        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }
    }

    private SubscriberExceptionContext b(Object obj) {
        return new SubscriberExceptionContext(this.f27651a, obj, this.f27652b, this.f27653c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Subscriber c(EventBus eventBus, Object obj, Method method) {
        if (f(method)) {
            return new Subscriber(eventBus, obj, method);
        }
        return new SynchronizedSubscriber(eventBus, obj, method);
    }

    private static boolean f(Method method) {
        if (method.getAnnotation(AllowConcurrentEvents.class) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Object obj) {
        try {
            e(obj);
        } catch (InvocationTargetException e4) {
            this.f27651a.b(e4.getCause(), b(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(final Object obj) {
        this.f27654d.execute(new Runnable() { // from class: com.google.common.eventbus.a
            @Override // java.lang.Runnable
            public final void run() {
                Subscriber.this.g(obj);
            }
        });
    }

    @VisibleForTesting
    void e(Object obj) throws InvocationTargetException {
        try {
            this.f27653c.invoke(this.f27652b, Preconditions.checkNotNull(obj));
        } catch (IllegalAccessException e4) {
            throw new Error("Method became inaccessible: " + obj, e4);
        } catch (IllegalArgumentException e5) {
            throw new Error("Method rejected target/argument: " + obj, e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof Error) {
                throw ((Error) e6.getCause());
            }
            throw e6;
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        if (this.f27652b != subscriber.f27652b || !this.f27653c.equals(subscriber.f27653c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f27653c.hashCode() + 31) * 31) + System.identityHashCode(this.f27652b);
    }

    private Subscriber(EventBus eventBus, Object obj, Method method) {
        this.f27651a = eventBus;
        this.f27652b = Preconditions.checkNotNull(obj);
        this.f27653c = method;
        method.setAccessible(true);
        this.f27654d = eventBus.a();
    }
}
