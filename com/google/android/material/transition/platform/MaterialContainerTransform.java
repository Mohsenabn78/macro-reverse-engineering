package com.google.android.material.transition.platform;

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
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
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
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.platform.TransitionUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
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
    private static final String f25038z = "MaterialContainerTransform";

    /* renamed from: a  reason: collision with root package name */
    private boolean f25039a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25040b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25041c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25042d;
    @IdRes

    /* renamed from: e  reason: collision with root package name */
    private int f25043e;
    @IdRes

    /* renamed from: f  reason: collision with root package name */
    private int f25044f;
    @IdRes

    /* renamed from: g  reason: collision with root package name */
    private int f25045g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f25046h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f25047i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f25048j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f25049k;

    /* renamed from: l  reason: collision with root package name */
    private int f25050l;

    /* renamed from: m  reason: collision with root package name */
    private int f25051m;

    /* renamed from: n  reason: collision with root package name */
    private int f25052n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private View f25053o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private View f25054p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private ShapeAppearanceModel f25055q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private ShapeAppearanceModel f25056r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private ProgressThresholds f25057s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private ProgressThresholds f25058t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private ProgressThresholds f25059u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private ProgressThresholds f25060v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25061w;

    /* renamed from: x  reason: collision with root package name */
    private float f25062x;

    /* renamed from: y  reason: collision with root package name */
    private float f25063y;

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
        private final float f25071a;
        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)

        /* renamed from: b  reason: collision with root package name */
        private final float f25072b;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
            this.f25071a = f4;
            this.f25072b = f5;
        }

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        public float getEnd() {
            return this.f25072b;
        }

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        public float getStart() {
            return this.f25071a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ProgressThresholdsGroup {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ProgressThresholds f25073a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final ProgressThresholds f25074b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final ProgressThresholds f25075c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final ProgressThresholds f25076d;

        private ProgressThresholdsGroup(@NonNull ProgressThresholds progressThresholds, @NonNull ProgressThresholds progressThresholds2, @NonNull ProgressThresholds progressThresholds3, @NonNull ProgressThresholds progressThresholds4) {
            this.f25073a = progressThresholds;
            this.f25074b = progressThresholds2;
            this.f25075c = progressThresholds3;
            this.f25076d = progressThresholds4;
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
        private final View f25077a;

        /* renamed from: b  reason: collision with root package name */
        private final RectF f25078b;

        /* renamed from: c  reason: collision with root package name */
        private final ShapeAppearanceModel f25079c;

        /* renamed from: d  reason: collision with root package name */
        private final float f25080d;

        /* renamed from: e  reason: collision with root package name */
        private final View f25081e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f25082f;

        /* renamed from: g  reason: collision with root package name */
        private final ShapeAppearanceModel f25083g;

        /* renamed from: h  reason: collision with root package name */
        private final float f25084h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f25085i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f25086j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f25087k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f25088l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f25089m;

        /* renamed from: n  reason: collision with root package name */
        private final MaskEvaluator f25090n;

        /* renamed from: o  reason: collision with root package name */
        private final PathMeasure f25091o;

        /* renamed from: p  reason: collision with root package name */
        private final float f25092p;

        /* renamed from: q  reason: collision with root package name */
        private final float[] f25093q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f25094r;

        /* renamed from: s  reason: collision with root package name */
        private final float f25095s;

        /* renamed from: t  reason: collision with root package name */
        private final float f25096t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f25097u;

        /* renamed from: v  reason: collision with root package name */
        private final MaterialShapeDrawable f25098v;

        /* renamed from: w  reason: collision with root package name */
        private final RectF f25099w;

        /* renamed from: x  reason: collision with root package name */
        private final RectF f25100x;

        /* renamed from: y  reason: collision with root package name */
        private final RectF f25101y;

        /* renamed from: z  reason: collision with root package name */
        private final RectF f25102z;

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
            canvas.clipPath(this.f25090n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.f25098v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f25098v.setElevation(this.J);
            this.f25098v.setShadowVerticalOffset((int) this.K);
            this.f25098v.setShapeAppearanceModel(this.f25090n.c());
            this.f25098v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel c4 = this.f25090n.c();
            if (c4.isRoundRect(this.I)) {
                float cornerSize = c4.getTopLeftCornerSize().getCornerSize(this.I);
                canvas.drawRoundRect(this.I, cornerSize, cornerSize, this.f25088l);
                return;
            }
            canvas.drawPath(this.f25090n.d(), this.f25088l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f25087k);
            Rect bounds = getBounds();
            RectF rectF = this.f25101y;
            TransitionUtils.u(canvas, bounds, rectF.left, rectF.top, this.H.f25028b, this.G.f25007b, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f25081e.draw(canvas2);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f25086j);
            Rect bounds = getBounds();
            RectF rectF = this.f25099w;
            TransitionUtils.u(canvas, bounds, rectF.left, rectF.top, this.H.f25027a, this.G.f25006a, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f25077a.draw(canvas2);
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
            float k4;
            float f5;
            float f6;
            RectF rectF;
            this.L = f4;
            Paint paint = this.f25089m;
            if (this.f25094r) {
                k4 = TransitionUtils.k(0.0f, 255.0f, f4);
            } else {
                k4 = TransitionUtils.k(255.0f, 0.0f, f4);
            }
            paint.setAlpha((int) k4);
            this.f25091o.getPosTan(this.f25092p * f4, this.f25093q, null);
            float[] fArr = this.f25093q;
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
                this.f25091o.getPosTan(this.f25092p * f5, fArr, null);
                float[] fArr2 = this.f25093q;
                f7 += (f7 - fArr2[0]) * f6;
                f8 += (f8 - fArr2[1]) * f6;
            }
            float f9 = f7;
            float f10 = f8;
            FitModeResult a4 = this.C.a(f4, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25074b.f25071a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25074b.f25072b))).floatValue(), this.f25078b.width(), this.f25078b.height(), this.f25082f.width(), this.f25082f.height());
            this.H = a4;
            RectF rectF2 = this.f25099w;
            float f11 = a4.f25029c;
            rectF2.set(f9 - (f11 / 2.0f), f10, (f11 / 2.0f) + f9, a4.f25030d + f10);
            RectF rectF3 = this.f25101y;
            FitModeResult fitModeResult = this.H;
            float f12 = fitModeResult.f25031e;
            rectF3.set(f9 - (f12 / 2.0f), f10, f9 + (f12 / 2.0f), fitModeResult.f25032f + f10);
            this.f25100x.set(this.f25099w);
            this.f25102z.set(this.f25101y);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25075c.f25071a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25075c.f25072b))).floatValue();
            boolean b4 = this.C.b(this.H);
            if (b4) {
                rectF = this.f25100x;
            } else {
                rectF = this.f25102z;
            }
            float l4 = TransitionUtils.l(0.0f, 1.0f, floatValue, floatValue2, f4);
            if (!b4) {
                l4 = 1.0f - l4;
            }
            this.C.c(rectF, l4, this.H);
            this.I = new RectF(Math.min(this.f25100x.left, this.f25102z.left), Math.min(this.f25100x.top, this.f25102z.top), Math.max(this.f25100x.right, this.f25102z.right), Math.max(this.f25100x.bottom, this.f25102z.bottom));
            this.f25090n.b(f4, this.f25079c, this.f25083g, this.f25099w, this.f25100x, this.f25102z, this.A.f25076d);
            this.J = TransitionUtils.k(this.f25080d, this.f25084h, f4);
            float d4 = d(this.I, this.f25095s);
            float e4 = e(this.I, this.f25096t);
            float f13 = this.J;
            float f14 = (int) (e4 * f13);
            this.K = f14;
            this.f25088l.setShadowLayer(f13, (int) (d4 * f13), f14, 754974720);
            this.G = this.B.a(f4, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25073a.f25071a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f25073a.f25072b))).floatValue(), 0.35f);
            if (this.f25086j.getColor() != 0) {
                this.f25086j.setAlpha(this.G.f25006a);
            }
            if (this.f25087k.getColor() != 0) {
                this.f25087k.setAlpha(this.G.f25007b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            int i4;
            if (this.f25089m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f25089m);
            }
            if (this.D) {
                i4 = canvas.save();
            } else {
                i4 = -1;
            }
            if (this.f25097u && this.J > 0.0f) {
                h(canvas);
            }
            this.f25090n.a(canvas);
            n(canvas, this.f25085i);
            if (this.G.f25008c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(i4);
                f(canvas, this.f25099w, this.F, -65281);
                g(canvas, this.f25100x, InputDeviceCompat.SOURCE_ANY);
                g(canvas, this.f25099w, -16711936);
                g(canvas, this.f25102z, -16711681);
                g(canvas, this.f25101y, -16776961);
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
            this.f25085i = paint;
            Paint paint2 = new Paint();
            this.f25086j = paint2;
            Paint paint3 = new Paint();
            this.f25087k = paint3;
            this.f25088l = new Paint();
            Paint paint4 = new Paint();
            this.f25089m = paint4;
            this.f25090n = new MaskEvaluator();
            this.f25093q = r7;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f25098v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f25077a = view;
            this.f25078b = rectF;
            this.f25079c = shapeAppearanceModel;
            this.f25080d = f4;
            this.f25081e = view2;
            this.f25082f = rectF2;
            this.f25083g = shapeAppearanceModel2;
            this.f25084h = f5;
            this.f25094r = z3;
            this.f25097u = z4;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            this.D = z5;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.f25095s = displayMetrics.widthPixels;
            this.f25096t = displayMetrics.heightPixels;
            paint.setColor(i4);
            paint2.setColor(i5);
            paint3.setColor(i6);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f25099w = rectF3;
            this.f25100x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f25101y = rectF4;
            this.f25102z = new RectF(rectF4);
            PointF m4 = m(rectF);
            PointF m5 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m4.x, m4.y, m5.x, m5.y), false);
            this.f25091o = pathMeasure;
            this.f25092p = pathMeasure.getLength();
            float[] fArr = {rectF.centerX(), rectF.top};
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(TransitionUtils.c(i7));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public MaterialContainerTransform() {
        this.f25039a = false;
        this.f25040b = false;
        this.f25041c = false;
        this.f25042d = false;
        this.f25043e = 16908290;
        this.f25044f = -1;
        this.f25045g = -1;
        this.f25046h = 0;
        this.f25047i = 0;
        this.f25048j = 0;
        this.f25049k = 1375731712;
        this.f25050l = 0;
        this.f25051m = 0;
        this.f25052n = 0;
        this.f25061w = Build.VERSION.SDK_INT >= 28;
        this.f25062x = -1.0f;
        this.f25063y = -1.0f;
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
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.d(this.f25057s, progressThresholdsGroup.f25073a), (ProgressThresholds) TransitionUtils.d(this.f25058t, progressThresholdsGroup.f25074b), (ProgressThresholds) TransitionUtils.d(this.f25059u, progressThresholdsGroup.f25075c), (ProgressThresholds) TransitionUtils.d(this.f25060v, progressThresholdsGroup.f25076d));
    }

    @StyleRes
    private static int i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean j(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i4 = this.f25050l;
        if (i4 != 0) {
            if (i4 == 1) {
                return true;
            }
            if (i4 == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.f25050l);
        } else if (TransitionUtils.a(rectF2) <= TransitionUtils.a(rectF)) {
            return false;
        } else {
            return true;
        }
    }

    private void k(Context context, boolean z3) {
        int i4;
        TransitionUtils.q(this, context, R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (z3) {
            i4 = R.attr.motionDurationLong1;
        } else {
            i4 = R.attr.motionDurationMedium2;
        }
        TransitionUtils.p(this, context, i4);
        if (!this.f25041c) {
            TransitionUtils.r(this, context, R.attr.motionPath);
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.f25054p, this.f25045g, this.f25056r);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.f25053o, this.f25044f, this.f25055q);
    }

    @Override // android.transition.Transition
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
                    if (this.f25043e == view.getId()) {
                        e4 = (View) view.getParent();
                        view2 = view;
                    } else {
                        e4 = TransitionUtils.e(view, this.f25043e);
                        view2 = null;
                    }
                    RectF g4 = TransitionUtils.g(e4);
                    float f4 = -g4.left;
                    float f5 = -g4.top;
                    RectF c4 = c(e4, view2, f4, f5);
                    rectF.offset(f4, f5);
                    rectF2.offset(f4, f5);
                    boolean j4 = j(rectF, rectF2);
                    if (!this.f25042d) {
                        k(view.getContext(), j4);
                    }
                    final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view3, rectF, shapeAppearanceModel, f(this.f25062x, view3), view4, rectF2, shapeAppearanceModel2, f(this.f25063y, view4), this.f25046h, this.f25047i, this.f25048j, this.f25049k, j4, this.f25061w, FadeModeEvaluators.a(this.f25051m, j4), FitModeEvaluators.a(this.f25052n, j4, rectF, rectF2), b(j4), this.f25039a);
                    transitionDrawable.setBounds(Math.round(c4.left), Math.round(c4.top), Math.round(c4.right), Math.round(c4.bottom));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            transitionDrawable.o(valueAnimator.getAnimatedFraction());
                        }
                    });
                    addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.2
                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            MaterialContainerTransform.this.removeListener(this);
                            if (MaterialContainerTransform.this.f25040b) {
                                return;
                            }
                            view3.setAlpha(1.0f);
                            view4.setAlpha(1.0f);
                            ViewUtils.getOverlay(e4).remove(transitionDrawable);
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public void onTransitionStart(@NonNull Transition transition) {
                            ViewUtils.getOverlay(e4).add(transitionDrawable);
                            view3.setAlpha(0.0f);
                            view4.setAlpha(0.0f);
                        }
                    });
                    return ofFloat;
                }
                Log.w(f25038z, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                return null;
            }
            Log.w(f25038z, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.f25046h;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.f25043e;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.f25048j;
    }

    public float getEndElevation() {
        return this.f25063y;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.f25056r;
    }

    @Nullable
    public View getEndView() {
        return this.f25054p;
    }

    @IdRes
    public int getEndViewId() {
        return this.f25045g;
    }

    public int getFadeMode() {
        return this.f25051m;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.f25057s;
    }

    public int getFitMode() {
        return this.f25052n;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.f25059u;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.f25058t;
    }

    @ColorInt
    public int getScrimColor() {
        return this.f25049k;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.f25060v;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.f25047i;
    }

    public float getStartElevation() {
        return this.f25062x;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.f25055q;
    }

    @Nullable
    public View getStartView() {
        return this.f25053o;
    }

    @IdRes
    public int getStartViewId() {
        return this.f25044f;
    }

    public int getTransitionDirection() {
        return this.f25050l;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return A;
    }

    public boolean isDrawDebugEnabled() {
        return this.f25039a;
    }

    public boolean isElevationShadowEnabled() {
        return this.f25061w;
    }

    public boolean isHoldAtEndEnabled() {
        return this.f25040b;
    }

    public void setAllContainerColors(@ColorInt int i4) {
        this.f25046h = i4;
        this.f25047i = i4;
        this.f25048j = i4;
    }

    public void setContainerColor(@ColorInt int i4) {
        this.f25046h = i4;
    }

    public void setDrawDebugEnabled(boolean z3) {
        this.f25039a = z3;
    }

    public void setDrawingViewId(@IdRes int i4) {
        this.f25043e = i4;
    }

    public void setElevationShadowEnabled(boolean z3) {
        this.f25061w = z3;
    }

    public void setEndContainerColor(@ColorInt int i4) {
        this.f25048j = i4;
    }

    public void setEndElevation(float f4) {
        this.f25063y = f4;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f25056r = shapeAppearanceModel;
    }

    public void setEndView(@Nullable View view) {
        this.f25054p = view;
    }

    public void setEndViewId(@IdRes int i4) {
        this.f25045g = i4;
    }

    public void setFadeMode(int i4) {
        this.f25051m = i4;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f25057s = progressThresholds;
    }

    public void setFitMode(int i4) {
        this.f25052n = i4;
    }

    public void setHoldAtEndEnabled(boolean z3) {
        this.f25040b = z3;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f25041c = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f25059u = progressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f25058t = progressThresholds;
    }

    public void setScrimColor(@ColorInt int i4) {
        this.f25049k = i4;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.f25060v = progressThresholds;
    }

    public void setStartContainerColor(@ColorInt int i4) {
        this.f25047i = i4;
    }

    public void setStartElevation(float f4) {
        this.f25062x = f4;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f25055q = shapeAppearanceModel;
    }

    public void setStartView(@Nullable View view) {
        this.f25053o = view;
    }

    public void setStartViewId(@IdRes int i4) {
        this.f25044f = i4;
    }

    public void setTransitionDirection(int i4) {
        this.f25050l = i4;
    }

    public MaterialContainerTransform(@NonNull Context context, boolean z3) {
        this.f25039a = false;
        this.f25040b = false;
        this.f25041c = false;
        this.f25042d = false;
        this.f25043e = 16908290;
        this.f25044f = -1;
        this.f25045g = -1;
        this.f25046h = 0;
        this.f25047i = 0;
        this.f25048j = 0;
        this.f25049k = 1375731712;
        this.f25050l = 0;
        this.f25051m = 0;
        this.f25052n = 0;
        this.f25061w = Build.VERSION.SDK_INT >= 28;
        this.f25062x = -1.0f;
        this.f25063y = -1.0f;
        k(context, z3);
        this.f25042d = true;
    }
}
