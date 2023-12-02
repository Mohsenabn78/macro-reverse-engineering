package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.BloomFilter;
import com.google.firebase.firestore.remote.TestingHooks;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class WatchChangeAggregator {

    /* renamed from: a  reason: collision with root package name */
    private final TargetMetadataProvider f31186a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, TargetState> f31187b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<DocumentKey, MutableDocument> f31188c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<DocumentKey, Set<Integer>> f31189d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, QueryPurpose> f31190e = new HashMap();

    /* renamed from: com.google.firebase.firestore.remote.WatchChangeAggregator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31191a;

        static {
            int[] iArr = new int[WatchChange.WatchTargetChangeType.values().length];
            f31191a = iArr;
            try {
                iArr[WatchChange.WatchTargetChangeType.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31191a[WatchChange.WatchTargetChangeType.Added.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31191a[WatchChange.WatchTargetChangeType.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31191a[WatchChange.WatchTargetChangeType.Current.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31191a[WatchChange.WatchTargetChangeType.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum BloomFilterApplicationStatus {
        SUCCESS,
        SKIPPED,
        FALSE_POSITIVE
    }

    /* loaded from: classes5.dex */
    public interface TargetMetadataProvider {
        DatabaseId getDatabaseId();

        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4);

        @Nullable
        TargetData getTargetDataForTarget(int i4);
    }

    public WatchChangeAggregator(TargetMetadataProvider targetMetadataProvider) {
        this.f31186a = targetMetadataProvider;
    }

    private void a(int i4, MutableDocument mutableDocument) {
        DocumentViewChange.Type type;
        if (!h(i4)) {
            return;
        }
        if (o(i4, mutableDocument.getKey())) {
            type = DocumentViewChange.Type.MODIFIED;
        } else {
            type = DocumentViewChange.Type.ADDED;
        }
        d(i4).a(mutableDocument.getKey(), type);
        this.f31188c.put(mutableDocument.getKey(), mutableDocument);
        c(mutableDocument.getKey()).add(Integer.valueOf(i4));
    }

    private BloomFilterApplicationStatus b(BloomFilter bloomFilter, WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange, int i4) {
        if (existenceFilterWatchChange.getExistenceFilter().getCount() == i4 - e(bloomFilter, existenceFilterWatchChange.getTargetId())) {
            return BloomFilterApplicationStatus.SUCCESS;
        }
        return BloomFilterApplicationStatus.FALSE_POSITIVE;
    }

    private Set<Integer> c(DocumentKey documentKey) {
        Set<Integer> set = this.f31189d.get(documentKey);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.f31189d.put(documentKey, hashSet);
            return hashSet;
        }
        return set;
    }

    private TargetState d(int i4) {
        TargetState targetState = this.f31187b.get(Integer.valueOf(i4));
        if (targetState == null) {
            TargetState targetState2 = new TargetState();
            this.f31187b.put(Integer.valueOf(i4), targetState2);
            return targetState2;
        }
        return targetState;
    }

    private int e(BloomFilter bloomFilter, int i4) {
        Iterator<DocumentKey> it = this.f31186a.getRemoteKeysForTarget(i4).iterator();
        int i5 = 0;
        while (it.hasNext()) {
            DocumentKey next = it.next();
            DatabaseId databaseId = this.f31186a.getDatabaseId();
            if (!bloomFilter.mightContain("projects/" + databaseId.getProjectId() + "/databases/" + databaseId.getDatabaseId() + "/documents/" + next.getPath().canonicalString())) {
                l(i4, next, null);
                i5++;
            }
        }
        return i5;
    }

    private int f(int i4) {
        TargetChange j4 = d(i4).j();
        return (this.f31186a.getRemoteKeysForTarget(i4).size() + j4.getAddedDocuments().size()) - j4.getRemovedDocuments().size();
    }

    private Collection<Integer> g(WatchChange.WatchTargetChange watchTargetChange) {
        List<Integer> targetIds = watchTargetChange.getTargetIds();
        if (!targetIds.isEmpty()) {
            return targetIds;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.f31187b.keySet()) {
            if (h(num.intValue())) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    private boolean h(int i4) {
        if (j(i4) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    private BloomFilter i(WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange) {
        com.google.firestore.v1.BloomFilter unchangedNames = existenceFilterWatchChange.getExistenceFilter().getUnchangedNames();
        if (unchangedNames != null && unchangedNames.hasBits()) {
            try {
                BloomFilter create = BloomFilter.create(unchangedNames.getBits().getBitmap(), unchangedNames.getBits().getPadding(), unchangedNames.getHashCount());
                if (create.b() == 0) {
                    return null;
                }
                return create;
            } catch (BloomFilter.BloomFilterCreateException e4) {
                Logger.warn("WatchChangeAggregator", "Applying bloom filter failed: (" + e4.getMessage() + "); ignoring the bloom filter and falling back to full re-query.", new Object[0]);
            }
        }
        return null;
    }

    @Nullable
    private TargetData j(int i4) {
        TargetState targetState = this.f31187b.get(Integer.valueOf(i4));
        if (targetState != null && targetState.e()) {
            return null;
        }
        return this.f31186a.getTargetDataForTarget(i4);
    }

    private void l(int i4, DocumentKey documentKey, @Nullable MutableDocument mutableDocument) {
        if (!h(i4)) {
            return;
        }
        TargetState d4 = d(i4);
        if (o(i4, documentKey)) {
            d4.a(documentKey, DocumentViewChange.Type.REMOVED);
        } else {
            d4.i(documentKey);
        }
        c(documentKey).add(Integer.valueOf(i4));
        if (mutableDocument != null) {
            this.f31188c.put(documentKey, mutableDocument);
        }
    }

    private void n(int i4) {
        boolean z3;
        if (this.f31187b.get(Integer.valueOf(i4)) != null && !this.f31187b.get(Integer.valueOf(i4)).e()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Should only reset active targets", new Object[0]);
        this.f31187b.put(Integer.valueOf(i4), new TargetState());
        Iterator<DocumentKey> it = this.f31186a.getRemoteKeysForTarget(i4).iterator();
        while (it.hasNext()) {
            l(i4, it.next(), null);
        }
    }

    private boolean o(int i4, DocumentKey documentKey) {
        return this.f31186a.getRemoteKeysForTarget(i4).contains(documentKey);
    }

    public RemoteEvent createRemoteEvent(SnapshotVersion snapshotVersion) {
        boolean z3;
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, TargetState> entry : this.f31187b.entrySet()) {
            int intValue = entry.getKey().intValue();
            TargetState value = entry.getValue();
            TargetData j4 = j(intValue);
            if (j4 != null) {
                if (value.d() && j4.getTarget().isDocumentQuery()) {
                    DocumentKey fromPath = DocumentKey.fromPath(j4.getTarget().getPath());
                    if (this.f31188c.get(fromPath) == null && !o(intValue, fromPath)) {
                        l(intValue, fromPath, MutableDocument.newNoDocument(fromPath, snapshotVersion));
                    }
                }
                if (value.c()) {
                    hashMap.put(Integer.valueOf(intValue), value.j());
                    value.b();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<DocumentKey, Set<Integer>> entry2 : this.f31189d.entrySet()) {
            DocumentKey key = entry2.getKey();
            Iterator<Integer> it = entry2.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    TargetData j5 = j(it.next().intValue());
                    if (j5 != null && !j5.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
                        z3 = false;
                        break;
                    }
                } else {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                hashSet.add(key);
            }
        }
        for (MutableDocument mutableDocument : this.f31188c.values()) {
            mutableDocument.setReadTime(snapshotVersion);
        }
        RemoteEvent remoteEvent = new RemoteEvent(snapshotVersion, Collections.unmodifiableMap(hashMap), Collections.unmodifiableMap(this.f31190e), Collections.unmodifiableMap(this.f31188c), Collections.unmodifiableSet(hashSet));
        this.f31188c = new HashMap();
        this.f31189d = new HashMap();
        this.f31190e = new HashMap();
        return remoteEvent;
    }

    public void handleDocumentChange(WatchChange.DocumentChange documentChange) {
        MutableDocument newDocument = documentChange.getNewDocument();
        DocumentKey documentKey = documentChange.getDocumentKey();
        for (Integer num : documentChange.getUpdatedTargetIds()) {
            int intValue = num.intValue();
            if (newDocument != null && newDocument.isFoundDocument()) {
                a(intValue, newDocument);
            } else {
                l(intValue, documentKey, newDocument);
            }
        }
        for (Integer num2 : documentChange.getRemovedTargetIds()) {
            l(num2.intValue(), documentKey, documentChange.getNewDocument());
        }
    }

    public void handleExistenceFilter(WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange) {
        BloomFilterApplicationStatus bloomFilterApplicationStatus;
        QueryPurpose queryPurpose;
        boolean z3;
        int targetId = existenceFilterWatchChange.getTargetId();
        int count = existenceFilterWatchChange.getExistenceFilter().getCount();
        TargetData j4 = j(targetId);
        if (j4 != null) {
            Target target = j4.getTarget();
            if (target.isDocumentQuery()) {
                if (count == 0) {
                    DocumentKey fromPath = DocumentKey.fromPath(target.getPath());
                    l(targetId, fromPath, MutableDocument.newNoDocument(fromPath, SnapshotVersion.NONE));
                    return;
                }
                if (count == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assert.hardAssert(z3, "Single document existence filter with count: %d", Integer.valueOf(count));
                return;
            }
            int f4 = f(targetId);
            if (f4 != count) {
                BloomFilter i4 = i(existenceFilterWatchChange);
                if (i4 != null) {
                    bloomFilterApplicationStatus = b(i4, existenceFilterWatchChange, f4);
                } else {
                    bloomFilterApplicationStatus = BloomFilterApplicationStatus.SKIPPED;
                }
                if (bloomFilterApplicationStatus != BloomFilterApplicationStatus.SUCCESS) {
                    n(targetId);
                    if (bloomFilterApplicationStatus == BloomFilterApplicationStatus.FALSE_POSITIVE) {
                        queryPurpose = QueryPurpose.EXISTENCE_FILTER_MISMATCH_BLOOM;
                    } else {
                        queryPurpose = QueryPurpose.EXISTENCE_FILTER_MISMATCH;
                    }
                    this.f31190e.put(Integer.valueOf(targetId), queryPurpose);
                }
                TestingHooks.a().b(TestingHooks.ExistenceFilterMismatchInfo.e(f4, existenceFilterWatchChange.getExistenceFilter(), this.f31186a.getDatabaseId(), i4, bloomFilterApplicationStatus));
            }
        }
    }

    public void handleTargetChange(WatchChange.WatchTargetChange watchTargetChange) {
        for (Integer num : g(watchTargetChange)) {
            int intValue = num.intValue();
            TargetState d4 = d(intValue);
            int i4 = AnonymousClass1.f31191a[watchTargetChange.getChangeType().ordinal()];
            boolean z3 = true;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                if (h(intValue)) {
                                    n(intValue);
                                    d4.k(watchTargetChange.getResumeToken());
                                }
                            } else {
                                throw Assert.fail("Unknown target watch change state: %s", watchTargetChange.getChangeType());
                            }
                        } else if (h(intValue)) {
                            d4.f();
                            d4.k(watchTargetChange.getResumeToken());
                        }
                    } else {
                        d4.h();
                        if (!d4.e()) {
                            m(intValue);
                        }
                        if (watchTargetChange.getCause() != null) {
                            z3 = false;
                        }
                        Assert.hardAssert(z3, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                    }
                } else {
                    d4.h();
                    if (!d4.e()) {
                        d4.b();
                    }
                    d4.k(watchTargetChange.getResumeToken());
                }
            } else if (h(intValue)) {
                d4.k(watchTargetChange.getResumeToken());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i4) {
        d(i4).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i4) {
        this.f31187b.remove(Integer.valueOf(i4));
    }
}
