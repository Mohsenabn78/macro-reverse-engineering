package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Dispatcher {

    /* loaded from: classes5.dex */
    private static final class ImmediateDispatcher extends Dispatcher {

        /* renamed from: a  reason: collision with root package name */
        private static final ImmediateDispatcher f27636a = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void a(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().d(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class LegacyAsyncDispatcher extends Dispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final ConcurrentLinkedQueue<EventWithSubscriber> f27637a;

        /* loaded from: classes5.dex */
        private static final class EventWithSubscriber {

            /* renamed from: a  reason: collision with root package name */
            private final Object f27638a;

            /* renamed from: b  reason: collision with root package name */
            private final Subscriber f27639b;

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.f27638a = obj;
                this.f27639b = subscriber;
            }
        }

        private LegacyAsyncDispatcher() {
            this.f27637a = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void a(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.f27637a.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.f27637a.poll();
                if (poll != null) {
                    poll.f27639b.d(poll.f27638a);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PerThreadQueuedDispatcher extends Dispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<Queue<Event>> f27640a;

        /* renamed from: b  reason: collision with root package name */
        private final ThreadLocal<Boolean> f27641b;

        /* loaded from: classes5.dex */
        private static final class Event {

            /* renamed from: a  reason: collision with root package name */
            private final Object f27642a;

            /* renamed from: b  reason: collision with root package name */
            private final Iterator<Subscriber> f27643b;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.f27642a = obj;
                this.f27643b = it;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.f27640a = new ThreadLocal<Queue<Event>>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                /* renamed from: a */
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.f27641b = new ThreadLocal<Boolean>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                /* renamed from: a */
                public Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0034 A[Catch: all -> 0x005b, LOOP:1: B:7:0x0034->B:9:0x003e, LOOP_START, TryCatch #0 {all -> 0x005b, blocks: (B:5:0x002c, B:7:0x0034, B:9:0x003e), top: B:16:0x002c }] */
        @Override // com.google.common.eventbus.Dispatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(java.lang.Object r4, java.util.Iterator<com.google.common.eventbus.Subscriber> r5) {
            /*
                r3 = this;
                com.google.common.base.Preconditions.checkNotNull(r4)
                com.google.common.base.Preconditions.checkNotNull(r5)
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r3.f27640a
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = 0
                r1.<init>(r4, r5)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f27641b
                java.lang.Object r4 = r4.get()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L67
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f27641b
                java.lang.Boolean r5 = java.lang.Boolean.TRUE
                r4.set(r5)
            L2c:
                java.lang.Object r4 = r0.poll()     // Catch: java.lang.Throwable -> L5b
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r4 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r4     // Catch: java.lang.Throwable -> L5b
                if (r4 == 0) goto L50
            L34:
                java.util.Iterator r5 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.a(r4)     // Catch: java.lang.Throwable -> L5b
                boolean r5 = r5.hasNext()     // Catch: java.lang.Throwable -> L5b
                if (r5 == 0) goto L2c
                java.util.Iterator r5 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.a(r4)     // Catch: java.lang.Throwable -> L5b
                java.lang.Object r5 = r5.next()     // Catch: java.lang.Throwable -> L5b
                com.google.common.eventbus.Subscriber r5 = (com.google.common.eventbus.Subscriber) r5     // Catch: java.lang.Throwable -> L5b
                java.lang.Object r1 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.b(r4)     // Catch: java.lang.Throwable -> L5b
                r5.d(r1)     // Catch: java.lang.Throwable -> L5b
                goto L34
            L50:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f27641b
                r4.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r4 = r3.f27640a
                r4.remove()
                goto L67
            L5b:
                r4 = move-exception
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r3.f27641b
                r5.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r5 = r3.f27640a
                r5.remove()
                throw r4
            L67:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.a(java.lang.Object, java.util.Iterator):void");
        }
    }

    Dispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher b() {
        return new LegacyAsyncDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher c() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, Iterator<Subscriber> it);
}
