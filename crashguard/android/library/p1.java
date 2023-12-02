package crashguard.android.library;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
final class p1 {

    /* renamed from: a  reason: collision with root package name */
    private static Looper f39013a;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadPoolExecutor f39014b = new ThreadPoolExecutor(0, 10, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new a(0));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = f39014b;
            if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().size() < 100) {
                threadPoolExecutor.execute(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Thread thread, Runnable runnable) {
        if (f39013a == null) {
            f39013a = Looper.getMainLooper();
        }
        Looper looper = f39013a;
        if (looper != null) {
            try {
                if (looper.getThread() == thread) {
                    runnable.run();
                } else {
                    new Handler(f39013a).post(runnable);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f39015a;

        private a() {
            this.f39015a = 0;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Locale locale = Locale.ENGLISH;
            String str = new String(new byte[]{67, 71, 84, Framer.STDIN_FRAME_PREFIX, 37, 100});
            int i4 = this.f39015a + 1;
            this.f39015a = i4;
            return new Thread(runnable, String.format(locale, str, Integer.valueOf(i4)));
        }

        /* synthetic */ a(int i4) {
            this();
        }
    }
}
