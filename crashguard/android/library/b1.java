package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.net.HttpHeaders;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b1 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38624b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38625c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38626d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38627e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f38628f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f38629g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f38630h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f38631i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f38632j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f38633k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f38634l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f38635m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f38636n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f38637o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f38638p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f38639q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f38640r;

    /* renamed from: s  reason: collision with root package name */
    private static final String f38641s;

    /* renamed from: t  reason: collision with root package name */
    private static final String f38642t;

    /* renamed from: u  reason: collision with root package name */
    private static final String f38643u;

    /* renamed from: v  reason: collision with root package name */
    private static final String f38644v;

    static {
        String str = "APL";
        f38624b = str;
        String str2 = "id";
        f38625c = str2;
        String str3 = new String(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 105, 114, 97, 116, 105, 111, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 105, 109, 101, 115, 116, 97, 109, 112});
        f38626d = str3;
        String str4 = "ssid";
        f38627e = str4;
        String str5 = new String(new byte[]{115, 115, 105, 100, Framer.STDIN_REQUEST_FRAME_PREFIX, 104, 97, 115, 104});
        f38628f = str5;
        String str6 = "bssid";
        f38629g = str6;
        String str7 = new String(new byte[]{98, 115, 115, 105, 100, Framer.STDIN_REQUEST_FRAME_PREFIX, 104, 97, 115, 104});
        f38630h = str7;
        String str8 = "rssi";
        f38631i = str8;
        String str9 = "v4";
        f38632j = str9;
        String str10 = "v6";
        f38633k = str10;
        String str11 = "cv4";
        f38634l = str11;
        String str12 = "cv6";
        f38635m = str12;
        String str13 = "latitude";
        f38636n = str13;
        String str14 = "longitude";
        f38637o = str14;
        String str15 = "course";
        f38638p = str15;
        String str16 = "speed";
        f38639q = str16;
        String str17 = new String(new byte[]{104, 111, 114, 105, 122, 111, 110, 116, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38640r = str17;
        String str18 = new String(new byte[]{118, 101, 114, 116, 105, 99, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38641s = str18;
        String str19 = "timestamp";
        f38642t = str19;
        String str20 = "provider";
        f38643u = str20;
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
        f38644v = a4.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static l1 a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex(f38625c));
        long j4 = cursor.getLong(cursor.getColumnIndex(f38626d));
        String string2 = cursor.getString(cursor.getColumnIndex(f38627e));
        String string3 = cursor.getString(cursor.getColumnIndex(f38628f));
        String string4 = cursor.getString(cursor.getColumnIndex(f38629g));
        String string5 = cursor.getString(cursor.getColumnIndex(f38630h));
        String string6 = cursor.getString(cursor.getColumnIndex(f38631i));
        String string7 = cursor.getString(cursor.getColumnIndex(f38632j));
        String str = f38634l;
        return new l1(string, j4, string2, string3, string4, string5, string6, string7, cursor.getString(cursor.getColumnIndex(str)), cursor.getString(cursor.getColumnIndex(f38633k)), cursor.getString(cursor.getColumnIndex(str)), cursor.getString(cursor.getColumnIndex(f38642t)), cursor.getString(cursor.getColumnIndex(f38638p)), cursor.getString(cursor.getColumnIndex(f38639q)), cursor.getString(cursor.getColumnIndex(f38640r)), cursor.getString(cursor.getColumnIndex(f38641s)), cursor.getString(cursor.getColumnIndex(f38636n)), cursor.getString(cursor.getColumnIndex(f38637o)), cursor.getString(cursor.getColumnIndex(f38643u)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        t4 t4Var = this.f38710a;
        String str = f38624b;
        String str2 = f38644v;
        t4Var.getWritableDatabase().execSQL(String.format("DROP TABLE %s", str));
        t4Var.getWritableDatabase().execSQL(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38644v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(l1 l1Var) {
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(f38625c, uuid);
        contentValues.put(f38626d, Long.valueOf(l1Var.f()));
        contentValues.put(f38627e, l1Var.r());
        contentValues.put(f38628f, l1Var.h());
        contentValues.put(f38629g, l1Var.a());
        contentValues.put(f38630h, l1Var.g());
        contentValues.put(f38631i, l1Var.p());
        contentValues.put(f38632j, l1Var.k());
        contentValues.put(f38634l, l1Var.k());
        contentValues.put(f38633k, l1Var.l());
        contentValues.put(f38635m, l1Var.l());
        contentValues.put(f38636n, l1Var.m());
        contentValues.put(f38637o, l1Var.n());
        contentValues.put(f38638p, l1Var.e());
        contentValues.put(f38639q, l1Var.q());
        contentValues.put(f38640r, l1Var.i());
        contentValues.put(f38641s, l1Var.t());
        contentValues.put(f38642t, l1Var.s());
        contentValues.put(f38643u, l1Var.o());
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f38624b, null, contentValues);
        l1Var.b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(String str, String str2) {
        return this.f38710a.h(f38624b, String.format("%s = '%s' AND %s = '%s'", f38628f, str, f38630h, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long f() {
        return this.f38710a.b(f38624b, f38625c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList g() {
        LinkedList linkedList = new LinkedList();
        Cursor d4 = this.f38710a.d(f38624b, new String[]{"*"}, null, new String[0]);
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
