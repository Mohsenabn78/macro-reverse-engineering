package crashguard.android.library;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.google.firebase.firestore.util.ExponentialBackoff;
import crashguard.android.library.CrashGuard;
import crashguard.android.library.v5;
import crashguard.android.library.w1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class q0 extends u0 implements w1.a {

    /* renamed from: b  reason: collision with root package name */
    private final w1 f39016b;

    /* renamed from: c  reason: collision with root package name */
    private int f39017c;

    /* renamed from: d  reason: collision with root package name */
    private CrashGuard.State f39018d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashGuard.Project f39019e;

    /* renamed from: f  reason: collision with root package name */
    private CrashGuard.Configuration f39020f;

    /* renamed from: g  reason: collision with root package name */
    private final f6 f39021g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(Context context, CrashGuard.Project project) {
        super(context);
        this.f39016b = new w1(this);
        this.f39017c = 1;
        this.f39018d = CrashGuard.State.STOPPED;
        this.f39020f = new CrashGuard.Configuration(null);
        this.f39021g = new f6();
        this.f39019e = project;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Context context) {
        h2.c(context).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final Context context) {
        CrashGuard.Project project = this.f39019e;
        if (project == null || project.c()) {
            Log.i("AOC", context.getString(R.string.cg_invalid_project));
        }
        new c2(context).a();
        g6.b(this.f39063a.get()).f("PeriodicHeartbeat", new v5(new v5.a().b(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS).f39070a));
        this.f39021g.b(context);
        p1.b(Thread.currentThread(), new Runnable() { // from class: crashguard.android.library.p0
            @Override // java.lang.Runnable
            public final void run() {
                q0.i(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        t4.f(this.f39063a.get()).close();
        Context context = this.f39063a.get();
        this.f39021g.a(context);
        h2 c4 = h2.c(context);
        c4.h(c4);
        ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f39016b);
        this.f39018d = CrashGuard.State.STOPPED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(CrashGuard.Configuration configuration) {
        this.f39020f = configuration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f39019e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(final Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        int i4 = Build.VERSION.SDK_INT;
        boolean z3 = true;
        if (i4 > 32) {
            str = Process.myProcessName();
        } else if (i4 > 27) {
            str = Application.getProcessName();
        } else {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, q0.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    String str2 = (String) invoke;
                    if (!str2.trim().isEmpty()) {
                        str = str2;
                    }
                }
            } catch (Throwable unused) {
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            str = "";
        }
        boolean equals = context.getApplicationInfo().processName.equals(str);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.f39016b);
        if (equals) {
            f5.a();
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof j0)) {
            Thread.setDefaultUncaughtExceptionHandler(new j0(this.f39063a.get(), Thread.getDefaultUncaughtExceptionHandler()));
        }
        if (equals) {
            ArrayList arrayList = new ArrayList(2);
            ArrayList arrayList2 = new ArrayList(2);
            Collections.addAll(arrayList, "handleBindApplication", "callApplicationOnCreate");
            Collections.addAll(arrayList2, "android.app.ActivityThread", "android.app.Instrumentation");
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i5];
                    if (arrayList2.contains(stackTraceElement.getClassName()) && arrayList.contains(stackTraceElement.getMethodName())) {
                        break;
                    }
                    i5++;
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                Log.i("AOC", context.getString(R.string.cg_init_on_create));
            }
            p1.a(new Runnable() { // from class: crashguard.android.library.o0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.this.k(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int h() {
        return this.f39017c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CrashGuard.State j() {
        return this.f39018d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l() {
        String a4 = this.f39020f.a();
        if (a4 != null) {
            String trim = a4.trim();
            if (!trim.isEmpty()) {
                return trim;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int m() {
        return Math.max(this.f39020f.b(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String n() {
        return this.f39019e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o() {
        return this.f39020f.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean p() {
        return this.f39020f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String q() {
        String c4 = this.f39020f.c();
        if (c4 != null) {
            String trim = c4.trim();
            if (!trim.isEmpty()) {
                return trim;
            }
            return null;
        }
        return null;
    }

    public final void r() {
        this.f39017c = 1;
    }

    public final void s() {
        this.f39017c = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t() {
        if (this.f39018d == CrashGuard.State.STOPPED) {
            this.f39018d = CrashGuard.State.STARTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u() {
        Context context = this.f39063a.get();
        this.f39021g.a(context);
        h2 c4 = h2.c(context);
        c4.h(c4);
        ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f39016b);
        this.f39018d = CrashGuard.State.STOPPED;
    }
}
