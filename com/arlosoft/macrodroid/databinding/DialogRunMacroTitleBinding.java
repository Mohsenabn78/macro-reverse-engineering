package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogRunMacroTitleBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11117a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final AppCompatEditText textContent;

    private DialogRunMacroTitleBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText) {
        this.f11117a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.magicTextButton = button2;
        this.okButton = button3;
        this.textContent = appCompatEditText;
    }

    @NonNull
    public static DialogRunMacroTitleBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.magic_text_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                if (button2 != null) {
                    i4 = R.id.okButton;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button3 != null) {
                        i4 = R.id.text_content;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text_content);
                        if (appCompatEditText != null) {
                            return new DialogRunMacroTitleBinding((ScrollView) view, linearLayout, button, button2, button3, appCompatEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogRunMacroTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogRunMacroTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_run_macro_title, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11117a;
    }
}
