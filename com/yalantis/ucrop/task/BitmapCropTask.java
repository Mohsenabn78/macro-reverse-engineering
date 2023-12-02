package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38448a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f38449b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f38450c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f38451d;

    /* renamed from: e  reason: collision with root package name */
    private float f38452e;

    /* renamed from: f  reason: collision with root package name */
    private float f38453f;

    /* renamed from: g  reason: collision with root package name */
    private final int f38454g;

    /* renamed from: h  reason: collision with root package name */
    private final int f38455h;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap.CompressFormat f38456i;

    /* renamed from: j  reason: collision with root package name */
    private final int f38457j;

    /* renamed from: k  reason: collision with root package name */
    private final String f38458k;

    /* renamed from: l  reason: collision with root package name */
    private final String f38459l;

    /* renamed from: m  reason: collision with root package name */
    private final ExifInfo f38460m;

    /* renamed from: n  reason: collision with root package name */
    private final BitmapCropCallback f38461n;

    /* renamed from: o  reason: collision with root package name */
    private int f38462o;

    /* renamed from: p  reason: collision with root package name */
    private int f38463p;

    /* renamed from: q  reason: collision with root package name */
    private int f38464q;

    /* renamed from: r  reason: collision with root package name */
    private int f38465r;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.f38448a = new WeakReference<>(context);
        this.f38449b = bitmap;
        this.f38450c = imageState.getCropRect();
        this.f38451d = imageState.getCurrentImageRect();
        this.f38452e = imageState.getCurrentScale();
        this.f38453f = imageState.getCurrentAngle();
        this.f38454g = cropParameters.getMaxResultImageSizeX();
        this.f38455h = cropParameters.getMaxResultImageSizeY();
        this.f38456i = cropParameters.getCompressFormat();
        this.f38457j = cropParameters.getCompressQuality();
        this.f38458k = cropParameters.getImageInputPath();
        this.f38459l = cropParameters.getImageOutputPath();
        this.f38460m = cropParameters.getExifInfo();
        this.f38461n = bitmapCropCallback;
    }

    private boolean a() throws IOException {
        Bitmap bitmap;
        if (this.f38454g > 0 && this.f38455h > 0) {
            float width = this.f38450c.width() / this.f38452e;
            float height = this.f38450c.height() / this.f38452e;
            int i4 = this.f38454g;
            if (width > i4 || height > this.f38455h) {
                float min = Math.min(i4 / width, this.f38455h / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f38449b, Math.round(bitmap.getWidth() * min), Math.round(this.f38449b.getHeight() * min), false);
                Bitmap bitmap2 = this.f38449b;
                if (bitmap2 != createScaledBitmap) {
                    bitmap2.recycle();
                }
                this.f38449b = createScaledBitmap;
                this.f38452e /= min;
            }
        }
        if (this.f38453f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f38453f, this.f38449b.getWidth() / 2, this.f38449b.getHeight() / 2);
            Bitmap bitmap3 = this.f38449b;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f38449b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.f38449b;
            if (bitmap4 != createBitmap) {
                bitmap4.recycle();
            }
            this.f38449b = createBitmap;
        }
        this.f38464q = Math.round((this.f38450c.left - this.f38451d.left) / this.f38452e);
        this.f38465r = Math.round((this.f38450c.top - this.f38451d.top) / this.f38452e);
        this.f38462o = Math.round(this.f38450c.width() / this.f38452e);
        int round = Math.round(this.f38450c.height() / this.f38452e);
        this.f38463p = round;
        boolean e4 = e(this.f38462o, round);
        Log.i("BitmapCropTask", "Should crop: " + e4);
        if (e4) {
            ExifInterface exifInterface = new ExifInterface(this.f38458k);
            d(Bitmap.createBitmap(this.f38449b, this.f38464q, this.f38465r, this.f38462o, this.f38463p));
            if (this.f38456i.equals(Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.copyExif(exifInterface, this.f38462o, this.f38463p, this.f38459l);
                return true;
            }
            return true;
        }
        FileUtils.copyFile(this.f38458k, this.f38459l);
        return false;
    }

    private void d(@NonNull Bitmap bitmap) throws FileNotFoundException {
        Context context = this.f38448a.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.f38459l)));
            bitmap.compress(this.f38456i, this.f38457j, outputStream);
            bitmap.recycle();
        } finally {
            BitmapLoadUtils.close(outputStream);
        }
    }

    private boolean e(int i4, int i5) {
        int round = Math.round(Math.max(i4, i5) / 1000.0f) + 1;
        if (this.f38454g > 0 && this.f38455h > 0) {
            return true;
        }
        float f4 = round;
        if (Math.abs(this.f38450c.left - this.f38451d.left) > f4 || Math.abs(this.f38450c.top - this.f38451d.top) > f4 || Math.abs(this.f38450c.bottom - this.f38451d.bottom) > f4 || Math.abs(this.f38450c.right - this.f38451d.right) > f4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    /* renamed from: b */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f38449b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f38451d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.f38449b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(@Nullable Throwable th) {
        BitmapCropCallback bitmapCropCallback = this.f38461n;
        if (bitmapCropCallback != null) {
            if (th == null) {
                this.f38461n.onBitmapCropped(Uri.fromFile(new File(this.f38459l)), this.f38464q, this.f38465r, this.f38462o, this.f38463p);
                return;
            }
            bitmapCropCallback.onCropFailure(th);
        }
    }
}
