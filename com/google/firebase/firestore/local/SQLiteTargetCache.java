package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.local.SQLiteTargetCache;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SQLiteTargetCache implements TargetCache {

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30760a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30761b;

    /* renamed from: c  reason: collision with root package name */
    private int f30762c;

    /* renamed from: d  reason: collision with root package name */
    private long f30763d;

    /* renamed from: e  reason: collision with root package name */
    private SnapshotVersion f30764e = SnapshotVersion.NONE;

    /* renamed from: f  reason: collision with root package name */
    private long f30765f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DocumentKeysHolder {

        /* renamed from: a  reason: collision with root package name */
        ImmutableSortedSet<DocumentKey> f30766a;

        private DocumentKeysHolder() {
            this.f30766a = DocumentKey.emptyKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TargetDataHolder {

        /* renamed from: a  reason: collision with root package name */
        TargetData f30767a;

        private TargetDataHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteTargetCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.f30760a = sQLitePersistence;
        this.f30761b = localSerializer;
    }

    private boolean A(TargetData targetData) {
        boolean z3;
        if (targetData.getTargetId() > this.f30762c) {
            this.f30762c = targetData.getTargetId();
            z3 = true;
        } else {
            z3 = false;
        }
        if (targetData.getSequenceNumber() > this.f30763d) {
            this.f30763d = targetData.getSequenceNumber();
            return true;
        }
        return z3;
    }

    private void B() {
        this.f30760a.p("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.f30762c), Long.valueOf(this.f30763d), Long.valueOf(this.f30764e.getTimestamp().getSeconds()), Integer.valueOf(this.f30764e.getTimestamp().getNanoseconds()), Long.valueOf(this.f30765f));
    }

    private TargetData n(byte[] bArr) {
        try {
            return this.f30761b.e(Target.parseFrom(bArr));
        } catch (InvalidProtocolBufferException e4) {
            throw Assert.fail("TargetData failed to parse: %s", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Consumer consumer, Cursor cursor) {
        consumer.accept(n(cursor.getBlob(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(DocumentKeysHolder documentKeysHolder, Cursor cursor) {
        documentKeysHolder.f30766a = documentKeysHolder.f30766a.insert(DocumentKey.fromPath(EncodedPath.b(cursor.getString(0))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(com.google.firebase.firestore.core.Target target, TargetDataHolder targetDataHolder, Cursor cursor) {
        TargetData n4 = n(cursor.getBlob(0));
        if (target.equals(n4.getTarget())) {
            targetDataHolder.f30767a = n4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(SparseArray sparseArray, int[] iArr, Cursor cursor) {
        int i4 = cursor.getInt(0);
        if (sparseArray.get(i4) == null) {
            x(i4);
            iArr[0] = iArr[0] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Cursor cursor) {
        this.f30762c = cursor.getInt(0);
        this.f30763d = cursor.getInt(1);
        this.f30764e = new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3)));
        this.f30765f = cursor.getLong(4);
    }

    private void x(int i4) {
        d(i4);
        this.f30760a.p("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i4));
        this.f30765f--;
    }

    private void y(TargetData targetData) {
        int targetId = targetData.getTargetId();
        String canonicalId = targetData.getTarget().getCanonicalId();
        Timestamp timestamp = targetData.getSnapshotVersion().getTimestamp();
        this.f30760a.p("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(targetId), canonicalId, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), targetData.getResumeToken().toByteArray(), Long.valueOf(targetData.getSequenceNumber()), this.f30761b.k(targetData).toByteArray());
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void a(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        SQLiteStatement w3 = this.f30760a.w("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        SQLiteLruReferenceDelegate referenceDelegate = this.f30760a.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            this.f30760a.o(w3, Integer.valueOf(i4), EncodedPath.c(next.getPath()));
            referenceDelegate.i(next);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    @Nullable
    public TargetData b(final com.google.firebase.firestore.core.Target target) {
        String canonicalId = target.getCanonicalId();
        final TargetDataHolder targetDataHolder = new TargetDataHolder();
        this.f30760a.x("SELECT target_proto FROM targets WHERE canonical_id = ?").b(canonicalId).e(new Consumer() { // from class: com.google.firebase.firestore.local.k2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.this.t(target, targetDataHolder, (Cursor) obj);
            }
        });
        return targetDataHolder.f30767a;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void c(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        SQLiteStatement w3 = this.f30760a.w("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        SQLiteLruReferenceDelegate referenceDelegate = this.f30760a.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            this.f30760a.o(w3, Integer.valueOf(i4), EncodedPath.c(next.getPath()));
            referenceDelegate.h(next);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void d(int i4) {
        this.f30760a.p("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i4));
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void e(TargetData targetData) {
        y(targetData);
        if (A(targetData)) {
            B();
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void f(SnapshotVersion snapshotVersion) {
        this.f30764e = snapshotVersion;
        B();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void g(TargetData targetData) {
        y(targetData);
        A(targetData);
        this.f30765f++;
        B();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public int getHighestTargetId() {
        return this.f30762c;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.f30764e;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public ImmutableSortedSet<DocumentKey> h(int i4) {
        final DocumentKeysHolder documentKeysHolder = new DocumentKeysHolder();
        this.f30760a.x("SELECT path FROM target_documents WHERE target_id = ?").b(Integer.valueOf(i4)).e(new Consumer() { // from class: com.google.firebase.firestore.local.o2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.s(SQLiteTargetCache.DocumentKeysHolder.this, (Cursor) obj);
            }
        });
        return documentKeysHolder.f30766a;
    }

    public void o(final Consumer<TargetData> consumer) {
        this.f30760a.x("SELECT target_proto FROM targets").e(new Consumer() { // from class: com.google.firebase.firestore.local.n2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.this.r(consumer, (Cursor) obj);
            }
        });
    }

    public long p() {
        return this.f30763d;
    }

    public long q() {
        return this.f30765f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(long j4, final SparseArray<?> sparseArray) {
        final int[] iArr = new int[1];
        this.f30760a.x("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").b(Long.valueOf(j4)).e(new Consumer() { // from class: com.google.firebase.firestore.local.m2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.this.u(sparseArray, iArr, (Cursor) obj);
            }
        });
        B();
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        boolean z3 = true;
        if (this.f30760a.x("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").c(new Consumer() { // from class: com.google.firebase.firestore.local.l2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.this.v((Cursor) obj);
            }
        }) != 1) {
            z3 = false;
        }
        Assert.hardAssert(z3, "Missing target_globals entry", new Object[0]);
    }
}
