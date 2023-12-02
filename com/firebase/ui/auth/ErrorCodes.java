package com.firebase.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class ErrorCodes {
    public static final int ANONYMOUS_UPGRADE_MERGE_CONFLICT = 5;
    public static final int DEVELOPER_ERROR = 3;
    public static final int EMAIL_LINK_CROSS_DEVICE_LINKING_ERROR = 10;
    public static final int EMAIL_LINK_DIFFERENT_ANONYMOUS_USER_ERROR = 11;
    public static final int EMAIL_LINK_PROMPT_FOR_EMAIL_ERROR = 9;
    public static final int EMAIL_LINK_WRONG_DEVICE_ERROR = 8;
    public static final int EMAIL_MISMATCH_ERROR = 6;
    public static final int ERROR_GENERIC_IDP_RECOVERABLE_ERROR = 13;
    public static final int ERROR_USER_DISABLED = 12;
    public static final int INVALID_EMAIL_LINK_ERROR = 7;
    public static final int NO_NETWORK = 1;
    public static final int PLAY_SERVICES_UPDATE_CANCELLED = 2;
    public static final int PROVIDER_ERROR = 4;
    public static final int UNKNOWN_ERROR = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Code {
    }

    private ErrorCodes() {
        throw new AssertionError("No instance for you!");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String toFriendlyMessage(int i4) {
        switch (i4) {
            case 0:
                return "Unknown error";
            case 1:
                return "No internet connection";
            case 2:
                return "Play Services update cancelled";
            case 3:
                return "Developer error";
            case 4:
                return "Provider error";
            case 5:
                return "User account merge conflict";
            case 6:
                return "You are are attempting to sign in a different email than previously provided";
            case 7:
                return "You are are attempting to sign in with an invalid email link";
            case 8:
                return "You must open the email link on the same device.";
            case 9:
                return "Please enter your email to continue signing in";
            case 10:
                return "You must determine if you want to continue linking or complete the sign in";
            case 11:
                return "The session associated with this sign-in request has either expired or was cleared";
            case 12:
                return "The user account has been disabled by an administrator.";
            case 13:
                return "Generic IDP recoverable error.";
            default:
                throw new IllegalArgumentException("Unknown code: " + i4);
        }
    }
}
