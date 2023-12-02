package com.arlosoft.macrodroid.upgrade.model;

/* compiled from: ProUserStatus.kt */
/* loaded from: classes3.dex */
public enum ProUserStatusCode {
    PRO_USER_PLAY_STORE_VALID(0),
    PRO_USER_SERIAL_VALID(1),
    PRO_USER_NO_INFO_IN_APP(2),
    PRO_USER_PLAY_STORE_INVALID(3),
    PRO_USER_PLAY_STORE_VOIDED(4),
    PRO_USER_SERIAL_NOT_VERIFIED(5),
    PRO_USER_STATUS_UNAVAILABLE(6),
    PRO_USER_STATUS_AUTH_FAILED(7),
    SUBSCRIPTION_EXPIRED(8),
    SUBSCRIPTION_NOT_FOUND(9);
    
    private final int code;

    ProUserStatusCode(int i4) {
        this.code = i4;
    }

    public final int getCode() {
        return this.code;
    }
}
