package com.arlosoft.macrodroid.emailservice.sendgrid;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridMail;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendGridMailBody.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f11981a;

    private e(JSONObject jSONObject) {
        this.f11981a = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(SendGridMail sendGridMail) {
        return new e(b(sendGridMail));
    }

    private static JSONObject b(SendGridMail sendGridMail) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m(sendGridMail));
            if (!sendGridMail.f().isEmpty()) {
                jSONArray.put(f(sendGridMail));
            }
            if (!sendGridMail.e().isEmpty()) {
                jSONArray.put(d(sendGridMail));
            }
            jSONObject.put("personalizations", jSONArray);
            jSONObject.put("from", h(sendGridMail));
            jSONObject.put("subject", k(sendGridMail));
            jSONObject.put(FirebaseAnalytics.Param.CONTENT, g(sendGridMail));
            if (sendGridMail.k() != null) {
                jSONObject.put("template_id", l(sendGridMail));
            }
            if (!sendGridMail.h().isEmpty()) {
                jSONObject.put("reply_to", i(sendGridMail));
            }
            if (sendGridMail.i() != 0) {
                jSONObject.put("send_at", j(sendGridMail));
            }
            if (sendGridMail.a().size() > 0) {
                jSONObject.put("attachments", c(sendGridMail));
            }
            if (sendGridMail.l().size() > 0) {
                jSONObject.put("tracking_settings", n(sendGridMail));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    static JSONArray c(SendGridMail sendGridMail) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (SendGridMail.d dVar : sendGridMail.c()) {
            if (!dVar.b().isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(FirebaseAnalytics.Param.CONTENT, dVar.b());
                jSONObject.put("filename", dVar.c());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    static JSONObject d(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bcc", o(sendGridMail.e()));
        return jSONObject;
    }

    static JSONObject f(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cc", o(sendGridMail.f()));
        return jSONObject;
    }

    static JSONArray g(SendGridMail sendGridMail) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Map<String, String> b4 = sendGridMail.b();
        if (b4.containsKey("text/plain")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "text/plain");
            jSONObject.put("value", b4.get("text/plain"));
            jSONArray.put(jSONObject);
            b4.remove("text/plain");
        }
        if (b4.containsKey("text/html")) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "text/html");
            jSONObject2.put("value", b4.get("text/html"));
            jSONArray.put(jSONObject2);
            b4.remove("text/html");
        }
        for (Map.Entry<String, String> entry : b4.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", entry.getKey());
            jSONObject3.put("value", entry.getValue());
            jSONArray.put(jSONObject3);
        }
        return jSONArray;
    }

    static JSONObject h(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : sendGridMail.d().entrySet()) {
            jSONObject.put("email", entry.getKey());
            jSONObject.put("name", entry.getValue());
        }
        return jSONObject;
    }

    static JSONObject i(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : sendGridMail.h().entrySet()) {
            jSONObject.put("email", entry.getKey());
            jSONObject.put("name", entry.getValue());
        }
        return jSONObject;
    }

    static int j(SendGridMail sendGridMail) {
        return sendGridMail.i();
    }

    static String k(SendGridMail sendGridMail) {
        return sendGridMail.j();
    }

    static String l(SendGridMail sendGridMail) {
        return sendGridMail.k();
    }

    static JSONObject m(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TypedValues.TransitionType.S_TO, o(sendGridMail.g()));
        return jSONObject;
    }

    static JSONObject n(SendGridMail sendGridMail) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Map<String, Boolean>> entry : sendGridMail.l().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        System.out.println(jSONObject);
        return jSONObject;
    }

    private static JSONArray o(Map<String, String> map) throws JSONException {
        String value;
        JSONArray jSONArray = new JSONArray();
        int i4 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("email", entry.getKey());
            if (entry.getValue().equals("")) {
                value = null;
            } else {
                value = entry.getValue();
            }
            jSONObject.put("name", value);
            jSONArray.put(jSONObject);
            i4++;
            if (i4 >= 1000) {
                break;
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject e() {
        return this.f11981a;
    }
}
