package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SendSmsActionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11363a;
    @NonNull
    public final CheckBox sendSmsAddToMessageLogCheckbox;
    @NonNull
    public final Button sendSmsMagicTextButton;
    @NonNull
    public final Button sendSmsMagicTextButtonNumber;
    @NonNull
    public final AppCompatEditText sendSmsPhoneNumber;
    @NonNull
    public final CheckBox sendSmsPrePopulate;
    @NonNull
    public final ImageButton sendSmsSelectContact;
    @NonNull
    public final LinearLayout simSelectionLayout;
    @NonNull
    public final Spinner simSelectionSpinner;
    @NonNull
    public final AppCompatEditText smsText;

    private SendSmsActionBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox2, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout2, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11363a = linearLayout;
        this.sendSmsAddToMessageLogCheckbox = checkBox;
        this.sendSmsMagicTextButton = button;
        this.sendSmsMagicTextButtonNumber = button2;
        this.sendSmsPhoneNumber = appCompatEditText;
        this.sendSmsPrePopulate = checkBox2;
        this.sendSmsSelectContact = imageButton;
        this.simSelectionLayout = linearLayout2;
        this.simSelectionSpinner = spinner;
        this.smsText = appCompatEditText2;
    }

    @NonNull
    public static SendSmsActionBinding bind(@NonNull View view) {
        int i4 = R.id.send_sms_add_to_message_log_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.send_sms_add_to_message_log_checkbox);
        if (checkBox != null) {
            i4 = R.id.send_sms_magic_text_button;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.send_sms_magic_text_button);
            if (button != null) {
                i4 = R.id.send_sms_magic_text_button_number;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.send_sms_magic_text_button_number);
                if (button2 != null) {
                    i4 = R.id.send_sms_phone_number;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.send_sms_phone_number);
                    if (appCompatEditText != null) {
                        i4 = R.id.send_sms_pre_populate;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.send_sms_pre_populate);
                        if (checkBox2 != null) {
                            i4 = R.id.send_sms_select_contact;
                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.send_sms_select_contact);
                            if (imageButton != null) {
                                i4 = R.id.sim_selection_layout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sim_selection_layout);
                                if (linearLayout != null) {
                                    i4 = R.id.sim_selection_spinner;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.sim_selection_spinner);
                                    if (spinner != null) {
                                        i4 = R.id.smsText;
                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.smsText);
                                        if (appCompatEditText2 != null) {
                                            return new SendSmsActionBinding((LinearLayout) view, checkBox, button, button2, appCompatEditText, checkBox2, imageButton, linearLayout, spinner, appCompatEditText2);
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
    public static SendSmsActionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SendSmsActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.send_sms_action, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11363a;
    }
}
