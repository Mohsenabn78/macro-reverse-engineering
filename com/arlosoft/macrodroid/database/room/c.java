package com.arlosoft.macrodroid.database.room;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: MacroDroidRoomDatabase_AutoMigration_3_4_Impl.java */
/* loaded from: classes3.dex */
class c extends Migration {
    public c() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ExtraInstalled` (`id` TEXT NOT NULL, `versionString` TEXT NOT NULL, `versionCode` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}
