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
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes3.dex */
public final class SubscriptionUpdateItemDao_Impl implements SubscriptionUpdateItemDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10860a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<SubscriptionUpdateItem> f10861b;

    /* renamed from: c  reason: collision with root package name */
    private final Converters f10862c = new Converters();

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10863d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f10864e;

    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<SubscriptionUpdateItem> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, SubscriptionUpdateItem subscriptionUpdateItem) {
            supportSQLiteStatement.bindLong(1, subscriptionUpdateItem.getId());
            supportSQLiteStatement.bindLong(2, SubscriptionUpdateItemDao_Impl.this.f10862c.subscriptionUpdateTypeToIndex(subscriptionUpdateItem.getType()));
            supportSQLiteStatement.bindLong(3, subscriptionUpdateItem.getMacroId());
            if (subscriptionUpdateItem.getMacroName() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, subscriptionUpdateItem.getMacroName());
            }
            if (subscriptionUpdateItem.getUsername() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, subscriptionUpdateItem.getUsername());
            }
            supportSQLiteStatement.bindLong(6, subscriptionUpdateItem.getUserId());
            if (subscriptionUpdateItem.getUserImage() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, subscriptionUpdateItem.getUserImage());
            }
            if (subscriptionUpdateItem.getComment() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, subscriptionUpdateItem.getComment());
            }
            supportSQLiteStatement.bindLong(9, subscriptionUpdateItem.getTimestamp());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SubscriptionUpdateItem` (`id`,`type`,`macroId`,`macroName`,`username`,`userId`,`userImage`,`comment`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }
    }

    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SubscriptionUpdateItem";
        }
    }

    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SubscriptionUpdateItem WHERE id == ?";
        }
    }

    /* loaded from: classes3.dex */
    class d implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SubscriptionUpdateItem f10868a;

        d(SubscriptionUpdateItem subscriptionUpdateItem) {
            this.f10868a = subscriptionUpdateItem;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            SubscriptionUpdateItemDao_Impl.this.f10860a.beginTransaction();
            try {
                long insertAndReturnId = SubscriptionUpdateItemDao_Impl.this.f10861b.insertAndReturnId(this.f10868a);
                SubscriptionUpdateItemDao_Impl.this.f10860a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                SubscriptionUpdateItemDao_Impl.this.f10860a.endTransaction();
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
            SupportSQLiteStatement acquire = SubscriptionUpdateItemDao_Impl.this.f10863d.acquire();
            SubscriptionUpdateItemDao_Impl.this.f10860a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SubscriptionUpdateItemDao_Impl.this.f10860a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                SubscriptionUpdateItemDao_Impl.this.f10860a.endTransaction();
                SubscriptionUpdateItemDao_Impl.this.f10863d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f10871a;

        f(long j4) {
            this.f10871a = j4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SubscriptionUpdateItemDao_Impl.this.f10864e.acquire();
            acquire.bindLong(1, this.f10871a);
            SubscriptionUpdateItemDao_Impl.this.f10860a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SubscriptionUpdateItemDao_Impl.this.f10860a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                SubscriptionUpdateItemDao_Impl.this.f10860a.endTransaction();
                SubscriptionUpdateItemDao_Impl.this.f10864e.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements Callable<List<SubscriptionUpdateItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10873a;

        g(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10873a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<SubscriptionUpdateItem> call() throws Exception {
            String string;
            String string2;
            String string3;
            String string4;
            Cursor query = DBUtil.query(SubscriptionUpdateItemDao_Impl.this.f10860a, this.f10873a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "macroId");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "macroName");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, HintConstants.AUTOFILL_HINT_USERNAME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "userId");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "userImage");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ClientCookie.COMMENT_ATTR);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    long j4 = query.getLong(columnIndexOrThrow);
                    SubcriptionUpdateType indexToSubscriptionUpdateType = SubscriptionUpdateItemDao_Impl.this.f10862c.indexToSubscriptionUpdateType(query.getInt(columnIndexOrThrow2));
                    int i4 = query.getInt(columnIndexOrThrow3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow5);
                    }
                    int i5 = query.getInt(columnIndexOrThrow6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow8);
                    }
                    arrayList.add(new SubscriptionUpdateItem(j4, indexToSubscriptionUpdateType, i4, string, string2, i5, string3, string4, query.getLong(columnIndexOrThrow9)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10873a.release();
            }
        }
    }

    public SubscriptionUpdateItemDao_Impl(RoomDatabase roomDatabase) {
        this.f10860a = roomDatabase;
        this.f10861b = new a(roomDatabase);
        this.f10863d = new b(roomDatabase);
        this.f10864e = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao
    public Object addSubscriptionUpdateItem(SubscriptionUpdateItem subscriptionUpdateItem, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10860a, true, new d(subscriptionUpdateItem), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10860a, true, new e(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao
    public Object deleteSubscriptionUpdateItem(long j4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10860a, true, new f(j4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao
    public Object getAllSubscriptionUpdateItems(Continuation<? super List<SubscriptionUpdateItem>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SubscriptionUpdateItem ORDER BY timestamp DESC", 0);
        return CoroutinesRoom.execute(this.f10860a, false, DBUtil.createCancellationSignal(), new g(acquire), continuation);
    }
}
