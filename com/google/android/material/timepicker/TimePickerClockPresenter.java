package com.google.android.material.timepicker;

import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;

/* loaded from: classes5.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f24792f = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f24793g = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f24794h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a  reason: collision with root package name */
    private TimePickerView f24795a;

    /* renamed from: b  reason: collision with root package name */
    private TimeModel f24796b;

    /* renamed from: c  reason: collision with root package name */
    private float f24797c;

    /* renamed from: d  reason: collision with root package name */
    private float f24798d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24799e = false;

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.f24795a = timePickerView;
        this.f24796b = timeModel;
        e();
    }

    private int c() {
        if (this.f24796b.f24787c == 1) {
            return 15;
        }
        return 30;
    }

    private String[] d() {
        if (this.f24796b.f24787c == 1) {
            return f24793g;
        }
        return f24792f;
    }

    private void f(int i4, int i5) {
        TimeModel timeModel = this.f24796b;
        if (timeModel.f24789e != i5 || timeModel.f24788d != i4) {
            this.f24795a.performHapticFeedback(4);
        }
    }

    private void h() {
        TimePickerView timePickerView = this.f24795a;
        TimeModel timeModel = this.f24796b;
        timePickerView.r(timeModel.f24791g, timeModel.c(), this.f24796b.f24789e);
    }

    private void i() {
        j(f24792f, "%d");
        j(f24793g, "%d");
        j(f24794h, "%02d");
    }

    private void j(String[] strArr, String str) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            strArr[i4] = TimeModel.b(this.f24795a.getResources(), strArr[i4], str);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void a(int i4) {
        this.f24796b.j(i4);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void b(int i4) {
        g(i4, true);
    }

    public void e() {
        if (this.f24796b.f24787c == 0) {
            this.f24795a.q();
        }
        this.f24795a.d(this);
        this.f24795a.m(this);
        this.f24795a.l(this);
        this.f24795a.j(this);
        i();
        invalidate();
    }

    void g(int i4, boolean z3) {
        boolean z4;
        String[] d4;
        int i5;
        float f4;
        if (i4 == 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f24795a.f(z4);
        this.f24796b.f24790f = i4;
        TimePickerView timePickerView = this.f24795a;
        if (z4) {
            d4 = f24794h;
        } else {
            d4 = d();
        }
        if (z4) {
            i5 = R.string.material_minute_suffix;
        } else {
            i5 = R.string.material_hour_suffix;
        }
        timePickerView.o(d4, i5);
        TimePickerView timePickerView2 = this.f24795a;
        if (z4) {
            f4 = this.f24797c;
        } else {
            f4 = this.f24798d;
        }
        timePickerView2.g(f4, z3);
        this.f24795a.e(i4);
        this.f24795a.i(new ClickActionDelegate(this.f24795a.getContext(), R.string.material_hour_selection));
        this.f24795a.h(new ClickActionDelegate(this.f24795a.getContext(), R.string.material_minute_selection));
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.f24795a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.f24798d = this.f24796b.c() * c();
        TimeModel timeModel = this.f24796b;
        this.f24797c = timeModel.f24789e * 6;
        g(timeModel.f24790f, false);
        h();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f4, boolean z3) {
        this.f24799e = true;
        TimeModel timeModel = this.f24796b;
        int i4 = timeModel.f24789e;
        int i5 = timeModel.f24788d;
        if (timeModel.f24790f == 10) {
            this.f24795a.g(this.f24798d, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.f24795a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                g(12, true);
            }
        } else {
            int round = Math.round(f4);
            if (!z3) {
                this.f24796b.i(((round + 15) / 30) * 5);
                this.f24797c = this.f24796b.f24789e * 6;
            }
            this.f24795a.g(this.f24797c, z3);
        }
        this.f24799e = false;
        h();
        f(i5, i4);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f4, boolean z3) {
        if (this.f24799e) {
            return;
        }
        TimeModel timeModel = this.f24796b;
        int i4 = timeModel.f24788d;
        int i5 = timeModel.f24789e;
        int round = Math.round(f4);
        TimeModel timeModel2 = this.f24796b;
        if (timeModel2.f24790f == 12) {
            timeModel2.i((round + 3) / 6);
            this.f24797c = (float) Math.floor(this.f24796b.f24789e * 6);
        } else {
            this.f24796b.g((round + (c() / 2)) / c());
            this.f24798d = this.f24796b.c() * c();
        }
        if (!z3) {
            h();
            f(i4, i5);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.f24795a.setVisibility(0);
    }
}
