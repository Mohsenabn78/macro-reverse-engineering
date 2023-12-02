package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogJavascriptResultExplanationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11084a;
    @NonNull
    public final TextView description;
    @NonNull
    public final CheckBox dontShowAgainCheckbox;
    @NonNull
    public final Button okButton;

    private DialogJavascriptResultExplanationBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckBox checkBox, @NonNull Button button) {
        this.f11084a = linearLayout;
        this.description = textView;
        this.dontShowAgainCheckbox = checkBox;
        this.okButton = button;
    }

    @NonNull
    public static DialogJavascriptResultExplanationBinding bind(@NonNull View view) {
        int i4 = R.id.description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
        if (textView != null) {
            i4 = R.id.dontShowAgainCheckbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.dontShowAgainCheckbox);
            if (checkBox != null) {
                i4 = R.id.okButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button != null) {
                    return new DialogJavascriptResultExplanationBinding((LinearLayout) view, textView, checkBox, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogJavascriptResultExplanationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogJavascriptResultExplanationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_javascript_result_explanation, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11084a;
    }
}
