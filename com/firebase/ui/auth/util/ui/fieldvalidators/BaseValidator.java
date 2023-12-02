package com.firebase.ui.auth.util.ui.fieldvalidators;

import androidx.annotation.RestrictTo;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BaseValidator {

    /* renamed from: a  reason: collision with root package name */
    protected TextInputLayout f18243a;

    /* renamed from: b  reason: collision with root package name */
    protected String f18244b = "";

    /* renamed from: c  reason: collision with root package name */
    protected String f18245c;

    public BaseValidator(TextInputLayout textInputLayout) {
        this.f18243a = textInputLayout;
    }

    protected boolean a(CharSequence charSequence) {
        return true;
    }

    public boolean validate(CharSequence charSequence) {
        if (this.f18245c != null && (charSequence == null || charSequence.length() == 0)) {
            this.f18243a.setError(this.f18245c);
            return false;
        } else if (a(charSequence)) {
            this.f18243a.setError("");
            return true;
        } else {
            this.f18243a.setError(this.f18244b);
            return false;
        }
    }
}
