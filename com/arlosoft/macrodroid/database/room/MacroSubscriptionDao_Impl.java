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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public final class MacroSubscriptionDao_Impl implements MacroSubscriptionDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10834a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<MacroSubscription> f10835b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f10836c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10837d;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<MacroSubscription> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MacroSubscription macroSubscription) {
            supportSQLiteStatement.bindLong(1, macroSubscription.getMacroId());
            if (macroSubscription.getMacroName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, macroSubscription.getMacroName());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `MacroSubscription` (`macroId`,`macroName`) VALUES (?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM MacroSubscription";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM MacroSubscription WHERE macroId == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroSubscription f10841a;

        d(MacroSubscription macroSubscription) {
            this.f10841a = macroSubscription;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            MacroSubscriptionDao_Impl.this.f10834a.beginTransaction();
            try {
                long insertAndReturnId = MacroSubscriptionDao_Impl.this.f10835b.insertAndReturnId(this.f10841a);
                MacroSubscriptionDao_Impl.this.f10834a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                MacroSubscriptionDao_Impl.this.f10834a.endTransaction();
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
            SupportSQLiteStatement acquire = MacroSubscriptionDao_Impl.this.f10836c.acquire();
            MacroSubscriptionDao_Impl.this.f10834a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MacroSubscriptionDao_Impl.this.f10834a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                MacroSubscriptionDao_Impl.this.f10834a.endTransaction();
                MacroSubscriptionDao_Impl.this.f10836c.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10844a;

        f(int i4) {
            this.f10844a = i4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = MacroSubscriptionDao_Impl.this.f10837d.acquire();
            acquire.bindLong(1, this.f10844a);
            MacroSubscriptionDao_Impl.this.f10834a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MacroSubscriptionDao_Impl.this.f10834a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                MacroSubscriptionDao_Impl.this.f10834a.endTransaction();
                MacroSubscriptionDao_Impl.this.f10837d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<List<MacroSubscription>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10846a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10846a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<MacroSubscription> call() throws Exception {
            String string;
            Cursor query = DBUtil.query(MacroSubscriptionDao_Impl.this.f10834a, this.f10846a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "macroId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "macroName");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i4 = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    arrayList.add(new MacroSubscription(i4, string));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10846a.release();
            }
        }
    }

    /* loaded from: classes3.dex */
    class h implements Callable<MacroSubscription> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10848a;

        h(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10848a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public MacroSubscription call() throws Exception {
            MacroSubscription macroSubscription = null;
            String string = null;
            Cursor query = DBUtil.query(MacroSubscriptionDao_Impl.this.f10834a, this.f10848a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "macroId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "macroName");
                if (query.moveToFirst()) {
                    int i4 = query.getInt(columnIndexOrThrow);
                    if (!query.isNull(columnIndexOrThrow2)) {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    macroSubscription = new MacroSubscription(i4, string);
                }
                return macroSubscription;
            } finally {
                query.close();
                this.f10848a.release();
            }
        }
    }

    public MacroSubscriptionDao_Impl(RoomDatabase roomDatabase) {
        this.f10834a = roomDatabase;
        this.f10835b = new a(roomDatabase);
        this.f10836c = new b(roomDatabase);
        this.f10837d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroSubscriptionDao
    public Object addMacroSubscription(MacroSubscription macroSubscription, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10834a, true, new d(macroSubscription), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroSubscriptionDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10834a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroSubscriptionDao
    public Object deleteMacroSubscription(int i4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10834a, true, new f(i4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroSubscriptionDao
    public Object getAllMacroSubscriptions(Continuation<? super List<MacroSubscription>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MacroSubscription", 0);
        return CoroutinesRoom.execute(this.f10834a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroSubscriptionDao
    public Object getSubscriptionByMacroId(int i4, Continuation<? super MacroSubscription> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MacroSubscription WHERE macroId == ?", 1);
        acquire.bindLong(1, i4);
        return CoroutinesRoom.execute(this.f10834a, false, DBUtil.createCancellationSignal(), new h(acquire), continuation);
    }
}
