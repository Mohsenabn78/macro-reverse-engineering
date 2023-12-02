package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class DefaultSettingsSpiCall implements SettingsSpiCall {

    /* renamed from: a  reason: collision with root package name */
    private final String f30006a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestFactory f30007b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f30008c;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.getLogger());
    }

    private HttpGetRequest b(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        c(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.f30024a);
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getVersion());
        c(httpGetRequest, HttpHeaders.ACCEPT, "application/json");
        c(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f30025b);
        c(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f30026c);
        c(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f30027d);
        c(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f30028e.getInstallIds().getCrashlyticsInstallId());
        return httpGetRequest;
    }

    private void c(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.header(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e4) {
            Logger logger = this.f30008c;
            logger.w("Failed to parse settings JSON from " + this.f30006a, e4);
            Logger logger2 = this.f30008c;
            logger2.w("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> f(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.f30031h);
        hashMap.put("display_version", settingsRequest.f30030g);
        hashMap.put("source", Integer.toString(settingsRequest.f30032i));
        String str = settingsRequest.f30029f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsSpiCall
    public JSONObject a(SettingsRequest settingsRequest, boolean z3) {
        if (z3) {
            try {
                Map<String, String> f4 = f(settingsRequest);
                HttpGetRequest b4 = b(d(f4), settingsRequest);
                Logger logger = this.f30008c;
                logger.d("Requesting settings from " + this.f30006a);
                Logger logger2 = this.f30008c;
                logger2.v("Settings query params were: " + f4);
                return g(b4.execute());
            } catch (IOException e4) {
                this.f30008c.e("Settings request failed.", e4);
                return null;
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }

    protected HttpGetRequest d(Map<String, String> map) {
        HttpGetRequest buildHttpGetRequest = this.f30007b.buildHttpGetRequest(this.f30006a, map);
        return buildHttpGetRequest.header("User-Agent", "Crashlytics Android SDK/" + CrashlyticsCore.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject g(HttpResponse httpResponse) {
        int code = httpResponse.code();
        Logger logger = this.f30008c;
        logger.v("Settings response code was: " + code);
        if (h(code)) {
            return e(httpResponse.body());
        }
        Logger logger2 = this.f30008c;
        logger2.e("Settings request failed; (status: " + code + ") from " + this.f30006a);
        return null;
    }

    boolean h(int i4) {
        if (i4 != 200 && i4 != 201 && i4 != 202 && i4 != 203) {
            return false;
        }
        return true;
    }

    DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (str != null) {
            this.f30008c = logger;
            this.f30007b = httpRequestFactory;
            this.f30006a = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
