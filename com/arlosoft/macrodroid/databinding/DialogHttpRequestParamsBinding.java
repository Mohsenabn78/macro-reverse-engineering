package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogHttpRequestParamsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11076a;
    @NonNull
    public final ImageButton deleteButton;
    @NonNull
    public final AppCompatEditText paramName;
    @NonNull
    public final TextInputLayout paramNameLayout;
    @NonNull
    public final Button paramNameMagicTextButton;
    @NonNull
    public final AppCompatEditText paramValue;
    @NonNull
    public final TextInputLayout paramValueLayout;
    @NonNull
    public final Button paramValueMagicTextButton;
    @NonNull
    public final TextView title;

    private DialogHttpRequestParamsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull Button button2, @NonNull TextView textView) {
        this.f11076a = constraintLayout;
        this.deleteButton = imageButton;
        this.paramName = appCompatEditText;
        this.paramNameLayout = textInputLayout;
        this.paramNameMagicTextButton = button;
        this.paramValue = appCompatEditText2;
        this.paramValueLayout = textInputLayout2;
        this.paramValueMagicTextButton = button2;
        this.title = textView;
    }

    @NonNull
    public static DialogHttpRequestParamsBinding bind(@NonNull View view) {
        int i4 = R.id.deleteButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.deleteButton);
        if (imageButton != null) {
            i4 = R.id.paramName;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.paramName);
            if (appCompatEditText != null) {
                i4 = R.id.paramNameLayout;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.paramNameLayout);
                if (textInputLayout != null) {
                    i4 = R.id.paramNameMagicTextButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.paramNameMagicTextButton);
                    if (button != null) {
                        i4 = R.id.paramValue;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.paramValue);
                        if (appCompatEditText2 != null) {
                            i4 = R.id.paramValueLayout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.paramValueLayout);
                            if (textInputLayout2 != null) {
                                i4 = R.id.paramValueMagicTextButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.paramValueMagicTextButton);
                                if (button2 != null) {
                                    i4 = R.id.title;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                    if (textView != null) {
                                        return new DialogHttpRequestParamsBinding((ConstraintLayout) view, imageButton, appCompatEditText, textInputLayout, button, appCompatEditText2, textInputLayout2, button2, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogHttpRequestParamsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogHttpRequestParamsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_http_request_params, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11076a;
    }
}
