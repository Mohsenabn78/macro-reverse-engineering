package crashguard.android.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class d5 {

    /* renamed from: a  reason: collision with root package name */
    private final m2 f38695a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f38696b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiManager f38697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y1 f38698b;

        a(WifiManager wifiManager, y1 y1Var) {
            this.f38697a = wifiManager;
            this.f38698b = y1Var;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                List<ScanResult> scanResults = this.f38697a.getScanResults();
                if (scanResults.size() > 0) {
                    d5.f(d5.this, d5.d(d5.this, scanResults, this.f38698b));
                    ((Context) d5.this.f38696b.get()).unregisterReceiver(this);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d5(Context context) {
        this.f38695a = t4.f(context).l();
        this.f38696b = new WeakReference<>(context);
    }

    private static h5 a(l5 l5Var, k2 k2Var, SecretKeySpec secretKeySpec) throws Exception {
        return new h5(l5Var.h(), Long.parseLong(new String(k2.f(l5Var.o(), secretKeySpec))), k2.a(new String(k2.f(l5Var.n(), secretKeySpec))), new String(k2.f(l5Var.a(), secretKeySpec)), new String(k2.f(l5Var.c(), secretKeySpec)), Integer.parseInt(new String(k2.f(l5Var.j(), secretKeySpec))), Integer.parseInt(new String(k2.f(l5Var.f(), secretKeySpec))), Float.parseFloat(new String(k2.f(l5Var.d(), secretKeySpec))), Float.parseFloat(new String(k2.f(l5Var.m(), secretKeySpec))), Double.parseDouble(new String(k2.f(l5Var.i(), secretKeySpec))), Double.parseDouble(new String(k2.f(l5Var.k(), secretKeySpec))), Float.parseFloat(new String(k2.f(l5Var.g(), secretKeySpec))), Float.parseFloat(new String(k2.f(l5Var.p(), secretKeySpec))), new String(k2.f(l5Var.l(), secretKeySpec)));
    }

    static LinkedList d(d5 d5Var, List list, y1 y1Var) {
        d5Var.getClass();
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ScanResult scanResult = (ScanResult) it.next();
            String trim = scanResult.SSID.trim();
            if (trim.length() > 0 && !trim.equals("<unknown ssid>")) {
                System.currentTimeMillis();
                linkedList.add(new h5(null, y1Var.j(), scanResult.SSID, scanResult.BSSID.toUpperCase(Locale.ENGLISH), scanResult.capabilities, scanResult.level, scanResult.frequency, y1Var.a(), y1Var.i(), y1Var.f(), y1Var.g(), y1Var.e(), y1Var.k(), y1Var.h()));
            }
        }
        return linkedList;
    }

    static void f(d5 d5Var, LinkedList linkedList) {
        d5Var.getClass();
        try {
            SecretKeySpec e4 = new e1(d5Var.f38696b.get()).e();
            if (e4 != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    h5 h5Var = (h5) it.next();
                    d5Var.f38695a.d(new l5(null, 604800000 + h5Var.n(), k2.h(String.valueOf(h5Var.n()), e4), k2.h(h5Var.m(), e4), k2.h(h5Var.a(), e4), k2.h(h5Var.d(), e4), k2.h(String.valueOf(h5Var.i()), e4), k2.h(String.valueOf(h5Var.f()), e4), k2.h(String.valueOf(h5Var.e()), e4), k2.h(String.valueOf(h5Var.l()), e4), k2.h(String.valueOf(h5Var.h()), e4), k2.h(String.valueOf(h5Var.j()), e4), k2.h(String.valueOf(h5Var.g()), e4), k2.h(String.valueOf(h5Var.o()), e4), k2.h(h5Var.k(), e4)));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList c() {
        this.f38695a.b();
        LinkedList linkedList = new LinkedList();
        try {
            k2 k2Var = new k2();
            SecretKeySpec e4 = new e1(this.f38696b.get()).e();
            if (e4 != null) {
                for (l5 l5Var : this.f38695a.f()) {
                    linkedList.add(a(l5Var, k2Var, e4));
                }
            }
        } catch (Throwable unused) {
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        if ((r6[0] * 3.28084f) >= ((float) r4)) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(crashguard.android.library.y1 r17) {
        /*
            r16 = this;
            r0 = r16
            crashguard.android.library.m2 r1 = r0.f38695a
            long r1 = r1.e()
            r3 = 4999(0x1387, double:2.47E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto Lf
            return
        Lf:
            crashguard.android.library.y0 r1 = new crashguard.android.library.y0
            java.lang.ref.WeakReference<android.content.Context> r2 = r0.f38696b
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            r1.<init>(r2)
            crashguard.android.library.y1 r2 = r1.U()
            if (r2 != 0) goto L23
            goto L5c
        L23:
            r3 = 0
            long r4 = r1.e0()     // Catch: java.lang.Throwable -> L5e
            long r6 = r1.V()     // Catch: java.lang.Throwable -> L5e
            long r6 = r6 + r4
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5e
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L5f
            long r4 = r1.d0()     // Catch: java.lang.Throwable -> L5e
            r6 = 5
            float[] r6 = new float[r6]     // Catch: java.lang.Throwable -> L5e
            double r7 = r17.f()     // Catch: java.lang.Throwable -> L5e
            double r9 = r17.g()     // Catch: java.lang.Throwable -> L5e
            double r11 = r2.f()     // Catch: java.lang.Throwable -> L5e
            double r13 = r2.g()     // Catch: java.lang.Throwable -> L5e
            r15 = r6
            android.location.Location.distanceBetween(r7, r9, r11, r13, r15)     // Catch: java.lang.Throwable -> L5e
            r2 = r6[r3]     // Catch: java.lang.Throwable -> L5e
            r6 = 1079114056(0x4051f948, float:3.28084)
            float r2 = r2 * r6
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L5f
        L5c:
            r3 = 1
            goto L5f
        L5e:
        L5f:
            if (r3 != 0) goto L62
            return
        L62:
            long r2 = java.lang.System.currentTimeMillis()
            r1.B(r2)
            java.lang.ref.WeakReference<android.content.Context> r1 = r0.f38696b     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lac
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Throwable -> Lac
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> Lac
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1     // Catch: java.lang.Throwable -> Lac
            crashguard.android.library.z5 r2 = new crashguard.android.library.z5     // Catch: java.lang.Throwable -> Lac
            java.lang.ref.WeakReference<android.content.Context> r3 = r0.f38696b     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r3 = r3.get()     // Catch: java.lang.Throwable -> Lac
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> Lac
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lac
            boolean r2 = r2.j()     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto Lac
            java.lang.ref.WeakReference<android.content.Context> r2 = r0.f38696b     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> Lac
            android.content.Context r2 = (android.content.Context) r2     // Catch: java.lang.Throwable -> Lac
            crashguard.android.library.d5$a r3 = new crashguard.android.library.d5$a     // Catch: java.lang.Throwable -> Lac
            r4 = r17
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> Lac
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> Lac
            java.lang.String r5 = "android.net.wifi.SCAN_RESULTS"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lac
            r2.registerReceiver(r3, r4)     // Catch: java.lang.Throwable -> Lac
            r1.startScan()     // Catch: java.lang.Throwable -> Lac
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.d5.e(crashguard.android.library.y1):void");
    }
}
