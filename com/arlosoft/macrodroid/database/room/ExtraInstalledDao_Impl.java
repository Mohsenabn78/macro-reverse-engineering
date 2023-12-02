package com.arlosoft.macrodroid.database.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public final class ExtraInstalledDao_Impl implements ExtraInstalledDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10808a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<ExtraInstalled> f10809b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f10810c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10811d;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<ExtraInstalled> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ExtraInstalled extraInstalled) {
            if (extraInstalled.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, extraInstalled.getId());
            }
            if (extraInstalled.getVersionString() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, extraInstalled.getVersionString());
            }
            supportSQLiteStatement.bindLong(3, extraInstalled.getVersionCode());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ExtraInstalled` (`id`,`versionString`,`versionCode`) VALUES (?,?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM ExtraInstalled";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM ExtraInstalled WHERE id == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ExtraInstalled f10815a;

        d(ExtraInstalled extraInstalled) {
            this.f10815a = extraInstalled;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            ExtraInstalledDao_Impl.this.f10808a.beginTransaction();
            try {
                long insertAndReturnId = ExtraInstalledDao_Impl.this.f10809b.insertAndReturnId(this.f10815a);
                ExtraInstalledDao_Impl.this.f10808a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                ExtraInstalledDao_Impl.this.f10808a.endTransaction();
            }
        }
    }

    /* loaded from: classes3.dex */
    class e implements Callable<Unit> {
        e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = ExtraInstalledDao_Impl.this.f10810c.acquire();
            ExtraInstalledDao_Impl.this.f10808a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                ExtraInstalledDao_Impl.this.f10808a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                ExtraInstalledDao_Impl.this.f10808a.endTransaction();
                ExtraInstalledDao_Impl.this.f10810c.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10818a;

        f(String str) {
            this.f10818a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = ExtraInstalledDao_Impl.this.f10811d.acquire();
            String str = this.f10818a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            ExtraInstalledDao_Impl.this.f10808a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                ExtraInstalledDao_Impl.this.f10808a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                ExtraInstalledDao_Impl.this.f10808a.endTransaction();
                ExtraInstalledDao_Impl.this.f10811d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<ExtraInstalled> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10820a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10820a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public ExtraInstalled call() throws Exception {
            String string;
            ExtraInstalled extraInstalled = null;
            String string2 = null;
            Cursor query = DBUtil.query(ExtraInstalledDao_Impl.this.f10808a, this.f10820a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "versionString");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "versionCode");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    if (!query.isNull(columnIndexOrThrow2)) {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    extraInstalled = new ExtraInstalled(string, string2, query.getInt(columnIndexOrThrow3));
                }
                return extraInstalled;
            } finally {
                query.close();
                this.f10820a.release();
            }
        }
    }

    public ExtraInstalledDao_Impl(RoomDatabase roomDatabase) {
        this.f10808a = roomDatabase;
        this.f10809b = new a(roomDatabase);
        this.f10810c = new b(roomDatabase);
        this.f10811d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.ExtraInstalledDao
    public Object addInstalledExtra(ExtraInstalled extraInstalled, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10808a, true, new d(extraInstalled), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.ExtraInstalledDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10808a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.ExtraInstalledDao
    public Object deleteInstalledExtra(String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10808a, true, new f(str), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.ExtraInstalledDao
    public Object getInstalledExtraById(String str, Continuation<? super ExtraInstalled> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ExtraInstalled WHERE id == ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.f10808a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }
}
