package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* loaded from: classes5.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;

    /* renamed from: x  reason: collision with root package name */
    private static final String f24192x = "MaterialShapeDrawable";

    /* renamed from: y  reason: collision with root package name */
    private static final Paint f24193y;

    /* renamed from: a  reason: collision with root package name */
    private MaterialShapeDrawableState f24194a;

    /* renamed from: b  reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f24195b;

    /* renamed from: c  reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f24196c;

    /* renamed from: d  reason: collision with root package name */
    private final BitSet f24197d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24198e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f24199f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f24200g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f24201h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f24202i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f24203j;

    /* renamed from: k  reason: collision with root package name */
    private final Region f24204k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f24205l;

    /* renamed from: m  reason: collision with root package name */
    private ShapeAppearanceModel f24206m;

    /* renamed from: n  reason: collision with root package name */
    private final Paint f24207n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f24208o;

    /* renamed from: p  reason: collision with root package name */
    private final ShadowRenderer f24209p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private final ShapeAppearancePathProvider.PathListener f24210q;

    /* renamed from: r  reason: collision with root package name */
    private final ShapeAppearancePathProvider f24211r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private PorterDuffColorFilter f24212s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private PorterDuffColorFilter f24213t;

    /* renamed from: u  reason: collision with root package name */
    private int f24214u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    private final RectF f24215v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f24216w;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface CompatibilityShadowMode {
    }

    static {
        Paint paint = new Paint(1);
        f24193y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean A(int[] iArr) {
        boolean z3;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f24194a.f24223d != null && color2 != (colorForState2 = this.f24194a.f24223d.getColorForState(iArr, (color2 = this.f24207n.getColor())))) {
            this.f24207n.setColor(colorForState2);
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f24194a.f24224e != null && color != (colorForState = this.f24194a.f24224e.getColorForState(iArr, (color = this.f24208o.getColor())))) {
            this.f24208o.setColor(colorForState);
            return true;
        }
        return z3;
    }

    private boolean B() {
        PorterDuffColorFilter porterDuffColorFilter = this.f24212s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f24213t;
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        this.f24212s = j(materialShapeDrawableState.f24226g, materialShapeDrawableState.f24227h, this.f24207n, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.f24194a;
        this.f24213t = j(materialShapeDrawableState2.f24225f, materialShapeDrawableState2.f24227h, this.f24208o, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.f24194a;
        if (materialShapeDrawableState3.f24240u) {
            this.f24209p.setShadowColor(materialShapeDrawableState3.f24226g.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(porterDuffColorFilter, this.f24212s) || !ObjectsCompat.equals(porterDuffColorFilter2, this.f24213t)) {
            return true;
        }
        return false;
    }

    private void C() {
        float z3 = getZ();
        this.f24194a.f24237r = (int) Math.ceil(0.75f * z3);
        this.f24194a.f24238s = (int) Math.ceil(z3 * 0.25f);
        B();
        w();
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    @Nullable
    private PorterDuffColorFilter e(@NonNull Paint paint, boolean z3) {
        if (z3) {
            int color = paint.getColor();
            int k4 = k(color);
            this.f24214u = k4;
            if (k4 != color) {
                return new PorterDuffColorFilter(k4, PorterDuff.Mode.SRC_IN);
            }
            return null;
        }
        return null;
    }

    private void f(@NonNull RectF rectF, @NonNull Path path) {
        g(rectF, path);
        if (this.f24194a.f24229j != 1.0f) {
            this.f24199f.reset();
            Matrix matrix = this.f24199f;
            float f4 = this.f24194a.f24229j;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f24199f);
        }
        path.computeBounds(this.f24215v, true);
    }

    private void h() {
        final float f4 = -s();
        ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize) {
                if (!(cornerSize instanceof RelativeCornerSize)) {
                    return new AdjustedCornerSize(f4, cornerSize);
                }
                return cornerSize;
            }
        });
        this.f24206m = withTransformedCornerSizes;
        this.f24211r.calculatePath(withTransformedCornerSizes, this.f24194a.f24230k, r(), this.f24201h);
    }

    @NonNull
    private PorterDuffColorFilter i(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z3) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z3) {
            colorForState = k(colorForState);
        }
        this.f24214u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter j(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z3) {
        if (colorStateList != null && mode != null) {
            return i(colorStateList, mode, z3);
        }
        return e(paint, z3);
    }

    private void l(@NonNull Canvas canvas) {
        if (this.f24197d.cardinality() > 0) {
            Log.w(f24192x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f24194a.f24238s != 0) {
            canvas.drawPath(this.f24200g, this.f24209p.getShadowPaint());
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.f24195b[i4].b(this.f24209p, this.f24194a.f24237r, canvas);
            this.f24196c[i4].b(this.f24209p, this.f24194a.f24237r, canvas);
        }
        if (this.f24216w) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.f24200g, f24193y);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void m(@NonNull Canvas canvas) {
        o(canvas, this.f24207n, this.f24200g, this.f24194a.f24220a, q());
    }

    private void o(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (shapeAppearanceModel.isRoundRect(rectF)) {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.f24194a.f24230k;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    @NonNull
    private RectF r() {
        this.f24203j.set(q());
        float s3 = s();
        this.f24203j.inset(s3, s3);
        return this.f24203j;
    }

    private float s() {
        if (v()) {
            return this.f24208o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean t() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        int i4 = materialShapeDrawableState.f24236q;
        if (i4 != 1 && materialShapeDrawableState.f24237r > 0 && (i4 == 2 || requiresCompatShadow())) {
            return true;
        }
        return false;
    }

    private boolean u() {
        Paint.Style style = this.f24194a.f24241v;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    private boolean v() {
        Paint.Style style = this.f24194a.f24241v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f24208o.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void w() {
        super.invalidateSelf();
    }

    private void x(@NonNull Canvas canvas) {
        if (!t()) {
            return;
        }
        canvas.save();
        z(canvas);
        if (!this.f24216w) {
            l(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.f24215v.width() - getBounds().width());
        int height = (int) (this.f24215v.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f24215v.width()) + (this.f24194a.f24237r * 2) + width, ((int) this.f24215v.height()) + (this.f24194a.f24237r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f4 = (getBounds().left - this.f24194a.f24237r) - width;
            float f5 = (getBounds().top - this.f24194a.f24237r) - height;
            canvas2.translate(-f4, -f5);
            l(canvas2);
            canvas.drawBitmap(createBitmap, f4, f5, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int y(int i4, int i5) {
        return (i4 * (i5 + (i5 >>> 7))) >>> 8;
    }

    private void z(@NonNull Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f24207n.setColorFilter(this.f24212s);
        int alpha = this.f24207n.getAlpha();
        this.f24207n.setAlpha(y(alpha, this.f24194a.f24232m));
        this.f24208o.setColorFilter(this.f24213t);
        this.f24208o.setStrokeWidth(this.f24194a.f24231l);
        int alpha2 = this.f24208o.getAlpha();
        this.f24208o.setAlpha(y(alpha2, this.f24194a.f24232m));
        if (this.f24198e) {
            h();
            f(q(), this.f24200g);
            this.f24198e = false;
        }
        x(canvas);
        if (u()) {
            m(canvas);
        }
        if (v()) {
            p(canvas);
        }
        this.f24207n.setAlpha(alpha);
        this.f24208o.setAlpha(alpha2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void g(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.f24211r;
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        shapeAppearancePathProvider.calculatePath(materialShapeDrawableState.f24220a, materialShapeDrawableState.f24230k, rectF, this.f24210q, path);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.f24194a.f24220a.getBottomLeftCornerSize().getCornerSize(q());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.f24194a.f24220a.getBottomRightCornerSize().getCornerSize(q());
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f24194a;
    }

    public float getElevation() {
        return this.f24194a.f24234o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.f24194a.f24223d;
    }

    public float getInterpolation() {
        return this.f24194a.f24230k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f24194a.f24236q == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.f24194a.f24230k);
            return;
        }
        f(q(), this.f24200g);
        if (this.f24200g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f24200g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f24194a.f24228i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    public Paint.Style getPaintStyle() {
        return this.f24194a.f24241v;
    }

    public float getParentAbsoluteElevation() {
        return this.f24194a.f24233n;
    }

    @Deprecated
    public void getPathForSize(int i4, int i5, @NonNull Path path) {
        g(new RectF(0.0f, 0.0f, i4, i5), path);
    }

    @ColorInt
    public int getResolvedTintColor() {
        return this.f24214u;
    }

    public float getScale() {
        return this.f24194a.f24229j;
    }

    public int getShadowCompatRotation() {
        return this.f24194a.f24239t;
    }

    public int getShadowCompatibilityMode() {
        return this.f24194a.f24236q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        return (int) (materialShapeDrawableState.f24238s * Math.sin(Math.toRadians(materialShapeDrawableState.f24239t)));
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        return (int) (materialShapeDrawableState.f24238s * Math.cos(Math.toRadians(materialShapeDrawableState.f24239t)));
    }

    public int getShadowRadius() {
        return this.f24194a.f24237r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.f24194a.f24238s;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f24194a.f24220a;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f24194a.f24224e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.f24194a.f24225f;
    }

    public float getStrokeWidth() {
        return this.f24194a.f24231l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.f24194a.f24226g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.f24194a.f24220a.getTopLeftCornerSize().getCornerSize(q());
    }

    public float getTopRightCornerResolvedSize() {
        return this.f24194a.f24220a.getTopRightCornerSize().getCornerSize(q());
    }

    public float getTranslationZ() {
        return this.f24194a.f24235p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f24204k.set(getBounds());
        f(q(), this.f24200g);
        this.f24205l.setPath(this.f24200g, this.f24204k);
        this.f24204k.op(this.f24205l, Region.Op.DIFFERENCE);
        return this.f24204k;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.f24194a.f24221b = new ElevationOverlayProvider(context);
        C();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f24198e = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.f24194a.f24221b;
        if (elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.f24194a.f24221b != null) {
            return true;
        }
        return false;
    }

    public boolean isPointInTransparentRegion(int i4, int i5) {
        return getTransparentRegion().contains(i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.f24194a.f24220a.isRoundRect(q());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i4 = this.f24194a.f24236q;
        if (i4 != 0 && i4 != 2) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.f24194a.f24226g) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.f24194a.f24225f) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.f24194a.f24224e) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.f24194a.f24223d) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int k(@ColorInt int i4) {
        float z3 = getZ() + getParentAbsoluteElevation();
        ElevationOverlayProvider elevationOverlayProvider = this.f24194a.f24221b;
        if (elevationOverlayProvider != null) {
            return elevationOverlayProvider.compositeOverlayIfNeeded(i4, z3);
        }
        return i4;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f24194a = new MaterialShapeDrawableState(this.f24194a);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void n(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        o(canvas, paint, path, this.f24194a.f24220a, rectF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f24198e = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z3;
        boolean A = A(iArr);
        boolean B = B();
        if (!A && !B) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            invalidateSelf();
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(@NonNull Canvas canvas) {
        o(canvas, this.f24208o, this.f24201h, this.f24206m, r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public RectF q() {
        this.f24202i.set(getBounds());
        return this.f24202i;
    }

    public boolean requiresCompatShadow() {
        int i4 = Build.VERSION.SDK_INT;
        if (!isRoundRect() && !this.f24200g.isConvex() && i4 < 29) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24232m != i4) {
            materialShapeDrawableState.f24232m = i4;
            w();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f24194a.f24222c = colorFilter;
        w();
    }

    public void setCornerSize(float f4) {
        setShapeAppearanceModel(this.f24194a.f24220a.withCornerSize(f4));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z3) {
        this.f24211r.k(z3);
    }

    public void setElevation(float f4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24234o != f4) {
            materialShapeDrawableState.f24234o = f4;
            C();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24223d != colorStateList) {
            materialShapeDrawableState.f24223d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24230k != f4) {
            materialShapeDrawableState.f24230k = f4;
            this.f24198e = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24228i == null) {
            materialShapeDrawableState.f24228i = new Rect();
        }
        this.f24194a.f24228i.set(i4, i5, i6, i7);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.f24194a.f24241v = style;
        w();
    }

    public void setParentAbsoluteElevation(float f4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24233n != f4) {
            materialShapeDrawableState.f24233n = f4;
            C();
        }
    }

    public void setScale(float f4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24229j != f4) {
            materialShapeDrawableState.f24229j = f4;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z3) {
        this.f24216w = z3;
    }

    public void setShadowColor(int i4) {
        this.f24209p.setShadowColor(i4);
        this.f24194a.f24240u = false;
        w();
    }

    public void setShadowCompatRotation(int i4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24239t != i4) {
            materialShapeDrawableState.f24239t = i4;
            w();
        }
    }

    public void setShadowCompatibilityMode(int i4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24236q != i4) {
            materialShapeDrawableState.f24236q = i4;
            w();
        }
    }

    @Deprecated
    public void setShadowElevation(int i4) {
        setElevation(i4);
    }

    @Deprecated
    public void setShadowEnabled(boolean z3) {
        setShadowCompatibilityMode(!z3 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i4) {
        this.f24194a.f24237r = i4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24238s != i4) {
            materialShapeDrawableState.f24238s = i4;
            w();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f24194a.f24220a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f4, @ColorInt int i4) {
        setStrokeWidth(f4);
        setStrokeColor(ColorStateList.valueOf(i4));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24224e != colorStateList) {
            materialShapeDrawableState.f24224e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.f24194a.f24225f = colorStateList;
        B();
        w();
    }

    public void setStrokeWidth(float f4) {
        this.f24194a.f24231l = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i4) {
        setTintList(ColorStateList.valueOf(i4));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f24194a.f24226g = colorStateList;
        B();
        w();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24227h != mode) {
            materialShapeDrawableState.f24227h = mode;
            B();
            w();
        }
    }

    public void setTranslationZ(float f4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24235p != f4) {
            materialShapeDrawableState.f24235p = f4;
            C();
        }
    }

    public void setUseTintColorForShadow(boolean z3) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f24194a;
        if (materialShapeDrawableState.f24240u != z3) {
            materialShapeDrawableState.f24240u = z3;
            invalidateSelf();
        }
    }

    public void setZ(float f4) {
        setTranslationZ(f4 - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f4) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f4);
        return materialShapeDrawable;
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.f24194a.f24220a.withCornerSize(cornerSize));
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i4, i5).build());
    }

    public void setStroke(float f4, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f4);
        setStrokeColor(colorStateList);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStrokeTint(@ColorInt int i4) {
        setStrokeTint(ColorStateList.valueOf(i4));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    private MaterialShapeDrawable(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
        this.f24195b = new ShapePath.ShadowCompatOperation[4];
        this.f24196c = new ShapePath.ShadowCompatOperation[4];
        this.f24197d = new BitSet(8);
        this.f24199f = new Matrix();
        this.f24200g = new Path();
        this.f24201h = new Path();
        this.f24202i = new RectF();
        this.f24203j = new RectF();
        this.f24204k = new Region();
        this.f24205l = new Region();
        Paint paint = new Paint(1);
        this.f24207n = paint;
        Paint paint2 = new Paint(1);
        this.f24208o = paint2;
        this.f24209p = new ShadowRenderer();
        this.f24211r = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.f24215v = new RectF();
        this.f24216w = true;
        this.f24194a = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        B();
        A(getState());
        this.f24210q = new ShapeAppearancePathProvider.PathListener() { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i4) {
                MaterialShapeDrawable.this.f24197d.set(i4, shapePath.c());
                MaterialShapeDrawable.this.f24195b[i4] = shapePath.d(matrix);
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i4) {
                MaterialShapeDrawable.this.f24197d.set(i4 + 4, shapePath.c());
                MaterialShapeDrawable.this.f24196c[i4] = shapePath.d(matrix);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public ShapeAppearanceModel f24220a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public ElevationOverlayProvider f24221b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f24222c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f24223d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f24224e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f24225f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f24226g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f24227h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Rect f24228i;

        /* renamed from: j  reason: collision with root package name */
        public float f24229j;

        /* renamed from: k  reason: collision with root package name */
        public float f24230k;

        /* renamed from: l  reason: collision with root package name */
        public float f24231l;

        /* renamed from: m  reason: collision with root package name */
        public int f24232m;

        /* renamed from: n  reason: collision with root package name */
        public float f24233n;

        /* renamed from: o  reason: collision with root package name */
        public float f24234o;

        /* renamed from: p  reason: collision with root package name */
        public float f24235p;

        /* renamed from: q  reason: collision with root package name */
        public int f24236q;

        /* renamed from: r  reason: collision with root package name */
        public int f24237r;

        /* renamed from: s  reason: collision with root package name */
        public int f24238s;

        /* renamed from: t  reason: collision with root package name */
        public int f24239t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f24240u;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f24241v;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.f24223d = null;
            this.f24224e = null;
            this.f24225f = null;
            this.f24226g = null;
            this.f24227h = PorterDuff.Mode.SRC_IN;
            this.f24228i = null;
            this.f24229j = 1.0f;
            this.f24230k = 1.0f;
            this.f24232m = 255;
            this.f24233n = 0.0f;
            this.f24234o = 0.0f;
            this.f24235p = 0.0f;
            this.f24236q = 0;
            this.f24237r = 0;
            this.f24238s = 0;
            this.f24239t = 0;
            this.f24240u = false;
            this.f24241v = Paint.Style.FILL_AND_STROKE;
            this.f24220a = shapeAppearanceModel;
            this.f24221b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.f24198e = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
            this.f24223d = null;
            this.f24224e = null;
            this.f24225f = null;
            this.f24226g = null;
            this.f24227h = PorterDuff.Mode.SRC_IN;
            this.f24228i = null;
            this.f24229j = 1.0f;
            this.f24230k = 1.0f;
            this.f24232m = 255;
            this.f24233n = 0.0f;
            this.f24234o = 0.0f;
            this.f24235p = 0.0f;
            this.f24236q = 0;
            this.f24237r = 0;
            this.f24238s = 0;
            this.f24239t = 0;
            this.f24240u = false;
            this.f24241v = Paint.Style.FILL_AND_STROKE;
            this.f24220a = materialShapeDrawableState.f24220a;
            this.f24221b = materialShapeDrawableState.f24221b;
            this.f24231l = materialShapeDrawableState.f24231l;
            this.f24222c = materialShapeDrawableState.f24222c;
            this.f24223d = materialShapeDrawableState.f24223d;
            this.f24224e = materialShapeDrawableState.f24224e;
            this.f24227h = materialShapeDrawableState.f24227h;
            this.f24226g = materialShapeDrawableState.f24226g;
            this.f24232m = materialShapeDrawableState.f24232m;
            this.f24229j = materialShapeDrawableState.f24229j;
            this.f24238s = materialShapeDrawableState.f24238s;
            this.f24236q = materialShapeDrawableState.f24236q;
            this.f24240u = materialShapeDrawableState.f24240u;
            this.f24230k = materialShapeDrawableState.f24230k;
            this.f24233n = materialShapeDrawableState.f24233n;
            this.f24234o = materialShapeDrawableState.f24234o;
            this.f24235p = materialShapeDrawableState.f24235p;
            this.f24237r = materialShapeDrawableState.f24237r;
            this.f24239t = materialShapeDrawableState.f24239t;
            this.f24225f = materialShapeDrawableState.f24225f;
            this.f24241v = materialShapeDrawableState.f24241v;
            if (materialShapeDrawableState.f24228i != null) {
                this.f24228i = new Rect(materialShapeDrawableState.f24228i);
            }
        }
    }
}
