package com.google.android.gms.nearby.exposurenotification;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.CommonStatusCodes;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class ExposureNotificationStatusCodes extends CommonStatusCodes {
    public static final int FAILED = 13;
    public static final int FAILED_ALREADY_STARTED = 39500;
    public static final int FAILED_BLUETOOTH_DISABLED = 39504;
    public static final int FAILED_DISK_IO = 39506;
    public static final int FAILED_KEY_RELEASE_NOT_PREAUTHORIZED = 39510;
    public static final int FAILED_NOT_IN_FOREGROUND = 39509;
    public static final int FAILED_NOT_SUPPORTED = 39501;
    public static final int FAILED_RATE_LIMITED = 39508;
    public static final int FAILED_REJECTED_OPT_IN = 39502;
    public static final int FAILED_SERVICE_DISABLED = 39503;
    public static final int FAILED_TEMPORARILY_DISABLED = 39505;
    public static final int FAILED_UNAUTHORIZED = 39507;

    private ExposureNotificationStatusCodes() {
    }

    @NonNull
    public static String getStatusCodeString(int i4) {
        switch (i4) {
            case FAILED_ALREADY_STARTED /* 39500 */:
                return "FAILED_ALREADY_STARTED";
            case FAILED_NOT_SUPPORTED /* 39501 */:
                return "FAILED_NOT_SUPPORTED";
            case FAILED_REJECTED_OPT_IN /* 39502 */:
                return "FAILED_REJECTED_OPT_IN";
            case FAILED_SERVICE_DISABLED /* 39503 */:
                return "FAILED_SERVICE_DISABLED";
            case FAILED_BLUETOOTH_DISABLED /* 39504 */:
                return "FAILED_BLUETOOTH_DISABLED";
            case FAILED_TEMPORARILY_DISABLED /* 39505 */:
                return "FAILED_TEMPORARILY_DISABLED";
            case FAILED_DISK_IO /* 39506 */:
                return "FAILED_DISK_IO";
            case FAILED_UNAUTHORIZED /* 39507 */:
                return "FAILED_UNAUTHORIZED";
            case FAILED_RATE_LIMITED /* 39508 */:
                return "FAILED_RATE_LIMITED";
            case FAILED_NOT_IN_FOREGROUND /* 39509 */:
                return "FAILED_NOT_IN_FOREGROUND";
            case FAILED_KEY_RELEASE_NOT_PREAUTHORIZED /* 39510 */:
                return "FAILED_KEY_RELEASE_NOT_PREAUTHORIZED";
            default:
                return CommonStatusCodes.getStatusCodeString(i4);
        }
    }
}
