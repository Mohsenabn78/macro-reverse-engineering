package com.google.firebase.firestore.local;

import android.database.Cursor;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Overlay;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firestore.v1.Write;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* loaded from: classes5.dex */
public class SQLiteDocumentOverlayCache implements DocumentOverlayCache {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30705a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30706b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30707c;

    public SQLiteDocumentOverlayCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        String str;
        this.f30705a = sQLitePersistence;
        this.f30706b = localSerializer;
        if (user.isAuthenticated()) {
            str = user.getUid();
        } else {
            str = "";
        }
        this.f30707c = str;
    }

    private Overlay g(byte[] bArr, int i4) {
        try {
            return Overlay.create(i4, this.f30706b.decodeMutation(Write.parseFrom(bArr)));
        } catch (InvalidProtocolBufferException e4) {
            throw Assert.fail("Overlay failed to parse: %s", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Overlay h(Cursor cursor) {
        return g(cursor.getBlob(0), cursor.getInt(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int[] iArr, String[] strArr, String[] strArr2, BackgroundQueue backgroundQueue, Map map, Cursor cursor) {
        iArr[0] = cursor.getInt(1);
        strArr[0] = cursor.getString(2);
        strArr2[0] = cursor.getString(3);
        m(backgroundQueue, map, cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(byte[] bArr, int i4, Map map) {
        Overlay g4 = g(bArr, i4);
        synchronized (map) {
            map.put(g4.getKey(), g4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.concurrent.Executor] */
    /* renamed from: n */
    public void m(BackgroundQueue backgroundQueue, final Map<DocumentKey, Overlay> map, Cursor cursor) {
        final byte[] blob = cursor.getBlob(0);
        final int i4 = cursor.getInt(1);
        BackgroundQueue backgroundQueue2 = backgroundQueue;
        if (cursor.isLast()) {
            backgroundQueue2 = Executors.DIRECT_EXECUTOR;
        }
        backgroundQueue2.execute(new Runnable() { // from class: com.google.firebase.firestore.local.m0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteDocumentOverlayCache.this.l(blob, i4, map);
            }
        });
    }

    private void o(final Map<DocumentKey, Overlay> map, final BackgroundQueue backgroundQueue, ResourcePath resourcePath, List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.f30705a, "SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id IN (", Arrays.asList(this.f30707c, EncodedPath.c(resourcePath)), list, ")");
        while (longQuery.d()) {
            longQuery.e().e(new Consumer() { // from class: com.google.firebase.firestore.local.i0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteDocumentOverlayCache.this.m(backgroundQueue, map, (Cursor) obj);
                }
            });
        }
    }

    private void p(int i4, DocumentKey documentKey, Mutation mutation) {
        this.f30705a.p("INSERT OR REPLACE INTO document_overlays (uid, collection_group, collection_path, document_id, largest_batch_id, overlay_mutation) VALUES (?, ?, ?, ?, ?, ?)", this.f30707c, documentKey.getCollectionGroup(), EncodedPath.c(documentKey.getPath().popLast()), documentKey.getPath().getLastSegment(), Integer.valueOf(i4), this.f30706b.encodeMutation(mutation).toByteArray());
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    @Nullable
    public Overlay getOverlay(DocumentKey documentKey) {
        return (Overlay) this.f30705a.x("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id = ?").b(this.f30707c, EncodedPath.c(documentKey.getPath().popLast()), documentKey.getPath().getLastSegment()).d(new Function() { // from class: com.google.firebase.firestore.local.h0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Overlay h4;
                h4 = SQLiteDocumentOverlayCache.this.h((Cursor) obj);
                return h4;
            }
        });
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(SortedSet<DocumentKey> sortedSet) {
        Assert.hardAssert(sortedSet.comparator() == null, "getOverlays() requires natural order", new Object[0]);
        HashMap hashMap = new HashMap();
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        ResourcePath resourcePath = ResourcePath.EMPTY;
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : sortedSet) {
            if (!resourcePath.equals(documentKey.getCollectionPath())) {
                o(hashMap, backgroundQueue, resourcePath, arrayList);
                resourcePath = documentKey.getCollectionPath();
                arrayList.clear();
            }
            arrayList.add(documentKey.getDocumentId());
        }
        o(hashMap, backgroundQueue, resourcePath, arrayList);
        backgroundQueue.drain();
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void removeOverlaysForBatchId(int i4) {
        this.f30705a.p("DELETE FROM document_overlays WHERE uid = ? AND largest_batch_id = ?", this.f30707c, Integer.valueOf(i4));
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void saveOverlays(int i4, Map<DocumentKey, Mutation> map) {
        for (Map.Entry<DocumentKey, Mutation> entry : map.entrySet()) {
            DocumentKey key = entry.getKey();
            p(i4, key, (Mutation) Preconditions.checkNotNull(entry.getValue(), "null value for key: %s", key));
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(ResourcePath resourcePath, int i4) {
        final HashMap hashMap = new HashMap();
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        this.f30705a.x("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND largest_batch_id > ?").b(this.f30707c, EncodedPath.c(resourcePath), Integer.valueOf(i4)).e(new Consumer() { // from class: com.google.firebase.firestore.local.j0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteDocumentOverlayCache.this.i(backgroundQueue, hashMap, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(String str, int i4, int i5) {
        final HashMap hashMap = new HashMap();
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final int[] iArr = new int[1];
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        this.f30705a.x("SELECT overlay_mutation, largest_batch_id, collection_path, document_id  FROM document_overlays WHERE uid = ? AND collection_group = ? AND largest_batch_id > ? ORDER BY largest_batch_id, collection_path, document_id LIMIT ?").b(this.f30707c, str, Integer.valueOf(i4), Integer.valueOf(i5)).e(new Consumer() { // from class: com.google.firebase.firestore.local.k0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteDocumentOverlayCache.this.j(iArr, strArr, strArr2, backgroundQueue, hashMap, (Cursor) obj);
            }
        });
        if (strArr[0] == null) {
            return hashMap;
        }
        SQLitePersistence.Query x3 = this.f30705a.x("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_group = ? AND (collection_path > ? OR (collection_path = ? AND document_id > ?)) AND largest_batch_id = ?");
        String str2 = strArr[0];
        x3.b(this.f30707c, str, str2, str2, strArr2[0], Integer.valueOf(iArr[0])).e(new Consumer() { // from class: com.google.firebase.firestore.local.l0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteDocumentOverlayCache.this.k(backgroundQueue, hashMap, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return hashMap;
    }
}
