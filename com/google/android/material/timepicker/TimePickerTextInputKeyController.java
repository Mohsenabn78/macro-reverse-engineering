package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes5.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final ChipTextInputComboView f24800a;

    /* renamed from: b  reason: collision with root package name */
    private final ChipTextInputComboView f24801b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeModel f24802c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24803d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f24800a = chipTextInputComboView;
        this.f24801b = chipTextInputComboView2;
        this.f24802c = timeModel;
    }

    private void b(int i4) {
        boolean z3;
        ChipTextInputComboView chipTextInputComboView = this.f24801b;
        boolean z4 = true;
        if (i4 == 12) {
            z3 = true;
        } else {
            z3 = false;
        }
        chipTextInputComboView.setChecked(z3);
        ChipTextInputComboView chipTextInputComboView2 = this.f24800a;
        if (i4 != 10) {
            z4 = false;
        }
        chipTextInputComboView2.setChecked(z4);
        this.f24802c.f24790f = i4;
    }

    private boolean c(int i4, KeyEvent keyEvent, EditText editText) {
        boolean z3;
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i4 >= 7 && i4 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        b(12);
        return true;
    }

    private boolean d(int i4, KeyEvent keyEvent, EditText editText) {
        boolean z3;
        if (i4 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        b(10);
        return true;
    }

    public void a() {
        TextInputLayout e4 = this.f24800a.e();
        TextInputLayout e5 = this.f24801b.e();
        EditText editText = e4.getEditText();
        EditText editText2 = e5.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        boolean z3;
        if (i4 == 5) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            b(12);
        }
        return z3;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i4, KeyEvent keyEvent) {
        boolean c4;
        if (this.f24803d) {
            return false;
        }
        this.f24803d = true;
        EditText editText = (EditText) view;
        if (this.f24802c.f24790f == 12) {
            c4 = d(i4, keyEvent, editText);
        } else {
            c4 = c(i4, keyEvent, editText);
        }
        this.f24803d = false;
        return c4;
    }
}
