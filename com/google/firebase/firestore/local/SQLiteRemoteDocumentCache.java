package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30755a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30756b;

    /* renamed from: c  reason: collision with root package name */
    private IndexManager f30757c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteRemoteDocumentCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.f30755a = sQLitePersistence;
        this.f30756b = localSerializer;
    }

    private MutableDocument j(byte[] bArr, int i4, int i5) {
        try {
            return this.f30756b.b(MaybeDocument.parseFrom(bArr)).setReadTime(new SnapshotVersion(new Timestamp(i4, i5)));
        } catch (InvalidProtocolBufferException e4) {
            throw Assert.fail("MaybeDocument failed to parse: %s", e4);
        }
    }

    private Map<DocumentKey, MutableDocument> k(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i4, @Nullable Function<MutableDocument, Boolean> function) {
        return l(list, indexOffset, i4, function, null);
    }

    private Map<DocumentKey, MutableDocument> l(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i4, @Nullable final Function<MutableDocument, Boolean> function, @Nullable final QueryContext queryContext) {
        Timestamp timestamp = indexOffset.getReadTime().getTimestamp();
        DocumentKey documentKey = indexOffset.getDocumentKey();
        StringBuilder repeatSequence = Util.repeatSequence("SELECT contents, read_time_seconds, read_time_nanos, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ", list.size(), " UNION ");
        repeatSequence.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        Object[] objArr = new Object[(list.size() * 9) + 1];
        int i5 = 0;
        for (ResourcePath resourcePath : list) {
            String c4 = EncodedPath.c(resourcePath);
            int i6 = i5 + 1;
            objArr[i5] = c4;
            int i7 = i6 + 1;
            objArr[i6] = EncodedPath.f(c4);
            int i8 = i7 + 1;
            objArr[i7] = Integer.valueOf(resourcePath.length() + 1);
            int i9 = i8 + 1;
            objArr[i8] = Long.valueOf(timestamp.getSeconds());
            int i10 = i9 + 1;
            objArr[i9] = Long.valueOf(timestamp.getSeconds());
            int i11 = i10 + 1;
            objArr[i10] = Integer.valueOf(timestamp.getNanoseconds());
            int i12 = i11 + 1;
            objArr[i11] = Long.valueOf(timestamp.getSeconds());
            int i13 = i12 + 1;
            objArr[i12] = Integer.valueOf(timestamp.getNanoseconds());
            objArr[i13] = EncodedPath.c(documentKey.getPath());
            i5 = i13 + 1;
        }
        objArr[i5] = Integer.valueOf(i4);
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        final HashMap hashMap = new HashMap();
        this.f30755a.x(repeatSequence.toString()).b(objArr).e(new Consumer() { // from class: com.google.firebase.firestore.local.q1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteRemoteDocumentCache.this.n(backgroundQueue, hashMap, function, queryContext, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(BackgroundQueue backgroundQueue, Map map, Cursor cursor) {
        q(backgroundQueue, map, cursor, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BackgroundQueue backgroundQueue, Map map, Function function, QueryContext queryContext, Cursor cursor) {
        q(backgroundQueue, map, cursor, function);
        if (queryContext != null) {
            queryContext.incrementDocumentReadCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean o(Query query, Set set, MutableDocument mutableDocument) {
        boolean z3;
        if (!query.matches(mutableDocument) && !set.contains(mutableDocument.getKey())) {
            z3 = false;
        } else {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(byte[] bArr, int i4, int i5, Function function, Map map) {
        MutableDocument j4 = j(bArr, i4, i5);
        if (function == null || ((Boolean) function.apply(j4)).booleanValue()) {
            synchronized (map) {
                map.put(j4.getKey(), j4);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.concurrent.Executor] */
    private void q(BackgroundQueue backgroundQueue, final Map<DocumentKey, MutableDocument> map, Cursor cursor, @Nullable final Function<MutableDocument, Boolean> function) {
        final byte[] blob = cursor.getBlob(0);
        final int i4 = cursor.getInt(1);
        final int i5 = cursor.getInt(2);
        BackgroundQueue backgroundQueue2 = backgroundQueue;
        if (cursor.isLast()) {
            backgroundQueue2 = Executors.DIRECT_EXECUTOR;
        }
        backgroundQueue2.execute(new Runnable() { // from class: com.google.firebase.firestore.local.r1
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteRemoteDocumentCache.this.p(blob, i4, i5, function, map);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument a(DocumentKey documentKey) {
        return getAll(Collections.singletonList(documentKey)).get(documentKey);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> b(String str, FieldIndex.IndexOffset indexOffset, int i4) {
        List<ResourcePath> collectionParents = this.f30757c.getCollectionParents(str);
        ArrayList arrayList = new ArrayList(collectionParents.size());
        for (ResourcePath resourcePath : collectionParents) {
            arrayList.add(resourcePath.append(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyMap();
        }
        if (arrayList.size() * 9 < 900) {
            return k(arrayList, indexOffset, i4, null);
        }
        HashMap hashMap = new HashMap();
        int i5 = 0;
        while (i5 < arrayList.size()) {
            int i6 = i5 + 100;
            hashMap.putAll(k(arrayList.subList(i5, Math.min(arrayList.size(), i6)), indexOffset, i4, null));
            i5 = i6;
        }
        return Util.firstNEntries(hashMap, i4, FieldIndex.IndexOffset.DOCUMENT_COMPARATOR);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> c(final Query query, FieldIndex.IndexOffset indexOffset, @Nonnull final Set<DocumentKey> set, @Nullable QueryContext queryContext) {
        return l(Collections.singletonList(query.getPath()), indexOffset, Integer.MAX_VALUE, new Function() { // from class: com.google.firebase.firestore.local.o1
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Boolean o4;
                o4 = SQLiteRemoteDocumentCache.o(Query.this, set, (MutableDocument) obj);
                return o4;
            }
        }, queryContext);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void d(MutableDocument mutableDocument, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        DocumentKey key = mutableDocument.getKey();
        Timestamp timestamp = snapshotVersion.getTimestamp();
        this.f30755a.p("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?, ?)", EncodedPath.c(key.getPath()), Integer.valueOf(key.getPath().length()), Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), this.f30756b.h(mutableDocument).toByteArray());
        this.f30757c.addToCollectionParentIndex(mutableDocument.getKey().getCollectionPath());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void e(IndexManager indexManager) {
        this.f30757c = indexManager;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        final HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : iterable) {
            arrayList.add(EncodedPath.c(documentKey.getPath()));
            hashMap.put(documentKey, MutableDocument.newInvalidDocument(documentKey));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.f30755a, "SELECT contents, read_time_seconds, read_time_nanos FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        while (longQuery.d()) {
            longQuery.e().e(new Consumer() { // from class: com.google.firebase.firestore.local.p1
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteRemoteDocumentCache.this.m(backgroundQueue, hashMap, (Cursor) obj);
                }
            });
        }
        backgroundQueue.drain();
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void removeAll(Collection<DocumentKey> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (DocumentKey documentKey : collection) {
            arrayList.add(EncodedPath.c(documentKey.getPath()));
            emptyDocumentMap = emptyDocumentMap.insert(documentKey, MutableDocument.newNoDocument(documentKey, SnapshotVersion.NONE));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.f30755a, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
        while (longQuery.d()) {
            longQuery.a();
        }
        this.f30757c.updateIndexEntries(emptyDocumentMap);
    }
}
