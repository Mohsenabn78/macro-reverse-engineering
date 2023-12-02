package com.arlosoft.macrodroid.database.room;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: MacroDroidRoomDatabase_AutoMigration_2_3_Impl.java */
/* loaded from: classes3.dex */
class b extends Migration {
    public b() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BlockedUser` (`userId` INTEGER NOT NULL, `username` TEXT NOT NULL, PRIMARY KEY(`userId`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BlockedMacro` (`macroId` INTEGER NOT NULL, `macroName` TEXT NOT NULL, PRIMARY KEY(`macroId`))");
    }
}
