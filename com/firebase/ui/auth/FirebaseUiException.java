package com.firebase.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* loaded from: classes3.dex */
public class FirebaseUiException extends Exception {
    private final int mErrorCode;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseUiException(int i4) {
        this(i4, ErrorCodes.toFriendlyMessage(i4));
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseUiException(int i4, @NonNull String str) {
        super(str);
        this.mErrorCode = i4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseUiException(int i4, @NonNull Throwable th) {
        this(i4, ErrorCodes.toFriendlyMessage(i4), th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FirebaseUiException(int i4, @NonNull String str, @NonNull Throwable th) {
        super(str, th);
        this.mErrorCode = i4;
    }
}
