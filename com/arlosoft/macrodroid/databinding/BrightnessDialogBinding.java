package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class BrightnessDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f10991a;
    @NonNull
    public final LinearLayout brightnessBarLayout;
    @NonNull
    public final SwitchCompat brightnessDialogAutoSwitch;
    @NonNull
    public final SeekBar brightnessDialogSeekBar;
    @NonNull
    public final LinearLayout brightnessDialogValuesLayout;
    @NonNull
    public final TextView brightnessPercentText;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox forceValueCheckbox;
    @NonNull
    public final TextView forceValueDescription;
    @NonNull
    public final EditText forceValueValue;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox useAndroidPieCheckbox;
    @NonNull
    public final TextView useAndroidPieText;
    @NonNull
    public final NDSpinner variablesSpinner;

    private BrightnessDialogBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull SwitchCompat switchCompat, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull TextView textView2, @NonNull EditText editText, @NonNull Button button2, @NonNull CheckBox checkBox2, @NonNull TextView textView3, @NonNull NDSpinner nDSpinner) {
        this.f10991a = scrollView;
        this.brightnessBarLayout = linearLayout;
        this.brightnessDialogAutoSwitch = switchCompat;
        this.brightnessDialogSeekBar = seekBar;
        this.brightnessDialogValuesLayout = linearLayout2;
        this.brightnessPercentText = textView;
        this.cancelButton = button;
        this.forceValueCheckbox = checkBox;
        this.forceValueDescription = textView2;
        this.forceValueValue = editText;
        this.okButton = button2;
        this.useAndroidPieCheckbox = checkBox2;
        this.useAndroidPieText = textView3;
        this.variablesSpinner = nDSpinner;
    }

    @NonNull
    public static BrightnessDialogBinding bind(@NonNull View view) {
        int i4 = R.id.brightness_bar_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.brightness_bar_layout);
        if (linearLayout != null) {
            i4 = R.id.brightness_dialog_auto_switch;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.brightness_dialog_auto_switch);
            if (switchCompat != null) {
                i4 = R.id.brightness_dialog_seek_bar;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.brightness_dialog_seek_bar);
                if (seekBar != null) {
                    i4 = R.id.brightness_dialog_values_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.brightness_dialog_values_layout);
                    if (linearLayout2 != null) {
                        i4 = R.id.brightness_percent_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.brightness_percent_text);
                        if (textView != null) {
                            i4 = R.id.cancelButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                            if (button != null) {
                                i4 = R.id.force_value_checkbox;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_value_checkbox);
                                if (checkBox != null) {
                                    i4 = R.id.force_value_description;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.force_value_description);
                                    if (textView2 != null) {
                                        i4 = R.id.force_value_value;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.force_value_value);
                                        if (editText != null) {
                                            i4 = R.id.okButton;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                            if (button2 != null) {
                                                i4 = R.id.use_android_pie_checkbox;
                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.use_android_pie_checkbox);
                                                if (checkBox2 != null) {
                                                    i4 = R.id.use_android_pie_text;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.use_android_pie_text);
                                                    if (textView3 != null) {
                                                        i4 = R.id.variablesSpinner;
                                                        NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variablesSpinner);
                                                        if (nDSpinner != null) {
                                                            return new BrightnessDialogBinding((ScrollView) view, linearLayout, switchCompat, seekBar, linearLayout2, textView, button, checkBox, textView2, editText, button2, checkBox2, textView3, nDSpinner);
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
    public static BrightnessDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BrightnessDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.brightness_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f10991a;
    }
}
