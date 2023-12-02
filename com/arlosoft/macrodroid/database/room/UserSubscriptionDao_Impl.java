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
public final class UserSubscriptionDao_Impl implements UserSubscriptionDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10911a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<UserSubscription> f10912b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f10913c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10914d;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<UserSubscription> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, UserSubscription userSubscription) {
            supportSQLiteStatement.bindLong(1, userSubscription.getUserId());
            if (userSubscription.getUserName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, userSubscription.getUserName());
            }
            if (userSubscription.getUserImage() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, userSubscription.getUserImage());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `UserSubscription` (`userId`,`userName`,`userImage`) VALUES (?,?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM UserSubscription";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM UserSubscription WHERE userId == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserSubscription f10918a;

        d(UserSubscription userSubscription) {
            this.f10918a = userSubscription;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            UserSubscriptionDao_Impl.this.f10911a.beginTransaction();
            try {
                long insertAndReturnId = UserSubscriptionDao_Impl.this.f10912b.insertAndReturnId(this.f10918a);
                UserSubscriptionDao_Impl.this.f10911a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                UserSubscriptionDao_Impl.this.f10911a.endTransaction();
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
            SupportSQLiteStatement acquire = UserSubscriptionDao_Impl.this.f10913c.acquire();
            UserSubscriptionDao_Impl.this.f10911a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                UserSubscriptionDao_Impl.this.f10911a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionDao_Impl.this.f10911a.endTransaction();
                UserSubscriptionDao_Impl.this.f10913c.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10921a;

        f(int i4) {
            this.f10921a = i4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = UserSubscriptionDao_Impl.this.f10914d.acquire();
            acquire.bindLong(1, this.f10921a);
            UserSubscriptionDao_Impl.this.f10911a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                UserSubscriptionDao_Impl.this.f10911a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionDao_Impl.this.f10911a.endTransaction();
                UserSubscriptionDao_Impl.this.f10914d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<List<UserSubscription>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10923a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10923a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<UserSubscription> call() throws Exception {
            String string;
            String string2;
            Cursor query = DBUtil.query(UserSubscriptionDao_Impl.this.f10911a, this.f10923a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userName");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "userImage");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i4 = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    arrayList.add(new UserSubscription(i4, string, string2));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10923a.release();
            }
        }
    }

    /* loaded from: classes3.dex */
    class h implements Callable<UserSubscription> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10925a;

        h(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10925a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public UserSubscription call() throws Exception {
            String string;
            UserSubscription userSubscription = null;
            String string2 = null;
            Cursor query = DBUtil.query(UserSubscriptionDao_Impl.this.f10911a, this.f10925a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userName");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "userImage");
                if (query.moveToFirst()) {
                    int i4 = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    if (!query.isNull(columnIndexOrThrow3)) {
                        string2 = query.getString(columnIndexOrThrow3);
                    }
                    userSubscription = new UserSubscription(i4, string, string2);
                }
                return userSubscription;
            } finally {
                query.close();
                this.f10925a.release();
            }
        }
    }

    public UserSubscriptionDao_Impl(RoomDatabase roomDatabase) {
        this.f10911a = roomDatabase;
        this.f10912b = new a(roomDatabase);
        this.f10913c = new b(roomDatabase);
        this.f10914d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.UserSubscriptionDao
    public Object addUserSubscription(UserSubscription userSubscription, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10911a, true, new d(userSubscription), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.UserSubscriptionDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10911a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.UserSubscriptionDao
    public Object deleteUserSubscription(int i4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10911a, true, new f(i4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.UserSubscriptionDao
    public Object getAllUserSubscriptions(Continuation<? super List<UserSubscription>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM UserSubscription", 0);
        return CoroutinesRoom.execute(this.f10911a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.UserSubscriptionDao
    public Object getSubscriptionByUserId(int i4, Continuation<? super UserSubscription> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM UserSubscription WHERE userId == ?", 1);
        acquire.bindLong(1, i4);
        return CoroutinesRoom.execute(this.f10911a, false, DBUtil.createCancellationSignal(), new h(acquire), continuation);
    }
}
