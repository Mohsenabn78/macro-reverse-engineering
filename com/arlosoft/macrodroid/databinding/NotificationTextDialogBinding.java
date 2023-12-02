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
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.widget.ToggleButtonGroupTableLayout;

/* loaded from: classes3.dex */
public final class NotificationTextDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11339a;
    @NonNull
    public final LinearLayout actionsContainer;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final NumberPicker hourPicker;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final NumberPicker minutePicker;
    @NonNull
    public final Spinner notificationActionsSpinner;
    @NonNull
    public final RadioButton notificationTextDialogAnyRadioButton;
    @NonNull
    public final RadioButton notificationTextDialogContainsRadioButton;
    @NonNull
    public final CheckBox notificationTextDialogExcludeOngoing;
    @NonNull
    public final RadioButton notificationTextDialogExcludesRadioButton;
    @NonNull
    public final RadioButton notificationTextDialogMatchesRadioButton;
    @NonNull
    public final CheckBox notificationTextDialogSupressMultiples;
    @NonNull
    public final AppCompatEditText notificationTextDialogTextContent;
    @NonNull
    public final TextView notificationTextDialogWildcardsInfo;
    @NonNull
    public final Button okButton;
    @NonNull
    public final LinearLayout olderThanContainer;
    @NonNull
    public final ToggleButtonGroupTableLayout radGroup1;
    @NonNull
    public final NumberPicker secondPicker;
    @NonNull
    public final AppCompatSpinner soundOptionSpinner;
    @NonNull
    public final LinearLayout soundOptionsContainer;

    private NotificationTextDialogBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull NumberPicker numberPicker, @NonNull CheckBox checkBox2, @NonNull Button button2, @NonNull NumberPicker numberPicker2, @NonNull Spinner spinner, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull CheckBox checkBox3, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull CheckBox checkBox4, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull Button button3, @NonNull LinearLayout linearLayout3, @NonNull ToggleButtonGroupTableLayout toggleButtonGroupTableLayout, @NonNull NumberPicker numberPicker3, @NonNull AppCompatSpinner appCompatSpinner, @NonNull LinearLayout linearLayout4) {
        this.f11339a = scrollView;
        this.actionsContainer = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.enableRegex = checkBox;
        this.hourPicker = numberPicker;
        this.ignoreCase = checkBox2;
        this.magicTextButton = button2;
        this.minutePicker = numberPicker2;
        this.notificationActionsSpinner = spinner;
        this.notificationTextDialogAnyRadioButton = radioButton;
        this.notificationTextDialogContainsRadioButton = radioButton2;
        this.notificationTextDialogExcludeOngoing = checkBox3;
        this.notificationTextDialogExcludesRadioButton = radioButton3;
        this.notificationTextDialogMatchesRadioButton = radioButton4;
        this.notificationTextDialogSupressMultiples = checkBox4;
        this.notificationTextDialogTextContent = appCompatEditText;
        this.notificationTextDialogWildcardsInfo = textView;
        this.okButton = button3;
        this.olderThanContainer = linearLayout3;
        this.radGroup1 = toggleButtonGroupTableLayout;
        this.secondPicker = numberPicker3;
        this.soundOptionSpinner = appCompatSpinner;
        this.soundOptionsContainer = linearLayout4;
    }

    @NonNull
    public static NotificationTextDialogBinding bind(@NonNull View view) {
        int i4 = R.id.actions_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actions_container);
        if (linearLayout != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout2 != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.enable_regex;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                    if (checkBox != null) {
                        i4 = R.id.hour_picker;
                        NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.hour_picker);
                        if (numberPicker != null) {
                            i4 = R.id.ignore_case;
                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                            if (checkBox2 != null) {
                                i4 = R.id.magic_text_button;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                                if (button2 != null) {
                                    i4 = R.id.minute_picker;
                                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.minute_picker);
                                    if (numberPicker2 != null) {
                                        i4 = R.id.notification_actions_spinner;
                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.notification_actions_spinner);
                                        if (spinner != null) {
                                            i4 = R.id.notification_text_dialog_any_radio_button;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_any_radio_button);
                                            if (radioButton != null) {
                                                i4 = R.id.notification_text_dialog_contains_radio_button;
                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_contains_radio_button);
                                                if (radioButton2 != null) {
                                                    i4 = R.id.notification_text_dialog_exclude_ongoing;
                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_exclude_ongoing);
                                                    if (checkBox3 != null) {
                                                        i4 = R.id.notification_text_dialog_excludes_radio_button;
                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_excludes_radio_button);
                                                        if (radioButton3 != null) {
                                                            i4 = R.id.notification_text_dialog_matches_radio_button;
                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_matches_radio_button);
                                                            if (radioButton4 != null) {
                                                                i4 = R.id.notification_text_dialog_supress_multiples;
                                                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_supress_multiples);
                                                                if (checkBox4 != null) {
                                                                    i4 = R.id.notification_text_dialog_text_content;
                                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_text_content);
                                                                    if (appCompatEditText != null) {
                                                                        i4 = R.id.notification_text_dialog_wildcards_info;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_wildcards_info);
                                                                        if (textView != null) {
                                                                            i4 = R.id.okButton;
                                                                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                            if (button3 != null) {
                                                                                i4 = R.id.older_than_container;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.older_than_container);
                                                                                if (linearLayout3 != null) {
                                                                                    i4 = R.id.radGroup1;
                                                                                    ToggleButtonGroupTableLayout toggleButtonGroupTableLayout = (ToggleButtonGroupTableLayout) ViewBindings.findChildViewById(view, R.id.radGroup1);
                                                                                    if (toggleButtonGroupTableLayout != null) {
                                                                                        i4 = R.id.second_picker;
                                                                                        NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.second_picker);
                                                                                        if (numberPicker3 != null) {
                                                                                            i4 = R.id.sound_option_spinner;
                                                                                            AppCompatSpinner appCompatSpinner = (AppCompatSpinner) ViewBindings.findChildViewById(view, R.id.sound_option_spinner);
                                                                                            if (appCompatSpinner != null) {
                                                                                                i4 = R.id.sound_options_container;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sound_options_container);
                                                                                                if (linearLayout4 != null) {
                                                                                                    return new NotificationTextDialogBinding((ScrollView) view, linearLayout, linearLayout2, button, checkBox, numberPicker, checkBox2, button2, numberPicker2, spinner, radioButton, radioButton2, checkBox3, radioButton3, radioButton4, checkBox4, appCompatEditText, textView, button3, linearLayout3, toggleButtonGroupTableLayout, numberPicker3, appCompatSpinner, linearLayout4);
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
    public static NotificationTextDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NotificationTextDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.notification_text_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11339a;
    }
}
