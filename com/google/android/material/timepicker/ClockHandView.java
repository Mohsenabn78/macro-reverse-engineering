package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ClockHandView extends View {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f24727a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24728b;

    /* renamed from: c  reason: collision with root package name */
    private float f24729c;

    /* renamed from: d  reason: collision with root package name */
    private float f24730d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24731e;

    /* renamed from: f  reason: collision with root package name */
    private int f24732f;

    /* renamed from: g  reason: collision with root package name */
    private final List<OnRotateListener> f24733g;

    /* renamed from: h  reason: collision with root package name */
    private final int f24734h;

    /* renamed from: i  reason: collision with root package name */
    private final float f24735i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f24736j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f24737k;
    @Px

    /* renamed from: l  reason: collision with root package name */
    private final int f24738l;

    /* renamed from: m  reason: collision with root package name */
    private float f24739m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24740n;

    /* renamed from: o  reason: collision with root package name */
    private OnActionUpListener f24741o;

    /* renamed from: p  reason: collision with root package name */
    private double f24742p;

    /* renamed from: q  reason: collision with root package name */
    private int f24743q;

    /* loaded from: classes5.dex */
    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z3);
    }

    /* loaded from: classes5.dex */
    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z3);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void c(Canvas canvas) {
        int width;
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f4 = height;
        this.f24736j.setStrokeWidth(0.0f);
        canvas.drawCircle((this.f24743q * ((float) Math.cos(this.f24742p))) + width2, (this.f24743q * ((float) Math.sin(this.f24742p))) + f4, this.f24734h, this.f24736j);
        double sin = Math.sin(this.f24742p);
        double cos = Math.cos(this.f24742p);
        this.f24736j.setStrokeWidth(this.f24738l);
        canvas.drawLine(width2, f4, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.f24736j);
        canvas.drawCircle(width2, f4, this.f24735i, this.f24736j);
    }

    private int e(float f4, float f5) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f5 - (getHeight() / 2), f4 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }

    private Pair<Float, Float> h(float f4) {
        float f5 = f();
        if (Math.abs(f5 - f4) > 180.0f) {
            if (f5 > 180.0f && f4 < 180.0f) {
                f4 += 360.0f;
            }
            if (f5 < 180.0f && f4 > 180.0f) {
                f5 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f5), Float.valueOf(f4));
    }

    private boolean i(float f4, float f5, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        float e4 = e(f4, f5);
        boolean z7 = false;
        if (f() != e4) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4 && z6) {
            return true;
        }
        if (!z6 && !z3) {
            return false;
        }
        if (z5 && this.f24728b) {
            z7 = true;
        }
        m(e4, z7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z3) {
        float f5 = f4 % 360.0f;
        this.f24739m = f5;
        this.f24742p = Math.toRadians(f5 - 90.0f);
        float width = (getWidth() / 2) + (this.f24743q * ((float) Math.cos(this.f24742p)));
        float height = (getHeight() / 2) + (this.f24743q * ((float) Math.sin(this.f24742p)));
        RectF rectF = this.f24737k;
        int i4 = this.f24734h;
        rectF.set(width - i4, height - i4, width + i4, height + i4);
        for (OnRotateListener onRotateListener : this.f24733g) {
            onRotateListener.onRotate(f5, z3);
        }
        invalidate();
    }

    public void b(OnRotateListener onRotateListener) {
        this.f24733g.add(onRotateListener);
    }

    public RectF d() {
        return this.f24737k;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 360.0d)
    public float f() {
        return this.f24739m;
    }

    public int g() {
        return this.f24734h;
    }

    public void j(boolean z3) {
        this.f24728b = z3;
    }

    public void k(@Dimension int i4) {
        this.f24743q = i4;
        invalidate();
    }

    public void l(@FloatRange(from = 0.0d, to = 360.0d) float f4) {
        m(f4, false);
    }

    public void m(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z3) {
        ValueAnimator valueAnimator = this.f24727a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z3) {
            n(f4, false);
            return;
        }
        Pair<Float, Float> h4 = h(f4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h4.first).floatValue(), ((Float) h4.second).floatValue());
        this.f24727a = ofFloat;
        ofFloat.setDuration(200L);
        this.f24727a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.ClockHandView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.this.n(((Float) valueAnimator2.getAnimatedValue()).floatValue(), true);
            }
        });
        this.f24727a.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.timepicker.ClockHandView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.f24727a.start();
    }

    public void o(OnActionUpListener onActionUpListener) {
        this.f24741o = onActionUpListener;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        OnActionUpListener onActionUpListener;
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z3 = false;
                z4 = false;
            } else {
                int i4 = (int) (x3 - this.f24729c);
                int i5 = (int) (y3 - this.f24730d);
                if ((i4 * i4) + (i5 * i5) > this.f24732f) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.f24731e = z6;
                boolean z7 = this.f24740n;
                if (actionMasked == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z7;
            }
            z5 = false;
        } else {
            this.f24729c = x3;
            this.f24730d = y3;
            this.f24731e = true;
            this.f24740n = false;
            z3 = false;
            z4 = false;
            z5 = true;
        }
        boolean i6 = i(x3, y3, z4, z5, z3) | this.f24740n;
        this.f24740n = i6;
        if (i6 && z3 && (onActionUpListener = this.f24741o) != null) {
            onActionUpListener.onActionUp(e(x3, y3), this.f24731e);
        }
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f24733g = new ArrayList();
        Paint paint = new Paint();
        this.f24736j = paint;
        this.f24737k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i4, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f24743q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f24734h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f24738l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f24735i = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f24732f = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}
