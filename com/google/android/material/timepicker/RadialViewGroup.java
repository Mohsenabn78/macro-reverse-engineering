package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f24781a;

    /* renamed from: b  reason: collision with root package name */
    private int f24782b;

    /* renamed from: c  reason: collision with root package name */
    private MaterialShapeDrawable f24783c;

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable a() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f24783c = materialShapeDrawable;
        materialShapeDrawable.setCornerSize(new RelativeCornerSize(0.5f));
        this.f24783c.setFillColor(ColorStateList.valueOf(-1));
        return this.f24783c;
    }

    private static boolean d(View view) {
        return "skip".equals(view.getTag());
    }

    private void f() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f24781a);
            handler.post(this.f24781a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        f();
    }

    @Dimension
    public int b() {
        return this.f24782b;
    }

    public void c(@Dimension int i4) {
        this.f24782b = i4;
        e();
    }

    protected void e() {
        int childCount = getChildCount();
        int i4 = 1;
        for (int i5 = 0; i5 < childCount; i5++) {
            if (d(getChildAt(i5))) {
                i4++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f4 = 0.0f;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            int i7 = R.id.circle_center;
            if (id != i7 && !d(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), i7, this.f24782b, f4);
                f4 += 360.0f / (childCount - i4);
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        f();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        this.f24783c.setFillColor(ColorStateList.valueOf(i4));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i4, 0);
        this.f24782b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f24781a = new Runnable() { // from class: com.google.android.material.timepicker.RadialViewGroup.1
            @Override // java.lang.Runnable
            public void run() {
                RadialViewGroup.this.e();
            }
        };
        obtainStyledAttributes.recycle();
    }
}
