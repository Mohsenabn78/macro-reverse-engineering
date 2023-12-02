package com.google.android.gms.auth;

import android.content.Intent;

/* loaded from: classes4.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GooglePlayServicesAvailabilityException(int i4, String str, Intent intent) {
        super(str, intent);
        this.zzu = i4;
    }

    public int getConnectionStatusCode() {
        return this.zzu;
    }
}
