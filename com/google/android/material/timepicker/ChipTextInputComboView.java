package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private final Chip f24704a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f24705b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f24706c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f24707d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24708e;

    /* loaded from: classes5.dex */
    private class TextFormatter extends TextWatcherAdapter {
        private TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f24704a.setText(ChipTextInputComboView.this.d("00"));
            } else {
                ChipTextInputComboView.this.f24704a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f24706c.setImeHintLocales(locales);
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f24706c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f24706c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f24705b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f24704a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        this.f24704a.setText(d(charSequence));
        if (!TextUtils.isEmpty(this.f24706c.getText())) {
            this.f24706c.removeTextChangedListener(this.f24707d);
            this.f24706c.setText((CharSequence) null);
            this.f24706c.addTextChangedListener(this.f24707d);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f24704a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        int i4;
        this.f24704a.setChecked(z3);
        EditText editText = this.f24706c;
        int i5 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 4;
        }
        editText.setVisibility(i4);
        Chip chip = this.f24704a;
        if (z3) {
            i5 = 8;
        }
        chip.setVisibility(i5);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.f24706c);
            if (!TextUtils.isEmpty(this.f24706c.getText())) {
                EditText editText2 = this.f24706c;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f24704a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i4, Object obj) {
        this.f24704a.setTag(i4, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f24704a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f24704a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f24705b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f24706c = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.f24707d = textFormatter;
        editText.addTextChangedListener(textFormatter);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f24708e = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
    }
}
