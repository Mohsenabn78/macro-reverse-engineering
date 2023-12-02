package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes5.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @NonNull
    private Animator m0(float f4, float f5) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f23711w, "elevation", f4).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f23711w, View.TRANSLATION_Z, f5).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void C() {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f23711w.isEnabled()) {
                this.f23711w.setElevation(this.f23696h);
                if (this.f23711w.isPressed()) {
                    this.f23711w.setTranslationZ(this.f23698j);
                    return;
                } else if (!this.f23711w.isFocused() && !this.f23711w.isHovered()) {
                    this.f23711w.setTranslationZ(0.0f);
                    return;
                } else {
                    this.f23711w.setTranslationZ(this.f23697i);
                    return;
                }
            }
            this.f23711w.setElevation(0.0f);
            this.f23711w.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void F(float f4, float f5, float f6) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 == 21) {
            this.f23711w.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.E, m0(f4, f6));
            stateListAnimator.addState(FloatingActionButtonImpl.F, m0(f4, f5));
            stateListAnimator.addState(FloatingActionButtonImpl.G, m0(f4, f5));
            stateListAnimator.addState(FloatingActionButtonImpl.H, m0(f4, f5));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f23711w, "elevation", f4).setDuration(0L));
            if (i4 >= 22 && i4 <= 24) {
                FloatingActionButton floatingActionButton = this.f23711w;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f23711w, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.D);
            stateListAnimator.addState(FloatingActionButtonImpl.I, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.J, m0(0.0f, 0.0f));
            this.f23711w.setStateListAnimator(stateListAnimator);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean N() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f23691c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean c0() {
        if (!this.f23712x.isCompatPaddingEnabled() && e0()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @NonNull
    MaterialShapeDrawable l() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.f23689a));
    }

    @NonNull
    BorderDrawable l0(int i4, ColorStateList colorStateList) {
        Context context = this.f23711w.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.f23689a));
        borderDrawable.e(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        borderDrawable.d(i4);
        borderDrawable.c(colorStateList);
        return borderDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float n() {
        return this.f23711w.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void s(@NonNull Rect rect) {
        if (this.f23712x.isCompatPaddingEnabled()) {
            super.s(rect);
        } else if (!e0()) {
            int sizeDimension = (this.f23699k - this.f23711w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i4) {
        Drawable drawable;
        MaterialShapeDrawable l4 = l();
        this.f23690b = l4;
        l4.setTintList(colorStateList);
        if (mode != null) {
            this.f23690b.setTintMode(mode);
        }
        this.f23690b.initializeElevationOverlay(this.f23711w.getContext());
        if (i4 > 0) {
            this.f23692d = l0(i4, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f23692d), (Drawable) Preconditions.checkNotNull(this.f23690b)});
        } else {
            this.f23692d = null;
            drawable = this.f23690b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.f23691c = rippleDrawable;
        this.f23693e = rippleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void g0() {
    }
}
