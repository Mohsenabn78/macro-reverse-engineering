package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f38526a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f38527b;

    /* renamed from: c  reason: collision with root package name */
    protected int f38528c;

    /* renamed from: d  reason: collision with root package name */
    protected int f38529d;

    /* renamed from: e  reason: collision with root package name */
    protected float[] f38530e;

    /* renamed from: f  reason: collision with root package name */
    protected float[] f38531f;

    /* renamed from: g  reason: collision with root package name */
    private int f38532g;

    /* renamed from: h  reason: collision with root package name */
    private int f38533h;

    /* renamed from: i  reason: collision with root package name */
    private float f38534i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f38535j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f38536k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f38537l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38538m;

    /* renamed from: n  reason: collision with root package name */
    private int f38539n;

    /* renamed from: o  reason: collision with root package name */
    private Path f38540o;

    /* renamed from: p  reason: collision with root package name */
    private Paint f38541p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f38542q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f38543r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f38544s;

    /* renamed from: t  reason: collision with root package name */
    private int f38545t;

    /* renamed from: u  reason: collision with root package name */
    private float f38546u;

    /* renamed from: v  reason: collision with root package name */
    private float f38547v;

    /* renamed from: w  reason: collision with root package name */
    private int f38548w;

    /* renamed from: x  reason: collision with root package name */
    private int f38549x;

    /* renamed from: y  reason: collision with root package name */
    private int f38550y;

    /* renamed from: z  reason: collision with root package name */
    private int f38551z;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    private int c(float f4, float f5) {
        double d4 = this.f38549x;
        int i4 = -1;
        for (int i5 = 0; i5 < 8; i5 += 2) {
            double sqrt = Math.sqrt(Math.pow(f4 - this.f38530e[i5], 2.0d) + Math.pow(f5 - this.f38530e[i5 + 1], 2.0d));
            if (sqrt < d4) {
                i4 = i5 / 2;
                d4 = sqrt;
            }
        }
        if (this.f38545t == 1 && i4 < 0 && this.f38526a.contains(f4, f5)) {
            return 4;
        }
        return i4;
    }

    private void e(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.f38543r.setStrokeWidth(dimensionPixelSize);
        this.f38543r.setColor(color);
        this.f38543r.setStyle(Paint.Style.STROKE);
        this.f38544s.setStrokeWidth(dimensionPixelSize * 3);
        this.f38544s.setColor(color);
        this.f38544s.setStyle(Paint.Style.STROKE);
    }

    private void f(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.f38542q.setStrokeWidth(dimensionPixelSize);
        this.f38542q.setColor(color);
        this.f38532g = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.f38533h = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void h(float f4, float f5) {
        boolean z3;
        float f6;
        float f7;
        float f8;
        float f9;
        this.f38527b.set(this.f38526a);
        int i4 = this.f38548w;
        boolean z4 = true;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            this.f38527b.offset(f4 - this.f38546u, f5 - this.f38547v);
                            if (this.f38527b.left > getLeft() && this.f38527b.top > getTop() && this.f38527b.right < getRight() && this.f38527b.bottom < getBottom()) {
                                this.f38526a.set(this.f38527b);
                                i();
                                postInvalidate();
                                return;
                            }
                            return;
                        }
                    } else {
                        RectF rectF = this.f38527b;
                        RectF rectF2 = this.f38526a;
                        rectF.set(f4, rectF2.top, rectF2.right, f5);
                    }
                } else {
                    RectF rectF3 = this.f38527b;
                    RectF rectF4 = this.f38526a;
                    rectF3.set(rectF4.left, rectF4.top, f4, f5);
                }
            } else {
                RectF rectF5 = this.f38527b;
                RectF rectF6 = this.f38526a;
                rectF5.set(rectF6.left, f5, f4, rectF6.bottom);
            }
        } else {
            RectF rectF7 = this.f38527b;
            RectF rectF8 = this.f38526a;
            rectF7.set(f4, f5, rectF8.right, rectF8.bottom);
        }
        if (this.f38527b.height() >= this.f38550y) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f38527b.width() < this.f38550y) {
            z4 = false;
        }
        RectF rectF9 = this.f38526a;
        if (z4) {
            f6 = this.f38527b.left;
        } else {
            f6 = rectF9.left;
        }
        if (z3) {
            f7 = this.f38527b.top;
        } else {
            f7 = rectF9.top;
        }
        if (z4) {
            f8 = this.f38527b.right;
        } else {
            f8 = rectF9.right;
        }
        if (z3) {
            f9 = this.f38527b.bottom;
        } else {
            f9 = rectF9.bottom;
        }
        rectF9.set(f6, f7, f8, f9);
        if (z3 || z4) {
            i();
            postInvalidate();
        }
    }

    private void i() {
        this.f38530e = RectUtils.getCornersFromRect(this.f38526a);
        this.f38531f = RectUtils.getCenterFromRect(this.f38526a);
        this.f38535j = null;
        this.f38540o.reset();
        this.f38540o.addCircle(this.f38526a.centerX(), this.f38526a.centerY(), Math.min(this.f38526a.width(), this.f38526a.height()) / 2.0f, Path.Direction.CW);
    }

    protected void a(@NonNull Canvas canvas) {
        if (this.f38537l) {
            if (this.f38535j == null && !this.f38526a.isEmpty()) {
                this.f38535j = new float[(this.f38532g * 4) + (this.f38533h * 4)];
                int i4 = 0;
                for (int i5 = 0; i5 < this.f38532g; i5++) {
                    float[] fArr = this.f38535j;
                    int i6 = i4 + 1;
                    RectF rectF = this.f38526a;
                    fArr[i4] = rectF.left;
                    int i7 = i6 + 1;
                    float f4 = i5 + 1.0f;
                    float height = rectF.height() * (f4 / (this.f38532g + 1));
                    RectF rectF2 = this.f38526a;
                    fArr[i6] = height + rectF2.top;
                    float[] fArr2 = this.f38535j;
                    int i8 = i7 + 1;
                    fArr2[i7] = rectF2.right;
                    i4 = i8 + 1;
                    fArr2[i8] = (rectF2.height() * (f4 / (this.f38532g + 1))) + this.f38526a.top;
                }
                for (int i9 = 0; i9 < this.f38533h; i9++) {
                    float[] fArr3 = this.f38535j;
                    int i10 = i4 + 1;
                    float f5 = i9 + 1.0f;
                    float width = this.f38526a.width() * (f5 / (this.f38533h + 1));
                    RectF rectF3 = this.f38526a;
                    fArr3[i4] = width + rectF3.left;
                    float[] fArr4 = this.f38535j;
                    int i11 = i10 + 1;
                    fArr4[i10] = rectF3.top;
                    int i12 = i11 + 1;
                    float width2 = rectF3.width() * (f5 / (this.f38533h + 1));
                    RectF rectF4 = this.f38526a;
                    fArr4[i11] = width2 + rectF4.left;
                    i4 = i12 + 1;
                    this.f38535j[i12] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f38535j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f38542q);
            }
        }
        if (this.f38536k) {
            canvas.drawRect(this.f38526a, this.f38543r);
        }
        if (this.f38545t != 0) {
            canvas.save();
            this.f38527b.set(this.f38526a);
            RectF rectF5 = this.f38527b;
            int i13 = this.f38551z;
            rectF5.inset(i13, -i13);
            canvas.clipRect(this.f38527b, Region.Op.DIFFERENCE);
            this.f38527b.set(this.f38526a);
            RectF rectF6 = this.f38527b;
            int i14 = this.f38551z;
            rectF6.inset(-i14, i14);
            canvas.clipRect(this.f38527b, Region.Op.DIFFERENCE);
            canvas.drawRect(this.f38526a, this.f38544s);
            canvas.restore();
        }
    }

    protected void b(@NonNull Canvas canvas) {
        canvas.save();
        if (this.f38538m) {
            canvas.clipPath(this.f38540o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f38526a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f38539n);
        canvas.restore();
        if (this.f38538m) {
            canvas.drawCircle(this.f38526a.centerX(), this.f38526a.centerY(), Math.min(this.f38526a.width(), this.f38526a.height()) / 2.0f, this.f38541p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull TypedArray typedArray) {
        this.f38538m = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.f38539n = color;
        this.f38541p.setColor(color);
        this.f38541p.setStyle(Paint.Style.STROKE);
        this.f38541p.setStrokeWidth(1.0f);
        e(typedArray);
        this.f38536k = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        f(typedArray);
        this.f38537l = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f38526a;
    }

    public int getFreestyleCropMode() {
        return this.f38545t;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.A;
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        if (this.f38545t == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f38528c = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f38529d = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.f38534i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3 = false;
        if (!this.f38526a.isEmpty() && this.f38545t != 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int c4 = c(x3, y3);
                this.f38548w = c4;
                if (c4 != -1) {
                    z3 = true;
                }
                if (!z3) {
                    this.f38546u = -1.0f;
                    this.f38547v = -1.0f;
                } else if (this.f38546u < 0.0f) {
                    this.f38546u = x3;
                    this.f38547v = y3;
                }
                return z3;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f38548w != -1) {
                float min = Math.min(Math.max(x3, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y3, getPaddingTop()), getHeight() - getPaddingBottom());
                h(min, min2);
                this.f38546u = min;
                this.f38547v = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.f38546u = -1.0f;
                this.f38547v = -1.0f;
                this.f38548w = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.A;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.f38526a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z3) {
        this.f38538m = z3;
    }

    public void setCropFrameColor(@ColorInt int i4) {
        this.f38543r.setColor(i4);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i4) {
        this.f38543r.setStrokeWidth(i4);
    }

    public void setCropGridColor(@ColorInt int i4) {
        this.f38542q.setColor(i4);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i4) {
        this.f38533h = i4;
        this.f38535j = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i4) {
        this.f38532g = i4;
        this.f38535j = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i4) {
        this.f38542q.setStrokeWidth(i4);
    }

    public void setDimmedColor(@ColorInt int i4) {
        this.f38539n = i4;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z3) {
        this.f38545t = z3 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i4) {
        this.f38545t = i4;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.A = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z3) {
        this.f38536k = z3;
    }

    public void setShowCropGrid(boolean z3) {
        this.f38537l = z3;
    }

    public void setTargetAspectRatio(float f4) {
        this.f38534i = f4;
        if (this.f38528c > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.B = true;
    }

    public void setupCropBounds() {
        int i4 = this.f38528c;
        float f4 = this.f38534i;
        int i5 = (int) (i4 / f4);
        int i6 = this.f38529d;
        if (i5 > i6) {
            int i7 = (int) (i6 * f4);
            int i8 = (i4 - i7) / 2;
            this.f38526a.set(getPaddingLeft() + i8, getPaddingTop(), getPaddingLeft() + i7 + i8, getPaddingTop() + this.f38529d);
        } else {
            int i9 = (i6 - i5) / 2;
            this.f38526a.set(getPaddingLeft(), getPaddingTop() + i9, getPaddingLeft() + this.f38528c, getPaddingTop() + i5 + i9);
        }
        OverlayViewChangeListener overlayViewChangeListener = this.A;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.f38526a);
        }
        i();
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38526a = new RectF();
        this.f38527b = new RectF();
        this.f38535j = null;
        this.f38540o = new Path();
        this.f38541p = new Paint(1);
        this.f38542q = new Paint(1);
        this.f38543r = new Paint(1);
        this.f38544s = new Paint(1);
        this.f38545t = 0;
        this.f38546u = -1.0f;
        this.f38547v = -1.0f;
        this.f38548w = -1;
        this.f38549x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f38550y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.f38551z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        d();
    }

    protected void d() {
    }
}
