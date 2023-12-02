package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;

/* loaded from: classes3.dex */
public interface DatabaseConnectionProvider {
    SQLiteDatabase openDatabase(File file) throws SQLiteException;
}
