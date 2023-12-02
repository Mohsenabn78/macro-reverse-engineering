package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

/* loaded from: classes5.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {

    /* renamed from: a  reason: collision with root package name */
    private final Chip f24818a;

    /* renamed from: b  reason: collision with root package name */
    private final Chip f24819b;

    /* renamed from: c  reason: collision with root package name */
    private final ClockHandView f24820c;

    /* renamed from: d  reason: collision with root package name */
    private final ClockFaceView f24821d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonToggleGroup f24822e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f24823f;

    /* renamed from: g  reason: collision with root package name */
    private OnPeriodChangeListener f24824g;

    /* renamed from: h  reason: collision with root package name */
    private OnSelectionChange f24825h;

    /* renamed from: i  reason: collision with root package name */
    private OnDoubleTapListener f24826i;

    /* loaded from: classes5.dex */
    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    /* loaded from: classes5.dex */
    interface OnPeriodChangeListener {
        void a(int i4);
    }

    /* loaded from: classes5.dex */
    interface OnSelectionChange {
        void b(int i4);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void n() {
        Chip chip = this.f24818a;
        int i4 = R.id.selection_type;
        chip.setTag(i4, 12);
        this.f24819b.setTag(i4, 10);
        this.f24818a.setOnClickListener(this.f24823f);
        this.f24819b.setOnClickListener(this.f24823f);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void p() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener onDoubleTapListener = TimePickerView.this.f24826i;
                if (onDoubleTapListener != null) {
                    onDoubleTapListener.onDoubleTap();
                    return true;
                }
                return false;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.f24818a.setOnTouchListener(onTouchListener);
        this.f24819b.setOnTouchListener(onTouchListener);
    }

    private void s() {
        boolean z3;
        if (this.f24822e.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int i4 = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i4 = 2;
            }
            constraintSet.clear(R.id.material_clock_display, i4);
            constraintSet.applyTo(this);
        }
    }

    public void d(ClockHandView.OnRotateListener onRotateListener) {
        this.f24820c.b(onRotateListener);
    }

    public void e(int i4) {
        boolean z3;
        Chip chip = this.f24818a;
        boolean z4 = true;
        if (i4 == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chip.setChecked(z3);
        Chip chip2 = this.f24819b;
        if (i4 != 10) {
            z4 = false;
        }
        chip2.setChecked(z4);
    }

    public void f(boolean z3) {
        this.f24820c.j(z3);
    }

    public void g(float f4, boolean z3) {
        this.f24820c.m(f4, z3);
    }

    public void h(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f24818a, accessibilityDelegateCompat);
    }

    public void i(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f24819b, accessibilityDelegateCompat);
    }

    public void j(ClockHandView.OnActionUpListener onActionUpListener) {
        this.f24820c.o(onActionUpListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@Nullable OnDoubleTapListener onDoubleTapListener) {
        this.f24826i = onDoubleTapListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(OnPeriodChangeListener onPeriodChangeListener) {
        this.f24824g = onPeriodChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(OnSelectionChange onSelectionChange) {
        this.f24825h = onSelectionChange;
    }

    public void o(String[] strArr, @StringRes int i4) {
        this.f24821d.m(strArr, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i4) {
        super.onVisibilityChanged(view, i4);
        if (view == this && i4 == 0) {
            s();
        }
    }

    public void q() {
        this.f24822e.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void r(int i4, int i5, int i6) {
        int i7;
        if (i4 == 1) {
            i7 = R.id.material_clock_period_pm_button;
        } else {
            i7 = R.id.material_clock_period_am_button;
        }
        this.f24822e.check(i7);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i6));
        String format2 = String.format(locale, "%02d", Integer.valueOf(i5));
        this.f24818a.setText(format);
        this.f24819b.setText(format2);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f24823f = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TimePickerView.this.f24825h != null) {
                    TimePickerView.this.f24825h.b(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f24821d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f24822e = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i5, boolean z3) {
                int i6;
                if (i5 == R.id.material_clock_period_pm_button) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (TimePickerView.this.f24824g != null && z3) {
                    TimePickerView.this.f24824g.a(i6);
                }
            }
        });
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.f24818a = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.f24819b = chip2;
        this.f24820c = (ClockHandView) findViewById(R.id.material_clock_hand);
        ViewCompat.setAccessibilityLiveRegion(chip, 2);
        ViewCompat.setAccessibilityLiveRegion(chip2, 2);
        p();
        n();
    }
}
