package com.arlosoft.macrodroid.database.room;

import androidx.annotation.NonNull;
import androidx.autofill.HintConstants;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.arlosoft.macrodroid.action.activities.VariableValuePrompt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes3.dex */
public final class MacroDroidRoomDatabase_Impl extends MacroDroidRoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    private volatile SystemLogEntryDao f10824a;

    /* renamed from: b  reason: collision with root package name */
    private volatile UserSubscriptionDao f10825b;

    /* renamed from: c  reason: collision with root package name */
    private volatile MacroSubscriptionDao f10826c;

    /* renamed from: d  reason: collision with root package name */
    private volatile SubscriptionUpdateItemDao f10827d;

    /* renamed from: e  reason: collision with root package name */
    private volatile BlockedUserDao f10828e;

    /* renamed from: f  reason: collision with root package name */
    private volatile BlockedMacroDao f10829f;

    /* renamed from: g  reason: collision with root package name */
    private volatile ExtraInstalledDao f10830g;

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public BlockedMacroDao blockedMacroDao() {
        BlockedMacroDao blockedMacroDao;
        if (this.f10829f != null) {
            return this.f10829f;
        }
        synchronized (this) {
            if (this.f10829f == null) {
                this.f10829f = new BlockedMacroDao_Impl(this);
            }
            blockedMacroDao = this.f10829f;
        }
        return blockedMacroDao;
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public BlockedUserDao blockedUserDao() {
        BlockedUserDao blockedUserDao;
        if (this.f10828e != null) {
            return this.f10828e;
        }
        synchronized (this) {
            if (this.f10828e == null) {
                this.f10828e = new BlockedUserDao_Impl(this);
            }
            blockedUserDao = this.f10828e;
        }
        return blockedUserDao;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `SystemLogEntry`");
            writableDatabase.execSQL("DELETE FROM `UserSubscription`");
            writableDatabase.execSQL("DELETE FROM `MacroSubscription`");
            writableDatabase.execSQL("DELETE FROM `SubscriptionUpdateItem`");
            writableDatabase.execSQL("DELETE FROM `BlockedUser`");
            writableDatabase.execSQL("DELETE FROM `BlockedMacro`");
            writableDatabase.execSQL("DELETE FROM `ExtraInstalled`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), SystemLogEntry.TABLE_NAME, UserSubscription.TABLE_NAME, MacroSubscription.TABLE_NAME, SubscriptionUpdateItem.TABLE_NAME, BlockedUser.TABLE_NAME, BlockedMacro.TABLE_NAME, ExtraInstalled.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(4), "57e576bfcf4f9857219f33589b309818", "57d334b00016ab2a7ee663b24b57a862")).build());
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public ExtraInstalledDao extraInstalledDao() {
        ExtraInstalledDao extraInstalledDao;
        if (this.f10830g != null) {
            return this.f10830g;
        }
        synchronized (this) {
            if (this.f10830g == null) {
                this.f10830g = new ExtraInstalledDao_Impl(this);
            }
            extraInstalledDao = this.f10830g;
        }
        return extraInstalledDao;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new com.arlosoft.macrodroid.database.room.a(), new b(), new c());
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(SystemLogEntryDao.class, SystemLogEntryDao_Impl.getRequiredConverters());
        hashMap.put(UserSubscriptionDao.class, UserSubscriptionDao_Impl.getRequiredConverters());
        hashMap.put(MacroSubscriptionDao.class, MacroSubscriptionDao_Impl.getRequiredConverters());
        hashMap.put(SubscriptionUpdateItemDao.class, SubscriptionUpdateItemDao_Impl.getRequiredConverters());
        hashMap.put(BlockedUserDao.class, BlockedUserDao_Impl.getRequiredConverters());
        hashMap.put(BlockedMacroDao.class, BlockedMacroDao_Impl.getRequiredConverters());
        hashMap.put(ExtraInstalledDao.class, ExtraInstalledDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public MacroSubscriptionDao macroSubscriptionDao() {
        MacroSubscriptionDao macroSubscriptionDao;
        if (this.f10826c != null) {
            return this.f10826c;
        }
        synchronized (this) {
            if (this.f10826c == null) {
                this.f10826c = new MacroSubscriptionDao_Impl(this);
            }
            macroSubscriptionDao = this.f10826c;
        }
        return macroSubscriptionDao;
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public SubscriptionUpdateItemDao subscriptionUpdateItemDao() {
        SubscriptionUpdateItemDao subscriptionUpdateItemDao;
        if (this.f10827d != null) {
            return this.f10827d;
        }
        synchronized (this) {
            if (this.f10827d == null) {
                this.f10827d = new SubscriptionUpdateItemDao_Impl(this);
            }
            subscriptionUpdateItemDao = this.f10827d;
        }
        return subscriptionUpdateItemDao;
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public SystemLogEntryDao systemLogEntryDao() {
        SystemLogEntryDao systemLogEntryDao;
        if (this.f10824a != null) {
            return this.f10824a;
        }
        synchronized (this) {
            if (this.f10824a == null) {
                this.f10824a = new SystemLogEntryDao_Impl(this);
            }
            systemLogEntryDao = this.f10824a;
        }
        return systemLogEntryDao;
    }

    @Override // com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase
    public UserSubscriptionDao userSubscriptionDao() {
        UserSubscriptionDao userSubscriptionDao;
        if (this.f10825b != null) {
            return this.f10825b;
        }
        synchronized (this) {
            if (this.f10825b == null) {
                this.f10825b = new UserSubscriptionDao_Impl(this);
            }
            userSubscriptionDao = this.f10825b;
        }
        return userSubscriptionDao;
    }

    /* loaded from: classes3.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i4) {
            super(i4);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemLogEntry` (`logLevel` INTEGER NOT NULL, `timeStamp` INTEGER NOT NULL, `logText` TEXT NOT NULL, `macroId` INTEGER NOT NULL, `variableName` TEXT, `geofenceId` TEXT, `webLink` TEXT, `flag` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserSubscription` (`userId` INTEGER NOT NULL, `userName` TEXT NOT NULL, `userImage` TEXT NOT NULL, PRIMARY KEY(`userId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MacroSubscription` (`macroId` INTEGER NOT NULL, `macroName` TEXT NOT NULL, PRIMARY KEY(`macroId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SubscriptionUpdateItem` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `macroId` INTEGER NOT NULL, `macroName` TEXT NOT NULL, `username` TEXT NOT NULL, `userId` INTEGER NOT NULL, `userImage` TEXT NOT NULL, `comment` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BlockedUser` (`userId` INTEGER NOT NULL, `username` TEXT NOT NULL, PRIMARY KEY(`userId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BlockedMacro` (`macroId` INTEGER NOT NULL, `macroName` TEXT NOT NULL, PRIMARY KEY(`macroId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ExtraInstalled` (`id` TEXT NOT NULL, `versionString` TEXT NOT NULL, `versionCode` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '57e576bfcf4f9857219f33589b309818')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemLogEntry`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserSubscription`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MacroSubscription`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SubscriptionUpdateItem`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `BlockedUser`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `BlockedMacro`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ExtraInstalled`");
            if (((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.get(i4)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.get(i4)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            MacroDroidRoomDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) MacroDroidRoomDatabase_Impl.this).mCallbacks.get(i4)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(9);
            hashMap.put("logLevel", new TableInfo.Column("logLevel", "INTEGER", true, 0, null, 1));
            hashMap.put("timeStamp", new TableInfo.Column("timeStamp", "INTEGER", true, 0, null, 1));
            hashMap.put("logText", new TableInfo.Column("logText", "TEXT", true, 0, null, 1));
            hashMap.put("macroId", new TableInfo.Column("macroId", "INTEGER", true, 0, null, 1));
            hashMap.put(VariableValuePrompt.EXTRA_VARIABLE_NAME, new TableInfo.Column(VariableValuePrompt.EXTRA_VARIABLE_NAME, "TEXT", false, 0, null, 1));
            hashMap.put("geofenceId", new TableInfo.Column("geofenceId", "TEXT", false, 0, null, 1));
            hashMap.put("webLink", new TableInfo.Column("webLink", "TEXT", false, 0, null, 1));
            hashMap.put("flag", new TableInfo.Column("flag", "INTEGER", true, 0, null, 1));
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            TableInfo tableInfo = new TableInfo(SystemLogEntry.TABLE_NAME, hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, SystemLogEntry.TABLE_NAME);
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "SystemLogEntry(com.arlosoft.macrodroid.database.room.SystemLogEntry).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, 1));
            hashMap2.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, 1));
            hashMap2.put("userImage", new TableInfo.Column("userImage", "TEXT", true, 0, null, 1));
            TableInfo tableInfo2 = new TableInfo(UserSubscription.TABLE_NAME, hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, UserSubscription.TABLE_NAME);
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "UserSubscription(com.arlosoft.macrodroid.database.room.UserSubscription).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("macroId", new TableInfo.Column("macroId", "INTEGER", true, 1, null, 1));
            hashMap3.put("macroName", new TableInfo.Column("macroName", "TEXT", true, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo(MacroSubscription.TABLE_NAME, hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, MacroSubscription.TABLE_NAME);
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "MacroSubscription(com.arlosoft.macrodroid.database.room.MacroSubscription).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(9);
            hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap4.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
            hashMap4.put("macroId", new TableInfo.Column("macroId", "INTEGER", true, 0, null, 1));
            hashMap4.put("macroName", new TableInfo.Column("macroName", "TEXT", true, 0, null, 1));
            hashMap4.put(HintConstants.AUTOFILL_HINT_USERNAME, new TableInfo.Column(HintConstants.AUTOFILL_HINT_USERNAME, "TEXT", true, 0, null, 1));
            hashMap4.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, 1));
            hashMap4.put("userImage", new TableInfo.Column("userImage", "TEXT", true, 0, null, 1));
            hashMap4.put(ClientCookie.COMMENT_ATTR, new TableInfo.Column(ClientCookie.COMMENT_ATTR, "TEXT", true, 0, null, 1));
            hashMap4.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo4 = new TableInfo(SubscriptionUpdateItem.TABLE_NAME, hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, SubscriptionUpdateItem.TABLE_NAME);
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "SubscriptionUpdateItem(com.arlosoft.macrodroid.database.room.SubscriptionUpdateItem).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, 1));
            hashMap5.put(HintConstants.AUTOFILL_HINT_USERNAME, new TableInfo.Column(HintConstants.AUTOFILL_HINT_USERNAME, "TEXT", true, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo(BlockedUser.TABLE_NAME, hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, BlockedUser.TABLE_NAME);
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "BlockedUser(com.arlosoft.macrodroid.database.room.BlockedUser).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("macroId", new TableInfo.Column("macroId", "INTEGER", true, 1, null, 1));
            hashMap6.put("macroName", new TableInfo.Column("macroName", "TEXT", true, 0, null, 1));
            TableInfo tableInfo6 = new TableInfo(BlockedMacro.TABLE_NAME, hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase, BlockedMacro.TABLE_NAME);
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "BlockedMacro(com.arlosoft.macrodroid.database.room.BlockedMacro).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(3);
            hashMap7.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
            hashMap7.put("versionString", new TableInfo.Column("versionString", "TEXT", true, 0, null, 1));
            hashMap7.put("versionCode", new TableInfo.Column("versionCode", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo(ExtraInstalled.TABLE_NAME, hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase, ExtraInstalled.TABLE_NAME);
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "ExtraInstalled(com.arlosoft.macrodroid.database.room.ExtraInstalled).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
