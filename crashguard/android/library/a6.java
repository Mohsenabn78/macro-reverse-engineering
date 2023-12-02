package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.net.HttpHeaders;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a6 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38616b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38617c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38618d;

    /* renamed from: e  reason: collision with root package name */
    static final String f38619e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f38620f;

    static {
        String str = "WorkLock";
        f38616b = str;
        String str2 = new String(new byte[]{117, 110, 105, 113, 117, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 110, 97, 109, 101});
        f38617c = str2;
        String str3 = new String(new byte[]{119, 111, 114, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 112, 101, 99, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 100});
        f38618d = str3;
        String str4 = "timestamp";
        f38619e = str4;
        f38620f = "CREATE TABLE IF NOT EXISTS " + str + " (" + str2 + " TEXT PRIMARY KEY," + str3 + " TEXT NOT NULL DEFAULT ''," + str4 + " LONG)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a6(t4 t4Var) {
        super(t4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final w5 a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        String str3 = f38617c;
        contentValues.put(str3, str);
        String str4 = f38618d;
        contentValues.put(str4, str2);
        String str5 = f38619e;
        contentValues.put(str5, Long.valueOf(currentTimeMillis));
        String format = String.format("%s = '%s'", str3, str);
        try {
            t4 t4Var = this.f38710a;
            String str6 = f38616b;
            Cursor d4 = t4Var.d(str6, new String[]{"*"}, format, new String[0]);
            if (d4.moveToFirst()) {
                if (Math.abs(d4.getLong(d4.getColumnIndex(str5)) - currentTimeMillis) >= 600000) {
                    this.f38710a.getWritableDatabase().update(str6, contentValues, format, new String[0]);
                    w5 w5Var = new w5(true);
                    d4.close();
                    return w5Var;
                }
                d4.getString(d4.getColumnIndex(str4));
                d4.getLong(d4.getColumnIndex(str5));
                w5 w5Var2 = new w5(false);
                d4.close();
                return w5Var2;
            }
            this.f38710a.getWritableDatabase().insert(str6, null, contentValues);
            w5 w5Var3 = new w5(true);
            d4.close();
            return w5Var3;
        } catch (Throwable unused) {
            return new w5(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38620f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase, int i4) {
        if (i4 < 2) {
            sQLiteDatabase.execSQL(f38620f);
        }
        if (i4 < 5) {
            try {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE WorkerState RENAME TO %s", f38616b));
            } catch (Throwable unused) {
            }
            try {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT NOT NULL DEFAULT ''", f38616b, f38618d));
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        this.f38710a.c(f38616b, String.format("%s = '%s'", f38617c, str), new String[0]);
    }
}
