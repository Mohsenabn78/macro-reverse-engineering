package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleCallback;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class LocalStore implements BundleCallback {

    /* renamed from: n  reason: collision with root package name */
    private static final long f30605n = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: a  reason: collision with root package name */
    private final Persistence f30606a;

    /* renamed from: b  reason: collision with root package name */
    private IndexManager f30607b;

    /* renamed from: c  reason: collision with root package name */
    private MutationQueue f30608c;

    /* renamed from: d  reason: collision with root package name */
    private DocumentOverlayCache f30609d;

    /* renamed from: e  reason: collision with root package name */
    private final RemoteDocumentCache f30610e;

    /* renamed from: f  reason: collision with root package name */
    private LocalDocumentsView f30611f;

    /* renamed from: g  reason: collision with root package name */
    private final QueryEngine f30612g;

    /* renamed from: h  reason: collision with root package name */
    private final ReferenceSet f30613h;

    /* renamed from: i  reason: collision with root package name */
    private final TargetCache f30614i;

    /* renamed from: j  reason: collision with root package name */
    private final BundleCache f30615j;

    /* renamed from: k  reason: collision with root package name */
    private final SparseArray<TargetData> f30616k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<Target, Integer> f30617l;

    /* renamed from: m  reason: collision with root package name */
    private final TargetIdGenerator f30618m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class AllocateQueryHolder {

        /* renamed from: a  reason: collision with root package name */
        TargetData f30619a;

        /* renamed from: b  reason: collision with root package name */
        int f30620b;

        private AllocateQueryHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DocumentChangeResult {

        /* renamed from: a  reason: collision with root package name */
        private final Map<DocumentKey, MutableDocument> f30621a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<DocumentKey> f30622b;

        private DocumentChangeResult(Map<DocumentKey, MutableDocument> map, Set<DocumentKey> set) {
            this.f30621a = map;
            this.f30622b = set;
        }
    }

    public LocalStore(Persistence persistence, QueryEngine queryEngine, User user) {
        Assert.hardAssert(persistence.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.f30606a = persistence;
        this.f30612g = queryEngine;
        TargetCache g4 = persistence.g();
        this.f30614i = g4;
        this.f30615j = persistence.a();
        this.f30618m = TargetIdGenerator.forTargetCache(g4.getHighestTargetId());
        this.f30610e = persistence.f();
        ReferenceSet referenceSet = new ReferenceSet();
        this.f30613h = referenceSet;
        this.f30616k = new SparseArray<>();
        this.f30617l = new HashMap();
        persistence.getReferenceDelegate().g(referenceSet);
        v(user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LruGarbageCollector.Results A(LruGarbageCollector lruGarbageCollector) {
        return lruGarbageCollector.f(this.f30616k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(List list) {
        Collection<FieldIndex> fieldIndexes = this.f30607b.getFieldIndexes();
        Comparator<FieldIndex> comparator = FieldIndex.SEMANTIC_COMPARATOR;
        final IndexManager indexManager = this.f30607b;
        Objects.requireNonNull(indexManager);
        Consumer consumer = new Consumer() { // from class: com.google.firebase.firestore.local.p
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                IndexManager.this.addFieldIndex((FieldIndex) obj);
            }
        };
        final IndexManager indexManager2 = this.f30607b;
        Objects.requireNonNull(indexManager2);
        Util.diffCollections(fieldIndexes, list, comparator, consumer, new Consumer() { // from class: com.google.firebase.firestore.local.q
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                IndexManager.this.deleteFieldIndex((FieldIndex) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.f30607b.deleteAllFieldIndexes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NamedQuery D(String str) {
        return this.f30615j.getNamedQuery(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean E(BundleMetadata bundleMetadata) {
        boolean z3;
        BundleMetadata bundleMetadata2 = this.f30615j.getBundleMetadata(bundleMetadata.getBundleId());
        if (bundleMetadata2 != null && bundleMetadata2.getCreateTime().compareTo(bundleMetadata.getCreateTime()) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        return Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(List list) {
        boolean z3;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalViewChanges localViewChanges = (LocalViewChanges) it.next();
            int targetId = localViewChanges.getTargetId();
            this.f30613h.addReferences(localViewChanges.getAdded(), targetId);
            ImmutableSortedSet<DocumentKey> removed = localViewChanges.getRemoved();
            Iterator<DocumentKey> it2 = removed.iterator();
            while (it2.hasNext()) {
                this.f30606a.getReferenceDelegate().i(it2.next());
            }
            this.f30613h.removeReferences(removed, targetId);
            if (!localViewChanges.isFromCache()) {
                TargetData targetData = this.f30616k.get(targetId);
                if (targetData != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assert.hardAssert(z3, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(targetId));
                TargetData withLastLimboFreeSnapshotVersion = targetData.withLastLimboFreeSnapshotVersion(targetData.getSnapshotVersion());
                this.f30616k.put(targetId, withLastLimboFreeSnapshotVersion);
                if (Q(targetData, withLastLimboFreeSnapshotVersion, null)) {
                    this.f30614i.e(withLastLimboFreeSnapshotVersion);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ImmutableSortedMap G(int i4) {
        boolean z3;
        MutationBatch d4 = this.f30608c.d(i4);
        if (d4 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Attempt to reject nonexistent batch!", new Object[0]);
        this.f30608c.h(d4);
        this.f30608c.a();
        this.f30609d.removeOverlaysForBatchId(i4);
        this.f30611f.o(d4.getKeys());
        return this.f30611f.d(d4.getKeys());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(int i4) {
        boolean z3;
        TargetData targetData = this.f30616k.get(i4);
        if (targetData != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Tried to release nonexistent target: %s", Integer.valueOf(i4));
        Iterator<DocumentKey> it = this.f30613h.removeReferencesForId(i4).iterator();
        while (it.hasNext()) {
            this.f30606a.getReferenceDelegate().i(it.next());
        }
        this.f30606a.getReferenceDelegate().f(targetData);
        this.f30616k.remove(i4);
        this.f30617l.remove(targetData.getTarget());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(BundleMetadata bundleMetadata) {
        this.f30615j.saveBundleMetadata(bundleMetadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(NamedQuery namedQuery, TargetData targetData, int i4, ImmutableSortedSet immutableSortedSet) {
        if (namedQuery.getReadTime().compareTo(targetData.getSnapshotVersion()) > 0) {
            TargetData withResumeToken = targetData.withResumeToken(ByteString.EMPTY, namedQuery.getReadTime());
            this.f30616k.append(i4, withResumeToken);
            this.f30614i.e(withResumeToken);
            this.f30614i.d(i4);
            this.f30614i.c(immutableSortedSet, i4);
        }
        this.f30615j.saveNamedQuery(namedQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ByteString byteString) {
        this.f30608c.i(byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f30607b.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f30608c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LocalDocumentsResult N(Set set, List list, Timestamp timestamp) {
        Map<DocumentKey, MutableDocument> all = this.f30610e.getAll(set);
        HashSet hashSet = new HashSet();
        for (Map.Entry<DocumentKey, MutableDocument> entry : all.entrySet()) {
            if (!entry.getValue().isValidDocument()) {
                hashSet.add(entry.getKey());
            }
        }
        Map<DocumentKey, OverlayedDocument> l4 = this.f30611f.l(all);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Mutation mutation = (Mutation) it.next();
            ObjectValue extractTransformBaseValue = mutation.extractTransformBaseValue(l4.get(mutation.getKey()).getDocument());
            if (extractTransformBaseValue != null) {
                arrayList.add(new PatchMutation(mutation.getKey(), extractTransformBaseValue, extractTransformBaseValue.getFieldMask(), Precondition.exists(true)));
            }
        }
        MutationBatch f4 = this.f30608c.f(timestamp, arrayList, list);
        this.f30609d.saveOverlays(f4.getBatchId(), f4.applyToLocalDocumentSet(l4, hashSet));
        return LocalDocumentsResult.fromOverlayedDocuments(f4.getBatchId(), l4);
    }

    private static Target O(String str) {
        return Query.atPath(ResourcePath.fromString("__bundle__/docs/" + str)).toTarget();
    }

    private DocumentChangeResult P(Map<DocumentKey, MutableDocument> map) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<DocumentKey, MutableDocument> all = this.f30610e.getAll(map.keySet());
        for (Map.Entry<DocumentKey, MutableDocument> entry : map.entrySet()) {
            DocumentKey key = entry.getKey();
            MutableDocument value = entry.getValue();
            MutableDocument mutableDocument = all.get(key);
            if (value.isFoundDocument() != mutableDocument.isFoundDocument()) {
                hashSet.add(key);
            }
            if (value.isNoDocument() && value.getVersion().equals(SnapshotVersion.NONE)) {
                arrayList.add(value.getKey());
                hashMap.put(key, value);
            } else if (mutableDocument.isValidDocument() && value.getVersion().compareTo(mutableDocument.getVersion()) <= 0 && (value.getVersion().compareTo(mutableDocument.getVersion()) != 0 || !mutableDocument.hasPendingWrites())) {
                Logger.debug("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, mutableDocument.getVersion(), value.getVersion());
            } else {
                Assert.hardAssert(!SnapshotVersion.NONE.equals(value.getReadTime()), "Cannot add a document when the remote version is zero", new Object[0]);
                this.f30610e.d(value, value.getReadTime());
                hashMap.put(key, value);
            }
        }
        this.f30610e.removeAll(arrayList);
        return new DocumentChangeResult(hashMap, hashSet);
    }

    private static boolean Q(TargetData targetData, TargetData targetData2, @Nullable TargetChange targetChange) {
        if (targetData.getResumeToken().isEmpty()) {
            return true;
        }
        long seconds = targetData2.getSnapshotVersion().getTimestamp().getSeconds() - targetData.getSnapshotVersion().getTimestamp().getSeconds();
        long j4 = f30605n;
        if (seconds >= j4 || targetData2.getLastLimboFreeSnapshotVersion().getTimestamp().getSeconds() - targetData.getLastLimboFreeSnapshotVersion().getTimestamp().getSeconds() >= j4) {
            return true;
        }
        if (targetChange != null && targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size() + targetChange.getRemovedDocuments().size() > 0) {
            return true;
        }
        return false;
    }

    private void R() {
        this.f30606a.i("Start IndexManager", new Runnable() { // from class: com.google.firebase.firestore.local.v
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.L();
            }
        });
    }

    private void S() {
        this.f30606a.i("Start MutationQueue", new Runnable() { // from class: com.google.firebase.firestore.local.z
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.M();
            }
        });
    }

    private void s(MutationBatchResult mutationBatchResult) {
        boolean z3;
        MutationBatch batch = mutationBatchResult.getBatch();
        for (DocumentKey documentKey : batch.getKeys()) {
            MutableDocument a4 = this.f30610e.a(documentKey);
            SnapshotVersion snapshotVersion = mutationBatchResult.getDocVersions().get(documentKey);
            if (snapshotVersion != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "docVersions should contain every doc in the write.", new Object[0]);
            if (a4.getVersion().compareTo(snapshotVersion) < 0) {
                batch.applyToRemoteDocument(a4, mutationBatchResult);
                if (a4.isValidDocument()) {
                    this.f30610e.d(a4, mutationBatchResult.getCommitVersion());
                }
            }
        }
        this.f30608c.h(batch);
    }

    @NonNull
    private Set<DocumentKey> t(MutationBatchResult mutationBatchResult) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < mutationBatchResult.getMutationResults().size(); i4++) {
            if (!mutationBatchResult.getMutationResults().get(i4).getTransformResults().isEmpty()) {
                hashSet.add(mutationBatchResult.getBatch().getMutations().get(i4).getKey());
            }
        }
        return hashSet;
    }

    private void v(User user) {
        IndexManager c4 = this.f30606a.c(user);
        this.f30607b = c4;
        this.f30608c = this.f30606a.d(user, c4);
        DocumentOverlayCache b4 = this.f30606a.b(user);
        this.f30609d = b4;
        this.f30611f = new LocalDocumentsView(this.f30610e, this.f30608c, b4, this.f30607b);
        this.f30610e.e(this.f30607b);
        this.f30612g.initialize(this.f30611f, this.f30607b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ImmutableSortedMap w(MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        this.f30608c.e(batch, mutationBatchResult.getStreamToken());
        s(mutationBatchResult);
        this.f30608c.a();
        this.f30609d.removeOverlaysForBatchId(mutationBatchResult.getBatch().getBatchId());
        this.f30611f.o(t(mutationBatchResult));
        return this.f30611f.d(batch.getKeys());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(AllocateQueryHolder allocateQueryHolder, Target target) {
        int nextId = this.f30618m.nextId();
        allocateQueryHolder.f30620b = nextId;
        TargetData targetData = new TargetData(target, nextId, this.f30606a.getReferenceDelegate().e(), QueryPurpose.LISTEN);
        allocateQueryHolder.f30619a = targetData;
        this.f30614i.g(targetData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ImmutableSortedMap y(ImmutableSortedMap immutableSortedMap, TargetData targetData) {
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        HashMap hashMap = new HashMap();
        Iterator it = immutableSortedMap.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DocumentKey documentKey = (DocumentKey) entry.getKey();
            MutableDocument mutableDocument = (MutableDocument) entry.getValue();
            if (mutableDocument.isFoundDocument()) {
                emptyKeySet = emptyKeySet.insert(documentKey);
            }
            hashMap.put(documentKey, mutableDocument);
        }
        this.f30614i.d(targetData.getTargetId());
        this.f30614i.c(emptyKeySet, targetData.getTargetId());
        DocumentChangeResult P = P(hashMap);
        return this.f30611f.j(P.f30621a, P.f30622b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ImmutableSortedMap z(RemoteEvent remoteEvent, SnapshotVersion snapshotVersion) {
        boolean z3;
        Map<Integer, TargetChange> targetChanges = remoteEvent.getTargetChanges();
        long e4 = this.f30606a.getReferenceDelegate().e();
        for (Map.Entry<Integer, TargetChange> entry : targetChanges.entrySet()) {
            int intValue = entry.getKey().intValue();
            TargetChange value = entry.getValue();
            TargetData targetData = this.f30616k.get(intValue);
            if (targetData != null) {
                this.f30614i.a(value.getRemovedDocuments(), intValue);
                this.f30614i.c(value.getAddedDocuments(), intValue);
                TargetData withSequenceNumber = targetData.withSequenceNumber(e4);
                if (remoteEvent.getTargetMismatches().containsKey(Integer.valueOf(intValue))) {
                    ByteString byteString = ByteString.EMPTY;
                    SnapshotVersion snapshotVersion2 = SnapshotVersion.NONE;
                    withSequenceNumber = withSequenceNumber.withResumeToken(byteString, snapshotVersion2).withLastLimboFreeSnapshotVersion(snapshotVersion2);
                } else if (!value.getResumeToken().isEmpty()) {
                    withSequenceNumber = withSequenceNumber.withResumeToken(value.getResumeToken(), remoteEvent.getSnapshotVersion());
                }
                this.f30616k.put(intValue, withSequenceNumber);
                if (Q(targetData, withSequenceNumber, value)) {
                    this.f30614i.e(withSequenceNumber);
                }
            }
        }
        Map<DocumentKey, MutableDocument> documentUpdates = remoteEvent.getDocumentUpdates();
        Set<DocumentKey> resolvedLimboDocuments = remoteEvent.getResolvedLimboDocuments();
        for (DocumentKey documentKey : documentUpdates.keySet()) {
            if (resolvedLimboDocuments.contains(documentKey)) {
                this.f30606a.getReferenceDelegate().a(documentKey);
            }
        }
        DocumentChangeResult P = P(documentUpdates);
        Map<DocumentKey, MutableDocument> map = P.f30621a;
        SnapshotVersion lastRemoteSnapshotVersion = this.f30614i.getLastRemoteSnapshotVersion();
        if (!snapshotVersion.equals(SnapshotVersion.NONE)) {
            if (snapshotVersion.compareTo(lastRemoteSnapshotVersion) >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "Watch stream reverted to previous snapshot?? (%s < %s)", snapshotVersion, lastRemoteSnapshotVersion);
            this.f30614i.f(snapshotVersion);
        }
        return this.f30611f.j(map, P.f30622b);
    }

    public ImmutableSortedMap<DocumentKey, Document> acknowledgeBatch(final MutationBatchResult mutationBatchResult) {
        return (ImmutableSortedMap) this.f30606a.h("Acknowledge batch", new Supplier() { // from class: com.google.firebase.firestore.local.h
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                ImmutableSortedMap w3;
                w3 = LocalStore.this.w(mutationBatchResult);
                return w3;
            }
        });
    }

    public TargetData allocateTarget(final Target target) {
        int i4;
        TargetData b4 = this.f30614i.b(target);
        if (b4 != null) {
            i4 = b4.getTargetId();
        } else {
            final AllocateQueryHolder allocateQueryHolder = new AllocateQueryHolder();
            this.f30606a.i("Allocate target", new Runnable() { // from class: com.google.firebase.firestore.local.l
                @Override // java.lang.Runnable
                public final void run() {
                    LocalStore.this.x(allocateQueryHolder, target);
                }
            });
            i4 = allocateQueryHolder.f30620b;
            b4 = allocateQueryHolder.f30619a;
        }
        if (this.f30616k.get(i4) == null) {
            this.f30616k.put(i4, b4);
            this.f30617l.put(target, Integer.valueOf(i4));
        }
        return b4;
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments(final ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap, String str) {
        final TargetData allocateTarget = allocateTarget(O(str));
        return (ImmutableSortedMap) this.f30606a.h("Apply bundle documents", new Supplier() { // from class: com.google.firebase.firestore.local.r
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                ImmutableSortedMap y3;
                y3 = LocalStore.this.y(immutableSortedMap, allocateTarget);
                return y3;
            }
        });
    }

    public ImmutableSortedMap<DocumentKey, Document> applyRemoteEvent(final RemoteEvent remoteEvent) {
        final SnapshotVersion snapshotVersion = remoteEvent.getSnapshotVersion();
        return (ImmutableSortedMap) this.f30606a.h("Apply remote event", new Supplier() { // from class: com.google.firebase.firestore.local.o
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                ImmutableSortedMap z3;
                z3 = LocalStore.this.z(remoteEvent, snapshotVersion);
                return z3;
            }
        });
    }

    public LruGarbageCollector.Results collectGarbage(final LruGarbageCollector lruGarbageCollector) {
        return (LruGarbageCollector.Results) this.f30606a.h("Collect garbage", new Supplier() { // from class: com.google.firebase.firestore.local.w
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                LruGarbageCollector.Results A;
                A = LocalStore.this.A(lruGarbageCollector);
                return A;
            }
        });
    }

    public void configureFieldIndexes(final List<FieldIndex> list) {
        this.f30606a.i("Configure indexes", new Runnable() { // from class: com.google.firebase.firestore.local.x
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.B(list);
            }
        });
    }

    public void deleteAllFieldIndexes() {
        this.f30606a.i("Delete All Indexes", new Runnable() { // from class: com.google.firebase.firestore.local.s
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.C();
            }
        });
    }

    public QueryResult executeQuery(Query query, boolean z3) {
        ImmutableSortedSet<DocumentKey> immutableSortedSet;
        SnapshotVersion snapshotVersion;
        TargetData u3 = u(query.toTarget());
        SnapshotVersion snapshotVersion2 = SnapshotVersion.NONE;
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        if (u3 != null) {
            snapshotVersion = u3.getLastLimboFreeSnapshotVersion();
            immutableSortedSet = this.f30614i.h(u3.getTargetId());
        } else {
            immutableSortedSet = emptyKeySet;
            snapshotVersion = snapshotVersion2;
        }
        QueryEngine queryEngine = this.f30612g;
        if (z3) {
            snapshotVersion2 = snapshotVersion;
        }
        return new QueryResult(queryEngine.getDocumentsMatchingQuery(query, snapshotVersion2, immutableSortedSet), immutableSortedSet);
    }

    public int getHighestUnacknowledgedBatchId() {
        return this.f30608c.g();
    }

    public IndexManager getIndexManagerForCurrentUser() {
        return this.f30607b;
    }

    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.f30614i.getLastRemoteSnapshotVersion();
    }

    public ByteString getLastStreamToken() {
        return this.f30608c.getLastStreamToken();
    }

    public LocalDocumentsView getLocalDocumentsForCurrentUser() {
        return this.f30611f;
    }

    @Nullable
    public NamedQuery getNamedQuery(final String str) {
        return (NamedQuery) this.f30606a.h("Get named query", new Supplier() { // from class: com.google.firebase.firestore.local.n
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                NamedQuery D;
                D = LocalStore.this.D(str);
                return D;
            }
        });
    }

    @Nullable
    public MutationBatch getNextMutationBatch(int i4) {
        return this.f30608c.c(i4);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int i4) {
        return this.f30614i.h(i4);
    }

    public ImmutableSortedMap<DocumentKey, Document> handleUserChange(User user) {
        List<MutationBatch> j4 = this.f30608c.j();
        v(user);
        R();
        S();
        List<MutationBatch> j5 = this.f30608c.j();
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        for (List<MutationBatch> list : Arrays.asList(j4, j5)) {
            for (MutationBatch mutationBatch : list) {
                for (Mutation mutation : mutationBatch.getMutations()) {
                    emptyKeySet = emptyKeySet.insert(mutation.getKey());
                }
            }
        }
        return this.f30611f.d(emptyKeySet);
    }

    public boolean hasNewerBundle(final BundleMetadata bundleMetadata) {
        return ((Boolean) this.f30606a.h("Has newer bundle", new Supplier() { // from class: com.google.firebase.firestore.local.m
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                Boolean E;
                E = LocalStore.this.E(bundleMetadata);
                return E;
            }
        })).booleanValue();
    }

    public void notifyLocalViewChanges(final List<LocalViewChanges> list) {
        this.f30606a.i("notifyLocalViewChanges", new Runnable() { // from class: com.google.firebase.firestore.local.t
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.F(list);
            }
        });
    }

    public Document readDocument(DocumentKey documentKey) {
        return this.f30611f.c(documentKey);
    }

    public ImmutableSortedMap<DocumentKey, Document> rejectBatch(final int i4) {
        return (ImmutableSortedMap) this.f30606a.h("Reject batch", new Supplier() { // from class: com.google.firebase.firestore.local.g
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                ImmutableSortedMap G;
                G = LocalStore.this.G(i4);
                return G;
            }
        });
    }

    public void releaseTarget(final int i4) {
        this.f30606a.i("Release target", new Runnable() { // from class: com.google.firebase.firestore.local.y
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.H(i4);
            }
        });
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void saveBundle(final BundleMetadata bundleMetadata) {
        this.f30606a.i("Save bundle", new Runnable() { // from class: com.google.firebase.firestore.local.u
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.I(bundleMetadata);
            }
        });
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void saveNamedQuery(final NamedQuery namedQuery, final ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        final TargetData allocateTarget = allocateTarget(namedQuery.getBundledQuery().getTarget());
        final int targetId = allocateTarget.getTargetId();
        this.f30606a.i("Saved named query", new Runnable() { // from class: com.google.firebase.firestore.local.j
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.J(namedQuery, allocateTarget, targetId, immutableSortedSet);
            }
        });
    }

    public void setIndexAutoCreationEnabled(boolean z3) {
        this.f30612g.setIndexAutoCreationEnabled(z3);
    }

    public void setLastStreamToken(final ByteString byteString) {
        this.f30606a.i("Set stream token", new Runnable() { // from class: com.google.firebase.firestore.local.k
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.this.K(byteString);
            }
        });
    }

    public void start() {
        this.f30606a.e().run();
        R();
        S();
    }

    @Nullable
    @VisibleForTesting
    TargetData u(Target target) {
        Integer num = this.f30617l.get(target);
        if (num != null) {
            return this.f30616k.get(num.intValue());
        }
        return this.f30614i.b(target);
    }

    public LocalDocumentsResult writeLocally(final List<Mutation> list) {
        final Timestamp now = Timestamp.now();
        final HashSet hashSet = new HashSet();
        for (Mutation mutation : list) {
            hashSet.add(mutation.getKey());
        }
        return (LocalDocumentsResult) this.f30606a.h("Locally write mutations", new Supplier() { // from class: com.google.firebase.firestore.local.i
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                LocalDocumentsResult N;
                N = LocalStore.this.N(hashSet, list, now);
                return N;
            }
        });
    }
}
