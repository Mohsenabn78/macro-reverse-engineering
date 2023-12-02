package com.firebase.ui.auth.util.ui.fieldvalidators;

import android.util.Patterns;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailFieldValidator extends BaseValidator {
    public EmailFieldValidator(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18244b = this.f18243a.getResources().getString(R.string.fui_invalid_email_address);
        this.f18245c = this.f18243a.getResources().getString(R.string.fui_missing_email_address);
    }

    @Override // com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator
    protected boolean a(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
