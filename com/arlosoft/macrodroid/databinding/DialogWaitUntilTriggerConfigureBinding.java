package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class DialogWaitUntilTriggerConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11162a;
    @NonNull
    public final NumberPicker hourPicker;
    @NonNull
    public final NumberPicker minutePicker;
    @NonNull
    public final RadioButton radioCancelTimeout;
    @NonNull
    public final RadioButton radioContinueTimeout;
    @NonNull
    public final RadioButton radioNoTimeout;
    @NonNull
    public final NumberPicker secondPicker;
    @NonNull
    public final TableLayout timepickerLayout;

    private DialogWaitUntilTriggerConfigureBinding(@NonNull ScrollView scrollView, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull NumberPicker numberPicker3, @NonNull TableLayout tableLayout) {
        this.f11162a = scrollView;
        this.hourPicker = numberPicker;
        this.minutePicker = numberPicker2;
        this.radioCancelTimeout = radioButton;
        this.radioContinueTimeout = radioButton2;
        this.radioNoTimeout = radioButton3;
        this.secondPicker = numberPicker3;
        this.timepickerLayout = tableLayout;
    }

    @NonNull
    public static DialogWaitUntilTriggerConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.hour_picker;
        NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.hour_picker);
        if (numberPicker != null) {
            i4 = R.id.minute_picker;
            NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.minute_picker);
            if (numberPicker2 != null) {
                i4 = R.id.radio_cancel_timeout;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_cancel_timeout);
                if (radioButton != null) {
                    i4 = R.id.radio_continue_timeout;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_continue_timeout);
                    if (radioButton2 != null) {
                        i4 = R.id.radio_no_timeout;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_no_timeout);
                        if (radioButton3 != null) {
                            i4 = R.id.second_picker;
                            NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.second_picker);
                            if (numberPicker3 != null) {
                                i4 = R.id.timepicker_layout;
                                TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.timepicker_layout);
                                if (tableLayout != null) {
                                    return new DialogWaitUntilTriggerConfigureBinding((ScrollView) view, numberPicker, numberPicker2, radioButton, radioButton2, radioButton3, numberPicker3, tableLayout);
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
    public static DialogWaitUntilTriggerConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWaitUntilTriggerConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_wait_until_trigger_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11162a;
    }
}
