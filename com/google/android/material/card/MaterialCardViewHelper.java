package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class MaterialCardViewHelper {

    /* renamed from: t  reason: collision with root package name */
    private static final double f23263t = Math.cos(Math.toRadians(45.0d));
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f23264a;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final MaterialShapeDrawable f23266c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final MaterialShapeDrawable f23267d;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f23268e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f23269f;
    @Dimension

    /* renamed from: g  reason: collision with root package name */
    private int f23270g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Drawable f23271h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Drawable f23272i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f23273j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f23274k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ShapeAppearanceModel f23275l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f23276m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Drawable f23277n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private LayerDrawable f23278o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private MaterialShapeDrawable f23279p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private MaterialShapeDrawable f23280q;

    /* renamed from: s  reason: collision with root package name */
    private boolean f23282s;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f23265b = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private boolean f23281r = false;

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i4, @StyleRes int i5) {
        this.f23264a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i4, i5);
        this.f23266c = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i4, R.style.CardView);
        int i6 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i6, 0.0f));
        }
        this.f23267d = new MaterialShapeDrawable();
        R(builder.build());
        obtainStyledAttributes.recycle();
    }

    @NonNull
    private Drawable A(Drawable drawable) {
        int i4;
        int i5;
        if (this.f23264a.getUseCompatPadding()) {
            i5 = (int) Math.ceil(d());
            i4 = (int) Math.ceil(c());
        } else {
            i4 = 0;
            i5 = 0;
        }
        return new InsetDrawable(drawable, i4, i5, i4, i5) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean V() {
        if (this.f23264a.getPreventCornerOverlap() && !e()) {
            return true;
        }
        return false;
    }

    private boolean W() {
        if (this.f23264a.getPreventCornerOverlap() && e() && this.f23264a.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    private float a() {
        return Math.max(Math.max(b(this.f23275l.getTopLeftCorner(), this.f23266c.getTopLeftCornerResolvedSize()), b(this.f23275l.getTopRightCorner(), this.f23266c.getTopRightCornerResolvedSize())), Math.max(b(this.f23275l.getBottomRightCorner(), this.f23266c.getBottomRightCornerResolvedSize()), b(this.f23275l.getBottomLeftCorner(), this.f23266c.getBottomLeftCornerResolvedSize())));
    }

    private void a0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.f23264a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.f23264a.getForeground()).setDrawable(drawable);
        } else {
            this.f23264a.setForeground(A(drawable));
        }
    }

    private float b(CornerTreatment cornerTreatment, float f4) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f23263t) * f4);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f4 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        float f4;
        float maxCardElevation = this.f23264a.getMaxCardElevation();
        if (W()) {
            f4 = a();
        } else {
            f4 = 0.0f;
        }
        return maxCardElevation + f4;
    }

    private void c0() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.f23277n) != null) {
            ((RippleDrawable) drawable).setColor(this.f23273j);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f23279p;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.f23273j);
        }
    }

    private float d() {
        float f4;
        float maxCardElevation = this.f23264a.getMaxCardElevation() * 1.5f;
        if (W()) {
            f4 = a();
        } else {
            f4 = 0.0f;
        }
        return maxCardElevation + f4;
    }

    private boolean e() {
        if (this.f23266c.isRoundRect()) {
            return true;
        }
        return false;
    }

    @NonNull
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable h4 = h();
        this.f23279p = h4;
        h4.setFillColor(this.f23273j);
        stateListDrawable.addState(new int[]{16842919}, this.f23279p);
        return stateListDrawable;
    }

    @NonNull
    private Drawable g() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.f23280q = h();
            return new RippleDrawable(this.f23273j, null, this.f23280q);
        }
        return f();
    }

    @NonNull
    private MaterialShapeDrawable h() {
        return new MaterialShapeDrawable(this.f23275l);
    }

    @NonNull
    private Drawable q() {
        if (this.f23277n == null) {
            this.f23277n = g();
        }
        if (this.f23278o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f23277n, this.f23267d, this.f23272i});
            this.f23278o = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f23278o;
    }

    private float s() {
        if (this.f23264a.getPreventCornerOverlap() && this.f23264a.getUseCompatPadding()) {
            return (float) ((1.0d - f23263t) * this.f23264a.getCardViewRadius());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f23281r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f23282s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.f23264a.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.f23276m = colorStateList;
        if (colorStateList == null) {
            this.f23276m = ColorStateList.valueOf(-1);
        }
        this.f23270g = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z3 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.f23282s = z3;
        this.f23264a.setLongClickable(z3);
        this.f23274k = MaterialResources.getColorStateList(this.f23264a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        K(MaterialResources.getDrawable(this.f23264a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        M(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        L(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.f23264a.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f23273j = colorStateList2;
        if (colorStateList2 == null) {
            this.f23273j = ColorStateList.valueOf(MaterialColors.getColor(this.f23264a, R.attr.colorControlHighlight));
        }
        H(MaterialResources.getColorStateList(this.f23264a.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        c0();
        Z();
        d0();
        this.f23264a.setBackgroundInternal(A(this.f23266c));
        if (this.f23264a.isClickable()) {
            drawable = q();
        } else {
            drawable = this.f23267d;
        }
        this.f23271h = drawable;
        this.f23264a.setForeground(A(drawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i4, int i5) {
        int i6;
        int i7;
        if (this.f23278o != null) {
            int i8 = this.f23268e;
            int i9 = this.f23269f;
            int i10 = (i4 - i8) - i9;
            int i11 = (i5 - i8) - i9;
            if (this.f23264a.getUseCompatPadding()) {
                i11 -= (int) Math.ceil(d() * 2.0f);
                i10 -= (int) Math.ceil(c() * 2.0f);
            }
            int i12 = i11;
            int i13 = this.f23268e;
            if (ViewCompat.getLayoutDirection(this.f23264a) == 1) {
                i7 = i10;
                i6 = i13;
            } else {
                i6 = i10;
                i7 = i13;
            }
            this.f23278o.setLayerInset(2, i6, this.f23268e, i7, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z3) {
        this.f23281r = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(ColorStateList colorStateList) {
        this.f23266c.setFillColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f23267d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(boolean z3) {
        this.f23282s = z3;
    }

    public void J(boolean z3) {
        int i4;
        Drawable drawable = this.f23272i;
        if (drawable != null) {
            if (z3) {
                i4 = 255;
            } else {
                i4 = 0;
            }
            drawable.setAlpha(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(@Nullable Drawable drawable) {
        this.f23272i = drawable;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f23272i = mutate;
            DrawableCompat.setTintList(mutate, this.f23274k);
            J(this.f23264a.isChecked());
        }
        LayerDrawable layerDrawable = this.f23278o;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f23272i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(@Dimension int i4) {
        this.f23268e = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(@Dimension int i4) {
        this.f23269f = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(@Nullable ColorStateList colorStateList) {
        this.f23274k = colorStateList;
        Drawable drawable = this.f23272i;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(float f4) {
        R(this.f23275l.withCornerSize(f4));
        this.f23271h.invalidateSelf();
        if (W() || V()) {
            Y();
        }
        if (W()) {
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f23266c.setInterpolation(f4);
        MaterialShapeDrawable materialShapeDrawable = this.f23267d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f4);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f23280q;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(@Nullable ColorStateList colorStateList) {
        this.f23273j = colorStateList;
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23275l = shapeAppearanceModel;
        this.f23266c.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.f23266c;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.f23267d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f23280q;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.f23279p;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ColorStateList colorStateList) {
        if (this.f23276m == colorStateList) {
            return;
        }
        this.f23276m = colorStateList;
        d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(@Dimension int i4) {
        if (i4 == this.f23270g) {
            return;
        }
        this.f23270g = i4;
        d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i4, int i5, int i6, int i7) {
        this.f23265b.set(i4, i5, i6, i7);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Drawable drawable;
        Drawable drawable2 = this.f23271h;
        if (this.f23264a.isClickable()) {
            drawable = q();
        } else {
            drawable = this.f23267d;
        }
        this.f23271h = drawable;
        if (drawable2 != drawable) {
            a0(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        boolean z3;
        float f4;
        if (!V() && !W()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            f4 = a();
        } else {
            f4 = 0.0f;
        }
        int s3 = (int) (f4 - s());
        MaterialCardView materialCardView = this.f23264a;
        Rect rect = this.f23265b;
        materialCardView.c(rect.left + s3, rect.top + s3, rect.right + s3, rect.bottom + s3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        this.f23266c.setElevation(this.f23264a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        if (!B()) {
            this.f23264a.setBackgroundInternal(A(this.f23266c));
        }
        this.f23264a.setForeground(A(this.f23271h));
    }

    void d0() {
        this.f23267d.setStroke(this.f23270g, this.f23276m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void i() {
        Drawable drawable = this.f23277n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i4 = bounds.bottom;
            this.f23277n.setBounds(bounds.left, bounds.top, bounds.right, i4 - 1);
            this.f23277n.setBounds(bounds.left, bounds.top, bounds.right, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable j() {
        return this.f23266c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList k() {
        return this.f23266c.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f23267d.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Drawable m() {
        return this.f23272i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension
    public int n() {
        return this.f23268e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension
    public int o() {
        return this.f23269f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList p() {
        return this.f23274k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float r() {
        return this.f23266c.getTopLeftCornerResolvedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float t() {
        return this.f23266c.getInterpolation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList u() {
        return this.f23273j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel v() {
        return this.f23275l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int w() {
        ColorStateList colorStateList = this.f23276m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList x() {
        return this.f23276m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Dimension
    public int y() {
        return this.f23270g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect z() {
        return this.f23265b;
    }
}
