package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class DialogSunriseTimeAdjustBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11136a;
    @NonNull
    public final Spinner entryOption;
    @NonNull
    public final NumberPicker hourPicker;
    @NonNull
    public final NumberPicker minutePicker;
    @NonNull
    public final TableLayout timeSelectionTable;

    private DialogSunriseTimeAdjustBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull TableLayout tableLayout) {
        this.f11136a = linearLayout;
        this.entryOption = spinner;
        this.hourPicker = numberPicker;
        this.minutePicker = numberPicker2;
        this.timeSelectionTable = tableLayout;
    }

    @NonNull
    public static DialogSunriseTimeAdjustBinding bind(@NonNull View view) {
        int i4 = R.id.entry_option;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.entry_option);
        if (spinner != null) {
            i4 = R.id.hour_picker;
            NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.hour_picker);
            if (numberPicker != null) {
                i4 = R.id.minute_picker;
                NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.minute_picker);
                if (numberPicker2 != null) {
                    i4 = R.id.time_selection_table;
                    TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.time_selection_table);
                    if (tableLayout != null) {
                        return new DialogSunriseTimeAdjustBinding((LinearLayout) view, spinner, numberPicker, numberPicker2, tableLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSunriseTimeAdjustBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSunriseTimeAdjustBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sunrise_time_adjust, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11136a;
    }
}
