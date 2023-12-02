package com.arlosoft.macrodroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DatabaseHelper.java */
/* loaded from: classes3.dex */
class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "MacroDroid", (SQLiteDatabase.CursorFactory) null, 13);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE lastRunTime (macro_guid LONG PRIMARY KEY, last_run_time LONG, previous_run_time LONG)");
        sQLiteDatabase.execSQL("CREATE TABLE cellTowerRecords (id LONG PRIMARY KEY, cell_id TEXT, timestamp LONG)");
        sQLiteDatabase.execSQL("CREATE TABLE cellTowerIgnore (id LONG PRIMARY KEY, cell_id TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE floatingButtons (trigger_id LONG PRIMARY KEY, x_location LONG, y_location LONG, x_location_landscape LONG DEFAULT -9999, y_location_landscape LONG DEFAULT -9999)");
        sQLiteDatabase.execSQL("CREATE TABLE recentMacros (id LONG PRIMARY KEY, last_run_time LONG, macro_guid LONG)");
        sQLiteDatabase.execSQL("CREATE TABLE floatingTexts (id TEXT PRIMARY KEY, value TEXT, x_position REAL, y_position REAL, text_color LONG, bg_color LONG, padding LONG, text_size LONG, corners LONG, alpha LONG, is_visible LONG, trigger_context_info TEXT, macro_id LONG DEFAULT -1, alignment LONG, shown_timestamp LONG, auto_hide_delay LONG, html_formatting INT, show_over_status_bar INT, prevent_remove_by_drag INT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        switch (i4) {
            case 1:
                sQLiteDatabase.execSQL("CREATE TABLE cellTowerRecords (id LONG PRIMARY KEY, cell_id TEXT, timestamp LONG)");
                sQLiteDatabase.execSQL("CREATE TABLE cellTowerIgnore (id LONG PRIMARY KEY, cell_id TEXT)");
            case 2:
                sQLiteDatabase.execSQL("CREATE TABLE floatingButtons (trigger_id LONG PRIMARY KEY, x_location INTEGER, y_location INTEGER)");
            case 3:
                sQLiteDatabase.execSQL("CREATE TABLE recentMacros (id LONG PRIMARY KEY, last_run_time LONG, macro_guid LONG)");
            case 4:
                sQLiteDatabase.execSQL("ALTER TABLE lastRunTime ADD COLUMN previous_run_time LONG");
            case 5:
                sQLiteDatabase.execSQL("ALTER TABLE floatingButtons ADD COLUMN x_location_landscape LONG DEFAULT -9999");
                sQLiteDatabase.execSQL("ALTER TABLE floatingButtons ADD COLUMN y_location_landscape LONG DEFAULT -9999");
            case 6:
                sQLiteDatabase.execSQL("CREATE TABLE floatingTexts (id TEXT PRIMARY KEY, value TEXT, x_position REAL, y_position REAL, text_color LONG, bg_color LONG, padding LONG, text_size LONG, corners LONG, alpha LONG, is_visible LONG, trigger_context_info TEXT)");
            case 7:
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN macro_id LONG DEFAULT -1");
            case 8:
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN alignment LONG DEFAULT 0");
            case 9:
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN shown_timestamp LONG DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts Add COLUMN auto_hide_delay LONG DEFAULT 0");
            case 10:
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN html_formatting INT DEFAULT 0");
            case 11:
                sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN show_over_status_bar INT DEFAULT 0");
                break;
            case 12:
                break;
            default:
                return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE floatingTexts ADD COLUMN prevent_remove_by_drag INT DEFAULT 0");
    }
}
