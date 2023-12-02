package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {

    /* renamed from: c0  reason: collision with root package name */
    private static final String f24311c0 = "BaseSlider";

    /* renamed from: d0  reason: collision with root package name */
    static final int f24312d0 = R.style.Widget_MaterialComponents_Slider;
    private int A;
    private float B;
    private MotionEvent C;
    private LabelFormatter D;
    private boolean E;
    private float F;
    private float G;
    private ArrayList<Float> H;
    private int I;
    private int J;
    private float K;
    private float[] L;
    private boolean M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    @NonNull
    private ColorStateList R;
    @NonNull
    private ColorStateList S;
    @NonNull
    private ColorStateList T;
    @NonNull
    private ColorStateList U;
    @NonNull
    private ColorStateList V;
    @NonNull
    private final MaterialShapeDrawable W;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f24313a;

    /* renamed from: a0  reason: collision with root package name */
    private float f24314a0;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f24315b;

    /* renamed from: b0  reason: collision with root package name */
    private int f24316b0;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f24317c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f24318d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f24319e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Paint f24320f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final AccessibilityHelper f24321g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f24322h;

    /* renamed from: i  reason: collision with root package name */
    private BaseSlider<S, L, T>.AccessibilityEventSender f24323i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TooltipDrawableFactory f24324j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final List<TooltipDrawable> f24325k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final List<L> f24326l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final List<T> f24327m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24328n;

    /* renamed from: o  reason: collision with root package name */
    private ValueAnimator f24329o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f24330p;

    /* renamed from: q  reason: collision with root package name */
    private final int f24331q;

    /* renamed from: r  reason: collision with root package name */
    private int f24332r;

    /* renamed from: s  reason: collision with root package name */
    private int f24333s;

    /* renamed from: t  reason: collision with root package name */
    private int f24334t;

    /* renamed from: u  reason: collision with root package name */
    private int f24335u;

    /* renamed from: v  reason: collision with root package name */
    private int f24336v;

    /* renamed from: w  reason: collision with root package name */
    private int f24337w;

    /* renamed from: x  reason: collision with root package name */
    private int f24338x;

    /* renamed from: y  reason: collision with root package name */
    private int f24339y;

    /* renamed from: z  reason: collision with root package name */
    private int f24340z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AccessibilityEventSender implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f24346a;

        private AccessibilityEventSender() {
            this.f24346a = -1;
        }

        void a(int i4) {
            this.f24346a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f24321g.sendEventForVirtualView(this.f24346a, 4);
        }
    }

    /* loaded from: classes5.dex */
    private static class AccessibilityHelper extends ExploreByTouchHelper {

        /* renamed from: a  reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f24348a;

        /* renamed from: b  reason: collision with root package name */
        Rect f24349b;

        AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f24349b = new Rect();
            this.f24348a = baseSlider;
        }

        @NonNull
        private String a(int i4) {
            if (i4 == this.f24348a.getValues().size() - 1) {
                return this.f24348a.getContext().getString(R.string.material_slider_range_end);
            }
            if (i4 == 0) {
                return this.f24348a.getContext().getString(R.string.material_slider_range_start);
            }
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f4, float f5) {
            for (int i4 = 0; i4 < this.f24348a.getValues().size(); i4++) {
                this.f24348a.c0(i4, this.f24349b);
                if (this.f24349b.contains((int) f4, (int) f5)) {
                    return i4;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i4 = 0; i4 < this.f24348a.getValues().size(); i4++) {
                list.add(Integer.valueOf(i4));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i4, int i5, Bundle bundle) {
            if (!this.f24348a.isEnabled()) {
                return false;
            }
            if (i5 == 4096 || i5 == 8192) {
                float k4 = this.f24348a.k(20);
                if (i5 == 8192) {
                    k4 = -k4;
                }
                if (this.f24348a.F()) {
                    k4 = -k4;
                }
                if (this.f24348a.a0(i4, MathUtils.clamp(this.f24348a.getValues().get(i4).floatValue() + k4, this.f24348a.getValueFrom(), this.f24348a.getValueTo()))) {
                    this.f24348a.d0();
                    this.f24348a.postInvalidate();
                    invalidateVirtualView(i4);
                    return true;
                }
                return false;
            }
            if (i5 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.f24348a.a0(i4, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.f24348a.d0();
                    this.f24348a.postInvalidate();
                    invalidateVirtualView(i4);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i4, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.f24348a.getValues();
            float floatValue = values.get(i4).floatValue();
            float valueFrom = this.f24348a.getValueFrom();
            float valueTo = this.f24348a.getValueTo();
            if (this.f24348a.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f24348a.getContentDescription() != null) {
                sb.append(this.f24348a.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(a(i4));
                sb.append(this.f24348a.y(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.f24348a.c0(i4, this.f24349b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f24349b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SliderState[] newArray(int i4) {
                return new SliderState[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        float f24350a;

        /* renamed from: b  reason: collision with root package name */
        float f24351b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Float> f24352c;

        /* renamed from: d  reason: collision with root package name */
        float f24353d;

        /* renamed from: e  reason: collision with root package name */
        boolean f24354e;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeFloat(this.f24350a);
            parcel.writeFloat(this.f24351b);
            parcel.writeList(this.f24352c);
            parcel.writeFloat(this.f24353d);
            parcel.writeBooleanArray(new boolean[]{this.f24354e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.f24350a = parcel.readFloat();
            this.f24351b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f24352c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f24353d = parcel.readFloat();
            this.f24354e = parcel.createBooleanArray()[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface TooltipDrawableFactory {
        TooltipDrawable a();
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private float A(int i4, float f4) {
        float floatValue;
        float floatValue2;
        float minSeparation = getMinSeparation();
        if (this.f24316b0 == 0) {
            minSeparation = p(minSeparation);
        }
        if (F()) {
            minSeparation = -minSeparation;
        }
        int i5 = i4 + 1;
        if (i5 >= this.H.size()) {
            floatValue = this.G;
        } else {
            floatValue = this.H.get(i5).floatValue() - minSeparation;
        }
        int i6 = i4 - 1;
        if (i6 < 0) {
            floatValue2 = this.F;
        } else {
            floatValue2 = this.H.get(i6).floatValue() + minSeparation;
        }
        return MathUtils.clamp(f4, floatValue2, floatValue);
    }

    @ColorInt
    private int B(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void C() {
        this.f24313a.setStrokeWidth(this.f24336v);
        this.f24315b.setStrokeWidth(this.f24336v);
        this.f24319e.setStrokeWidth(this.f24336v / 2.0f);
        this.f24320f.setStrokeWidth(this.f24336v / 2.0f);
    }

    private boolean D() {
        ViewParent parent = getParent();
        while (true) {
            boolean z3 = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) ? true : true) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private boolean E(float f4) {
        double doubleValue = new BigDecimal(Float.toString(f4)).divide(new BigDecimal(Float.toString(this.K)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(doubleValue) - doubleValue) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    private void G(@NonNull Resources resources) {
        this.f24334t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f24332r = dimensionPixelOffset;
        this.f24337w = dimensionPixelOffset;
        this.f24333s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f24338x = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void H() {
        if (this.K <= 0.0f) {
            return;
        }
        f0();
        int min = Math.min((int) (((this.G - this.F) / this.K) + 1.0f), (this.N / (this.f24336v * 2)) + 1);
        float[] fArr = this.L;
        if (fArr == null || fArr.length != min * 2) {
            this.L = new float[min * 2];
        }
        float f4 = this.N / (min - 1);
        for (int i4 = 0; i4 < min * 2; i4 += 2) {
            float[] fArr2 = this.L;
            fArr2[i4] = this.f24337w + ((i4 / 2) * f4);
            fArr2[i4 + 1] = l();
        }
    }

    private void I(@NonNull Canvas canvas, int i4, int i5) {
        if (X()) {
            int N = (int) (this.f24337w + (N(this.H.get(this.J).floatValue()) * i4));
            if (Build.VERSION.SDK_INT < 28) {
                int i6 = this.f24340z;
                canvas.clipRect(N - i6, i5 - i6, N + i6, i6 + i5, Region.Op.UNION);
            }
            canvas.drawCircle(N, i5, this.f24340z, this.f24318d);
        }
    }

    private void J(@NonNull Canvas canvas) {
        if (this.M && this.K > 0.0f) {
            float[] activeRange = getActiveRange();
            int T = T(this.L, activeRange[0]);
            int T2 = T(this.L, activeRange[1]);
            int i4 = T * 2;
            canvas.drawPoints(this.L, 0, i4, this.f24319e);
            int i5 = T2 * 2;
            canvas.drawPoints(this.L, i4, i5 - i4, this.f24320f);
            float[] fArr = this.L;
            canvas.drawPoints(fArr, i5, fArr.length - i5, this.f24319e);
        }
    }

    private void K() {
        this.f24337w = this.f24332r + Math.max(this.f24339y - this.f24333s, 0);
        if (ViewCompat.isLaidOut(this)) {
            e0(getWidth());
        }
    }

    private boolean L(int i4) {
        int i5 = this.J;
        int clamp = (int) MathUtils.clamp(i5 + i4, 0L, this.H.size() - 1);
        this.J = clamp;
        if (clamp == i5) {
            return false;
        }
        if (this.I != -1) {
            this.I = clamp;
        }
        d0();
        postInvalidate();
        return true;
    }

    private boolean M(int i4) {
        if (F()) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = Integer.MAX_VALUE;
            } else {
                i4 = -i4;
            }
        }
        return L(i4);
    }

    private float N(float f4) {
        float f5 = this.F;
        float f6 = (f4 - f5) / (this.G - f5);
        if (F()) {
            return 1.0f - f6;
        }
        return f6;
    }

    private Boolean O(int i4, @NonNull KeyEvent keyEvent) {
        if (i4 != 61) {
            if (i4 != 66) {
                if (i4 != 81) {
                    if (i4 != 69) {
                        if (i4 != 70) {
                            switch (i4) {
                                case 21:
                                    M(-1);
                                    return Boolean.TRUE;
                                case 22:
                                    M(1);
                                    return Boolean.TRUE;
                                case 23:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        L(-1);
                        return Boolean.TRUE;
                    }
                }
                L(1);
                return Boolean.TRUE;
            }
            this.I = this.J;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(L(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(L(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void P() {
        for (T t3 : this.f24327m) {
            t3.onStartTrackingTouch(this);
        }
    }

    private void Q() {
        for (T t3 : this.f24327m) {
            t3.onStopTrackingTouch(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static TooltipDrawable R(@NonNull Context context, @NonNull TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int T(float[] fArr, float f4) {
        return Math.round(f4 * ((fArr.length / 2) - 1));
    }

    private void U(Context context, AttributeSet attributeSet, int i4) {
        int i5;
        int i6;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i4, f24312d0, new int[0]);
        this.F = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.G = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.F));
        this.K = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i7 = R.styleable.Slider_trackColor;
        boolean hasValue = obtainStyledAttributes.hasValue(i7);
        if (hasValue) {
            i5 = i7;
        } else {
            i5 = R.styleable.Slider_trackColorInactive;
        }
        if (!hasValue) {
            i7 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i7);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.W.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        int i8 = R.styleable.Slider_thumbStrokeColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, i8));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true);
        int i9 = R.styleable.Slider_tickColor;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i9);
        if (hasValue2) {
            i6 = i9;
        } else {
            i6 = R.styleable.Slider_tickColorInactive;
        }
        if (!hasValue2) {
            i9 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i6);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i9);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.f24335u = obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void V(int i4) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f24323i;
        if (accessibilityEventSender == null) {
            this.f24323i = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.f24323i.a(i4);
        postDelayed(this.f24323i, 200L);
    }

    private void W(TooltipDrawable tooltipDrawable, float f4) {
        tooltipDrawable.setText(y(f4));
        int N = (this.f24337w + ((int) (N(f4) * this.N))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int l4 = l() - (this.A + this.f24339y);
        tooltipDrawable.setBounds(N, l4 - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + N, l4);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private boolean X() {
        if (!this.O && (getBackground() instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    private boolean Y(float f4) {
        return a0(this.I, f4);
    }

    private double Z(float f4) {
        float f5 = this.K;
        if (f5 > 0.0f) {
            int i4 = (int) ((this.G - this.F) / f5);
            return Math.round(f4 * i4) / i4;
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0(int i4, float f4) {
        this.J = i4;
        if (Math.abs(f4 - this.H.get(i4).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.H.set(i4, Float.valueOf(A(i4, f4)));
        q(i4);
        return true;
    }

    private boolean b0() {
        return Y(getValueOfTouchPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (!X() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int N = (int) ((N(this.H.get(this.J).floatValue()) * this.N) + this.f24337w);
                int l4 = l();
                int i4 = this.f24340z;
                DrawableCompat.setHotspotBounds(background, N - i4, l4 - i4, N + i4, l4 + i4);
            }
        }
    }

    private void e0(int i4) {
        this.N = Math.max(i4 - (this.f24337w * 2), 0);
        H();
    }

    private void f0() {
        if (this.Q) {
            i0();
            j0();
            h0();
            k0();
            g0();
            n0();
            this.Q = false;
        }
    }

    private void g0() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f4 = this.K;
            if (f4 > 0.0f && minSeparation > 0.0f) {
                if (this.f24316b0 == 1) {
                    if (minSeparation < f4 || !E(minSeparation)) {
                        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.K), Float.valueOf(this.K)));
                    }
                    return;
                }
                throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.K)));
            }
            return;
        }
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.H.size() == 1) {
            floatValue2 = this.F;
        }
        float N = N(floatValue2);
        float N2 = N(floatValue);
        return F() ? new float[]{N2, N} : new float[]{N, N2};
    }

    private float getValueOfTouchPosition() {
        double Z = Z(this.f24314a0);
        if (F()) {
            Z = 1.0d - Z;
        }
        float f4 = this.G;
        float f5 = this.F;
        return (float) ((Z * (f4 - f5)) + f5);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f4 = this.f24314a0;
        if (F()) {
            f4 = 1.0f - f4;
        }
        float f5 = this.G;
        float f6 = this.F;
        return (f4 * (f5 - f6)) + f6;
    }

    private void h(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private void h0() {
        if (this.K > 0.0f && !l0(this.G)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.K), Float.valueOf(this.F), Float.valueOf(this.G)));
        }
    }

    private Float i(int i4) {
        float j4;
        if (this.P) {
            j4 = k(20);
        } else {
            j4 = j();
        }
        if (i4 != 21) {
            if (i4 != 22) {
                if (i4 != 69) {
                    if (i4 != 70 && i4 != 81) {
                        return null;
                    }
                    return Float.valueOf(j4);
                }
                return Float.valueOf(-j4);
            }
            if (F()) {
                j4 = -j4;
            }
            return Float.valueOf(j4);
        }
        if (!F()) {
            j4 = -j4;
        }
        return Float.valueOf(j4);
    }

    private void i0() {
        if (this.F < this.G) {
            return;
        }
        throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.F), Float.valueOf(this.G)));
    }

    private float j() {
        float f4 = this.K;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        return f4;
    }

    private void j0() {
        if (this.G > this.F) {
            return;
        }
        throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.G), Float.valueOf(this.F)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float k(int i4) {
        float f4;
        float f5;
        float j4 = j();
        if ((this.G - this.F) / j4 <= i4) {
            return j4;
        }
        return Math.round(f4 / f5) * j4;
    }

    private void k0() {
        Iterator<Float> it = this.H.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.F && next.floatValue() <= this.G) {
                if (this.K > 0.0f && !l0(next.floatValue())) {
                    throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", next, Float.valueOf(this.F), Float.valueOf(this.K), Float.valueOf(this.K)));
                }
            } else {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", next, Float.valueOf(this.F), Float.valueOf(this.G)));
            }
        }
    }

    private int l() {
        int i4 = this.f24338x;
        int i5 = 0;
        if (this.f24335u == 1) {
            i5 = this.f24325k.get(0).getIntrinsicHeight();
        }
        return i4 + i5;
    }

    private boolean l0(float f4) {
        return E(f4 - this.F);
    }

    private ValueAnimator m(boolean z3) {
        float f4;
        ValueAnimator valueAnimator;
        long j4;
        TimeInterpolator timeInterpolator;
        float f5 = 0.0f;
        if (z3) {
            f4 = 0.0f;
        } else {
            f4 = 1.0f;
        }
        if (z3) {
            valueAnimator = this.f24330p;
        } else {
            valueAnimator = this.f24329o;
        }
        float z4 = z(valueAnimator, f4);
        if (z3) {
            f5 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(z4, f5);
        if (z3) {
            j4 = 83;
        } else {
            j4 = 117;
        }
        ofFloat.setDuration(j4);
        if (z3) {
            timeInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        } else {
            timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        }
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.BaseSlider.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                for (TooltipDrawable tooltipDrawable : BaseSlider.this.f24325k) {
                    tooltipDrawable.setRevealFraction(floatValue);
                }
                ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    private float m0(float f4) {
        return (N(f4) * this.N) + this.f24337w;
    }

    private void n() {
        if (this.f24325k.size() > this.H.size()) {
            List<TooltipDrawable> subList = this.f24325k.subList(this.H.size(), this.f24325k.size());
            for (TooltipDrawable tooltipDrawable : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    o(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (this.f24325k.size() < this.H.size()) {
            TooltipDrawable a4 = this.f24324j.a();
            this.f24325k.add(a4);
            if (ViewCompat.isAttachedToWindow(this)) {
                h(a4);
            }
        }
        int i4 = 1;
        if (this.f24325k.size() == 1) {
            i4 = 0;
        }
        for (TooltipDrawable tooltipDrawable2 : this.f24325k) {
            tooltipDrawable2.setStrokeWidth(i4);
        }
    }

    private void n0() {
        float f4 = this.K;
        if (f4 == 0.0f) {
            return;
        }
        if (((int) f4) != f4) {
            Log.w(f24311c0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f4)));
        }
        float f5 = this.F;
        if (((int) f5) != f5) {
            Log.w(f24311c0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f5)));
        }
        float f6 = this.G;
        if (((int) f6) != f6) {
            Log.w(f24311c0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f6)));
        }
    }

    private void o(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private float p(float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        float f5 = (f4 - this.f24337w) / this.N;
        float f6 = this.F;
        return (f5 * (f6 - this.G)) + f6;
    }

    private void q(int i4) {
        for (L l4 : this.f24326l) {
            l4.onValueChange(this, this.H.get(i4).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f24322h;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            V(i4);
        }
    }

    private void r() {
        for (L l4 : this.f24326l) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                l4.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void s(@NonNull Canvas canvas, int i4, int i5) {
        float[] activeRange = getActiveRange();
        int i6 = this.f24337w;
        float f4 = i4;
        float f5 = i5;
        canvas.drawLine(i6 + (activeRange[0] * f4), f5, i6 + (activeRange[1] * f4), f5, this.f24315b);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.H.size() == arrayList.size() && this.H.equals(arrayList)) {
                return;
            }
            this.H = arrayList;
            this.Q = true;
            this.J = 0;
            d0();
            n();
            r();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void t(@NonNull Canvas canvas, int i4, int i5) {
        int i6;
        float[] activeRange = getActiveRange();
        float f4 = i4;
        float f5 = this.f24337w + (activeRange[1] * f4);
        if (f5 < i6 + i4) {
            float f6 = i5;
            canvas.drawLine(f5, f6, i6 + i4, f6, this.f24313a);
        }
        int i7 = this.f24337w;
        float f7 = i7 + (activeRange[0] * f4);
        if (f7 > i7) {
            float f8 = i5;
            canvas.drawLine(i7, f8, f7, f8, this.f24313a);
        }
    }

    private void u(@NonNull Canvas canvas, int i4, int i5) {
        if (!isEnabled()) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.f24337w + (N(it.next().floatValue()) * i4), i5, this.f24339y, this.f24317c);
            }
        }
        Iterator<Float> it2 = this.H.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int N = this.f24337w + ((int) (N(it2.next().floatValue()) * i4));
            int i6 = this.f24339y;
            canvas.translate(N - i6, i5 - i6);
            this.W.draw(canvas);
            canvas.restore();
        }
    }

    private void v() {
        if (this.f24335u == 2) {
            return;
        }
        if (!this.f24328n) {
            this.f24328n = true;
            ValueAnimator m4 = m(true);
            this.f24329o = m4;
            this.f24330p = null;
            m4.start();
        }
        Iterator<TooltipDrawable> it = this.f24325k.iterator();
        for (int i4 = 0; i4 < this.H.size() && it.hasNext(); i4++) {
            if (i4 != this.J) {
                W(it.next(), this.H.get(i4).floatValue());
            }
        }
        if (it.hasNext()) {
            W(it.next(), this.H.get(this.J).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f24325k.size()), Integer.valueOf(this.H.size())));
    }

    private void w() {
        if (this.f24328n) {
            this.f24328n = false;
            ValueAnimator m4 = m(false);
            this.f24330p = m4;
            this.f24329o = null;
            m4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    for (TooltipDrawable tooltipDrawable : BaseSlider.this.f24325k) {
                        ViewUtils.getContentViewOverlay(BaseSlider.this).remove(tooltipDrawable);
                    }
                }
            });
            this.f24330p.start();
        }
    }

    private void x(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 17) {
                    if (i4 == 66) {
                        M(Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                M(Integer.MAX_VALUE);
                return;
            }
            L(Integer.MIN_VALUE);
            return;
        }
        L(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y(float f4) {
        String str;
        if (hasLabelFormatter()) {
            return this.D.getFormattedValue(f4);
        }
        if (((int) f4) == f4) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, Float.valueOf(f4));
    }

    private static float z(ValueAnimator valueAnimator, float f4) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
            return floatValue;
        }
        return f4;
    }

    final boolean F() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    protected boolean S() {
        boolean z3;
        if (this.I != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float m02 = m0(valueOfTouchPositionAbsolute);
        this.I = 0;
        float abs = Math.abs(this.H.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i4 = 1; i4 < this.H.size(); i4++) {
            float abs2 = Math.abs(this.H.get(i4).floatValue() - valueOfTouchPositionAbsolute);
            float m03 = m0(this.H.get(i4).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            if (!F() ? m03 - m02 < 0.0f : m03 - m02 > 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.I = i4;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(m03 - m02) < this.f24331q) {
                    this.I = -1;
                    return false;
                } else if (z3) {
                    this.I = i4;
                }
            }
            abs = abs2;
        }
        if (this.I != -1) {
            return true;
        }
        return false;
    }

    public void addOnChangeListener(@NonNull L l4) {
        this.f24326l.add(l4);
    }

    public void addOnSliderTouchListener(@NonNull T t3) {
        this.f24327m.add(t3);
    }

    void c0(int i4, Rect rect) {
        int N = this.f24337w + ((int) (N(getValues().get(i4).floatValue()) * this.N));
        int l4 = l();
        int i5 = this.f24339y;
        rect.set(N - i5, l4 - i5, N + i5, l4 + i5);
    }

    public void clearOnChangeListeners() {
        this.f24326l.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.f24327m.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f24321g.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f24313a.setColor(B(this.V));
        this.f24315b.setColor(B(this.U));
        this.f24319e.setColor(B(this.T));
        this.f24320f.setColor(B(this.S));
        for (TooltipDrawable tooltipDrawable : this.f24325k) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.W.isStateful()) {
            this.W.setState(getDrawableState());
        }
        this.f24318d.setColor(B(this.R));
        this.f24318d.setAlpha(63);
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.f24321g.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.I;
    }

    public int getFocusedThumbIndex() {
        return this.J;
    }

    @Dimension
    public int getHaloRadius() {
        return this.f24340z;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.R;
    }

    public int getLabelBehavior() {
        return this.f24335u;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.K;
    }

    public float getThumbElevation() {
        return this.W.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.f24339y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.W.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.W.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.W.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.S;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.T;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.T.equals(this.S)) {
            return this.S;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.U;
    }

    @Dimension
    public int getTrackHeight() {
        return this.f24336v;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.V;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.f24337w;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.V.equals(this.U)) {
            return this.U;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.N;
    }

    public float getValueFrom() {
        return this.F;
    }

    public float getValueTo() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.H);
    }

    public boolean hasLabelFormatter() {
        if (this.D != null) {
            return true;
        }
        return false;
    }

    public boolean isTickVisible() {
        return this.M;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable tooltipDrawable : this.f24325k) {
            h(tooltipDrawable);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f24323i;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.f24328n = false;
        for (TooltipDrawable tooltipDrawable : this.f24325k) {
            o(tooltipDrawable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.Q) {
            f0();
            H();
        }
        super.onDraw(canvas);
        int l4 = l();
        t(canvas, this.N, l4);
        if (((Float) Collections.max(getValues())).floatValue() > this.F) {
            s(canvas, this.N, l4);
        }
        J(canvas);
        if ((this.E || isFocused()) && isEnabled()) {
            I(canvas, this.N, l4);
            if (this.I != -1) {
                v();
            }
        }
        u(canvas, this.N, l4);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z3, int i4, @Nullable Rect rect) {
        super.onFocusChanged(z3, i4, rect);
        if (!z3) {
            this.I = -1;
            w();
            this.f24321g.clearKeyboardFocusForVirtualView(this.J);
            return;
        }
        x(i4);
        this.f24321g.requestKeyboardFocusForVirtualView(this.J);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i4, keyEvent);
        }
        if (this.H.size() == 1) {
            this.I = 0;
        }
        if (this.I == -1) {
            Boolean O = O(i4, keyEvent);
            if (O != null) {
                return O.booleanValue();
            }
            return super.onKeyDown(i4, keyEvent);
        }
        this.P |= keyEvent.isLongPress();
        Float i5 = i(i4);
        if (i5 != null) {
            if (Y(this.H.get(this.I).floatValue() + i5.floatValue())) {
                d0();
                postInvalidate();
            }
            return true;
        }
        if (i4 != 23) {
            if (i4 != 61) {
                if (i4 != 66) {
                    return super.onKeyDown(i4, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return L(1);
            } else {
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return L(-1);
            }
        }
        this.I = -1;
        w();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, @NonNull KeyEvent keyEvent) {
        this.P = false;
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6 = this.f24334t;
        int i7 = 0;
        if (this.f24335u == 1) {
            i7 = this.f24325k.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(i6 + i7, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.F = sliderState.f24350a;
        this.G = sliderState.f24351b;
        setValuesInternal(sliderState.f24352c);
        this.K = sliderState.f24353d;
        if (sliderState.f24354e) {
            requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f24350a = this.F;
        sliderState.f24351b = this.G;
        sliderState.f24352c = new ArrayList<>(this.H);
        sliderState.f24353d = this.K;
        sliderState.f24354e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        e0(i4);
        d0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x3 = motionEvent.getX();
        float f4 = (x3 - this.f24337w) / this.N;
        this.f24314a0 = f4;
        float max = Math.max(0.0f, f4);
        this.f24314a0 = max;
        this.f24314a0 = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.E) {
                        if (D() && Math.abs(x3 - this.B) < this.f24331q) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        P();
                    }
                    if (S()) {
                        this.E = true;
                        b0();
                        d0();
                        invalidate();
                    }
                }
            } else {
                this.E = false;
                MotionEvent motionEvent2 = this.C;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.C.getX() - motionEvent.getX()) <= this.f24331q && Math.abs(this.C.getY() - motionEvent.getY()) <= this.f24331q && S()) {
                    P();
                }
                if (this.I != -1) {
                    b0();
                    this.I = -1;
                    Q();
                }
                w();
                invalidate();
            }
        } else {
            this.B = x3;
            if (!D()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (S()) {
                    requestFocus();
                    this.E = true;
                    b0();
                    d0();
                    invalidate();
                    P();
                }
            }
        }
        setPressed(this.E);
        this.C = MotionEvent.obtain(motionEvent);
        return true;
    }

    public void removeOnChangeListener(@NonNull L l4) {
        this.f24326l.remove(l4);
    }

    public void removeOnSliderTouchListener(@NonNull T t3) {
        this.f24327m.remove(t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActiveThumbIndex(int i4) {
        this.I = i4;
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        int i4;
        super.setEnabled(z3);
        if (z3) {
            i4 = 0;
        } else {
            i4 = 2;
        }
        setLayerType(i4, null);
    }

    public void setFocusedThumbIndex(int i4) {
        if (i4 >= 0 && i4 < this.H.size()) {
            this.J = i4;
            this.f24321g.requestKeyboardFocusForVirtualView(i4);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i4) {
        if (i4 == this.f24340z) {
            return;
        }
        this.f24340z = i4;
        Drawable background = getBackground();
        if (!X() && (background instanceof RippleDrawable)) {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.f24340z);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i4) {
        setHaloRadius(getResources().getDimensionPixelSize(i4));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.R)) {
            return;
        }
        this.R = colorStateList;
        Drawable background = getBackground();
        if (!X() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f24318d.setColor(B(colorStateList));
        this.f24318d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i4) {
        if (this.f24335u != i4) {
            this.f24335u = i4;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.D = labelFormatter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSeparationUnit(int i4) {
        this.f24316b0 = i4;
        this.Q = true;
        postInvalidate();
    }

    public void setStepSize(float f4) {
        if (f4 >= 0.0f) {
            if (this.K != f4) {
                this.K = f4;
                this.Q = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f4), Float.valueOf(this.F), Float.valueOf(this.G)));
    }

    public void setThumbElevation(float f4) {
        this.W.setElevation(f4);
    }

    public void setThumbElevationResource(@DimenRes int i4) {
        setThumbElevation(getResources().getDimension(i4));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i4) {
        if (i4 == this.f24339y) {
            return;
        }
        this.f24339y = i4;
        K();
        this.W.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.f24339y).build());
        MaterialShapeDrawable materialShapeDrawable = this.W;
        int i5 = this.f24339y;
        materialShapeDrawable.setBounds(0, 0, i5 * 2, i5 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i4) {
        setThumbRadius(getResources().getDimensionPixelSize(i4));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.W.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i4) {
        if (i4 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i4));
        }
    }

    public void setThumbStrokeWidth(float f4) {
        this.W.setStrokeWidth(f4);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i4) {
        if (i4 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i4));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.W.getFillColor())) {
            return;
        }
        this.W.setFillColor(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.S)) {
            return;
        }
        this.S = colorStateList;
        this.f24320f.setColor(B(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.T)) {
            return;
        }
        this.T = colorStateList;
        this.f24319e.setColor(B(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z3) {
        if (this.M != z3) {
            this.M = z3;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.U)) {
            return;
        }
        this.U = colorStateList;
        this.f24315b.setColor(B(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i4) {
        if (this.f24336v != i4) {
            this.f24336v = i4;
            C();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        this.f24313a.setColor(B(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f4) {
        this.F = f4;
        this.Q = true;
        postInvalidate();
    }

    public void setValueTo(float f4) {
        this.G = f4;
        this.Q = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context, @Nullable final AttributeSet attributeSet, final int i4) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i4, f24312d0), attributeSet, i4);
        this.f24325k = new ArrayList();
        this.f24326l = new ArrayList();
        this.f24327m = new ArrayList();
        this.f24328n = false;
        this.E = false;
        this.H = new ArrayList<>();
        this.I = -1;
        this.J = -1;
        this.K = 0.0f;
        this.M = true;
        this.P = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.W = materialShapeDrawable;
        this.f24316b0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f24313a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f24315b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f24317c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f24318d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f24319e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f24320f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        G(context2.getResources());
        this.f24324j = new TooltipDrawableFactory() { // from class: com.google.android.material.slider.BaseSlider.1
            @Override // com.google.android.material.slider.BaseSlider.TooltipDrawableFactory
            public TooltipDrawable a() {
                TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), attributeSet, R.styleable.Slider, i4, BaseSlider.f24312d0, new int[0]);
                TooltipDrawable R = BaseSlider.R(BaseSlider.this.getContext(), obtainStyledAttributes);
                obtainStyledAttributes.recycle();
                return R;
            }
        };
        U(context2, attributeSet, i4);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.f24331q = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.f24321g = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        this.f24322h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}
