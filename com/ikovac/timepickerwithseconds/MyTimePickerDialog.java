package com.ikovac.timepickerwithseconds;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ikovac.timepickerwithseconds.TimePicker;
import java.text.DateFormat;
import java.util.Calendar;

/* loaded from: classes6.dex */
public class MyTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, TimePicker.OnTimeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private final TimePicker f34113a;

    /* renamed from: b  reason: collision with root package name */
    private final OnTimeSetListener f34114b;

    /* renamed from: c  reason: collision with root package name */
    private final Calendar f34115c;

    /* renamed from: d  reason: collision with root package name */
    private final DateFormat f34116d;

    /* renamed from: e  reason: collision with root package name */
    int f34117e;

    /* renamed from: f  reason: collision with root package name */
    int f34118f;

    /* renamed from: g  reason: collision with root package name */
    int f34119g;

    /* renamed from: h  reason: collision with root package name */
    boolean f34120h;

    /* loaded from: classes6.dex */
    public interface OnTimeSetListener {
        void onTimeSet(TimePicker timePicker, int i4, int i5, int i6);
    }

    public MyTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i4, int i5, int i6, boolean z3) {
        this(context, 0, onTimeSetListener, i4, i5, i6, z3);
    }

    private void a(int i4, int i5, int i6) {
        String format = String.format("%02d", Integer.valueOf(i4));
        String format2 = String.format("%02d", Integer.valueOf(i5));
        String format3 = String.format("%02d", Integer.valueOf(i6));
        setTitle(format + ":" + format2 + ":" + format3);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        if (this.f34114b != null) {
            this.f34113a.clearFocus();
            OnTimeSetListener onTimeSetListener = this.f34114b;
            TimePicker timePicker = this.f34113a;
            onTimeSetListener.onTimeSet(timePicker, timePicker.getCurrentHour().intValue(), this.f34113a.getCurrentMinute().intValue(), this.f34113a.getCurrentSeconds().intValue());
        }
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i4 = bundle.getInt("hour");
        int i5 = bundle.getInt("minute");
        int i6 = bundle.getInt("seconds");
        this.f34113a.setCurrentHour(Integer.valueOf(i4));
        this.f34113a.setCurrentMinute(Integer.valueOf(i5));
        this.f34113a.setCurrentSecond(Integer.valueOf(i6));
        this.f34113a.setIs24HourView(Boolean.valueOf(bundle.getBoolean("is24hour")));
        this.f34113a.setOnTimeChangedListener(this);
        a(i4, i5, i6);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("hour", this.f34113a.getCurrentHour().intValue());
        onSaveInstanceState.putInt("minute", this.f34113a.getCurrentMinute().intValue());
        onSaveInstanceState.putInt("seconds", this.f34113a.getCurrentSeconds().intValue());
        onSaveInstanceState.putBoolean("is24hour", this.f34113a.is24HourView());
        return onSaveInstanceState;
    }

    @Override // com.ikovac.timepickerwithseconds.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i4, int i5, int i6) {
        a(i4, i5, i6);
    }

    public void updateTime(int i4, int i5, int i6) {
        this.f34113a.setCurrentHour(Integer.valueOf(i4));
        this.f34113a.setCurrentMinute(Integer.valueOf(i5));
        this.f34113a.setCurrentSecond(Integer.valueOf(i6));
    }

    public MyTimePickerDialog(Context context, int i4, OnTimeSetListener onTimeSetListener, int i5, int i6, int i7, boolean z3) {
        super(context, i4);
        requestWindowFeature(1);
        this.f34114b = onTimeSetListener;
        this.f34117e = i5;
        this.f34118f = i6;
        this.f34119g = i7;
        this.f34120h = z3;
        this.f34116d = android.text.format.DateFormat.getTimeFormat(context);
        this.f34115c = Calendar.getInstance();
        a(this.f34117e, this.f34118f, this.f34119g);
        setButton(context.getText(R.string.time_set), this);
        setButton2(context.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.time_picker_dialog, (ViewGroup) null);
        setView(inflate);
        TimePicker timePicker = (TimePicker) inflate.findViewById(R.id.timePicker);
        this.f34113a = timePicker;
        timePicker.setCurrentHour(Integer.valueOf(this.f34117e));
        timePicker.setCurrentMinute(Integer.valueOf(this.f34118f));
        timePicker.setCurrentSecond(Integer.valueOf(this.f34119g));
        timePicker.setIs24HourView(Boolean.valueOf(this.f34120h));
        timePicker.setOnTimeChangedListener(this);
    }
}
