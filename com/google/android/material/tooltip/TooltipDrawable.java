package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    @StyleRes
    private static final int Q = R.style.Widget_MaterialComponents_Tooltip;
    @AttrRes
    private static final int R = R.attr.tooltipStyle;
    @NonNull
    private final Context A;
    @Nullable
    private final Paint.FontMetrics B;
    @NonNull
    private final TextDrawableHelper C;
    @NonNull
    private final View.OnLayoutChangeListener D;
    @NonNull
    private final Rect E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private float L;
    private float M;
    private final float N;
    private float O;
    private float P;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f24832z;

    private TooltipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        super(context, attributeSet, i4, i5);
        this.B = new Paint.FontMetrics();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.C = textDrawableHelper;
        this.D = new View.OnLayoutChangeListener() { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                TooltipDrawable.this.L(view);
            }
        };
        this.E = new Rect();
        this.L = 1.0f;
        this.M = 1.0f;
        this.N = 0.5f;
        this.O = 0.5f;
        this.P = 1.0f;
        this.A = context;
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    private float E() {
        int i4;
        if (((this.E.right - getBounds().right) - this.K) - this.I < 0) {
            i4 = ((this.E.right - getBounds().right) - this.K) - this.I;
        } else if (((this.E.left - getBounds().left) - this.K) + this.I > 0) {
            i4 = ((this.E.left - getBounds().left) - this.K) + this.I;
        } else {
            return 0.0f;
        }
        return i4;
    }

    private float F() {
        this.C.getTextPaint().getFontMetrics(this.B);
        Paint.FontMetrics fontMetrics = this.B;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float G(@NonNull Rect rect) {
        return rect.centerY() - F();
    }

    private EdgeTreatment H() {
        float width = ((float) (getBounds().width() - (this.J * Math.sqrt(2.0d)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.J), Math.min(Math.max(-E(), -width), width));
    }

    private void I(@NonNull Canvas canvas) {
        if (this.f24832z == null) {
            return;
        }
        Rect bounds = getBounds();
        int G = (int) G(bounds);
        if (this.C.getTextAppearance() != null) {
            this.C.getTextPaint().drawableState = getState();
            this.C.updateTextPaintDrawState(this.A);
            this.C.getTextPaint().setAlpha((int) (this.P * 255.0f));
        }
        CharSequence charSequence = this.f24832z;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), G, this.C.getTextPaint());
    }

    private float J() {
        CharSequence charSequence = this.f24832z;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.C.getTextWidth(charSequence.toString());
    }

    private void K(@Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.A, attributeSet, R.styleable.Tooltip, i4, i5, new int[0]);
        this.J = this.A.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(H()).build());
        setText(obtainStyledAttributes.getText(R.styleable.Tooltip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(this.A, obtainStyledAttributes, R.styleable.Tooltip_android_textAppearance);
        if (textAppearance != null) {
            int i6 = R.styleable.Tooltip_android_textColor;
            if (obtainStyledAttributes.hasValue(i6)) {
                textAppearance.setTextColor(MaterialResources.getColorStateList(this.A, obtainStyledAttributes, i6));
            }
        }
        setTextAppearance(textAppearance);
        setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.Tooltip_backgroundTint, MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.A, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(MaterialColors.getColor(this.A, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153)))));
        setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.A, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        this.F = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.G = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.H = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.K = iArr[0];
        view.getWindowVisibleDisplayFrame(this.E);
    }

    @NonNull
    public static TooltipDrawable create(@NonNull Context context) {
        return createFromAttributes(context, null, R, Q);
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context, attributeSet, i4, i5);
        tooltipDrawable.K(attributeSet, i4, i5);
        return tooltipDrawable;
    }

    public void detachView(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.D);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.scale(this.L, this.M, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.O));
        canvas.translate(E(), (float) (-((this.J * Math.sqrt(2.0d)) - this.J)));
        super.draw(canvas);
        I(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.C.getTextPaint().getTextSize(), this.H);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.F * 2) + J(), this.G);
    }

    public int getLayoutMargin() {
        return this.I;
    }

    public int getMinHeight() {
        return this.H;
    }

    public int getMinWidth() {
        return this.G;
    }

    @Nullable
    public CharSequence getText() {
        return this.f24832z;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.C.getTextAppearance();
    }

    public int getTextPadding() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(H()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(@Px int i4) {
        this.I = i4;
        invalidateSelf();
    }

    public void setMinHeight(@Px int i4) {
        this.H = i4;
        invalidateSelf();
    }

    public void setMinWidth(@Px int i4) {
        this.G = i4;
        invalidateSelf();
    }

    public void setRelativeToView(@Nullable View view) {
        if (view == null) {
            return;
        }
        L(view);
        view.addOnLayoutChangeListener(this.D);
    }

    public void setRevealFraction(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.O = 1.2f;
        this.L = f4;
        this.M = f4;
        this.P = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, f4);
        invalidateSelf();
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (!TextUtils.equals(this.f24832z, charSequence)) {
            this.f24832z = charSequence;
            this.C.setTextWidthDirty(true);
            invalidateSelf();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.C.setTextAppearance(textAppearance, this.A);
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(new TextAppearance(this.A, i4));
    }

    public void setTextPadding(@Px int i4) {
        this.F = i4;
        invalidateSelf();
    }

    public void setTextResource(@StringRes int i4) {
        setText(this.A.getResources().getString(i4));
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return createFromAttributes(context, attributeSet, R, Q);
    }
}
