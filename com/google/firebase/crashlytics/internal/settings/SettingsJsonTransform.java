package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
interface SettingsJsonTransform {
    Settings a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}
