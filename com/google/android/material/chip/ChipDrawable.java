package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final int[] J0 = {16842910};
    private static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    @Nullable
    private ColorStateList A;
    @Nullable
    private PorterDuff.Mode A0;
    private float B;
    private int[] B0;
    private float C;
    private boolean C0;
    @Nullable
    private ColorStateList D;
    @Nullable
    private ColorStateList D0;
    private float E;
    @NonNull
    private WeakReference<Delegate> E0;
    @Nullable
    private ColorStateList F;
    private TextUtils.TruncateAt F0;
    @Nullable
    private CharSequence G;
    private boolean G0;
    private boolean H;
    private int H0;
    @Nullable
    private Drawable I;
    private boolean I0;
    @Nullable
    private ColorStateList J;
    private float K;
    private boolean L;
    private boolean M;
    @Nullable
    private Drawable N;
    @Nullable
    private Drawable O;
    @Nullable
    private ColorStateList P;
    private float Q;
    @Nullable
    private CharSequence R;
    private boolean S;
    private boolean T;
    @Nullable
    private Drawable U;
    @Nullable
    private ColorStateList V;
    @Nullable
    private MotionSpec W;
    @Nullable
    private MotionSpec X;
    private float Y;
    private float Z;

    /* renamed from: a0  reason: collision with root package name */
    private float f23312a0;

    /* renamed from: b0  reason: collision with root package name */
    private float f23313b0;

    /* renamed from: c0  reason: collision with root package name */
    private float f23314c0;

    /* renamed from: d0  reason: collision with root package name */
    private float f23315d0;

    /* renamed from: e0  reason: collision with root package name */
    private float f23316e0;

    /* renamed from: f0  reason: collision with root package name */
    private float f23317f0;
    @NonNull

    /* renamed from: g0  reason: collision with root package name */
    private final Context f23318g0;

    /* renamed from: h0  reason: collision with root package name */
    private final Paint f23319h0;
    @Nullable

    /* renamed from: i0  reason: collision with root package name */
    private final Paint f23320i0;

    /* renamed from: j0  reason: collision with root package name */
    private final Paint.FontMetrics f23321j0;

    /* renamed from: k0  reason: collision with root package name */
    private final RectF f23322k0;

    /* renamed from: l0  reason: collision with root package name */
    private final PointF f23323l0;

    /* renamed from: m0  reason: collision with root package name */
    private final Path f23324m0;
    @NonNull

    /* renamed from: n0  reason: collision with root package name */
    private final TextDrawableHelper f23325n0;
    @ColorInt

    /* renamed from: o0  reason: collision with root package name */
    private int f23326o0;
    @ColorInt

    /* renamed from: p0  reason: collision with root package name */
    private int f23327p0;
    @ColorInt

    /* renamed from: q0  reason: collision with root package name */
    private int f23328q0;
    @ColorInt

    /* renamed from: r0  reason: collision with root package name */
    private int f23329r0;
    @ColorInt

    /* renamed from: s0  reason: collision with root package name */
    private int f23330s0;
    @ColorInt

    /* renamed from: t0  reason: collision with root package name */
    private int f23331t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f23332u0;
    @ColorInt

    /* renamed from: v0  reason: collision with root package name */
    private int f23333v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f23334w0;
    @Nullable

    /* renamed from: x0  reason: collision with root package name */
    private ColorFilter f23335x0;
    @Nullable

    /* renamed from: y0  reason: collision with root package name */
    private PorterDuffColorFilter f23336y0;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f23337z;
    @Nullable

    /* renamed from: z0  reason: collision with root package name */
    private ColorStateList f23338z0;

    /* loaded from: classes5.dex */
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        super(context, attributeSet, i4, i5);
        this.C = -1.0f;
        this.f23319h0 = new Paint(1);
        this.f23321j0 = new Paint.FontMetrics();
        this.f23322k0 = new RectF();
        this.f23323l0 = new PointF();
        this.f23324m0 = new Path();
        this.f23334w0 = 255;
        this.A0 = PorterDuff.Mode.SRC_IN;
        this.E0 = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.f23318g0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f23325n0 = textDrawableHelper;
        this.G = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.f23320i0 = null;
        int[] iArr = J0;
        setState(iArr);
        setCloseIconState(iArr);
        this.G0 = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            K0.setTint(-1);
        }
    }

    private void D(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            DrawableCompat.setTintList(drawable, this.P);
            return;
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.L) {
            DrawableCompat.setTintList(drawable2, this.J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void E(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (l0() || k0()) {
            float f4 = this.Y + this.Z;
            float Y = Y();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = rect.left + f4;
                rectF.left = f5;
                rectF.right = f5 + Y;
            } else {
                float f6 = rect.right - f4;
                rectF.right = f6;
                rectF.left = f6 - Y;
            }
            float X = X();
            float exactCenterY = rect.exactCenterY() - (X / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + X;
        }
    }

    private void G(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (m0()) {
            float f4 = this.f23317f0 + this.f23316e0 + this.Q + this.f23315d0 + this.f23314c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f4;
            } else {
                rectF.left = rect.left + f4;
            }
        }
    }

    private void H(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (m0()) {
            float f4 = this.f23317f0 + this.f23316e0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = rect.right - f4;
                rectF.right = f5;
                rectF.left = f5 - this.Q;
            } else {
                float f6 = rect.left + f4;
                rectF.left = f6;
                rectF.right = f6 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f7 = this.Q;
            float f8 = exactCenterY - (f7 / 2.0f);
            rectF.top = f8;
            rectF.bottom = f8 + f7;
        }
    }

    private void I(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (m0()) {
            float f4 = this.f23317f0 + this.f23316e0 + this.Q + this.f23315d0 + this.f23314c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = rect.right;
                rectF.right = f5;
                rectF.left = f5 - f4;
            } else {
                int i4 = rect.left;
                rectF.left = i4;
                rectF.right = i4 + f4;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void K(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float F = this.Y + F() + this.f23313b0;
            float J = this.f23317f0 + J() + this.f23314c0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + F;
                rectF.right = rect.right - J;
            } else {
                rectF.left = rect.left + J;
                rectF.right = rect.right - F;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float L() {
        this.f23325n0.getTextPaint().getFontMetrics(this.f23321j0);
        Paint.FontMetrics fontMetrics = this.f23321j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean N() {
        if (this.T && this.U != null && this.S) {
            return true;
        }
        return false;
    }

    private void O(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (k0()) {
            E(rect, this.f23322k0);
            RectF rectF = this.f23322k0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.U.setBounds(0, 0, (int) this.f23322k0.width(), (int) this.f23322k0.height());
            this.U.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void P(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.I0) {
            this.f23319h0.setColor(this.f23327p0);
            this.f23319h0.setStyle(Paint.Style.FILL);
            this.f23319h0.setColorFilter(Z());
            this.f23322k0.set(rect);
            canvas.drawRoundRect(this.f23322k0, getChipCornerRadius(), getChipCornerRadius(), this.f23319h0);
        }
    }

    private void Q(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (l0()) {
            E(rect, this.f23322k0);
            RectF rectF = this.f23322k0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.I.setBounds(0, 0, (int) this.f23322k0.width(), (int) this.f23322k0.height());
            this.I.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void R(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.E > 0.0f && !this.I0) {
            this.f23319h0.setColor(this.f23329r0);
            this.f23319h0.setStyle(Paint.Style.STROKE);
            if (!this.I0) {
                this.f23319h0.setColorFilter(Z());
            }
            RectF rectF = this.f23322k0;
            float f4 = this.E;
            rectF.set(rect.left + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
            float f5 = this.C - (this.E / 2.0f);
            canvas.drawRoundRect(this.f23322k0, f5, f5, this.f23319h0);
        }
    }

    private void S(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.I0) {
            this.f23319h0.setColor(this.f23326o0);
            this.f23319h0.setStyle(Paint.Style.FILL);
            this.f23322k0.set(rect);
            canvas.drawRoundRect(this.f23322k0, getChipCornerRadius(), getChipCornerRadius(), this.f23319h0);
        }
    }

    private void T(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (m0()) {
            H(rect, this.f23322k0);
            RectF rectF = this.f23322k0;
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas.translate(f4, f5);
            this.N.setBounds(0, 0, (int) this.f23322k0.width(), (int) this.f23322k0.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
            } else {
                this.N.draw(canvas);
            }
            canvas.translate(-f4, -f5);
        }
    }

    private void U(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f23319h0.setColor(this.f23330s0);
        this.f23319h0.setStyle(Paint.Style.FILL);
        this.f23322k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.f23322k0, getChipCornerRadius(), getChipCornerRadius(), this.f23319h0);
            return;
        }
        g(new RectF(rect), this.f23324m0);
        super.n(canvas, this.f23319h0, this.f23324m0, q());
    }

    private void V(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f23320i0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.f23320i0);
            if (l0() || k0()) {
                E(rect, this.f23322k0);
                canvas.drawRect(this.f23322k0, this.f23320i0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f23320i0);
            }
            if (m0()) {
                H(rect, this.f23322k0);
                canvas.drawRect(this.f23322k0, this.f23320i0);
            }
            this.f23320i0.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            G(rect, this.f23322k0);
            canvas.drawRect(this.f23322k0, this.f23320i0);
            this.f23320i0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            I(rect, this.f23322k0);
            canvas.drawRect(this.f23322k0, this.f23320i0);
        }
    }

    private void W(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z3;
        if (this.G != null) {
            Paint.Align M = M(rect, this.f23323l0);
            K(rect, this.f23322k0);
            if (this.f23325n0.getTextAppearance() != null) {
                this.f23325n0.getTextPaint().drawableState = getState();
                this.f23325n0.updateTextPaintDrawState(this.f23318g0);
            }
            this.f23325n0.getTextPaint().setTextAlign(M);
            int i4 = 0;
            if (Math.round(this.f23325n0.getTextWidth(getText().toString())) > Math.round(this.f23322k0.width())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i4 = canvas.save();
                canvas.clipRect(this.f23322k0);
            }
            CharSequence charSequence = this.G;
            if (z3 && this.F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f23325n0.getTextPaint(), this.f23322k0.width(), this.F0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f23323l0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f23325n0.getTextPaint());
            if (z3) {
                canvas.restoreToCount(i4);
            }
        }
    }

    private float X() {
        Drawable drawable;
        if (this.f23332u0) {
            drawable = this.U;
        } else {
            drawable = this.I;
        }
        float f4 = this.K;
        if (f4 <= 0.0f && drawable != null) {
            f4 = (float) Math.ceil(ViewUtils.dpToPx(this.f23318g0, 24));
            if (drawable.getIntrinsicHeight() <= f4) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f4;
    }

    private float Y() {
        Drawable drawable;
        if (this.f23332u0) {
            drawable = this.U;
        } else {
            drawable = this.I;
        }
        float f4 = this.K;
        if (f4 <= 0.0f && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f4;
    }

    @Nullable
    private ColorFilter Z() {
        ColorFilter colorFilter = this.f23335x0;
        if (colorFilter == null) {
            return this.f23336y0;
        }
        return colorFilter;
    }

    private static boolean a0(@Nullable int[] iArr, @AttrRes int i4) {
        if (iArr == null) {
            return false;
        }
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    private static boolean b0(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    private static boolean c0(@Nullable Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i4, i5);
        chipDrawable.e0(attributeSet, i4, i5);
        return chipDrawable;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context, @XmlRes int i4) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i4, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context, parseDrawableXml, R.attr.chipStandaloneStyle, styleAttribute);
    }

    private static boolean d0(@Nullable TextAppearance textAppearance) {
        if (textAppearance != null && textAppearance.getTextColor() != null && textAppearance.getTextColor().isStateful()) {
            return true;
        }
        return false;
    }

    private void e0(@Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.f23318g0, attributeSet, R.styleable.Chip, i4, i5, new int[0]);
        this.I0 = obtainStyledAttributes.hasValue(R.styleable.Chip_shapeAppearance);
        h0(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i6 = R.styleable.Chip_chipCornerRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            setChipCornerRadius(obtainStyledAttributes.getDimension(i6, 0.0f));
        }
        setChipStrokeColor(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(R.styleable.Chip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_android_textAppearance);
        textAppearance.setTextSize(obtainStyledAttributes.getDimension(R.styleable.Chip_android_textSize, textAppearance.getTextSize()));
        setTextAppearance(textAppearance);
        int i7 = obtainStyledAttributes.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 == 3) {
                    setEllipsize(TextUtils.TruncateAt.END);
                }
            } else {
                setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            setEllipsize(TextUtils.TruncateAt.START);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(MaterialResources.getDrawable(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_chipIcon));
        int i8 = R.styleable.Chip_chipIconTint;
        if (obtainStyledAttributes.hasValue(i8)) {
            setChipIconTint(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, i8));
        }
        setChipIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(MaterialResources.getDrawable(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(MaterialResources.getDrawable(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_checkedIcon));
        int i9 = R.styleable.Chip_checkedIconTint;
        if (obtainStyledAttributes.hasValue(i9)) {
            setCheckedIconTint(MaterialResources.getColorStateList(this.f23318g0, obtainStyledAttributes, i9));
        }
        setShowMotionSpec(MotionSpec.createFromAttribute(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.f23318g0, obtainStyledAttributes, R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g0(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.g0(int[], int[]):boolean");
    }

    private void h0(@Nullable ColorStateList colorStateList) {
        if (this.f23337z != colorStateList) {
            this.f23337z = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean k0() {
        if (this.T && this.U != null && this.f23332u0) {
            return true;
        }
        return false;
    }

    private boolean l0() {
        if (this.H && this.I != null) {
            return true;
        }
        return false;
    }

    private boolean m0() {
        if (this.M && this.N != null) {
            return true;
        }
        return false;
    }

    private void n0(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void o0() {
        ColorStateList colorStateList;
        if (this.C0) {
            colorStateList = RippleUtils.sanitizeRippleDrawableColor(this.F);
        } else {
            colorStateList = null;
        }
        this.D0 = colorStateList;
    }

    @TargetApi(21)
    private void p0() {
        this.O = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.N, K0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float F() {
        if (!l0() && !k0()) {
            return 0.0f;
        }
        return this.Z + Y() + this.f23312a0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float J() {
        if (m0()) {
            return this.f23315d0 + this.Q + this.f23316e0;
        }
        return 0.0f;
    }

    @NonNull
    Paint.Align M(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float F = this.Y + F() + this.f23313b0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + F;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - F;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - L();
        }
        return align;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i4;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i5 = this.f23334w0;
            if (i5 < 255) {
                i4 = CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i5);
            } else {
                i4 = 0;
            }
            S(canvas, bounds);
            P(canvas, bounds);
            if (this.I0) {
                super.draw(canvas);
            }
            R(canvas, bounds);
            U(canvas, bounds);
            Q(canvas, bounds);
            O(canvas, bounds);
            if (this.G0) {
                W(canvas, bounds);
            }
            T(canvas, bounds);
            V(canvas, bounds);
            if (this.f23334w0 < 255) {
                canvas.restoreToCount(i4);
            }
        }
    }

    protected void f0() {
        Delegate delegate = this.E0.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f23334w0;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.U;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.V;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.A;
    }

    public float getChipCornerRadius() {
        if (this.I0) {
            return getTopLeftCornerResolvedSize();
        }
        return this.C;
    }

    public float getChipEndPadding() {
        return this.f23317f0;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.K;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.J;
    }

    public float getChipMinHeight() {
        return this.B;
    }

    public float getChipStartPadding() {
        return this.Y;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.D;
    }

    public float getChipStrokeWidth() {
        return this.E;
    }

    public void getChipTouchBounds(@NonNull RectF rectF) {
        G(getBounds(), rectF);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.R;
    }

    public float getCloseIconEndPadding() {
        return this.f23316e0;
    }

    public float getCloseIconSize() {
        return this.Q;
    }

    public float getCloseIconStartPadding() {
        return this.f23315d0;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.B0;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.P;
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF) {
        I(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.f23335x0;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.F0;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.X;
    }

    public float getIconEndPadding() {
        return this.f23312a0;
    }

    public float getIconStartPadding() {
        return this.Z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Y + F() + this.f23313b0 + this.f23325n0.getTextWidth(getText().toString()) + this.f23314c0 + J() + this.f23317f0), this.H0);
    }

    @Px
    public int getMaxWidth() {
        return this.H0;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.F;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.W;
    }

    @Nullable
    public CharSequence getText() {
        return this.G;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.f23325n0.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.f23314c0;
    }

    public float getTextStartPadding() {
        return this.f23313b0;
    }

    public boolean getUseCompatRipple() {
        return this.C0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(boolean z3) {
        this.G0 = z3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.S;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.T;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.H;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return c0(this.N);
    }

    public boolean isCloseIconVisible() {
        return this.M;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!b0(this.f23337z) && !b0(this.A) && !b0(this.D) && ((!this.C0 || !b0(this.D0)) && !d0(this.f23325n0.getTextAppearance()) && !N() && !c0(this.I) && !c0(this.U) && !b0(this.f23338z0))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j0() {
        return this.G0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i4) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i4);
        if (l0()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.I, i4);
        }
        if (k0()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.U, i4);
        }
        if (m0()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.N, i4);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i4) {
        boolean onLevelChange = super.onLevelChange(i4);
        if (l0()) {
            onLevelChange |= this.I.setLevel(i4);
        }
        if (k0()) {
            onLevelChange |= this.U.setLevel(i4);
        }
        if (m0()) {
            onLevelChange |= this.N.setLevel(i4);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return g0(iArr, getCloseIconState());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        f0();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        if (this.f23334w0 != i4) {
            this.f23334w0 = i4;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z3) {
        if (this.S != z3) {
            this.S = z3;
            float F = F();
            if (!z3 && this.f23332u0) {
                this.f23332u0 = false;
            }
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    public void setCheckableResource(@BoolRes int i4) {
        setCheckable(this.f23318g0.getResources().getBoolean(i4));
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (this.U != drawable) {
            float F = F();
            this.U = drawable;
            float F2 = F();
            n0(this.U);
            D(this.U);
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i4) {
        setCheckedIconVisible(this.f23318g0.getResources().getBoolean(i4));
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        setCheckedIcon(AppCompatResources.getDrawable(this.f23318g0, i4));
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (N()) {
                DrawableCompat.setTintList(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i4) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    public void setCheckedIconVisible(@BoolRes int i4) {
        setCheckedIconVisible(this.f23318g0.getResources().getBoolean(i4));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i4) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        if (this.C != f4) {
            this.C = f4;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f4));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i4) {
        setChipCornerRadius(this.f23318g0.getResources().getDimension(i4));
    }

    public void setChipEndPadding(float f4) {
        if (this.f23317f0 != f4) {
            this.f23317f0 = f4;
            invalidateSelf();
            f0();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i4) {
        setChipEndPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float F = F();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.I = drawable2;
            float F2 = F();
            n0(chipIcon);
            if (l0()) {
                D(this.I);
            }
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(@DrawableRes int i4) {
        setChipIcon(AppCompatResources.getDrawable(this.f23318g0, i4));
    }

    public void setChipIconSize(float f4) {
        if (this.K != f4) {
            float F = F();
            this.K = f4;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    public void setChipIconSizeResource(@DimenRes int i4) {
        setChipIconSize(this.f23318g0.getResources().getDimension(i4));
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (l0()) {
                DrawableCompat.setTintList(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(@ColorRes int i4) {
        setChipIconTint(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    public void setChipIconVisible(@BoolRes int i4) {
        setChipIconVisible(this.f23318g0.getResources().getBoolean(i4));
    }

    public void setChipMinHeight(float f4) {
        if (this.B != f4) {
            this.B = f4;
            invalidateSelf();
            f0();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i4) {
        setChipMinHeight(this.f23318g0.getResources().getDimension(i4));
    }

    public void setChipStartPadding(float f4) {
        if (this.Y != f4) {
            this.Y = f4;
            invalidateSelf();
            f0();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i4) {
        setChipStartPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i4) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    public void setChipStrokeWidth(float f4) {
        if (this.E != f4) {
            this.E = f4;
            this.f23319h0.setStrokeWidth(f4);
            if (this.I0) {
                super.setStrokeWidth(f4);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i4) {
        setChipStrokeWidth(this.f23318g0.getResources().getDimension(i4));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float J = J();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.N = drawable2;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                p0();
            }
            float J2 = J();
            n0(closeIcon);
            if (m0()) {
                D(this.N);
            }
            invalidateSelf();
            if (J != J2) {
                f0();
            }
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        if (this.f23316e0 != f4) {
            this.f23316e0 = f4;
            invalidateSelf();
            if (m0()) {
                f0();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i4) {
        setCloseIconEndPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setCloseIconResource(@DrawableRes int i4) {
        setCloseIcon(AppCompatResources.getDrawable(this.f23318g0, i4));
    }

    public void setCloseIconSize(float f4) {
        if (this.Q != f4) {
            this.Q = f4;
            invalidateSelf();
            if (m0()) {
                f0();
            }
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i4) {
        setCloseIconSize(this.f23318g0.getResources().getDimension(i4));
    }

    public void setCloseIconStartPadding(float f4) {
        if (this.f23315d0 != f4) {
            this.f23315d0 = f4;
            invalidateSelf();
            if (m0()) {
                f0();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i4) {
        setCloseIconStartPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        if (!Arrays.equals(this.B0, iArr)) {
            this.B0 = iArr;
            if (m0()) {
                return g0(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (m0()) {
                DrawableCompat.setTintList(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@ColorRes int i4) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    public void setCloseIconVisible(@BoolRes int i4) {
        setCloseIconVisible(this.f23318g0.getResources().getBoolean(i4));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f23335x0 != colorFilter) {
            this.f23335x0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setDelegate(@Nullable Delegate delegate) {
        this.E0 = new WeakReference<>(delegate);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.X = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        setHideMotionSpec(MotionSpec.createFromResource(this.f23318g0, i4));
    }

    public void setIconEndPadding(float f4) {
        if (this.f23312a0 != f4) {
            float F = F();
            this.f23312a0 = f4;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i4) {
        setIconEndPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setIconStartPadding(float f4) {
        if (this.Z != f4) {
            float F = F();
            this.Z = f4;
            float F2 = F();
            invalidateSelf();
            if (F != F2) {
                f0();
            }
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i4) {
        setIconStartPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setMaxWidth(@Px int i4) {
        this.H0 = i4;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            o0();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        setRippleColor(AppCompatResources.getColorStateList(this.f23318g0, i4));
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.W = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        setShowMotionSpec(MotionSpec.createFromResource(this.f23318g0, i4));
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.f23325n0.setTextWidthDirty(true);
            invalidateSelf();
            f0();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.f23325n0.setTextAppearance(textAppearance, this.f23318g0);
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(new TextAppearance(this.f23318g0, i4));
    }

    public void setTextEndPadding(float f4) {
        if (this.f23314c0 != f4) {
            this.f23314c0 = f4;
            invalidateSelf();
            f0();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i4) {
        setTextEndPadding(this.f23318g0.getResources().getDimension(i4));
    }

    public void setTextResource(@StringRes int i4) {
        setText(this.f23318g0.getResources().getString(i4));
    }

    public void setTextSize(@Dimension float f4) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextSize(f4);
            this.f23325n0.getTextPaint().setTextSize(f4);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f4) {
        if (this.f23313b0 != f4) {
            this.f23313b0 = f4;
            invalidateSelf();
            f0();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i4) {
        setTextStartPadding(this.f23318g0.getResources().getDimension(i4));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.f23338z0 != colorStateList) {
            this.f23338z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.f23336y0 = DrawableUtils.updateTintFilter(this, this.f23338z0, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z3) {
        if (this.C0 != z3) {
            this.C0 = z3;
            o0();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        if (l0()) {
            visible |= this.I.setVisible(z3, z4);
        }
        if (k0()) {
            visible |= this.U.setVisible(z3, z4);
        }
        if (m0()) {
            visible |= this.N.setVisible(z3, z4);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void setCheckedIconVisible(boolean z3) {
        if (this.T != z3) {
            boolean k02 = k0();
            this.T = z3;
            boolean k03 = k0();
            if (k02 != k03) {
                if (k03) {
                    D(this.U);
                } else {
                    n0(this.U);
                }
                invalidateSelf();
                f0();
            }
        }
    }

    public void setChipIconVisible(boolean z3) {
        if (this.H != z3) {
            boolean l02 = l0();
            this.H = z3;
            boolean l03 = l0();
            if (l02 != l03) {
                if (l03) {
                    D(this.I);
                } else {
                    n0(this.I);
                }
                invalidateSelf();
                f0();
            }
        }
    }

    public void setCloseIconVisible(boolean z3) {
        if (this.M != z3) {
            boolean m02 = m0();
            this.M = z3;
            boolean m03 = m0();
            if (m02 != m03) {
                if (m03) {
                    D(this.N);
                } else {
                    n0(this.N);
                }
                invalidateSelf();
                f0();
            }
        }
    }
}
