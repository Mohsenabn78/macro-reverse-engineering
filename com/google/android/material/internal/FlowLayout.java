package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f23814a;

    /* renamed from: b  reason: collision with root package name */
    private int f23815b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23816c;

    /* renamed from: d  reason: collision with root package name */
    private int f23817d;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    private static int a(int i4, int i5, int i6) {
        if (i5 != Integer.MIN_VALUE) {
            if (i5 != 1073741824) {
                return i6;
            }
            return i4;
        }
        return Math.min(i6, i4);
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f23814a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f23815b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    protected int getItemSpacing() {
        return this.f23815b;
    }

    protected int getLineSpacing() {
        return this.f23814a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f23817d;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean isSingleLine() {
        return this.f23816c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        boolean z4;
        int paddingLeft;
        int paddingRight;
        int i8;
        int i9;
        if (getChildCount() == 0) {
            this.f23817d = 0;
            return;
        }
        this.f23817d = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z4) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i10 = (i6 - i4) - paddingRight;
        int i11 = paddingLeft;
        int i12 = paddingTop;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i9 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i8 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int measuredWidth = i11 + i9 + childAt.getMeasuredWidth();
                if (!this.f23816c && measuredWidth > i10) {
                    i12 = this.f23814a + paddingTop;
                    this.f23817d++;
                    i11 = paddingLeft;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f23817d - 1));
                int i14 = i11 + i9;
                int measuredWidth2 = childAt.getMeasuredWidth() + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                if (z4) {
                    childAt.layout(i10 - measuredWidth2, i12, (i10 - i11) - i9, measuredHeight);
                } else {
                    childAt.layout(i14, i12, measuredWidth2, measuredHeight);
                }
                i11 += i9 + i8 + childAt.getMeasuredWidth() + this.f23815b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i6 = Integer.MAX_VALUE;
        } else {
            i6 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i10 = paddingTop;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i4, i5);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i7 = marginLayoutParams.leftMargin + 0;
                    i8 = marginLayoutParams.rightMargin + 0;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i13 = paddingLeft;
                if (paddingLeft + i7 + childAt.getMeasuredWidth() > paddingRight && !isSingleLine()) {
                    i9 = getPaddingLeft();
                    i10 = this.f23814a + paddingTop;
                } else {
                    i9 = i13;
                }
                int measuredWidth = i9 + i7 + childAt.getMeasuredWidth();
                int measuredHeight = i10 + childAt.getMeasuredHeight();
                if (measuredWidth > i11) {
                    i11 = measuredWidth;
                }
                paddingLeft = i9 + i7 + i8 + childAt.getMeasuredWidth() + this.f23815b;
                if (i12 == getChildCount() - 1) {
                    i11 += i8;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i11 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i4) {
        this.f23815b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i4) {
        this.f23814a = i4;
    }

    public void setSingleLine(boolean z3) {
        this.f23816c = z3;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f23816c = false;
        b(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f23816c = false;
        b(context, attributeSet);
    }
}
