package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SmsContentDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11375a;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final CheckBox monitorInboxCheckbox;
    @NonNull
    public final TextView monitorInboxSummary;
    @NonNull
    public final TextView notificationTextDialogWildcardsInfo;
    @NonNull
    public final RadioButton smsContentDialogAnyRadioButton;
    @NonNull
    public final RadioButton smsContentDialogContainsRadioButton;
    @NonNull
    public final RadioButton smsContentDialogExcludesRadioButton;
    @NonNull
    public final RadioButton smsContentDialogMatchesRadioButton;
    @NonNull
    public final AppCompatEditText smsContentDialogTextContent;
    @NonNull
    public final Button specialTextButton;
    @NonNull
    public final LinearLayout subscriptionIdContainer;
    @NonNull
    public final Spinner subscriptionIdSpinner;

    private SmsContentDialogBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull Spinner spinner) {
        this.f11375a = scrollView;
        this.enableRegex = checkBox;
        this.ignoreCase = checkBox2;
        this.monitorInboxCheckbox = checkBox3;
        this.monitorInboxSummary = textView;
        this.notificationTextDialogWildcardsInfo = textView2;
        this.smsContentDialogAnyRadioButton = radioButton;
        this.smsContentDialogContainsRadioButton = radioButton2;
        this.smsContentDialogExcludesRadioButton = radioButton3;
        this.smsContentDialogMatchesRadioButton = radioButton4;
        this.smsContentDialogTextContent = appCompatEditText;
        this.specialTextButton = button;
        this.subscriptionIdContainer = linearLayout;
        this.subscriptionIdSpinner = spinner;
    }

    @NonNull
    public static SmsContentDialogBinding bind(@NonNull View view) {
        int i4 = R.id.enable_regex;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
        if (checkBox != null) {
            i4 = R.id.ignore_case;
            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
            if (checkBox2 != null) {
                i4 = R.id.monitorInboxCheckbox;
                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.monitorInboxCheckbox);
                if (checkBox3 != null) {
                    i4 = R.id.monitorInboxSummary;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.monitorInboxSummary);
                    if (textView != null) {
                        i4 = R.id.notification_text_dialog_wildcards_info;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_wildcards_info);
                        if (textView2 != null) {
                            i4 = R.id.sms_content_dialog_any_radio_button;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.sms_content_dialog_any_radio_button);
                            if (radioButton != null) {
                                i4 = R.id.sms_content_dialog_contains_radio_button;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.sms_content_dialog_contains_radio_button);
                                if (radioButton2 != null) {
                                    i4 = R.id.sms_content_dialog_excludes_radio_button;
                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.sms_content_dialog_excludes_radio_button);
                                    if (radioButton3 != null) {
                                        i4 = R.id.sms_content_dialog_matches_radio_button;
                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.sms_content_dialog_matches_radio_button);
                                        if (radioButton4 != null) {
                                            i4 = R.id.sms_content_dialog_text_content;
                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.sms_content_dialog_text_content);
                                            if (appCompatEditText != null) {
                                                i4 = R.id.special_text_button;
                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button);
                                                if (button != null) {
                                                    i4 = R.id.subscription_id_container;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.subscription_id_container);
                                                    if (linearLayout != null) {
                                                        i4 = R.id.subscription_id_spinner;
                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.subscription_id_spinner);
                                                        if (spinner != null) {
                                                            return new SmsContentDialogBinding((ScrollView) view, checkBox, checkBox2, checkBox3, textView, textView2, radioButton, radioButton2, radioButton3, radioButton4, appCompatEditText, button, linearLayout, spinner);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SmsContentDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SmsContentDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.sms_content_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11375a;
    }
}
