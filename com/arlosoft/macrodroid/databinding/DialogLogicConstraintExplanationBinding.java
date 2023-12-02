package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogLogicConstraintExplanationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11090a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox dontShowAgainCheckbox;
    @NonNull
    public final TextView enterPasswordDialogPassword;
    @NonNull
    public final FrameLayout exampleContainer;
    @NonNull
    public final Button okButton;

    private DialogLogicConstraintExplanationBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull Button button2) {
        this.f11090a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.dontShowAgainCheckbox = checkBox;
        this.enterPasswordDialogPassword = textView;
        this.exampleContainer = frameLayout;
        this.okButton = button2;
    }

    @NonNull
    public static DialogLogicConstraintExplanationBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dontShowAgainCheckbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.dontShowAgainCheckbox);
                if (checkBox != null) {
                    i4 = R.id.enter_password_dialog_password;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.enter_password_dialog_password);
                    if (textView != null) {
                        i4 = R.id.exampleContainer;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.exampleContainer);
                        if (frameLayout != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                return new DialogLogicConstraintExplanationBinding((ScrollView) view, linearLayout, button, checkBox, textView, frameLayout, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogLogicConstraintExplanationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogLogicConstraintExplanationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_logic_constraint_explanation, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11090a;
    }
}
