package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.time.DurationKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SQLiteMutationQueue implements MutationQueue {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30725a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30726b;

    /* renamed from: c  reason: collision with root package name */
    private final IndexManager f30727c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30728d;

    /* renamed from: e  reason: collision with root package name */
    private int f30729e;

    /* renamed from: f  reason: collision with root package name */
    private ByteString f30730f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class BlobAccumulator implements Consumer<Cursor> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<ByteString> f30731a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private boolean f30732b = true;

        BlobAccumulator(byte[] bArr) {
            c(bArr);
        }

        private void c(byte[] bArr) {
            this.f30731a.add(ByteString.copyFrom(bArr));
        }

        @Override // com.google.firebase.firestore.util.Consumer
        /* renamed from: a */
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            c(blob);
            if (blob.length < 1000000) {
                this.f30732b = false;
            }
        }

        int d() {
            return this.f30731a.size();
        }

        ByteString e() {
            return ByteString.copyFrom(this.f30731a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteMutationQueue(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user, IndexManager indexManager) {
        String str;
        this.f30725a = sQLitePersistence;
        this.f30726b = localSerializer;
        if (user.isAuthenticated()) {
            str = user.getUid();
        } else {
            str = "";
        }
        this.f30728d = str;
        this.f30730f = WriteStream.EMPTY_STREAM_TOKEN;
        this.f30727c = indexManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MutationBatch A(Cursor cursor) {
        return u(cursor.getInt(0), cursor.getBlob(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(List list, Cursor cursor) {
        list.add(cursor.getString(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Cursor cursor) {
        this.f30729e = Math.max(this.f30729e, cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MutationBatch D(int i4, Cursor cursor) {
        return u(i4, cursor.getBlob(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(List list, Cursor cursor) {
        list.add(EncodedPath.b(cursor.getString(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Cursor cursor) {
        this.f30730f = ByteString.copyFrom(cursor.getBlob(0));
    }

    private void G() {
        final ArrayList arrayList = new ArrayList();
        this.f30725a.x("SELECT uid FROM mutation_queues").e(new Consumer() { // from class: com.google.firebase.firestore.local.g1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.B(arrayList, (Cursor) obj);
            }
        });
        this.f30729e = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f30725a.x("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").b((String) it.next()).e(new Consumer() { // from class: com.google.firebase.firestore.local.h1
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteMutationQueue.this.C((Cursor) obj);
                }
            });
        }
        this.f30729e++;
    }

    private void H() {
        this.f30725a.p("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.f30728d, -1, this.f30730f.toByteArray());
    }

    private MutationBatch u(int i4, byte[] bArr) {
        try {
            if (bArr.length < 1000000) {
                return this.f30726b.c(WriteBatch.parseFrom(bArr));
            }
            BlobAccumulator blobAccumulator = new BlobAccumulator(bArr);
            while (blobAccumulator.f30732b) {
                this.f30725a.x("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(Integer.valueOf((blobAccumulator.d() * DurationKt.NANOS_IN_MILLIS) + 1), Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), this.f30728d, Integer.valueOf(i4)).c(blobAccumulator);
            }
            return this.f30726b.c(WriteBatch.parseFrom(blobAccumulator.e()));
        } catch (InvalidProtocolBufferException e4) {
            throw Assert.fail("MutationBatch failed to parse: %s", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(List list, Cursor cursor) {
        list.add(u(cursor.getInt(0), cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Set set, List list, Cursor cursor) {
        int i4 = cursor.getInt(0);
        if (!set.contains(Integer.valueOf(i4))) {
            set.add(Integer.valueOf(i4));
            list.add(u(i4, cursor.getBlob(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int y(MutationBatch mutationBatch, MutationBatch mutationBatch2) {
        return Util.compareIntegers(mutationBatch.getBatchId(), mutationBatch2.getBatchId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer z(Cursor cursor) {
        return Integer.valueOf(cursor.getInt(0));
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void a() {
        if (!v()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        this.f30725a.x("SELECT path FROM document_mutations WHERE uid = ?").b(this.f30728d).e(new Consumer() { // from class: com.google.firebase.firestore.local.f1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.E(arrayList, (Cursor) obj);
            }
        });
        Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> b(Iterable<DocumentKey> iterable) {
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : iterable) {
            arrayList.add(EncodedPath.c(documentKey.getPath()));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.f30725a, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), this.f30728d), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        final ArrayList arrayList2 = new ArrayList();
        final HashSet hashSet = new HashSet();
        while (longQuery.d()) {
            longQuery.e().e(new Consumer() { // from class: com.google.firebase.firestore.local.a1
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteMutationQueue.this.x(hashSet, arrayList2, (Cursor) obj);
                }
            });
        }
        if (longQuery.c() > 1) {
            Collections.sort(arrayList2, new Comparator() { // from class: com.google.firebase.firestore.local.b1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int y3;
                    y3 = SQLiteMutationQueue.y((MutationBatch) obj, (MutationBatch) obj2);
                    return y3;
                }
            });
        }
        return arrayList2;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch c(int i4) {
        return (MutationBatch) this.f30725a.x("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").b(Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), this.f30728d, Integer.valueOf(i4 + 1)).d(new Function() { // from class: com.google.firebase.firestore.local.c1
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                MutationBatch A;
                A = SQLiteMutationQueue.this.A((Cursor) obj);
                return A;
            }
        });
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch d(final int i4) {
        return (MutationBatch) this.f30725a.x("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), this.f30728d, Integer.valueOf(i4)).d(new Function() { // from class: com.google.firebase.firestore.local.e1
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                MutationBatch D;
                D = SQLiteMutationQueue.this.D(i4, (Cursor) obj);
                return D;
            }
        });
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void e(MutationBatch mutationBatch, ByteString byteString) {
        this.f30730f = (ByteString) Preconditions.checkNotNull(byteString);
        H();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch f(Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        int i4 = this.f30729e;
        this.f30729e = i4 + 1;
        MutationBatch mutationBatch = new MutationBatch(i4, timestamp, list, list2);
        this.f30725a.p("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.f30728d, Integer.valueOf(i4), this.f30726b.i(mutationBatch).toByteArray());
        HashSet hashSet = new HashSet();
        SQLiteStatement w3 = this.f30725a.w("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        for (Mutation mutation : list2) {
            DocumentKey key = mutation.getKey();
            if (hashSet.add(key)) {
                this.f30725a.o(w3, this.f30728d, EncodedPath.c(key.getPath()), Integer.valueOf(i4));
                this.f30727c.addToCollectionParentIndex(key.getCollectionPath());
            }
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int g() {
        return ((Integer) this.f30725a.x("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").b(-1, this.f30728d).d(new Function() { // from class: com.google.firebase.firestore.local.y0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Integer z3;
                z3 = SQLiteMutationQueue.z((Cursor) obj);
                return z3;
            }
        })).intValue();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public ByteString getLastStreamToken() {
        return this.f30730f;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void h(MutationBatch mutationBatch) {
        boolean z3;
        SQLiteStatement w3 = this.f30725a.w("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement w4 = this.f30725a.w("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int batchId = mutationBatch.getBatchId();
        if (this.f30725a.o(w3, this.f30728d, Integer.valueOf(batchId)) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Mutation batch (%s, %d) did not exist", this.f30728d, Integer.valueOf(mutationBatch.getBatchId()));
        for (Mutation mutation : mutationBatch.getMutations()) {
            DocumentKey key = mutation.getKey();
            this.f30725a.o(w4, this.f30728d, EncodedPath.c(key.getPath()), Integer.valueOf(batchId));
            this.f30725a.getReferenceDelegate().d(key);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void i(ByteString byteString) {
        this.f30730f = (ByteString) Preconditions.checkNotNull(byteString);
        H();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> j() {
        final ArrayList arrayList = new ArrayList();
        this.f30725a.x("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").b(Integer.valueOf((int) DurationKt.NANOS_IN_MILLIS), this.f30728d).e(new Consumer() { // from class: com.google.firebase.firestore.local.z0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.this.w(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        G();
        if (this.f30725a.x("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").b(this.f30728d).c(new Consumer() { // from class: com.google.firebase.firestore.local.d1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.this.F((Cursor) obj);
            }
        }) == 0) {
            H();
        }
    }

    public boolean v() {
        return this.f30725a.x("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").b(this.f30728d).f();
    }
}
