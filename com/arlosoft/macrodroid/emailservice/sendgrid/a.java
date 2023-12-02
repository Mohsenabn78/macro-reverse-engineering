package com.arlosoft.macrodroid.emailservice.sendgrid;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ErrorParser.java */
/* loaded from: classes3.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            return new JSONObject(str).getJSONArray("errors").getJSONObject(0).get("message").toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return String.format("Error parsing error message: %s", e4.getMessage());
        }
    }
}
