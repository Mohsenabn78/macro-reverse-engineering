package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
final class g6 {

    /* renamed from: d  reason: collision with root package name */
    static g6 f38769d;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38770a;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadPoolExecutor f38772c = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new a(0));

    /* renamed from: b  reason: collision with root package name */
    private final k f38771b = a();

    private g6(Context context) {
        this.f38770a = new WeakReference<>(context);
    }

    private k a() {
        return k.b(this.f38770a.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g6 b(Context context) {
        if (f38769d == null) {
            f38769d = new g6(context);
        }
        return f38769d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(v vVar) {
        this.f38771b.i(vVar.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(c0 c0Var) {
        this.f38771b.i(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(Runnable runnable) {
        try {
            if (!this.f38772c.isShutdown() && !this.f38772c.isTerminated() && !this.f38772c.isTerminating() && this.f38772c.getQueue().size() < 10) {
                this.f38772c.execute(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(String str, v5 v5Var) {
        this.f38771b.h(str, v5Var.a());
    }

    /* loaded from: classes6.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f38773a;

        private a() {
            this.f38773a = 0;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Locale locale = Locale.ENGLISH;
            String str = new String(new byte[]{87, 77, 84, Framer.STDIN_FRAME_PREFIX, 37, 100});
            int i4 = this.f38773a + 1;
            this.f38773a = i4;
            return new Thread(runnable, String.format(locale, str, Integer.valueOf(i4)));
        }

        /* synthetic */ a(int i4) {
            this();
        }
    }
}
