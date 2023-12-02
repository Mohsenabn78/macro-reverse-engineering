package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class LruGarbageCollector {

    /* renamed from: c  reason: collision with root package name */
    private static final long f30628c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f30629d;

    /* renamed from: a  reason: collision with root package name */
    private final LruDelegate f30630a;

    /* renamed from: b  reason: collision with root package name */
    private final Params f30631b;

    /* loaded from: classes5.dex */
    public class GCScheduler implements Scheduler {

        /* renamed from: a  reason: collision with root package name */
        private final AsyncQueue f30632a;

        /* renamed from: b  reason: collision with root package name */
        private final LocalStore f30633b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f30634c = false;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private AsyncQueue.DelayedTask f30635d;

        public GCScheduler(AsyncQueue asyncQueue, LocalStore localStore) {
            this.f30632a = asyncQueue;
            this.f30633b = localStore;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            this.f30633b.collectGarbage(LruGarbageCollector.this);
            this.f30634c = true;
            c();
        }

        private void c() {
            this.f30635d = this.f30632a.enqueueAfterDelay(AsyncQueue.TimerId.GARBAGE_COLLECTION, this.f30634c ? LruGarbageCollector.f30629d : LruGarbageCollector.f30628c, new Runnable() { // from class: com.google.firebase.firestore.local.c0
                @Override // java.lang.Runnable
                public final void run() {
                    LruGarbageCollector.GCScheduler.this.b();
                }
            });
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            if (LruGarbageCollector.this.f30631b.f30637a != -1) {
                c();
            }
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            AsyncQueue.DelayedTask delayedTask = this.f30635d;
            if (delayedTask != null) {
                delayedTask.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Params {

        /* renamed from: a  reason: collision with root package name */
        long f30637a;

        /* renamed from: b  reason: collision with root package name */
        int f30638b;

        /* renamed from: c  reason: collision with root package name */
        final int f30639c;

        Params(long j4, int i4, int i5) {
            this.f30637a = j4;
            this.f30638b = i4;
            this.f30639c = i5;
        }

        public static Params Default() {
            return new Params(104857600L, 10, 1000);
        }

        public static Params Disabled() {
            return new Params(-1L, 0, 0);
        }

        public static Params WithCacheSizeBytes(long j4) {
            return new Params(j4, 10, 1000);
        }
    }

    /* loaded from: classes5.dex */
    public static class Results {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f30640a;

        /* renamed from: b  reason: collision with root package name */
        private final int f30641b;

        /* renamed from: c  reason: collision with root package name */
        private final int f30642c;

        /* renamed from: d  reason: collision with root package name */
        private final int f30643d;

        Results(boolean z3, int i4, int i5, int i6) {
            this.f30640a = z3;
            this.f30641b = i4;
            this.f30642c = i5;
            this.f30643d = i6;
        }

        static Results a() {
            return new Results(false, 0, 0, 0);
        }

        public int getDocumentsRemoved() {
            return this.f30643d;
        }

        public int getSequenceNumbersCollected() {
            return this.f30641b;
        }

        public int getTargetsRemoved() {
            return this.f30642c;
        }

        public boolean hasRun() {
            return this.f30640a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class RollingSequenceNumberBuffer {

        /* renamed from: c  reason: collision with root package name */
        private static final Comparator<Long> f30644c = new Comparator() { // from class: com.google.firebase.firestore.local.d0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d4;
                d4 = LruGarbageCollector.RollingSequenceNumberBuffer.d((Long) obj, (Long) obj2);
                return d4;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final PriorityQueue<Long> f30645a;

        /* renamed from: b  reason: collision with root package name */
        private final int f30646b;

        RollingSequenceNumberBuffer(int i4) {
            this.f30646b = i4;
            this.f30645a = new PriorityQueue<>(i4, f30644c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int d(Long l4, Long l5) {
            return l5.compareTo(l4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(Long l4) {
            if (this.f30645a.size() < this.f30646b) {
                this.f30645a.add(l4);
            } else if (l4.longValue() < this.f30645a.peek().longValue()) {
                this.f30645a.poll();
                this.f30645a.add(l4);
            }
        }

        long c() {
            return this.f30645a.peek().longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f30628c = timeUnit.toMillis(1L);
        f30629d = timeUnit.toMillis(5L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LruGarbageCollector(LruDelegate lruDelegate, Params params) {
        this.f30630a = lruDelegate;
        this.f30631b = params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(RollingSequenceNumberBuffer rollingSequenceNumberBuffer, TargetData targetData) {
        rollingSequenceNumberBuffer.b(Long.valueOf(targetData.getSequenceNumber()));
    }

    private Results l(SparseArray<?> sparseArray) {
        Locale locale;
        long currentTimeMillis = System.currentTimeMillis();
        int e4 = e(this.f30631b.f30638b);
        if (e4 > this.f30631b.f30639c) {
            Logger.debug("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f30631b.f30639c + " from " + e4, new Object[0]);
            e4 = this.f30631b.f30639c;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        long h4 = h(e4);
        long currentTimeMillis3 = System.currentTimeMillis();
        int k4 = k(h4, sparseArray);
        long currentTimeMillis4 = System.currentTimeMillis();
        int j4 = j(h4);
        long currentTimeMillis5 = System.currentTimeMillis();
        if (Logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LRU Garbage Collection:\n\tCounted targets in " + (currentTimeMillis2 - currentTimeMillis) + "ms\n");
            sb.append(String.format(Locale.ROOT, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(e4), Long.valueOf(currentTimeMillis3 - currentTimeMillis2)));
            Logger.debug("LruGarbageCollector", ((sb.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(k4), Long.valueOf(currentTimeMillis4 - currentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(j4), Long.valueOf(currentTimeMillis5 - currentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(currentTimeMillis5 - currentTimeMillis)), new Object[0]);
        }
        return new Results(true, e4, k4, j4);
    }

    int e(int i4) {
        return (int) ((i4 / 100.0f) * ((float) this.f30630a.getSequenceNumberCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Results f(SparseArray<?> sparseArray) {
        if (this.f30631b.f30637a == -1) {
            Logger.debug("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return Results.a();
        }
        long g4 = g();
        if (g4 < this.f30631b.f30637a) {
            Logger.debug("LruGarbageCollector", "Garbage collection skipped; Cache size " + g4 + " is lower than threshold " + this.f30631b.f30637a, new Object[0]);
            return Results.a();
        }
        return l(sparseArray);
    }

    long g() {
        return this.f30630a.getByteSize();
    }

    long h(int i4) {
        if (i4 == 0) {
            return -1L;
        }
        final RollingSequenceNumberBuffer rollingSequenceNumberBuffer = new RollingSequenceNumberBuffer(i4);
        this.f30630a.forEachTarget(new Consumer() { // from class: com.google.firebase.firestore.local.a0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                LruGarbageCollector.i(LruGarbageCollector.RollingSequenceNumberBuffer.this, (TargetData) obj);
            }
        });
        this.f30630a.forEachOrphanedDocumentSequenceNumber(new Consumer() { // from class: com.google.firebase.firestore.local.b0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                LruGarbageCollector.RollingSequenceNumberBuffer.this.b((Long) obj);
            }
        });
        return rollingSequenceNumberBuffer.c();
    }

    int j(long j4) {
        return this.f30630a.removeOrphanedDocuments(j4);
    }

    int k(long j4, SparseArray<?> sparseArray) {
        return this.f30630a.removeTargets(j4, sparseArray);
    }

    public GCScheduler newScheduler(AsyncQueue asyncQueue, LocalStore localStore) {
        return new GCScheduler(asyncQueue, localStore);
    }

    public LruGarbageCollector withNewThreshold(long j4) {
        Params params = this.f30631b;
        params.f30637a = j4;
        params.f30638b = 100;
        return this;
    }
}
