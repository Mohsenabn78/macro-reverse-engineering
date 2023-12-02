package com.oneclickaway.opensource.placeautocomplete.data.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes6.dex */
public class RecentSearchesDB_Impl extends RecentSearchesDB {
    private volatile RecentSearchesDAO _recentSearchesDAO;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `SearchSelectedItem`");
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
        return new InvalidationTracker(this, "SearchSelectedItem");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.oneclickaway.opensource.placeautocomplete.data.room.RecentSearchesDB_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SearchSelectedItem` (`placeId` TEXT NOT NULL, `mainText` TEXT NOT NULL, `secondaryText` TEXT NOT NULL, `searchCurrentMilliseconds` INTEGER NOT NULL, PRIMARY KEY(`placeId`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2834631d190c588254cbab58905bf1ce\")");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SearchSelectedItem`");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks.get(i4)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) RecentSearchesDB_Impl.this).mDatabase = supportSQLiteDatabase;
                RecentSearchesDB_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RecentSearchesDB_Impl.this).mCallbacks.get(i4)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("placeId", new TableInfo.Column("placeId", "TEXT", true, 1));
                hashMap.put("mainText", new TableInfo.Column("mainText", "TEXT", true, 0));
                hashMap.put("secondaryText", new TableInfo.Column("secondaryText", "TEXT", true, 0));
                hashMap.put("searchCurrentMilliseconds", new TableInfo.Column("searchCurrentMilliseconds", "INTEGER", true, 0));
                TableInfo tableInfo = new TableInfo("SearchSelectedItem", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "SearchSelectedItem");
                if (tableInfo.equals(read)) {
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle SearchSelectedItem(com.oneclickaway.opensource.placeautocomplete.data.model.room.SearchSelectedItem).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "2834631d190c588254cbab58905bf1ce", "183011075d39413cc896da69642f3e06")).build());
    }

    @Override // com.oneclickaway.opensource.placeautocomplete.data.room.RecentSearchesDB
    public RecentSearchesDAO repDao() {
        RecentSearchesDAO recentSearchesDAO;
        if (this._recentSearchesDAO != null) {
            return this._recentSearchesDAO;
        }
        synchronized (this) {
            if (this._recentSearchesDAO == null) {
                this._recentSearchesDAO = new RecentSearchesDAO_Impl(this);
            }
            recentSearchesDAO = this._recentSearchesDAO;
        }
        return recentSearchesDAO;
    }
}
