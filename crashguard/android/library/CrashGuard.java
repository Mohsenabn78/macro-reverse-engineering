package crashguard.android.library;

import android.content.Context;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class CrashGuard {
    public static final String VERSION = "1.1.4";

    /* renamed from: b  reason: collision with root package name */
    private static CrashGuard f38592b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38593c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final q0 f38594a;

    /* loaded from: classes6.dex */
    public static class Configuration {

        /* renamed from: a  reason: collision with root package name */
        private final String f38595a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38596b;

        /* renamed from: c  reason: collision with root package name */
        private final int f38597c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f38598d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f38599e;

        public Configuration(String str) {
            this(null, str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String a() {
            return this.f38596b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int b() {
            return this.f38597c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String c() {
            return this.f38595a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean d() {
            return this.f38598d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean e() {
            return this.f38599e;
        }

        public Configuration(String str, String str2) {
            this(0, str, str2);
        }

        public Configuration(int i4, String str, String str2) {
            this(i4, str, str2, true);
        }

        public Configuration(int i4, String str, String str2, boolean z3) {
            this(i4, str, str2, z3, false);
        }

        public Configuration(int i4, String str, String str2, boolean z3, boolean z4) {
            this.f38597c = i4;
            this.f38595a = str;
            this.f38596b = str2;
            this.f38598d = z3;
            this.f38599e = z4;
        }
    }

    /* loaded from: classes6.dex */
    public static class Project {

        /* renamed from: a  reason: collision with root package name */
        private final String f38600a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38601b;

        public Project(String str, String str2) {
            this.f38600a = str;
            this.f38601b = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String a() {
            return this.f38600a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String b() {
            return this.f38601b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean c() {
            String str = this.f38600a;
            if (str != null && this.f38601b != null && !str.trim().isEmpty() && !this.f38601b.trim().isEmpty()) {
                Pattern compile = Pattern.compile("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
                if (compile.matcher(this.f38600a).matches() && compile.matcher(this.f38601b).matches()) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public enum State {
        STARTED,
        STOPPED
    }

    private CrashGuard(Context context, Project project) {
        this.f38594a = new q0(context, project);
    }

    public static CrashGuard getInstance(Context context) throws RuntimeException {
        CrashGuard crashGuard = f38592b;
        if (crashGuard != null) {
            return crashGuard;
        }
        throw new RuntimeException(context.getString(R.string.cg_instance_null));
    }

    public static CrashGuard initialize(Context context, Project project) {
        CrashGuard crashGuard;
        if (f38592b == null) {
            synchronized (f38593c) {
                crashGuard = new CrashGuard(context, project);
                crashGuard.f38594a.g(context);
                f38592b = crashGuard;
            }
            return crashGuard;
        }
        return getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f38594a.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.f38594a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.f38594a.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.f38594a.p();
    }

    public void destroy() {
        this.f38594a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e() {
        return this.f38594a.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f38594a.h() == 2) {
            return true;
        }
        return false;
    }

    public String getAccessCode() {
        return this.f38594a.f();
    }

    public String getSecretCode() {
        return this.f38594a.n();
    }

    public State getState() {
        return this.f38594a.j();
    }

    public void sendTestCrash() {
        new k5(this.f38594a.f39063a.get()).f(Thread.currentThread(), new RuntimeException("This is a crash test. Access the dashboard to see crash details."));
    }

    public CrashGuard setConfiguration(Configuration configuration) {
        this.f38594a.e(configuration);
        return this;
    }

    public CrashGuard setSupplementalInformation(String str) {
        q0 q0Var = this.f38594a;
        q0Var.getClass();
        new y0(q0Var.f39063a.get()).I(str);
        return this;
    }

    public void start() {
        this.f38594a.t();
    }

    public void stop() {
        this.f38594a.u();
    }
}
