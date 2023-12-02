package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes5.dex */
public class MaterialDivider extends View {

    /* renamed from: f  reason: collision with root package name */
    private static final int f23588f = R.style.Widget_MaterialComponents_MaterialDivider;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialShapeDrawable f23589a;

    /* renamed from: b  reason: collision with root package name */
    private int f23590b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f23591c;

    /* renamed from: d  reason: collision with root package name */
    private int f23592d;

    /* renamed from: e  reason: collision with root package name */
    private int f23593e;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f23591c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f23593e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f23592d;
    }

    public int getDividerThickness() {
        return this.f23590b;
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        int i4;
        int width;
        int i5;
        super.onDraw(canvas);
        boolean z3 = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            z3 = false;
        }
        if (z3) {
            i4 = this.f23593e;
        } else {
            i4 = this.f23592d;
        }
        if (z3) {
            width = getWidth();
            i5 = this.f23592d;
        } else {
            width = getWidth();
            i5 = this.f23593e;
        }
        this.f23589a.setBounds(i4, 0, width - i5, getBottom() - getTop());
        this.f23589a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i6 = this.f23590b;
            if (i6 > 0 && measuredHeight != i6) {
                measuredHeight = i6;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i4) {
        if (this.f23591c != i4) {
            this.f23591c = i4;
            this.f23589a.setFillColor(ColorStateList.valueOf(i4));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i4) {
        setDividerColor(ContextCompat.getColor(getContext(), i4));
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f23593e = i4;
    }

    public void setDividerInsetEndResource(@DimenRes int i4) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f23592d = i4;
    }

    public void setDividerInsetStartResource(@DimenRes int i4) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerThickness(@Px int i4) {
        if (this.f23590b != i4) {
            this.f23590b = i4;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i4) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i4));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.divider.MaterialDivider.f23588f
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            r7.f23589a = r0
            int[] r2 = com.google.android.material.R.styleable.MaterialDivider
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.material_divider_thickness
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.f23590b = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetStart
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f23592d = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetEnd
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f23593e = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
