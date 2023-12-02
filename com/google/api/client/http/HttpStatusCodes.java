package com.google.api.client.http;

/* loaded from: classes5.dex */
public class HttpStatusCodes {
    public static final int STATUS_CODE_BAD_GATEWAY = 502;
    public static final int STATUS_CODE_BAD_REQUEST = 400;
    public static final int STATUS_CODE_CONFLICT = 409;
    public static final int STATUS_CODE_CREATED = 201;
    public static final int STATUS_CODE_FORBIDDEN = 403;
    public static final int STATUS_CODE_FOUND = 302;
    public static final int STATUS_CODE_METHOD_NOT_ALLOWED = 405;
    public static final int STATUS_CODE_MOVED_PERMANENTLY = 301;
    public static final int STATUS_CODE_MULTIPLE_CHOICES = 300;
    public static final int STATUS_CODE_NOT_FOUND = 404;
    public static final int STATUS_CODE_NOT_MODIFIED = 304;
    public static final int STATUS_CODE_NO_CONTENT = 204;
    public static final int STATUS_CODE_OK = 200;
    public static final int STATUS_CODE_PRECONDITION_FAILED = 412;
    public static final int STATUS_CODE_SEE_OTHER = 303;
    public static final int STATUS_CODE_SERVER_ERROR = 500;
    public static final int STATUS_CODE_SERVICE_UNAVAILABLE = 503;
    public static final int STATUS_CODE_TEMPORARY_REDIRECT = 307;
    public static final int STATUS_CODE_UNAUTHORIZED = 401;
    public static final int STATUS_CODE_UNPROCESSABLE_ENTITY = 422;

    public static boolean isRedirect(int i4) {
        if (i4 != 307) {
            switch (i4) {
                case 301:
                case 302:
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean isSuccess(int i4) {
        if (i4 >= 200 && i4 < 300) {
            return true;
        }
        return false;
    }
}
