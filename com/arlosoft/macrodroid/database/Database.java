package com.arlosoft.macrodroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.data.CellTowerRecord;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class Database {

    /* renamed from: c  reason: collision with root package name */
    private static Database f10748c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f10749d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static HashMap<Long, Long> f10750e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<Long, Long> f10751f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final a f10752a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f10753b;

    private Database(Context context) {
        this.f10752a = new a(context);
        a();
    }

    private synchronized void a() {
        if (this.f10753b == null) {
            try {
                this.f10753b = this.f10752a.getWritableDatabase();
            } catch (SQLiteException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
                SystemLog.logError("Failed to open database: " + e4.toString());
            }
        }
    }

    private boolean b(long j4) {
        boolean z3 = true;
        Cursor query = this.f10753b.query("floatingButtons", new String[]{"trigger_id"}, "trigger_id=?", new String[]{String.valueOf(j4)}, null, null, null);
        try {
            if (query.getCount() <= 0) {
                z3 = false;
            }
            query.close();
            return z3;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private boolean c(String str) {
        boolean z3 = true;
        Cursor query = this.f10753b.query("floatingTexts", new String[]{"id"}, "id=?", new String[]{str}, null, null, null);
        try {
            if (query.getCount() <= 0) {
                z3 = false;
            }
            query.close();
            return z3;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static synchronized Database getInstance(Context context) {
        Database database;
        synchronized (Database.class) {
            synchronized (f10749d) {
                if (f10748c == null) {
                    f10748c = new Database(context);
                }
            }
            database = f10748c;
        }
        return database;
    }

    public void addCellTowerRecord(String str, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cell_id", str);
        contentValues.put("timestamp", Long.valueOf(j4));
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insertWithOnConflict("cellTowerRecords", null, contentValues, 5);
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException unused) {
            }
        }
    }

    public void clearAllIgnoreTowers() {
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.delete("cellTowerIgnore", null, null);
        }
    }

    public void configureFloatingText(String str, String str2, float f4, float f5, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3, boolean z4, long j4, boolean z5, int i11, boolean z6, boolean z7, boolean z8, TriggerContextInfo triggerContextInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", str);
        contentValues.put("value", str2);
        contentValues.put("text_color", Integer.valueOf(i4));
        contentValues.put("bg_color", Integer.valueOf(i5));
        contentValues.put("padding", Integer.valueOf(i6));
        contentValues.put("text_size", Integer.valueOf(i7));
        contentValues.put("corners", Integer.valueOf(i8));
        contentValues.put("alignment", Integer.valueOf(i9));
        contentValues.put("alpha", Integer.valueOf(i10));
        contentValues.put("is_visible", Boolean.valueOf(z3));
        contentValues.put(TemplateCommentsActivity.EXTRA_MACRO_ID, Long.valueOf(j4));
        contentValues.put("auto_hide_delay", Long.valueOf(z5 ? i11 * 1000 : 0L));
        contentValues.put("shown_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("html_formatting", Boolean.valueOf(z6));
        contentValues.put("show_over_status_bar", Boolean.valueOf(z7));
        contentValues.put("prevent_remove_by_drag", Boolean.valueOf(z8));
        contentValues.put("trigger_context_info", GsonUtils.getGsonBuilder().create().toJson(triggerContextInfo));
        a();
        if (this.f10753b != null) {
            try {
                if (c(str)) {
                    if (z4) {
                        contentValues.put("x_position", Float.valueOf(f4));
                        contentValues.put("y_position", Float.valueOf(f5));
                    }
                    this.f10753b.update("floatingTexts", contentValues, "id=?", new String[]{str});
                    return;
                }
                contentValues.put("x_position", Float.valueOf(f4));
                contentValues.put("y_position", Float.valueOf(f5));
                this.f10753b.insert("floatingTexts", null, contentValues);
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException e4) {
                SystemLog.logDebug("Failed to set floating texts in database: " + e4.toString());
            }
        }
    }

    public List<FloatingTextData> getFloatingTexts(boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        TriggerContextInfo triggerContextInfo;
        a();
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("floatingTexts", null, null, null, null, null, null);
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("id"));
                    String string2 = query.getString(query.getColumnIndex("value"));
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str = string2;
                    float f4 = query.getFloat(query.getColumnIndex("x_position"));
                    float f5 = query.getFloat(query.getColumnIndex("y_position"));
                    int i4 = query.getInt(query.getColumnIndex("text_color"));
                    int i5 = query.getInt(query.getColumnIndex("bg_color"));
                    int i6 = query.getInt(query.getColumnIndex("padding"));
                    int i7 = query.getInt(query.getColumnIndex("text_size"));
                    int i8 = query.getInt(query.getColumnIndex("corners"));
                    int i9 = query.getInt(query.getColumnIndex("alignment"));
                    int i10 = query.getInt(query.getColumnIndex("alpha"));
                    if (query.getInt(query.getColumnIndex("is_visible")) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    long j4 = query.getLong(query.getColumnIndex(TemplateCommentsActivity.EXTRA_MACRO_ID));
                    long j5 = query.getLong(query.getColumnIndex("auto_hide_delay"));
                    long j6 = query.getLong(query.getColumnIndex("shown_timestamp"));
                    if (query.getInt(query.getColumnIndex("html_formatting")) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (query.getInt(query.getColumnIndex("show_over_status_bar")) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (query.getInt(query.getColumnIndex("prevent_remove_by_drag")) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String string3 = query.getString(query.getColumnIndex("trigger_context_info"));
                    try {
                        triggerContextInfo = (TriggerContextInfo) GsonUtils.getGsonBuilder().create().fromJson(string3, (Class<Object>) TriggerContextInfo.class);
                    } catch (Exception e4) {
                        FirebaseAnalyticsEventLogger.log(string3);
                        FirebaseAnalyticsEventLogger.logHandledException(e4);
                        triggerContextInfo = null;
                    }
                    arrayList.add(new FloatingTextData(string, str, f4, f5, i4, i5, i7, i6, i8, i9, i10, z4, j4, j5, j6, z5, z6, z7, triggerContextInfo));
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return arrayList;
    }

    public Set<String> getIgnoreCellTowerSet() {
        HashSet hashSet = new HashSet();
        String[] strArr = {"cell_id"};
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("cellTowerIgnore", strArr, null, null, null, null, "cell_id ASC");
            if (query != null) {
                try {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        hashSet.add(query.getString(0));
                        query.moveToNext();
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return hashSet;
    }

    public List<String> getIgnoreCellTowers() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"cell_id"};
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("cellTowerIgnore", strArr, null, null, null, null, "cell_id ASC");
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    arrayList.add(query.getString(0));
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return arrayList;
    }

    public long getLastRunTime(long j4) {
        String[] strArr = {"last_run_time"};
        String[] strArr2 = {String.valueOf(j4)};
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        long j5 = 0;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("lastRunTime", strArr, "macro_guid=?", strArr2, null, null, null);
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    j5 = query.getLong(0);
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return j5;
    }

    public HashMap<Long, Long> getLastRunTimes() {
        HashMap<Long, Long> hashMap = new HashMap<>();
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("lastRunTime", new String[]{"macro_guid", "last_run_time"}, null, null, null, null, null);
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    hashMap.put(Long.valueOf(query.getLong(0)), Long.valueOf(query.getLong(1)));
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return hashMap;
    }

    public List<Pair<Long, Long>> getLastRunTimesList(int i4) {
        ArrayList arrayList = new ArrayList();
        try {
            a();
            SQLiteDatabase sQLiteDatabase = this.f10753b;
            if (sQLiteDatabase != null) {
                Cursor query = sQLiteDatabase.query("recentMacros", new String[]{"macro_guid", "last_run_time"}, null, null, null, null, "last_run_time DESC");
                query.moveToFirst();
                while (!query.isAfterLast() && query.getPosition() < i4 + 1) {
                    arrayList.add(new Pair(Long.valueOf(query.getLong(0)), Long.valueOf(query.getLong(1))));
                    query.moveToNext();
                }
                query.close();
            }
        } catch (SQLiteException e4) {
            SystemLog.logVerbose("Database error: " + e4.toString());
        }
        return arrayList;
    }

    public List<CellTowerRecord> getLatestCellTowerRecords(long j4) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"cell_id", "timestamp"};
        String[] strArr2 = {String.valueOf(j4)};
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("cellTowerRecords", strArr, "timestamp > ?", strArr2, null, null, "timestamp DESC");
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    arrayList.add(new CellTowerRecord(query.getString(0), query.getLong(1)));
                    query.moveToNext();
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return arrayList;
    }

    public Pair<Integer, Integer> getLocationOfFloatingButton(long j4, boolean z3, int i4, int i5, int i6) {
        String[] strArr = {"trigger_id", "x_location", "y_location", "x_location_landscape", "y_location_landscape"};
        int i7 = 0;
        String[] strArr2 = {String.valueOf(j4)};
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query("floatingButtons", strArr, "trigger_id=?", strArr2, null, null, null);
            try {
                query.moveToFirst();
                long j5 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (!query.isAfterLast()) {
                    j5 = query.getInt(query.getColumnIndex("trigger_id"));
                    i9 = query.getInt(query.getColumnIndex("x_location"));
                    i10 = query.getInt(query.getColumnIndex("y_location"));
                    i7 = query.getInt(query.getColumnIndex("x_location_landscape"));
                    i8 = query.getInt(query.getColumnIndex("y_location_landscape"));
                    query.moveToNext();
                }
                if (z3) {
                    Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(i9), Integer.valueOf(i10));
                    query.close();
                    return pair;
                }
                if (i7 == -9999 && i8 == -9999) {
                    int i11 = i4 - i6;
                    int i12 = i5 - i6;
                    i7 = (int) ((i9 / (i12 / 2)) * (i11 / 2));
                    i8 = (int) ((i10 / (i11 / 2)) * (i12 / 2));
                    setLocationOfFloatingButtonLandscape(j5, i7, i8);
                }
                Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(i7), Integer.valueOf(i8));
                query.close();
                return pair2;
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public long getPreviousRunTime(long j4) {
        Long l4 = f10751f.get(Long.valueOf(j4));
        if (l4 == null) {
            return 0L;
        }
        return l4.longValue();
    }

    public void hideAllFloatingTexts() {
        for (FloatingTextData floatingTextData : getFloatingTexts(true)) {
            hideFloatingText(floatingTextData.getId());
        }
    }

    public void hideFloatingText(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", str);
        contentValues.put("is_visible", Boolean.FALSE);
        a();
        if (this.f10753b != null) {
            try {
                if (c(str)) {
                    this.f10753b.update("floatingTexts", contentValues, "id=?", new String[]{str});
                } else {
                    SystemLog.logWarning("Cannot hide floating text with id: " + str + " (not found)");
                }
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException e4) {
                SystemLog.logDebug("Failed to set floating texts in database: " + e4.toString());
            }
        }
    }

    public void refreshPreviousUpdateTime(long j4) {
        Long l4 = f10750e.get(Long.valueOf(j4));
        if (l4 != null) {
            f10751f.put(Long.valueOf(j4), l4);
        }
    }

    public void removeAllCellTowerRecordsBefore(long j4) {
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("cellTowerRecords", "timestamp < ?", new String[]{String.valueOf(j4)});
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException unused) {
            }
        }
    }

    public void setIgnoreCellTowerState(String str, boolean z3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cell_id", str);
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            if (z3) {
                try {
                    sQLiteDatabase.insertWithOnConflict("cellTowerIgnore", null, contentValues, 5);
                    return;
                } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException unused) {
                    return;
                }
            }
            sQLiteDatabase.delete("cellTowerIgnore", "cell_id = ?", new String[]{str});
        }
    }

    public void setLastUpdateTime(long j4, long j5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("macro_guid", Long.valueOf(j4));
        contentValues.put("last_run_time", Long.valueOf(j5));
        if (f10751f.get(Long.valueOf(j4)) == null) {
            f10751f.put(Long.valueOf(j4), Long.valueOf(getLastRunTime(j4)));
        }
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("recentMacros", null, contentValues);
                this.f10753b.insertWithOnConflict("lastRunTime", null, contentValues, 5);
            } catch (SQLiteCantOpenDatabaseException e4) {
                e = e4;
                SystemLog.logError("Failed to update last run time: " + e);
            } catch (SQLiteReadOnlyDatabaseException e5) {
                e = e5;
                SystemLog.logError("Failed to update last run time: " + e);
            } catch (SQLiteException e6) {
                FirebaseAnalyticsEventLogger.logHandledException(e6);
                SystemLog.logError("Failed to update last run time: " + e6);
            } catch (IllegalStateException e7) {
                e = e7;
                SystemLog.logError("Failed to update last run time: " + e);
            }
        }
    }

    public void setLastUpdateTimeInstant(long j4, long j5) {
        f10750e.put(Long.valueOf(j4), Long.valueOf(j5));
    }

    public void setLocationOfFloatingButtonLandscape(long j4, int i4, int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("trigger_id", String.valueOf(j4));
        contentValues.put("x_location_landscape", Integer.valueOf(i4));
        contentValues.put("y_location_landscape", Integer.valueOf(i5));
        a();
        if (this.f10753b != null) {
            try {
                if (b(j4)) {
                    this.f10753b.update("floatingButtons", contentValues, "trigger_id=?", new String[]{String.valueOf(j4)});
                } else {
                    this.f10753b.insert("floatingButtons", null, contentValues);
                }
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException unused) {
            }
        }
    }

    public void setLocationOfFloatingButtonPortrait(long j4, int i4, int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("trigger_id", String.valueOf(j4));
        contentValues.put("x_location", Integer.valueOf(i4));
        contentValues.put("y_location", Integer.valueOf(i5));
        a();
        if (this.f10753b != null) {
            try {
                if (b(j4)) {
                    this.f10753b.update("floatingButtons", contentValues, "trigger_id=?", new String[]{String.valueOf(j4)});
                } else {
                    this.f10753b.insert("floatingButtons", null, contentValues);
                }
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException e4) {
                SystemLog.logDebug("Failed to set floating button in database: " + e4.toString());
            }
        }
    }

    public void updateFloatingTextLocation(String str, float f4, float f5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", str);
        contentValues.put("x_position", Float.valueOf(f4));
        contentValues.put("y_position", Float.valueOf(f5));
        a();
        SQLiteDatabase sQLiteDatabase = this.f10753b;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("floatingTexts", contentValues, "id=?", new String[]{str});
            } catch (SQLiteCantOpenDatabaseException | SQLiteReadOnlyDatabaseException e4) {
                SystemLog.logDebug("Failed to set floating texts in database: " + e4.toString());
            }
        }
    }

    public static Database getInstance() {
        synchronized (f10749d) {
            if (f10748c == null) {
                f10748c = new Database(MacroDroidApplication.getInstance());
            }
        }
        return f10748c;
    }
}
