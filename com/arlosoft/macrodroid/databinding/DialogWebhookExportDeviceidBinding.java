package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWebhookExportDeviceidBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewFlipper f11164a;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView deviceIdValue;
    @NonNull
    public final Button dismissButton;
    @NonNull
    public final Button exportButton;
    @NonNull
    public final ProgressBar exportingProgressIndicator;
    @NonNull
    public final EditText password;
    @NonNull
    public final TextView passwordValue;
    @NonNull
    public final ImageView shareDeviceIdButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private DialogWebhookExportDeviceidBinding(@NonNull ViewFlipper viewFlipper, @NonNull Button button, @NonNull TextView textView, @NonNull Button button2, @NonNull Button button3, @NonNull ProgressBar progressBar, @NonNull EditText editText, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ViewFlipper viewFlipper2) {
        this.f11164a = viewFlipper;
        this.cancelButton = button;
        this.deviceIdValue = textView;
        this.dismissButton = button2;
        this.exportButton = button3;
        this.exportingProgressIndicator = progressBar;
        this.password = editText;
        this.passwordValue = textView2;
        this.shareDeviceIdButton = imageView;
        this.viewFlipper = viewFlipper2;
    }

    @NonNull
    public static DialogWebhookExportDeviceidBinding bind(@NonNull View view) {
        int i4 = R.id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
        if (button != null) {
            i4 = R.id.deviceIdValue;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.deviceIdValue);
            if (textView != null) {
                i4 = R.id.dismissButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.dismissButton);
                if (button2 != null) {
                    i4 = R.id.exportButton;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.exportButton);
                    if (button3 != null) {
                        i4 = R.id.exportingProgressIndicator;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.exportingProgressIndicator);
                        if (progressBar != null) {
                            i4 = R.id.password;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.password);
                            if (editText != null) {
                                i4 = R.id.passwordValue;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.passwordValue);
                                if (textView2 != null) {
                                    i4 = R.id.shareDeviceIdButton;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.shareDeviceIdButton);
                                    if (imageView != null) {
                                        ViewFlipper viewFlipper = (ViewFlipper) view;
                                        return new DialogWebhookExportDeviceidBinding(viewFlipper, button, textView, button2, button3, progressBar, editText, textView2, imageView, viewFlipper);
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
    public static DialogWebhookExportDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWebhookExportDeviceidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_webhook_export_deviceid, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ViewFlipper getRoot() {
        return this.f11164a;
    }
}
