package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: Access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class MaterialButtonHelper {
    @ChecksSdkIntAtLeast(api = 21)

    /* renamed from: t  reason: collision with root package name */
    private static final boolean f23212t;

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f23213u;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f23214a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private ShapeAppearanceModel f23215b;

    /* renamed from: c  reason: collision with root package name */
    private int f23216c;

    /* renamed from: d  reason: collision with root package name */
    private int f23217d;

    /* renamed from: e  reason: collision with root package name */
    private int f23218e;

    /* renamed from: f  reason: collision with root package name */
    private int f23219f;

    /* renamed from: g  reason: collision with root package name */
    private int f23220g;

    /* renamed from: h  reason: collision with root package name */
    private int f23221h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f23222i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f23223j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f23224k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f23225l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Drawable f23226m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23227n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23228o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23229p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f23230q;

    /* renamed from: r  reason: collision with root package name */
    private LayerDrawable f23231r;

    /* renamed from: s  reason: collision with root package name */
    private int f23232s;

    static {
        int i4 = Build.VERSION.SDK_INT;
        boolean z3 = true;
        f23212t = true;
        if (i4 > 22) {
            z3 = false;
        }
        f23213u = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialButtonHelper(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23214a = materialButton;
        this.f23215b = shapeAppearanceModel;
    }

    private void E(@Dimension int i4, @Dimension int i5) {
        int paddingStart = ViewCompat.getPaddingStart(this.f23214a);
        int paddingTop = this.f23214a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f23214a);
        int paddingBottom = this.f23214a.getPaddingBottom();
        int i6 = this.f23218e;
        int i7 = this.f23219f;
        this.f23219f = i5;
        this.f23218e = i4;
        if (!this.f23228o) {
            F();
        }
        ViewCompat.setPaddingRelative(this.f23214a, paddingStart, (paddingTop + i4) - i6, paddingEnd, (paddingBottom + i5) - i7);
    }

    private void F() {
        this.f23214a.setInternalBackground(a());
        MaterialShapeDrawable f4 = f();
        if (f4 != null) {
            f4.setElevation(this.f23232s);
        }
    }

    private void G(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (f23213u && !this.f23228o) {
            int paddingStart = ViewCompat.getPaddingStart(this.f23214a);
            int paddingTop = this.f23214a.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.f23214a);
            int paddingBottom = this.f23214a.getPaddingBottom();
            F();
            ViewCompat.setPaddingRelative(this.f23214a, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void I() {
        int i4;
        MaterialShapeDrawable f4 = f();
        MaterialShapeDrawable n4 = n();
        if (f4 != null) {
            f4.setStroke(this.f23221h, this.f23224k);
            if (n4 != null) {
                float f5 = this.f23221h;
                if (this.f23227n) {
                    i4 = MaterialColors.getColor(this.f23214a, R.attr.colorSurface);
                } else {
                    i4 = 0;
                }
                n4.setStroke(f5, i4);
            }
        }
    }

    @NonNull
    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f23216c, this.f23218e, this.f23217d, this.f23219f);
    }

    private Drawable a() {
        int i4;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f23215b);
        materialShapeDrawable.initializeElevationOverlay(this.f23214a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f23223j);
        PorterDuff.Mode mode = this.f23222i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke(this.f23221h, this.f23224k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f23215b);
        materialShapeDrawable2.setTint(0);
        float f4 = this.f23221h;
        if (this.f23227n) {
            i4 = MaterialColors.getColor(this.f23214a, R.attr.colorSurface);
        } else {
            i4 = 0;
        }
        materialShapeDrawable2.setStroke(f4, i4);
        if (f23212t) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f23215b);
            this.f23226m = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.f23225l), J(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f23226m);
            this.f23231r = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f23215b);
        this.f23226m = rippleDrawableCompat;
        DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.f23225l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f23226m});
        this.f23231r = layerDrawable;
        return J(layerDrawable);
    }

    @Nullable
    private MaterialShapeDrawable g(boolean z3) {
        LayerDrawable layerDrawable = this.f23231r;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f23212t) {
                return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f23231r.getDrawable(0)).getDrawable()).getDrawable(!z3 ? 1 : 0);
            }
            return (MaterialShapeDrawable) this.f23231r.getDrawable(!z3 ? 1 : 0);
        }
        return null;
    }

    @Nullable
    private MaterialShapeDrawable n() {
        return g(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(@Nullable ColorStateList colorStateList) {
        if (this.f23224k != colorStateList) {
            this.f23224k = colorStateList;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i4) {
        if (this.f23221h != i4) {
            this.f23221h = i4;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(@Nullable ColorStateList colorStateList) {
        if (this.f23223j != colorStateList) {
            this.f23223j = colorStateList;
            if (f() != null) {
                DrawableCompat.setTintList(f(), this.f23223j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(@Nullable PorterDuff.Mode mode) {
        if (this.f23222i != mode) {
            this.f23222i = mode;
            if (f() != null && this.f23222i != null) {
                DrawableCompat.setTintMode(f(), this.f23222i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i4, int i5) {
        Drawable drawable = this.f23226m;
        if (drawable != null) {
            drawable.setBounds(this.f23216c, this.f23218e, i5 - this.f23217d, i4 - this.f23219f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f23220g;
    }

    public int c() {
        return this.f23219f;
    }

    public int d() {
        return this.f23218e;
    }

    @Nullable
    public Shapeable e() {
        LayerDrawable layerDrawable = this.f23231r;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f23231r.getNumberOfLayers() > 2) {
                return (Shapeable) this.f23231r.getDrawable(2);
            }
            return (Shapeable) this.f23231r.getDrawable(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public MaterialShapeDrawable f() {
        return g(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList h() {
        return this.f23225l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ShapeAppearanceModel i() {
        return this.f23215b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList j() {
        return this.f23224k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f23221h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f23223j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f23222i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f23228o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f23230q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(@NonNull TypedArray typedArray) {
        this.f23216c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f23217d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f23218e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f23219f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i4 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i4)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i4, -1);
            this.f23220g = dimensionPixelSize;
            y(this.f23215b.withCornerSize(dimensionPixelSize));
            this.f23229p = true;
        }
        this.f23221h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f23222i = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f23223j = MaterialResources.getColorStateList(this.f23214a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f23224k = MaterialResources.getColorStateList(this.f23214a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f23225l = MaterialResources.getColorStateList(this.f23214a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f23230q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f23232s = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.f23214a);
        int paddingTop = this.f23214a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f23214a);
        int paddingBottom = this.f23214a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        ViewCompat.setPaddingRelative(this.f23214a, paddingStart + this.f23216c, paddingTop + this.f23218e, paddingEnd + this.f23217d, paddingBottom + this.f23219f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i4) {
        if (f() != null) {
            f().setTint(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f23228o = true;
        this.f23214a.setSupportBackgroundTintList(this.f23223j);
        this.f23214a.setSupportBackgroundTintMode(this.f23222i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z3) {
        this.f23230q = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i4) {
        if (!this.f23229p || this.f23220g != i4) {
            this.f23220g = i4;
            this.f23229p = true;
            y(this.f23215b.withCornerSize(i4));
        }
    }

    public void v(@Dimension int i4) {
        E(this.f23218e, i4);
    }

    public void w(@Dimension int i4) {
        E(i4, this.f23219f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(@Nullable ColorStateList colorStateList) {
        if (this.f23225l != colorStateList) {
            this.f23225l = colorStateList;
            boolean z3 = f23212t;
            if (z3 && (this.f23214a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f23214a.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else if (!z3 && (this.f23214a.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.f23214a.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23215b = shapeAppearanceModel;
        G(shapeAppearanceModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z3) {
        this.f23227n = z3;
        I();
    }
}
