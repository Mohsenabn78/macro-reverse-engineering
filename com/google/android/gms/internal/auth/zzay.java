package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
public enum zzay {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN("Unknown"),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    NEED_PERMISSION("NeedPermission"),
    NEED_REMOTE_CONSENT("NeedRemoteConsent"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_SCREENLOCK_REQUIRED("DeviceManagementScreenlockRequired"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String zzek;

    zzay(String str) {
        this.zzek = str;
    }

    public static boolean zza(zzay zzayVar) {
        if (!BAD_AUTHENTICATION.equals(zzayVar) && !CAPTCHA.equals(zzayVar) && !NEED_PERMISSION.equals(zzayVar) && !NEED_REMOTE_CONSENT.equals(zzayVar) && !NEEDS_BROWSER.equals(zzayVar) && !USER_CANCEL.equals(zzayVar) && !DEVICE_MANAGEMENT_REQUIRED.equals(zzayVar) && !DM_INTERNAL_ERROR.equals(zzayVar) && !DM_SYNC_DISABLED.equals(zzayVar) && !DM_ADMIN_BLOCKED.equals(zzayVar) && !DM_ADMIN_PENDING_APPROVAL.equals(zzayVar) && !DM_STALE_SYNC_REQUIRED.equals(zzayVar) && !DM_DEACTIVATED.equals(zzayVar) && !DM_REQUIRED.equals(zzayVar) && !THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zzayVar) && !DM_SCREENLOCK_REQUIRED.equals(zzayVar)) {
            return false;
        }
        return true;
    }

    public static final zzay zzc(String str) {
        zzay[] values;
        zzay zzayVar = null;
        for (zzay zzayVar2 : values()) {
            if (zzayVar2.zzek.equals(str)) {
                zzayVar = zzayVar2;
            }
        }
        return zzayVar;
    }
}
