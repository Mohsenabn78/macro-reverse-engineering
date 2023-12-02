package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class IncludeIntentExtraBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11257a;
    @NonNull
    public final Button addVariableButton;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final AppCompatEditText parameterName;
    @NonNull
    public final Button specialTextButton;
    @NonNull
    public final AppCompatEditText value;
    @NonNull
    public final NDSpinner variableSpinner;
    @NonNull
    public final TextView wildcardsText;

    private IncludeIntentExtraBinding(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText2, @NonNull NDSpinner nDSpinner, @NonNull TextView textView) {
        this.f11257a = frameLayout;
        this.addVariableButton = button;
        this.deleteButton = imageView;
        this.parameterName = appCompatEditText;
        this.specialTextButton = button2;
        this.value = appCompatEditText2;
        this.variableSpinner = nDSpinner;
        this.wildcardsText = textView;
    }

    @NonNull
    public static IncludeIntentExtraBinding bind(@NonNull View view) {
        int i4 = R.id.add_variable_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_variable_button);
        if (button != null) {
            i4 = R.id.delete_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delete_button);
            if (imageView != null) {
                i4 = R.id.parameter_name;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.parameter_name);
                if (appCompatEditText != null) {
                    i4 = R.id.special_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button);
                    if (button2 != null) {
                        i4 = R.id.value;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.value);
                        if (appCompatEditText2 != null) {
                            i4 = R.id.variable_spinner;
                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variable_spinner);
                            if (nDSpinner != null) {
                                i4 = R.id.wildcards_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wildcards_text);
                                if (textView != null) {
                                    return new IncludeIntentExtraBinding((FrameLayout) view, button, imageView, appCompatEditText, button2, appCompatEditText2, nDSpinner, textView);
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
    public static IncludeIntentExtraBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeIntentExtraBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_intent_extra, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11257a;
    }
}
