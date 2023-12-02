package crashguard.android.library;

import android.content.Context;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.facebook.stetho.dumpapp.Framer;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class d6 extends i {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        protected String f38701a;

        /* renamed from: b  reason: collision with root package name */
        protected String f38702b;

        /* renamed from: c  reason: collision with root package name */
        protected long f38703c;

        a(long j4) {
            this.f38703c = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d6(Context context) {
        this.f38700a = new WeakReference<>(context);
    }

    private static JSONObject b(String str) throws Exception {
        g0 g0Var;
        List<String> list;
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        if (str.startsWith("https")) {
            ByteArrayInputStream a4 = new NativeCrashGuard().a();
            try {
                g0Var = new u(str, a4);
                a4.close();
            } catch (Throwable th) {
                try {
                    a4.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            g0Var = new g0(str);
        }
        g0Var.f38746a.setConnectTimeout(5000);
        g0Var.f38746a.setReadTimeout(5000);
        g0Var.f38746a.setRequestMethod("HEAD");
        g0Var.f38746a.setDoInput(false);
        g0Var.f38746a.setDoOutput(false);
        Map<String, List<String>> headerFields = g0Var.f38746a.getHeaderFields();
        if (headerFields == null || (list = headerFields.get(new String(new byte[]{88, Framer.STDIN_FRAME_PREFIX, 67, 82, 65, 83, 72, 71, 85, 65, 82, 68, Framer.STDIN_FRAME_PREFIX, 72, 73, 78, 84}))) == null || list.size() <= 0) {
            return null;
        }
        return new JSONObject(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a() throws Exception {
        JSONObject jSONObject;
        NetworkSecurityPolicy networkSecurityPolicy;
        NetworkSecurityPolicy networkSecurityPolicy2;
        a aVar = null;
        if (this.f38700a.get() == null) {
            return null;
        }
        boolean z3 = true;
        JSONObject b4 = b(String.format("%s/module/healthcheck", getBaseUrl()));
        String str = "http://catch6.crashguard.me";
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 22) {
            if (i4 > 23) {
                try {
                    networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
                    z3 = networkSecurityPolicy.isCleartextTrafficPermitted(new URL(str).getHost());
                } catch (MalformedURLException unused) {
                    z3 = false;
                }
            } else {
                networkSecurityPolicy2 = NetworkSecurityPolicy.getInstance();
                z3 = networkSecurityPolicy2.isCleartextTrafficPermitted();
            }
        }
        if (z3) {
            jSONObject = b(str);
        } else {
            jSONObject = null;
        }
        if (b4 != null) {
            aVar = new a(b4.getLong("epoch") * 1000);
            aVar.f38701a = b4.getString("ip");
        }
        if (jSONObject != null) {
            if (aVar == null) {
                aVar = new a(jSONObject.getLong("epoch") * 1000);
            }
            aVar.f38702b = jSONObject.getString("ip");
        }
        return aVar;
    }
}
