package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class ConfigureNotificationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11000a;
    @NonNull
    public final Button actionActionButtonButton;
    @NonNull
    public final LinearLayout actionButtonsContainer;
    @NonNull
    public final Button configInputOutputParams;
    @NonNull
    public final CheckBox configureNotificationBlockNextAction;
    @NonNull
    public final Button configureNotificationChangeIconButton;
    @NonNull
    public final Button configureNotificationIconBackground;
    @NonNull
    public final RelativeLayout configureNotificationImageContainer;
    @NonNull
    public final CheckBox configureNotificationInvokeMacroCheckbox;
    @NonNull
    public final Spinner configureNotificationInvokeMacroSpinner;
    @NonNull
    public final Button configureNotificationMagicSubjectButton;
    @NonNull
    public final Button configureNotificationMagicTextButton;
    @NonNull
    public final Spinner configureNotificationNotificationSound;
    @NonNull
    public final AppCompatEditText configureNotificationNotificationText;
    @NonNull
    public final CheckBox configureNotificationOverwriteCheckbox;
    @NonNull
    public final ImageView configureNotificationPreviewImage;
    @NonNull
    public final Spinner configureNotificationPrioritySpinner;
    @NonNull
    public final AppCompatEditText configureNotificationSubjectText;
    @NonNull
    public final Button editNotificationChannels;
    @NonNull
    public final CheckBox htmlCheckBox;
    @NonNull
    public final LinearLayout iconConfigContainer;
    @NonNull
    public final RadioGroup iconTypeRadioGroup;
    @NonNull
    public final CheckBox maintainSpacesCheckbox;
    @NonNull
    public final LinearLayout maintainSpacesContainer;
    @NonNull
    public final LinearLayout notificationChannelContainer;
    @NonNull
    public final Spinner notificationChannelsSpinner;
    @NonNull
    public final LinearLayout notificationContainer;
    @NonNull
    public final AppCompatEditText notificationIconText;
    @NonNull
    public final TextInputLayout notificationIconTextInputLayout;
    @NonNull
    public final LinearLayout notificationIconTextLayout;
    @NonNull
    public final Button notificationIconTextMagicTextButton;
    @NonNull
    public final TextInputLayout notificationSubjectInputLayout;
    @NonNull
    public final TextInputLayout notificationTextInputLayout;
    @NonNull
    public final CheckBox preventBackButtonCheckbox;
    @NonNull
    public final RadioButton radioButtonUseIcon;
    @NonNull
    public final RadioButton radioButtonUseText;
    @NonNull
    public final LinearLayout soundOptionsContainer;

    private ConfigureNotificationBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull Button button2, @NonNull CheckBox checkBox, @NonNull Button button3, @NonNull Button button4, @NonNull RelativeLayout relativeLayout, @NonNull CheckBox checkBox2, @NonNull Spinner spinner, @NonNull Button button5, @NonNull Button button6, @NonNull Spinner spinner2, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox3, @NonNull ImageView imageView, @NonNull Spinner spinner3, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button7, @NonNull CheckBox checkBox4, @NonNull LinearLayout linearLayout2, @NonNull RadioGroup radioGroup, @NonNull CheckBox checkBox5, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull Spinner spinner4, @NonNull LinearLayout linearLayout5, @NonNull AppCompatEditText appCompatEditText3, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout6, @NonNull Button button8, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull CheckBox checkBox6, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout7) {
        this.f11000a = scrollView;
        this.actionActionButtonButton = button;
        this.actionButtonsContainer = linearLayout;
        this.configInputOutputParams = button2;
        this.configureNotificationBlockNextAction = checkBox;
        this.configureNotificationChangeIconButton = button3;
        this.configureNotificationIconBackground = button4;
        this.configureNotificationImageContainer = relativeLayout;
        this.configureNotificationInvokeMacroCheckbox = checkBox2;
        this.configureNotificationInvokeMacroSpinner = spinner;
        this.configureNotificationMagicSubjectButton = button5;
        this.configureNotificationMagicTextButton = button6;
        this.configureNotificationNotificationSound = spinner2;
        this.configureNotificationNotificationText = appCompatEditText;
        this.configureNotificationOverwriteCheckbox = checkBox3;
        this.configureNotificationPreviewImage = imageView;
        this.configureNotificationPrioritySpinner = spinner3;
        this.configureNotificationSubjectText = appCompatEditText2;
        this.editNotificationChannels = button7;
        this.htmlCheckBox = checkBox4;
        this.iconConfigContainer = linearLayout2;
        this.iconTypeRadioGroup = radioGroup;
        this.maintainSpacesCheckbox = checkBox5;
        this.maintainSpacesContainer = linearLayout3;
        this.notificationChannelContainer = linearLayout4;
        this.notificationChannelsSpinner = spinner4;
        this.notificationContainer = linearLayout5;
        this.notificationIconText = appCompatEditText3;
        this.notificationIconTextInputLayout = textInputLayout;
        this.notificationIconTextLayout = linearLayout6;
        this.notificationIconTextMagicTextButton = button8;
        this.notificationSubjectInputLayout = textInputLayout2;
        this.notificationTextInputLayout = textInputLayout3;
        this.preventBackButtonCheckbox = checkBox6;
        this.radioButtonUseIcon = radioButton;
        this.radioButtonUseText = radioButton2;
        this.soundOptionsContainer = linearLayout7;
    }

    @NonNull
    public static ConfigureNotificationBinding bind(@NonNull View view) {
        int i4 = R.id.actionActionButtonButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.actionActionButtonButton);
        if (button != null) {
            i4 = R.id.actionButtonsContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actionButtonsContainer);
            if (linearLayout != null) {
                i4 = R.id.configInputOutputParams;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams);
                if (button2 != null) {
                    i4 = R.id.configure_notification_block_next_action;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_notification_block_next_action);
                    if (checkBox != null) {
                        i4 = R.id.configure_notification_change_icon_button;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.configure_notification_change_icon_button);
                        if (button3 != null) {
                            i4 = R.id.configure_notification_icon_background;
                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.configure_notification_icon_background);
                            if (button4 != null) {
                                i4 = R.id.configure_notification_image_container;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.configure_notification_image_container);
                                if (relativeLayout != null) {
                                    i4 = R.id.configure_notification_invoke_macro_checkbox;
                                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_notification_invoke_macro_checkbox);
                                    if (checkBox2 != null) {
                                        i4 = R.id.configure_notification_invoke_macro_spinner;
                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_notification_invoke_macro_spinner);
                                        if (spinner != null) {
                                            i4 = R.id.configure_notification_magic_subject_button;
                                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.configure_notification_magic_subject_button);
                                            if (button5 != null) {
                                                i4 = R.id.configure_notification_magic_text_button;
                                                Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.configure_notification_magic_text_button);
                                                if (button6 != null) {
                                                    i4 = R.id.configure_notification_notification_sound;
                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_notification_notification_sound);
                                                    if (spinner2 != null) {
                                                        i4 = R.id.configure_notification_notification_text;
                                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_notification_notification_text);
                                                        if (appCompatEditText != null) {
                                                            i4 = R.id.configure_notification_overwrite_checkbox;
                                                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_notification_overwrite_checkbox);
                                                            if (checkBox3 != null) {
                                                                i4 = R.id.configure_notification_preview_image;
                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.configure_notification_preview_image);
                                                                if (imageView != null) {
                                                                    i4 = R.id.configure_notification_priority_spinner;
                                                                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_notification_priority_spinner);
                                                                    if (spinner3 != null) {
                                                                        i4 = R.id.configure_notification_subject_text;
                                                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_notification_subject_text);
                                                                        if (appCompatEditText2 != null) {
                                                                            i4 = R.id.edit_notification_channels;
                                                                            Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.edit_notification_channels);
                                                                            if (button7 != null) {
                                                                                i4 = R.id.html_check_box;
                                                                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.html_check_box);
                                                                                if (checkBox4 != null) {
                                                                                    i4 = R.id.icon_config_container;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.icon_config_container);
                                                                                    if (linearLayout2 != null) {
                                                                                        i4 = R.id.icon_type_radio_group;
                                                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.icon_type_radio_group);
                                                                                        if (radioGroup != null) {
                                                                                            i4 = R.id.maintain_spaces_checkbox;
                                                                                            CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.maintain_spaces_checkbox);
                                                                                            if (checkBox5 != null) {
                                                                                                i4 = R.id.maintain_spaces_container;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.maintain_spaces_container);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i4 = R.id.notification_channel_container;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.notification_channel_container);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i4 = R.id.notification_channels_spinner;
                                                                                                        Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.notification_channels_spinner);
                                                                                                        if (spinner4 != null) {
                                                                                                            i4 = R.id.notification_container;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.notification_container);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i4 = R.id.notification_icon_text;
                                                                                                                AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.notification_icon_text);
                                                                                                                if (appCompatEditText3 != null) {
                                                                                                                    i4 = R.id.notification_icon_text_input_layout;
                                                                                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.notification_icon_text_input_layout);
                                                                                                                    if (textInputLayout != null) {
                                                                                                                        i4 = R.id.notification_icon_text_layout;
                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.notification_icon_text_layout);
                                                                                                                        if (linearLayout6 != null) {
                                                                                                                            i4 = R.id.notification_icon_text_magic_text_button;
                                                                                                                            Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.notification_icon_text_magic_text_button);
                                                                                                                            if (button8 != null) {
                                                                                                                                i4 = R.id.notification_subject_input_layout;
                                                                                                                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.notification_subject_input_layout);
                                                                                                                                if (textInputLayout2 != null) {
                                                                                                                                    i4 = R.id.notification_text_input_layout;
                                                                                                                                    TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.notification_text_input_layout);
                                                                                                                                    if (textInputLayout3 != null) {
                                                                                                                                        i4 = R.id.prevent_back_button_checkbox;
                                                                                                                                        CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_back_button_checkbox);
                                                                                                                                        if (checkBox6 != null) {
                                                                                                                                            i4 = R.id.radio_button_use_icon;
                                                                                                                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_use_icon);
                                                                                                                                            if (radioButton != null) {
                                                                                                                                                i4 = R.id.radio_button_use_text;
                                                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_use_text);
                                                                                                                                                if (radioButton2 != null) {
                                                                                                                                                    i4 = R.id.sound_options_container;
                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sound_options_container);
                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                        return new ConfigureNotificationBinding((ScrollView) view, button, linearLayout, button2, checkBox, button3, button4, relativeLayout, checkBox2, spinner, button5, button6, spinner2, appCompatEditText, checkBox3, imageView, spinner3, appCompatEditText2, button7, checkBox4, linearLayout2, radioGroup, checkBox5, linearLayout3, linearLayout4, spinner4, linearLayout5, appCompatEditText3, textInputLayout, linearLayout6, button8, textInputLayout2, textInputLayout3, checkBox6, radioButton, radioButton2, linearLayout7);
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
    public static ConfigureNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_notification, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11000a;
    }
}
