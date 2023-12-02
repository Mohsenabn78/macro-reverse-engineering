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
public final class m2 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f38947b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38948c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38949d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f38950e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f38951f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f38952g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f38953h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f38954i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f38955j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f38956k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f38957l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f38958m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f38959n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f38960o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f38961p;

    /* renamed from: q  reason: collision with root package name */
    private static final String f38962q;

    /* renamed from: r  reason: collision with root package name */
    private static final String f38963r;

    static {
        String str = "ScanHistory";
        f38947b = str;
        String str2 = "id";
        f38948c = str2;
        String str3 = new String(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 105, 114, 97, 116, 105, 111, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 105, 109, 101, 115, 116, 97, 109, 112});
        f38949d = str3;
        String str4 = "capabilities";
        f38950e = str4;
        String str5 = "level";
        f38951f = str5;
        String str6 = "frequency";
        f38952g = str6;
        String str7 = "course";
        f38953h = str7;
        String str8 = "speed";
        f38954i = str8;
        String str9 = "latitude";
        f38955j = str9;
        String str10 = "longitude";
        f38956k = str10;
        String str11 = new String(new byte[]{104, 111, 114, 105, 122, 111, 110, 116, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38957l = str11;
        String str12 = new String(new byte[]{118, 101, 114, 116, 105, 99, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f38958m = str12;
        String str13 = "timestamp";
        f38959n = str13;
        String str14 = "provider";
        f38960o = str14;
        String str15 = "ssid";
        f38961p = str15;
        String str16 = "bssid";
        f38962q = str16;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(" TEXT PRIMARY KEY,");
        StringBuilder a4 = g.a(g.a(g.a(g.a(g.a(g.a(sb, str3, " LONG,", str15, " TEXT,"), str16, " TEXT,", str4, " TEXT,"), str5, " TEXT,", str6, " TEXT,"), str7, " TEXT,", str8, " TEXT,"), str9, " TEXT,", str10, " TEXT,"), str11, " TEXT,", str12, " TEXT,");
        a4.append(str13);
        a4.append(" TEXT,");
        a4.append(str14);
        a4.append(" TEXT)");
        f38963r = a4.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static l5 a(Cursor cursor) {
        return new l5(cursor.getString(cursor.getColumnIndex(f38948c)), cursor.getLong(cursor.getColumnIndex(f38949d)), cursor.getString(cursor.getColumnIndex(f38959n)), cursor.getString(cursor.getColumnIndex(f38961p)), cursor.getString(cursor.getColumnIndex(f38962q)), cursor.getString(cursor.getColumnIndex(f38950e)), cursor.getString(cursor.getColumnIndex(f38951f)), cursor.getString(cursor.getColumnIndex(f38952g)), cursor.getString(cursor.getColumnIndex(f38953h)), cursor.getString(cursor.getColumnIndex(f38954i)), cursor.getString(cursor.getColumnIndex(f38955j)), cursor.getString(cursor.getColumnIndex(f38956k)), cursor.getString(cursor.getColumnIndex(f38957l)), cursor.getString(cursor.getColumnIndex(f38958m)), cursor.getString(cursor.getColumnIndex(f38960o)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f38710a.c(f38947b, String.format(Locale.ENGLISH, "%s <= %d", f38949d, Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f38963r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(l5 l5Var) {
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(f38948c, uuid);
        contentValues.put(f38949d, Long.valueOf(l5Var.e()));
        contentValues.put(f38961p, l5Var.n());
        contentValues.put(f38962q, l5Var.a());
        contentValues.put(f38950e, l5Var.c());
        contentValues.put(f38951f, l5Var.j());
        contentValues.put(f38952g, l5Var.f());
        contentValues.put(f38953h, l5Var.d());
        contentValues.put(f38954i, l5Var.m());
        contentValues.put(f38955j, l5Var.i());
        contentValues.put(f38956k, l5Var.k());
        contentValues.put(f38957l, l5Var.g());
        contentValues.put(f38958m, l5Var.p());
        contentValues.put(f38959n, l5Var.o());
        contentValues.put(f38960o, l5Var.l());
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f38947b, null, contentValues);
        l5Var.b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e() {
        return this.f38710a.b(f38947b, f38948c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList f() {
        LinkedList linkedList = new LinkedList();
        Cursor d4 = this.f38710a.d(f38947b, new String[]{"*"}, null, new String[0]);
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
