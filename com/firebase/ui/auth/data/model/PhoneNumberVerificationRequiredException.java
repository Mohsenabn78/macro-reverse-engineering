package com.firebase.ui.auth.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.FirebaseUiException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PhoneNumberVerificationRequiredException extends FirebaseUiException {
    private final String mPhoneNumber;

    public PhoneNumberVerificationRequiredException(@NonNull String str) {
        super(4, "Phone number requires verification.");
        this.mPhoneNumber = str;
    }

    @NonNull
    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }
}
