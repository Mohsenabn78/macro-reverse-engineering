package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.TransitionUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class MaterialContainerTransform extends Transition {
    private static final String[] A = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    private static final ProgressThresholdsGroup B = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup C = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup D = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup E = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;

    /* renamed from: z  reason: collision with root package name */
    private static final String f24900z = "MaterialContainerTransform";

    /* renamed from: a  reason: collision with root package name */
    private boolean f24901a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24902b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24903c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24904d;
    @IdRes

    /* renamed from: e  reason: collision with root package name */
    private int f24905e;
    @IdRes

    /* renamed from: f  reason: collision with root package name */
    private int f24906f;
    @IdRes

    /* renamed from: g  reason: collision with root package name */
    private int f24907g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f24908h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f24909i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f24910j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f24911k;

    /* renamed from: l  reason: collision with root package name */
    private int f24912l;

    /* renamed from: m  reason: collision with root package name */
    private int f24913m;

    /* renamed from: n  reason: collision with root package name */
    private int f24914n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private View f24915o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private View f24916p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private ShapeAppearanceModel f24917q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private ShapeAppearanceModel f24918r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private ProgressThresholds f24919s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private ProgressThresholds f24920t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private ProgressThresholds f24921u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private ProgressThresholds f24922v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f24923w;

    /* renamed from: x  reason: collision with root package name */
    private float f24924x;

    /* renamed from: y  reason: collision with root package name */
    private float f24925y;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface FitMode {
    }

    /* loaded from: classes5.dex */
    public static class ProgressThresholds {
        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)

        /* renamed from: a  reason: collision with root package name */
        private final float f24933a;
        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)

        /* renamed from: b  reason: collision with root package name */
        private final float f24934b;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
            this.f24933a = f4;
            this.f24934b = f5;
        }

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        public float getEnd() {
            return this.f24934b;
        }

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        public float getStart() {
            return this.f24933a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ProgressThresholdsGroup {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ProgressThresholds f24935a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final ProgressThresholds f24936b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final ProgressThresholds f24937c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final ProgressThresholds f24938d;

        private ProgressThresholdsGroup(@NonNull ProgressThresholds progressThresholds, @NonNull ProgressThresholds progressThresholds2, @NonNull ProgressThresholds progressThresholds3, @NonNull ProgressThresholds progressThresholds4) {
            this.f24935a = progressThresholds;
            this.f24936b = progressThresholds2;
            this.f24937c = progressThresholds3;
            this.f24938d = progressThresholds4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TransitionDirection {
    }

    /* loaded from: classes5.dex */
    private static final class TransitionDrawable extends Drawable {
        private final ProgressThresholdsGroup A;
        private final FadeModeEvaluator B;
        private final FitModeEvaluator C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private FadeModeResult G;
        private FitModeResult H;
        private RectF I;
        private float J;
        private float K;
        private float L;

        /* renamed from: a  reason: collision with root package name */
        private final View f24939a;

        /* renamed from: b  reason: collision with root package name */
        private final RectF f24940b;

        /* renamed from: c  reason: collision with root package name */
        private final ShapeAppearanceModel f24941c;

        /* renamed from: d  reason: collision with root package name */
        private final float f24942d;

        /* renamed from: e  reason: collision with root package name */
        private final View f24943e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f24944f;

        /* renamed from: g  reason: collision with root package name */
        private final ShapeAppearanceModel f24945g;

        /* renamed from: h  reason: collision with root package name */
        private final float f24946h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f24947i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f24948j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f24949k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f24950l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f24951m;

        /* renamed from: n  reason: collision with root package name */
        private final MaskEvaluator f24952n;

        /* renamed from: o  reason: collision with root package name */
        private final PathMeasure f24953o;

        /* renamed from: p  reason: collision with root package name */
        private final float f24954p;

        /* renamed from: q  reason: collision with root package name */
        private final float[] f24955q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f24956r;

        /* renamed from: s  reason: collision with root package name */
        private final float f24957s;

        /* renamed from: t  reason: collision with root package name */
        private final float f24958t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f24959u;

        /* renamed from: v  reason: collision with root package name */
        private final MaterialShapeDrawable f24960v;

        /* renamed from: w  reason: collision with root package name */
        private final RectF f24961w;

        /* renamed from: x  reason: collision with root package name */
        private final RectF f24962x;

        /* renamed from: y  reason: collision with root package name */
        private final RectF f24963y;

        /* renamed from: z  reason: collision with root package name */
        private final RectF f24964z;

        private static float d(RectF rectF, float f4) {
            return ((rectF.centerX() / (f4 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float e(RectF rectF, float f4) {
            return (rectF.centerY() / f4) * 1.5f;
        }

        private void f(Canvas canvas, RectF rectF, Path path, @ColorInt int i4) {
            PointF m4 = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(m4.x, m4.y);
                return;
            }
            path.lineTo(m4.x, m4.y);
            this.E.setColor(i4);
            canvas.drawPath(path, this.E);
        }

        private void g(Canvas canvas, RectF rectF, @ColorInt int i4) {
            this.E.setColor(i4);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f24952n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.f24960v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f24960v.setElevation(this.J);
            this.f24960v.setShadowVerticalOffset((int) this.K);
            this.f24960v.setShapeAppearanceModel(this.f24952n.c());
            this.f24960v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel c4 = this.f24952n.c();
            if (c4.isRoundRect(this.I)) {
                float cornerSize = c4.getTopLeftCornerSize().getCornerSize(this.I);
                canvas.drawRoundRect(this.I, cornerSize, cornerSize, this.f24950l);
                return;
            }
            canvas.drawPath(this.f24952n.d(), this.f24950l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f24949k);
            Rect bounds = getBounds();
            RectF rectF = this.f24963y;
            TransitionUtils.t(canvas, bounds, rectF.left, rectF.top, this.H.f24890b, this.G.f24869b, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f24943e.draw(canvas2);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f24948j);
            Rect bounds = getBounds();
            RectF rectF = this.f24961w;
            TransitionUtils.t(canvas, bounds, rectF.left, rectF.top, this.H.f24889a, this.G.f24868a, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f24939a.draw(canvas2);
                }
            });
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(float f4) {
            if (this.L != f4) {
                p(f4);
            }
        }

        private void p(float f4) {
            float j4;
            float f5;
            float f6;
            RectF rectF;
            this.L = f4;
            Paint paint = this.f24951m;
            if (this.f24956r) {
                j4 = TransitionUtils.j(0.0f, 255.0f, f4);
            } else {
                j4 = TransitionUtils.j(255.0f, 0.0f, f4);
            }
            paint.setAlpha((int) j4);
            this.f24953o.getPosTan(this.f24954p * f4, this.f24955q, null);
            float[] fArr = this.f24955q;
            float f7 = fArr[0];
            float f8 = fArr[1];
            int i4 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
            if (i4 > 0 || f4 < 0.0f) {
                if (i4 > 0) {
                    f6 = (f4 - 1.0f) / 0.00999999f;
                    f5 = 0.99f;
                } else {
                    f5 = 0.01f;
                    f6 = (f4 / 0.01f) * (-1.0f);
                }
                this.f24953o.getPosTan(this.f24954p * f5, fArr, null);
                float[] fArr2 = this.f24955q;
                f7 += (f7 - fArr2[0]) * f6;
                f8 += (f8 - fArr2[1]) * f6;
            }
            float f9 = f7;
            float f10 = f8;
            FitModeResult a4 = this.C.a(f4, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24936b.f24933a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24936b.f24934b))).floatValue(), this.f24940b.width(), this.f24940b.height(), this.f24944f.width(), this.f24944f.height());
            this.H = a4;
            RectF rectF2 = this.f24961w;
            float f11 = a4.f24891c;
            rectF2.set(f9 - (f11 / 2.0f), f10, (f11 / 2.0f) + f9, a4.f24892d + f10);
            RectF rectF3 = this.f24963y;
            FitModeResult fitModeResult = this.H;
            float f12 = fitModeResult.f24893e;
            rectF3.set(f9 - (f12 / 2.0f), f10, f9 + (f12 / 2.0f), fitModeResult.f24894f + f10);
            this.f24962x.set(this.f24961w);
            this.f24964z.set(this.f24963y);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24937c.f24933a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24937c.f24934b))).floatValue();
            boolean b4 = this.C.b(this.H);
            if (b4) {
                rectF = this.f24962x;
            } else {
                rectF = this.f24964z;
            }
            float k4 = TransitionUtils.k(0.0f, 1.0f, floatValue, floatValue2, f4);
            if (!b4) {
                k4 = 1.0f - k4;
            }
            this.C.c(rectF, k4, this.H);
            this.I = new RectF(Math.min(this.f24962x.left, this.f24964z.left), Math.min(this.f24962x.top, this.f24964z.top), Math.max(this.f24962x.right, this.f24964z.right), Math.max(this.f24962x.bottom, this.f24964z.bottom));
            this.f24952n.b(f4, this.f24941c, this.f24945g, this.f24961w, this.f24962x, this.f24964z, this.A.f24938d);
            this.J = TransitionUtils.j(this.f24942d, this.f24946h, f4);
            float d4 = d(this.I, this.f24957s);
            float e4 = e(this.I, this.f24958t);
            float f13 = this.J;
            float f14 = (int) (e4 * f13);
            this.K = f14;
            this.f24950l.setShadowLayer(f13, (int) (d4 * f13), f14, 754974720);
            this.G = this.B.a(f4, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24935a.f24933a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f24935a.f24934b))).floatValue(), 0.35f);
            if (this.f24948j.getColor() != 0) {
                this.f24948j.setAlpha(this.G.f24868a);
            }
            if (this.f24949k.getColor() != 0) {
                this.f24949k.setAlpha(this.G.f24869b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            int i4;
            if (this.f24951m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f24951m);
            }
            if (this.D) {
                i4 = canvas.save();
            } else {
                i4 = -1;
            }
            if (this.f24959u && this.J > 0.0f) {
                h(canvas);
            }
            this.f24952n.a(canvas);
            n(canvas, this.f24947i);
            if (this.G.f24870c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(i4);
                f(canvas, this.f24961w, this.F, -65281);
                g(canvas, this.f24962x, InputDeviceCompat.SOURCE_ANY);
                g(canvas, this.f24961w, -16711936);
                g(canvas, this.f24964z, -16711681);
                g(canvas, this.f24963y, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i4) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f4, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f5, @ColorInt int i4, @ColorInt int i5, @ColorInt int i6, int i7, boolean z3, boolean z4, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z5) {
            Paint paint = new Paint();
            this.f24947i = paint;
            Paint paint2 = new Paint();
            this.f24948j = paint2;
            Paint paint3 = new Paint();
            this.f24949k = paint3;
            this.f24950l = new Paint();
            Paint paint4 = new Paint();
            this.f24951m = paint4;
            this.f24952n = new MaskEvaluator();
            this.f24955q = r7;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f24960v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f24939a = view;
            this.f24940b = rectF;
            this.f24941c = shapeAppearanceModel;
            this.f24942d = f4;
            this.f24943e = view2;
            this.f24944f = rectF2;
            this.f24945g = shapeAppearanceModel2;
            this.f24946h = f5;
            this.f24956r = z3;
            this.f24959u = z4;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            this.D = z5;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.f24957s = displayMetrics.widthPixels;
            this.f24958t = displayMetrics.heightPixels;
            paint.setColor(i4);
            paint2.setColor(i5);
            paint3.setColor(i6);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f24961w = rectF3;
            this.f24962x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f24963y = rectF4;
            this.f24964z = new RectF(rectF4);
            PointF m4 = m(rectF);
            PointF m5 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m4.x, m4.y, m5.x, m5.y), false);
            this.f24953o = pathMeasure;
            this.f24954p = pathMeasure.getLength();
            float[] fArr = {rectF.centerX(), rectF.top};
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(TransitionUtils.c(i7));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public MaterialContainerTransform() {
        this.f24901a = false;
        this.f24902b = false;
        this.f24903c = false;
        this.f24904d = false;
        this.f24905e = 16908290;
        this.f24906f = -1;
        this.f24907g = -1;
        this.f24908h = 0;
        this.f24909i = 0;
        this.f24910j = 0;
        this.f24911k = 1375731712;
        this.f24912l = 0;
        this.f24913m = 0;
        this.f24914n = 0;
        this.f24923w = Build.VERSION.SDK_INT >= 28;
        this.f24924x = -1.0f;
        this.f24925y = -1.0f;
    }

    private ProgressThresholdsGroup b(boolean z3) {
        PathMotion pathMotion = getPathMotion();
        if (!(pathMotion instanceof ArcMotion) && !(pathMotion instanceof MaterialArcMotion)) {
            return h(z3, B, C);
        }
        return h(z3, D, E);
    }

    private static RectF c(View view, @Nullable View view2, float f4, float f5) {
        if (view2 != null) {
            RectF g4 = TransitionUtils.g(view2);
            g4.offset(f4, f5);
            return g4;
        }
        return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
    }

    private static ShapeAppearanceModel d(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.b(g(view, shapeAppearanceModel), rectF);
    }

    private static void e(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i4, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF g4;
        if (i4 != -1) {
            transitionValues.view = TransitionUtils.f(transitionValues.view, i4);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i5 = R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i5) instanceof View) {
                transitionValues.view.setTag(i5, null);
                transitionValues.view = (View) transitionValues.view.getTag(i5);
            }
        }
        View view3 = transitionValues.view;
        if (ViewCompat.isLaidOut(view3) || view3.getWidth() != 0 || view3.getHeight() != 0) {
            if (view3.getParent() == null) {
                g4 = TransitionUtils.h(view3);
            } else {
                g4 = TransitionUtils.g(view3);
            }
            transitionValues.values.put("materialContainerTransition:bounds", g4);
            transitionValues.values.put("materialContainerTransition:shapeAppearance", d(view3, g4, shapeAppearanceModel));
        }
    }

    private static float f(float f4, View view) {
        if (f4 == -1.0f) {
            return ViewCompat.getElevation(view);
        }
        return f4;
    }

    private static ShapeAppearanceModel g(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i4 = R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i4) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i4);
        }
        Context context = view.getContext();
        int i5 = i(context);
        if (i5 != -1) {
            return ShapeAppearanceModel.builder(context, i5, 0).build();
        }
        if (view instanceof Shapeable) {
            return ((Shapeable) view).getShapeAppearanceModel();
        }
        return ShapeAppearanceModel.builder().build();
    }

    private ProgressThresholdsGroup h(boolean z3, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z3) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.d(this.f24919s, progressThresholdsGroup.f24935a), (ProgressThresholds) TransitionUtils.d(this.f24920t, progressThresholdsGroup.f24936b), (ProgressThresholds) TransitionUtils.d(this.f24921u, progressThresholdsGroup.f24937c), (ProgressThresholds) TransitionUtils.d(this.f24922v, progressThresholdsGroup.f24938d));
    }

    @StyleRes
    private static int i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean j(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i4 = this.f24912l;
        if (i4 != 0) {
            if (i4 == 1) {
                return true;
            }
            if (i4 == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.f24912l);
        } else if (TransitionUtils.a(rectF2) <= TransitionUtils.a(rectF)) {
            return false;
        } else {
            return true;
        }
    }

    private void k(Context context, boolean z3) {
        int i4;
        TransitionUtils.p(this, context, R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (z3) {
            i4 = R.attr.motionDurationLong1;
        } else {
            i4 = R.attr.motionDurationMedium2;
        }
        TransitionUtils.o(this, context, i4);
        if (!this.f24903c) {
            TransitionUtils.q(this, context, R.attr.motionPath);
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.f24916p, this.f24907g, this.f24918r);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.f24915o, this.f24906f, this.f24917q);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View view;
        final View e4;
        View view2;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && shapeAppearanceModel != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF2 != null && shapeAppearanceModel2 != null) {
                    final View view3 = transitionValues.view;
                    final View view4 = transitionValues2.view;
                    if (view4.getParent() != null) {
                        view = view4;
                    } else {
                        view = view3;
                    }
                    if (this.f24905e == view.getId()) {
                        e4 = (View) view.getParent();
                        view2 = view;
                    } else {
                        e4 = TransitionUtils.e(view, this.f24905e);
                        view2 = null;
                    }
                    RectF g4 = TransitionUtils.g(e4);
                    float f4 = -g4.left;
                    float f5 = -g4.top;
                    RectF c4 = c(e4, view2, f4, f5);
                    rectF.offset(f4, f5);
                    rectF2.offset(f4, f5);
                    boolean j4 = j(rectF, rectF2);
                    if (!this.f24904d) {
                        k(view.getContext(), j4);
                    }
                    final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view3, rectF, shapeAppearanceModel, f(this.f24924x, view3), view4, rectF2, shapeAppearanceModel2, f(this.f24925y, view4), this.f24908h, this.f24909i, this.f24910j, this.f24911k, j4, this.f24923w, FadeModeEvaluators.a(this.f24913m, j4), FitModeEvaluators.a(this.f24914n, j4, rectF, rectF2), b(j4), this.f24901a);
                    transitionDrawable.setBounds(Math.round(c4.left), Math.round(c4.top), Math.round(c4.right), Math.round(c4.bottom));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.MaterialContainerTransform.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            transitionDrawable.o(valueAnimator.getAnimatedFraction());
                        }
                    });
                    addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransform.2
                        @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            MaterialContainerTransform.this.removeListener(this);
                            if (MaterialContainerTransform.this.f24902b) {
                                return;
                            }
                            view3.setAlpha(1.0f);
                            view4.setAlpha(1.0f);
                            ViewUtils.getOverlay(e4).remove(transitionDrawable);
                        }

                        @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionStart(@NonNull Transition transition) {
                            ViewUtils.getOverlay(e4).add(transitionDrawable);
                            view3.setAlpha(0.0f);
                            view4.setAlpha(0.0f);
                        }
                    });
                    return ofFloat;
                }
                Log.w(f24900z, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                return null;
            }
            Log.w(f24900z, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.f24908h;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.f24905e;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.f24910j;
    }

    public float getEndElevation() {
        return this.f24925y;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.f24918r;
    }

    @Nullable
    public View getEndView() {
        return this.f24916p;
    }

    @IdRes
    public int getEndViewId() {
        return this.f24907g;
    }

    public int getFadeMode() {
        return this.f24913m;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.f24919s;
    }

    public int getFitMode() {
        return this.f24914n;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.f24921u;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.f24920t;
    }

    @ColorInt
    public int getScrimColor() {
        return this.f24911k;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.f24922v;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.f24909i;
    }

    public float getStartElevation() {
        return this.f24924x;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.f24917q;
    }

    @Nullable
    public View getStartView() {
        return this.f24915o;
    }

    @IdRes
    public int getStartViewId() {
        return this.f24906f;
    }

    public int getTransitionDirection() {
        return this.f24912l;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return A;
    }

    public boolean isDrawDebugEnabled() {
        return this.f24901a;
    }

    public boolean isElevationShadowEnabled() {
        return this.f24923w;
    }

    public boolean isHoldAtEndEnabled() {
        return this.f24902b;
    }

    public void setAllContainerColors(@ColorInt int i4) {
        this.f24908h = i4;
        this.f24909i = i4;
        this.f24910j = i4;
    }

    public void setContainerColor(@ColorInt int i4) {
        this.f24908h = i4;
    }

    public void setDrawDebugEnabled(boolean z3) {
        this.f24901a = z3;
    }

    public void setDrawingViewId(@IdRes int i4) {
        this.f24905e = i4;
    }

    public void setElevationShadowEnabled(boolean z3) {
        this.f24923w = z3;
    }

    public void setEndContainerColor(@ColorInt int i4) {
        this.f24910j = i4;
    }

    public void setEndElevation(float f4) {
        this.f24925y = f4;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f24918r = shapeAppearanceModel;
    }

    public void setEndView(@Nullable View view) {
        this.f24916p = view;
    }

    public void setEndViewId(@IdRes int i4) {
        this.f24907g = i4;
    }

    public void setFadeMode(int i4) {
        this.f24913m = i4;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f24919s = progressThresholds;
    }

    public void setFitMode(int i4) {
        this.f24914n = i4;
    }

    public void setHoldAtEndEnabled(boolean z3) {
        this.f24902b = z3;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f24903c = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f24921u = progressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f24920t = progressThresholds;
    }

    public void setScrimColor(@ColorInt int i4) {
        this.f24911k = i4;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f24922v = progressThresholds;
    }

    public void setStartContainerColor(@ColorInt int i4) {
        this.f24909i = i4;
    }

    public void setStartElevation(float f4) {
        this.f24924x = f4;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f24917q = shapeAppearanceModel;
    }

    public void setStartView(@Nullable View view) {
        this.f24915o = view;
    }

    public void setStartViewId(@IdRes int i4) {
        this.f24906f = i4;
    }

    public void setTransitionDirection(int i4) {
        this.f24912l = i4;
    }

    public MaterialContainerTransform(@NonNull Context context, boolean z3) {
        this.f24901a = false;
        this.f24902b = false;
        this.f24903c = false;
        this.f24904d = false;
        this.f24905e = 16908290;
        this.f24906f = -1;
        this.f24907g = -1;
        this.f24908h = 0;
        this.f24909i = 0;
        this.f24910j = 0;
        this.f24911k = 1375731712;
        this.f24912l = 0;
        this.f24913m = 0;
        this.f24914n = 0;
        this.f24923w = Build.VERSION.SDK_INT >= 28;
        this.f24924x = -1.0f;
        this.f24925y = -1.0f;
        k(context, z3);
        this.f24904d = true;
    }
}
