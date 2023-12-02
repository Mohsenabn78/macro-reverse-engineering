package com.arlosoft.macrodroid.database.room;

import android.database.Cursor;
import androidx.autofill.HintConstants;
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
public final class BlockedUserDao_Impl implements BlockedUserDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10792a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<BlockedUser> f10793b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f10794c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10795d;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<BlockedUser> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BlockedUser blockedUser) {
            supportSQLiteStatement.bindLong(1, blockedUser.getUserId());
            if (blockedUser.getUsername() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, blockedUser.getUsername());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `BlockedUser` (`userId`,`username`) VALUES (?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM BlockedUser";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM BlockedUser WHERE userId == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockedUser f10799a;

        d(BlockedUser blockedUser) {
            this.f10799a = blockedUser;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            BlockedUserDao_Impl.this.f10792a.beginTransaction();
            try {
                long insertAndReturnId = BlockedUserDao_Impl.this.f10793b.insertAndReturnId(this.f10799a);
                BlockedUserDao_Impl.this.f10792a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                BlockedUserDao_Impl.this.f10792a.endTransaction();
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
            SupportSQLiteStatement acquire = BlockedUserDao_Impl.this.f10794c.acquire();
            BlockedUserDao_Impl.this.f10792a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                BlockedUserDao_Impl.this.f10792a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                BlockedUserDao_Impl.this.f10792a.endTransaction();
                BlockedUserDao_Impl.this.f10794c.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10802a;

        f(int i4) {
            this.f10802a = i4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = BlockedUserDao_Impl.this.f10795d.acquire();
            acquire.bindLong(1, this.f10802a);
            BlockedUserDao_Impl.this.f10792a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                BlockedUserDao_Impl.this.f10792a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                BlockedUserDao_Impl.this.f10792a.endTransaction();
                BlockedUserDao_Impl.this.f10795d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<List<BlockedUser>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10804a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10804a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<BlockedUser> call() throws Exception {
            String string;
            Cursor query = DBUtil.query(BlockedUserDao_Impl.this.f10792a, this.f10804a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, HintConstants.AUTOFILL_HINT_USERNAME);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i4 = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    arrayList.add(new BlockedUser(i4, string));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10804a.release();
            }
        }
    }

    /* loaded from: classes3.dex */
    class h implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10806a;

        h(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10806a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            Integer valueOf;
            boolean z3 = false;
            Boolean bool = null;
            Cursor query = DBUtil.query(BlockedUserDao_Impl.this.f10792a, this.f10806a, false, null);
            try {
                if (query.moveToFirst()) {
                    if (query.isNull(0)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(0));
                    }
                    if (valueOf != null) {
                        if (valueOf.intValue() != 0) {
                            z3 = true;
                        }
                        bool = Boolean.valueOf(z3);
                    }
                }
                return bool;
            } finally {
                query.close();
                this.f10806a.release();
            }
        }
    }

    public BlockedUserDao_Impl(RoomDatabase roomDatabase) {
        this.f10792a = roomDatabase;
        this.f10793b = new a(roomDatabase);
        this.f10794c = new b(roomDatabase);
        this.f10795d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedUserDao
    public Object addBlockedUser(BlockedUser blockedUser, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10792a, true, new d(blockedUser), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedUserDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10792a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedUserDao
    public Object deleteBlockedUser(int i4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10792a, true, new f(i4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedUserDao
    public Object getAllBlockedUsers(Continuation<? super List<BlockedUser>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM BlockedUser", 0);
        return CoroutinesRoom.execute(this.f10792a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.BlockedUserDao
    public Object isUserBlocked(int i4, Continuation<? super Boolean> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM BlockedUser WHERE userId == ?)", 1);
        acquire.bindLong(1, i4);
        return CoroutinesRoom.execute(this.f10792a, false, DBUtil.createCancellationSignal(), new h(acquire), continuation);
    }
}
