package crashguard.android.library;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.dumpapp.Framer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38897b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38898c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38899d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38900e;

    static {
        String str = "WorkPreference";
        f38897b = str;
        String str2 = new String(new byte[]{112, 114, 101, 102, 101, 114, 101, 110, 99, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 107, 101, 121});
        f38898c = str2;
        String str3 = new String(new byte[]{112, 114, 101, 102, 101, 114, 101, 110, 99, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 118, 97, 108, 117, 101});
        f38899d = str3;
        f38900e = "CREATE TABLE IF NOT EXISTS " + str + " (" + str2 + " TEXT PRIMARY KEY," + str3 + " LONG)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(t4 t4Var) {
        super(t4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m6 a(String str) {
        m6 m6Var;
        String str2 = f38898c;
        Cursor d4 = this.f38710a.d(f38897b, new String[]{"*"}, String.format("%s = '%s'", str2, str), new String[0]);
        try {
            if (d4.moveToFirst()) {
                m6Var = new m6(d4.getString(d4.getColumnIndex(str2)), Long.valueOf(d4.getLong(d4.getColumnIndex(f38899d))));
            } else {
                m6Var = null;
            }
            d4.close();
            return m6Var;
        } catch (Throwable th) {
            if (d4 != null) {
                try {
                    d4.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38900e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase, int i4) {
        if (i4 < 4) {
            sQLiteDatabase.execSQL(f38900e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(m6 m6Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f38898c, m6Var.a());
        contentValues.put(f38899d, m6Var.c());
        this.f38710a.getWritableDatabase().insertWithOnConflict(f38897b, null, contentValues, 5);
    }
}
