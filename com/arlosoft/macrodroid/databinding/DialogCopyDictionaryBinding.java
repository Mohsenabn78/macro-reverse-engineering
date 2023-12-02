package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogCopyDictionaryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11043a;
    @NonNull
    public final Spinner otherVariableSpinner;

    private DialogCopyDictionaryBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner) {
        this.f11043a = linearLayout;
        this.otherVariableSpinner = spinner;
    }

    @NonNull
    public static DialogCopyDictionaryBinding bind(@NonNull View view) {
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.otherVariableSpinner);
        if (spinner != null) {
            return new DialogCopyDictionaryBinding((LinearLayout) view, spinner);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.otherVariableSpinner)));
    }

    @NonNull
    public static DialogCopyDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCopyDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_copy_dictionary, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11043a;
    }
}
