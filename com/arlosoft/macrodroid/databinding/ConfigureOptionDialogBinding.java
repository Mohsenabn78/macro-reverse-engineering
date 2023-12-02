package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConfigureOptionDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11005a;
    @NonNull
    public final CheckBox blockNextActions;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button configInputOutputParams1;
    @NonNull
    public final Button configInputOutputParams2;
    @NonNull
    public final Button configInputOutputParams3;
    @NonNull
    public final AppCompatEditText configureOptionDialog1;
    @NonNull
    public final AppCompatEditText configureOptionDialog2;
    @NonNull
    public final AppCompatEditText configureOptionDialog3;
    @NonNull
    public final AppCompatEditText configureOptionDialogMessage;
    @NonNull
    public final Spinner configureOptionDialogSpinner1;
    @NonNull
    public final Spinner configureOptionDialogSpinner2;
    @NonNull
    public final Spinner configureOptionDialogSpinner3;
    @NonNull
    public final AppCompatEditText configureOptionDialogTitle;
    @NonNull
    public final Spinner defaultOptionSpinner;
    @NonNull
    public final Button okButton;
    @NonNull
    public final Button optionDialogButton1MagicTextButton;
    @NonNull
    public final Button optionDialogButton2MagicTextButton;
    @NonNull
    public final Button optionDialogButton3MagicTextButton;
    @NonNull
    public final Button optionDialogMessageMagicTextButton;
    @NonNull
    public final Button optionDialogTitleMagicTextButton;
    @NonNull
    public final CheckBox preventBackButtonCheckbox;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final TextView secondsValue;
    @NonNull
    public final LinearLayout timeoutOptions;
    @NonNull
    public final SeekBar timeoutSeekbar;

    private ConfigureOptionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull AppCompatEditText appCompatEditText4, @NonNull Spinner spinner, @NonNull Spinner spinner2, @NonNull Spinner spinner3, @NonNull AppCompatEditText appCompatEditText5, @NonNull Spinner spinner4, @NonNull Button button5, @NonNull Button button6, @NonNull Button button7, @NonNull Button button8, @NonNull Button button9, @NonNull Button button10, @NonNull CheckBox checkBox2, @NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull SeekBar seekBar) {
        this.f11005a = linearLayout;
        this.blockNextActions = checkBox;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configInputOutputParams1 = button2;
        this.configInputOutputParams2 = button3;
        this.configInputOutputParams3 = button4;
        this.configureOptionDialog1 = appCompatEditText;
        this.configureOptionDialog2 = appCompatEditText2;
        this.configureOptionDialog3 = appCompatEditText3;
        this.configureOptionDialogMessage = appCompatEditText4;
        this.configureOptionDialogSpinner1 = spinner;
        this.configureOptionDialogSpinner2 = spinner2;
        this.configureOptionDialogSpinner3 = spinner3;
        this.configureOptionDialogTitle = appCompatEditText5;
        this.defaultOptionSpinner = spinner4;
        this.okButton = button5;
        this.optionDialogButton1MagicTextButton = button6;
        this.optionDialogButton2MagicTextButton = button7;
        this.optionDialogButton3MagicTextButton = button8;
        this.optionDialogMessageMagicTextButton = button9;
        this.optionDialogTitleMagicTextButton = button10;
        this.preventBackButtonCheckbox = checkBox2;
        this.scrollView = scrollView;
        this.secondsValue = textView;
        this.timeoutOptions = linearLayout3;
        this.timeoutSeekbar = seekBar;
    }

    @NonNull
    public static ConfigureOptionDialogBinding bind(@NonNull View view) {
        int i4 = R.id.block_next_actions;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.block_next_actions);
        if (checkBox != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.configInputOutputParams1;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams1);
                    if (button2 != null) {
                        i4 = R.id.configInputOutputParams2;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams2);
                        if (button3 != null) {
                            i4 = R.id.configInputOutputParams3;
                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams3);
                            if (button4 != null) {
                                i4 = R.id.configure_option_dialog_1;
                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_1);
                                if (appCompatEditText != null) {
                                    i4 = R.id.configure_option_dialog_2;
                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_2);
                                    if (appCompatEditText2 != null) {
                                        i4 = R.id.configure_option_dialog_3;
                                        AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_3);
                                        if (appCompatEditText3 != null) {
                                            i4 = R.id.configure_option_dialog_message;
                                            AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_message);
                                            if (appCompatEditText4 != null) {
                                                i4 = R.id.configure_option_dialog_spinner_1;
                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_spinner_1);
                                                if (spinner != null) {
                                                    i4 = R.id.configure_option_dialog_spinner_2;
                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_spinner_2);
                                                    if (spinner2 != null) {
                                                        i4 = R.id.configure_option_dialog_spinner_3;
                                                        Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_spinner_3);
                                                        if (spinner3 != null) {
                                                            i4 = R.id.configure_option_dialog_title;
                                                            AppCompatEditText appCompatEditText5 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_option_dialog_title);
                                                            if (appCompatEditText5 != null) {
                                                                i4 = R.id.default_option_spinner;
                                                                Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.default_option_spinner);
                                                                if (spinner4 != null) {
                                                                    i4 = R.id.okButton;
                                                                    Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                    if (button5 != null) {
                                                                        i4 = R.id.option_dialog_button1_magic_text_button;
                                                                        Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.option_dialog_button1_magic_text_button);
                                                                        if (button6 != null) {
                                                                            i4 = R.id.option_dialog_button2_magic_text_button;
                                                                            Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.option_dialog_button2_magic_text_button);
                                                                            if (button7 != null) {
                                                                                i4 = R.id.option_dialog_button3_magic_text_button;
                                                                                Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.option_dialog_button3_magic_text_button);
                                                                                if (button8 != null) {
                                                                                    i4 = R.id.option_dialog_message_magic_text_button;
                                                                                    Button button9 = (Button) ViewBindings.findChildViewById(view, R.id.option_dialog_message_magic_text_button);
                                                                                    if (button9 != null) {
                                                                                        i4 = R.id.option_dialog_title_magic_text_button;
                                                                                        Button button10 = (Button) ViewBindings.findChildViewById(view, R.id.option_dialog_title_magic_text_button);
                                                                                        if (button10 != null) {
                                                                                            i4 = R.id.prevent_back_button_checkbox;
                                                                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_back_button_checkbox);
                                                                                            if (checkBox2 != null) {
                                                                                                i4 = R.id.scroll_view;
                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                                                                                if (scrollView != null) {
                                                                                                    i4 = R.id.seconds_value;
                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.seconds_value);
                                                                                                    if (textView != null) {
                                                                                                        i4 = R.id.timeout_options;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.timeout_options);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i4 = R.id.timeout_seekbar;
                                                                                                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.timeout_seekbar);
                                                                                                            if (seekBar != null) {
                                                                                                                return new ConfigureOptionDialogBinding((LinearLayout) view, checkBox, linearLayout, button, button2, button3, button4, appCompatEditText, appCompatEditText2, appCompatEditText3, appCompatEditText4, spinner, spinner2, spinner3, appCompatEditText5, spinner4, button5, button6, button7, button8, button9, button10, checkBox2, scrollView, textView, linearLayout2, seekBar);
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
    public static ConfigureOptionDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureOptionDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_option_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11005a;
    }
}
