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
public final class t1 extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f39038b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f39039c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f39040d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f39041e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f39042f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f39043g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f39044h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f39045i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f39046j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f39047k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f39048l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f39049m;

    /* renamed from: n  reason: collision with root package name */
    private static final String f39050n;

    static {
        String str = "LocationHistory";
        f39038b = str;
        String str2 = "id";
        f39039c = str2;
        String str3 = new String(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 105, 114, 97, 116, 105, 111, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 105, 109, 101, 115, 116, 97, 109, 112});
        f39040d = str3;
        String str4 = new String(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 105, 114, 97, 116, 105, 111, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 105, 109, 101, 115, 116, 97, 109, 112, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 119, 111});
        f39041e = str4;
        String str5 = "latitude";
        f39042f = str5;
        String str6 = "longitude";
        f39043g = str6;
        String str7 = "course";
        f39044h = str7;
        String str8 = "speed";
        f39045i = str8;
        String str9 = new String(new byte[]{104, 111, 114, 105, 122, 111, 110, 116, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f39046j = str9;
        String str10 = new String(new byte[]{118, 101, 114, 116, 105, 99, 97, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 99, 99, 117, 114, 97, 99, 121});
        f39047k = str10;
        String str11 = "timestamp";
        f39048l = str11;
        String str12 = "provider";
        f39049m = str12;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(" TEXT PRIMARY KEY,");
        StringBuilder a4 = g.a(g.a(g.a(g.a(sb, str3, " LONG,", str4, " LONG,"), str5, " TEXT,", str6, " TEXT,"), str7, " TEXT,", str8, " TEXT,"), str9, " TEXT,", str10, " TEXT,");
        a4.append(str11);
        a4.append(" TEXT,");
        a4.append(str12);
        a4.append(" TEXT)");
        f39050n = a4.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static b2 b(Cursor cursor) {
        return new b2(cursor.getString(cursor.getColumnIndex(f39039c)), cursor.getString(cursor.getColumnIndex(f39048l)), cursor.getLong(cursor.getColumnIndex(f39040d)), cursor.getLong(cursor.getColumnIndex(f39041e)), cursor.getString(cursor.getColumnIndex(f39042f)), cursor.getString(cursor.getColumnIndex(f39043g)), cursor.getString(cursor.getColumnIndex(f39044h)), cursor.getString(cursor.getColumnIndex(f39045i)), cursor.getString(cursor.getColumnIndex(f39046j)), cursor.getString(cursor.getColumnIndex(f39047k)), cursor.getString(cursor.getColumnIndex(f39049m)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b2 a(long j4) {
        Locale locale = Locale.ENGLISH;
        String str = f39041e;
        String format = String.format(locale, "(%d - %s) < %d", Long.valueOf(System.currentTimeMillis()), str, Long.valueOf(j4));
        t4 t4Var = this.f38710a;
        Cursor query = t4Var.getReadableDatabase().query(false, f39038b, new String[]{"*"}, format, null, null, null, str + " DESC", null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    b2 b4 = b(query);
                    query.close();
                    return b4;
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
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        t4 t4Var = this.f38710a;
        String str = f39038b;
        String str2 = f39050n;
        t4Var.getWritableDatabase().execSQL(String.format("DROP TABLE %s", str));
        t4Var.getWritableDatabase().execSQL(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f39050n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(b2 b2Var) {
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(f39039c, uuid);
        contentValues.put(f39040d, Long.valueOf(b2Var.c()));
        contentValues.put(f39041e, Long.valueOf(b2Var.d()));
        contentValues.put(f39042f, b2Var.g());
        contentValues.put(f39043g, b2Var.h());
        contentValues.put(f39044h, b2Var.a());
        contentValues.put(f39045i, b2Var.j());
        contentValues.put(f39046j, b2Var.e());
        contentValues.put(f39047k, b2Var.l());
        contentValues.put(f39048l, b2Var.k());
        contentValues.put(f39049m, b2Var.i());
        t4 t4Var = this.f38710a;
        t4Var.getWritableDatabase().insert(f39038b, null, contentValues);
        b2Var.b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long f() {
        return this.f38710a.b(f39038b, f39039c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList g() {
        LinkedList linkedList = new LinkedList();
        Cursor d4 = this.f38710a.d(f39038b, new String[]{"*"}, null, new String[0]);
        if (d4 != null) {
            while (d4.moveToNext()) {
                try {
                    linkedList.add(b(d4));
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
