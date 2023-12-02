package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogFloatingTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11067a;
    @NonNull
    public final TextView alphaPercentText;
    @NonNull
    public final SeekBar alphaSeekbar;
    @NonNull
    public final EditText autoHideDelayText;
    @NonNull
    public final LinearLayout autoHideValueLayout;
    @NonNull
    public final CheckBox autoTimeOutAfterSeconds;
    @NonNull
    public final MaterialCardView bgColorCircle;
    @NonNull
    public final LinearLayout brightnessBarLayout;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ImageButton centerJustifyButton;
    @NonNull
    public final Button changeBackgroundColour;
    @NonNull
    public final Button changeTextColour;
    @NonNull
    public final SeekBar cornersSeekbar;
    @NonNull
    public final TextView cornersValueText;
    @NonNull
    public final EditText displayText;
    @NonNull
    public final TextInputLayout editableIdentifier;
    @NonNull
    public final Spinner enabledStateOptions;
    @NonNull
    public final CheckBox forceLocationOnEnable;
    @NonNull
    public final RadioButton hideAllRadioButton;
    @NonNull
    public final RadioButton hideRadioButton;
    @NonNull
    public final TextView horizontalPercent;
    @NonNull
    public final SeekBar horizontalPositionSeekBar;
    @NonNull
    public final CheckBox htmlFormattingOption;
    @NonNull
    public final LinearLayout identifierLayout;
    @NonNull
    public final EditText identifierText;
    @NonNull
    public final ImageButton leftJustifyButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button magicTextIdentifierButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final SeekBar paddingSeekbar;
    @NonNull
    public final TextView paddingValueText;
    @NonNull
    public final CheckBox preventRemovalByBin;
    @NonNull
    public final TextView previewText;
    @NonNull
    public final ImageButton rightJustifyButton;
    @NonNull
    public final LinearLayout showConfigLayout;
    @NonNull
    public final CheckBox showOverStatusBar;
    @NonNull
    public final RadioButton showRadioButton;
    @NonNull
    public final LinearLayout sizeBarLayout;
    @NonNull
    public final SeekBar sizeSeekbar;
    @NonNull
    public final TextView sizeValue;
    @NonNull
    public final TextView staticIdentifier;
    @NonNull
    public final MaterialCardView textColorCircle;
    @NonNull
    public final TextView textPosition;
    @NonNull
    public final TextView verticalPercent;
    @NonNull
    public final SeekBar verticalPositionSeekBar;

    private DialogFloatingTextBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull EditText editText, @NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull Button button, @NonNull ImageButton imageButton, @NonNull Button button2, @NonNull Button button3, @NonNull SeekBar seekBar2, @NonNull TextView textView2, @NonNull EditText editText2, @NonNull TextInputLayout textInputLayout, @NonNull Spinner spinner, @NonNull CheckBox checkBox2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull TextView textView3, @NonNull SeekBar seekBar3, @NonNull CheckBox checkBox3, @NonNull LinearLayout linearLayout4, @NonNull EditText editText3, @NonNull ImageButton imageButton2, @NonNull Button button4, @NonNull Button button5, @NonNull Button button6, @NonNull SeekBar seekBar4, @NonNull TextView textView4, @NonNull CheckBox checkBox4, @NonNull TextView textView5, @NonNull ImageButton imageButton3, @NonNull LinearLayout linearLayout5, @NonNull CheckBox checkBox5, @NonNull RadioButton radioButton3, @NonNull LinearLayout linearLayout6, @NonNull SeekBar seekBar5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull SeekBar seekBar6) {
        this.f11067a = scrollView;
        this.alphaPercentText = textView;
        this.alphaSeekbar = seekBar;
        this.autoHideDelayText = editText;
        this.autoHideValueLayout = linearLayout;
        this.autoTimeOutAfterSeconds = checkBox;
        this.bgColorCircle = materialCardView;
        this.brightnessBarLayout = linearLayout2;
        this.buttonBar = linearLayout3;
        this.cancelButton = button;
        this.centerJustifyButton = imageButton;
        this.changeBackgroundColour = button2;
        this.changeTextColour = button3;
        this.cornersSeekbar = seekBar2;
        this.cornersValueText = textView2;
        this.displayText = editText2;
        this.editableIdentifier = textInputLayout;
        this.enabledStateOptions = spinner;
        this.forceLocationOnEnable = checkBox2;
        this.hideAllRadioButton = radioButton;
        this.hideRadioButton = radioButton2;
        this.horizontalPercent = textView3;
        this.horizontalPositionSeekBar = seekBar3;
        this.htmlFormattingOption = checkBox3;
        this.identifierLayout = linearLayout4;
        this.identifierText = editText3;
        this.leftJustifyButton = imageButton2;
        this.magicTextButton = button4;
        this.magicTextIdentifierButton = button5;
        this.okButton = button6;
        this.paddingSeekbar = seekBar4;
        this.paddingValueText = textView4;
        this.preventRemovalByBin = checkBox4;
        this.previewText = textView5;
        this.rightJustifyButton = imageButton3;
        this.showConfigLayout = linearLayout5;
        this.showOverStatusBar = checkBox5;
        this.showRadioButton = radioButton3;
        this.sizeBarLayout = linearLayout6;
        this.sizeSeekbar = seekBar5;
        this.sizeValue = textView6;
        this.staticIdentifier = textView7;
        this.textColorCircle = materialCardView2;
        this.textPosition = textView8;
        this.verticalPercent = textView9;
        this.verticalPositionSeekBar = seekBar6;
    }

    @NonNull
    public static DialogFloatingTextBinding bind(@NonNull View view) {
        int i4 = R.id.alpha_percent_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.alpha_percent_text);
        if (textView != null) {
            i4 = R.id.alpha_seekbar;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.alpha_seekbar);
            if (seekBar != null) {
                i4 = R.id.auto_hide_delay_text;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.auto_hide_delay_text);
                if (editText != null) {
                    i4 = R.id.auto_hide_value_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.auto_hide_value_layout);
                    if (linearLayout != null) {
                        i4 = R.id.auto_time_out_after_seconds;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.auto_time_out_after_seconds);
                        if (checkBox != null) {
                            i4 = R.id.bg_color_circle;
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.bg_color_circle);
                            if (materialCardView != null) {
                                i4 = R.id.brightness_bar_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.brightness_bar_layout);
                                if (linearLayout2 != null) {
                                    i4 = R.id.button_bar;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                                    if (linearLayout3 != null) {
                                        i4 = R.id.cancelButton;
                                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                                        if (button != null) {
                                            i4 = R.id.centerJustifyButton;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.centerJustifyButton);
                                            if (imageButton != null) {
                                                i4 = R.id.change_background_colour;
                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.change_background_colour);
                                                if (button2 != null) {
                                                    i4 = R.id.change_text_colour;
                                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.change_text_colour);
                                                    if (button3 != null) {
                                                        i4 = R.id.corners_seekbar;
                                                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.corners_seekbar);
                                                        if (seekBar2 != null) {
                                                            i4 = R.id.corners_value_text;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.corners_value_text);
                                                            if (textView2 != null) {
                                                                i4 = R.id.display_text;
                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.display_text);
                                                                if (editText2 != null) {
                                                                    i4 = R.id.editable_identifier;
                                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.editable_identifier);
                                                                    if (textInputLayout != null) {
                                                                        i4 = R.id.enabled_state_options;
                                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.enabled_state_options);
                                                                        if (spinner != null) {
                                                                            i4 = R.id.force_location_on_enable;
                                                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_location_on_enable);
                                                                            if (checkBox2 != null) {
                                                                                i4 = R.id.hide_all_radio_button;
                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.hide_all_radio_button);
                                                                                if (radioButton != null) {
                                                                                    i4 = R.id.hide_radio_button;
                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.hide_radio_button);
                                                                                    if (radioButton2 != null) {
                                                                                        i4 = R.id.horizontal_percent;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.horizontal_percent);
                                                                                        if (textView3 != null) {
                                                                                            i4 = R.id.horizontal_position_seek_bar;
                                                                                            SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view, R.id.horizontal_position_seek_bar);
                                                                                            if (seekBar3 != null) {
                                                                                                i4 = R.id.html_formatting_option;
                                                                                                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.html_formatting_option);
                                                                                                if (checkBox3 != null) {
                                                                                                    i4 = R.id.identifier_layout;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.identifier_layout);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i4 = R.id.identifier_text;
                                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.identifier_text);
                                                                                                        if (editText3 != null) {
                                                                                                            i4 = R.id.leftJustifyButton;
                                                                                                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.leftJustifyButton);
                                                                                                            if (imageButton2 != null) {
                                                                                                                i4 = R.id.magic_text_button;
                                                                                                                Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                                                                                                                if (button4 != null) {
                                                                                                                    i4 = R.id.magic_text_identifier_button;
                                                                                                                    Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_identifier_button);
                                                                                                                    if (button5 != null) {
                                                                                                                        i4 = R.id.okButton;
                                                                                                                        Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                                                                        if (button6 != null) {
                                                                                                                            i4 = R.id.padding_seekbar;
                                                                                                                            SeekBar seekBar4 = (SeekBar) ViewBindings.findChildViewById(view, R.id.padding_seekbar);
                                                                                                                            if (seekBar4 != null) {
                                                                                                                                i4 = R.id.padding_value_text;
                                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.padding_value_text);
                                                                                                                                if (textView4 != null) {
                                                                                                                                    i4 = R.id.prevent_removal_by_bin;
                                                                                                                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_removal_by_bin);
                                                                                                                                    if (checkBox4 != null) {
                                                                                                                                        i4 = R.id.previewText;
                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.previewText);
                                                                                                                                        if (textView5 != null) {
                                                                                                                                            i4 = R.id.rightJustifyButton;
                                                                                                                                            ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.rightJustifyButton);
                                                                                                                                            if (imageButton3 != null) {
                                                                                                                                                i4 = R.id.show_config_layout;
                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.show_config_layout);
                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                    i4 = R.id.show_over_status_bar;
                                                                                                                                                    CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.show_over_status_bar);
                                                                                                                                                    if (checkBox5 != null) {
                                                                                                                                                        i4 = R.id.show_radio_button;
                                                                                                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.show_radio_button);
                                                                                                                                                        if (radioButton3 != null) {
                                                                                                                                                            i4 = R.id.size_bar_layout;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.size_bar_layout);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i4 = R.id.size_seekbar;
                                                                                                                                                                SeekBar seekBar5 = (SeekBar) ViewBindings.findChildViewById(view, R.id.size_seekbar);
                                                                                                                                                                if (seekBar5 != null) {
                                                                                                                                                                    i4 = R.id.size_value;
                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.size_value);
                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                        i4 = R.id.static_identifier;
                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.static_identifier);
                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                            i4 = R.id.text_color_circle;
                                                                                                                                                                            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.text_color_circle);
                                                                                                                                                                            if (materialCardView2 != null) {
                                                                                                                                                                                i4 = R.id.text_position;
                                                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.text_position);
                                                                                                                                                                                if (textView8 != null) {
                                                                                                                                                                                    i4 = R.id.vertical_percent;
                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.vertical_percent);
                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                        i4 = R.id.vertical_position_seek_bar;
                                                                                                                                                                                        SeekBar seekBar6 = (SeekBar) ViewBindings.findChildViewById(view, R.id.vertical_position_seek_bar);
                                                                                                                                                                                        if (seekBar6 != null) {
                                                                                                                                                                                            return new DialogFloatingTextBinding((ScrollView) view, textView, seekBar, editText, linearLayout, checkBox, materialCardView, linearLayout2, linearLayout3, button, imageButton, button2, button3, seekBar2, textView2, editText2, textInputLayout, spinner, checkBox2, radioButton, radioButton2, textView3, seekBar3, checkBox3, linearLayout4, editText3, imageButton2, button4, button5, button6, seekBar4, textView4, checkBox4, textView5, imageButton3, linearLayout5, checkBox5, radioButton3, linearLayout6, seekBar5, textView6, textView7, materialCardView2, textView8, textView9, seekBar6);
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
    public static DialogFloatingTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFloatingTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_floating_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11067a;
    }
}
