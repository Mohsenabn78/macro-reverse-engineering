package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: Access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class BorderDrawable extends Drawable {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f23621b;
    @Dimension

    /* renamed from: h  reason: collision with root package name */
    float f23627h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f23628i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f23629j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f23630k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    private int f23631l;
    @ColorInt

    /* renamed from: m  reason: collision with root package name */
    private int f23632m;

    /* renamed from: o  reason: collision with root package name */
    private ShapeAppearanceModel f23634o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f23635p;

    /* renamed from: a  reason: collision with root package name */
    private final ShapeAppearancePathProvider f23620a = ShapeAppearancePathProvider.getInstance();

    /* renamed from: c  reason: collision with root package name */
    private final Path f23622c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f23623d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f23624e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f23625f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final BorderState f23626g = new BorderState();

    /* renamed from: n  reason: collision with root package name */
    private boolean f23633n = true;

    /* loaded from: classes5.dex */
    private class BorderState extends Drawable.ConstantState {
        private BorderState() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return BorderDrawable.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BorderDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this.f23634o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f23621b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect rect = this.f23623d;
        copyBounds(rect);
        float height = this.f23627h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.f23628i, this.f23632m), ColorUtils.compositeColors(this.f23629j, this.f23632m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f23629j, 0), this.f23632m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f23631l, 0), this.f23632m), ColorUtils.compositeColors(this.f23631l, this.f23632m), ColorUtils.compositeColors(this.f23630k, this.f23632m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    protected RectF b() {
        this.f23625f.set(getBounds());
        return this.f23625f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f23632m = colorStateList.getColorForState(getState(), this.f23632m);
        }
        this.f23635p = colorStateList;
        this.f23633n = true;
        invalidateSelf();
    }

    public void d(@Dimension float f4) {
        if (this.f23627h != f4) {
            this.f23627h = f4;
            this.f23621b.setStrokeWidth(f4 * 1.3333f);
            this.f23633n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f23633n) {
            this.f23621b.setShader(a());
            this.f23633n = false;
        }
        float strokeWidth = this.f23621b.getStrokeWidth() / 2.0f;
        copyBounds(this.f23623d);
        this.f23624e.set(this.f23623d);
        float min = Math.min(this.f23634o.getTopLeftCornerSize().getCornerSize(b()), this.f23624e.width() / 2.0f);
        if (this.f23634o.isRoundRect(b())) {
            this.f23624e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f23624e, min, min, this.f23621b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@ColorInt int i4, @ColorInt int i5, @ColorInt int i6, @ColorInt int i7) {
        this.f23628i = i4;
        this.f23629j = i5;
        this.f23630k = i6;
        this.f23631l = i7;
    }

    public void f(ShapeAppearanceModel shapeAppearanceModel) {
        this.f23634o = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f23626g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f23627h > 0.0f) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f23634o.isRoundRect(b())) {
            outline.setRoundRect(getBounds(), this.f23634o.getTopLeftCornerSize().getCornerSize(b()));
            return;
        }
        copyBounds(this.f23623d);
        this.f23624e.set(this.f23623d);
        this.f23620a.calculatePath(this.f23634o, 1.0f, this.f23624e, this.f23622c);
        if (this.f23622c.isConvex()) {
            outline.setConvexPath(this.f23622c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.f23634o.isRoundRect(b())) {
            int round = Math.round(this.f23627h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f23635p;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f23633n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f23635p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f23632m)) != this.f23632m) {
            this.f23633n = true;
            this.f23632m = colorForState;
        }
        if (this.f23633n) {
            invalidateSelf();
        }
        return this.f23633n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i4) {
        this.f23621b.setAlpha(i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f23621b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
