package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.CommonStatusCodes;

@KeepForSdkWithMembers
/* loaded from: classes4.dex */
public class AuthApiStatusCodes extends CommonStatusCodes {
    public static final int AUTH_API_ACCESS_FORBIDDEN = 3001;
    public static final int AUTH_API_CLIENT_ERROR = 3002;
    public static final int AUTH_API_INVALID_CREDENTIALS = 3000;
    public static final int AUTH_API_SERVER_ERROR = 3003;
    public static final int AUTH_APP_CERT_ERROR = 3006;
    public static final int AUTH_TOKEN_ERROR = 3004;
    public static final int AUTH_URL_RESOLUTION = 3005;

    private AuthApiStatusCodes() {
    }

    public static String getStatusCodeString(int i4) {
        switch (i4) {
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case AUTH_API_ACCESS_FORBIDDEN /* 3001 */:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case AUTH_API_CLIENT_ERROR /* 3002 */:
                return "AUTH_API_CLIENT_ERROR";
            case AUTH_API_SERVER_ERROR /* 3003 */:
                return "AUTH_API_SERVER_ERROR";
            case AUTH_TOKEN_ERROR /* 3004 */:
                return "AUTH_TOKEN_ERROR";
            case AUTH_URL_RESOLUTION /* 3005 */:
                return "AUTH_URL_RESOLUTION";
            case AUTH_APP_CERT_ERROR /* 3006 */:
                return "AUTH_APP_CERT_ERROR";
            default:
                return CommonStatusCodes.getStatusCodeString(i4);
        }
    }
}
