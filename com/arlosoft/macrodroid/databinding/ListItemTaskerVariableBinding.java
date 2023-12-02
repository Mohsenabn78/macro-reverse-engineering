package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ListItemTaskerVariableBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11314a;
    @NonNull
    public final AppCompatButton addVarButton;
    @NonNull
    public final LinearLayout textInputLayout;
    @NonNull
    public final TextView varDescription;
    @NonNull
    public final TextView varName;
    @NonNull
    public final Spinner varSpinner;

    private ListItemTaskerVariableBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatButton appCompatButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Spinner spinner) {
        this.f11314a = linearLayout;
        this.addVarButton = appCompatButton;
        this.textInputLayout = linearLayout2;
        this.varDescription = textView;
        this.varName = textView2;
        this.varSpinner = spinner;
    }

    @NonNull
    public static ListItemTaskerVariableBinding bind(@NonNull View view) {
        int i4 = R.id.addVarButton;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.addVarButton);
        if (appCompatButton != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i4 = R.id.varDescription;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.varDescription);
            if (textView != null) {
                i4 = R.id.varName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.varName);
                if (textView2 != null) {
                    i4 = R.id.varSpinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.varSpinner);
                    if (spinner != null) {
                        return new ListItemTaskerVariableBinding(linearLayout, appCompatButton, linearLayout, textView, textView2, spinner);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemTaskerVariableBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemTaskerVariableBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_tasker_variable, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11314a;
    }
}
