package crashguard.android.library;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class h5 {

    /* renamed from: a  reason: collision with root package name */
    private final String f38809a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38810b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38811c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38812d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38813e;

    /* renamed from: f  reason: collision with root package name */
    private final int f38814f;

    /* renamed from: g  reason: collision with root package name */
    private long f38815g;

    /* renamed from: h  reason: collision with root package name */
    private final double f38816h;

    /* renamed from: i  reason: collision with root package name */
    private final double f38817i;

    /* renamed from: j  reason: collision with root package name */
    private final float f38818j;

    /* renamed from: k  reason: collision with root package name */
    private final float f38819k;

    /* renamed from: l  reason: collision with root package name */
    private final float f38820l;

    /* renamed from: m  reason: collision with root package name */
    private final float f38821m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(String str, long j4, String str2, String str3, String str4, int i4, int i5, float f4, float f5, double d4, double d5, float f6, float f7, String str5) {
        c(str);
        this.f38815g = j4;
        this.f38809a = str2;
        this.f38810b = str3;
        this.f38811c = str4;
        this.f38813e = i4;
        this.f38814f = i5;
        this.f38821m = f4;
        this.f38820l = f5;
        this.f38816h = d4;
        this.f38817i = d5;
        this.f38818j = f6;
        this.f38819k = f7;
        this.f38812d = str5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f38810b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j4) {
        this.f38815g = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f38811c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float e() {
        return this.f38821m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int f() {
        return this.f38814f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float g() {
        return this.f38818j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double h() {
        return this.f38816h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i() {
        return this.f38813e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double j() {
        return this.f38817i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String k() {
        return this.f38812d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float l() {
        return this.f38820l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String m() {
        return this.f38809a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long n() {
        return this.f38815g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float o() {
        return this.f38819k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject p() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.f38809a);
        jSONObject.put("BSSID", this.f38810b);
        jSONObject.put("Capabilities", this.f38811c);
        jSONObject.put("Level", this.f38813e);
        jSONObject.put("Frequency", this.f38814f);
        jSONObject.put("Course", this.f38821m);
        jSONObject.put("Speed", this.f38820l);
        jSONObject.put("Latitude", this.f38816h);
        jSONObject.put("Longitude", this.f38817i);
        jSONObject.put("HorizontalAccuracy", this.f38818j);
        jSONObject.put("VerticalAccuracy", this.f38819k);
        jSONObject.put("Timestamp", y4.a(this.f38815g));
        jSONObject.put("Provider", this.f38812d);
        return jSONObject;
    }

    final void c(String str) {
    }
}
