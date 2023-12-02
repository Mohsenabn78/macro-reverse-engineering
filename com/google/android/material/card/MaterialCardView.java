package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes5.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f23254f = {16842911};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f23255g = {16842912};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f23256h = {R.attr.state_dragged};

    /* renamed from: i  reason: collision with root package name */
    private static final int f23257i = R.style.Widget_MaterialComponents_CardView;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardViewHelper f23258a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23259b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23260c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23261d;

    /* renamed from: e  reason: collision with root package name */
    private OnCheckedChangeListener f23262e;

    /* loaded from: classes5.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z3);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void b() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f23258a.i();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f23258a.j().getBounds());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4, int i5, int i6, int i7) {
        super.setContentPadding(i4, i5, i6, i7);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f23258a.k();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f23258a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f23258a.m();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f23258a.n();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f23258a.o();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f23258a.p();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f23258a.z().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f23258a.z().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f23258a.z().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f23258a.z().top;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getProgress() {
        return this.f23258a.t();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f23258a.r();
    }

    public ColorStateList getRippleColor() {
        return this.f23258a.u();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f23258a.v();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.f23258a.w();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f23258a.x();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f23258a.y();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper materialCardViewHelper = this.f23258a;
        if (materialCardViewHelper != null && materialCardViewHelper.C()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f23260c;
    }

    public boolean isDragged() {
        return this.f23261d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.f23258a.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f23254f);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f23255g);
        }
        if (isDragged()) {
            View.mergeDrawableStates(onCreateDrawableState, f23256h);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        this.f23258a.E(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f23259b) {
            if (!this.f23258a.B()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f23258a.F(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i4) {
        this.f23258a.G(ColorStateList.valueOf(i4));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f4) {
        super.setCardElevation(f4);
        this.f23258a.Z();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f23258a.H(colorStateList);
    }

    public void setCheckable(boolean z3) {
        this.f23258a.I(z3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (this.f23260c != z3) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f23258a.K(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i4) {
        this.f23258a.L(i4);
    }

    public void setCheckedIconMarginResource(@DimenRes int i4) {
        if (i4 != -1) {
            this.f23258a.L(getResources().getDimensionPixelSize(i4));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        this.f23258a.K(AppCompatResources.getDrawable(getContext(), i4));
    }

    public void setCheckedIconSize(@Dimension int i4) {
        this.f23258a.M(i4);
    }

    public void setCheckedIconSizeResource(@DimenRes int i4) {
        if (i4 != 0) {
            this.f23258a.M(getResources().getDimensionPixelSize(i4));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f23258a.N(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z3) {
        super.setClickable(z3);
        MaterialCardViewHelper materialCardViewHelper = this.f23258a;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.X();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i4, int i5, int i6, int i7) {
        this.f23258a.U(i4, i5, i6, i7);
    }

    public void setDragged(boolean z3) {
        if (this.f23261d != z3) {
            this.f23261d = z3;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f4) {
        super.setMaxCardElevation(f4);
        this.f23258a.b0();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.f23262e = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z3) {
        super.setPreventCornerOverlap(z3);
        this.f23258a.b0();
        this.f23258a.Y();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f23258a.P(f4);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f4) {
        super.setRadius(f4);
        this.f23258a.O(f4);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f23258a.Q(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i4) {
        this.f23258a.Q(AppCompatResources.getColorStateList(getContext(), i4));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.f23258a.R(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i4) {
        setStrokeColor(ColorStateList.valueOf(i4));
    }

    public void setStrokeWidth(@Dimension int i4) {
        this.f23258a.T(i4);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z3) {
        super.setUseCompatPadding(z3);
        this.f23258a.b0();
        this.f23258a.Y();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.f23260c = !this.f23260c;
            refreshDrawableState();
            b();
            this.f23258a.J(this.f23260c);
            OnCheckedChangeListener onCheckedChangeListener = this.f23262e;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.f23260c);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f23258a.G(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f23258a.S(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f23257i
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f23260c = r8
            r7.f23261d = r8
            r0 = 1
            r7.f23259b = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.MaterialCardViewHelper r0 = new com.google.android.material.card.MaterialCardViewHelper
            r0.<init>(r7, r9, r10, r6)
            r7.f23258a = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.G(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.U(r9, r10, r1, r2)
            r0.D(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
