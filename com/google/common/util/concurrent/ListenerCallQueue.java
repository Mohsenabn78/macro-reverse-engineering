package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes5.dex */
public final class ListenerCallQueue<L> {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f28530b = Logger.getLogger(ListenerCallQueue.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final List<PerListenerQueue<L>> f28531a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Event<L> {
        void call(L l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PerListenerQueue<L> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final L f28532a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f28533b;
        @GuardedBy("this")

        /* renamed from: c  reason: collision with root package name */
        final Queue<Event<L>> f28534c = Queues.newArrayDeque();
        @GuardedBy("this")

        /* renamed from: d  reason: collision with root package name */
        final Queue<Object> f28535d = Queues.newArrayDeque();
        @GuardedBy("this")

        /* renamed from: e  reason: collision with root package name */
        boolean f28536e;

        PerListenerQueue(L l4, Executor executor) {
            this.f28532a = (L) Preconditions.checkNotNull(l4);
            this.f28533b = (Executor) Preconditions.checkNotNull(executor);
        }

        synchronized void a(Event<L> event, Object obj) {
            this.f28534c.add(event);
            this.f28535d.add(obj);
        }

        void b() {
            boolean z3;
            synchronized (this) {
                if (!this.f28536e) {
                    z3 = true;
                    this.f28536e = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                try {
                    this.f28533b.execute(this);
                } catch (RuntimeException e4) {
                    synchronized (this) {
                        this.f28536e = false;
                        Logger logger = ListenerCallQueue.f28530b;
                        Level level = Level.SEVERE;
                        logger.log(level, "Exception while running callbacks for " + this.f28532a + " on " + this.f28533b, (Throwable) e4);
                        throw e4;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
            r2.call(r9.f28532a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            r4 = com.google.common.util.concurrent.ListenerCallQueue.f28530b;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing callback: " + r9.f28532a + com.fasterxml.jackson.core.util.MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L58
                boolean r2 = r9.f28536e     // Catch: java.lang.Throwable -> L4c
                com.google.common.base.Preconditions.checkState(r2)     // Catch: java.lang.Throwable -> L4c
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.f28534c     // Catch: java.lang.Throwable -> L4c
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L4c
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch: java.lang.Throwable -> L4c
                java.util.Queue<java.lang.Object> r3 = r9.f28535d     // Catch: java.lang.Throwable -> L4c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L4c
                if (r2 != 0) goto L1f
                r9.f28536e = r0     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = 0
                goto L4f
            L1f:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L4c
                L r4 = r9.f28532a     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L58
                r2.call(r4)     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L58
                goto L0
            L26:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.a()     // Catch: java.lang.Throwable -> L58
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L58
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
                r6.<init>()     // Catch: java.lang.Throwable -> L58
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L58
                L r7 = r9.f28532a     // Catch: java.lang.Throwable -> L58
                r6.append(r7)     // Catch: java.lang.Throwable -> L58
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L58
                r6.append(r3)     // Catch: java.lang.Throwable -> L58
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L58
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L58
                goto L0
            L4c:
                r2 = move-exception
                r1 = r2
                r2 = 1
            L4f:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L56
                throw r1     // Catch: java.lang.Throwable -> L51
            L51:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L59
            L56:
                r1 = move-exception
                goto L4f
            L58:
                r2 = move-exception
            L59:
                if (r1 == 0) goto L63
                monitor-enter(r9)
                r9.f28536e = r0     // Catch: java.lang.Throwable -> L60
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L60
                goto L63
            L60:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L60
                throw r0
            L63:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void e(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, Constants.ScionAnalytics.PARAM_LABEL);
        synchronized (this.f28531a) {
            for (PerListenerQueue<L> perListenerQueue : this.f28531a) {
                perListenerQueue.a(event, obj);
            }
        }
    }

    public void b(L l4, Executor executor) {
        Preconditions.checkNotNull(l4, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.f28531a.add(new PerListenerQueue<>(l4, executor));
    }

    public void c() {
        for (int i4 = 0; i4 < this.f28531a.size(); i4++) {
            this.f28531a.get(i4).b();
        }
    }

    public void d(Event<L> event) {
        e(event, event);
    }
}
