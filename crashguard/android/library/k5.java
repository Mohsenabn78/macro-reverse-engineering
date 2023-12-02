package crashguard.android.library;

import android.content.Context;
import android.util.Log;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
final class k5 extends d1 {

    /* renamed from: b  reason: collision with root package name */
    private final String f38892b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(Context context) {
        this(context, "CrashTest");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // crashguard.android.library.d1
    public final h1 b(Thread thread, Throwable th) {
        return new h1(th, thread.getName(), true, System.currentTimeMillis());
    }

    protected final boolean e() {
        try {
            return Class.forName(String.format("%s.%s", this.f38690a.get().getApplicationInfo().packageName, "BuildConfig")).getDeclaredField("DEBUG").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(Thread thread, Throwable th) {
        if (e()) {
            try {
                Context context = this.f38690a.get();
                k2 k2Var = new k2();
                SecretKey b4 = o1.b(context, k2Var);
                h1 b5 = b(thread, th);
                new x1(context, k2Var, b4).c(b5);
                d(b5.h());
            } catch (Throwable unused) {
            }
        }
        if (Log.isLoggable(this.f38892b, 6)) {
            Log.e(this.f38892b, "The application encountered an error.", th);
        }
    }

    private k5(Context context, String str) {
        super(context);
        this.f38892b = str.trim().isEmpty() ? "CrashGuard" : str;
    }
}
