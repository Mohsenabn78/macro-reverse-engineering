package crashguard.android.library;

import com.facebook.stetho.dumpapp.Framer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class g1 {

    /* renamed from: a  reason: collision with root package name */
    private String f38749a;

    /* renamed from: b  reason: collision with root package name */
    private long f38750b;

    /* renamed from: c  reason: collision with root package name */
    private float f38751c;

    /* renamed from: d  reason: collision with root package name */
    private float f38752d;

    /* renamed from: e  reason: collision with root package name */
    private float f38753e;

    /* renamed from: f  reason: collision with root package name */
    private float f38754f;

    /* renamed from: g  reason: collision with root package name */
    private double f38755g;

    /* renamed from: h  reason: collision with root package name */
    private double f38756h;

    /* renamed from: i  reason: collision with root package name */
    private final long f38757i;

    /* renamed from: j  reason: collision with root package name */
    private final String f38758j;

    /* renamed from: k  reason: collision with root package name */
    private final String f38759k;

    /* renamed from: l  reason: collision with root package name */
    private final String f38760l;

    /* renamed from: m  reason: collision with root package name */
    private final String f38761m;

    /* renamed from: n  reason: collision with root package name */
    private final String f38762n;

    /* renamed from: o  reason: collision with root package name */
    private final String f38763o;

    /* renamed from: p  reason: collision with root package name */
    private final String f38764p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(long j4, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(null, j4, str, str2, str3, str4, str5, str6, str7, 0L, 0.0f, 0.0f, 0.0f, 0.0f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f38759k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(double d4) {
        this.f38756h = d4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f4) {
        this.f38751c = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(long j4) {
        this.f38750b = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f38763o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(double d4) {
        this.f38755g = d4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(float f4) {
        this.f38753e = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(String str) {
        this.f38749a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String j() {
        return this.f38764p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(float f4) {
        this.f38752d = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float l() {
        return this.f38751c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(float f4) {
        this.f38754f = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long n() {
        return this.f38757i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float o() {
        return this.f38753e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String p() {
        return this.f38761m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String q() {
        return this.f38762n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double r() {
        return this.f38756h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double s() {
        return this.f38755g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String t() {
        return this.f38749a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String u() {
        return this.f38760l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float v() {
        return this.f38752d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w() {
        return this.f38758j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long x() {
        return this.f38750b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float y() {
        return this.f38754f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject z() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.f38758j);
        jSONObject.put("BSSID", this.f38759k);
        jSONObject.put("RSSI", this.f38760l);
        jSONObject.put(new String(new byte[]{87, 105, 70, 105, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 52}), this.f38761m);
        jSONObject.put(new String(new byte[]{87, 105, 70, 105, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 54}), this.f38762n);
        jSONObject.put(new String(new byte[]{67, 108, 105, 101, 110, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 52}), this.f38763o);
        jSONObject.put(new String(new byte[]{67, 108, 105, 101, 110, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 54}), this.f38764p);
        jSONObject.put("Timestamp", y4.a(this.f38750b));
        jSONObject.put("Course", this.f38751c);
        jSONObject.put("Speed", this.f38752d);
        jSONObject.put("HorizontalAccuracy", this.f38753e);
        jSONObject.put("VerticalAccuracy", this.f38754f);
        jSONObject.put("Latitude", this.f38756h);
        jSONObject.put("Longitude", this.f38755g);
        jSONObject.put("Provider", this.f38749a);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(String str, long j4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j5, float f4, float f5, float f6, float f7, double d4, double d5, String str9) {
        e(str);
        this.f38757i = j4;
        this.f38758j = str2;
        this.f38759k = str3;
        this.f38760l = str4;
        this.f38761m = str5;
        this.f38763o = str6;
        this.f38762n = str7;
        this.f38764p = str8;
        this.f38750b = j5;
        this.f38751c = f4;
        this.f38752d = f5;
        this.f38753e = f6;
        this.f38754f = f7;
        this.f38756h = d4;
        this.f38755g = d5;
        this.f38749a = str9;
    }

    final void e(String str) {
    }
}
