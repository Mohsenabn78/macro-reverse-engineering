package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* loaded from: classes5.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f24804a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeModel f24805b;

    /* renamed from: c  reason: collision with root package name */
    private final TextWatcher f24806c = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.f24805b.i(0);
                    return;
                }
                TimePickerTextInputPresenter.this.f24805b.i(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f24807d = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.f24805b.g(0);
                    return;
                }
                TimePickerTextInputPresenter.this.f24805b.g(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f24808e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f24809f;

    /* renamed from: g  reason: collision with root package name */
    private final TimePickerTextInputKeyController f24810g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f24811h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f24812i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f24813j;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        this.f24804a = linearLayout;
        this.f24805b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f24808e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f24809f = chipTextInputComboView2;
        int i4 = R.id.material_label;
        ((TextView) chipTextInputComboView.findViewById(i4)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i4)).setText(resources.getString(R.string.material_timepicker_hour));
        int i5 = R.id.selection_type;
        chipTextInputComboView.setTag(i5, 12);
        chipTextInputComboView2.setTag(i5, 10);
        if (timeModel.f24787c == 0) {
            i();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.b(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        chipTextInputComboView2.c(timeModel.d());
        chipTextInputComboView.c(timeModel.e());
        this.f24811h = chipTextInputComboView2.e().getEditText();
        this.f24812i = chipTextInputComboView.e().getEditText();
        this.f24810g = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.f(new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection));
        e();
    }

    private void c() {
        this.f24811h.addTextChangedListener(this.f24807d);
        this.f24812i.addTextChangedListener(this.f24806c);
    }

    private void f() {
        this.f24811h.removeTextChangedListener(this.f24807d);
        this.f24812i.removeTextChangedListener(this.f24806c);
    }

    private void h(TimeModel timeModel) {
        f();
        Locale locale = this.f24804a.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(timeModel.f24789e));
        String format2 = String.format(locale, "%02d", Integer.valueOf(timeModel.c()));
        this.f24808e.g(format);
        this.f24809f.g(format2);
        c();
        j();
    }

    private void i() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f24804a.findViewById(R.id.material_clock_period_toggle);
        this.f24813j = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i4, boolean z3) {
                int i5;
                if (i4 == R.id.material_clock_period_pm_button) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                TimePickerTextInputPresenter.this.f24805b.j(i5);
            }
        });
        this.f24813j.setVisibility(0);
        j();
    }

    private void j() {
        int i4;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f24813j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        if (this.f24805b.f24791g == 0) {
            i4 = R.id.material_clock_period_am_button;
        } else {
            i4 = R.id.material_clock_period_pm_button;
        }
        materialButtonToggleGroup.check(i4);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void b(int i4) {
        boolean z3;
        this.f24805b.f24790f = i4;
        ChipTextInputComboView chipTextInputComboView = this.f24808e;
        boolean z4 = true;
        if (i4 == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.f24809f;
        if (i4 != 10) {
            z4 = false;
        }
        chipTextInputComboView2.setChecked(z4);
        j();
    }

    public void d() {
        this.f24808e.setChecked(false);
        this.f24809f.setChecked(false);
    }

    public void e() {
        c();
        h(this.f24805b);
        this.f24810g.a();
    }

    public void g() {
        boolean z3;
        ChipTextInputComboView chipTextInputComboView = this.f24808e;
        boolean z4 = true;
        if (this.f24805b.f24790f == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.f24809f;
        if (this.f24805b.f24790f != 10) {
            z4 = false;
        }
        chipTextInputComboView2.setChecked(z4);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View focusedChild = this.f24804a.getFocusedChild();
        if (focusedChild == null) {
            this.f24804a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.f24804a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f24804a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        h(this.f24805b);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.f24804a.setVisibility(0);
    }
}
