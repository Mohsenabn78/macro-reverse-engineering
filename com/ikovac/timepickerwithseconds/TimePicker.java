package com.ikovac.timepickerwithseconds;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* loaded from: classes6.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f34122a;

    /* renamed from: b  reason: collision with root package name */
    private int f34123b;

    /* renamed from: c  reason: collision with root package name */
    private int f34124c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f34125d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f34126e;

    /* renamed from: f  reason: collision with root package name */
    private final NumberPicker f34127f;

    /* renamed from: g  reason: collision with root package name */
    private final NumberPicker f34128g;

    /* renamed from: h  reason: collision with root package name */
    private final NumberPicker f34129h;

    /* renamed from: i  reason: collision with root package name */
    private final Button f34130i;

    /* renamed from: j  reason: collision with root package name */
    private final String f34131j;

    /* renamed from: k  reason: collision with root package name */
    private final String f34132k;

    /* renamed from: l  reason: collision with root package name */
    private OnTimeChangedListener f34133l;

    /* renamed from: m  reason: collision with root package name */
    private static final OnTimeChangedListener f34121m = new a();
    public static final NumberPicker.Formatter TWO_DIGIT_FORMATTER = new b();

    /* loaded from: classes6.dex */
    public interface OnTimeChangedListener {
        void onTimeChanged(TimePicker timePicker, int i4, int i5, int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f34134a;

        /* renamed from: b  reason: collision with root package name */
        private final int f34135b;

        /* loaded from: classes6.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int a() {
            return this.f34134a;
        }

        public int b() {
            return this.f34135b;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f34134a);
            parcel.writeInt(this.f34135b);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i4, int i5, a aVar) {
            this(parcelable, i4, i5);
        }

        private SavedState(Parcelable parcelable, int i4, int i5) {
            super(parcelable);
            this.f34134a = i4;
            this.f34135b = i5;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f34134a = parcel.readInt();
            this.f34135b = parcel.readInt();
        }
    }

    /* loaded from: classes6.dex */
    static class b implements NumberPicker.Formatter {
        b() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i4) {
            return String.format("%02d", Integer.valueOf(i4));
        }
    }

    /* loaded from: classes6.dex */
    class c implements NumberPicker.OnValueChangeListener {
        c() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i4, int i5) {
            TimePicker.this.f34122a = i5;
            if (!TimePicker.this.f34125d.booleanValue()) {
                if (TimePicker.this.f34122a == 12) {
                    TimePicker.this.f34122a = 0;
                }
                if (!TimePicker.this.f34126e) {
                    TimePicker.this.f34122a += 12;
                }
            }
            TimePicker.this.m();
        }
    }

    /* loaded from: classes6.dex */
    class d implements NumberPicker.OnValueChangeListener {
        d() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i4, int i5) {
            TimePicker.this.f34123b = i5;
            TimePicker.this.m();
        }
    }

    /* loaded from: classes6.dex */
    class e implements NumberPicker.OnValueChangeListener {
        e() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i4, int i5) {
            TimePicker.this.f34124c = i5;
            TimePicker.this.m();
        }
    }

    /* loaded from: classes6.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePicker timePicker;
            TimePicker.this.requestFocus();
            if (TimePicker.this.f34126e) {
                if (TimePicker.this.f34122a < 12) {
                    TimePicker.this.f34122a += 12;
                }
            } else if (TimePicker.this.f34122a >= 12) {
                TimePicker.this.f34122a -= 12;
            }
            TimePicker.this.f34126e = !timePicker.f34126e;
            TimePicker.this.f34130i.setText(TimePicker.this.f34126e ? TimePicker.this.f34131j : TimePicker.this.f34132k);
            TimePicker.this.m();
        }
    }

    public TimePicker(Context context) {
        this(context, null);
    }

    private void l() {
        if (this.f34125d.booleanValue()) {
            this.f34127f.setMinValue(0);
            this.f34127f.setMaxValue(23);
            this.f34127f.setFormatter(TWO_DIGIT_FORMATTER);
            this.f34130i.setVisibility(8);
            return;
        }
        this.f34127f.setMinValue(1);
        this.f34127f.setMaxValue(12);
        this.f34127f.setFormatter(null);
        this.f34130i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f34133l.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue(), getCurrentSeconds().intValue());
    }

    private void n() {
        boolean z3;
        String str;
        int i4 = this.f34122a;
        if (!this.f34125d.booleanValue()) {
            if (i4 > 12) {
                i4 -= 12;
            } else if (i4 == 0) {
                i4 = 12;
            }
        }
        this.f34127f.setValue(i4);
        if (this.f34122a < 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f34126e = z3;
        Button button = this.f34130i;
        if (z3) {
            str = this.f34131j;
        } else {
            str = this.f34132k;
        }
        button.setText(str);
        m();
    }

    private void o() {
        this.f34128g.setValue(this.f34123b);
        this.f34133l.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue(), getCurrentSeconds().intValue());
    }

    private void p() {
        this.f34129h.setValue(this.f34124c);
        this.f34133l.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue(), getCurrentSeconds().intValue());
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f34127f.getBaseline();
    }

    public Integer getCurrentHour() {
        return Integer.valueOf(this.f34122a);
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f34123b);
    }

    public Integer getCurrentSeconds() {
        return Integer.valueOf(this.f34124c);
    }

    public boolean is24HourView() {
        return this.f34125d.booleanValue();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.a()));
        setCurrentMinute(Integer.valueOf(savedState.b()));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f34122a, this.f34123b, null);
    }

    public void setCurrentHour(Integer num) {
        this.f34122a = num.intValue();
        n();
    }

    public void setCurrentMinute(Integer num) {
        this.f34123b = num.intValue();
        o();
    }

    public void setCurrentSecond(Integer num) {
        this.f34124c = num.intValue();
        p();
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.f34128g.setEnabled(z3);
        this.f34127f.setEnabled(z3);
        this.f34130i.setEnabled(z3);
    }

    public void setIs24HourView(Boolean bool) {
        if (this.f34125d != bool) {
            this.f34125d = bool;
            l();
            n();
        }
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.f34133l = onTimeChangedListener;
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34122a = 0;
        this.f34123b = 0;
        this.f34124c = 0;
        this.f34125d = Boolean.FALSE;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.time_picker_widget, (ViewGroup) this, true);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.hour);
        this.f34127f = numberPicker;
        numberPicker.setOnValueChangedListener(new c());
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.minute);
        this.f34128g = numberPicker2;
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        NumberPicker.Formatter formatter = TWO_DIGIT_FORMATTER;
        numberPicker2.setFormatter(formatter);
        numberPicker2.setOnValueChangedListener(new d());
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.seconds);
        this.f34129h = numberPicker3;
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(59);
        numberPicker3.setFormatter(formatter);
        numberPicker3.setOnValueChangedListener(new e());
        Button button = (Button) findViewById(R.id.amPm);
        this.f34130i = button;
        l();
        Calendar calendar = Calendar.getInstance();
        setOnTimeChangedListener(f34121m);
        setCurrentHour(Integer.valueOf(calendar.get(11)));
        setCurrentMinute(Integer.valueOf(calendar.get(12)));
        setCurrentSecond(Integer.valueOf(calendar.get(13)));
        this.f34126e = this.f34122a < 12;
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        String str = amPmStrings[0];
        this.f34131j = str;
        String str2 = amPmStrings[1];
        this.f34132k = str2;
        button.setText(this.f34126e ? str : str2);
        button.setOnClickListener(new f());
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements OnTimeChangedListener {
        a() {
        }

        @Override // com.ikovac.timepickerwithseconds.TimePicker.OnTimeChangedListener
        public void onTimeChanged(TimePicker timePicker, int i4, int i5, int i6) {
        }
    }
}
