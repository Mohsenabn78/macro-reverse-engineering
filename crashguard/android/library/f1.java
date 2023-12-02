package crashguard.android.library;

import android.content.Context;
import android.os.Bundle;
import crashguard.android.library.c0;
import crashguard.android.library.h6;
import crashguard.android.library.s0;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38739a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f38740b;

    /* renamed from: c  reason: collision with root package name */
    private final a1 f38741c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(Context context, Bundle bundle, a1 a1Var) {
        this.f38739a = new WeakReference<>(context);
        this.f38740b = bundle;
        this.f38741c = a1Var;
    }

    private static void b(Context context, c0 c0Var) {
        s0 c4 = new s0.a().a(c0Var.x()).b(c0.f38663o, c0Var.h()).c();
        h6.a aVar = new h6.a(c0Var.v(), c0Var.l());
        aVar.f39070a.e(c4);
        g6.b(context).c(new h6(((h6.a) aVar.a()).f39070a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context a() {
        return this.f38739a.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        h0 o4;
        c0 h4;
        boolean z3;
        h0 o5;
        c0 h5;
        try {
            Context context = this.f38739a.get();
            m0 m0Var = null;
            String string = this.f38740b.getString(c0.f38662n, null);
            if (string != null && (h4 = (o4 = t4.f(context).o()).h(string)) != null) {
                h4.t();
                boolean z4 = true;
                if (h4.a() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    o4.f(h4);
                } else {
                    boolean z5 = this.f38740b.getBoolean(c0.f38661m, false);
                    if (!h4.A() || !h4.z() || !h4.y() || !z5) {
                        z4 = false;
                    }
                    if (z4) {
                        b(context, h4);
                    } else {
                        Context context2 = this.f38739a.get();
                        String w3 = h4.w();
                        if (a2.class.getName().equalsIgnoreCase(w3)) {
                            m0Var = new a2(context2, h4);
                        } else if (t.class.getName().equalsIgnoreCase(w3)) {
                            m0Var = new t(context2, h4);
                        }
                        if (m0Var != null) {
                            try {
                                h4.d(c0.a.RUNNING);
                                o4.j(h4);
                                String e4 = h4.x().e(c0.f38663o);
                                if (e4 != null && (h5 = (o5 = t4.f(this.f38739a.get()).o()).h(e4)) != null) {
                                    h5.o(h5.p() + 1);
                                    o5.j(h5);
                                }
                                m0Var.a();
                                if (h4.A()) {
                                    h4.d(c0.a.ENQUEUED);
                                    h4.o(h4.p() + 1);
                                    h4.q(System.currentTimeMillis());
                                    o4.j(h4);
                                } else {
                                    o4.f(h4);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    o4.c();
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            a1 a1Var = this.f38741c;
            if (a1Var != null) {
                a1Var.onWorkFinished();
            }
        } catch (Throwable unused3) {
        }
    }
}
