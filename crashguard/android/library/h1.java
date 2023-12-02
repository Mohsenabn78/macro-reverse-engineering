package crashguard.android.library;

import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class h1 {

    /* renamed from: m  reason: collision with root package name */
    static final String f38791m = "CrashInfo";

    /* renamed from: n  reason: collision with root package name */
    static final String f38792n = "PendingCrashes";

    /* renamed from: a  reason: collision with root package name */
    private String f38793a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38794b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38795c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38796d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38797e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38798f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38799g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f38800h;

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f38801i;

    /* renamed from: j  reason: collision with root package name */
    private final long f38802j;

    /* renamed from: k  reason: collision with root package name */
    private final String f38803k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f38804l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(Throwable th, String str) {
        this(th, str, false, System.currentTimeMillis());
    }

    private boolean c(Throwable th) {
        String name;
        String str = "crashguard.android.library";
        if (th.getStackTrace().length > 0) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                try {
                    Class<?> cls = Class.forName(stackTraceElement.getClassName());
                    Package r7 = cls.getPackage();
                    if (r7 == null) {
                        name = cls.getName();
                        int lastIndexOf = name.lastIndexOf(".");
                        if (lastIndexOf > -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                    } else {
                        name = r7.getName();
                    }
                    if (name != null && (name.contains(str) || name.contains("crashguard"))) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        String str2 = this.f38797e;
        if (str2 == null) {
            return false;
        }
        if (str2.contains(str) || this.f38797e.contains("crashguard")) {
            return true;
        }
        return false;
    }

    private static String e(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> a() {
        return this.f38800h;
    }

    public final void b(String str) {
        this.f38793a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f38798f;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof h1) {
            return ((h1) obj).f38794b.equals(this.f38794b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f38803k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String g() {
        return this.f38794b;
    }

    public final String h() {
        return this.f38793a;
    }

    public final int hashCode() {
        return Objects.hash(this.f38794b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String i() {
        return this.f38796d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String j() {
        return this.f38795c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String k() {
        return this.f38797e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> l() {
        return this.f38801i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String m() {
        return this.f38799g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long n() {
        return this.f38802j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o() {
        return this.f38804l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject p() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.f38803k != null) {
            jSONObject.put("CrashLine", this.f38803k);
        }
        jSONObject.put("Date", y4.a(this.f38802j));
        jSONObject.put("ModuleInPath", this.f38804l);
        jSONObject.put("Message", this.f38795c);
        jSONObject.put("LocalizedMessage", this.f38796d);
        jSONObject.put("ParamThread", this.f38799g);
        jSONObject.put("Class", this.f38798f);
        jSONObject.put("StackTrace", this.f38797e);
        if (!this.f38800h.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.f38800h) {
                jSONArray.put(str);
            }
            jSONObject.put("Causes", jSONArray);
        }
        if (!this.f38801i.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : this.f38801i) {
                jSONArray2.put(str2);
            }
            jSONObject.put("Suppressed", jSONArray2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(Throwable th, String str, boolean z3, long j4) {
        this(th, str, z3, j4, 0);
    }

    h1(Throwable th, String str, boolean z3, long j4, int i4) {
        this.f38793a = null;
        this.f38802j = j4;
        this.f38799g = str;
        this.f38795c = th.getMessage();
        this.f38796d = th.getLocalizedMessage();
        this.f38797e = e(th);
        this.f38798f = th.getClass().getName();
        if (z3) {
            this.f38804l = false;
        } else {
            this.f38804l = c(th);
        }
        this.f38800h = new LinkedList();
        Throwable th2 = th;
        for (int i5 = 0; i5 < 5 && (th2 = th2.getCause()) != null; i5++) {
            this.f38800h.add(th2.getMessage());
        }
        this.f38801i = new LinkedList();
        Throwable[] suppressed = th.getSuppressed();
        int min = Math.min(suppressed.length, 5);
        for (int i6 = 0; i6 < min; i6++) {
            this.f38801i.add(suppressed[i6].getMessage());
        }
        if (th.getStackTrace().length > 0) {
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            this.f38803k = String.format(Locale.ENGLISH, "%s:%s:%s:%d", stackTraceElement.getFileName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        } else {
            this.f38803k = null;
        }
        this.f38794b = k2.g(this.f38797e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(String str, String str2, String str3, String str4, String str5, String str6, String str7, LinkedList linkedList, LinkedList linkedList2, String str8, boolean z3, long j4) {
        this.f38793a = str;
        this.f38794b = str2;
        this.f38795c = str3;
        this.f38796d = str4;
        this.f38797e = str5;
        this.f38798f = str6;
        this.f38799g = str7;
        this.f38800h = linkedList;
        this.f38801i = linkedList2;
        this.f38803k = str8;
        this.f38804l = z3;
        this.f38802j = j4;
    }
}
