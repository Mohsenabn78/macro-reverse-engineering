package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TopicsSubscriber {

    /* renamed from: i  reason: collision with root package name */
    private static final long f31743i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f31744a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f31745b;

    /* renamed from: c  reason: collision with root package name */
    private final GmsRpc f31746c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f31747d;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f31749f;

    /* renamed from: h  reason: collision with root package name */
    private final TopicsStore f31751h;
    @GuardedBy("pendingOperations")

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f31748e = new ArrayMap();
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private boolean f31750g = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f31747d = firebaseMessaging;
        this.f31745b = metadata;
        this.f31751h = topicsStore;
        this.f31746c = gmsRpc;
        this.f31744a = context;
        this.f31749f = scheduledExecutorService;
    }

    private void b(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.f31748e) {
            String e4 = topicOperation.e();
            if (this.f31748e.containsKey(e4)) {
                arrayDeque = this.f31748e.get(e4);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.f31748e.put(e4, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    @WorkerThread
    private static <T> void c(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            e = e4;
            throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e);
        } catch (ExecutionException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e5);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e6) {
            e = e6;
            throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e);
        }
    }

    @WorkerThread
    private void d(String str) throws IOException {
        c(this.f31746c.l(this.f31747d.n(), str));
    }

    @WorkerThread
    private void e(String str) throws IOException {
        c(this.f31746c.m(this.f31747d.n(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Task<TopicsSubscriber> f(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc gmsRpc, final Context context, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsSubscriber j4;
                j4 = TopicsSubscriber.j(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc);
                return j4;
            }
        });
    }

    static boolean h() {
        if (!Log.isLoggable(Constants.TAG, 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable(Constants.TAG, 3))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.b(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void k(TopicOperation topicOperation) {
        synchronized (this.f31748e) {
            String e4 = topicOperation.e();
            if (!this.f31748e.containsKey(e4)) {
                return;
            }
            ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f31748e.get(e4);
            TaskCompletionSource<Void> poll = arrayDeque.poll();
            if (poll != null) {
                poll.setResult(null);
            }
            if (arrayDeque.isEmpty()) {
                this.f31748e.remove(e4);
            }
        }
    }

    private void p() {
        if (!i()) {
            t(0L);
        }
    }

    boolean g() {
        if (this.f31751h.c() != null) {
            return true;
        }
        return false;
    }

    synchronized boolean i() {
        return this.f31750g;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[Catch: IOException -> 0x008b, TryCatch #0 {IOException -> 0x008b, blocks: (B:3:0x0001, B:18:0x002e, B:20:0x0034, B:21:0x0047, B:23:0x0054, B:24:0x0069, B:26:0x0076, B:8:0x0013, B:11:0x001d), top: B:41:0x0001 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean l(com.google.firebase.messaging.TopicOperation r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.b()     // Catch: java.io.IOException -> L8b
            int r2 = r1.hashCode()     // Catch: java.io.IOException -> L8b
            r3 = 83
            r4 = 1
            if (r2 == r3) goto L1d
            r3 = 85
            if (r2 == r3) goto L13
            goto L27
        L13:
            java.lang.String r2 = "U"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L8b
            if (r1 == 0) goto L27
            r1 = 1
            goto L28
        L1d:
            java.lang.String r2 = "S"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L8b
            if (r1 == 0) goto L27
            r1 = 0
            goto L28
        L27:
            r1 = -1
        L28:
            java.lang.String r2 = " succeeded."
            if (r1 == 0) goto L69
            if (r1 == r4) goto L47
            boolean r1 = h()     // Catch: java.io.IOException -> L8b
            if (r1 == 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L8b
            r1.<init>()     // Catch: java.io.IOException -> L8b
            java.lang.String r2 = "Unknown topic operation"
            r1.append(r2)     // Catch: java.io.IOException -> L8b
            r1.append(r6)     // Catch: java.io.IOException -> L8b
            java.lang.String r6 = "."
            r1.append(r6)     // Catch: java.io.IOException -> L8b
            goto L8a
        L47:
            java.lang.String r1 = r6.c()     // Catch: java.io.IOException -> L8b
            r5.e(r1)     // Catch: java.io.IOException -> L8b
            boolean r1 = h()     // Catch: java.io.IOException -> L8b
            if (r1 == 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L8b
            r1.<init>()     // Catch: java.io.IOException -> L8b
            java.lang.String r3 = "Unsubscribe from topic: "
            r1.append(r3)     // Catch: java.io.IOException -> L8b
            java.lang.String r6 = r6.c()     // Catch: java.io.IOException -> L8b
            r1.append(r6)     // Catch: java.io.IOException -> L8b
            r1.append(r2)     // Catch: java.io.IOException -> L8b
            goto L8a
        L69:
            java.lang.String r1 = r6.c()     // Catch: java.io.IOException -> L8b
            r5.d(r1)     // Catch: java.io.IOException -> L8b
            boolean r1 = h()     // Catch: java.io.IOException -> L8b
            if (r1 == 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L8b
            r1.<init>()     // Catch: java.io.IOException -> L8b
            java.lang.String r3 = "Subscribe to topic: "
            r1.append(r3)     // Catch: java.io.IOException -> L8b
            java.lang.String r6 = r6.c()     // Catch: java.io.IOException -> L8b
            r1.append(r6)     // Catch: java.io.IOException -> L8b
            r1.append(r2)     // Catch: java.io.IOException -> L8b
        L8a:
            return r4
        L8b:
            r6 = move-exception
            java.lang.String r1 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r2 = r6.getMessage()
            boolean r1 = r1.equals(r2)
            java.lang.String r2 = "FirebaseMessaging"
            if (r1 != 0) goto Lb4
            java.lang.String r1 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r6.getMessage()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto La7
            goto Lb4
        La7:
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto Lb3
            java.lang.String r6 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r2, r6)
            return r0
        Lb3:
            throw r6
        Lb4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r1.append(r3)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = ". Will retry Topic operation."
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.l(com.google.firebase.messaging.TopicOperation):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable, long j4) {
        this.f31749f.schedule(runnable, j4, TimeUnit.SECONDS);
    }

    @VisibleForTesting
    Task<Void> n(TopicOperation topicOperation) {
        this.f31751h.a(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        b(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void o(boolean z3) {
        this.f31750g = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        if (g()) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> r(String str) {
        Task<Void> n4 = n(TopicOperation.f(str));
        q();
        return n4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public boolean s() throws IOException {
        while (true) {
            synchronized (this) {
                TopicOperation c4 = this.f31751h.c();
                if (c4 == null) {
                    h();
                    return true;
                } else if (!l(c4)) {
                    return false;
                } else {
                    this.f31751h.e(c4);
                    k(c4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(long j4) {
        m(new TopicsSyncTask(this, this.f31744a, this.f31745b, Math.min(Math.max(30L, 2 * j4), f31743i)), j4);
        o(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> u(String str) {
        Task<Void> n4 = n(TopicOperation.g(str));
        q();
        return n4;
    }
}
