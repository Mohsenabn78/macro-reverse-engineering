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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EnterNumberDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11202a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button enterNumberDialogMagicTextButton;
    @NonNull
    public final AppCompatEditText enterNumberDialogPhoneNumber;
    @NonNull
    public final CheckBox excludeNumber;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView wildcardText;

    private EnterNumberDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox, @NonNull Button button3, @NonNull TextView textView) {
        this.f11202a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.enterNumberDialogMagicTextButton = button2;
        this.enterNumberDialogPhoneNumber = appCompatEditText;
        this.excludeNumber = checkBox;
        this.okButton = button3;
        this.wildcardText = textView;
    }

    @NonNull
    public static EnterNumberDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.enter_number_dialog_magic_text_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.enter_number_dialog_magic_text_button);
                if (button2 != null) {
                    i4 = R.id.enter_number_dialog_phone_number;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_number_dialog_phone_number);
                    if (appCompatEditText != null) {
                        i4 = R.id.exclude_number;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.exclude_number);
                        if (checkBox != null) {
                            i4 = R.id.okButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button3 != null) {
                                i4 = R.id.wildcard_Text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wildcard_Text);
                                if (textView != null) {
                                    return new EnterNumberDialogBinding((LinearLayout) view, linearLayout, button, button2, appCompatEditText, checkBox, button3, textView);
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
    public static EnterNumberDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterNumberDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_number_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11202a;
    }
}
