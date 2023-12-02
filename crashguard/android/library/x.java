package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.common.net.HttpHeaders;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class x extends e2 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f39099b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f39100c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f39101d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f39102e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f39103f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f39104g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f39105h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f39106i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f39107j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f39108k;

    static {
        String str = "Crash";
        f39099b = str;
        String str2 = "id";
        f39100c = str2;
        String str3 = "hash";
        f39101d = str3;
        String str4 = "lm";
        f39102e = str4;
        String str5 = "st";
        f39103f = str5;
        String str6 = "cn";
        f39104g = str6;
        String str7 = "tn";
        f39105h = str7;
        String str8 = "cl";
        f39106i = str8;
        String str9 = "mip";
        f39107j = str9;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(" TEXT PRIMARY KEY,");
        StringBuilder a4 = g.a(g.a(g.a(sb, str3, " TEXT,m TEXT,", str4, " TEXT,"), str5, " TEXT,", str6, " TEXT,"), str7, " TEXT,c TEXT,s TEXT,", str8, " TEXT,");
        a4.append(str9);
        a4.append(" TEXT,t LONG)");
        f39108k = a4.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t4 t4Var) {
        super(t4Var);
    }

    @SuppressLint({HttpHeaders.RANGE})
    private static n1 a(Cursor cursor) {
        LinkedList linkedList;
        LinkedList linkedList2;
        String string = cursor.getString(cursor.getColumnIndex(f39100c));
        String string2 = cursor.getString(cursor.getColumnIndex(f39101d));
        String string3 = cursor.getString(cursor.getColumnIndex("m"));
        String string4 = cursor.getString(cursor.getColumnIndex(f39102e));
        String string5 = cursor.getString(cursor.getColumnIndex(f39103f));
        String string6 = cursor.getString(cursor.getColumnIndex(f39104g));
        String string7 = cursor.getString(cursor.getColumnIndex(f39105h));
        String string8 = cursor.getString(cursor.getColumnIndex(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT));
        if (string8 == null) {
            linkedList = new LinkedList();
        } else {
            linkedList = new LinkedList(Arrays.asList(string8.split(":\\\\|:")));
        }
        String string9 = cursor.getString(cursor.getColumnIndex("s"));
        if (string9 == null) {
            linkedList2 = new LinkedList();
        } else {
            linkedList2 = new LinkedList(Arrays.asList(string9.split(":\\\\|:")));
        }
        return new n1(string, string2, string3, string4, string5, string6, string7, linkedList, linkedList2, cursor.getString(cursor.getColumnIndex(f39106i)), cursor.getString(cursor.getColumnIndex(f39107j)), cursor.getLong(cursor.getColumnIndex("t")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final LinkedList b() {
        LinkedList linkedList = new LinkedList();
        Cursor query = this.f38710a.getReadableDatabase().query(false, f39099b, new String[]{"*"}, null, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                linkedList.add(a(query));
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
        query.close();
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f39108k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(SQLiteDatabase sQLiteDatabase, int i4) {
        if (i4 < 3) {
            sQLiteDatabase.execSQL(f39108k);
        }
        if (i4 < 6) {
            try {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN `%s` TEXT", f39099b, f39101d));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(n1 n1Var) {
        String str;
        String str2;
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(f39100c, uuid);
        contentValues.put(f39101d, n1Var.e());
        contentValues.put("m", n1Var.h());
        contentValues.put(f39102e, n1Var.g());
        contentValues.put(f39103f, n1Var.j());
        contentValues.put(f39104g, n1Var.c());
        contentValues.put(f39105h, n1Var.l());
        List<String> a4 = n1Var.a();
        if (a4 != null && !a4.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String str3 : a4) {
                sb.append(str3);
                sb.append(":|:");
            }
            str = sb.substring(0, (sb.length() - 3) - 1);
        } else {
            str = null;
        }
        contentValues.put(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, str);
        List<String> k4 = n1Var.k();
        if (k4 != null && !k4.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (String str4 : k4) {
                sb2.append(str4);
                sb2.append(":|:");
            }
            str2 = sb2.substring(0, (sb2.length() - 3) - 1);
        } else {
            str2 = null;
        }
        contentValues.put("s", str2);
        contentValues.put(f39106i, n1Var.d());
        contentValues.put(f39107j, n1Var.i());
        contentValues.put("t", Long.valueOf(n1Var.m()));
        this.f38710a.getWritableDatabase().insert(f39099b, null, contentValues);
        n1Var.b(uuid);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(String str) {
        if (this.f38710a.c(f39099b, String.format("%s = '%s'", f39100c, str), new String[0]) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({HttpHeaders.RANGE})
    public final n1 g(String str) {
        t4 t4Var = this.f38710a;
        Cursor query = t4Var.getReadableDatabase().query(false, f39099b, new String[]{"*"}, String.format("%s = '%s'", f39100c, str), null, null, null, null, null);
        try {
            if (query.moveToFirst()) {
                n1 a4 = a(query);
                query.close();
                return a4;
            }
            query.close();
            return null;
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
}
