package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConfigureConfirmNextDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f10997a;
    @NonNull
    public final CheckBox cancelAfterTimeoutCheckbox;
    @NonNull
    public final AppCompatEditText configureConfirmNextDialogMessage;
    @NonNull
    public final AppCompatEditText configureConfirmNextDialogTitle;
    @NonNull
    public final AppCompatEditText configureConfirmNextNegativeText;
    @NonNull
    public final AppCompatEditText configureConfirmNextPositiveText;
    @NonNull
    public final Button confirmNextMessageMagicTextButton;
    @NonNull
    public final Button confirmNextMessageNegativeTextButton;
    @NonNull
    public final Button confirmNextMessagePositiveTextButton;
    @NonNull
    public final Button confirmNextTitleMagicTextButton;
    @NonNull
    public final CheckBox quitOnBackCheckbox;
    @NonNull
    public final TextView secondsValue;
    @NonNull
    public final LinearLayout timeoutOptions;
    @NonNull
    public final SeekBar timeoutSeekbar;

    private ConfigureConfirmNextDialogBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull AppCompatEditText appCompatEditText4, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull CheckBox checkBox2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull SeekBar seekBar) {
        this.f10997a = scrollView;
        this.cancelAfterTimeoutCheckbox = checkBox;
        this.configureConfirmNextDialogMessage = appCompatEditText;
        this.configureConfirmNextDialogTitle = appCompatEditText2;
        this.configureConfirmNextNegativeText = appCompatEditText3;
        this.configureConfirmNextPositiveText = appCompatEditText4;
        this.confirmNextMessageMagicTextButton = button;
        this.confirmNextMessageNegativeTextButton = button2;
        this.confirmNextMessagePositiveTextButton = button3;
        this.confirmNextTitleMagicTextButton = button4;
        this.quitOnBackCheckbox = checkBox2;
        this.secondsValue = textView;
        this.timeoutOptions = linearLayout;
        this.timeoutSeekbar = seekBar;
    }

    @NonNull
    public static ConfigureConfirmNextDialogBinding bind(@NonNull View view) {
        int i4 = R.id.cancelAfterTimeoutCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cancelAfterTimeoutCheckbox);
        if (checkBox != null) {
            i4 = R.id.configure_confirm_next_dialog_message;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_confirm_next_dialog_message);
            if (appCompatEditText != null) {
                i4 = R.id.configure_confirm_next_dialog_title;
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_confirm_next_dialog_title);
                if (appCompatEditText2 != null) {
                    i4 = R.id.configure_confirm_next_negative_text;
                    AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_confirm_next_negative_text);
                    if (appCompatEditText3 != null) {
                        i4 = R.id.configure_confirm_next_positive_text;
                        AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_confirm_next_positive_text);
                        if (appCompatEditText4 != null) {
                            i4 = R.id.confirm_next_message_magic_text_button;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.confirm_next_message_magic_text_button);
                            if (button != null) {
                                i4 = R.id.confirm_next_message_negative_text_button;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.confirm_next_message_negative_text_button);
                                if (button2 != null) {
                                    i4 = R.id.confirm_next_message_positive_text_button;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.confirm_next_message_positive_text_button);
                                    if (button3 != null) {
                                        i4 = R.id.confirm_next_title_magic_text_button;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.confirm_next_title_magic_text_button);
                                        if (button4 != null) {
                                            i4 = R.id.quitOnBackCheckbox;
                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.quitOnBackCheckbox);
                                            if (checkBox2 != null) {
                                                i4 = R.id.seconds_value;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.seconds_value);
                                                if (textView != null) {
                                                    i4 = R.id.timeout_options;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.timeout_options);
                                                    if (linearLayout != null) {
                                                        i4 = R.id.timeout_seekbar;
                                                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.timeout_seekbar);
                                                        if (seekBar != null) {
                                                            return new ConfigureConfirmNextDialogBinding((ScrollView) view, checkBox, appCompatEditText, appCompatEditText2, appCompatEditText3, appCompatEditText4, button, button2, button3, button4, checkBox2, textView, linearLayout, seekBar);
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
    public static ConfigureConfirmNextDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureConfirmNextDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_confirm_next_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f10997a;
    }
}
