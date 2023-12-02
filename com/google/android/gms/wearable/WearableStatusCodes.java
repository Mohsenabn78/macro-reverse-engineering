package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.CommonStatusCodes;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class WearableStatusCodes extends CommonStatusCodes {
    public static final int ACCOUNT_KEY_CREATION_FAILED = 4010;
    public static final int ASSET_UNAVAILABLE = 4005;
    public static final int DATA_ITEM_TOO_LARGE = 4003;
    public static final int DUPLICATE_CAPABILITY = 4006;
    public static final int DUPLICATE_LISTENER = 4001;
    public static final int INVALID_TARGET_NODE = 4004;
    public static final int MODEL_ID_UNAVAILABLE = 4011;
    public static final int TARGET_NODE_NOT_CONNECTED = 4000;
    public static final int UNKNOWN_CAPABILITY = 4007;
    public static final int UNKNOWN_LISTENER = 4002;
    public static final int UNSUPPORTED_BY_TARGET_NODE = 4009;
    public static final int WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED = 4008;

    private WearableStatusCodes() {
    }

    @NonNull
    public static String getStatusCodeString(int i4) {
        switch (i4) {
            case TARGET_NODE_NOT_CONNECTED /* 4000 */:
                return "TARGET_NODE_NOT_CONNECTED";
            case DUPLICATE_LISTENER /* 4001 */:
                return "DUPLICATE_LISTENER";
            case UNKNOWN_LISTENER /* 4002 */:
                return "UNKNOWN_LISTENER";
            case DATA_ITEM_TOO_LARGE /* 4003 */:
                return "DATA_ITEM_TOO_LARGE";
            case INVALID_TARGET_NODE /* 4004 */:
                return "INVALID_TARGET_NODE";
            case ASSET_UNAVAILABLE /* 4005 */:
                return "ASSET_UNAVAILABLE";
            case DUPLICATE_CAPABILITY /* 4006 */:
                return "DUPLICATE_CAPABILITY";
            case UNKNOWN_CAPABILITY /* 4007 */:
                return "UNKNOWN_CAPABILITY";
            case WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED /* 4008 */:
                return "WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED";
            case UNSUPPORTED_BY_TARGET_NODE /* 4009 */:
                return "UNSUPPORTED_BY_TARGET";
            case ACCOUNT_KEY_CREATION_FAILED /* 4010 */:
                return "ACCOUNT_KEY_CREATION_FAILED";
            default:
                return CommonStatusCodes.getStatusCodeString(i4);
        }
    }
}
