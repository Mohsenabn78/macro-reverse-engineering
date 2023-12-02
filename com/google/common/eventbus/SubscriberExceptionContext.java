package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class SubscriberExceptionContext {

    /* renamed from: a  reason: collision with root package name */
    private final EventBus f27655a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f27656b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f27657c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f27658d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.f27655a = (EventBus) Preconditions.checkNotNull(eventBus);
        this.f27656b = Preconditions.checkNotNull(obj);
        this.f27657c = Preconditions.checkNotNull(obj2);
        this.f27658d = (Method) Preconditions.checkNotNull(method);
    }

    public Object getEvent() {
        return this.f27656b;
    }

    public EventBus getEventBus() {
        return this.f27655a;
    }

    public Object getSubscriber() {
        return this.f27657c;
    }

    public Method getSubscriberMethod() {
        return this.f27658d;
    }
}
