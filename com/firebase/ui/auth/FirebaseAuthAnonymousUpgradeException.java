package com.firebase.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class FirebaseAuthAnonymousUpgradeException extends Exception {
    private IdpResponse mResponse;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseAuthAnonymousUpgradeException(int i4, @NonNull IdpResponse idpResponse) {
        super(ErrorCodes.toFriendlyMessage(i4));
        this.mResponse = idpResponse;
    }

    public IdpResponse getResponse() {
        return this.mResponse;
    }
}
