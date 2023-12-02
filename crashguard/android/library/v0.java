package crashguard.android.library;

import com.facebook.stetho.dumpapp.Framer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class v0 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f39071b = "typ";

    /* renamed from: c  reason: collision with root package name */
    private static final String f39072c = "JWT";

    /* renamed from: d  reason: collision with root package name */
    private static final String f39073d = "kid";

    /* renamed from: e  reason: collision with root package name */
    private static final String f39074e = "alg";

    /* renamed from: f  reason: collision with root package name */
    private static final String f39075f = new String(new byte[]{72, 83, Framer.STDERR_FRAME_PREFIX, 53, 54});

    /* renamed from: g  reason: collision with root package name */
    private static final String f39076g = new String(new byte[]{115, 105, 103, Framer.STDIN_REQUEST_FRAME_PREFIX, 116, 115});

    /* renamed from: h  reason: collision with root package name */
    private static final String f39077h = new String(new byte[]{72, 109, 97, 99, 83, 72, 65, Framer.STDERR_FRAME_PREFIX, 53, 54});

    /* renamed from: a  reason: collision with root package name */
    private final k2 f39078a = new k2();

    private static JSONObject b(long j4) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(new String(new byte[]{115, 105, 103, Framer.STDIN_REQUEST_FRAME_PREFIX, 110, 111, 110, 99, 101}), "");
        jSONObject.put("iat", j4 / 1000);
        jSONObject.put(f39076g, y4.a(j4));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(y0 y0Var, long j4, String str, String str2) {
        String str3;
        String l4 = y0Var.l();
        if (l4 != null) {
            try {
                String[] split = l4.split("\\\\.");
                if (split.length == 3) {
                    String str4 = split[2];
                    String format = String.format("%s.%s", split[0], split[1]);
                    String str5 = f39077h;
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), str5);
                    Mac mac = Mac.getInstance(str5);
                    mac.init(secretKeySpec);
                    byte[] doFinal = mac.doFinal(format.getBytes());
                    this.f39078a.getClass();
                    if (k2.i(doFinal).equals(str4)) {
                        byte[] bytes = split[1].getBytes();
                        this.f39078a.getClass();
                        String string = new JSONObject(k2.b(bytes)).getString(f39076g);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        Date parse = simpleDateFormat.parse(string);
                        if (parse != null) {
                            if (Math.abs(parse.getTime() - j4) < 82800000) {
                                return l4;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f39071b, f39072c);
            jSONObject.put(f39073d, str);
            jSONObject.put(f39074e, f39075f);
            byte[] bytes2 = jSONObject.toString().getBytes();
            this.f39078a.getClass();
            String i4 = k2.i(bytes2);
            byte[] bytes3 = b(j4).toString().getBytes();
            this.f39078a.getClass();
            String format2 = String.format("%s.%s", i4, k2.i(bytes3));
            String str6 = f39077h;
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(str2.getBytes(), str6);
            Mac mac2 = Mac.getInstance(str6);
            mac2.init(secretKeySpec2);
            byte[] doFinal2 = mac2.doFinal(format2.getBytes());
            this.f39078a.getClass();
            str3 = String.format("%s.%s", format2, k2.i(doFinal2));
        } catch (Throwable unused2) {
            str3 = null;
        }
        y0Var.t(str3);
        return str3;
    }
}
