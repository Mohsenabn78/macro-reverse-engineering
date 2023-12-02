package crashguard.android.library;

import android.content.Context;
import android.os.Debug;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import crashguard.android.library.d6;
import crashguard.android.library.g0;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class k6 extends i {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38893a;

    /* renamed from: b  reason: collision with root package name */
    private final n0 f38894b;

    /* renamed from: d  reason: collision with root package name */
    private final h1 f38895d;

    /* renamed from: e  reason: collision with root package name */
    private final List<h1> f38896e;

    static {
        String str = "healthcheck.report.reason";
        String str2 = "healthcheck.honor.interval";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(Context context, @Nullable h1 h1Var) {
        this(context, h1Var, new LinkedList());
    }

    private String a() {
        return String.format("%s/module/healthcheck", getBaseUrl());
    }

    private static JSONObject b(String str, y0 y0Var) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        y0Var.F(str);
        String str2 = "wsi";
        if (jSONObject.has(str2)) {
            y0Var.S(jSONObject.getLong(str2) * 1000);
        }
        String str3 = "wsd";
        if (jSONObject.has(str3)) {
            y0Var.Q(jSONObject.getLong(str3));
        }
        String str4 = "csi";
        if (jSONObject.has(str4)) {
            y0Var.q(jSONObject.getLong(str4) * 1000);
        }
        String str5 = "csd";
        if (jSONObject.has(str5)) {
            y0Var.n(jSONObject.getLong(str5));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(long j4) {
        if (j4 <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, boolean z3) throws Throwable {
        boolean z4;
        boolean z5;
        int i4;
        long j4;
        long currentTimeMillis;
        long j5;
        boolean z6;
        Context context = this.f38893a.get();
        if (context != null) {
            y0 y0Var = new y0(context);
            if (z3) {
                z4 = d(y0Var.b0());
            } else {
                z4 = true;
            }
            if (z4) {
                d6.a a4 = new d6(context).a();
                if (a4 != null) {
                    y0Var.z(a4.f38701a);
                    y0Var.C(a4.f38702b);
                    n6 n6Var = new n6(context, y0Var);
                    n6Var.d(this.f38895d);
                    n6Var.f(this.f38896e);
                    n6Var.e(str);
                    this.f38894b.getClass();
                    if (!n0.b() && !Debug.isDebuggerConnected()) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    String jSONObject = n6Var.a(i4, a4).toString();
                    CrashGuard crashGuard = CrashGuard.getInstance(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String a5 = new v0().a(y0Var, currentTimeMillis2 - (currentTimeMillis2 - a4.f38703c), crashGuard.getAccessCode(), crashGuard.getSecretCode());
                    if (a5 != null) {
                        String d4 = k2.d(gzip(jSONObject, 7), new SecretKeySpec(k2.g(crashGuard.getAccessCode() + crashGuard.getSecretCode()).getBytes(), k2.f38889a));
                        ByteArrayInputStream a6 = new NativeCrashGuard().a();
                        try {
                            u uVar = new u(a(), a6);
                            uVar.f38746a.setRequestProperty(getSignatureHeader(), a5);
                            g0.a c4 = uVar.c("application/json", d4.getBytes());
                            if (c4.a() == 200) {
                                y0Var.f0();
                                y0Var.h();
                                y0Var.i();
                                y0Var.j();
                                y0Var.k();
                                String str2 = new String(c4.b(), 0, c4.b().length);
                                JSONObject b4 = b(str2, y0Var);
                                String str3 = "hb";
                                if (b4.has(str3)) {
                                    j4 = Math.abs(b4.getLong(str3));
                                } else {
                                    j4 = 300;
                                }
                                if (j4 > 0) {
                                    j5 = System.currentTimeMillis();
                                    currentTimeMillis = j4 * 1000;
                                } else {
                                    currentTimeMillis = System.currentTimeMillis();
                                    j5 = 300000;
                                }
                                y0Var.M(currentTimeMillis + j5);
                                boolean equals = ExifInterface.GPS_MEASUREMENT_3D.equals(str);
                                boolean equals2 = "4".equals(str);
                                if (!equals && !equals2) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6 && b4.has("bl")) {
                                    new NativeCrashGuard().b(context, a5, str2);
                                }
                                new l2(context).b();
                                new v1(context).c();
                                new b6(context).b();
                                uVar.close();
                                a6.close();
                                return;
                            }
                            throw new RuntimeException();
                        } catch (Throwable th) {
                            try {
                                a6.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    throw new RuntimeException();
                }
                throw new RuntimeException();
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(Context context, @NonNull LinkedList linkedList) {
        this(context, null, linkedList);
    }

    private k6(Context context, @Nullable h1 h1Var, @NonNull LinkedList linkedList) {
        this.f38893a = new WeakReference<>(context);
        this.f38895d = h1Var;
        this.f38896e = linkedList;
        this.f38894b = new n0();
    }
}
