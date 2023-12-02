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
public final class BlockedMacroDao_Impl implements BlockedMacroDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10776a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<BlockedMacro> f10777b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f10778c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10779d;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<BlockedMacro> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BlockedMacro blockedMacro) {
            supportSQLiteStatement.bindLong(1, blockedMacro.getMacroId());
            if (blockedMacro.getMacroName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, blockedMacro.getMacroName());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `BlockedMacro` (`macroId`,`macroName`) VALUES (?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM BlockedMacro";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM BlockedMacro WHERE macroId == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockedMacro f10783a;

        d(BlockedMacro blockedMacro) {
            this.f10783a = blockedMacro;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            BlockedMacroDao_Impl.this.f10776a.beginTransaction();
            try {
                long insertAndReturnId = BlockedMacroDao_Impl.this.f10777b.insertAndReturnId(this.f10783a);
                BlockedMacroDao_Impl.this.f10776a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                BlockedMacroDao_Impl.this.f10776a.endTransaction();
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
            SupportSQLiteStatement acquire = BlockedMacroDao_Impl.this.f10778c.acquire();
            BlockedMacroDao_Impl.this.f10776a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                BlockedMacroDao_Impl.this.f10776a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                BlockedMacroDao_Impl.this.f10776a.endTransaction();
                BlockedMacroDao_Impl.this.f10778c.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10786a;

        f(int i4) {
            this.f10786a = i4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = BlockedMacroDao_Impl.this.f10779d.acquire();
            acquire.bindLong(1, this.f10786a);
            BlockedMacroDao_Impl.this.f10776a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                BlockedMacroDao_Impl.this.f10776a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                BlockedMacroDao_Impl.this.f10776a.endTransaction();
                BlockedMacroDao_Impl.this.f10779d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<List<BlockedMacro>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10788a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10788a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<BlockedMacro> call() throws Exception {
            String string;
            Cursor query = DBUtil.query(BlockedMacroDao_Impl.this.f10776a, this.f10788a, false, null);
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
                    arrayList.add(new BlockedMacro(i4, string));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10788a.release();
            }
        }
    }

    public BlockedMacroDao_Impl(RoomDatabase roomDatabase) {
        this.f10776a = roomDatabase;
        this.f10777b = new a(roomDatabase);
        this.f10778c = new b(roomDatabase);
        this.f10779d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedMacroDao
    public Object addBlockedMacro(BlockedMacro blockedMacro, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10776a, true, new d(blockedMacro), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedMacroDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10776a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedMacroDao
    public Object deleteBlockedMacro(int i4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10776a, true, new f(i4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedMacroDao
    public Object getAllBlockedMacro(Continuation<? super List<BlockedMacro>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BlockedMacro", 0);
        return CoroutinesRoom.execute(this.f10776a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }
}
