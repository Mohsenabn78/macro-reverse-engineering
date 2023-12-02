package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogEnterDescriptionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11057a;
    @NonNull
    public final EditText descriptionEditText;

    private DialogEnterDescriptionBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText) {
        this.f11057a = linearLayout;
        this.descriptionEditText = editText;
    }

    @NonNull
    public static DialogEnterDescriptionBinding bind(@NonNull View view) {
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.descriptionEditText);
        if (editText != null) {
            return new DialogEnterDescriptionBinding((LinearLayout) view, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.descriptionEditText)));
    }

    @NonNull
    public static DialogEnterDescriptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEnterDescriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_enter_description, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11057a;
    }
}
