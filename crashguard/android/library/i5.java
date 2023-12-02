package crashguard.android.library;

import com.facebook.stetho.dumpapp.Framer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class i5 {

    /* renamed from: a  reason: collision with root package name */
    private String f38832a;

    /* renamed from: b  reason: collision with root package name */
    private long f38833b;

    /* renamed from: c  reason: collision with root package name */
    private float f38834c;

    /* renamed from: d  reason: collision with root package name */
    private float f38835d;

    /* renamed from: e  reason: collision with root package name */
    private float f38836e;

    /* renamed from: f  reason: collision with root package name */
    private float f38837f;

    /* renamed from: g  reason: collision with root package name */
    private double f38838g;

    /* renamed from: h  reason: collision with root package name */
    private double f38839h;

    /* renamed from: i  reason: collision with root package name */
    private final long f38840i;

    /* renamed from: j  reason: collision with root package name */
    private final long f38841j;

    /* renamed from: k  reason: collision with root package name */
    private final long f38842k;

    /* renamed from: l  reason: collision with root package name */
    private final String f38843l;

    /* renamed from: m  reason: collision with root package name */
    private final String f38844m;

    /* renamed from: n  reason: collision with root package name */
    private final String f38845n;

    /* renamed from: o  reason: collision with root package name */
    private final String f38846o;

    /* renamed from: p  reason: collision with root package name */
    private final String f38847p;

    /* renamed from: q  reason: collision with root package name */
    private final String f38848q;

    /* renamed from: r  reason: collision with root package name */
    private final String f38849r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(long j4, String str, String str2, long j5, long j6, String str3, String str4, String str5, String str6, String str7) {
        this(null, j4, str, str2, j5, j6, str3, str4, str5, str6, str7, 0L, 0.0f, 0.0f, 0.0f, 0.0f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float A() {
        return this.f38837f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject B() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("CID", this.f38841j);
        jSONObject.put("LAC", this.f38842k);
        jSONObject.put("MCC", this.f38843l);
        jSONObject.put("MNC", this.f38844m);
        jSONObject.put(new String(new byte[]{67, 101, 108, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 52}), this.f38845n);
        jSONObject.put(new String(new byte[]{67, 101, 108, 108, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 54}), this.f38846o);
        jSONObject.put(new String(new byte[]{67, 108, 105, 101, 110, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 52}), this.f38847p);
        jSONObject.put(new String(new byte[]{67, 108, 105, 101, 110, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 80, 118, 54}), this.f38848q);
        if (this.f38849r != null) {
            try {
                jSONObject.put("CarrierValues", new JSONArray(this.f38849r));
            } catch (Throwable unused) {
            }
        }
        jSONObject.put("Timestamp", y4.a(this.f38833b));
        jSONObject.put("Course", this.f38834c);
        jSONObject.put("Speed", this.f38835d);
        jSONObject.put("HorizontalAccuracy", this.f38836e);
        jSONObject.put("VerticalAccuracy", this.f38837f);
        jSONObject.put("Latitude", this.f38839h);
        jSONObject.put("Longitude", this.f38838g);
        jSONObject.put("Provider", this.f38832a);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f38849r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(double d4) {
        this.f38839h = d4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f4) {
        this.f38834c = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(long j4) {
        this.f38833b = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long f() {
        return this.f38841j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(double d4) {
        this.f38838g = d4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(float f4) {
        this.f38836e = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(String str) {
        this.f38832a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String j() {
        return this.f38847p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(float f4) {
        this.f38835d = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l() {
        return this.f38848q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(float f4) {
        this.f38837f = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float n() {
        return this.f38834c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long o() {
        return this.f38840i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float p() {
        return this.f38836e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String q() {
        return this.f38845n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String r() {
        return this.f38846o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long s() {
        return this.f38842k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double t() {
        return this.f38839h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double u() {
        return this.f38838g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String v() {
        return this.f38843l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w() {
        return this.f38844m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String x() {
        return this.f38832a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float y() {
        return this.f38835d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long z() {
        return this.f38833b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(String str, long j4, String str2, String str3, long j5, long j6, String str4, String str5, String str6, String str7, String str8, long j7, float f4, float f5, float f6, float f7, double d4, double d5, String str9) {
        e(str);
        this.f38840i = j4;
        this.f38843l = str2;
        this.f38844m = str3;
        this.f38841j = j5;
        this.f38842k = j6;
        this.f38845n = str4;
        this.f38847p = str5;
        this.f38846o = str6;
        this.f38848q = str7;
        this.f38849r = str8;
        this.f38833b = j7;
        this.f38834c = f4;
        this.f38835d = f5;
        this.f38836e = f6;
        this.f38837f = f7;
        this.f38839h = d4;
        this.f38838g = d5;
        this.f38832a = str9;
    }

    final void e(String str) {
    }
}
