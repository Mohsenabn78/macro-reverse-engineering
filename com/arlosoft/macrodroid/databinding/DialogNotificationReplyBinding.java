package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.ToggleButtonGroupTableLayout;

/* loaded from: classes3.dex */
public final class DialogNotificationReplyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11104a;
    @NonNull
    public final TextView applicationNameText;
    @NonNull
    public final LinearLayout defineManuallyLayout;
    @NonNull
    public final RadioButton defineManuallyRadioButton;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final RadioButton notificationTextDialogAnyRadioButton;
    @NonNull
    public final RadioButton notificationTextDialogContainsRadioButton;
    @NonNull
    public final RadioButton notificationTextDialogExcludesRadioButton;
    @NonNull
    public final RadioButton notificationTextDialogMatchesRadioButton;
    @NonNull
    public final AppCompatEditText notificationTextDialogTextContent;
    @NonNull
    public final TextView notificationTextDialogWildcardsInfo;
    @NonNull
    public final ToggleButtonGroupTableLayout radGroup1;
    @NonNull
    public final ImageButton selectAppButton;
    @NonNull
    public final AppCompatEditText textToReply;
    @NonNull
    public final Button textToReplyMagicTextButton;
    @NonNull
    public final RadioButton useNotificationTriggerRadioButton;

    private DialogNotificationReplyBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull Button button, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView2, @NonNull ToggleButtonGroupTableLayout toggleButtonGroupTableLayout, @NonNull ImageButton imageButton, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button2, @NonNull RadioButton radioButton6) {
        this.f11104a = scrollView;
        this.applicationNameText = textView;
        this.defineManuallyLayout = linearLayout;
        this.defineManuallyRadioButton = radioButton;
        this.enableRegex = checkBox;
        this.ignoreCase = checkBox2;
        this.magicTextButton = button;
        this.notificationTextDialogAnyRadioButton = radioButton2;
        this.notificationTextDialogContainsRadioButton = radioButton3;
        this.notificationTextDialogExcludesRadioButton = radioButton4;
        this.notificationTextDialogMatchesRadioButton = radioButton5;
        this.notificationTextDialogTextContent = appCompatEditText;
        this.notificationTextDialogWildcardsInfo = textView2;
        this.radGroup1 = toggleButtonGroupTableLayout;
        this.selectAppButton = imageButton;
        this.textToReply = appCompatEditText2;
        this.textToReplyMagicTextButton = button2;
        this.useNotificationTriggerRadioButton = radioButton6;
    }

    @NonNull
    public static DialogNotificationReplyBinding bind(@NonNull View view) {
        int i4 = R.id.applicationNameText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.applicationNameText);
        if (textView != null) {
            i4 = R.id.define_manually_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.define_manually_layout);
            if (linearLayout != null) {
                i4 = R.id.define_manually_radio_button;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.define_manually_radio_button);
                if (radioButton != null) {
                    i4 = R.id.enable_regex;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                    if (checkBox != null) {
                        i4 = R.id.ignore_case;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                        if (checkBox2 != null) {
                            i4 = R.id.magic_text_button;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                            if (button != null) {
                                i4 = R.id.notification_text_dialog_any_radio_button;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_any_radio_button);
                                if (radioButton2 != null) {
                                    i4 = R.id.notification_text_dialog_contains_radio_button;
                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_contains_radio_button);
                                    if (radioButton3 != null) {
                                        i4 = R.id.notification_text_dialog_excludes_radio_button;
                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_excludes_radio_button);
                                        if (radioButton4 != null) {
                                            i4 = R.id.notification_text_dialog_matches_radio_button;
                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_matches_radio_button);
                                            if (radioButton5 != null) {
                                                i4 = R.id.notification_text_dialog_text_content;
                                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_text_content);
                                                if (appCompatEditText != null) {
                                                    i4 = R.id.notification_text_dialog_wildcards_info;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_wildcards_info);
                                                    if (textView2 != null) {
                                                        i4 = R.id.radGroup1;
                                                        ToggleButtonGroupTableLayout toggleButtonGroupTableLayout = (ToggleButtonGroupTableLayout) ViewBindings.findChildViewById(view, R.id.radGroup1);
                                                        if (toggleButtonGroupTableLayout != null) {
                                                            i4 = R.id.selectAppButton;
                                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectAppButton);
                                                            if (imageButton != null) {
                                                                i4 = R.id.text_to_reply;
                                                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text_to_reply);
                                                                if (appCompatEditText2 != null) {
                                                                    i4 = R.id.text_to_reply_magic_text_button;
                                                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.text_to_reply_magic_text_button);
                                                                    if (button2 != null) {
                                                                        i4 = R.id.use_notification_trigger_radio_button;
                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(view, R.id.use_notification_trigger_radio_button);
                                                                        if (radioButton6 != null) {
                                                                            return new DialogNotificationReplyBinding((ScrollView) view, textView, linearLayout, radioButton, checkBox, checkBox2, button, radioButton2, radioButton3, radioButton4, radioButton5, appCompatEditText, textView2, toggleButtonGroupTableLayout, imageButton, appCompatEditText2, button2, radioButton6);
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
    public static DialogNotificationReplyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogNotificationReplyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_notification_reply, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11104a;
    }
}
