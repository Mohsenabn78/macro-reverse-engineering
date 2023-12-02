package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogUploadDetailsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11158a;
    @NonNull
    public final LinearLayout categoryContainer;
    @NonNull
    public final Spinner catgorySpinner;
    @NonNull
    public final TextInputLayout descriptionInputLayout;
    @NonNull
    public final TextInputEditText descriptionText;
    @NonNull
    public final LinearLayout languageContainer;
    @NonNull
    public final Spinner languageSpinner;
    @NonNull
    public final TextInputLayout nameInputLayout;
    @NonNull
    public final TextInputEditText nameText;
    @NonNull
    public final TextView selectCategoryLabel;

    private DialogUploadDetailsBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Spinner spinner, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull LinearLayout linearLayout3, @NonNull Spinner spinner2, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputEditText textInputEditText2, @NonNull TextView textView) {
        this.f11158a = linearLayout;
        this.categoryContainer = linearLayout2;
        this.catgorySpinner = spinner;
        this.descriptionInputLayout = textInputLayout;
        this.descriptionText = textInputEditText;
        this.languageContainer = linearLayout3;
        this.languageSpinner = spinner2;
        this.nameInputLayout = textInputLayout2;
        this.nameText = textInputEditText2;
        this.selectCategoryLabel = textView;
    }

    @NonNull
    public static DialogUploadDetailsBinding bind(@NonNull View view) {
        int i4 = R.id.categoryContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.categoryContainer);
        if (linearLayout != null) {
            i4 = R.id.catgorySpinner;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.catgorySpinner);
            if (spinner != null) {
                i4 = R.id.descriptionInputLayout;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.descriptionInputLayout);
                if (textInputLayout != null) {
                    i4 = R.id.descriptionText;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.descriptionText);
                    if (textInputEditText != null) {
                        i4 = R.id.languageContainer;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.languageContainer);
                        if (linearLayout2 != null) {
                            i4 = R.id.languageSpinner;
                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.languageSpinner);
                            if (spinner2 != null) {
                                i4 = R.id.nameInputLayout;
                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.nameInputLayout);
                                if (textInputLayout2 != null) {
                                    i4 = R.id.nameText;
                                    TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.nameText);
                                    if (textInputEditText2 != null) {
                                        i4 = R.id.selectCategoryLabel;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.selectCategoryLabel);
                                        if (textView != null) {
                                            return new DialogUploadDetailsBinding((LinearLayout) view, linearLayout, spinner, textInputLayout, textInputEditText, linearLayout2, spinner2, textInputLayout2, textInputEditText2, textView);
                                        }
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
    public static DialogUploadDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUploadDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_upload_details, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11158a;
    }
}
