package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class x0 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f39109b = new String(new byte[]{106, 111, 98, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 100});

    /* renamed from: c  reason: collision with root package name */
    private static final String f39110c = new String(new byte[]{97, 108, 97, 114, 109, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 100});

    /* renamed from: a  reason: collision with root package name */
    private final l f39111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(Context context) {
        this.f39111a = t4.f(context).n();
    }

    private int b(String str, int i4, int i5) {
        t4 t4Var = this.f39111a.f38710a;
        t4Var.getWritableDatabase().beginTransaction();
        try {
            m6 a4 = this.f39111a.a(str);
            if (a4 == null) {
                a4 = new m6(str, Long.valueOf(i4));
            }
            int max = Math.max(a4.c().intValue(), i4);
            int i6 = max + 1;
            if (i6 > i5) {
                i6 = i4;
            }
            a4.b(Long.valueOf(i6));
            this.f39111a.d(a4);
            t4Var.getWritableDatabase().setTransactionSuccessful();
            t4Var.getWritableDatabase().endTransaction();
            return max;
        } catch (Throwable unused) {
            t4Var.getWritableDatabase().endTransaction();
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return b(f39109b, 200000, 299999);
    }
}
