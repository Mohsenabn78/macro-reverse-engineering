package com.firebase.ui.auth.util.ui.fieldvalidators;

import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PasswordFieldValidator extends BaseValidator {

    /* renamed from: d  reason: collision with root package name */
    private int f18246d;

    public PasswordFieldValidator(TextInputLayout textInputLayout, int i4) {
        super(textInputLayout);
        this.f18246d = i4;
        Resources resources = this.f18243a.getResources();
        int i5 = R.plurals.fui_error_weak_password;
        int i6 = this.f18246d;
        this.f18244b = resources.getQuantityString(i5, i6, Integer.valueOf(i6));
    }

    @Override // com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator
    protected boolean a(CharSequence charSequence) {
        if (charSequence.length() >= this.f18246d) {
            return true;
        }
        return false;
    }
}
