package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

/* loaded from: classes3.dex */
public class ToggleButtonGroupTableLayout extends TableLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RadioButton f16495a;

    public ToggleButtonGroupTableLayout(Context context) {
        super(context);
    }

    private void setChildrenOnClickListener(TableRow tableRow) {
        int childCount = tableRow.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = tableRow.getChildAt(i4);
            if (childAt instanceof RadioButton) {
                childAt.setOnClickListener(this);
            }
        }
    }

    @Override // android.widget.TableLayout, android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
        setChildrenOnClickListener((TableRow) view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton = (RadioButton) view;
        RadioButton radioButton2 = this.f16495a;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        radioButton.setChecked(true);
        this.f16495a = radioButton;
    }

    public ToggleButtonGroupTableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TableLayout, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        setChildrenOnClickListener((TableRow) view);
    }
}
