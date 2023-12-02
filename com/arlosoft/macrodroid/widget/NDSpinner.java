package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes3.dex */
public class NDSpinner extends AppCompatSpinner {
    public boolean isDropDownMenuShown;

    public NDSpinner(Context context) {
        super(context);
        this.isDropDownMenuShown = false;
    }

    public boolean isDropDownMenuShown() {
        return this.isDropDownMenuShown;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public boolean performClick() {
        this.isDropDownMenuShown = true;
        return super.performClick();
    }

    public void setDropDownMenuShown(boolean z3) {
        this.isDropDownMenuShown = z3;
    }

    @Override // android.widget.AbsSpinner
    public void setSelection(int i4, boolean z3) {
        boolean z4 = i4 == getSelectedItemPosition();
        super.setSelection(i4, z3);
        if (!z4 || getOnItemSelectedListener() == null) {
            return;
        }
        getOnItemSelectedListener().onItemSelected(this, getSelectedView(), i4, getSelectedItemId());
    }

    public NDSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDropDownMenuShown = false;
    }

    public NDSpinner(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.isDropDownMenuShown = false;
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public void setSelection(int i4) {
        boolean z3 = i4 == getSelectedItemPosition();
        super.setSelection(i4);
        if (!z3 || getOnItemSelectedListener() == null) {
            return;
        }
        getOnItemSelectedListener().onItemSelected(this, getSelectedView(), i4, getSelectedItemId());
    }
}
