package com.arlosoft.macrodroid.database.room;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.arlosoft.macrodroid.action.activities.VariableValuePrompt;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final class SystemLogEntryDao_Impl implements SystemLogEntryDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f10884a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<SystemLogEntry> f10885b;

    /* renamed from: c  reason: collision with root package name */
    private final Converters f10886c = new Converters();

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f10887d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f10888e;

    /* loaded from: classes3.dex */
    class a extends LimitOffsetPagingSource<SystemLogEntry> {
        a(RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, String... strArr) {
            super(roomSQLiteQuery, roomDatabase, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.paging.LimitOffsetPagingSource
        public List<SystemLogEntry> convertRows(Cursor cursor) {
            String string;
            String string2;
            String string3;
            String string4;
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursor, "logLevel");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursor, "timeStamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursor, "logText");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursor, "macroId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursor, VariableValuePrompt.EXTRA_VARIABLE_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursor, "geofenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursor, "webLink");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursor, "flag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(cursor.getInt(columnIndexOrThrow));
                long j4 = cursor.getLong(columnIndexOrThrow2);
                if (cursor.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = cursor.getString(columnIndexOrThrow3);
                }
                long j5 = cursor.getLong(columnIndexOrThrow4);
                if (cursor.isNull(columnIndexOrThrow5)) {
                    string2 = null;
                } else {
                    string2 = cursor.getString(columnIndexOrThrow5);
                }
                if (cursor.isNull(columnIndexOrThrow6)) {
                    string3 = null;
                } else {
                    string3 = cursor.getString(columnIndexOrThrow6);
                }
                if (cursor.isNull(columnIndexOrThrow7)) {
                    string4 = null;
                } else {
                    string4 = cursor.getString(columnIndexOrThrow7);
                }
                arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(cursor.getInt(columnIndexOrThrow8)), cursor.getLong(columnIndexOrThrow9)));
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    class b extends LimitOffsetPagingSource<SystemLogEntry> {
        b(RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, String... strArr) {
            super(roomSQLiteQuery, roomDatabase, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.paging.LimitOffsetPagingSource
        public List<SystemLogEntry> convertRows(Cursor cursor) {
            String string;
            String string2;
            String string3;
            String string4;
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursor, "logLevel");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursor, "timeStamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursor, "logText");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursor, "macroId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursor, VariableValuePrompt.EXTRA_VARIABLE_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursor, "geofenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursor, "webLink");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursor, "flag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(cursor.getInt(columnIndexOrThrow));
                long j4 = cursor.getLong(columnIndexOrThrow2);
                if (cursor.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = cursor.getString(columnIndexOrThrow3);
                }
                long j5 = cursor.getLong(columnIndexOrThrow4);
                if (cursor.isNull(columnIndexOrThrow5)) {
                    string2 = null;
                } else {
                    string2 = cursor.getString(columnIndexOrThrow5);
                }
                if (cursor.isNull(columnIndexOrThrow6)) {
                    string3 = null;
                } else {
                    string3 = cursor.getString(columnIndexOrThrow6);
                }
                if (cursor.isNull(columnIndexOrThrow7)) {
                    string4 = null;
                } else {
                    string4 = cursor.getString(columnIndexOrThrow7);
                }
                arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(cursor.getInt(columnIndexOrThrow8)), cursor.getLong(columnIndexOrThrow9)));
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    class c extends LimitOffsetPagingSource<SystemLogEntry> {
        c(RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, String... strArr) {
            super(roomSQLiteQuery, roomDatabase, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.paging.LimitOffsetPagingSource
        public List<SystemLogEntry> convertRows(Cursor cursor) {
            String string;
            String string2;
            String string3;
            String string4;
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursor, "logLevel");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursor, "timeStamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursor, "logText");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursor, "macroId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursor, VariableValuePrompt.EXTRA_VARIABLE_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursor, "geofenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursor, "webLink");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursor, "flag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(cursor.getInt(columnIndexOrThrow));
                long j4 = cursor.getLong(columnIndexOrThrow2);
                if (cursor.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = cursor.getString(columnIndexOrThrow3);
                }
                long j5 = cursor.getLong(columnIndexOrThrow4);
                if (cursor.isNull(columnIndexOrThrow5)) {
                    string2 = null;
                } else {
                    string2 = cursor.getString(columnIndexOrThrow5);
                }
                if (cursor.isNull(columnIndexOrThrow6)) {
                    string3 = null;
                } else {
                    string3 = cursor.getString(columnIndexOrThrow6);
                }
                if (cursor.isNull(columnIndexOrThrow7)) {
                    string4 = null;
                } else {
                    string4 = cursor.getString(columnIndexOrThrow7);
                }
                arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(cursor.getInt(columnIndexOrThrow8)), cursor.getLong(columnIndexOrThrow9)));
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    class d extends LimitOffsetPagingSource<SystemLogEntry> {
        d(SupportSQLiteQuery supportSQLiteQuery, RoomDatabase roomDatabase, String... strArr) {
            super(supportSQLiteQuery, roomDatabase, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.paging.LimitOffsetPagingSource
        public List<SystemLogEntry> convertRows(Cursor cursor) {
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(SystemLogEntryDao_Impl.this.b(cursor));
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    class e implements Callable<List<SystemLogEntry>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupportSQLiteQuery f10893a;

        e(SupportSQLiteQuery supportSQLiteQuery) {
            this.f10893a = supportSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<SystemLogEntry> call() throws Exception {
            Cursor query = DBUtil.query(SystemLogEntryDao_Impl.this.f10884a, this.f10893a, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(SystemLogEntryDao_Impl.this.b(query));
                }
                return arrayList;
            } finally {
                query.close();
            }
        }
    }

    /* loaded from: classes3.dex */
    class f extends EntityInsertionAdapter<SystemLogEntry> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, SystemLogEntry systemLogEntry) {
            supportSQLiteStatement.bindLong(1, SystemLogEntryDao_Impl.this.f10886c.sleepNoteIconToId(systemLogEntry.getLogLevel()));
            supportSQLiteStatement.bindLong(2, systemLogEntry.getTimeStamp());
            if (systemLogEntry.getLogText() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, systemLogEntry.getLogText());
            }
            supportSQLiteStatement.bindLong(4, systemLogEntry.getMacroId());
            if (systemLogEntry.getVariableName() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, systemLogEntry.getVariableName());
            }
            if (systemLogEntry.getGeofenceId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, systemLogEntry.getGeofenceId());
            }
            if (systemLogEntry.getWebLink() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, systemLogEntry.getWebLink());
            }
            supportSQLiteStatement.bindLong(8, SystemLogEntryDao_Impl.this.f10886c.logFlagToIndex(systemLogEntry.getFlag()));
            supportSQLiteStatement.bindLong(9, systemLogEntry.getId());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemLogEntry` (`logLevel`,`timeStamp`,`logText`,`macroId`,`variableName`,`geofenceId`,`webLink`,`flag`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
        }
    }

    /* loaded from: classes3.dex */
    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SystemLogEntry";
        }
    }

    /* loaded from: classes3.dex */
    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SystemLogEntry WHERE id < ?";
        }
    }

    /* loaded from: classes3.dex */
    class i implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SystemLogEntry f10898a;

        i(SystemLogEntry systemLogEntry) {
            this.f10898a = systemLogEntry;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() throws Exception {
            SystemLogEntryDao_Impl.this.f10884a.beginTransaction();
            try {
                long insertAndReturnId = SystemLogEntryDao_Impl.this.f10885b.insertAndReturnId(this.f10898a);
                SystemLogEntryDao_Impl.this.f10884a.setTransactionSuccessful();
                return Long.valueOf(insertAndReturnId);
            } finally {
                SystemLogEntryDao_Impl.this.f10884a.endTransaction();
            }
        }
    }

    /* loaded from: classes3.dex */
    class j implements Callable<Unit> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SystemLogEntryDao_Impl.this.f10887d.acquire();
            SystemLogEntryDao_Impl.this.f10884a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SystemLogEntryDao_Impl.this.f10884a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                SystemLogEntryDao_Impl.this.f10884a.endTransaction();
                SystemLogEntryDao_Impl.this.f10887d.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class k implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f10901a;

        k(long j4) {
            this.f10901a = j4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = SystemLogEntryDao_Impl.this.f10888e.acquire();
            acquire.bindLong(1, this.f10901a);
            SystemLogEntryDao_Impl.this.f10884a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                SystemLogEntryDao_Impl.this.f10884a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                SystemLogEntryDao_Impl.this.f10884a.endTransaction();
                SystemLogEntryDao_Impl.this.f10888e.release(acquire);
            }
        }
    }

    /* loaded from: classes3.dex */
    class l implements Callable<List<SystemLogEntry>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10903a;

        l(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10903a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<SystemLogEntry> call() throws Exception {
            String string;
            String string2;
            String string3;
            String string4;
            Cursor query = DBUtil.query(SystemLogEntryDao_Impl.this.f10884a, this.f10903a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "logLevel");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "logText");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "macroId");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, VariableValuePrompt.EXTRA_VARIABLE_NAME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "geofenceId");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "webLink");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "flag");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(query.getInt(columnIndexOrThrow));
                    long j4 = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    long j5 = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow7);
                    }
                    arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(query.getInt(columnIndexOrThrow8)), query.getLong(columnIndexOrThrow9)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10903a.release();
            }
        }
    }

    /* loaded from: classes3.dex */
    class m implements Callable<List<SystemLogEntry>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f10905a;

        m(RoomSQLiteQuery roomSQLiteQuery) {
            this.f10905a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<SystemLogEntry> call() throws Exception {
            String string;
            String string2;
            String string3;
            String string4;
            Cursor query = DBUtil.query(SystemLogEntryDao_Impl.this.f10884a, this.f10905a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "logLevel");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "logText");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "macroId");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, VariableValuePrompt.EXTRA_VARIABLE_NAME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "geofenceId");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "webLink");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "flag");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(query.getInt(columnIndexOrThrow));
                    long j4 = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow3);
                    }
                    long j5 = query.getLong(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow7);
                    }
                    arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(query.getInt(columnIndexOrThrow8)), query.getLong(columnIndexOrThrow9)));
                }
                return arrayList;
            } finally {
                query.close();
                this.f10905a.release();
            }
        }
    }

    /* loaded from: classes3.dex */
    class n extends LimitOffsetPagingSource<SystemLogEntry> {
        n(RoomSQLiteQuery roomSQLiteQuery, RoomDatabase roomDatabase, String... strArr) {
            super(roomSQLiteQuery, roomDatabase, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.paging.LimitOffsetPagingSource
        public List<SystemLogEntry> convertRows(Cursor cursor) {
            String string;
            String string2;
            String string3;
            String string4;
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursor, "logLevel");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursor, "timeStamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursor, "logText");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursor, "macroId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursor, VariableValuePrompt.EXTRA_VARIABLE_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursor, "geofenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursor, "webLink");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursor, "flag");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                LogLevel idToSleepNoteIcon = SystemLogEntryDao_Impl.this.f10886c.idToSleepNoteIcon(cursor.getInt(columnIndexOrThrow));
                long j4 = cursor.getLong(columnIndexOrThrow2);
                if (cursor.isNull(columnIndexOrThrow3)) {
                    string = null;
                } else {
                    string = cursor.getString(columnIndexOrThrow3);
                }
                long j5 = cursor.getLong(columnIndexOrThrow4);
                if (cursor.isNull(columnIndexOrThrow5)) {
                    string2 = null;
                } else {
                    string2 = cursor.getString(columnIndexOrThrow5);
                }
                if (cursor.isNull(columnIndexOrThrow6)) {
                    string3 = null;
                } else {
                    string3 = cursor.getString(columnIndexOrThrow6);
                }
                if (cursor.isNull(columnIndexOrThrow7)) {
                    string4 = null;
                } else {
                    string4 = cursor.getString(columnIndexOrThrow7);
                }
                arrayList.add(new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, SystemLogEntryDao_Impl.this.f10886c.indexToLogFlag(cursor.getInt(columnIndexOrThrow8)), cursor.getLong(columnIndexOrThrow9)));
            }
            return arrayList;
        }
    }

    public SystemLogEntryDao_Impl(RoomDatabase roomDatabase) {
        this.f10884a = roomDatabase;
        this.f10885b = new f(roomDatabase);
        this.f10887d = new g(roomDatabase);
        this.f10888e = new h(roomDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SystemLogEntry b(Cursor cursor) {
        LogLevel idToSleepNoteIcon;
        long j4;
        String string;
        long j5;
        String string2;
        String string3;
        String string4;
        long j6;
        int columnIndex = CursorUtil.getColumnIndex(cursor, "logLevel");
        int columnIndex2 = CursorUtil.getColumnIndex(cursor, "timeStamp");
        int columnIndex3 = CursorUtil.getColumnIndex(cursor, "logText");
        int columnIndex4 = CursorUtil.getColumnIndex(cursor, "macroId");
        int columnIndex5 = CursorUtil.getColumnIndex(cursor, VariableValuePrompt.EXTRA_VARIABLE_NAME);
        int columnIndex6 = CursorUtil.getColumnIndex(cursor, "geofenceId");
        int columnIndex7 = CursorUtil.getColumnIndex(cursor, "webLink");
        int columnIndex8 = CursorUtil.getColumnIndex(cursor, "flag");
        int columnIndex9 = CursorUtil.getColumnIndex(cursor, "id");
        LogFlag logFlag = null;
        if (columnIndex == -1) {
            idToSleepNoteIcon = null;
        } else {
            idToSleepNoteIcon = this.f10886c.idToSleepNoteIcon(cursor.getInt(columnIndex));
        }
        if (columnIndex2 == -1) {
            j4 = 0;
        } else {
            j4 = cursor.getLong(columnIndex2);
        }
        if (columnIndex3 == -1 || cursor.isNull(columnIndex3)) {
            string = null;
        } else {
            string = cursor.getString(columnIndex3);
        }
        if (columnIndex4 == -1) {
            j5 = 0;
        } else {
            j5 = cursor.getLong(columnIndex4);
        }
        if (columnIndex5 == -1 || cursor.isNull(columnIndex5)) {
            string2 = null;
        } else {
            string2 = cursor.getString(columnIndex5);
        }
        if (columnIndex6 == -1 || cursor.isNull(columnIndex6)) {
            string3 = null;
        } else {
            string3 = cursor.getString(columnIndex6);
        }
        if (columnIndex7 == -1 || cursor.isNull(columnIndex7)) {
            string4 = null;
        } else {
            string4 = cursor.getString(columnIndex7);
        }
        if (columnIndex8 != -1) {
            logFlag = this.f10886c.indexToLogFlag(cursor.getInt(columnIndex8));
        }
        LogFlag logFlag2 = logFlag;
        if (columnIndex9 == -1) {
            j6 = 0;
        } else {
            j6 = cursor.getLong(columnIndex9);
        }
        return new SystemLogEntry(idToSleepNoteIcon, j4, string, j5, string2, string3, string4, logFlag2, j6);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(SystemLogEntry systemLogEntry, int i4, Continuation continuation) {
        return SystemLogEntryDao.DefaultImpls.addLogEntryAndDeleteOld(this, systemLogEntry, i4, continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object addLogEntry(SystemLogEntry systemLogEntry, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.f10884a, true, new i(systemLogEntry), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object addLogEntryAndDeleteOld(final SystemLogEntry systemLogEntry, final int i4, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.f10884a, new Function1() { // from class: com.arlosoft.macrodroid.database.room.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object i5;
                i5 = SystemLogEntryDao_Impl.this.i(systemLogEntry, i4, (Continuation) obj);
                return i5;
            }
        }, continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object clearAll(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10884a, true, new j(), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object deleteBeforeId(long j4, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f10884a, true, new k(j4), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object getAll(LogLevel logLevel, Continuation<? super List<SystemLogEntry>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry WHERE logLevel >= ?", 1);
        acquire.bindLong(1, this.f10886c.sleepNoteIconToId(logLevel));
        return CoroutinesRoom.execute(this.f10884a, false, DBUtil.createCancellationSignal(), new m(acquire), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object getAllFiltered(SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<SystemLogEntry>> continuation) {
        return CoroutinesRoom.execute(this.f10884a, false, DBUtil.createCancellationSignal(), new e(supportSQLiteQuery), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public PagingSource<Integer, SystemLogEntry> getFiltered(SupportSQLiteQuery supportSQLiteQuery) {
        return new d(supportSQLiteQuery, this.f10884a, SystemLogEntry.TABLE_NAME);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public Object getLatest(int i4, int i5, Continuation<? super List<SystemLogEntry>> continuation) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry WHERE logLevel >= ? ORDER BY id DESC LIMIT ?", 2);
        acquire.bindLong(1, i5);
        acquire.bindLong(2, i4);
        return CoroutinesRoom.execute(this.f10884a, false, DBUtil.createCancellationSignal(), new l(acquire), continuation);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public PagingSource<Integer, SystemLogEntry> pagingSourceAll() {
        return new a(RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry ORDER BY id DESC", 0), this.f10884a, SystemLogEntry.TABLE_NAME);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public PagingSource<Integer, SystemLogEntry> pagingSourceFiltered(int i4) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry WHERE logLevel >= ? ORDER BY id DESC ", 1);
        acquire.bindLong(1, i4);
        return new b(acquire, this.f10884a, SystemLogEntry.TABLE_NAME);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public PagingSource<Integer, SystemLogEntry> pagingSourceSearch(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry WHERE logText LIKE ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return new n(acquire, this.f10884a, SystemLogEntry.TABLE_NAME);
    }

    @Override // com.arlosoft.macrodroid.database.room.SystemLogEntryDao
    public PagingSource<Integer, SystemLogEntry> pagingSourceWithFilterAndSearch(String str, LogLevel logLevel) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemLogEntry WHERE logText LIKE ? AND logLevel >= ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, this.f10886c.sleepNoteIconToId(logLevel));
        return new c(acquire, this.f10884a, SystemLogEntry.TABLE_NAME);
    }
}
