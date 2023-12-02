package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWebhookGenerateNewDeviceidBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11165a;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button generateNewIdButton;
    @NonNull
    public final ProgressBar generatingProgressIndicator;
    @NonNull
    public final CheckBox understoodCheckBox;

    private DialogWebhookGenerateNewDeviceidBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull ProgressBar progressBar, @NonNull CheckBox checkBox) {
        this.f11165a = linearLayout;
        this.cancelButton = button;
        this.generateNewIdButton = button2;
        this.generatingProgressIndicator = progressBar;
        this.understoodCheckBox = checkBox;
    }

    @NonNull
    public static DialogWebhookGenerateNewDeviceidBinding bind(@NonNull View view) {
        int i4 = R.id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
        if (button != null) {
            i4 = R.id.generateNewIdButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.generateNewIdButton);
            if (button2 != null) {
                i4 = R.id.generatingProgressIndicator;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.generatingProgressIndicator);
                if (progressBar != null) {
                    i4 = R.id.understoodCheckBox;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.understoodCheckBox);
                    if (checkBox != null) {
                        return new DialogWebhookGenerateNewDeviceidBinding((LinearLayout) view, button, button2, progressBar, checkBox);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogWebhookGenerateNewDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWebhookGenerateNewDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_webhook_generate_new_deviceid, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11165a;
    }
}
