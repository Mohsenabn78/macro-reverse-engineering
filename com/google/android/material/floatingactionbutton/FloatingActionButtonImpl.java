package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class FloatingActionButtonImpl {
    static final TimeInterpolator D = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] E = {16842919, 16842910};
    static final int[] F = {16843623, 16842908, 16842910};
    static final int[] G = {16842908, 16842910};
    static final int[] H = {16843623, 16842910};
    static final int[] I = {16842910};
    static final int[] J = new int[0];
    @Nullable
    private ViewTreeObserver.OnPreDrawListener C;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    ShapeAppearanceModel f23689a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    MaterialShapeDrawable f23690b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    Drawable f23691c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    BorderDrawable f23692d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    Drawable f23693e;

    /* renamed from: f  reason: collision with root package name */
    boolean f23694f;

    /* renamed from: h  reason: collision with root package name */
    float f23696h;

    /* renamed from: i  reason: collision with root package name */
    float f23697i;

    /* renamed from: j  reason: collision with root package name */
    float f23698j;

    /* renamed from: k  reason: collision with root package name */
    int f23699k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final StateListAnimator f23700l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Animator f23701m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private MotionSpec f23702n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private MotionSpec f23703o;

    /* renamed from: p  reason: collision with root package name */
    private float f23704p;

    /* renamed from: r  reason: collision with root package name */
    private int f23706r;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f23708t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f23709u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<InternalTransformationCallback> f23710v;

    /* renamed from: w  reason: collision with root package name */
    final FloatingActionButton f23711w;

    /* renamed from: x  reason: collision with root package name */
    final ShadowViewDelegate f23712x;

    /* renamed from: g  reason: collision with root package name */
    boolean f23695g = true;

    /* renamed from: q  reason: collision with root package name */
    private float f23705q = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private int f23707s = 0;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f23713y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f23714z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    /* loaded from: classes5.dex */
    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes5.dex */
    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f23696h + floatingActionButtonImpl.f23697i;
        }
    }

    /* loaded from: classes5.dex */
    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f23696h + floatingActionButtonImpl.f23698j;
        }
    }

    /* loaded from: classes5.dex */
    interface InternalTransformationCallback {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    interface InternalVisibilityChangedListener {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return FloatingActionButtonImpl.this.f23696h;
        }
    }

    /* loaded from: classes5.dex */
    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23739a;

        /* renamed from: b  reason: collision with root package name */
        private float f23740b;

        /* renamed from: c  reason: collision with root package name */
        private float f23741c;

        private ShadowAnimatorImpl() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.j0((int) this.f23741c);
            this.f23739a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float elevation;
            if (!this.f23739a) {
                MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.f23690b;
                if (materialShapeDrawable == null) {
                    elevation = 0.0f;
                } else {
                    elevation = materialShapeDrawable.getElevation();
                }
                this.f23740b = elevation;
                this.f23741c = a();
                this.f23739a = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f4 = this.f23740b;
            floatingActionButtonImpl.j0((int) (f4 + ((this.f23741c - f4) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.f23711w = floatingActionButton;
        this.f23712x = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f23700l = stateListAnimator;
        stateListAnimator.addState(E, k(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.addState(F, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(G, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(H, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(I, k(new ResetElevationAnimation()));
        stateListAnimator.addState(J, k(new DisabledElevationAnimation()));
        this.f23704p = floatingActionButton.getRotation();
    }

    private boolean d0() {
        if (ViewCompat.isLaidOut(this.f23711w) && !this.f23711w.isInEditMode()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f4, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f23711w.getDrawable();
        if (drawable != null && this.f23706r != 0) {
            RectF rectF = this.f23714z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i4 = this.f23706r;
            rectF2.set(0.0f, 0.0f, i4, i4);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i5 = this.f23706r;
            matrix.postScale(f4, f4, i5 / 2.0f, i5 / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet i(@NonNull MotionSpec motionSpec, float f4, float f5, float f6) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f23711w, View.ALPHA, f4);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f23711w, View.SCALE_X, f5);
        motionSpec.getTiming("scale").apply(ofFloat2);
        k0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f23711w, View.SCALE_Y, f5);
        motionSpec.getTiming("scale").apply(ofFloat3);
        k0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f6, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f23711w, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            public Matrix evaluate(float f7, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                FloatingActionButtonImpl.this.f23705q = f7;
                return super.evaluate(f7, matrix, matrix2);
            }
        }, new Matrix(this.B));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(final float f4, final float f5, final float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.f23711w.getAlpha();
        final float scaleX = this.f23711w.getScaleX();
        final float scaleY = this.f23711w.getScaleY();
        final float f7 = this.f23705q;
        final Matrix matrix = new Matrix(this.B);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl.this.f23711w.setAlpha(AnimationUtils.lerp(alpha, f4, 0.0f, 0.2f, floatValue));
                FloatingActionButtonImpl.this.f23711w.setScaleX(AnimationUtils.lerp(scaleX, f5, floatValue));
                FloatingActionButtonImpl.this.f23711w.setScaleY(AnimationUtils.lerp(scaleY, f5, floatValue));
                FloatingActionButtonImpl.this.f23705q = AnimationUtils.lerp(f7, f6, floatValue);
                FloatingActionButtonImpl.this.h(AnimationUtils.lerp(f7, f6, floatValue), matrix);
                FloatingActionButtonImpl.this.f23711w.setImageMatrix(matrix);
            }
        });
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.resolveThemeDuration(this.f23711w.getContext(), R.attr.motionDurationLong1, this.f23711w.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.f23711w.getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5

            /* renamed from: a  reason: collision with root package name */
            FloatEvaluator f23732a = new FloatEvaluator();

            @Override // android.animation.TypeEvaluator
            /* renamed from: a */
            public Float evaluate(float f4, Float f5, Float f6) {
                float floatValue = this.f23732a.evaluate(f4, (Number) f5, (Number) f6).floatValue();
                if (floatValue < 0.1f) {
                    floatValue = 0.0f;
                }
                return Float.valueOf(floatValue);
            }
        });
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.C == null) {
            this.C = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.H();
                    return true;
                }
            };
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.f23700l.jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.f23711w, materialShapeDrawable);
        }
        if (N()) {
            this.f23711w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        ViewTreeObserver viewTreeObserver = this.f23711w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int[] iArr) {
        this.f23700l.setState(iArr);
    }

    void F(float f4, float f5, float f6) {
        i0();
        j0(f4);
    }

    void G(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f23693e, "Didn't initialize content background");
        if (c0()) {
            this.f23712x.setBackgroundDrawable(new InsetDrawable(this.f23693e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f23712x.setBackgroundDrawable(this.f23693e);
    }

    void H() {
        float rotation = this.f23711w.getRotation();
        if (this.f23704p != rotation) {
            this.f23704p = rotation;
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        ArrayList<InternalTransformationCallback> arrayList = this.f23710v;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        ArrayList<InternalTransformationCallback> arrayList = this.f23710v;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void K(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f23709u;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f23708t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(@NonNull InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList = this.f23710v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    boolean N() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable = this.f23692d;
        if (borderDrawable != null) {
            borderDrawable.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f4) {
        if (this.f23696h != f4) {
            this.f23696h = f4;
            F(f4, this.f23697i, this.f23698j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(boolean z3) {
        this.f23694f = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(@Nullable MotionSpec motionSpec) {
        this.f23703o = motionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(float f4) {
        if (this.f23697i != f4) {
            this.f23697i = f4;
            F(this.f23696h, f4, this.f23698j);
        }
    }

    final void U(float f4) {
        this.f23705q = f4;
        Matrix matrix = this.B;
        h(f4, matrix);
        this.f23711w.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void V(int i4) {
        if (this.f23706r != i4) {
            this.f23706r = i4;
            h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i4) {
        this.f23699k = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(float f4) {
        if (this.f23698j != f4) {
            this.f23698j = f4;
            F(this.f23696h, this.f23697i, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f23691c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(boolean z3) {
        this.f23695g = z3;
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23689a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.f23691c;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.f23692d;
        if (borderDrawable != null) {
            borderDrawable.f(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0(@Nullable MotionSpec motionSpec) {
        this.f23702n = motionSpec;
    }

    boolean c0() {
        return true;
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f23709u == null) {
            this.f23709u = new ArrayList<>();
        }
        this.f23709u.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e0() {
        if (this.f23694f && this.f23711w.getSizeDimension() < this.f23699k) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f23708t == null) {
            this.f23708t = new ArrayList<>();
        }
        this.f23708t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z3) {
        boolean z4;
        AnimatorSet j4;
        float f4;
        float f5;
        if (z()) {
            return;
        }
        Animator animator = this.f23701m;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f23702n == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (d0()) {
            if (this.f23711w.getVisibility() != 0) {
                float f6 = 0.0f;
                this.f23711w.setAlpha(0.0f);
                FloatingActionButton floatingActionButton = this.f23711w;
                if (z4) {
                    f4 = 0.4f;
                } else {
                    f4 = 0.0f;
                }
                floatingActionButton.setScaleY(f4);
                FloatingActionButton floatingActionButton2 = this.f23711w;
                if (z4) {
                    f5 = 0.4f;
                } else {
                    f5 = 0.0f;
                }
                floatingActionButton2.setScaleX(f5);
                if (z4) {
                    f6 = 0.4f;
                }
                U(f6);
            }
            MotionSpec motionSpec = this.f23702n;
            if (motionSpec != null) {
                j4 = i(motionSpec, 1.0f, 1.0f, 1.0f);
            } else {
                j4 = j(1.0f, 1.0f, 1.0f);
            }
            j4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    FloatingActionButtonImpl.this.f23707s = 0;
                    FloatingActionButtonImpl.this.f23701m = null;
                    InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                    if (internalVisibilityChangedListener2 != null) {
                        internalVisibilityChangedListener2.a();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.f23711w.internalSetVisibility(0, z3);
                    FloatingActionButtonImpl.this.f23707s = 2;
                    FloatingActionButtonImpl.this.f23701m = animator2;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.f23708t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j4.addListener(it.next());
                }
            }
            j4.start();
            return;
        }
        this.f23711w.internalSetVisibility(0, z3);
        this.f23711w.setAlpha(1.0f);
        this.f23711w.setScaleY(1.0f);
        this.f23711w.setScaleX(1.0f);
        U(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull InternalTransformationCallback internalTransformationCallback) {
        if (this.f23710v == null) {
            this.f23710v = new ArrayList<>();
        }
        this.f23710v.add(internalTransformationCallback);
    }

    void g0() {
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShadowCompatRotation((int) this.f23704p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h0() {
        U(this.f23705q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i0() {
        Rect rect = this.f23713y;
        s(rect);
        G(rect);
        this.f23712x.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(float f4) {
        MaterialShapeDrawable materialShapeDrawable = this.f23690b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f4);
        }
    }

    MaterialShapeDrawable l() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.f23689a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Drawable m() {
        return this.f23693e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.f23696h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f23694f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec p() {
        return this.f23703o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float q() {
        return this.f23697i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@NonNull Rect rect) {
        int i4;
        float f4;
        if (this.f23694f) {
            i4 = (this.f23699k - this.f23711w.getSizeDimension()) / 2;
        } else {
            i4 = 0;
        }
        if (this.f23695g) {
            f4 = n() + this.f23698j;
        } else {
            f4 = 0.0f;
        }
        int max = Math.max(i4, (int) Math.ceil(f4));
        int max2 = Math.max(i4, (int) Math.ceil(f4 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.f23698j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final ShapeAppearanceModel u() {
        return this.f23689a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec v() {
        return this.f23702n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z3) {
        int i4;
        AnimatorSet j4;
        if (y()) {
            return;
        }
        Animator animator = this.f23701m;
        if (animator != null) {
            animator.cancel();
        }
        if (d0()) {
            MotionSpec motionSpec = this.f23703o;
            if (motionSpec != null) {
                j4 = i(motionSpec, 0.0f, 0.0f, 0.0f);
            } else {
                j4 = j(0.0f, 0.4f, 0.4f);
            }
            j4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1

                /* renamed from: a  reason: collision with root package name */
                private boolean f23715a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    this.f23715a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    int i5;
                    FloatingActionButtonImpl.this.f23707s = 0;
                    FloatingActionButtonImpl.this.f23701m = null;
                    if (!this.f23715a) {
                        FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.f23711w;
                        boolean z4 = z3;
                        if (z4) {
                            i5 = 8;
                        } else {
                            i5 = 4;
                        }
                        floatingActionButton.internalSetVisibility(i5, z4);
                        InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                        if (internalVisibilityChangedListener2 != null) {
                            internalVisibilityChangedListener2.b();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.f23711w.internalSetVisibility(0, z3);
                    FloatingActionButtonImpl.this.f23707s = 1;
                    FloatingActionButtonImpl.this.f23701m = animator2;
                    this.f23715a = false;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.f23709u;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j4.addListener(it.next());
                }
            }
            j4.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f23711w;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 4;
        }
        floatingActionButton.internalSetVisibility(i4, z3);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i4) {
        MaterialShapeDrawable l4 = l();
        this.f23690b = l4;
        l4.setTintList(colorStateList);
        if (mode != null) {
            this.f23690b.setTintMode(mode);
        }
        this.f23690b.setShadowColor(-12303292);
        this.f23690b.initializeElevationOverlay(this.f23711w.getContext());
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f23690b.getShapeAppearanceModel());
        rippleDrawableCompat.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
        this.f23691c = rippleDrawableCompat;
        this.f23693e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f23690b), rippleDrawableCompat});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        if (this.f23711w.getVisibility() == 0) {
            if (this.f23707s != 1) {
                return false;
            }
            return true;
        } else if (this.f23707s == 2) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        if (this.f23711w.getVisibility() != 0) {
            if (this.f23707s != 2) {
                return false;
            }
            return true;
        } else if (this.f23707s == 1) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
    }
}
