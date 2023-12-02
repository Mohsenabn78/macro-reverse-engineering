package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class Personalization {
    public static final String ANALYTICS_ORIGIN_PERSONALIZATION = "fp";
    public static final String ARM_INDEX = "armIndex";
    public static final String CHOICE_ID = "choiceId";
    public static final String EXTERNAL_ARM_INDEX_PARAM = "arm_index";
    public static final String EXTERNAL_ARM_VALUE_PARAM = "arm_value";
    public static final String EXTERNAL_EVENT = "personalization_assignment";
    public static final String EXTERNAL_GROUP_PARAM = "group";
    public static final String EXTERNAL_PERSONALIZATION_ID_PARAM = "personalization_id";
    public static final String EXTERNAL_RC_PARAMETER_PARAM = "arm_key";
    public static final String GROUP = "group";
    public static final String INTERNAL_CHOICE_ID_PARAM = "_fpid";
    public static final String INTERNAL_EVENT = "_fpc";
    public static final String PERSONALIZATION_ID = "personalizationId";

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsConnector> f32023a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f32024b = Collections.synchronizedMap(new HashMap());

    public Personalization(Provider<AnalyticsConnector> provider) {
        this.f32023a = provider;
    }

    public void logArmActive(@NonNull String str, @NonNull ConfigContainer configContainer) {
        JSONObject optJSONObject;
        AnalyticsConnector analyticsConnector = this.f32023a.get();
        if (analyticsConnector == null) {
            return;
        }
        JSONObject personalizationMetadata = configContainer.getPersonalizationMetadata();
        if (personalizationMetadata.length() < 1) {
            return;
        }
        JSONObject configs = configContainer.getConfigs();
        if (configs.length() < 1 || (optJSONObject = personalizationMetadata.optJSONObject(str)) == null) {
            return;
        }
        String optString = optJSONObject.optString(CHOICE_ID);
        if (optString.isEmpty()) {
            return;
        }
        synchronized (this.f32024b) {
            if (optString.equals(this.f32024b.get(str))) {
                return;
            }
            this.f32024b.put(str, optString);
            Bundle bundle = new Bundle();
            bundle.putString(EXTERNAL_RC_PARAMETER_PARAM, str);
            bundle.putString(EXTERNAL_ARM_VALUE_PARAM, configs.optString(str));
            bundle.putString(EXTERNAL_PERSONALIZATION_ID_PARAM, optJSONObject.optString(PERSONALIZATION_ID));
            bundle.putInt(EXTERNAL_ARM_INDEX_PARAM, optJSONObject.optInt(ARM_INDEX, -1));
            bundle.putString("group", optJSONObject.optString("group"));
            analyticsConnector.logEvent(ANALYTICS_ORIGIN_PERSONALIZATION, EXTERNAL_EVENT, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(INTERNAL_CHOICE_ID_PARAM, optString);
            analyticsConnector.logEvent(ANALYTICS_ORIGIN_PERSONALIZATION, INTERNAL_EVENT, bundle2);
        }
    }
}
