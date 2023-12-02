package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
class EventBus implements Subscriber, Publisher {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> f29212a = new HashMap();
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private Queue<Event<?>> f29213b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f29214c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventBus(Executor executor) {
        this.f29214c = executor;
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> c(Event<?> event) {
        Set<Map.Entry<EventHandler<Object>, Executor>> entrySet;
        ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.f29212a.get(event.getType());
        if (concurrentHashMap == null) {
            entrySet = Collections.emptySet();
        } else {
            entrySet = concurrentHashMap.entrySet();
        }
        return entrySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Map.Entry entry, Event event) {
        ((EventHandler) entry.getKey()).handle(event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Queue<Event<?>> queue;
        synchronized (this) {
            queue = this.f29213b;
            if (queue != null) {
                this.f29213b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event<?> event : queue) {
                publish(event);
            }
        }
    }

    @Override // com.google.firebase.events.Publisher
    public void publish(final Event<?> event) {
        Preconditions.checkNotNull(event);
        synchronized (this) {
            Queue<Event<?>> queue = this.f29213b;
            if (queue != null) {
                queue.add(event);
                return;
            }
            for (final Map.Entry<EventHandler<Object>, Executor> entry : c(event)) {
                entry.getValue().execute(new Runnable() { // from class: com.google.firebase.components.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        EventBus.d(entry, event);
                    }
                });
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        Preconditions.checkNotNull(executor);
        if (!this.f29212a.containsKey(cls)) {
            this.f29212a.put(cls, new ConcurrentHashMap<>());
        }
        this.f29212a.get(cls).put(eventHandler, executor);
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        if (!this.f29212a.containsKey(cls)) {
            return;
        }
        ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.f29212a.get(cls);
        concurrentHashMap.remove(eventHandler);
        if (concurrentHashMap.isEmpty()) {
            this.f29212a.remove(cls);
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        subscribe(cls, this.f29214c, eventHandler);
    }
}
