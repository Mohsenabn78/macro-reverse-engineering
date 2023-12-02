package com.google.firebase.remoteconfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class RemoteConfigConstants {
    public static final String FETCH_REGEX_URL = "https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch";
    public static final String REALTIME_REGEX_URL = "https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/%s/namespaces/%s:streamFetchInvalidations";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ExperimentDescriptionFieldKey {
        public static final String EXPERIMENT_ID = "experimentId";
        public static final String VARIANT_ID = "variantId";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface RequestFieldKey {
        public static final String ANALYTICS_USER_PROPERTIES = "analyticsUserProperties";
        public static final String APP_BUILD = "appBuild";
        public static final String APP_ID = "appId";
        public static final String APP_VERSION = "appVersion";
        public static final String COUNTRY_CODE = "countryCode";
        public static final String FIRST_OPEN_TIME = "firstOpenTime";
        public static final String INSTANCE_ID = "appInstanceId";
        public static final String INSTANCE_ID_TOKEN = "appInstanceIdToken";
        public static final String LANGUAGE_CODE = "languageCode";
        public static final String PACKAGE_NAME = "packageName";
        public static final String PLATFORM_VERSION = "platformVersion";
        public static final String SDK_VERSION = "sdkVersion";
        public static final String TIME_ZONE = "timeZone";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ResponseFieldKey {
        public static final String ENTRIES = "entries";
        public static final String EXPERIMENT_DESCRIPTIONS = "experimentDescriptions";
        public static final String PERSONALIZATION_METADATA = "personalizationMetadata";
        public static final String STATE = "state";
        public static final String TEMPLATE_VERSION_NUMBER = "templateVersion";
    }

    private RemoteConfigConstants() {
    }
}
