package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class y0 extends e6 {
    private final String A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final String F;
    private final String G;

    /* renamed from: g  reason: collision with root package name */
    private final String f39123g;

    /* renamed from: h  reason: collision with root package name */
    private final String f39124h;

    /* renamed from: i  reason: collision with root package name */
    private final String f39125i;

    /* renamed from: j  reason: collision with root package name */
    private final String f39126j;

    /* renamed from: k  reason: collision with root package name */
    private final String f39127k;

    /* renamed from: l  reason: collision with root package name */
    private final String f39128l;

    /* renamed from: m  reason: collision with root package name */
    private final String f39129m;

    /* renamed from: n  reason: collision with root package name */
    private final String f39130n;

    /* renamed from: o  reason: collision with root package name */
    private final String f39131o;

    /* renamed from: p  reason: collision with root package name */
    private final String f39132p;

    /* renamed from: q  reason: collision with root package name */
    private final String f39133q;

    /* renamed from: r  reason: collision with root package name */
    private final String f39134r;

    /* renamed from: s  reason: collision with root package name */
    private final String f39135s;

    /* renamed from: t  reason: collision with root package name */
    private final String f39136t;

    /* renamed from: u  reason: collision with root package name */
    private final String f39137u;

    /* renamed from: v  reason: collision with root package name */
    private final String f39138v;

    /* renamed from: w  reason: collision with root package name */
    private final String f39139w;

    /* renamed from: x  reason: collision with root package name */
    private final String f39140x;

    /* renamed from: y  reason: collision with root package name */
    private final String f39141y;

    /* renamed from: z  reason: collision with root package name */
    private final String f39142z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(Context context) {
        super(context, "crashguard.android.library.preferences");
        this.f39123g = "device.id";
        this.f39124h = "jwt.auth";
        String str = "info";
        this.f39125i = "response";
        this.f39126j = "bp";
        this.f39127k = new String(new byte[]{98, 112, Framer.STDIN_REQUEST_FRAME_PREFIX, 98, 112});
        this.f39128l = new String(new byte[]{98, 112, Framer.STDIN_REQUEST_FRAME_PREFIX, 101, 115, 112});
        this.f39129m = new String(new byte[]{98, 112, Framer.STDIN_REQUEST_FRAME_PREFIX, 109, 108});
        this.f39130n = new String(new byte[]{98, 112, Framer.STDIN_REQUEST_FRAME_PREFIX, 110, 112});
        this.f39131o = "last.reported.timestamp";
        this.f39132p = "last.wifi.scan.check.timestamp";
        this.f39133q = "last.cell.scan.check.timestamp";
        this.f39134r = "last.crash.counter.reset.timestamp";
        this.f39135s = "last.crash.timestamp";
        this.f39136t = "crash.counter";
        this.f39137u = "aaid";
        this.f39138v = new String(new byte[]{110, 101, Framer.EXIT_FRAME_PREFIX, 116, 46, 97, 97, 105, 100, 46, 99, 104, 101, 99, 107});
        this.f39139w = "installed.apps.time";
        this.f39140x = "last.known.location";
        this.f39141y = "last.known.v4";
        this.f39142z = "last.known.v6";
        this.A = "offset";
        this.B = new String(new byte[]{110, 101, Framer.EXIT_FRAME_PREFIX, 116, 46, 99, 108, 105, 101, 110, 116, 46, 99, 104, 101, 99, 107});
        this.C = "wsi";
        this.D = "wsd";
        this.E = "csi";
        this.F = "csd";
        this.G = "supplemental.info";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long A() {
        return c(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS, this.E);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(long j4) {
        a(this.f39132p, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(String str) {
        b(this.f39142z, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D() {
        return e(this.f39137u, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void E(long j4) {
        a(this.f39138v, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F(String str) {
        b(this.f39125i, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String G() {
        String e4 = e(this.f39123g, null);
        if (e4 == null) {
            String uuid = UUID.randomUUID().toString();
            b(this.f39123g, uuid, true);
            return uuid;
        }
        return e4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(long j4) {
        a(this.B, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I(String str) {
        b(this.G, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String J() {
        return e(this.f39128l, "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void K(long j4) {
        a(this.f39139w, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long L() {
        return c(0L, this.f39133q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(long j4) {
        a(this.f39131o, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String N() {
        return e(this.f39141y, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(long j4) {
        a(this.A, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String P() {
        return e(this.f39142z, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(long j4) {
        a(this.C, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long R() {
        return c(0L, this.f39134r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(long j4) {
        a(this.C, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long T() {
        return c(0L, this.f39135s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y1 U() {
        String e4 = e(this.f39140x, null);
        if (e4 != null) {
            try {
                return new y1(new JSONObject(e4));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long V() {
        return c(0L, this.f39132p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String W() {
        return e(this.f39129m, "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String X() {
        return e(this.f39130n, "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long Y() {
        return c(0L, this.f39138v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long Z() {
        return c(0L, this.B);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a0() {
        return c(0L, this.f39139w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b0() {
        return c(0L, this.f39131o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c0() {
        return e(this.G, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long d0() {
        return c(45L, this.D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e0() {
        return c(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS, this.C);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f0() {
        b(this.f39126j, "0", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        b(this.f39127k, "0", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        b(this.f39128l, "0", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        b(this.f39129m, "0", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        b(this.f39130n, "0", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l() {
        return e(this.f39124h, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(int i4) {
        f(this.f39136t, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(long j4) {
        a(this.F, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(y1 y1Var) throws Exception {
        b(this.f39140x, y1Var.b(true, false).toString(), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String p() {
        return e(this.f39126j, "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(long j4) {
        a(this.E, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String r() {
        return e(this.f39127k, "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(long j4) {
        a(this.f39133q, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(String str) {
        b(this.f39124h, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int u() {
        return g(this.f39136t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v(long j4) {
        a(this.f39134r, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(String str) {
        b(this.f39137u, str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long x() {
        return c(45L, this.F);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(long j4) {
        a(this.f39135s, j4, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(String str) {
        b(this.f39141y, str, true);
    }
}
