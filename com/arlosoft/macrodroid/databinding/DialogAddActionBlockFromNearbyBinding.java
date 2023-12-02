package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogAddActionBlockFromNearbyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11021a;
    @NonNull
    public final TextInputLayout descriptionInputLayout;
    @NonNull
    public final TextInputEditText descriptionText;
    @NonNull
    public final TextInputLayout nameInputLayout;
    @NonNull
    public final TextInputEditText nameText;

    private DialogAddActionBlockFromNearbyBinding(@NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputEditText textInputEditText2) {
        this.f11021a = linearLayout;
        this.descriptionInputLayout = textInputLayout;
        this.descriptionText = textInputEditText;
        this.nameInputLayout = textInputLayout2;
        this.nameText = textInputEditText2;
    }

    @NonNull
    public static DialogAddActionBlockFromNearbyBinding bind(@NonNull View view) {
        int i4 = R.id.descriptionInputLayout;
        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.descriptionInputLayout);
        if (textInputLayout != null) {
            i4 = R.id.descriptionText;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.descriptionText);
            if (textInputEditText != null) {
                i4 = R.id.nameInputLayout;
                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.nameInputLayout);
                if (textInputLayout2 != null) {
                    i4 = R.id.nameText;
                    TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.nameText);
                    if (textInputEditText2 != null) {
                        return new DialogAddActionBlockFromNearbyBinding((LinearLayout) view, textInputLayout, textInputEditText, textInputLayout2, textInputEditText2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogAddActionBlockFromNearbyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAddActionBlockFromNearbyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_add_action_block_from_nearby, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11021a;
    }
}
