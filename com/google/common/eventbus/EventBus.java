package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class EventBus {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f27644f = Logger.getLogger(EventBus.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final String f27645a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f27646b;

    /* renamed from: c  reason: collision with root package name */
    private final SubscriberExceptionHandler f27647c;

    /* renamed from: d  reason: collision with root package name */
    private final SubscriberRegistry f27648d;

    /* renamed from: e  reason: collision with root package name */
    private final Dispatcher f27649e;

    /* loaded from: classes5.dex */
    static final class LoggingHandler implements SubscriberExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        static final LoggingHandler f27650a = new LoggingHandler();

        LoggingHandler() {
        }

        private static Logger a(SubscriberExceptionContext subscriberExceptionContext) {
            return Logger.getLogger(EventBus.class.getName() + "." + subscriberExceptionContext.getEventBus().identifier());
        }

        private static String b(SubscriberExceptionContext subscriberExceptionContext) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            return "Exception thrown by subscriber method " + subscriberMethod.getName() + '(' + subscriberMethod.getParameterTypes()[0].getName() + ") on subscriber " + subscriberExceptionContext.getSubscriber() + " when dispatching event: " + subscriberExceptionContext.getEvent();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger a4 = a(subscriberExceptionContext);
            Level level = Level.SEVERE;
            if (a4.isLoggable(level)) {
                a4.log(level, b(subscriberExceptionContext), th);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Executor a() {
        return this.f27646b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(th);
        Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.f27647c.handleException(th, subscriberExceptionContext);
        } catch (Throwable th2) {
            f27644f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    public final String identifier() {
        return this.f27645a;
    }

    public void post(Object obj) {
        Iterator<Subscriber> f4 = this.f27648d.f(obj);
        if (f4.hasNext()) {
            this.f27649e.a(obj, f4);
        } else if (!(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
    }

    public void register(Object obj) {
        this.f27648d.g(obj);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.f27645a).toString();
    }

    public void unregister(Object obj) {
        this.f27648d.h(obj);
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), Dispatcher.c(), LoggingHandler.f27650a);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), Dispatcher.c(), subscriberExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventBus(String str, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.f27648d = new SubscriberRegistry(this);
        this.f27645a = (String) Preconditions.checkNotNull(str);
        this.f27646b = (Executor) Preconditions.checkNotNull(executor);
        this.f27649e = (Dispatcher) Preconditions.checkNotNull(dispatcher);
        this.f27647c = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }
}
