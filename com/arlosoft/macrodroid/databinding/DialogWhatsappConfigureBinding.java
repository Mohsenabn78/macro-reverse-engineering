package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogWhatsappConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11167a;
    @NonNull
    public final RadioButton businessRadioButton;
    @NonNull
    public final TextView delayBeforeSendDescription;
    @NonNull
    public final TextInputLayout delayBeforeSendLayout;
    @NonNull
    public final AppCompatEditText delayBeforeSendMs;
    @NonNull
    public final CheckBox exitAfterSendCheckbox;
    @NonNull
    public final Button magicTextButtonMessage;
    @NonNull
    public final Button magicTextButtonNumber;
    @NonNull
    public final AppCompatEditText messageText;
    @NonNull
    public final AppCompatEditText phoneNumber;
    @NonNull
    public final CheckBox prePopulateCheckbox;
    @NonNull
    public final ImageButton selectContactButton;
    @NonNull
    public final RadioButton standardRadioButton;

    private DialogWhatsappConfigureBinding(@NonNull ScrollView scrollView, @NonNull RadioButton radioButton, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull CheckBox checkBox2, @NonNull ImageButton imageButton, @NonNull RadioButton radioButton2) {
        this.f11167a = scrollView;
        this.businessRadioButton = radioButton;
        this.delayBeforeSendDescription = textView;
        this.delayBeforeSendLayout = textInputLayout;
        this.delayBeforeSendMs = appCompatEditText;
        this.exitAfterSendCheckbox = checkBox;
        this.magicTextButtonMessage = button;
        this.magicTextButtonNumber = button2;
        this.messageText = appCompatEditText2;
        this.phoneNumber = appCompatEditText3;
        this.prePopulateCheckbox = checkBox2;
        this.selectContactButton = imageButton;
        this.standardRadioButton = radioButton2;
    }

    @NonNull
    public static DialogWhatsappConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.businessRadioButton;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.businessRadioButton);
        if (radioButton != null) {
            i4 = R.id.delayBeforeSendDescription;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.delayBeforeSendDescription);
            if (textView != null) {
                i4 = R.id.delayBeforeSendLayout;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.delayBeforeSendLayout);
                if (textInputLayout != null) {
                    i4 = R.id.delayBeforeSendMs;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.delayBeforeSendMs);
                    if (appCompatEditText != null) {
                        i4 = R.id.exitAfterSendCheckbox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.exitAfterSendCheckbox);
                        if (checkBox != null) {
                            i4 = R.id.magicTextButtonMessage;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButtonMessage);
                            if (button != null) {
                                i4 = R.id.magicTextButtonNumber;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButtonNumber);
                                if (button2 != null) {
                                    i4 = R.id.messageText;
                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.messageText);
                                    if (appCompatEditText2 != null) {
                                        i4 = R.id.phoneNumber;
                                        AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.phoneNumber);
                                        if (appCompatEditText3 != null) {
                                            i4 = R.id.prePopulateCheckbox;
                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prePopulateCheckbox);
                                            if (checkBox2 != null) {
                                                i4 = R.id.selectContactButton;
                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectContactButton);
                                                if (imageButton != null) {
                                                    i4 = R.id.standardRadioButton;
                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.standardRadioButton);
                                                    if (radioButton2 != null) {
                                                        return new DialogWhatsappConfigureBinding((ScrollView) view, radioButton, textView, textInputLayout, appCompatEditText, checkBox, button, button2, appCompatEditText2, appCompatEditText3, checkBox2, imageButton, radioButton2);
                                                    }
                                                }
                                            }
                                        }
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
    public static DialogWhatsappConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWhatsappConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_whatsapp_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11167a;
    }
}
