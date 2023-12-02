package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f24629e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f24630f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f24631g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i4) {
        super(textInputLayout, i4);
        this.f24629e = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
                passwordToggleEndIconDelegate.f24597c.setChecked(!passwordToggleEndIconDelegate.g());
            }
        };
        this.f24630f = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                EditText editText = textInputLayout2.getEditText();
                textInputLayout2.setEndIconVisible(true);
                textInputLayout2.setEndIconCheckable(true);
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
                passwordToggleEndIconDelegate.f24597c.setChecked(!passwordToggleEndIconDelegate.g());
                editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f24629e);
                editText.addTextChangedListener(PasswordToggleEndIconDelegate.this.f24629e);
            }
        };
        this.f24631g = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i5) {
                final EditText editText = textInputLayout2.getEditText();
                if (editText != null && i5 == 1) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText.post(new Runnable() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f24629e);
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f24595a.getEditText();
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }

    private static boolean h(EditText editText) {
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void a() {
        TextInputLayout textInputLayout = this.f24595a;
        int i4 = this.f24598d;
        if (i4 == 0) {
            i4 = R.drawable.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i4);
        TextInputLayout textInputLayout2 = this.f24595a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.password_toggle_content_description));
        this.f24595a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditText editText = PasswordToggleEndIconDelegate.this.f24595a.getEditText();
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                if (PasswordToggleEndIconDelegate.this.g()) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                PasswordToggleEndIconDelegate.this.f24595a.refreshEndIconDrawableState();
            }
        });
        this.f24595a.addOnEditTextAttachedListener(this.f24630f);
        this.f24595a.addOnEndIconChangedListener(this.f24631g);
        EditText editText = this.f24595a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
