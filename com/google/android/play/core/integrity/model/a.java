package com.google.android.play.core.integrity.model;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f25296a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map f25297b;

    static {
        HashMap hashMap = new HashMap();
        f25296a = hashMap;
        HashMap hashMap2 = new HashMap();
        f25297b = hashMap2;
        hashMap.put(-1, "Integrity API is not available.\nIntegrity API is not enabled, or the Play Store version might be old.\nRecommended actions:\n1) Make sure that Integrity API is enabled in Google Play Console.\n2) Ask the user to update Play Store.\n");
        hashMap.put(-2, "The Play Store app is either not installed or not the official version.\nAsk the user to install an official and recent version of Play Store.\n");
        hashMap.put(-3, "Network error: unable to obtain integrity details.\nAsk the user to check for a connection.\n");
        hashMap.put(-4, "No active account found in the Play Store app. Note that the Play Integrity API now supports unauthenticated requests. This error code is used only for older Play Store versions that lack support.\nAsk the user to authenticate in Play Store.\n");
        hashMap.put(-5, "PackageManager could not find this app.\nSomething is wrong (possibly an attack). Non-actionable.\n");
        hashMap.put(-6, "Google Play Services is not available or version is too old.\nAsk the user to Install or Update Play Services.\n");
        hashMap.put(-7, "The calling app UID (user id) does not match the one from Package Manager.\nSomething is wrong (possibly an attack). Non-actionable.\n");
        hashMap.put(-8, "The calling app is making too many requests to the API and hence is throttled.\nRetry with an exponential backoff.\n");
        hashMap.put(-9, "Binding to the service in the Play Store has failed. This can be due to having an old Play Store version installed on the device.\nAsk the user to update Play Store.\n");
        hashMap.put(-10, "Nonce length is too short. The nonce must be a minimum of 16 bytes (before base64 encoding) to allow for a better security.\nRetry with a longer nonce.\n");
        hashMap.put(-11, "Nonce length is too long. The nonce must be less than 500 bytes before base64 encoding.\nRetry with a shorter nonce.\n");
        hashMap.put(-12, "Unknown internal Google server error.\nRetry with an exponential backoff. Consider filing a bug if fails consistently.\n");
        hashMap.put(-13, "Nonce is not encoded as a base64 web-safe no-wrap string.\nRetry with correct nonce format.\n");
        hashMap.put(-14, "The Play Store needs to be updated.\nAsk the user to update the Google Play Store.\n");
        hashMap.put(-15, "Play Services needs to be updated.\nAsk the user to update Google Play Services.\n");
        hashMap.put(-16, "The provided cloud project number is invalid.\nUse the cloud project number which can be found in Project info in your Google Cloud Console for the cloud project where Play Integrity API is enabled.\n");
        hashMap.put(-100, "Unknown error processing integrity request.\nRetry with an exponential backoff. Consider filing a bug if fails consistently.\n");
        hashMap.put(-17, "There is a transient error on the calling device.\nRetry with an exponential backoff.\n");
        hashMap2.put(-1, "API_NOT_AVAILABLE");
        hashMap2.put(-3, "NETWORK_ERROR");
        hashMap2.put(-2, "PLAY_STORE_NOT_FOUND");
        hashMap2.put(-4, "PLAY_STORE_ACCOUNT_NOT_FOUND");
        hashMap2.put(-14, "PLAY_STORE_VERSION_OUTDATED");
        hashMap2.put(-5, "APP_NOT_INSTALLED");
        hashMap2.put(-6, "PLAY_SERVICES_NOT_FOUND");
        hashMap2.put(-15, "PLAY_SERVICES_VERSION_OUTDATED");
        hashMap2.put(-7, "APP_UID_MISMATCH");
        hashMap2.put(-8, "TOO_MANY_REQUESTS");
        hashMap2.put(-9, "CANNOT_BIND_TO_SERVICE");
        hashMap2.put(-10, "NONCE_TOO_SHORT");
        hashMap2.put(-11, "NONCE_TOO_LONG");
        hashMap2.put(-13, "NONCE_IS_NOT_BASE64");
        hashMap2.put(-16, "CLOUD_PROJECT_NUMBER_IS_INVALID");
        hashMap2.put(-12, "GOOGLE_SERVER_UNAVAILABLE");
        hashMap2.put(-100, "INTERNAL_ERROR");
        hashMap2.put(-17, "CLIENT_TRANSIENT_ERROR");
    }

    public static String a(int i4) {
        Map map = f25296a;
        Integer valueOf = Integer.valueOf(i4);
        if (map.containsKey(valueOf)) {
            Map map2 = f25297b;
            if (map2.containsKey(valueOf)) {
                return ((String) map.get(valueOf)) + " (https://developer.android.com/google/play/integrity/reference/com/google/android/play/core/integrity/model/IntegrityErrorCode.html#" + ((String) map2.get(valueOf)) + ")";
            }
            return "";
        }
        return "";
    }
}
