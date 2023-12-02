package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;
import crashguard.android.library.d6;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n6 {

    /* renamed from: a  reason: collision with root package name */
    private final y0 f39002a;

    /* renamed from: b  reason: collision with root package name */
    private h1 f39003b;

    /* renamed from: c  reason: collision with root package name */
    private List<h1> f39004c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private final u5 f39005d;

    /* renamed from: e  reason: collision with root package name */
    private final a5 f39006e;

    /* renamed from: f  reason: collision with root package name */
    private final x4 f39007f;

    /* renamed from: g  reason: collision with root package name */
    private final j2 f39008g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n6(Context context, y0 y0Var) {
        this.f39002a = y0Var;
        z5 z5Var = new z5(context);
        this.f39005d = new u5(context, z5Var);
        this.f39006e = new a5(context, z5Var);
        this.f39007f = new x4(context, z5Var);
        this.f39008g = new j2(context, z5Var);
    }

    private static JSONObject b(h1 h1Var, String str) throws JSONException {
        JSONObject p4 = h1Var.p();
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                boolean z3 = false;
                if (trim.length() > 512) {
                    trim = trim.substring(0, 512);
                    z3 = true;
                }
                p4.put("SuppInfoTruncated", z3);
                p4.put("SupplementalInfo", trim);
            }
        }
        return p4;
    }

    private static JSONObject c(j5 j5Var, w4 w4Var, d2 d2Var, n2 n2Var, int i4) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("CBR", j5Var.h());
        jSONObject.put("Timestamp", y4.a(j5Var.f()));
        jSONObject.put("UUID", j5Var.g());
        jSONObject.put("NetHostname", j5Var.C0());
        jSONObject.put("MID", j5Var.B());
        List<w> I = j5Var.I();
        if (I != null && I.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (w wVar : I) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("value", wVar.a());
                jSONObject2.put("timestamp", y4.a(wVar.c()));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("AIH", jSONArray);
        }
        jSONObject.put("GSFID", j5Var.m0());
        jSONObject.put("SerialNumber", j5Var.c());
        jSONObject.put("DRMID", j5Var.k0());
        JSONArray d4 = n2Var.d();
        if (d4 != null && d4.length() > 0) {
            jSONObject.put("CNID", d4);
        }
        jSONObject.put("PackageName", j5Var.D0());
        jSONObject.put("ParentVer", j5Var.U());
        jSONObject.put("AppBuild", j5Var.R());
        jSONObject.put("SDK", j5Var.b());
        jSONObject.put("Model", j5Var.B0());
        jSONObject.put("Manufacturer", j5Var.A0());
        jSONObject.put("CGV", j5Var.N());
        jSONObject.put("KernelVersion", j5Var.u0());
        jSONObject.put("DisplayLanguage", j5Var.g0());
        jSONObject.put("LanguageSetting", j5Var.w0());
        jSONObject.put("SoftwareVer", j5Var.d());
        jSONObject.put("rilModemBoard", j5Var.a());
        jSONObject.put("VerBaseband", j5Var.G0());
        jSONObject.put("ADS", j5Var.j());
        jSONObject.put("AZS", j5Var.k());
        jSONObject.put("IsBatteryCharging", j5Var.l());
        jSONObject.put("BL", j5Var.X());
        JSONObject jSONObject3 = new JSONObject();
        Map<String, Boolean> E0 = j5Var.E0();
        for (String str : E0.keySet()) {
            jSONObject3.put(str, E0.get(str));
        }
        jSONObject.put("PermissionArray", jSONObject3);
        jSONObject.put("IsDebugged", j5Var.m());
        jSONObject.put("IsEmulator", j5Var.o());
        jSONObject.put("DeveloperMode", j5Var.n());
        jSONObject.put("IsADB", j5Var.i());
        jSONObject.put("IsUSBConnected", j5Var.q());
        jSONObject.put("IsBluetoothEnabled", d2Var.h());
        jSONObject.put("isGPSEnabled", j5Var.p());
        if (w4Var.v() > -1) {
            jSONObject.put("IsWifiConnected", w4Var.v() == 1);
        }
        if (w4Var.u() > -1) {
            jSONObject.put("IsTetheringAP", w4Var.u() == 1);
        }
        jSONObject.put("CF", j5Var.a0());
        jSONObject.put("CS", j5Var.d0());
        jSONObject.put("IPCheckDate", y4.a(j5Var.s0()));
        jSONObject.put("IPCheckDateOffset", j5Var.q0());
        if (i4 == 2) {
            List<String> e4 = j5Var.e();
            if (e4 != null && e4.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : e4) {
                    jSONArray2.put(str2);
                }
                jSONObject.put("SupportedArchs", jSONArray2);
            }
            jSONObject.put("UserName", d2Var.g());
            jSONObject.put("BluetoothMac", d2Var.e());
            JSONArray a4 = d2Var.a();
            if (a4 != null && a4.length() > 0) {
                jSONObject.put("BTPaired", a4);
            }
            jSONObject.put("ConnectedSSID", w4Var.t());
            jSONObject.put("CBS", w4Var.f());
            if (w4Var.r() != 0) {
                jSONObject.put("CRS", w4Var.r());
            }
            jSONObject.put("WIFIMAC", w4Var.q());
            String str3 = w4Var.v() == 1 ? "WiFi" : "Cell";
            Locale locale = Locale.ENGLISH;
            jSONObject.put(String.format(locale, new String(new byte[]{37, 115, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 52}), str3), w4Var.m());
            jSONObject.put(String.format(locale, new String(new byte[]{37, 115, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 54}), str3), w4Var.o());
            JSONArray a5 = n2Var.a();
            if (a5 != null && a5.length() > 0) {
                jSONObject.put("SimList", a5);
            }
            List<String> i02 = j5Var.i0();
            if (i02 != null && i02.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str4 : i02) {
                    jSONArray3.put(str4);
                }
                jSONObject.put("DNS", jSONArray3);
            }
            JSONArray o02 = j5Var.o0();
            if (o02 != null && o02.length() > 0) {
                jSONObject.put("InstalledApps", o02);
            }
            JSONArray F0 = j5Var.F0();
            if (F0 != null && F0.length() > 0) {
                jSONObject.put("RP", F0);
            }
            JSONArray j4 = w4Var.j();
            if (j4 != null && j4.length() > 0) {
                jSONObject.put("WifiConfiguredNetworks", j4);
            }
            JSONArray r4 = j5Var.r();
            if (r4 != null && r4.length() > 0) {
                jSONObject.put("AL", r4);
            }
            List<y1> y02 = j5Var.y0();
            if (y02 != null && y02.size() > 0) {
                try {
                    JSONArray jSONArray4 = new JSONArray();
                    for (y1 y1Var : y02) {
                        jSONArray4.put(y1Var.b(false, true));
                    }
                    jSONObject.put("LocationHistory", jSONArray4);
                } catch (Throwable unused) {
                }
            }
            List<g1> a6 = w4Var.a();
            if (a6 != null && a6.size() > 0) {
                try {
                    JSONArray jSONArray5 = new JSONArray();
                    for (g1 g1Var : a6) {
                        jSONArray5.put(g1Var.z());
                    }
                    jSONObject.put("APL", jSONArray5);
                } catch (Throwable unused2) {
                }
            }
            List<i5> f4 = n2Var.f();
            if (f4 != null && f4.size() > 0) {
                try {
                    JSONArray jSONArray6 = new JSONArray();
                    for (i5 i5Var : f4) {
                        jSONArray6.put(i5Var.B());
                    }
                    jSONObject.put("CellSurvey", jSONArray6);
                } catch (Throwable unused3) {
                }
            }
            List<h5> s3 = w4Var.s();
            if (s3 != null && s3.size() > 0) {
                try {
                    JSONArray jSONArray7 = new JSONArray();
                    for (h5 h5Var : s3) {
                        jSONArray7.put(h5Var.p());
                    }
                    jSONObject.put("WifiSurvey", jSONArray7);
                } catch (Throwable unused4) {
                }
            }
        }
        return jSONObject;
    }

    private void g(JSONObject jSONObject) {
        h(jSONObject, this.f39002a.p());
        h(jSONObject, this.f39002a.r());
        h(jSONObject, this.f39002a.J());
        h(jSONObject, this.f39002a.W());
        h(jSONObject, this.f39002a.X());
    }

    private static void h(JSONObject jSONObject, String str) {
        try {
            if (!str.equals("0")) {
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject a(int i4, d6.a aVar) throws Exception {
        boolean z3;
        boolean z4;
        boolean z5;
        this.f39005d.d(aVar);
        this.f39005d.f(aVar.f38703c);
        long currentTimeMillis = aVar.f38703c - System.currentTimeMillis();
        this.f39002a.O(currentTimeMillis);
        u5 u5Var = this.f39005d;
        boolean z6 = true;
        if (i4 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        j5 a4 = u5Var.a(z3);
        a5 a5Var = this.f39006e;
        if (i4 == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        w4 a5 = a5Var.a(z4);
        j2 j2Var = this.f39008g;
        if (i4 == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        d2 a6 = j2Var.a(z5);
        x4 x4Var = this.f39007f;
        if (i4 != 2) {
            z6 = false;
        }
        n2 l4 = x4Var.l(z6);
        this.f39005d.b(currentTimeMillis);
        this.f39006e.b(currentTimeMillis);
        JSONObject c4 = c(a4, a5, a6, l4, i4);
        String c02 = this.f39002a.c0();
        h1 h1Var = this.f39003b;
        if (h1Var != null) {
            c4.put(h1.f38791m, b(h1Var, c02));
        }
        if (!this.f39004c.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (h1 h1Var2 : this.f39004c) {
                jSONArray.put(b(h1Var2, c02));
            }
            c4.put(h1.f38792n, jSONArray);
        }
        if (i4 == 2) {
            try {
                g(c4);
            } catch (Throwable unused) {
            }
        }
        return c4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(h1 h1Var) {
        this.f39003b = h1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(String str) {
        this.f39005d.e(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(List<h1> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.f39004c = list;
    }
}
