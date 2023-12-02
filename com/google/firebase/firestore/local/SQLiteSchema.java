package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SQLiteSchema {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f30758a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30759b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteSchema(SQLiteDatabase sQLiteDatabase, LocalSerializer localSerializer) {
        this.f30758a = sQLiteDatabase;
        this.f30759b = localSerializer;
    }

    private void A() {
        N(new String[]{"document_overlays"}, new Runnable() { // from class: com.google.firebase.firestore.local.d2
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.R();
            }
        });
    }

    private void B() {
        N(new String[]{"mutation_queues", "mutations", "document_mutations"}, new Runnable() { // from class: com.google.firebase.firestore.local.u1
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.S();
            }
        });
    }

    private void C() {
        N(new String[]{"remote_documents"}, new Runnable() { // from class: com.google.firebase.firestore.local.f2
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.T();
            }
        });
    }

    private void D() {
        N(new String[]{"targets", "target_globals", "target_documents"}, new Runnable() { // from class: com.google.firebase.firestore.local.s1
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.U();
            }
        });
    }

    private void E() {
        N(new String[]{"collection_parents"}, new Runnable() { // from class: com.google.firebase.firestore.local.v1
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.Y();
            }
        });
        final MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex = new MemoryIndexManager.MemoryCollectionParentIndex();
        final SQLiteStatement compileStatement = this.f30758a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
        final Consumer consumer = new Consumer() { // from class: com.google.firebase.firestore.local.w1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.V(MemoryIndexManager.MemoryCollectionParentIndex.this, compileStatement, (ResourcePath) obj);
            }
        };
        new SQLitePersistence.Query(this.f30758a, "SELECT path FROM remote_documents").e(new Consumer() { // from class: com.google.firebase.firestore.local.x1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.W(Consumer.this, (Cursor) obj);
            }
        });
        new SQLitePersistence.Query(this.f30758a, "SELECT path FROM document_mutations").e(new Consumer() { // from class: com.google.firebase.firestore.local.y1
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.X(Consumer.this, (Cursor) obj);
            }
        });
    }

    private void F() {
        new SQLitePersistence.Query(this.f30758a, "SELECT target_id, target_proto FROM targets").e(new Consumer() { // from class: com.google.firebase.firestore.local.i2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.this.Z((Cursor) obj);
            }
        });
    }

    private void G() {
        if (m0("targets")) {
            this.f30758a.execSQL("DROP TABLE targets");
        }
        if (m0("target_globals")) {
            this.f30758a.execSQL("DROP TABLE target_globals");
        }
        if (m0("target_documents")) {
            this.f30758a.execSQL("DROP TABLE target_documents");
        }
    }

    private void H() {
        SQLitePersistence.Query b4 = new SQLitePersistence.Query(this.f30758a, "SELECT path FROM remote_documents WHERE path_length IS NULL LIMIT ?").b(100);
        final SQLiteStatement compileStatement = this.f30758a.compileStatement("UPDATE remote_documents SET path_length = ? WHERE path = ?");
        final boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            b4.e(new Consumer() { // from class: com.google.firebase.firestore.local.z1
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteSchema.a0(zArr, compileStatement, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    private void I() {
        this.f30758a.execSQL("UPDATE remote_documents SET read_time_seconds = 0, read_time_nanos = 0 WHERE read_time_seconds IS NULL");
    }

    private void J() {
        boolean z3;
        Long l4 = (Long) new SQLitePersistence.Query(this.f30758a, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").d(new Function() { // from class: com.google.firebase.firestore.local.j2
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Long b02;
                b02 = SQLiteSchema.b0((Cursor) obj);
                return b02;
            }
        });
        if (l4 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Missing highest sequence number", new Object[0]);
        final long longValue = l4.longValue();
        final SQLiteStatement compileStatement = this.f30758a.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        SQLitePersistence.Query b4 = new SQLitePersistence.Query(this.f30758a, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").b(100);
        final boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            b4.e(new Consumer() { // from class: com.google.firebase.firestore.local.t1
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteSchema.c0(zArr, compileStatement, longValue, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    private void K() {
        boolean z3;
        if (DatabaseUtils.queryNumEntries(this.f30758a, "target_globals") == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            this.f30758a.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
        }
    }

    private boolean M() {
        boolean z3;
        boolean l02 = l0("remote_documents", "read_time_seconds");
        boolean l03 = l0("remote_documents", "read_time_nanos");
        if (l02 == l03) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        if (l02 && l03) {
            return true;
        }
        return false;
    }

    private void N(String[] strArr, Runnable runnable) {
        String str;
        String str2 = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z3 = false;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str3 = strArr[i4];
            boolean m02 = m0(str3);
            if (i4 == 0) {
                z3 = m02;
            } else if (m02 != z3) {
                String str4 = "Expected all of " + str2 + " to either exist or not, but ";
                if (z3) {
                    str = str4 + strArr[0] + " exists and " + str3 + " does not";
                } else {
                    str = str4 + strArr[0] + " does not exist and " + str3 + " does";
                }
                throw new IllegalStateException(str);
            }
        }
        if (!z3) {
            runnable.run();
            return;
        }
        Logger.debug("SQLiteSchema", "Skipping migration because all of " + str2 + " already exist", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        this.f30758a.execSQL("CREATE TABLE bundles (bundle_id TEXT PRIMARY KEY, create_time_seconds INTEGER, create_time_nanos INTEGER, schema_version INTEGER, total_documents INTEGER, total_bytes INTEGER)");
        this.f30758a.execSQL("CREATE TABLE named_queries (name TEXT PRIMARY KEY, read_time_seconds INTEGER, read_time_nanos INTEGER, bundled_query_proto BLOB)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        this.f30758a.execSQL("CREATE TABLE data_migrations (migration_name TEXT, PRIMARY KEY (migration_name))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f30758a.execSQL("CREATE TABLE index_configuration (index_id INTEGER, collection_group TEXT, index_proto BLOB, PRIMARY KEY (index_id))");
        this.f30758a.execSQL("CREATE TABLE index_state (index_id INTEGER, uid TEXT, sequence_number INTEGER, read_time_seconds INTEGER, read_time_nanos INTEGER, document_key TEXT, largest_batch_id INTEGER, PRIMARY KEY (index_id, uid))");
        this.f30758a.execSQL("CREATE TABLE index_entries (index_id INTEGER, uid TEXT, array_value BLOB, directional_value BLOB, document_key TEXT, PRIMARY KEY (index_id, uid, array_value, directional_value, document_key))");
        this.f30758a.execSQL("CREATE INDEX read_time ON remote_documents(read_time_seconds, read_time_nanos)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f30758a.execSQL("CREATE TABLE document_overlays (uid TEXT, collection_path TEXT, document_id TEXT, collection_group TEXT, largest_batch_id INTEGER, overlay_mutation BLOB, PRIMARY KEY (uid, collection_path, document_id))");
        this.f30758a.execSQL("CREATE INDEX batch_id_overlay ON document_overlays (uid, largest_batch_id)");
        this.f30758a.execSQL("CREATE INDEX collection_group_overlay ON document_overlays (uid, collection_group)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.f30758a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        this.f30758a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        this.f30758a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.f30758a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f30758a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        this.f30758a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        this.f30758a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        this.f30758a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        this.f30758a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement, ResourcePath resourcePath) {
        if (memoryCollectionParentIndex.a(resourcePath)) {
            String lastSegment = resourcePath.getLastSegment();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, lastSegment);
            sQLiteStatement.bindString(2, EncodedPath.c(resourcePath.popLast()));
            sQLiteStatement.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(Consumer consumer, Cursor cursor) {
        consumer.accept(EncodedPath.b(cursor.getString(0)).popLast());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(Consumer consumer, Cursor cursor) {
        consumer.accept(EncodedPath.b(cursor.getString(0)).popLast());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        this.f30758a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Cursor cursor) {
        int i4 = cursor.getInt(0);
        try {
            this.f30758a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{Target.parseFrom(cursor.getBlob(1)).toBuilder().clearLastLimboFreeSnapshotVersion().build().toByteArray(), Integer.valueOf(i4)});
        } catch (InvalidProtocolBufferException unused) {
            throw Assert.fail("Failed to decode Query data for target %s", Integer.valueOf(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(boolean[] zArr, SQLiteStatement sQLiteStatement, Cursor cursor) {
        boolean z3 = true;
        zArr[0] = true;
        String string = cursor.getString(0);
        ResourcePath b4 = EncodedPath.b(string);
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, b4.length());
        sQLiteStatement.bindString(2, string);
        if (sQLiteStatement.executeUpdateDelete() == -1) {
            z3 = false;
        }
        Assert.hardAssert(z3, "Failed to update document path", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long b0(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(boolean[] zArr, SQLiteStatement sQLiteStatement, long j4, Cursor cursor) {
        boolean z3 = true;
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j4);
        if (sQLiteStatement.executeInsert() == -1) {
            z3 = false;
        }
        Assert.hardAssert(z3, "Failed to insert a sentinel row", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(String str, Cursor cursor) {
        h0(str, cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Cursor cursor) {
        final String string = cursor.getString(0);
        new SQLitePersistence.Query(this.f30758a, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").b(string, Long.valueOf(cursor.getLong(1))).e(new Consumer() { // from class: com.google.firebase.firestore.local.a2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.this.d0(string, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Cursor cursor) {
        int i4 = cursor.getInt(0);
        try {
            this.f30758a.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", new Object[]{this.f30759b.e(Target.parseFrom(cursor.getBlob(1))).getTarget().getCanonicalId(), Integer.valueOf(i4)});
        } catch (InvalidProtocolBufferException unused) {
            throw Assert.fail("Failed to decode Query data for target %s", Integer.valueOf(i4));
        }
    }

    private void g0() {
        new SQLitePersistence.Query(this.f30758a, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").e(new Consumer() { // from class: com.google.firebase.firestore.local.g2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.this.e0((Cursor) obj);
            }
        });
    }

    private void h0(String str, int i4) {
        boolean z3;
        SQLiteStatement compileStatement = this.f30758a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        compileStatement.bindString(1, str);
        compileStatement.bindLong(2, i4);
        if (compileStatement.executeUpdateDelete() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Mutation batch (%s, %d) did not exist", str, Integer.valueOf(i4));
        this.f30758a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i4)});
    }

    private void i0() {
        new SQLitePersistence.Query(this.f30758a, "SELECT target_id, target_proto FROM targets").e(new Consumer() { // from class: com.google.firebase.firestore.local.b2
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.this.f0((Cursor) obj);
            }
        });
    }

    private boolean l0(String str, String str2) {
        if (L(str).indexOf(str2) != -1) {
            return true;
        }
        return false;
    }

    private boolean m0(String str) {
        return !new SQLitePersistence.Query(this.f30758a, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").b(str).f();
    }

    private void s() {
        if (!l0("remote_documents", "path_length")) {
            this.f30758a.execSQL("ALTER TABLE remote_documents ADD COLUMN path_length INTEGER");
        }
    }

    private void t(String str) {
        this.f30758a.execSQL("INSERT OR IGNORE INTO data_migrations (migration_name) VALUES (?)", new String[]{str});
    }

    private void u() {
        this.f30758a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.f30758a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    private void v() {
        if (!l0("target_documents", "sequence_number")) {
            this.f30758a.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
        }
    }

    private void w() {
        if (!l0("target_globals", "target_count")) {
            this.f30758a.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long queryNumEntries = DatabaseUtils.queryNumEntries(this.f30758a, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(queryNumEntries));
        this.f30758a.update("target_globals", contentValues, null, null);
    }

    private void x() {
        N(new String[]{"bundles", "named_queries"}, new Runnable() { // from class: com.google.firebase.firestore.local.h2
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.O();
            }
        });
    }

    private void y() {
        N(new String[]{"data_migrations"}, new Runnable() { // from class: com.google.firebase.firestore.local.c2
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.P();
            }
        });
    }

    private void z() {
        N(new String[]{"index_configuration", "index_state", "index_entries"}, new Runnable() { // from class: com.google.firebase.firestore.local.e2
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.this.Q();
            }
        });
    }

    @VisibleForTesting
    List<String> L(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f30758a;
            cursor = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursor.getColumnIndex("name");
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(columnIndex));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(int i4) {
        k0(i4, 16);
    }

    void k0(int i4, int i5) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i4 < 1 && i5 >= 1) {
            B();
            D();
            C();
        }
        if (i4 < 3 && i5 >= 3 && i4 != 0) {
            G();
            D();
        }
        if (i4 < 4 && i5 >= 4) {
            K();
            w();
        }
        if (i4 < 5 && i5 >= 5) {
            v();
        }
        if (i4 < 6 && i5 >= 6) {
            g0();
        }
        if (i4 < 7 && i5 >= 7) {
            J();
        }
        if (i4 < 8 && i5 >= 8) {
            E();
        }
        if (i4 < 9 && i5 >= 9) {
            if (!M()) {
                u();
            } else {
                F();
            }
        }
        if (i4 == 9 && i5 >= 10) {
            F();
        }
        if (i4 < 11 && i5 >= 11) {
            i0();
        }
        if (i4 < 12 && i5 >= 12) {
            x();
        }
        if (i4 < 13 && i5 >= 13) {
            s();
            H();
        }
        if (i4 < 14 && i5 >= 14) {
            A();
            y();
            t(Persistence.DATA_MIGRATION_BUILD_OVERLAYS);
        }
        if (i4 < 15 && i5 >= 15) {
            I();
        }
        if (i4 < 16 && i5 >= 16) {
            z();
        }
        Logger.debug("SQLiteSchema", "Migration from version %s to %s took %s milliseconds", Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
