package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.common.net.HttpHeaders;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38939b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38940c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38941d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38942e;

    static {
        String str = "AIH";
        f38939b = str;
        String str2 = "id";
        f38940c = str2;
        String str3 = "timestamp";
        f38941d = str3;
        f38942e = "CREATE TABLE IF NOT EXISTS " + str + " (" + str2 + " TEXT PRIMARY KEY," + str3 + " TEXT)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(t4 t4Var) {
        super(t4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList a() {
        LinkedList linkedList = new LinkedList();
        Cursor d4 = this.f38710a.d(f38939b, new String[]{"*"}, null, new String[0]);
        if (d4 != null) {
            while (d4.moveToNext()) {
                try {
                    linkedList.add(new d0(d4.getString(d4.getColumnIndex(f38940c)), d4.getString(d4.getColumnIndex(f38941d))));
                } catch (Throwable th) {
                    try {
                        d4.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
        if (d4 != null) {
            d4.close();
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38942e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(d0 d0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f38940c, d0Var.a());
        contentValues.put(f38941d, d0Var.b());
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f38939b, null, contentValues);
    }
}
