package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SQLiteLruReferenceDelegate implements ReferenceDelegate, LruDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30720a;

    /* renamed from: b  reason: collision with root package name */
    private ListenSequence f30721b;

    /* renamed from: c  reason: collision with root package name */
    private long f30722c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final LruGarbageCollector f30723d;

    /* renamed from: e  reason: collision with root package name */
    private ReferenceSet f30724e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteLruReferenceDelegate(SQLitePersistence sQLitePersistence, LruGarbageCollector.Params params) {
        this.f30720a = sQLitePersistence;
        this.f30723d = new LruGarbageCollector(this, params);
    }

    private boolean m(DocumentKey documentKey) {
        if (this.f30724e.containsKey(documentKey)) {
            return true;
        }
        return q(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Consumer consumer, Cursor cursor) {
        consumer.accept(Long.valueOf(cursor.getLong(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long o(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int[] iArr, List list, Cursor cursor) {
        DocumentKey fromPath = DocumentKey.fromPath(EncodedPath.b(cursor.getString(0)));
        if (!m(fromPath)) {
            iArr[0] = iArr[0] + 1;
            list.add(fromPath);
            r(fromPath);
        }
    }

    private boolean q(DocumentKey documentKey) {
        return !this.f30720a.x("SELECT 1 FROM document_mutations WHERE path = ?").b(EncodedPath.c(documentKey.getPath())).f();
    }

    private void r(DocumentKey documentKey) {
        this.f30720a.p("DELETE FROM target_documents WHERE path = ? AND target_id = 0", EncodedPath.c(documentKey.getPath()));
    }

    private void t(DocumentKey documentKey) {
        this.f30720a.p("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", EncodedPath.c(documentKey.getPath()), Long.valueOf(e()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void a(DocumentKey documentKey) {
        t(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void b() {
        boolean z3;
        if (this.f30722c != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Committing a transaction without having started one", new Object[0]);
        this.f30722c = -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void c() {
        boolean z3;
        if (this.f30722c == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Starting a transaction without committing the previous one", new Object[0]);
        this.f30722c = this.f30721b.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void d(DocumentKey documentKey) {
        t(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long e() {
        boolean z3;
        if (this.f30722c != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f30722c;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void f(TargetData targetData) {
        this.f30720a.g().e(targetData.withSequenceNumber(e()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachOrphanedDocumentSequenceNumber(final Consumer<Long> consumer) {
        this.f30720a.x("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").e(new Consumer() { // from class: com.google.firebase.firestore.local.w0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteLruReferenceDelegate.n(Consumer.this, (Cursor) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachTarget(Consumer<TargetData> consumer) {
        this.f30720a.g().o(consumer);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void g(ReferenceSet referenceSet) {
        this.f30724e = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getByteSize() {
        return this.f30720a.q();
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public LruGarbageCollector getGarbageCollector() {
        return this.f30723d;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getSequenceNumberCount() {
        return this.f30720a.g().q() + ((Long) this.f30720a.x("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").d(new Function() { // from class: com.google.firebase.firestore.local.v0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Long o4;
                o4 = SQLiteLruReferenceDelegate.o((Cursor) obj);
                return o4;
            }
        })).longValue();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void h(DocumentKey documentKey) {
        t(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void i(DocumentKey documentKey) {
        t(documentKey);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeOrphanedDocuments(long j4) {
        final int[] iArr = new int[1];
        final ArrayList arrayList = new ArrayList();
        while (true) {
            for (boolean z3 = true; z3; z3 = false) {
                if (this.f30720a.x("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").b(Long.valueOf(j4), 100).e(new Consumer() { // from class: com.google.firebase.firestore.local.x0
                    @Override // com.google.firebase.firestore.util.Consumer
                    public final void accept(Object obj) {
                        SQLiteLruReferenceDelegate.this.p(iArr, arrayList, (Cursor) obj);
                    }
                }) == 100) {
                    break;
                }
            }
            this.f30720a.f().removeAll(arrayList);
            return iArr[0];
        }
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeTargets(long j4, SparseArray<?> sparseArray) {
        return this.f30720a.g().w(j4, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(long j4) {
        this.f30721b = new ListenSequence(j4);
    }
}
