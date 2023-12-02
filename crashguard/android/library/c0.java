package crashguard.android.library;

import crashguard.android.library.s0;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c0 {

    /* renamed from: l  reason: collision with root package name */
    static String f38660l = "worker.data";

    /* renamed from: m  reason: collision with root package name */
    static String f38661m = "worker.delay.first.run";

    /* renamed from: n  reason: collision with root package name */
    static String f38662n = "worker.id";

    /* renamed from: o  reason: collision with root package name */
    static String f38663o = "delayed.worker.id";

    /* renamed from: a  reason: collision with root package name */
    private String f38664a;

    /* renamed from: b  reason: collision with root package name */
    private String f38665b;

    /* renamed from: c  reason: collision with root package name */
    private int f38666c;

    /* renamed from: d  reason: collision with root package name */
    private a f38667d;

    /* renamed from: e  reason: collision with root package name */
    private long f38668e;

    /* renamed from: f  reason: collision with root package name */
    private long f38669f;

    /* renamed from: g  reason: collision with root package name */
    private long f38670g;

    /* renamed from: h  reason: collision with root package name */
    private long f38671h;

    /* renamed from: i  reason: collision with root package name */
    private long f38672i;

    /* renamed from: j  reason: collision with root package name */
    private final Class<? extends m0> f38673j;

    /* renamed from: k  reason: collision with root package name */
    private s0 f38674k;

    /* loaded from: classes6.dex */
    enum a {
        ENQUEUED(0),
        RUNNING(1),
        /* JADX INFO: Fake field, exist only in values array */
        CANCELLED(2),
        FINISHED(10);
        

        /* renamed from: e  reason: collision with root package name */
        private static final HashMap f38678e = new HashMap();

        /* renamed from: a  reason: collision with root package name */
        private final int f38680a;

        static {
            a[] values;
            for (a aVar : values()) {
                f38678e.put(Integer.valueOf(aVar.f38680a), aVar);
            }
        }

        a(int i4) {
            this.f38680a = i4;
        }

        static a b(int i4) {
            return (a) f38678e.get(Integer.valueOf(i4));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int a() {
            return this.f38680a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c0(String str) {
        Class cls = t.class;
        try {
            Class cls2 = Class.forName(str, false, c0.class.getClassLoader());
            if (m0.class.isAssignableFrom(cls2)) {
                cls = cls2;
            }
        } catch (ClassNotFoundException unused) {
        }
        this.f38673j = cls;
        this.f38670g = 0L;
        this.f38671h = 0L;
        this.f38674k = new s0.a().c();
        this.f38672i = System.currentTimeMillis();
        this.f38667d = a.ENQUEUED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A() {
        boolean z3;
        if (this.f38671h < 1 && this.f38670g < 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && this.f38670g > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.f38669f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i4) {
        this.f38667d = a.b(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(long j4) {
        this.f38669f = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(a aVar) {
        this.f38667d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(s0 s0Var) {
        this.f38674k = s0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(String str) {
        this.f38664a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(byte[] bArr) {
        this.f38674k = s0.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String h() {
        return this.f38664a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(int i4) {
        this.f38666c = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(long j4) {
        this.f38671h = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(String str) {
        this.f38665b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long l() {
        return this.f38671h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(long j4) {
        this.f38670g = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long n() {
        return this.f38670g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(long j4) {
        this.f38668e = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long p() {
        return this.f38668e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(long j4) {
        this.f38672i = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a r() {
        return this.f38667d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int s() {
        return this.f38666c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String t() {
        String str = this.f38665b;
        if (str != null && !str.trim().isEmpty()) {
            return this.f38665b;
        }
        return this.f38673j.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long u() {
        return this.f38672i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<? extends m0> v() {
        return this.f38673j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w() {
        return this.f38673j.getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final s0 x() {
        return this.f38674k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean y() {
        if (this.f38668e < 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean z() {
        boolean z3;
        long j4 = this.f38671h;
        if (j4 < 1 && this.f38670g < 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && j4 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Class<? extends m0> cls) {
        this.f38670g = 0L;
        this.f38671h = 0L;
        this.f38674k = new s0.a().c();
        this.f38673j = cls;
        this.f38672i = System.currentTimeMillis();
        this.f38667d = a.ENQUEUED;
    }
}
