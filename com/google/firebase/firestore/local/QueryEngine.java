package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.IndexManager;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class QueryEngine {

    /* renamed from: a  reason: collision with root package name */
    private LocalDocumentsView f30692a;

    /* renamed from: b  reason: collision with root package name */
    private IndexManager f30693b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30694c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30695d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f30696e = 100;

    /* renamed from: f  reason: collision with root package name */
    private double f30697f = 2.0d;

    private ImmutableSortedMap<DocumentKey, Document> a(Iterable<Document> iterable, Query query, FieldIndex.IndexOffset indexOffset) {
        ImmutableSortedMap<DocumentKey, Document> h4 = this.f30692a.h(query, indexOffset);
        for (Document document : iterable) {
            h4 = h4.insert(document.getKey(), document);
        }
        return h4;
    }

    private ImmutableSortedSet<Document> b(Query query, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        ImmutableSortedSet<Document> immutableSortedSet = new ImmutableSortedSet<>(Collections.emptyList(), query.comparator());
        Iterator<Map.Entry<DocumentKey, Document>> it = immutableSortedMap.iterator();
        while (it.hasNext()) {
            Document value = it.next().getValue();
            if (query.matches(value)) {
                immutableSortedSet = immutableSortedSet.insert(value);
            }
        }
        return immutableSortedSet;
    }

    private void c(Query query, QueryContext queryContext, int i4) {
        if (queryContext.getDocumentReadCount() < this.f30696e) {
            Logger.debug("QueryEngine", "SDK will not create cache indexes for query: %s, since it only creates cache indexes for collection contains more than or equal to %s documents.", query.toString(), Integer.valueOf(this.f30696e));
            return;
        }
        Logger.debug("QueryEngine", "Query: %s, scans %s local documents and returns %s documents as results.", query.toString(), Integer.valueOf(queryContext.getDocumentReadCount()), Integer.valueOf(i4));
        if (queryContext.getDocumentReadCount() > this.f30697f * i4) {
            this.f30693b.createTargetIndexes(query.toTarget());
            Logger.debug("QueryEngine", "The SDK decides to create cache indexes for query: %s, as using cache indexes may help improve performance.", query.toString());
            return;
        }
        Logger.debug("QueryEngine", "The SDK decides not to create cache indexes for this query: %s, as using cache indexes may not help improve performance.", query.toString());
    }

    private ImmutableSortedMap<DocumentKey, Document> d(Query query, QueryContext queryContext) {
        if (Logger.isDebugEnabled()) {
            Logger.debug("QueryEngine", "Using full collection scan to execute query: %s", query.toString());
        }
        return this.f30692a.i(query, FieldIndex.IndexOffset.NONE, queryContext);
    }

    private boolean e(Query query, int i4, ImmutableSortedSet<Document> immutableSortedSet, SnapshotVersion snapshotVersion) {
        Document minEntry;
        if (!query.hasLimit()) {
            return false;
        }
        if (i4 != immutableSortedSet.size()) {
            return true;
        }
        if (query.getLimitType() == Query.LimitType.LIMIT_TO_FIRST) {
            minEntry = immutableSortedSet.getMaxEntry();
        } else {
            minEntry = immutableSortedSet.getMinEntry();
        }
        if (minEntry == null) {
            return false;
        }
        if (!minEntry.hasPendingWrites() && minEntry.getVersion().compareTo(snapshotVersion) <= 0) {
            return false;
        }
        return true;
    }

    @Nullable
    private ImmutableSortedMap<DocumentKey, Document> f(Query query) {
        boolean z3;
        if (query.matchesAllDocuments()) {
            return null;
        }
        Target target = query.toTarget();
        IndexManager.IndexType indexType = this.f30693b.getIndexType(target);
        if (indexType.equals(IndexManager.IndexType.NONE)) {
            return null;
        }
        if (query.hasLimit() && indexType.equals(IndexManager.IndexType.PARTIAL)) {
            return f(query.limitToFirst(-1L));
        }
        List<DocumentKey> documentsMatchingTarget = this.f30693b.getDocumentsMatchingTarget(target);
        if (documentsMatchingTarget != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "index manager must return results for partial and full indexes.", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> d4 = this.f30692a.d(documentsMatchingTarget);
        FieldIndex.IndexOffset minOffset = this.f30693b.getMinOffset(target);
        ImmutableSortedSet<Document> b4 = b(query, d4);
        if (e(query, documentsMatchingTarget.size(), b4, minOffset.getReadTime())) {
            return f(query.limitToFirst(-1L));
        }
        return a(b4, query, minOffset);
    }

    @Nullable
    private ImmutableSortedMap<DocumentKey, Document> g(Query query, ImmutableSortedSet<DocumentKey> immutableSortedSet, SnapshotVersion snapshotVersion) {
        if (query.matchesAllDocuments() || snapshotVersion.equals(SnapshotVersion.NONE)) {
            return null;
        }
        ImmutableSortedSet<Document> b4 = b(query, this.f30692a.d(immutableSortedSet));
        if (e(query, immutableSortedSet.size(), b4, snapshotVersion)) {
            return null;
        }
        if (Logger.isDebugEnabled()) {
            Logger.debug("QueryEngine", "Re-using previous result from %s to execute query: %s", snapshotVersion.toString(), query.toString());
        }
        return a(b4, query, FieldIndex.IndexOffset.createSuccessor(snapshotVersion, -1));
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        Assert.hardAssert(this.f30694c, "initialize() not called", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> f4 = f(query);
        if (f4 != null) {
            return f4;
        }
        ImmutableSortedMap<DocumentKey, Document> g4 = g(query, immutableSortedSet, snapshotVersion);
        if (g4 != null) {
            return g4;
        }
        QueryContext queryContext = new QueryContext();
        ImmutableSortedMap<DocumentKey, Document> d4 = d(query, queryContext);
        if (d4 != null && this.f30695d) {
            c(query, queryContext, d4.size());
        }
        return d4;
    }

    public void initialize(LocalDocumentsView localDocumentsView, IndexManager indexManager) {
        this.f30692a = localDocumentsView;
        this.f30693b = indexManager;
        this.f30694c = true;
    }

    public void setIndexAutoCreationEnabled(boolean z3) {
        this.f30695d = z3;
    }
}
