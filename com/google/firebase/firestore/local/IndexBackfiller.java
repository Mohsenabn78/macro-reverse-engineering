package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.common.base.Supplier;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class IndexBackfiller {

    /* renamed from: f  reason: collision with root package name */
    private static final long f30585f = TimeUnit.SECONDS.toMillis(15);

    /* renamed from: g  reason: collision with root package name */
    private static final long f30586g = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final Scheduler f30587a;

    /* renamed from: b  reason: collision with root package name */
    private final Persistence f30588b;

    /* renamed from: c  reason: collision with root package name */
    private final Supplier<IndexManager> f30589c;

    /* renamed from: d  reason: collision with root package name */
    private final Supplier<LocalDocumentsView> f30590d;

    /* renamed from: e  reason: collision with root package name */
    private int f30591e;

    /* loaded from: classes5.dex */
    public class Scheduler implements com.google.firebase.firestore.local.Scheduler {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private AsyncQueue.DelayedTask f30592a;

        /* renamed from: b  reason: collision with root package name */
        private final AsyncQueue f30593b;

        public Scheduler(AsyncQueue asyncQueue) {
            this.f30593b = asyncQueue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Logger.debug("IndexBackfiller", "Documents written: %s", Integer.valueOf(IndexBackfiller.this.backfill()));
            c(IndexBackfiller.f30586g);
        }

        private void c(long j4) {
            this.f30592a = this.f30593b.enqueueAfterDelay(AsyncQueue.TimerId.INDEX_BACKFILL, j4, new Runnable() { // from class: com.google.firebase.firestore.local.f
                @Override // java.lang.Runnable
                public final void run() {
                    IndexBackfiller.Scheduler.this.b();
                }
            });
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            c(IndexBackfiller.f30585f);
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            AsyncQueue.DelayedTask delayedTask = this.f30592a;
            if (delayedTask != null) {
                delayedTask.cancel();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndexBackfiller(Persistence persistence, AsyncQueue asyncQueue, final LocalStore localStore) {
        this(persistence, asyncQueue, new Supplier() { // from class: com.google.firebase.firestore.local.d
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return LocalStore.this.getIndexManagerForCurrentUser();
            }
        }, new Supplier() { // from class: com.google.firebase.firestore.local.e
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return LocalStore.this.getLocalDocumentsForCurrentUser();
            }
        });
        Objects.requireNonNull(localStore);
    }

    private FieldIndex.IndexOffset d(FieldIndex.IndexOffset indexOffset, LocalDocumentsResult localDocumentsResult) {
        Iterator<Map.Entry<DocumentKey, Document>> it = localDocumentsResult.getDocuments().iterator();
        FieldIndex.IndexOffset indexOffset2 = indexOffset;
        while (it.hasNext()) {
            FieldIndex.IndexOffset fromDocument = FieldIndex.IndexOffset.fromDocument(it.next().getValue());
            if (fromDocument.compareTo(indexOffset2) > 0) {
                indexOffset2 = fromDocument;
            }
        }
        return FieldIndex.IndexOffset.create(indexOffset2.getReadTime(), indexOffset2.getDocumentKey(), Math.max(localDocumentsResult.getBatchId(), indexOffset.getLargestBatchId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer e() {
        return Integer.valueOf(g());
    }

    private int f(String str, int i4) {
        IndexManager indexManager = this.f30589c.get();
        FieldIndex.IndexOffset minOffset = indexManager.getMinOffset(str);
        LocalDocumentsResult k4 = this.f30590d.get().k(str, minOffset, i4);
        indexManager.updateIndexEntries(k4.getDocuments());
        FieldIndex.IndexOffset d4 = d(minOffset, k4);
        Logger.debug("IndexBackfiller", "Updating offset: %s", d4);
        indexManager.updateCollectionGroup(str, d4);
        return k4.getDocuments().size();
    }

    private int g() {
        IndexManager indexManager = this.f30589c.get();
        HashSet hashSet = new HashSet();
        int i4 = this.f30591e;
        while (i4 > 0) {
            String nextCollectionGroupToUpdate = indexManager.getNextCollectionGroupToUpdate();
            if (nextCollectionGroupToUpdate == null || hashSet.contains(nextCollectionGroupToUpdate)) {
                break;
            }
            Logger.debug("IndexBackfiller", "Processing collection: %s", nextCollectionGroupToUpdate);
            i4 -= f(nextCollectionGroupToUpdate, i4);
            hashSet.add(nextCollectionGroupToUpdate);
        }
        return this.f30591e - i4;
    }

    public int backfill() {
        return ((Integer) this.f30588b.h("Backfill Indexes", new com.google.firebase.firestore.util.Supplier() { // from class: com.google.firebase.firestore.local.c
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                Integer e4;
                e4 = IndexBackfiller.this.e();
                return e4;
            }
        })).intValue();
    }

    public Scheduler getScheduler() {
        return this.f30587a;
    }

    public IndexBackfiller(Persistence persistence, AsyncQueue asyncQueue, Supplier<IndexManager> supplier, Supplier<LocalDocumentsView> supplier2) {
        this.f30591e = 50;
        this.f30588b = persistence;
        this.f30587a = new Scheduler(asyncQueue);
        this.f30589c = supplier;
        this.f30590d = supplier2;
    }
}
