package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
import com.google.android.material.textfield.TextInputLayout;
import com.melnykov.fab.FloatingActionButton;

/* loaded from: classes3.dex */
public final class DialogFloatingButtonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11066a;
    @NonNull
    public final TextView alphaPercentText;
    @NonNull
    public final LinearLayout brightnessBarLayout;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Spinner disableOptionsSpinner;
    @NonNull
    public final TextInputLayout editableIdentifier;
    @NonNull
    public final Spinner enabledStateOptions;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final SeekBar floatingButtonAlphaSeekbar;
    @NonNull
    public final Button floatingButtonChangeBackground;
    @NonNull
    public final Button floatingButtonChangeIcon;
    @NonNull
    public final ImageView floatingButtonImage;
    @NonNull
    public final CheckBox forceLocationOnEnable;
    @NonNull
    public final LinearLayout iconPaddingLayout;
    @NonNull
    public final EditText identifierText;
    @NonNull
    public final RadioButton miniSize;
    @NonNull
    public final RadioButton normalSize;
    @NonNull
    public final Button okButton;
    @NonNull
    public final SeekBar paddingSeekbar;
    @NonNull
    public final TextView paddingValueText;
    @NonNull
    public final CheckBox preventRemovalByBin;
    @NonNull
    public final RadioButton radioButtonPercent;
    @NonNull
    public final RadioButton radioButtonPixels;
    @NonNull
    public final CheckBox showOnLockScreen;
    @NonNull
    public final TextView staticIdentifier;
    @NonNull
    public final CheckBox transparentBackgroundCheckbox;
    @NonNull
    public final AppCompatEditText xLocation;
    @NonNull
    public final AppCompatEditText yLocation;

    private DialogFloatingButtonBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Spinner spinner, @NonNull TextInputLayout textInputLayout, @NonNull Spinner spinner2, @NonNull FloatingActionButton floatingActionButton, @NonNull SeekBar seekBar, @NonNull Button button2, @NonNull Button button3, @NonNull ImageView imageView, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout3, @NonNull EditText editText, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull Button button4, @NonNull SeekBar seekBar2, @NonNull TextView textView2, @NonNull CheckBox checkBox2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull CheckBox checkBox3, @NonNull TextView textView3, @NonNull CheckBox checkBox4, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11066a = scrollView;
        this.alphaPercentText = textView;
        this.brightnessBarLayout = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.disableOptionsSpinner = spinner;
        this.editableIdentifier = textInputLayout;
        this.enabledStateOptions = spinner2;
        this.fab = floatingActionButton;
        this.floatingButtonAlphaSeekbar = seekBar;
        this.floatingButtonChangeBackground = button2;
        this.floatingButtonChangeIcon = button3;
        this.floatingButtonImage = imageView;
        this.forceLocationOnEnable = checkBox;
        this.iconPaddingLayout = linearLayout3;
        this.identifierText = editText;
        this.miniSize = radioButton;
        this.normalSize = radioButton2;
        this.okButton = button4;
        this.paddingSeekbar = seekBar2;
        this.paddingValueText = textView2;
        this.preventRemovalByBin = checkBox2;
        this.radioButtonPercent = radioButton3;
        this.radioButtonPixels = radioButton4;
        this.showOnLockScreen = checkBox3;
        this.staticIdentifier = textView3;
        this.transparentBackgroundCheckbox = checkBox4;
        this.xLocation = appCompatEditText;
        this.yLocation = appCompatEditText2;
    }

    @NonNull
    public static DialogFloatingButtonBinding bind(@NonNull View view) {
        int i4 = R.id.alpha_percent_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.alpha_percent_text);
        if (textView != null) {
            i4 = R.id.brightness_bar_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.brightness_bar_layout);
            if (linearLayout != null) {
                i4 = R.id.button_bar;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                if (linearLayout2 != null) {
                    i4 = R.id.cancelButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                    if (button != null) {
                        i4 = R.id.disable_options_spinner;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.disable_options_spinner);
                        if (spinner != null) {
                            i4 = R.id.editable_identifier;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.editable_identifier);
                            if (textInputLayout != null) {
                                i4 = R.id.enabled_state_options;
                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.enabled_state_options);
                                if (spinner2 != null) {
                                    i4 = R.id.fab;
                                    FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
                                    if (floatingActionButton != null) {
                                        i4 = R.id.floating_button_alpha_seekbar;
                                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.floating_button_alpha_seekbar);
                                        if (seekBar != null) {
                                            i4 = R.id.floating_button_change_background;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.floating_button_change_background);
                                            if (button2 != null) {
                                                i4 = R.id.floating_button_change_icon;
                                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.floating_button_change_icon);
                                                if (button3 != null) {
                                                    i4 = R.id.floating_button_image;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.floating_button_image);
                                                    if (imageView != null) {
                                                        i4 = R.id.force_location_on_enable;
                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_location_on_enable);
                                                        if (checkBox != null) {
                                                            i4 = R.id.icon_padding_layout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.icon_padding_layout);
                                                            if (linearLayout3 != null) {
                                                                i4 = R.id.identifier_text;
                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.identifier_text);
                                                                if (editText != null) {
                                                                    i4 = R.id.mini_size;
                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.mini_size);
                                                                    if (radioButton != null) {
                                                                        i4 = R.id.normal_size;
                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.normal_size);
                                                                        if (radioButton2 != null) {
                                                                            i4 = R.id.okButton;
                                                                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                            if (button4 != null) {
                                                                                i4 = R.id.padding_seekbar;
                                                                                SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.padding_seekbar);
                                                                                if (seekBar2 != null) {
                                                                                    i4 = R.id.padding_value_text;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.padding_value_text);
                                                                                    if (textView2 != null) {
                                                                                        i4 = R.id.prevent_removal_by_bin;
                                                                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_removal_by_bin);
                                                                                        if (checkBox2 != null) {
                                                                                            i4 = R.id.radioButtonPercent;
                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPercent);
                                                                                            if (radioButton3 != null) {
                                                                                                i4 = R.id.radioButtonPixels;
                                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPixels);
                                                                                                if (radioButton4 != null) {
                                                                                                    i4 = R.id.show_on_lock_screen;
                                                                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.show_on_lock_screen);
                                                                                                    if (checkBox3 != null) {
                                                                                                        i4 = R.id.static_identifier;
                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.static_identifier);
                                                                                                        if (textView3 != null) {
                                                                                                            i4 = R.id.transparent_background_checkbox;
                                                                                                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.transparent_background_checkbox);
                                                                                                            if (checkBox4 != null) {
                                                                                                                i4 = R.id.x_location;
                                                                                                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.x_location);
                                                                                                                if (appCompatEditText != null) {
                                                                                                                    i4 = R.id.y_location;
                                                                                                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.y_location);
                                                                                                                    if (appCompatEditText2 != null) {
                                                                                                                        return new DialogFloatingButtonBinding((ScrollView) view, textView, linearLayout, linearLayout2, button, spinner, textInputLayout, spinner2, floatingActionButton, seekBar, button2, button3, imageView, checkBox, linearLayout3, editText, radioButton, radioButton2, button4, seekBar2, textView2, checkBox2, radioButton3, radioButton4, checkBox3, textView3, checkBox4, appCompatEditText, appCompatEditText2);
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
    public static DialogFloatingButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFloatingButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_floating_button, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11066a;
    }
}
