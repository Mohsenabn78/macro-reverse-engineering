package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.net.HttpHeaders;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class e5 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38711b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38712c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38713d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38714e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f38715f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f38716g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f38717h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f38718i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f38719j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f38720k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f38721l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f38722m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f38723n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f38724o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f38725p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f38726q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f38727r;

    /* renamed from: s  reason: collision with root package name */
    private static final String f38728s;

    /* renamed from: t  reason: collision with root package name */
    private static final String f38729t;

    /* renamed from: u  reason: collision with root package name */
    private static final String f38730u;

    /* renamed from: v  reason: collision with root package name */
    private static final String f38731v;

    static {
        String str = "CDL";
        f38711b = str;
        String str2 = "id";
        f38712c = str2;
        String str3 = new String(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 105, 114, 97, 116, 105, 111, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 105, 109, 101, 115, 116, 97, 109, 112});
        f38713d = str3;
        String str4 = "cid";
        f38714e = str4;
        String str5 = "lac";
        f38715f = str5;
        String str6 = "mcc";
        f38716g = str6;
        String str7 = "mnc";
        f38717h = str7;
        String str8 = "v4";
        f38718i = str8;
        String str9 = "v6";
        f38719j = str9;
        String str10 = "cv4";
        f38720k = str10;
        String str11 = "cv6";
        f38721l = str11;
        String str12 = new String(new byte[]{99, 97, 114, 114, 105, 101, 114, Framer.STDIN_REQUEST_FRAME_PREFIX, 118, 97, 108, 117, 101, 115});
        f38722m = str12;
        String str13 = "latitude";
        f38723n = str13;
        String str14 = "longitude";
        f38724o = str14;
        String str15 = "course";
        f38725p = str15;
        String str16 = "speed";
        f38726q = str16;
        String str17 = new String(new byte[]{104, 111, 114, 105, 122, 111, 110, 116, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38727r = str17;
        String str18 = new String(new byte[]{118, 101, 114, 116, 105, 99, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38728s = str18;
        String str19 = "timestamp";
        f38729t = str19;
        String str20 = "provider";
        f38730u = str20;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(" TEXT PRIMARY KEY,");
        StringBuilder a4 = g.a(g.a(g.a(g.a(g.a(g.a(g.a(g.a(sb, str3, " LONG,", str4, " TEXT,"), str5, " TEXT,", str6, " TEXT,"), str7, " TEXT,", str8, " TEXT,"), str9, " TEXT,", str10, " TEXT,"), str11, " TEXT,", str12, " TEXT,"), str13, " TEXT,", str14, " TEXT,"), str15, " TEXT,", str16, " TEXT,"), str17, " TEXT,", str18, " TEXT,");
        a4.append(str19);
        a4.append(" TEXT,");
        a4.append(str20);
        a4.append(" TEXT)");
        f38731v = a4.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static m5 a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex(f38712c));
        long j4 = cursor.getLong(cursor.getColumnIndex(f38713d));
        String string2 = cursor.getString(cursor.getColumnIndex(f38716g));
        String string3 = cursor.getString(cursor.getColumnIndex(f38717h));
        String string4 = cursor.getString(cursor.getColumnIndex(f38714e));
        String string5 = cursor.getString(cursor.getColumnIndex(f38715f));
        String string6 = cursor.getString(cursor.getColumnIndex(f38718i));
        String str = f38720k;
        return new m5(string, j4, string2, string3, string4, string5, string6, cursor.getString(cursor.getColumnIndex(str)), cursor.getString(cursor.getColumnIndex(f38719j)), cursor.getString(cursor.getColumnIndex(str)), cursor.getString(cursor.getColumnIndex(f38722m)), cursor.getString(cursor.getColumnIndex(f38729t)), cursor.getString(cursor.getColumnIndex(f38725p)), cursor.getString(cursor.getColumnIndex(f38726q)), cursor.getString(cursor.getColumnIndex(f38727r)), cursor.getString(cursor.getColumnIndex(f38728s)), cursor.getString(cursor.getColumnIndex(f38723n)), cursor.getString(cursor.getColumnIndex(f38724o)), cursor.getString(cursor.getColumnIndex(f38730u)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f38710a.c(f38711b, String.format(Locale.ENGLISH, "%s <= %d", f38713d, Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38731v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(m5 m5Var) {
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(f38712c, uuid);
        contentValues.put(f38713d, Long.valueOf(m5Var.g()));
        contentValues.put(f38714e, m5Var.c());
        contentValues.put(f38715f, m5Var.l());
        contentValues.put(f38716g, m5Var.o());
        contentValues.put(f38717h, m5Var.p());
        contentValues.put(f38718i, m5Var.j());
        contentValues.put(f38720k, m5Var.j());
        contentValues.put(f38719j, m5Var.k());
        contentValues.put(f38721l, m5Var.k());
        contentValues.put(f38722m, m5Var.a());
        contentValues.put(f38723n, m5Var.m());
        contentValues.put(f38724o, m5Var.n());
        contentValues.put(f38725p, m5Var.f());
        contentValues.put(f38726q, m5Var.r());
        contentValues.put(f38727r, m5Var.h());
        contentValues.put(f38728s, m5Var.t());
        contentValues.put(f38729t, m5Var.s());
        contentValues.put(f38730u, m5Var.q());
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f38711b, null, contentValues);
        m5Var.b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e() {
        return this.f38710a.b(f38711b, f38712c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList f() {
        LinkedList linkedList = new LinkedList();
        Cursor d4 = this.f38710a.d(f38711b, new String[]{"*"}, null, new String[0]);
        if (d4 != null) {
            while (d4.moveToNext()) {
                try {
                    linkedList.add(a(d4));
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
}
