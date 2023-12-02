package com.firebase.ui.auth.data.model;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.FirebaseUiException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class IntentRequiredException extends FirebaseUiException {
    private final Intent mIntent;
    private final int mRequestCode;

    public IntentRequiredException(@NonNull Intent intent, int i4) {
        super(0);
        this.mIntent = intent;
        this.mRequestCode = i4;
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }
}
