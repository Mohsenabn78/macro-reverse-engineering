package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;
import net.cachapa.expandablelayout.ExpandableLayout;

@Deprecated
/* loaded from: classes5.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f24841c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f24842d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f24843e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f24844f;

    /* renamed from: g  reason: collision with root package name */
    private float f24845g;

    /* renamed from: h  reason: collision with root package name */
    private float f24846h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class FabTransformationSpec {
        public Positioning positioning;
        @Nullable
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
        this.f24841c = new Rect();
        this.f24842d = new RectF();
        this.f24843e = new RectF();
        this.f24844f = new int[2];
    }

    @Nullable
    private ViewGroup B(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup g(@NonNull View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return B(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return B(view);
        }
        return B(((ViewGroup) view).getChildAt(0));
    }

    private void h(@NonNull View view, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, @NonNull MotionTiming motionTiming2, float f4, float f5, float f6, float f7, @NonNull RectF rectF) {
        float o4 = o(fabTransformationSpec, motionTiming, f4, f6);
        float o5 = o(fabTransformationSpec, motionTiming2, f5, f7);
        Rect rect = this.f24841c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f24842d;
        rectF2.set(rect);
        RectF rectF3 = this.f24843e;
        p(view, rectF3);
        rectF3.offset(o4, o5);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void i(@NonNull View view, @NonNull RectF rectF) {
        p(view, rectF);
        rectF.offset(this.f24845g, this.f24846h);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> j(float f4, float f5, boolean z3, @NonNull FabTransformationSpec fabTransformationSpec) {
        MotionTiming timing;
        MotionTiming timing2;
        int i4;
        if (f4 != 0.0f && f5 != 0.0f) {
            if ((z3 && f5 < 0.0f) || (!z3 && i4 > 0)) {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
            } else {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
            }
        } else {
            timing = fabTransformationSpec.timings.getTiming("translationXLinear");
            timing2 = fabTransformationSpec.timings.getTiming("translationYLinear");
        }
        return new Pair<>(timing, timing2);
    }

    private float k(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.f24842d;
        RectF rectF2 = this.f24843e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(-m(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float l(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.f24842d;
        RectF rectF2 = this.f24843e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(0.0f, -n(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float m(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float centerX;
        float centerX2;
        float f4;
        RectF rectF = this.f24842d;
        RectF rectF2 = this.f24843e;
        i(view, rectF);
        p(view2, rectF2);
        int i4 = positioning.gravity & 7;
        if (i4 != 1) {
            if (i4 != 3) {
                if (i4 != 5) {
                    f4 = 0.0f;
                    return f4 + positioning.xAdjustment;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f4 = centerX - centerX2;
        return f4 + positioning.xAdjustment;
    }

    private float n(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float centerY;
        float centerY2;
        float f4;
        RectF rectF = this.f24842d;
        RectF rectF2 = this.f24843e;
        i(view, rectF);
        p(view2, rectF2);
        int i4 = positioning.gravity & 112;
        if (i4 != 16) {
            if (i4 != 48) {
                if (i4 != 80) {
                    f4 = 0.0f;
                    return f4 + positioning.yAdjustment;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f4 = centerY - centerY2;
        return f4 + positioning.yAdjustment;
    }

    private float o(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f4, float f5) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        MotionTiming timing = fabTransformationSpec.timings.getTiming(ExpandableLayout.KEY_EXPANSION);
        return AnimationUtils.lerp(f4, f5, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDelay() + timing.getDuration()) + 17) - delay)) / ((float) duration)));
    }

    private void p(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f24844f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void q(View view, View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup g4;
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (((view2 instanceof CircularRevealWidget) && CircularRevealHelper.STRATEGY == 0) || (g4 = g(view2)) == null) {
            return;
        }
        if (z3) {
            if (!z4) {
                ChildrenAlphaProperty.CHILDREN_ALPHA.set(g4, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(g4, ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(g4, ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
        }
        fabTransformationSpec.timings.getTiming("contentFade").apply(ofFloat);
        list.add(ofFloat);
    }

    private void r(@NonNull View view, View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
        int z5 = z(view);
        int i4 = 16777215 & z5;
        if (z3) {
            if (!z4) {
                circularRevealWidget.setCircularRevealScrimColor(z5);
            }
            ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i4);
        } else {
            ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, z5);
        }
        ofInt.setEvaluator(ArgbEvaluatorCompat.getInstance());
        fabTransformationSpec.timings.getTiming(TypedValues.Custom.S_COLOR).apply(ofInt);
        list.add(ofInt);
    }

    private void s(@NonNull View view, @NonNull View view2, boolean z3, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list) {
        float m4 = m(view, view2, fabTransformationSpec.positioning);
        float n4 = n(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> j4 = j(m4, n4, z3, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) j4.first;
        MotionTiming motionTiming2 = (MotionTiming) j4.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z3) {
            m4 = this.f24845g;
        }
        fArr[0] = m4;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z3) {
            n4 = this.f24846h;
        }
        fArr2[0] = n4;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void t(View view, @NonNull View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z3) {
            if (!z4) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(ofFloat);
        list.add(ofFloat);
    }

    private void u(@NonNull View view, View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, float f4, float f5, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
        float k4 = k(view, view2, fabTransformationSpec.positioning);
        float l4 = l(view, view2, fabTransformationSpec.positioning);
        ((FloatingActionButton) view).getContentRect(this.f24841c);
        float width = this.f24841c.width() / 2.0f;
        MotionTiming timing = fabTransformationSpec.timings.getTiming(ExpandableLayout.KEY_EXPANSION);
        if (z3) {
            if (!z4) {
                circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(k4, l4, width));
            }
            if (z4) {
                width = circularRevealWidget.getRevealInfo().radius;
            }
            animator = CircularRevealCompat.createCircularReveal(circularRevealWidget, k4, l4, MathUtils.distanceToFurthestCorner(k4, l4, 0.0f, 0.0f, f4, f5));
            animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                    revealInfo.radius = Float.MAX_VALUE;
                    circularRevealWidget.setRevealInfo(revealInfo);
                }
            });
            x(view2, timing.getDelay(), (int) k4, (int) l4, width, list);
        } else {
            float f6 = circularRevealWidget.getRevealInfo().radius;
            Animator createCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget, k4, l4, width);
            int i4 = (int) k4;
            int i5 = (int) l4;
            x(view2, timing.getDelay(), i4, i5, f6, list);
            w(view2, timing.getDelay(), timing.getDuration(), fabTransformationSpec.timings.getTotalDuration(), i4, i5, width, list);
            animator = createCircularReveal;
        }
        timing.apply(animator);
        list.add(animator);
        list2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
    }

    private void v(View view, final View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z3) {
                if (!z4) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
            }
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            fabTransformationSpec.timings.getTiming("iconFade").apply(ofInt);
            list.add(ofInt);
            list2.add(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                }
            });
        }
    }

    private void w(View view, long j4, long j5, long j6, int i4, int i5, float f4, @NonNull List<Animator> list) {
        long j7 = j4 + j5;
        if (j7 < j6) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i4, i5, f4, f4);
            createCircularReveal.setStartDelay(j7);
            createCircularReveal.setDuration(j6 - j7);
            list.add(createCircularReveal);
        }
    }

    private void x(View view, long j4, int i4, int i5, float f4, @NonNull List<Animator> list) {
        if (j4 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i4, i5, f4, f4);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j4);
            list.add(createCircularReveal);
        }
    }

    private void y(@NonNull View view, @NonNull View view2, boolean z3, boolean z4, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float m4 = m(view, view2, fabTransformationSpec.positioning);
        float n4 = n(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> j4 = j(m4, n4, z3, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) j4.first;
        MotionTiming motionTiming2 = (MotionTiming) j4.second;
        if (z3) {
            if (!z4) {
                view2.setTranslationX(-m4);
                view2.setTranslationY(-n4);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            h(view2, fabTransformationSpec, motionTiming, motionTiming2, -m4, -n4, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -m4);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -n4);
        }
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int z(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    protected abstract FabTransformationSpec A(Context context, boolean z3);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet f(@NonNull final View view, @NonNull final View view2, final boolean z3, boolean z4) {
        FabTransformationSpec A = A(view2.getContext(), z3);
        if (z3) {
            this.f24845g = view.getTranslationX();
            this.f24846h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        t(view, view2, z3, z4, A, arrayList, arrayList2);
        RectF rectF = this.f24842d;
        y(view, view2, z3, z4, A, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        s(view, view2, z3, A, arrayList);
        v(view, view2, z3, z4, A, arrayList, arrayList2);
        u(view, view2, z3, z4, A, width, height, arrayList, arrayList2);
        r(view, view2, z3, z4, A, arrayList, arrayList2);
        q(view, view2, z3, z4, A, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z3) {
                    view2.setVisibility(4);
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z3) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            animatorSet.addListener(arrayList2.get(i4));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24841c = new Rect();
        this.f24842d = new RectF();
        this.f24843e = new RectF();
        this.f24844f = new int[2];
    }
}
