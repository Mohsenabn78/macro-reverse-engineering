package com.firebase.ui.auth.util.ui.fieldvalidators;

import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class RequiredFieldValidator extends BaseValidator {
    public RequiredFieldValidator(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18244b = this.f18243a.getResources().getString(R.string.fui_required_field);
    }

    @Override // com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator
    protected boolean a(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            return true;
        }
        return false;
    }

    public RequiredFieldValidator(TextInputLayout textInputLayout, String str) {
        super(textInputLayout);
        this.f18244b = str;
    }
}
