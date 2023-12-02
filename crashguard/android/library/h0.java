package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.net.HttpHeaders;
import crashguard.android.library.c0;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h0 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38774b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38775c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38776d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38777e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f38778f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f38779g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f38780h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f38781i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f38782j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f38783k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f38784l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f38785m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f38786n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f38787o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f38788p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f38789q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f38790r;

    static {
        String str = "WorkSpec";
        f38774b = str;
        String str2 = "id";
        f38775c = str2;
        String str3 = new String(new byte[]{115, 121, 115, 116, 101, 109, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 100});
        f38776d = str3;
        String str4 = "tag";
        f38777e = str4;
        String str5 = "state";
        f38778f = str5;
        String str6 = new String(new byte[]{99, 108, 97, 115, 115, Framer.STDIN_REQUEST_FRAME_PREFIX, 110, 97, 109, 101});
        f38779g = str6;
        String str7 = new String(new byte[]{105, 110, 105, 116, 105, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 100, 101, 108, 97, 121});
        f38780h = str7;
        String str8 = new String(new byte[]{105, 110, 116, 101, 114, 118, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 100, 117, 114, 97, 116, 105, 111, 110});
        f38781i = str8;
        String str9 = new String(new byte[]{112, 101, 114, 105, 111, 100, Framer.STDIN_REQUEST_FRAME_PREFIX, 99, 111, 117, 110, 116});
        f38782j = str9;
        String str10 = "generation";
        f38783k = str10;
        String str11 = "data";
        f38784l = str11;
        String str12 = "timestamp";
        f38785m = str12;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(" TEXT PRIMARY KEY,");
        StringBuilder a4 = g.a(g.a(g.a(g.a(sb, str3, " LONG,", str4, " TEXT,"), str5, " TEXT,", str6, " TEXT,"), str7, " LONG,", str8, " LONG,"), str9, " LONG,", str10, " LONG,");
        a4.append(str11);
        a4.append(" BLOB,");
        a4.append(str12);
        a4.append(" LONG)");
        f38786n = a4.toString();
        String str13 = "WorkName";
        f38787o = str13;
        String str14 = "name";
        f38788p = str14;
        String str15 = new String(new byte[]{119, 111, 114, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 112, 101, 99, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 100});
        f38789q = str15;
        f38790r = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT NOT NULL, %s TEXT NOT NULL, PRIMARY KEY(%s, %s), FOREIGN KEY(%s) REFERENCES %s(%s))", str13, str14, str15, str14, str15, str15, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static c0 a(Cursor cursor) {
        c0 c0Var = new c0(cursor.getString(cursor.getColumnIndex(f38779g)));
        c0Var.f(cursor.getString(cursor.getColumnIndex(f38775c)));
        c0Var.i(cursor.getInt(cursor.getColumnIndex(f38776d)));
        c0Var.k(cursor.getString(cursor.getColumnIndex(f38777e)));
        c0Var.b(cursor.getInt(cursor.getColumnIndex(f38778f)));
        c0Var.j(cursor.getLong(cursor.getColumnIndex(f38780h)));
        c0Var.m(cursor.getLong(cursor.getColumnIndex(f38781i)));
        c0Var.o(cursor.getLong(cursor.getColumnIndex(f38782j)));
        c0Var.c(cursor.getLong(cursor.getColumnIndex(f38783k)));
        c0Var.g(cursor.getBlob(cursor.getColumnIndex(f38784l)));
        c0Var.q(cursor.getLong(cursor.getColumnIndex(f38785m)));
        return c0Var;
    }

    private static ContentValues l(c0 c0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f38775c, c0Var.h());
        contentValues.put(f38776d, Integer.valueOf(c0Var.s()));
        contentValues.put(f38777e, c0Var.t());
        contentValues.put(f38778f, Integer.valueOf(c0Var.r().a()));
        contentValues.put(f38779g, c0Var.w());
        contentValues.put(f38780h, Long.valueOf(c0Var.l()));
        contentValues.put(f38781i, Long.valueOf(c0Var.n()));
        contentValues.put(f38782j, Long.valueOf(c0Var.p()));
        contentValues.put(f38783k, Long.valueOf(c0Var.a()));
        contentValues.put(f38784l, c0Var.x().d());
        contentValues.put(f38785m, Long.valueOf(c0Var.u()));
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c0 b(String str) {
        c0 c0Var = null;
        Cursor rawQuery = this.f38710a.getReadableDatabase().rawQuery(String.format("SELECT s.* FROM %s s INNER JOIN %s uw ON (s.%s = uw.%s) WHERE uw.%s = '%s'", f38774b, f38787o, f38775c, f38789q, f38788p, str), null);
        try {
            if (rawQuery.moveToFirst()) {
                c0Var = a(rawQuery);
            }
            rawQuery.close();
            return c0Var;
        } catch (Throwable th) {
            if (rawQuery != null) {
                try {
                    rawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        long currentTimeMillis = System.currentTimeMillis();
        t4 t4Var = this.f38710a;
        String str = f38774b;
        Locale locale = Locale.ENGLISH;
        String str2 = f38785m;
        t4Var.c(str, String.format(locale, "%s = 0 AND (%s + %d) < %d AND (%s + %s) < %d", f38781i, str2, 86400000L, Long.valueOf(currentTimeMillis), str2, f38780h, Long.valueOf(currentTimeMillis)), new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38786n);
        sQLiteDatabase.execSQL(f38790r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(SQLiteDatabase sQLiteDatabase, int i4) {
        if (i4 < 4) {
            sQLiteDatabase.execSQL(f38786n);
            sQLiteDatabase.execSQL(f38790r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(c0 c0Var) {
        this.f38710a.c(f38774b, String.format("%s = '%s'", f38775c, c0Var.h()), new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(String str, c0 c0Var) {
        this.f38710a.getWritableDatabase().beginTransaction();
        try {
            j(c0Var);
            ContentValues contentValues = new ContentValues();
            contentValues.put(f38788p, str);
            contentValues.put(f38789q, c0Var.h());
            this.f38710a.getWritableDatabase().insertWithOnConflict(f38787o, null, contentValues, 5);
            this.f38710a.getWritableDatabase().setTransactionSuccessful();
        } catch (Throwable unused) {
        }
        this.f38710a.getWritableDatabase().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c0 h(String str) {
        c0 c0Var;
        Cursor d4 = this.f38710a.d(f38774b, new String[]{"*"}, String.format("%s = '%s'", f38775c, str), new String[0]);
        try {
            if (d4.moveToFirst()) {
                c0Var = a(d4);
            } else {
                c0Var = null;
            }
            d4.close();
            return c0Var;
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
    public final LinkedList i() {
        Cursor d4 = this.f38710a.d(f38774b, new String[]{"*"}, String.format(Locale.ENGLISH, "%s <> %d", f38778f, Integer.valueOf(c0.a.FINISHED.a())), new String[0]);
        try {
            LinkedList linkedList = new LinkedList();
            while (d4.moveToNext()) {
                linkedList.add(a(d4));
            }
            d4.close();
            return linkedList;
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
    public final void j(c0 c0Var) {
        if (c0Var.h() == null) {
            k(c0Var);
        } else {
            this.f38710a.getWritableDatabase().insertWithOnConflict(f38774b, null, l(c0Var), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(c0 c0Var) {
        ContentValues l4 = l(c0Var);
        String uuid = UUID.randomUUID().toString();
        l4.put(f38775c, uuid);
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f38774b, null, l4);
        c0Var.f(uuid);
    }
}
