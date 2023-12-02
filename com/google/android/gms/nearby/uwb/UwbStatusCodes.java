package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.firebase.iid.GmsRpc;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class UwbStatusCodes extends CommonStatusCodes {
    public static final int INVALID_API_CALL = 42002;
    public static final int NULL_RANGING_DEVICE = 42001;
    public static final int RANGING_ALREADY_STARTED = 42003;
    public static final int SERVICE_NOT_AVAILABLE = 42000;
    public static final int STATUS_ERROR = 13;
    public static final int STATUS_OK = 0;
    public static final int UWB_SYSTEM_CALLBACK_FAILURE = 42005;

    private UwbStatusCodes() {
    }

    @NonNull
    public static String zza(int i4) {
        switch (i4) {
            case SERVICE_NOT_AVAILABLE /* 42000 */:
                return GmsRpc.ERROR_SERVICE_NOT_AVAILABLE;
            case NULL_RANGING_DEVICE /* 42001 */:
                return "NULL_RANGING_DEVICE";
            case INVALID_API_CALL /* 42002 */:
                return "INVALID_API_CALL";
            case RANGING_ALREADY_STARTED /* 42003 */:
                return "RANGING_ALREADY_STARTED";
            case 42004:
                return "MISSING_PERMISSION_UWB_RANGING";
            case UWB_SYSTEM_CALLBACK_FAILURE /* 42005 */:
                return "UWB_SYSTEM_CALLBACK_FAILURE";
            default:
                return CommonStatusCodes.getStatusCodeString(i4);
        }
    }
}
