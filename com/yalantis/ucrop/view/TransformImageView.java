package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;

/* loaded from: classes6.dex */
public class TransformImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    protected final float[] f38552a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f38553b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f38554c;

    /* renamed from: d  reason: collision with root package name */
    protected Matrix f38555d;

    /* renamed from: e  reason: collision with root package name */
    protected int f38556e;

    /* renamed from: f  reason: collision with root package name */
    protected int f38557f;

    /* renamed from: g  reason: collision with root package name */
    protected TransformImageListener f38558g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f38559h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f38560i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f38561j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f38562k;

    /* renamed from: l  reason: collision with root package name */
    private int f38563l;

    /* renamed from: m  reason: collision with root package name */
    private String f38564m;

    /* renamed from: n  reason: collision with root package name */
    private String f38565n;

    /* renamed from: o  reason: collision with root package name */
    private ExifInfo f38566o;

    /* loaded from: classes6.dex */
    public interface TransformImageListener {
        void onLoadComplete();

        void onLoadFailure(@NonNull Exception exc);

        void onRotate(float f4);

        void onScale(float f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements BitmapLoadCallback {
        a() {
        }

        @Override // com.yalantis.ucrop.callback.BitmapLoadCallback
        public void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String str, @Nullable String str2) {
            TransformImageView.this.f38564m = str;
            TransformImageView.this.f38565n = str2;
            TransformImageView.this.f38566o = exifInfo;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.f38561j = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // com.yalantis.ucrop.callback.BitmapLoadCallback
        public void onFailure(@NonNull Exception exc) {
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            TransformImageListener transformImageListener = TransformImageView.this.f38558g;
            if (transformImageListener != null) {
                transformImageListener.onLoadFailure(exc);
            }
        }
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    private void g() {
        this.f38555d.mapPoints(this.f38552a, this.f38559h);
        this.f38555d.mapPoints(this.f38553b, this.f38560i);
    }

    protected float d(@NonNull Matrix matrix, @IntRange(from = 0, to = 9) int i4) {
        matrix.getValues(this.f38554c);
        return this.f38554c[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f38559h = RectUtils.getCornersFromRect(rectF);
        this.f38560i = RectUtils.getCenterFromRect(rectF);
        this.f38562k = true;
        TransformImageListener transformImageListener = this.f38558g;
        if (transformImageListener != null) {
            transformImageListener.onLoadComplete();
        }
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.f38555d);
    }

    public float getCurrentScale() {
        return getMatrixScale(this.f38555d);
    }

    public ExifInfo getExifInfo() {
        return this.f38566o;
    }

    public String getImageInputPath() {
        return this.f38564m;
    }

    public String getImageOutputPath() {
        return this.f38565n;
    }

    public float getMatrixAngle(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2(d(matrix, 1), d(matrix, 0)) * 57.29577951308232d));
    }

    public float getMatrixScale(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow(d(matrix, 0), 2.0d) + Math.pow(d(matrix, 3), 2.0d));
    }

    public int getMaxBitmapSize() {
        if (this.f38563l <= 0) {
            this.f38563l = BitmapLoadUtils.calculateMaxBitmapSize(getContext());
        }
        return this.f38563l;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() != null && (getDrawable() instanceof FastBitmapDrawable)) {
            return ((FastBitmapDrawable) getDrawable()).getBitmap();
        }
        return null;
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3 || (this.f38561j && !this.f38562k)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f38556e = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f38557f = (getHeight() - getPaddingBottom()) - paddingTop;
            f();
        }
    }

    public void postRotate(float f4, float f5, float f6) {
        if (f4 != 0.0f) {
            this.f38555d.postRotate(f4, f5, f6);
            setImageMatrix(this.f38555d);
            TransformImageListener transformImageListener = this.f38558g;
            if (transformImageListener != null) {
                transformImageListener.onRotate(getMatrixAngle(this.f38555d));
            }
        }
    }

    public void postScale(float f4, float f5, float f6) {
        if (f4 != 0.0f) {
            this.f38555d.postScale(f4, f4, f5, f6);
            setImageMatrix(this.f38555d);
            TransformImageListener transformImageListener = this.f38558g;
            if (transformImageListener != null) {
                transformImageListener.onScale(getMatrixScale(this.f38555d));
            }
        }
    }

    public void postTranslate(float f4, float f5) {
        if (f4 != 0.0f || f5 != 0.0f) {
            this.f38555d.postTranslate(f4, f5);
            setImageMatrix(this.f38555d);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f38555d.set(matrix);
        g();
    }

    public void setImageUri(@NonNull Uri uri, @Nullable Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    public void setMaxBitmapSize(int i4) {
        this.f38563l = i4;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.f38558g = transformImageListener;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38552a = new float[8];
        this.f38553b = new float[2];
        this.f38554c = new float[9];
        this.f38555d = new Matrix();
        this.f38561j = false;
        this.f38562k = false;
        this.f38563l = 0;
        e();
    }
}
