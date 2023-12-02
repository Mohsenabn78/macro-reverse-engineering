package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
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
public final class SpeakActionConfigDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11377a;
    @NonNull
    public final Spinner audioStream;
    @NonNull
    public final Spinner languageToSpeak;
    @NonNull
    public final ImageView languageToSpeakHelp;
    @NonNull
    public final TextView pitchValue;
    @NonNull
    public final Button speakActionConfigDialogButtonSpecialText;
    @NonNull
    public final Button speakActionConfigDialogButtonTest;
    @NonNull
    public final SeekBar speakActionConfigDialogPitchSeekbar;
    @NonNull
    public final CheckBox speakActionConfigDialogQueueCheckbox;
    @NonNull
    public final SeekBar speakActionConfigDialogSpeedSeekbar;
    @NonNull
    public final AppCompatEditText speakActionConfigDialogTextToSay;
    @NonNull
    public final CheckBox speakActionConfigDialogWaitCheckbox;
    @NonNull
    public final CheckBox speakDigitsIndividuallyCheckbox;
    @NonNull
    public final TextView speedValue;
    @NonNull
    public final TextView ttsEngineLink;
    @NonNull
    public final TextView ttsSettingsLink;

    private SpeakActionConfigDialogBinding(@NonNull ScrollView scrollView, @NonNull Spinner spinner, @NonNull Spinner spinner2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull Button button, @NonNull Button button2, @NonNull SeekBar seekBar, @NonNull CheckBox checkBox, @NonNull SeekBar seekBar2, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11377a = scrollView;
        this.audioStream = spinner;
        this.languageToSpeak = spinner2;
        this.languageToSpeakHelp = imageView;
        this.pitchValue = textView;
        this.speakActionConfigDialogButtonSpecialText = button;
        this.speakActionConfigDialogButtonTest = button2;
        this.speakActionConfigDialogPitchSeekbar = seekBar;
        this.speakActionConfigDialogQueueCheckbox = checkBox;
        this.speakActionConfigDialogSpeedSeekbar = seekBar2;
        this.speakActionConfigDialogTextToSay = appCompatEditText;
        this.speakActionConfigDialogWaitCheckbox = checkBox2;
        this.speakDigitsIndividuallyCheckbox = checkBox3;
        this.speedValue = textView2;
        this.ttsEngineLink = textView3;
        this.ttsSettingsLink = textView4;
    }

    @NonNull
    public static SpeakActionConfigDialogBinding bind(@NonNull View view) {
        int i4 = R.id.audio_stream;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.audio_stream);
        if (spinner != null) {
            i4 = R.id.language_to_speak;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.language_to_speak);
            if (spinner2 != null) {
                i4 = R.id.language_to_speak_help;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.language_to_speak_help);
                if (imageView != null) {
                    i4 = R.id.pitch_value;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pitch_value);
                    if (textView != null) {
                        i4 = R.id.speak_action_config_dialog_button_special_text;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_button_special_text);
                        if (button != null) {
                            i4 = R.id.speak_action_config_dialog_button_test;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_button_test);
                            if (button2 != null) {
                                i4 = R.id.speak_action_config_dialog_pitch_seekbar;
                                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_pitch_seekbar);
                                if (seekBar != null) {
                                    i4 = R.id.speak_action_config_dialog_queue_checkbox;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_queue_checkbox);
                                    if (checkBox != null) {
                                        i4 = R.id.speak_action_config_dialog_speed_seekbar;
                                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_speed_seekbar);
                                        if (seekBar2 != null) {
                                            i4 = R.id.speak_action_config_dialog_text_to_say;
                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_text_to_say);
                                            if (appCompatEditText != null) {
                                                i4 = R.id.speak_action_config_dialog_wait_checkbox;
                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.speak_action_config_dialog_wait_checkbox);
                                                if (checkBox2 != null) {
                                                    i4 = R.id.speak_digits_individually_checkbox;
                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.speak_digits_individually_checkbox);
                                                    if (checkBox3 != null) {
                                                        i4 = R.id.speed_value;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.speed_value);
                                                        if (textView2 != null) {
                                                            i4 = R.id.ttsEngineLink;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.ttsEngineLink);
                                                            if (textView3 != null) {
                                                                i4 = R.id.ttsSettingsLink;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ttsSettingsLink);
                                                                if (textView4 != null) {
                                                                    return new SpeakActionConfigDialogBinding((ScrollView) view, spinner, spinner2, imageView, textView, button, button2, seekBar, checkBox, seekBar2, appCompatEditText, checkBox2, checkBox3, textView2, textView3, textView4);
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
    public static SpeakActionConfigDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SpeakActionConfigDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.speak_action_config_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11377a;
    }
}
