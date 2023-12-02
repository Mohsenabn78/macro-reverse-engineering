package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogPasswordPromptBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11108a;
    @NonNull
    public final TextView exportedPasswordWarning;
    @NonNull
    public final AppCompatEditText passwordEntry;

    private DialogPasswordPromptBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText) {
        this.f11108a = linearLayout;
        this.exportedPasswordWarning = textView;
        this.passwordEntry = appCompatEditText;
    }

    @NonNull
    public static DialogPasswordPromptBinding bind(@NonNull View view) {
        int i4 = R.id.exported_password_warning;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.exported_password_warning);
        if (textView != null) {
            i4 = R.id.passwordEntry;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.passwordEntry);
            if (appCompatEditText != null) {
                return new DialogPasswordPromptBinding((LinearLayout) view, textView, appCompatEditText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogPasswordPromptBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogPasswordPromptBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_password_prompt, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11108a;
    }
}
