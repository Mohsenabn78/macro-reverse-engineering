package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogConfirmUploadTemplateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11040a;
    @NonNull
    public final Button buttonEdit;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;

    private DialogConfirmUploadTemplateBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3) {
        this.f11040a = linearLayout;
        this.buttonEdit = button;
        this.cancelButton = button2;
        this.okButton = button3;
    }

    @NonNull
    public static DialogConfirmUploadTemplateBinding bind(@NonNull View view) {
        int i4 = R.id.button_edit;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_edit);
        if (button != null) {
            i4 = R.id.cancelButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button2 != null) {
                i4 = R.id.okButton;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button3 != null) {
                    return new DialogConfirmUploadTemplateBinding((LinearLayout) view, button, button2, button3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogConfirmUploadTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfirmUploadTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_confirm_upload_template, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11040a;
    }
}
