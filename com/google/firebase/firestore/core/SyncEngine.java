package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.TransactionOptions;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleElement;
import com.google.firebase.firestore.bundle.BundleLoader;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.BundleReader;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.View;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.local.LocalDocumentsResult;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class SyncEngine implements RemoteStore.RemoteStoreCallback {

    /* renamed from: o  reason: collision with root package name */
    private static final String f30399o = "SyncEngine";

    /* renamed from: a  reason: collision with root package name */
    private final LocalStore f30400a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteStore f30401b;

    /* renamed from: e  reason: collision with root package name */
    private final int f30404e;

    /* renamed from: m  reason: collision with root package name */
    private User f30412m;

    /* renamed from: n  reason: collision with root package name */
    private SyncEngineCallback f30413n;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Query, QueryView> f30402c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Integer, List<Query>> f30403d = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<DocumentKey> f30405f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final Map<DocumentKey, Integer> f30406g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, LimboResolution> f30407h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final ReferenceSet f30408i = new ReferenceSet();

    /* renamed from: j  reason: collision with root package name */
    private final Map<User, Map<Integer, TaskCompletionSource<Void>>> f30409j = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private final TargetIdGenerator f30411l = TargetIdGenerator.forSyncEngine();

    /* renamed from: k  reason: collision with root package name */
    private final Map<Integer, List<TaskCompletionSource<Void>>> f30410k = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.SyncEngine$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30414a;

        static {
            int[] iArr = new int[LimboDocumentChange.Type.values().length];
            f30414a = iArr;
            try {
                iArr[LimboDocumentChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30414a[LimboDocumentChange.Type.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class LimboResolution {

        /* renamed from: a  reason: collision with root package name */
        private final DocumentKey f30415a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30416b;

        LimboResolution(DocumentKey documentKey) {
            this.f30415a = documentKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface SyncEngineCallback {
        void handleOnlineStateChange(OnlineState onlineState);

        void onError(Query query, Status status);

        void onViewSnapshots(List<ViewSnapshot> list);
    }

    public SyncEngine(LocalStore localStore, RemoteStore remoteStore, User user, int i4) {
        this.f30400a = localStore;
        this.f30401b = remoteStore;
        this.f30404e = i4;
        this.f30412m = user;
    }

    private void a(int i4, TaskCompletionSource<Void> taskCompletionSource) {
        Map<Integer, TaskCompletionSource<Void>> map = this.f30409j.get(this.f30412m);
        if (map == null) {
            map = new HashMap<>();
            this.f30409j.put(this.f30412m, map);
        }
        map.put(Integer.valueOf(i4), taskCompletionSource);
    }

    private void b(String str) {
        boolean z3;
        if (this.f30413n != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Trying to call %s before setting callback", str);
    }

    private void c(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, @Nullable RemoteEvent remoteEvent) {
        TargetChange targetChange;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<Query, QueryView> entry : this.f30402c.entrySet()) {
            QueryView value = entry.getValue();
            View c4 = value.c();
            View.DocumentChanges computeDocChanges = c4.computeDocChanges(immutableSortedMap);
            if (computeDocChanges.needsRefill()) {
                computeDocChanges = c4.computeDocChanges(this.f30400a.executeQuery(value.a(), false).getDocuments(), computeDocChanges);
            }
            if (remoteEvent == null) {
                targetChange = null;
            } else {
                targetChange = remoteEvent.getTargetChanges().get(Integer.valueOf(value.b()));
            }
            ViewChange applyChanges = value.c().applyChanges(computeDocChanges, targetChange);
            o(applyChanges.getLimboChanges(), value.b());
            if (applyChanges.getSnapshot() != null) {
                arrayList.add(applyChanges.getSnapshot());
                arrayList2.add(LocalViewChanges.fromViewSnapshot(value.b(), applyChanges.getSnapshot()));
            }
        }
        this.f30413n.onViewSnapshots(arrayList);
        this.f30400a.notifyLocalViewChanges(arrayList2);
    }

    private boolean d(Status status) {
        String str;
        Status.Code code = status.getCode();
        if (status.getDescription() != null) {
            str = status.getDescription();
        } else {
            str = "";
        }
        if ((code == Status.Code.FAILED_PRECONDITION && str.contains("requires an index")) || code == Status.Code.PERMISSION_DENIED) {
            return true;
        }
        return false;
    }

    private void e() {
        for (Map.Entry<Integer, List<TaskCompletionSource<Void>>> entry : this.f30410k.entrySet()) {
            for (TaskCompletionSource<Void> taskCompletionSource : entry.getValue()) {
                taskCompletionSource.setException(new FirebaseFirestoreException("'waitForPendingWrites' task is cancelled due to User change.", FirebaseFirestoreException.Code.CANCELLED));
            }
        }
        this.f30410k.clear();
    }

    private ViewSnapshot f(Query query, int i4, ByteString byteString) {
        QueryResult executeQuery = this.f30400a.executeQuery(query, true);
        ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
        boolean z3 = false;
        if (this.f30403d.get(Integer.valueOf(i4)) != null) {
            syncState = this.f30402c.get(this.f30403d.get(Integer.valueOf(i4)).get(0)).c().getSyncState();
        }
        if (syncState == ViewSnapshot.SyncState.SYNCED) {
            z3 = true;
        }
        TargetChange createSynthesizedTargetChangeForCurrentChange = TargetChange.createSynthesizedTargetChangeForCurrentChange(z3, byteString);
        View view = new View(query, executeQuery.getRemoteKeys());
        ViewChange applyChanges = view.applyChanges(view.computeDocChanges(executeQuery.getDocuments()), createSynthesizedTargetChangeForCurrentChange);
        o(applyChanges.getLimboChanges(), i4);
        this.f30402c.put(query, new QueryView(query, i4, view));
        if (!this.f30403d.containsKey(Integer.valueOf(i4))) {
            this.f30403d.put(Integer.valueOf(i4), new ArrayList(1));
        }
        this.f30403d.get(Integer.valueOf(i4)).add(query);
        return applyChanges.getSnapshot();
    }

    private void g(Status status, String str, Object... objArr) {
        if (d(status)) {
            Logger.warn("Firestore", "%s: %s", String.format(str, objArr), status);
        }
    }

    private void h(int i4, @Nullable Status status) {
        Integer valueOf;
        TaskCompletionSource<Void> taskCompletionSource;
        Map<Integer, TaskCompletionSource<Void>> map = this.f30409j.get(this.f30412m);
        if (map != null && (taskCompletionSource = map.get((valueOf = Integer.valueOf(i4)))) != null) {
            if (status != null) {
                taskCompletionSource.setException(Util.exceptionFromStatus(status));
            } else {
                taskCompletionSource.setResult(null);
            }
            map.remove(valueOf);
        }
    }

    private void i() {
        while (!this.f30405f.isEmpty() && this.f30406g.size() < this.f30404e) {
            Iterator<DocumentKey> it = this.f30405f.iterator();
            DocumentKey next = it.next();
            it.remove();
            int nextId = this.f30411l.nextId();
            this.f30407h.put(Integer.valueOf(nextId), new LimboResolution(next));
            this.f30406g.put(next, Integer.valueOf(nextId));
            this.f30401b.listen(new TargetData(Query.atPath(next.getPath()).toTarget(), nextId, -1L, QueryPurpose.LIMBO_RESOLUTION));
        }
    }

    private void j(int i4, Status status) {
        for (Query query : this.f30403d.get(Integer.valueOf(i4))) {
            this.f30402c.remove(query);
            if (!status.isOk()) {
                this.f30413n.onError(query, status);
                g(status, "Listen for %s failed", query);
            }
        }
        this.f30403d.remove(Integer.valueOf(i4));
        ImmutableSortedSet<DocumentKey> referencesForId = this.f30408i.referencesForId(i4);
        this.f30408i.removeReferencesForId(i4);
        Iterator<DocumentKey> it = referencesForId.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            if (!this.f30408i.containsKey(next)) {
                k(next);
            }
        }
    }

    private void k(DocumentKey documentKey) {
        this.f30405f.remove(documentKey);
        Integer num = this.f30406g.get(documentKey);
        if (num != null) {
            this.f30401b.stopListening(num.intValue());
            this.f30406g.remove(documentKey);
            this.f30407h.remove(num);
            i();
        }
    }

    private void l(int i4) {
        if (this.f30410k.containsKey(Integer.valueOf(i4))) {
            for (TaskCompletionSource<Void> taskCompletionSource : this.f30410k.get(Integer.valueOf(i4))) {
                taskCompletionSource.setResult(null);
            }
            this.f30410k.remove(Integer.valueOf(i4));
        }
    }

    private void n(LimboDocumentChange limboDocumentChange) {
        DocumentKey key = limboDocumentChange.getKey();
        if (!this.f30406g.containsKey(key) && !this.f30405f.contains(key)) {
            Logger.debug(f30399o, "New document in limbo: %s", key);
            this.f30405f.add(key);
            i();
        }
    }

    private void o(List<LimboDocumentChange> list, int i4) {
        for (LimboDocumentChange limboDocumentChange : list) {
            int i5 = AnonymousClass1.f30414a[limboDocumentChange.getType().ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    Logger.debug(f30399o, "Document no longer in limbo: %s", limboDocumentChange.getKey());
                    DocumentKey key = limboDocumentChange.getKey();
                    this.f30408i.removeReference(key, i4);
                    if (!this.f30408i.containsKey(key)) {
                        k(key);
                    }
                } else {
                    throw Assert.fail("Unknown limbo change type: %s", limboDocumentChange.getType());
                }
            } else {
                this.f30408i.addReference(limboDocumentChange.getKey(), i4);
                n(limboDocumentChange);
            }
        }
    }

    @VisibleForTesting
    public Map<DocumentKey, Integer> getActiveLimboDocumentResolutions() {
        return new HashMap(this.f30406g);
    }

    @VisibleForTesting
    public List<DocumentKey> getEnqueuedLimboDocumentResolutions() {
        return new ArrayList(this.f30405f);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
        LimboResolution limboResolution = this.f30407h.get(Integer.valueOf(i4));
        if (limboResolution != null && limboResolution.f30416b) {
            return DocumentKey.emptyKeySet().insert(limboResolution.f30415a);
        }
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        if (this.f30403d.containsKey(Integer.valueOf(i4))) {
            for (Query query : this.f30403d.get(Integer.valueOf(i4))) {
                if (this.f30402c.containsKey(query)) {
                    emptyKeySet = emptyKeySet.unionWith(this.f30402c.get(query).c().d());
                }
            }
        }
        return emptyKeySet;
    }

    public void handleCredentialChange(User user) {
        boolean z3 = !this.f30412m.equals(user);
        this.f30412m = user;
        if (z3) {
            e();
            c(this.f30400a.handleUserChange(user), null);
        }
        this.f30401b.handleCredentialChange();
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        b("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Query, QueryView> entry : this.f30402c.entrySet()) {
            ViewChange applyOnlineStateChange = entry.getValue().c().applyOnlineStateChange(onlineState);
            Assert.hardAssert(applyOnlineStateChange.getLimboChanges().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (applyOnlineStateChange.getSnapshot() != null) {
                arrayList.add(applyOnlineStateChange.getSnapshot());
            }
        }
        this.f30413n.onViewSnapshots(arrayList);
        this.f30413n.handleOnlineStateChange(onlineState);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedListen(int i4, Status status) {
        DocumentKey documentKey;
        b("handleRejectedListen");
        LimboResolution limboResolution = this.f30407h.get(Integer.valueOf(i4));
        if (limboResolution != null) {
            documentKey = limboResolution.f30415a;
        } else {
            documentKey = null;
        }
        if (documentKey != null) {
            this.f30406g.remove(documentKey);
            this.f30407h.remove(Integer.valueOf(i4));
            i();
            SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
            handleRemoteEvent(new RemoteEvent(snapshotVersion, Collections.emptyMap(), Collections.emptyMap(), Collections.singletonMap(documentKey, MutableDocument.newNoDocument(documentKey, snapshotVersion)), Collections.singleton(documentKey)));
            return;
        }
        this.f30400a.releaseTarget(i4);
        j(i4, status);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedWrite(int i4, Status status) {
        b("handleRejectedWrite");
        ImmutableSortedMap<DocumentKey, Document> rejectBatch = this.f30400a.rejectBatch(i4);
        if (!rejectBatch.isEmpty()) {
            g(status, "Write failed at %s", rejectBatch.getMinKey().getPath());
        }
        h(i4, status);
        l(i4);
        c(rejectBatch, null);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        boolean z3;
        b("handleRemoteEvent");
        for (Map.Entry<Integer, TargetChange> entry : remoteEvent.getTargetChanges().entrySet()) {
            TargetChange value = entry.getValue();
            LimboResolution limboResolution = this.f30407h.get(entry.getKey());
            if (limboResolution != null) {
                if (value.getAddedDocuments().size() + value.getModifiedDocuments().size() + value.getRemovedDocuments().size() <= 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assert.hardAssert(z3, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.getAddedDocuments().size() > 0) {
                    limboResolution.f30416b = true;
                } else if (value.getModifiedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.f30416b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.getRemovedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.f30416b, "Received remove for limbo target document without add.", new Object[0]);
                    limboResolution.f30416b = false;
                }
            }
        }
        c(this.f30400a.applyRemoteEvent(remoteEvent), remoteEvent);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        b("handleSuccessfulWrite");
        h(mutationBatchResult.getBatch().getBatchId(), null);
        l(mutationBatchResult.getBatch().getBatchId());
        c(this.f30400a.acknowledgeBatch(mutationBatchResult), null);
    }

    public int listen(Query query) {
        b("listen");
        Assert.hardAssert(!this.f30402c.containsKey(query), "We already listen to query: %s", query);
        TargetData allocateTarget = this.f30400a.allocateTarget(query.toTarget());
        this.f30413n.onViewSnapshots(Collections.singletonList(f(query, allocateTarget.getTargetId(), allocateTarget.getResumeToken())));
        this.f30401b.listen(allocateTarget);
        return allocateTarget.getTargetId();
    }

    public void loadBundle(BundleReader bundleReader, LoadBundleTask loadBundleTask) {
        try {
            try {
                BundleMetadata bundleMetadata = bundleReader.getBundleMetadata();
                if (this.f30400a.hasNewerBundle(bundleMetadata)) {
                    loadBundleTask.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
                    try {
                        bundleReader.close();
                        return;
                    } catch (IOException e4) {
                        Logger.warn(f30399o, "Exception while closing bundle", e4);
                        return;
                    }
                }
                loadBundleTask.updateProgress(LoadBundleTaskProgress.forInitial(bundleMetadata));
                BundleLoader bundleLoader = new BundleLoader(this.f30400a, bundleMetadata);
                long j4 = 0;
                while (true) {
                    BundleElement nextElement = bundleReader.getNextElement();
                    if (nextElement != null) {
                        long bytesRead = bundleReader.getBytesRead();
                        LoadBundleTaskProgress addElement = bundleLoader.addElement(nextElement, bytesRead - j4);
                        if (addElement != null) {
                            loadBundleTask.updateProgress(addElement);
                        }
                        j4 = bytesRead;
                    } else {
                        c(bundleLoader.applyChanges(), null);
                        this.f30400a.saveBundle(bundleMetadata);
                        loadBundleTask.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
                        try {
                            bundleReader.close();
                            return;
                        } catch (IOException e5) {
                            Logger.warn(f30399o, "Exception while closing bundle", e5);
                            return;
                        }
                    }
                }
            } catch (Exception e6) {
                Logger.warn("Firestore", "Loading bundle failed : %s", e6);
                loadBundleTask.setException(new FirebaseFirestoreException("Bundle failed to load", FirebaseFirestoreException.Code.INVALID_ARGUMENT, e6));
                try {
                    bundleReader.close();
                } catch (IOException e7) {
                    Logger.warn(f30399o, "Exception while closing bundle", e7);
                }
            }
        } catch (Throwable th) {
            try {
                bundleReader.close();
            } catch (IOException e8) {
                Logger.warn(f30399o, "Exception while closing bundle", e8);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Query query) {
        boolean z3;
        b("stopListening");
        QueryView queryView = this.f30402c.get(query);
        if (queryView != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Trying to stop listening to a query not found", new Object[0]);
        this.f30402c.remove(query);
        int b4 = queryView.b();
        List<Query> list = this.f30403d.get(Integer.valueOf(b4));
        list.remove(query);
        if (list.isEmpty()) {
            this.f30400a.releaseTarget(b4);
            this.f30401b.stopListening(b4);
            j(b4, Status.OK);
        }
    }

    public void registerPendingWritesTask(TaskCompletionSource<Void> taskCompletionSource) {
        if (!this.f30401b.canUseNetwork()) {
            Logger.debug(f30399o, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int highestUnacknowledgedBatchId = this.f30400a.getHighestUnacknowledgedBatchId();
        if (highestUnacknowledgedBatchId == -1) {
            taskCompletionSource.setResult(null);
            return;
        }
        if (!this.f30410k.containsKey(Integer.valueOf(highestUnacknowledgedBatchId))) {
            this.f30410k.put(Integer.valueOf(highestUnacknowledgedBatchId), new ArrayList());
        }
        this.f30410k.get(Integer.valueOf(highestUnacknowledgedBatchId)).add(taskCompletionSource);
    }

    public Task<Map<String, Value>> runAggregateQuery(Query query, List<AggregateField> list) {
        return this.f30401b.runAggregateQuery(query, list);
    }

    public void setCallback(SyncEngineCallback syncEngineCallback) {
        this.f30413n = syncEngineCallback;
    }

    public <TResult> Task<TResult> transaction(AsyncQueue asyncQueue, TransactionOptions transactionOptions, Function<Transaction, Task<TResult>> function) {
        return new TransactionRunner(asyncQueue, this.f30401b, transactionOptions, function).run();
    }

    public void writeMutations(List<Mutation> list, TaskCompletionSource<Void> taskCompletionSource) {
        b("writeMutations");
        LocalDocumentsResult writeLocally = this.f30400a.writeLocally(list);
        a(writeLocally.getBatchId(), taskCompletionSource);
        c(writeLocally.getDocuments(), null);
        this.f30401b.fillWritePipeline();
    }
}
