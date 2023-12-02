package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class MacrodroidTimePickerDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TimePicker f11330a;
    @NonNull
    public final TimePicker timePicker;

    private MacrodroidTimePickerDialogBinding(@NonNull TimePicker timePicker, @NonNull TimePicker timePicker2) {
        this.f11330a = timePicker;
        this.timePicker = timePicker2;
    }

    @NonNull
    public static MacrodroidTimePickerDialogBinding bind(@NonNull View view) {
        if (view != null) {
            TimePicker timePicker = (TimePicker) view;
            return new MacrodroidTimePickerDialogBinding(timePicker, timePicker);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MacrodroidTimePickerDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacrodroidTimePickerDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macrodroid_time_picker_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public TimePicker getRoot() {
        return this.f11330a;
    }
}
