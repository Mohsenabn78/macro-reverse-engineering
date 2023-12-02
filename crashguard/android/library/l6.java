package crashguard.android.library;

import android.content.Context;
import crashguard.android.library.c0;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* loaded from: classes6.dex */
final class l6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l6(Context context) {
        this.f38938a = new WeakReference<>(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f38938a.get();
        h0 o4 = t4.f(context).o();
        LinkedList<c0> i4 = o4.i();
        if (i4.size() > 0) {
            g6 b4 = g6.b(context);
            for (c0 c0Var : i4) {
                o4.f38710a.getWritableDatabase().beginTransaction();
                try {
                    c0Var.d(c0.a.ENQUEUED);
                    b4.d(c0Var);
                    o4.f38710a.getWritableDatabase().setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                o4.f38710a.getWritableDatabase().endTransaction();
            }
        }
    }
}
