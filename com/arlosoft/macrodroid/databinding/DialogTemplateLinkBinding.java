package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogTemplateLinkBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11143a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button copyButton;
    @NonNull
    public final TextView dialogTemplateLinkText;
    @NonNull
    public final Button okButton;

    private DialogTemplateLinkBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull Button button3) {
        this.f11143a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.copyButton = button2;
        this.dialogTemplateLinkText = textView;
        this.okButton = button3;
    }

    @NonNull
    public static DialogTemplateLinkBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.copyButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.copyButton);
                if (button2 != null) {
                    i4 = R.id.dialog_template_link_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_template_link_text);
                    if (textView != null) {
                        i4 = R.id.okButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button3 != null) {
                            return new DialogTemplateLinkBinding((LinearLayout) view, linearLayout, button, button2, textView, button3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogTemplateLinkBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTemplateLinkBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_template_link, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11143a;
    }
}
