package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWebhookImportDeviceidBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11166a;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final EditText deviceId;
    @NonNull
    public final Button importButton;
    @NonNull
    public final ProgressBar importingProgressIndicator;
    @NonNull
    public final EditText password;

    private DialogWebhookImportDeviceidBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull EditText editText, @NonNull Button button2, @NonNull ProgressBar progressBar, @NonNull EditText editText2) {
        this.f11166a = linearLayout;
        this.cancelButton = button;
        this.deviceId = editText;
        this.importButton = button2;
        this.importingProgressIndicator = progressBar;
        this.password = editText2;
    }

    @NonNull
    public static DialogWebhookImportDeviceidBinding bind(@NonNull View view) {
        int i4 = R.id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
        if (button != null) {
            i4 = R.id.deviceId;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.deviceId);
            if (editText != null) {
                i4 = R.id.importButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.importButton);
                if (button2 != null) {
                    i4 = R.id.importingProgressIndicator;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.importingProgressIndicator);
                    if (progressBar != null) {
                        i4 = R.id.password;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.password);
                        if (editText2 != null) {
                            return new DialogWebhookImportDeviceidBinding((LinearLayout) view, button, editText, button2, progressBar, editText2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogWebhookImportDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWebhookImportDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_webhook_import_deviceid, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11166a;
    }
}
