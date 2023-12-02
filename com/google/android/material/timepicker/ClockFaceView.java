package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* loaded from: classes5.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {

    /* renamed from: d  reason: collision with root package name */
    private final ClockHandView f24711d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f24712e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f24713f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray<TextView> f24714g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityDelegateCompat f24715h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f24716i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f24717j;

    /* renamed from: k  reason: collision with root package name */
    private final int f24718k;

    /* renamed from: l  reason: collision with root package name */
    private final int f24719l;

    /* renamed from: m  reason: collision with root package name */
    private final int f24720m;

    /* renamed from: n  reason: collision with root package name */
    private final int f24721n;

    /* renamed from: o  reason: collision with root package name */
    private String[] f24722o;

    /* renamed from: p  reason: collision with root package name */
    private float f24723p;

    /* renamed from: q  reason: collision with root package name */
    private final ColorStateList f24724q;

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void j() {
        RectF d4 = this.f24711d.d();
        for (int i4 = 0; i4 < this.f24714g.size(); i4++) {
            TextView textView = this.f24714g.get(i4);
            if (textView != null) {
                textView.getDrawingRect(this.f24712e);
                this.f24712e.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f24712e);
                this.f24713f.set(this.f24712e);
                textView.getPaint().setShader(k(d4, this.f24713f));
                textView.invalidate();
            }
        }
    }

    private RadialGradient k(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f24713f.left, rectF.centerY() - this.f24713f.top, rectF.width() * 0.5f, this.f24716i, this.f24717j, Shader.TileMode.CLAMP);
    }

    private static float l(float f4, float f5, float f6) {
        return Math.max(Math.max(f4, f5), f6);
    }

    private void n(@StringRes int i4) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f24714g.size();
        for (int i5 = 0; i5 < Math.max(this.f24722o.length, size); i5++) {
            TextView textView = this.f24714g.get(i5);
            if (i5 >= this.f24722o.length) {
                removeView(textView);
                this.f24714g.remove(i5);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f24714g.put(i5, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f24722o[i5]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i5));
                ViewCompat.setAccessibilityDelegate(textView, this.f24715h);
                textView.setTextColor(this.f24724q);
                if (i4 != 0) {
                    textView.setContentDescription(getResources().getString(i4, this.f24722o[i5]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void c(int i4) {
        if (i4 != b()) {
            super.c(i4);
            this.f24711d.k(b());
        }
    }

    public void m(String[] strArr, @StringRes int i4) {
        this.f24722o = strArr;
        n(i4);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f24722o.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int l4 = (int) (this.f24721n / l(this.f24719l / displayMetrics.heightPixels, this.f24720m / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(l4, 1073741824);
        setMeasuredDimension(l4, l4);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f4, boolean z3) {
        if (Math.abs(this.f24723p - f4) > 0.001f) {
            this.f24723p = f4;
            j();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f24712e = new Rect();
        this.f24713f = new RectF();
        this.f24714g = new SparseArray<>();
        this.f24717j = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i4, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.f24724q = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f24711d = clockHandView;
        this.f24718k = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{16842913}, colorStateList.getDefaultColor());
        this.f24716i = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.timepicker.ClockFaceView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (!ClockFaceView.this.isShown()) {
                    return true;
                }
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.c(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f24711d.g()) - ClockFaceView.this.f24718k);
                return true;
            }
        });
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f24715h = new AccessibilityDelegateCompat() { // from class: com.google.android.material.timepicker.ClockFaceView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
                if (intValue > 0) {
                    accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f24714g.get(intValue - 1));
                }
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        m(strArr, 0);
        this.f24719l = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f24720m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f24721n = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
