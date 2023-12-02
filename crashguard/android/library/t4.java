package crashguard.android.library;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class t4 extends SQLiteOpenHelper {

    /* renamed from: j  reason: collision with root package name */
    private static final String f39051j = "crashguard.android.library.crashguard.db";

    /* renamed from: k  reason: collision with root package name */
    private static t4 f39052k = null;

    /* renamed from: l  reason: collision with root package name */
    private static final Object f39053l = new Object();

    /* renamed from: a  reason: collision with root package name */
    private a6 f39054a;

    /* renamed from: b  reason: collision with root package name */
    private x f39055b;

    /* renamed from: c  reason: collision with root package name */
    private m f39056c;

    /* renamed from: d  reason: collision with root package name */
    private b1 f39057d;

    /* renamed from: e  reason: collision with root package name */
    private t1 f39058e;

    /* renamed from: f  reason: collision with root package name */
    private e5 f39059f;

    /* renamed from: g  reason: collision with root package name */
    private m2 f39060g;

    /* renamed from: h  reason: collision with root package name */
    private h0 f39061h;

    /* renamed from: i  reason: collision with root package name */
    private l f39062i;

    private t4(Context context, String str) {
        super(context, str, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t4 f(Context context) {
        t4 t4Var;
        t4 t4Var2 = f39052k;
        if (t4Var2 == null) {
            synchronized (f39053l) {
                t4Var = new t4(context.getApplicationContext(), context.getDatabasePath(new File(context.getNoBackupFilesDir(), f39051j).getPath()).getPath());
                f39052k = t4Var;
            }
            return t4Var;
        }
        return t4Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery(String.format("SELECT COUNT(%s) FROM %s", str2, str), null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    long j4 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j4;
                }
            } catch (Throwable th) {
                try {
                    rawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
            return 0L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long c(String str, String str2, String... strArr) {
        return getWritableDatabase().delete(str, str2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Cursor d(String str, String[] strArr, String str2, String... strArr2) {
        return getReadableDatabase().query(false, str, strArr, str2, strArr2, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m e() {
        m mVar;
        m mVar2 = this.f39056c;
        if (mVar2 == null) {
            synchronized (f39053l) {
                mVar = new m(this);
                this.f39056c = mVar;
            }
            return mVar;
        }
        return mVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b1 g() {
        b1 b1Var;
        b1 b1Var2 = this.f39057d;
        if (b1Var2 == null) {
            synchronized (f39053l) {
                b1Var = new b1(this);
                this.f39057d = b1Var;
            }
            return b1Var;
        }
        return b1Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(String str, String str2) {
        Cursor query = getReadableDatabase().query(str, new String[]{"1"}, str2, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    query.close();
                    return true;
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
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e5 i() {
        e5 e5Var;
        e5 e5Var2 = this.f39059f;
        if (e5Var2 == null) {
            synchronized (f39053l) {
                e5Var = new e5(this);
                this.f39059f = e5Var;
            }
            return e5Var;
        }
        return e5Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x j() {
        x xVar;
        x xVar2 = this.f39055b;
        if (xVar2 == null) {
            synchronized (f39053l) {
                xVar = new x(this);
                this.f39055b = xVar;
            }
            return xVar;
        }
        return xVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t1 k() {
        t1 t1Var;
        t1 t1Var2 = this.f39058e;
        if (t1Var2 == null) {
            synchronized (f39053l) {
                t1Var = new t1(this);
                this.f39058e = t1Var;
            }
            return t1Var;
        }
        return t1Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m2 l() {
        m2 m2Var;
        m2 m2Var2 = this.f39060g;
        if (m2Var2 == null) {
            synchronized (f39053l) {
                m2Var = new m2(this);
                this.f39060g = m2Var;
            }
            return m2Var;
        }
        return m2Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a6 m() {
        a6 a6Var;
        a6 a6Var2 = this.f39054a;
        if (a6Var2 == null) {
            synchronized (f39053l) {
                a6Var = new a6(this);
                this.f39054a = a6Var;
            }
            return a6Var;
        }
        return a6Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l n() {
        l lVar;
        l lVar2 = this.f39062i;
        if (lVar2 == null) {
            synchronized (f39053l) {
                lVar = new l(this);
                this.f39062i = lVar;
            }
            return lVar;
        }
        return lVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h0 o() {
        h0 h0Var;
        h0 h0Var2 = this.f39061h;
        if (h0Var2 == null) {
            synchronized (f39053l) {
                h0Var = new h0(this);
                this.f39061h = h0Var;
            }
            return h0Var;
        }
        return h0Var2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        k().d(sQLiteDatabase);
        i().c(sQLiteDatabase);
        g().c(sQLiteDatabase);
        l().c(sQLiteDatabase);
        e().b(sQLiteDatabase);
        m().b(sQLiteDatabase);
        j().c(sQLiteDatabase);
        o().d(sQLiteDatabase);
        n().b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        k().getClass();
        i().getClass();
        g().getClass();
        l().getClass();
        e().getClass();
        m().getClass();
        if (i5 < 5) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkerState` (`unique_name` TEXT PRIMARY KEY, `timestamp` LONG )");
            sQLiteDatabase.execSQL("INSERT INTO `WorkerState` ".concat(new String(new byte[]{83, 69, 76, 69, 67, 84, 32, 96, 117, 110, 105, 113, 117, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 110, 97, 109, 101, 96, 44, 32, 96, 116, 105, 109, 101, 115, 116, 97, 109, 112, 96, 32, 70, 82, 79, 77, 32, 96, 87, 111, 114, 107, 76, 111, 99, 107, 96})));
            sQLiteDatabase.execSQL("DROP TABLE `WorkLock`");
        }
        if (i5 < 2) {
            sQLiteDatabase.execSQL("DROP TABLE `WorkerState`");
        }
        j().getClass();
        o().getClass();
        if (i5 < 4) {
            sQLiteDatabase.execSQL("DROP TABLE WorkName");
            sQLiteDatabase.execSQL("DROP TABLE WorkSpec");
        }
        n().getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        k().getClass();
        i().getClass();
        g().getClass();
        l().getClass();
        e().getClass();
        m().c(sQLiteDatabase, i4);
        j().d(sQLiteDatabase, i4);
        o().e(sQLiteDatabase, i4);
        n().c(sQLiteDatabase, i4);
    }
}
