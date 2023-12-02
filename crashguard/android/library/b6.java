package crashguard.android.library;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b6 {

    /* renamed from: a  reason: collision with root package name */
    private final e5 f38656a;

    /* renamed from: b  reason: collision with root package name */
    private final l2 f38657b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<Context> f38658c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b6(Context context) {
        this.f38658c = new WeakReference<>(context);
        this.f38656a = t4.f(context).i();
        this.f38657b = new l2(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(x5 x5Var) {
        h2.c(this.f38658c.get()).g(x5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f38656a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
        if ((r7[0] * 3.28084f) >= ((float) r5)) goto L3;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(crashguard.android.library.y1 r21) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.b6.c(crashguard.android.library.y1):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(i5 i5Var) {
        try {
            SecretKeySpec e4 = new e1(this.f38658c.get()).e();
            if (e4 != null) {
                this.f38656a.d(new m5(null, i5Var.o(), k2.h(i5Var.v(), e4), k2.h(i5Var.w(), e4), k2.h(String.valueOf(i5Var.f()), e4), k2.h(String.valueOf(i5Var.s()), e4), k2.h(i5Var.q(), e4), k2.h(i5Var.j(), e4), k2.h(i5Var.r(), e4), k2.h(i5Var.l(), e4), k2.h(i5Var.a(), e4), k2.h(String.valueOf(i5Var.z()), e4), k2.h(String.valueOf(i5Var.n()), e4), k2.h(String.valueOf(i5Var.y()), e4), k2.h(String.valueOf(i5Var.p()), e4), k2.h(String.valueOf(i5Var.A()), e4), k2.h(String.valueOf(i5Var.t()), e4), k2.h(String.valueOf(i5Var.u()), e4), k2.h(i5Var.x(), e4)));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList f() {
        this.f38656a.b();
        LinkedList linkedList = new LinkedList();
        try {
            SecretKeySpec e4 = new e1(this.f38658c.get()).e();
            if (e4 != null) {
                Iterator it = this.f38656a.f().iterator();
                while (it.hasNext()) {
                    m5 m5Var = (m5) it.next();
                    Iterator it2 = it;
                    LinkedList linkedList2 = linkedList;
                    try {
                        SecretKeySpec secretKeySpec = e4;
                        try {
                            linkedList2.add(new i5(m5Var.i(), m5Var.g(), new String(k2.f(m5Var.o(), e4)), new String(k2.f(m5Var.p(), e4)), Long.parseLong(new String(k2.f(m5Var.c(), e4))), Long.parseLong(new String(k2.f(m5Var.l(), e4))), new String(k2.f(m5Var.j(), e4)), new String(k2.f(m5Var.d(), e4)), new String(k2.f(m5Var.k(), e4)), new String(k2.f(m5Var.e(), e4)), new String(k2.f(m5Var.a(), e4)), Long.parseLong(new String(k2.f(m5Var.s(), e4))), Float.parseFloat(new String(k2.f(m5Var.f(), e4))), Float.parseFloat(new String(k2.f(m5Var.r(), e4))), Float.parseFloat(new String(k2.f(m5Var.h(), e4))), Float.parseFloat(new String(k2.f(m5Var.t(), e4))), Double.parseDouble(new String(k2.f(m5Var.m(), e4))), Double.parseDouble(new String(k2.f(m5Var.n(), e4))), new String(k2.f(m5Var.q(), e4))));
                            linkedList = linkedList2;
                            it = it2;
                            e4 = secretKeySpec;
                        } catch (Throwable unused) {
                            return linkedList2;
                        }
                    } catch (Throwable unused2) {
                        return linkedList2;
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return linkedList;
    }
}
