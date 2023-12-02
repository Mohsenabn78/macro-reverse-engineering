package crashguard.android.library;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l2 {

    /* renamed from: a  reason: collision with root package name */
    private final t1 f38921a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f38922b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2(Context context) {
        this.f38922b = new WeakReference<>(context);
        this.f38921a = t4.f(context).k();
    }

    private void d(Location location, float f4, long j4, SecretKeySpec secretKeySpec) throws Exception {
        this.f38921a.e(new b2(null, k2.h(String.valueOf(location.getTime()), secretKeySpec), j4, location.getTime(), k2.h(String.valueOf(location.getLatitude()), secretKeySpec), k2.h(String.valueOf(location.getLongitude()), secretKeySpec), k2.h(String.valueOf(location.getBearing()), secretKeySpec), k2.h(String.valueOf(location.getSpeed()), secretKeySpec), k2.h(String.valueOf(location.getAccuracy()), secretKeySpec), k2.h(String.valueOf(f4), secretKeySpec), k2.h(String.valueOf(location.getProvider()), secretKeySpec)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y1 a(long j4) {
        SecretKeySpec e4;
        try {
            b2 a4 = this.f38921a.a(j4);
            if (a4 != null && (e4 = new e1(this.f38922b.get()).e()) != null) {
                return new y1(a4.f(), Long.parseLong(new String(k2.f(a4.k(), e4))), Double.parseDouble(new String(k2.f(a4.g(), e4))), Double.parseDouble(new String(k2.f(a4.h(), e4))), Float.parseFloat(new String(k2.f(a4.a(), e4))), Float.parseFloat(new String(k2.f(a4.j(), e4))), Float.parseFloat(new String(k2.f(a4.e(), e4))), Float.parseFloat(new String(k2.f(a4.l(), e4))), new String(k2.f(a4.i(), e4)));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f38921a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Location location) {
        float f4;
        boolean z3;
        try {
            Context context = this.f38922b.get();
            SecretKeySpec e4 = new e1(context).e();
            if (e4 == null) {
                return;
            }
            if (Build.VERSION.SDK_INT > 25) {
                f4 = location.getVerticalAccuracyMeters();
            } else {
                f4 = 0.0f;
            }
            long time = location.getTime() + 604800000;
            if (this.f38921a.f() < 5000) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                d(location, f4, time, e4);
            }
            new y0(context).o(new y1(location, time, f4));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList e() {
        LinkedList linkedList = new LinkedList();
        try {
            SecretKeySpec e4 = new e1(this.f38922b.get()).e();
            if (e4 != null) {
                Iterator it = this.f38921a.g().iterator();
                while (it.hasNext()) {
                    b2 b2Var = (b2) it.next();
                    Iterator it2 = it;
                    linkedList.add(new y1(b2Var.f(), Long.parseLong(new String(k2.f(b2Var.k(), e4))), Double.parseDouble(new String(k2.f(b2Var.g(), e4))), Double.parseDouble(new String(k2.f(b2Var.h(), e4))), Float.parseFloat(new String(k2.f(b2Var.a(), e4))), Float.parseFloat(new String(k2.f(b2Var.j(), e4))), Float.parseFloat(new String(k2.f(b2Var.e(), e4))), Float.parseFloat(new String(k2.f(b2Var.l(), e4))), new String(k2.f(b2Var.i(), e4))));
                    it = it2;
                }
            }
        } catch (Throwable unused) {
        }
        return linkedList;
    }
}
