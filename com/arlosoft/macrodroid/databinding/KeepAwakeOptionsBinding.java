package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class KeepAwakeOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11284a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final NumberPicker keepAwakeOptionsHourPicker;
    @NonNull
    public final NumberPicker keepAwakeOptionsMinutePicker;
    @NonNull
    public final Spinner keepAwakeOptionsScreenSetting;
    @NonNull
    public final NumberPicker keepAwakeOptionsSecondPicker;
    @NonNull
    public final Spinner keepAwakeOptionsTimeSetting;
    @NonNull
    public final Button okButton;
    @NonNull
    public final ScrollView scrollView1;

    private KeepAwakeOptionsBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull Spinner spinner, @NonNull NumberPicker numberPicker3, @NonNull Spinner spinner2, @NonNull Button button2, @NonNull ScrollView scrollView2) {
        this.f11284a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.keepAwakeOptionsHourPicker = numberPicker;
        this.keepAwakeOptionsMinutePicker = numberPicker2;
        this.keepAwakeOptionsScreenSetting = spinner;
        this.keepAwakeOptionsSecondPicker = numberPicker3;
        this.keepAwakeOptionsTimeSetting = spinner2;
        this.okButton = button2;
        this.scrollView1 = scrollView2;
    }

    @NonNull
    public static KeepAwakeOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.keep_awake_options_hour_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.keep_awake_options_hour_picker);
                if (numberPicker != null) {
                    i4 = R.id.keep_awake_options_minute_picker;
                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.keep_awake_options_minute_picker);
                    if (numberPicker2 != null) {
                        i4 = R.id.keep_awake_options_screen_setting;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.keep_awake_options_screen_setting);
                        if (spinner != null) {
                            i4 = R.id.keep_awake_options_second_picker;
                            NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.keep_awake_options_second_picker);
                            if (numberPicker3 != null) {
                                i4 = R.id.keep_awake_options_time_setting;
                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.keep_awake_options_time_setting);
                                if (spinner2 != null) {
                                    i4 = R.id.okButton;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                    if (button2 != null) {
                                        ScrollView scrollView = (ScrollView) view;
                                        return new KeepAwakeOptionsBinding(scrollView, linearLayout, button, numberPicker, numberPicker2, spinner, numberPicker3, spinner2, button2, scrollView);
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
    public static KeepAwakeOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static KeepAwakeOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.keep_awake_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11284a;
    }
}
