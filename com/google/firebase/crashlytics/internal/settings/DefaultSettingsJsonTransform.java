package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Settings b(CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.getCurrentTimeMillis() + 3600000, new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return b(currentTimeProvider);
    }
}
