package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class MacroDroidTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, TimePicker.OnTimeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private final TimePicker f16463a;

    /* renamed from: b  reason: collision with root package name */
    private final OnTimeSetListener f16464b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16465c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16466d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16467e;

    /* loaded from: classes3.dex */
    public interface OnTimeSetListener {
        void onTimeSet(TimePicker timePicker, int i4, int i5);
    }

    public MacroDroidTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i4, int i5, boolean z3) {
        this(context, 0, onTimeSetListener, i4, i5, z3);
    }

    private static int resolveDialogTheme(Context context, int i4) {
        if (i4 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843934, typedValue, true);
            return typedValue.resourceId;
        }
        return i4;
    }

    public TimePicker getTimePicker() {
        return this.f16463a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        OnTimeSetListener onTimeSetListener;
        if (i4 == -1 && (onTimeSetListener = this.f16464b) != null) {
            TimePicker timePicker = this.f16463a;
            onTimeSetListener.onTimeSet(timePicker, timePicker.getCurrentHour().intValue(), this.f16463a.getCurrentMinute().intValue());
        }
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i4 = bundle.getInt("hour");
        int i5 = bundle.getInt("minute");
        this.f16463a.setIs24HourView(Boolean.valueOf(bundle.getBoolean("is24hour")));
        this.f16463a.setCurrentHour(Integer.valueOf(i4));
        this.f16463a.setCurrentMinute(Integer.valueOf(i5));
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("hour", this.f16463a.getCurrentHour().intValue());
        onSaveInstanceState.putInt("minute", this.f16463a.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean("is24hour", this.f16463a.is24HourView());
        return onSaveInstanceState;
    }

    public void updateTime(int i4, int i5) {
        this.f16463a.setCurrentHour(Integer.valueOf(i4));
        this.f16463a.setCurrentMinute(Integer.valueOf(i5));
    }

    private MacroDroidTimePickerDialog(Context context, int i4, OnTimeSetListener onTimeSetListener, int i5, int i6, boolean z3) {
        super(context, resolveDialogTheme(context, i4));
        this.f16464b = onTimeSetListener;
        this.f16465c = i5;
        this.f16466d = i6;
        this.f16467e = z3;
        Context context2 = getContext();
        View inflate = LayoutInflater.from(context2).inflate(R.layout.macrodroid_time_picker_dialog, (ViewGroup) null);
        setView(inflate);
        setButton(-1, context2.getString(17039370), this);
        setButton(-2, context2.getString(17039360), this);
        TimePicker timePicker = (TimePicker) inflate.findViewById(R.id.timePicker);
        this.f16463a = timePicker;
        timePicker.setIs24HourView(Boolean.valueOf(z3));
        timePicker.setCurrentHour(Integer.valueOf(i5));
        timePicker.setCurrentMinute(Integer.valueOf(i6));
        timePicker.setOnTimeChangedListener(this);
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i4, int i5) {
    }
}
