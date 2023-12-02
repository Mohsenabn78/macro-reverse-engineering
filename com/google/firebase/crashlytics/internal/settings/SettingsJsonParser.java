package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SettingsJsonParser {

    /* renamed from: a  reason: collision with root package name */
    private final CurrentTimeProvider f30023a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.f30023a = currentTimeProvider;
    }

    private static SettingsJsonTransform a(int i4) {
        if (i4 != 3) {
            Logger logger = Logger.getLogger();
            logger.e("Could not determine SettingsJsonTransform for settings version " + i4 + ". Using default settings values.");
            return new DefaultSettingsJsonTransform();
        }
        return new SettingsV3JsonTransform();
    }

    public Settings parseSettingsJson(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.f30023a, jSONObject);
    }
}
