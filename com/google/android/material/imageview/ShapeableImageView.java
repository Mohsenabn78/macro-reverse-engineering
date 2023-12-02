package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;

/* loaded from: classes5.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {

    /* renamed from: s  reason: collision with root package name */
    private static final int f23743s = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: a  reason: collision with root package name */
    private final ShapeAppearancePathProvider f23744a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f23745b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f23746c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f23747d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f23748e;

    /* renamed from: f  reason: collision with root package name */
    private final Path f23749f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f23750g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private MaterialShapeDrawable f23751h;

    /* renamed from: i  reason: collision with root package name */
    private ShapeAppearanceModel f23752i;
    @Dimension

    /* renamed from: j  reason: collision with root package name */
    private float f23753j;

    /* renamed from: k  reason: collision with root package name */
    private Path f23754k;
    @Dimension

    /* renamed from: l  reason: collision with root package name */
    private int f23755l;
    @Dimension

    /* renamed from: m  reason: collision with root package name */
    private int f23756m;
    @Dimension

    /* renamed from: n  reason: collision with root package name */
    private int f23757n;
    @Dimension

    /* renamed from: o  reason: collision with root package name */
    private int f23758o;
    @Dimension

    /* renamed from: p  reason: collision with root package name */
    private int f23759p;
    @Dimension

    /* renamed from: q  reason: collision with root package name */
    private int f23760q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23761r;

    @TargetApi(21)
    /* loaded from: classes5.dex */
    class OutlineProvider extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f23762a = new Rect();

        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f23752i == null) {
                return;
            }
            if (ShapeableImageView.this.f23751h == null) {
                ShapeableImageView.this.f23751h = new MaterialShapeDrawable(ShapeableImageView.this.f23752i);
            }
            ShapeableImageView.this.f23745b.round(this.f23762a);
            ShapeableImageView.this.f23751h.setBounds(this.f23762a);
            ShapeableImageView.this.f23751h.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void e(Canvas canvas) {
        if (this.f23750g == null) {
            return;
        }
        this.f23747d.setStrokeWidth(this.f23753j);
        int colorForState = this.f23750g.getColorForState(getDrawableState(), this.f23750g.getDefaultColor());
        if (this.f23753j > 0.0f && colorForState != 0) {
            this.f23747d.setColor(colorForState);
            canvas.drawPath(this.f23749f, this.f23747d);
        }
    }

    private boolean f() {
        if (this.f23759p == Integer.MIN_VALUE && this.f23760q == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean g() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void h(int i4, int i5) {
        this.f23745b.set(getPaddingLeft(), getPaddingTop(), i4 - getPaddingRight(), i5 - getPaddingBottom());
        this.f23744a.calculatePath(this.f23752i, 1.0f, this.f23745b, this.f23749f);
        this.f23754k.rewind();
        this.f23754k.addPath(this.f23749f);
        this.f23746c.set(0.0f, 0.0f, i4, i5);
        this.f23754k.addRect(this.f23746c, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.f23758o;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i4 = this.f23760q;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        if (g()) {
            return this.f23755l;
        }
        return this.f23757n;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i4;
        int i5;
        if (f()) {
            if (g() && (i5 = this.f23760q) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!g() && (i4 = this.f23759p) != Integer.MIN_VALUE) {
                return i4;
            }
        }
        return this.f23755l;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i4;
        int i5;
        if (f()) {
            if (g() && (i5 = this.f23759p) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!g() && (i4 = this.f23760q) != Integer.MIN_VALUE) {
                return i4;
            }
        }
        return this.f23757n;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i4 = this.f23759p;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        if (g()) {
            return this.f23757n;
        }
        return this.f23755l;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.f23756m;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f23752i;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f23750g;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f23753j;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f23754k, this.f23748e);
        e(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f23761r || !isLayoutDirectionResolved()) {
            return;
        }
        this.f23761r = true;
        if (!isPaddingRelative() && !f()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        h(i4, i5);
    }

    public void setContentPadding(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        this.f23759p = Integer.MIN_VALUE;
        this.f23760q = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f23755l) + i4, (super.getPaddingTop() - this.f23756m) + i5, (super.getPaddingRight() - this.f23757n) + i6, (super.getPaddingBottom() - this.f23758o) + i7);
        this.f23755l = i4;
        this.f23756m = i5;
        this.f23757n = i6;
        this.f23758o = i7;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        int i8;
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i4, (super.getPaddingTop() - this.f23756m) + i5, (super.getPaddingEnd() - getContentPaddingEnd()) + i6, (super.getPaddingBottom() - this.f23758o) + i7);
        if (g()) {
            i8 = i6;
        } else {
            i8 = i4;
        }
        this.f23755l = i8;
        this.f23756m = i5;
        if (!g()) {
            i4 = i6;
        }
        this.f23757n = i4;
        this.f23758o = i7;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPadding(i4 + getContentPaddingLeft(), i5 + getContentPaddingTop(), i6 + getContentPaddingRight(), i7 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPaddingRelative(i4 + getContentPaddingStart(), i5 + getContentPaddingTop(), i6 + getContentPaddingEnd(), i7 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23752i = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f23751h;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        h(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f23750g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i4) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setStrokeWidth(@Dimension float f4) {
        if (this.f23753j != f4) {
            this.f23753j = f4;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i4) {
        setStrokeWidth(getResources().getDimensionPixelSize(i4));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f23743s
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            com.google.android.material.shape.ShapeAppearancePathProvider r7 = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance()
            r6.f23744a = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f23749f = r7
            r7 = 0
            r6.f23761r = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f23748e = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23745b = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23746c = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f23754k = r2
            int[] r2 = com.google.android.material.R.styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList(r1, r2, r4)
            r6.f23750g = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f23753j = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23755l = r7
            r6.f23756m = r7
            r6.f23757n = r7
            r6.f23758o = r7
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23755l = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23756m = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23757n = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23758o = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23759p = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23760q = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f23747d = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.builder(r1, r8, r9, r0)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.build()
            r6.f23752i = r7
            com.google.android.material.imageview.ShapeableImageView$OutlineProvider r7 = new com.google.android.material.imageview.ShapeableImageView$OutlineProvider
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
