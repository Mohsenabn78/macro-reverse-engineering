package crashguard.android.library;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.stetho.dumpapp.Framer;
import crashguard.android.library.d6;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    private final b1 f39079a;

    /* renamed from: b  reason: collision with root package name */
    private final l2 f39080b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<Context> f39081c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1(Context context) {
        this.f39081c = new WeakReference<>(context);
        this.f39079a = t4.f(context).g();
        this.f39080b = new l2(context);
    }

    private static String b(String str) {
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty() && !trim.equalsIgnoreCase("<unknown ssid>")) {
                return trim.replace("\\\"", "");
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(q1 q1Var) {
        h2.c(this.f39081c.get()).g(q1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.f39079a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(g1 g1Var) {
        try {
            SecretKeySpec e4 = new e1(this.f39081c.get()).e();
            if (e4 != null) {
                this.f39079a.d(new l1(null, g1Var.n(), k2.h(g1Var.w(), e4), k2.g(g1Var.w()), k2.h(g1Var.a(), e4), k2.g(g1Var.a()), k2.h(g1Var.u(), e4), k2.h(g1Var.p(), e4), k2.h(g1Var.f(), e4), k2.h(g1Var.q(), e4), k2.h(g1Var.j(), e4), k2.h(String.valueOf(g1Var.x()), e4), k2.h(String.valueOf(g1Var.l()), e4), k2.h(String.valueOf(g1Var.v()), e4), k2.h(String.valueOf(g1Var.o()), e4), k2.h(String.valueOf(g1Var.y()), e4), k2.h(String.valueOf(g1Var.r()), e4), k2.h(String.valueOf(g1Var.s()), e4), k2.h(g1Var.t(), e4)));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList f() {
        LinkedList linkedList = new LinkedList();
        try {
            SecretKeySpec e4 = new e1(this.f39081c.get()).e();
            if (e4 != null) {
                Iterator it = this.f39079a.g().iterator();
                while (it.hasNext()) {
                    l1 l1Var = (l1) it.next();
                    Iterator it2 = it;
                    linkedList.add(new g1(l1Var.j(), l1Var.f(), new String(k2.f(l1Var.r(), e4)), new String(k2.f(l1Var.a(), e4)), new String(k2.f(l1Var.p(), e4)), new String(k2.f(l1Var.k(), e4)), new String(k2.f(l1Var.c(), e4)), new String(k2.f(l1Var.l(), e4)), new String(k2.f(l1Var.d(), e4)), Long.parseLong(new String(k2.f(l1Var.s(), e4))), Float.parseFloat(new String(k2.f(l1Var.e(), e4))), Float.parseFloat(new String(k2.f(l1Var.q(), e4))), Float.parseFloat(new String(k2.f(l1Var.i(), e4))), Float.parseFloat(new String(k2.f(l1Var.t(), e4))), Double.parseDouble(new String(k2.f(l1Var.m(), e4))), Double.parseDouble(new String(k2.f(l1Var.n(), e4))), new String(k2.f(l1Var.o(), e4))));
                    it = it2;
                }
            }
        } catch (Throwable unused) {
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        String f4;
        try {
            Context context = this.f39081c.get();
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            String valueOf = String.valueOf(connectionInfo.getRssi());
            String b4 = b(connectionInfo.getSSID());
            if (b4 == null && (b4 = b(z4.f39157a)) == null) {
                b4 = null;
            }
            String bssid = connectionInfo.getBSSID();
            if (b4 != null && bssid != null && !bssid.isEmpty()) {
                boolean z3 = false;
                if (!bssid.equalsIgnoreCase(new String(new byte[]{48, Framer.STDERR_FRAME_PREFIX, 58, 48, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48})) && !bssid.equalsIgnoreCase("00:00:00:00:00:00")) {
                    String upperCase = bssid.toUpperCase(Locale.ENGLISH);
                    String encodeToString = Base64.encodeToString(b4.getBytes(), 2);
                    String g4 = k2.g(encodeToString);
                    String g5 = k2.g(upperCase);
                    if (this.f39079a.f() >= 5000 || this.f39079a.e(g4, g5) || (f4 = c5.f()) == null) {
                        return;
                    }
                    String g6 = c5.g();
                    y0 y0Var = new y0(context);
                    String N = y0Var.N();
                    String P = y0Var.P();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (Math.abs(y0Var.Z() - elapsedRealtime) > 30000) {
                        y0Var.H(elapsedRealtime + 30000);
                        z3 = true;
                    }
                    if (z3) {
                        try {
                            d6.a a4 = new d6(context).a();
                            if (a4 != null) {
                                N = a4.f38701a;
                                P = a4.f38702b;
                                y0Var.z(N);
                                y0Var.C(P);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    g1 g1Var = new g1(System.currentTimeMillis() + 604800000, encodeToString, upperCase, valueOf, f4, N, g6, P);
                    y1 a5 = this.f39080b.a(6000L);
                    if (a5 == null) {
                        z5 z5Var = new z5(context);
                        if (z5Var.f() || z5Var.e()) {
                            final q1 q1Var = new q1(this.f39081c.get(), this, g1Var);
                            p1.b(Thread.currentThread(), new Runnable() { // from class: crashguard.android.library.r1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    v1.this.e(q1Var);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    g1Var.d(a5.j());
                    g1Var.c(a5.a());
                    g1Var.k(a5.i());
                    g1Var.h(a5.e());
                    g1Var.m(a5.k());
                    g1Var.b(a5.f());
                    g1Var.g(a5.g());
                    g1Var.i(a5.h());
                    d(g1Var);
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
