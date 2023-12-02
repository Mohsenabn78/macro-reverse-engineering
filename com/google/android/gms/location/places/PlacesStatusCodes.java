package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

@Deprecated
/* loaded from: classes4.dex */
public class PlacesStatusCodes extends CommonStatusCodes {
    public static final int ACCESS_NOT_CONFIGURED = 9003;
    public static final int DEVICE_RATE_LIMIT_EXCEEDED = 9006;
    public static final int INVALID_APP = 9008;
    public static final int INVALID_ARGUMENT = 9004;
    public static final int KEY_EXPIRED = 9007;
    public static final int KEY_INVALID = 9002;
    public static final int RATE_LIMIT_EXCEEDED = 9005;
    public static final int USAGE_LIMIT_EXCEEDED = 9001;

    private PlacesStatusCodes() {
    }

    public static String getStatusCodeString(int i4) {
        if (i4 != 9051) {
            if (i4 != 9150) {
                if (i4 != 9101) {
                    if (i4 != 9102) {
                        if (i4 != 9201) {
                            if (i4 != 9202) {
                                switch (i4) {
                                    case 9000:
                                        return "PLACES_API_QUOTA_FAILED";
                                    case USAGE_LIMIT_EXCEEDED /* 9001 */:
                                        return "PLACES_API_USAGE_LIMIT_EXCEEDED";
                                    case KEY_INVALID /* 9002 */:
                                        return "PLACES_API_KEY_INVALID";
                                    case ACCESS_NOT_CONFIGURED /* 9003 */:
                                        return "PLACES_API_ACCESS_NOT_CONFIGURED";
                                    case INVALID_ARGUMENT /* 9004 */:
                                        return "PLACES_API_INVALID_ARGUMENT";
                                    case RATE_LIMIT_EXCEEDED /* 9005 */:
                                        return "PLACES_API_RATE_LIMIT_EXCEEDED";
                                    case DEVICE_RATE_LIMIT_EXCEEDED /* 9006 */:
                                        return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
                                    case KEY_EXPIRED /* 9007 */:
                                        return "PLACES_API_KEY_EXPIRED";
                                    case INVALID_APP /* 9008 */:
                                        return "PLACES_API_INVALID_APP";
                                    case 9009:
                                        return "INSUFFICIENT_LOCATION_PERMISSION_FOR_BACKGROUND_PLACES";
                                    default:
                                        return CommonStatusCodes.getStatusCodeString(i4);
                                }
                            }
                            return "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED";
                        }
                        return "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED";
                    }
                    return "NEARBY_ALERTS_NOT_AVAILABLE";
                }
                return "PLACE_PROXIMITY_UNKNOWN";
            }
            return "PLACEFENCING_NOT_AVAILABLE";
        }
        return "PLACE_ALIAS_NOT_FOUND";
    }

    public static Status zzb(int i4) {
        String statusCodeString = getStatusCodeString(i4);
        Preconditions.checkNotNull(statusCodeString);
        return new Status(i4, statusCodeString);
    }
}
