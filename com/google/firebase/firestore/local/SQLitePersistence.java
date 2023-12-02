package com.google.firebase.firestore.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.FileUtil;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firebase.firestore.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes5.dex */
public final class SQLitePersistence extends Persistence {
    public static final int MAX_ARGS = 900;

    /* renamed from: b  reason: collision with root package name */
    private final OpenHelper f30734b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalSerializer f30735c;

    /* renamed from: d  reason: collision with root package name */
    private final SQLiteTargetCache f30736d;

    /* renamed from: e  reason: collision with root package name */
    private final SQLiteBundleCache f30737e;

    /* renamed from: f  reason: collision with root package name */
    private final SQLiteRemoteDocumentCache f30738f;

    /* renamed from: g  reason: collision with root package name */
    private final SQLiteLruReferenceDelegate f30739g;

    /* renamed from: h  reason: collision with root package name */
    private final SQLiteTransactionListener f30740h;

    /* renamed from: i  reason: collision with root package name */
    private SQLiteDatabase f30741i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f30742j;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private final LocalSerializer f30750a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30751b;

        private void b(SQLiteDatabase sQLiteDatabase) {
            if (!this.f30751b) {
                onConfigure(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f30751b = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            b(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase, this.f30750a).j0(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            b(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase, this.f30750a).j0(i4);
        }

        private OpenHelper(Context context, LocalSerializer localSerializer, String str) {
            this(context, localSerializer, str, 16);
        }

        @VisibleForTesting
        OpenHelper(Context context, LocalSerializer localSerializer, String str, int i4) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
            this.f30750a = localSerializer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Query {

        /* renamed from: a  reason: collision with root package name */
        private final SQLiteDatabase f30752a;

        /* renamed from: b  reason: collision with root package name */
        private final String f30753b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase.CursorFactory f30754c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(SQLiteDatabase sQLiteDatabase, String str) {
            this.f30752a = sQLiteDatabase;
            this.f30753b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Cursor g(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            SQLitePersistence.n(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        private Cursor h() {
            SQLiteDatabase.CursorFactory cursorFactory = this.f30754c;
            if (cursorFactory != null) {
                return this.f30752a.rawQueryWithFactory(cursorFactory, this.f30753b, null, null);
            }
            return this.f30752a.rawQuery(this.f30753b, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query b(final Object... objArr) {
            this.f30754c = new SQLiteDatabase.CursorFactory() { // from class: com.google.firebase.firestore.local.n1
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    Cursor g4;
                    g4 = SQLitePersistence.Query.g(objArr, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                    return g4;
                }
            };
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c(Consumer<Cursor> consumer) {
            Cursor h4 = h();
            try {
                if (h4.moveToFirst()) {
                    consumer.accept(h4);
                    h4.close();
                    return 1;
                }
                h4.close();
                return 0;
            } catch (Throwable th) {
                if (h4 != null) {
                    try {
                        h4.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public <T> T d(Function<Cursor, T> function) {
            Cursor h4 = h();
            try {
                if (h4.moveToFirst()) {
                    T apply = function.apply(h4);
                    h4.close();
                    return apply;
                }
                h4.close();
                return null;
            } catch (Throwable th) {
                if (h4 != null) {
                    try {
                        h4.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e(Consumer<Cursor> consumer) {
            Cursor h4 = h();
            int i4 = 0;
            while (h4.moveToNext()) {
                try {
                    i4++;
                    consumer.accept(h4);
                } catch (Throwable th) {
                    if (h4 != null) {
                        try {
                            h4.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            h4.close();
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean f() {
            Cursor h4 = h();
            try {
                boolean z3 = !h4.moveToFirst();
                h4.close();
                return z3;
            } catch (Throwable th) {
                if (h4 != null) {
                    try {
                        h4.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public SQLitePersistence(Context context, String str, DatabaseId databaseId, LocalSerializer localSerializer, LruGarbageCollector.Params params) {
        this(localSerializer, params, new OpenHelper(context, localSerializer, databaseName(str, databaseId)));
    }

    public static void clearPersistence(Context context, DatabaseId databaseId, String str) throws FirebaseFirestoreException {
        String path = context.getDatabasePath(databaseName(str, databaseId)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            FileUtil.delete(file);
            FileUtil.delete(file2);
            FileUtil.delete(file3);
        } catch (IOException e4) {
            throw new FirebaseFirestoreException("Failed to clear persistence." + e4, FirebaseFirestoreException.Code.UNKNOWN);
        }
    }

    @VisibleForTesting
    public static String databaseName(String str, DatabaseId databaseId) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(databaseId.getProjectId(), "utf-8") + "." + URLEncoder.encode(databaseId.getDatabaseId(), "utf-8");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(SQLiteProgram sQLiteProgram, Object[] objArr) {
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj == null) {
                sQLiteProgram.bindNull(i4 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i4 + 1, (String) obj);
            } else if (obj instanceof Integer) {
                sQLiteProgram.bindLong(i4 + 1, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                sQLiteProgram.bindLong(i4 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                sQLiteProgram.bindDouble(i4 + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof byte[]) {
                sQLiteProgram.bindBlob(i4 + 1, (byte[]) obj);
            } else {
                throw Assert.fail("Unknown argument %s of type %s", obj, obj.getClass());
            }
        }
    }

    private long r() {
        return ((Long) x("PRAGMA page_count").d(new Function() { // from class: com.google.firebase.firestore.local.m1
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Long u3;
                u3 = SQLitePersistence.u((Cursor) obj);
                return u3;
            }
        })).longValue();
    }

    private long s() {
        return ((Long) x("PRAGMA page_size").d(new Function() { // from class: com.google.firebase.firestore.local.l1
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Long v3;
                v3 = SQLitePersistence.v((Cursor) obj);
                return v3;
            }
        })).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long u(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long v(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public BundleCache a() {
        return this.f30737e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public DocumentOverlayCache b(User user) {
        return new SQLiteDocumentOverlayCache(this, this.f30735c, user);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public IndexManager c(User user) {
        return new SQLiteIndexManager(this, this.f30735c, user);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public MutationQueue d(User user, IndexManager indexManager) {
        return new SQLiteMutationQueue(this, this.f30735c, user, indexManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public OverlayMigrationManager e() {
        return new SQLiteOverlayMigrationManager(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public RemoteDocumentCache f() {
        return this.f30738f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public <T> T h(String str, Supplier<T> supplier) {
        Logger.debug(Persistence.f30690a, "Starting transaction: %s", str);
        this.f30741i.beginTransactionWithListener(this.f30740h);
        try {
            T t3 = supplier.get();
            this.f30741i.setTransactionSuccessful();
            return t3;
        } finally {
            this.f30741i.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public void i(String str, Runnable runnable) {
        Logger.debug(Persistence.f30690a, "Starting transaction: %s", str);
        this.f30741i.beginTransactionWithListener(this.f30740h);
        try {
            runnable.run();
            this.f30741i.setTransactionSuccessful();
        } finally {
            this.f30741i.endTransaction();
        }
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public boolean isStarted() {
        return this.f30742j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        n(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str, Object... objArr) {
        this.f30741i.execSQL(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long q() {
        return r() * s();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void shutdown() {
        Assert.hardAssert(this.f30742j, "SQLitePersistence shutdown without start!", new Object[0]);
        this.f30742j = false;
        this.f30741i.close();
        this.f30741i = null;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void start() {
        Assert.hardAssert(!this.f30742j, "SQLitePersistence double-started!", new Object[0]);
        this.f30742j = true;
        try {
            this.f30741i = this.f30734b.getWritableDatabase();
            this.f30736d.z();
            this.f30739g.s(this.f30736d.p());
        } catch (SQLiteDatabaseLockedException e4) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    /* renamed from: t */
    public SQLiteTargetCache g() {
        return this.f30736d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteStatement w(String str) {
        return this.f30741i.compileStatement(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query x(String str) {
        return new Query(this.f30741i, str);
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public SQLiteLruReferenceDelegate getReferenceDelegate() {
        return this.f30739g;
    }

    public SQLitePersistence(LocalSerializer localSerializer, LruGarbageCollector.Params params, OpenHelper openHelper) {
        this.f30740h = new SQLiteTransactionListener() { // from class: com.google.firebase.firestore.local.SQLitePersistence.1
            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onBegin() {
                SQLitePersistence.this.f30739g.c();
            }

            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onCommit() {
                SQLitePersistence.this.f30739g.b();
            }

            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onRollback() {
            }
        };
        this.f30734b = openHelper;
        this.f30735c = localSerializer;
        this.f30736d = new SQLiteTargetCache(this, localSerializer);
        this.f30737e = new SQLiteBundleCache(this, localSerializer);
        this.f30738f = new SQLiteRemoteDocumentCache(this, localSerializer);
        this.f30739g = new SQLiteLruReferenceDelegate(this, params);
    }

    /* loaded from: classes5.dex */
    static class LongQuery {

        /* renamed from: a  reason: collision with root package name */
        private final SQLitePersistence f30744a;

        /* renamed from: b  reason: collision with root package name */
        private final String f30745b;

        /* renamed from: c  reason: collision with root package name */
        private final String f30746c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Object> f30747d;

        /* renamed from: e  reason: collision with root package name */
        private int f30748e;

        /* renamed from: f  reason: collision with root package name */
        private final Iterator<Object> f30749f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, String str2) {
            this.f30748e = 0;
            this.f30744a = sQLitePersistence;
            this.f30745b = str;
            this.f30747d = Collections.emptyList();
            this.f30746c = str2;
            this.f30749f = list.iterator();
        }

        private Object[] b() {
            ArrayList arrayList = new ArrayList(this.f30747d);
            for (int i4 = 0; this.f30749f.hasNext() && i4 < 900 - this.f30747d.size(); i4++) {
                arrayList.add(this.f30749f.next());
            }
            return arrayList.toArray();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f30748e++;
            Object[] b4 = b();
            this.f30744a.p(this.f30745b + ((Object) Util.repeatSequence(TypeDescription.Generic.OfWildcardType.SYMBOL, b4.length, ", ")) + this.f30746c, b4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c() {
            return this.f30748e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d() {
            return this.f30749f.hasNext();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query e() {
            Object[] b4;
            this.f30748e++;
            return this.f30744a.x(this.f30745b + ((Object) Util.repeatSequence(TypeDescription.Generic.OfWildcardType.SYMBOL, b4.length, ", ")) + this.f30746c).b(b());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, List<Object> list2, String str2) {
            this.f30748e = 0;
            this.f30744a = sQLitePersistence;
            this.f30745b = str;
            this.f30747d = list;
            this.f30746c = str2;
            this.f30749f = list2.iterator();
        }
    }
}
