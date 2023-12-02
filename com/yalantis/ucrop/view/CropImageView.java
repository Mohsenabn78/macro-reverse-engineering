package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private long A;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f38495p;

    /* renamed from: q  reason: collision with root package name */
    private final Matrix f38496q;

    /* renamed from: r  reason: collision with root package name */
    private float f38497r;

    /* renamed from: s  reason: collision with root package name */
    private float f38498s;

    /* renamed from: t  reason: collision with root package name */
    private CropBoundsChangeListener f38499t;

    /* renamed from: u  reason: collision with root package name */
    private Runnable f38500u;

    /* renamed from: v  reason: collision with root package name */
    private Runnable f38501v;

    /* renamed from: w  reason: collision with root package name */
    private float f38502w;

    /* renamed from: x  reason: collision with root package name */
    private float f38503x;

    /* renamed from: y  reason: collision with root package name */
    private int f38504y;

    /* renamed from: z  reason: collision with root package name */
    private int f38505z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f38506a;

        /* renamed from: b  reason: collision with root package name */
        private final long f38507b;

        /* renamed from: c  reason: collision with root package name */
        private final long f38508c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f38509d;

        /* renamed from: e  reason: collision with root package name */
        private final float f38510e;

        /* renamed from: f  reason: collision with root package name */
        private final float f38511f;

        /* renamed from: g  reason: collision with root package name */
        private final float f38512g;

        /* renamed from: h  reason: collision with root package name */
        private final float f38513h;

        /* renamed from: i  reason: collision with root package name */
        private final float f38514i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f38515j;

        public a(CropImageView cropImageView, long j4, float f4, float f5, float f6, float f7, float f8, float f9, boolean z3) {
            this.f38506a = new WeakReference<>(cropImageView);
            this.f38507b = j4;
            this.f38509d = f4;
            this.f38510e = f5;
            this.f38511f = f6;
            this.f38512g = f7;
            this.f38513h = f8;
            this.f38514i = f9;
            this.f38515j = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f38506a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f38507b, System.currentTimeMillis() - this.f38508c);
            float easeOut = CubicEasing.easeOut(min, 0.0f, this.f38511f, (float) this.f38507b);
            float easeOut2 = CubicEasing.easeOut(min, 0.0f, this.f38512g, (float) this.f38507b);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.f38514i, (float) this.f38507b);
            if (min < ((float) this.f38507b)) {
                float[] fArr = cropImageView.f38553b;
                cropImageView.postTranslate(easeOut - (fArr[0] - this.f38509d), easeOut2 - (fArr[1] - this.f38510e));
                if (!this.f38515j) {
                    cropImageView.zoomInImage(this.f38513h + easeInOut, cropImageView.f38495p.centerX(), cropImageView.f38495p.centerY());
                }
                if (!cropImageView.l()) {
                    cropImageView.post(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f38516a;

        /* renamed from: b  reason: collision with root package name */
        private final long f38517b;

        /* renamed from: c  reason: collision with root package name */
        private final long f38518c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f38519d;

        /* renamed from: e  reason: collision with root package name */
        private final float f38520e;

        /* renamed from: f  reason: collision with root package name */
        private final float f38521f;

        /* renamed from: g  reason: collision with root package name */
        private final float f38522g;

        public b(CropImageView cropImageView, long j4, float f4, float f5, float f6, float f7) {
            this.f38516a = new WeakReference<>(cropImageView);
            this.f38517b = j4;
            this.f38519d = f4;
            this.f38520e = f5;
            this.f38521f = f6;
            this.f38522g = f7;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f38516a.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.f38517b, System.currentTimeMillis() - this.f38518c);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.f38520e, (float) this.f38517b);
            if (min < ((float) this.f38517b)) {
                cropImageView.zoomInImage(this.f38519d + easeInOut, this.f38521f, this.f38522g);
                cropImageView.post(this);
                return;
            }
            cropImageView.setImageToWrapCropBounds();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private float[] i() {
        this.f38496q.reset();
        this.f38496q.setRotate(-getCurrentAngle());
        float[] fArr = this.f38552a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.f38495p);
        this.f38496q.mapPoints(copyOf);
        this.f38496q.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f4 = trapToRect.left - trapToRect2.left;
        float f5 = trapToRect.top - trapToRect2.top;
        float f6 = trapToRect.right - trapToRect2.right;
        float f7 = trapToRect.bottom - trapToRect2.bottom;
        float[] fArr2 = new float[4];
        if (f4 <= 0.0f) {
            f4 = 0.0f;
        }
        fArr2[0] = f4;
        if (f5 <= 0.0f) {
            f5 = 0.0f;
        }
        fArr2[1] = f5;
        if (f6 >= 0.0f) {
            f6 = 0.0f;
        }
        fArr2[2] = f6;
        if (f7 >= 0.0f) {
            f7 = 0.0f;
        }
        fArr2[3] = f7;
        this.f38496q.reset();
        this.f38496q.setRotate(getCurrentAngle());
        this.f38496q.mapPoints(fArr2);
        return fArr2;
    }

    private void j() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        k(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void k(float f4, float f5) {
        float min = Math.min(Math.min(this.f38495p.width() / f4, this.f38495p.width() / f5), Math.min(this.f38495p.height() / f5, this.f38495p.height() / f4));
        this.f38503x = min;
        this.f38502w = min * this.f38498s;
    }

    private void o(float f4, float f5) {
        float width = this.f38495p.width();
        float height = this.f38495p.height();
        float max = Math.max(this.f38495p.width() / f4, this.f38495p.height() / f5);
        RectF rectF = this.f38495p;
        float f6 = ((height - (f5 * max)) / 2.0f) + rectF.top;
        this.f38555d.reset();
        this.f38555d.postScale(max, max);
        this.f38555d.postTranslate(((width - (f4 * max)) / 2.0f) + rectF.left, f6);
        setImageMatrix(this.f38555d);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.f38500u);
        removeCallbacks(this.f38501v);
    }

    public void cropAndSaveImage(@NonNull Bitmap.CompressFormat compressFormat, int i4, @Nullable BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.f38495p, RectUtils.trapToRect(this.f38552a), getCurrentScale(), getCurrentAngle()), new CropParameters(this.f38504y, this.f38505z, compressFormat, i4, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void f() {
        int i4;
        int i5;
        int i6;
        super.f();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f38497r == 0.0f) {
            this.f38497r = intrinsicWidth / intrinsicHeight;
        }
        int i7 = this.f38556e;
        float f4 = this.f38497r;
        int i8 = (int) (i7 / f4);
        int i9 = this.f38557f;
        if (i8 > i9) {
            this.f38495p.set((i7 - ((int) (i9 * f4))) / 2, 0.0f, i5 + i6, i9);
        } else {
            this.f38495p.set(0.0f, (i9 - i8) / 2, i7, i8 + i4);
        }
        k(intrinsicWidth, intrinsicHeight);
        o(intrinsicWidth, intrinsicHeight);
        CropBoundsChangeListener cropBoundsChangeListener = this.f38499t;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.f38497r);
        }
        TransformImageView.TransformImageListener transformImageListener = this.f38558g;
        if (transformImageListener != null) {
            transformImageListener.onScale(getCurrentScale());
            this.f38558g.onRotate(getCurrentAngle());
        }
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.f38499t;
    }

    public float getMaxScale() {
        return this.f38502w;
    }

    public float getMinScale() {
        return this.f38503x;
    }

    public float getTargetAspectRatio() {
        return this.f38497r;
    }

    protected boolean l() {
        return m(this.f38552a);
    }

    protected boolean m(float[] fArr) {
        this.f38496q.reset();
        this.f38496q.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.f38496q.mapPoints(copyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.f38495p);
        this.f38496q.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(copyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs != 0.0f && abs2 != 0.0f) {
            this.f38497r = abs / abs2;
        } else {
            this.f38497r = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(float f4, float f5, float f6, long j4) {
        if (f4 > getMaxScale()) {
            f4 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j4, currentScale, f4 - currentScale, f5, f6);
        this.f38501v = bVar;
        post(bVar);
    }

    public void postRotate(float f4) {
        postRotate(f4, this.f38495p.centerX(), this.f38495p.centerY());
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void postScale(float f4, float f5, float f6) {
        if (f4 > 1.0f && getCurrentScale() * f4 <= getMaxScale()) {
            super.postScale(f4, f5, f6);
        } else if (f4 < 1.0f && getCurrentScale() * f4 >= getMinScale()) {
            super.postScale(f4, f5, f6);
        }
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.f38499t = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.f38497r = rectF.width() / rectF.height();
        this.f38495p.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        j();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j4) {
        if (j4 > 0) {
            this.A = j4;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i4) {
        this.f38504y = i4;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i4) {
        this.f38505z = i4;
    }

    public void setMaxScaleMultiplier(float f4) {
        this.f38498s = f4;
    }

    public void setTargetAspectRatio(float f4) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.f38497r = f4;
            return;
        }
        if (f4 == 0.0f) {
            this.f38497r = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.f38497r = f4;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.f38499t;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.f38497r);
        }
    }

    public void zoomInImage(float f4) {
        zoomInImage(f4, this.f38495p.centerX(), this.f38495p.centerY());
    }

    public void zoomOutImage(float f4) {
        zoomOutImage(f4, this.f38495p.centerX(), this.f38495p.centerY());
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setImageToWrapCropBounds(boolean z3) {
        float f4;
        float max;
        float f5;
        if (!this.f38562k || l()) {
            return;
        }
        float[] fArr = this.f38553b;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.f38495p.centerX() - f6;
        float centerY = this.f38495p.centerY() - f7;
        this.f38496q.reset();
        this.f38496q.setTranslate(centerX, centerY);
        float[] fArr2 = this.f38552a;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f38496q.mapPoints(copyOf);
        boolean m4 = m(copyOf);
        if (m4) {
            float[] i4 = i();
            f5 = -(i4[1] + i4[3]);
            f4 = -(i4[0] + i4[2]);
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.f38495p);
            this.f38496q.reset();
            this.f38496q.setRotate(getCurrentAngle());
            this.f38496q.mapRect(rectF);
            float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.f38552a);
            f4 = centerX;
            max = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
            f5 = centerY;
        }
        if (z3) {
            a aVar = new a(this, this.A, f6, f7, f4, f5, currentScale, max, m4);
            this.f38500u = aVar;
            post(aVar);
            return;
        }
        postTranslate(f4, f5);
        if (m4) {
            return;
        }
        zoomInImage(currentScale + max, this.f38495p.centerX(), this.f38495p.centerY());
    }

    public void zoomInImage(float f4, float f5, float f6) {
        if (f4 <= getMaxScale()) {
            postScale(f4 / getCurrentScale(), f5, f6);
        }
    }

    public void zoomOutImage(float f4, float f5, float f6) {
        if (f4 >= getMinScale()) {
            postScale(f4 / getCurrentScale(), f5, f6);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38495p = new RectF();
        this.f38496q = new Matrix();
        this.f38498s = 10.0f;
        this.f38501v = null;
        this.f38504y = 0;
        this.f38505z = 0;
        this.A = 500L;
    }
}
