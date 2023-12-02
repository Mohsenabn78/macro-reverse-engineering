package crashguard.android.library;

import android.location.Location;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class y1 {

    /* renamed from: a  reason: collision with root package name */
    private String f39143a;

    /* renamed from: b  reason: collision with root package name */
    private long f39144b;

    /* renamed from: c  reason: collision with root package name */
    private final float f39145c;

    /* renamed from: d  reason: collision with root package name */
    private final float f39146d;

    /* renamed from: e  reason: collision with root package name */
    private final float f39147e;

    /* renamed from: f  reason: collision with root package name */
    private final float f39148f;

    /* renamed from: g  reason: collision with root package name */
    private final double f39149g;

    /* renamed from: h  reason: collision with root package name */
    private final double f39150h;

    /* renamed from: i  reason: collision with root package name */
    private final String f39151i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(JSONObject jSONObject) throws Exception {
        try {
            this.f39143a = jSONObject.getString("Id");
        } catch (Throwable unused) {
        }
        this.f39144b = jSONObject.getLong("Timestamp");
        this.f39150h = jSONObject.getDouble("Latitude");
        this.f39149g = jSONObject.getDouble("Longitude");
        this.f39145c = Double.valueOf(jSONObject.getDouble("Course")).floatValue();
        this.f39146d = Double.valueOf(jSONObject.getDouble("Speed")).floatValue();
        this.f39147e = Double.valueOf(jSONObject.getDouble("HorizontalAccuracy")).floatValue();
        this.f39148f = Double.valueOf(jSONObject.getDouble("VerticalAccuracy")).floatValue();
        this.f39151i = jSONObject.getString("Provider");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float a() {
        return this.f39145c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject b(boolean z3, boolean z4) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (z3) {
            jSONObject.put("Id", this.f39143a);
        }
        if (z4) {
            jSONObject.put("Timestamp", y4.a(this.f39144b));
        } else {
            jSONObject.put("Timestamp", this.f39144b);
        }
        jSONObject.put("Latitude", this.f39150h);
        jSONObject.put("Longitude", this.f39149g);
        jSONObject.put("Course", this.f39145c);
        jSONObject.put("Speed", this.f39146d);
        jSONObject.put("HorizontalAccuracy", this.f39147e);
        jSONObject.put("VerticalAccuracy", this.f39148f);
        jSONObject.put("Provider", this.f39151i);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(long j4) {
        this.f39144b = j4;
    }

    final void d(String str) {
        this.f39143a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float e() {
        return this.f39147e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double f() {
        return this.f39150h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double g() {
        return this.f39149g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String h() {
        return this.f39151i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float i() {
        return this.f39146d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long j() {
        return this.f39144b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float k() {
        return this.f39148f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(Location location, long j4, float f4) {
        this(location.getTime(), j4, location.getLatitude(), location.getLongitude(), location.getBearing(), location.getSpeed(), location.getAccuracy(), f4, location.getProvider());
    }

    y1(long j4, long j5, double d4, double d5, float f4, float f5, float f6, float f7, String str) {
        this((String) null, j4, d4, d5, f4, f5, f6, f7, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(String str, long j4, double d4, double d5, float f4, float f5, float f6, float f7, String str2) {
        d(str);
        this.f39144b = j4;
        this.f39150h = d4;
        this.f39149g = d5;
        this.f39145c = f4;
        this.f39146d = f5;
        this.f39147e = f6;
        this.f39148f = f7;
        this.f39151i = str2;
    }
}
