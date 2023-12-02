package com.firebase.ui.auth.util.ui.fieldvalidators;

import androidx.annotation.RestrictTo;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NoOpValidator extends BaseValidator {
    public NoOpValidator(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator
    protected boolean a(CharSequence charSequence) {
        return true;
    }
}
