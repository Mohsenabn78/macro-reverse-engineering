package com.koushikdutta.ion.bitmap;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.ion.Ion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class IonBitmapCache {
    public static final long DEFAULT_ERROR_CACHE_DURATION = 30000;

    /* renamed from: a  reason: collision with root package name */
    Resources f35806a;

    /* renamed from: b  reason: collision with root package name */
    DisplayMetrics f35807b;

    /* renamed from: c  reason: collision with root package name */
    a f35808c;

    /* renamed from: d  reason: collision with root package name */
    Ion f35809d;

    /* renamed from: e  reason: collision with root package name */
    long f35810e = 30000;

    /* renamed from: f  reason: collision with root package name */
    double f35811f = 0.14285714285714285d;

    public IonBitmapCache(Ion ion) {
        Context applicationContext = ion.getContext().getApplicationContext();
        this.f35809d = ion;
        this.f35807b = new DisplayMetrics();
        ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.f35807b);
        this.f35806a = new Resources(applicationContext.getAssets(), this.f35807b, applicationContext.getResources().getConfiguration());
        this.f35808c = new a(b(applicationContext) / 7);
    }

    private Point a(int i4, int i5) {
        if (i4 == 0) {
            i4 = this.f35807b.widthPixels;
        }
        int i6 = Integer.MAX_VALUE;
        if (i4 <= 0) {
            i4 = Integer.MAX_VALUE;
        }
        if (i5 == 0) {
            i5 = this.f35807b.heightPixels;
        }
        if (i5 > 0) {
            i6 = i5;
        }
        return new Point(i4, i6);
    }

    private static int b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1024 * 1024;
    }

    private static Bitmap c(Bitmap bitmap, int i4) {
        if (bitmap == null) {
            return null;
        }
        if (i4 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i4);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private BitmapFactory.Options d(BitmapFactory.Options options, int i4, int i5) throws BitmapDecodeException {
        if (options.outWidth >= 0 && options.outHeight >= 0) {
            Point a4 = a(i4, i5);
            int round = Math.round(Math.max(options.outWidth / a4.x, options.outHeight / a4.y));
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = round;
            options2.outWidth = options.outWidth;
            options2.outHeight = options.outHeight;
            options2.outMimeType = options.outMimeType;
            return options2;
        }
        throw new BitmapDecodeException(options.outWidth, options.outHeight);
    }

    public static Bitmap loadBitmap(byte[] bArr, int i4, int i5, BitmapFactory.Options options) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i4, i5, options);
        if (decodeByteArray == null) {
            return null;
        }
        return c(decodeByteArray, Exif.getOrientation(bArr, i4, i5));
    }

    @TargetApi(10)
    public static Bitmap loadRegion(BitmapRegionDecoder bitmapRegionDecoder, Rect rect, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i4;
        return bitmapRegionDecoder.decodeRegion(rect, options);
    }

    public void clear() {
        this.f35808c.g();
    }

    public void dump() {
        Log.i("IonBitmapCache", "bitmap cache: " + this.f35808c.size());
        Log.i("IonBitmapCache", "freeMemory: " + Runtime.getRuntime().freeMemory());
    }

    public BitmapInfo get(String str) {
        BitmapInfo h4;
        if (str == null || (h4 = this.f35808c.h(str)) == null) {
            return null;
        }
        Bitmap bitmap = h4.bitmap;
        if (bitmap != null && bitmap.isRecycled()) {
            Log.w("ION", "Cached bitmap was recycled.");
            Log.w("ION", "This may happen if passing Ion bitmaps directly to notification builders or remote media clients.");
            Log.w("ION", "Create a deep copy before doing this.");
            this.f35808c.remove(str);
            return null;
        } else if (h4.exception == null) {
            return h4;
        } else {
            if (h4.loadTime + this.f35810e > System.currentTimeMillis()) {
                return h4;
            }
            this.f35808c.remove(str);
            return null;
        }
    }

    public long getErrorCacheDuration() {
        return this.f35810e;
    }

    public double getHeapRatio() {
        return this.f35811f;
    }

    public BitmapFactory.Options prepareBitmapOptions(File file, int i4, int i5) throws BitmapDecodeException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.toString(), options);
        return d(options, i4, i5);
    }

    public void put(BitmapInfo bitmapInfo) {
        long b4 = (int) (b(this.f35809d.getContext()) * this.f35811f);
        if (b4 != this.f35808c.maxSize()) {
            this.f35808c.setMaxSize(b4);
        }
        this.f35808c.put(bitmapInfo.key, bitmapInfo);
    }

    public void putSoft(BitmapInfo bitmapInfo) {
        this.f35808c.i(bitmapInfo.key, bitmapInfo);
    }

    public BitmapInfo remove(String str) {
        return this.f35808c.j(str);
    }

    public void setErrorCacheDuration(long j4) {
        this.f35810e = j4;
    }

    public void setHeapRatio(double d4) {
        this.f35811f = d4;
    }

    public static Bitmap loadBitmap(Resources resources, int i4, BitmapFactory.Options options) {
        InputStream inputStream;
        int i5;
        try {
            inputStream = resources.openRawResource(i4);
        } catch (Exception unused) {
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[50000];
            i5 = Exif.getOrientation(bArr, 0, inputStream.read(bArr));
        } catch (Exception unused2) {
            i5 = 0;
            StreamUtility.closeQuietly(inputStream);
            return c(BitmapFactory.decodeResource(resources, i4, options), i5);
        }
        StreamUtility.closeQuietly(inputStream);
        return c(BitmapFactory.decodeResource(resources, i4, options), i5);
    }

    public BitmapFactory.Options prepareBitmapOptions(byte[] bArr, int i4, int i5, int i6, int i7) throws BitmapDecodeException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i4, i5, options);
        return d(options, i6, i7);
    }

    public BitmapFactory.Options prepareBitmapOptions(Resources resources, int i4, int i5, int i6) throws BitmapDecodeException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i4, options);
        return d(options, i5, i6);
    }

    public static Bitmap loadBitmap(InputStream inputStream, BitmapFactory.Options options) throws IOException {
        b bVar = new b(inputStream);
        bVar.mark(50000);
        int i4 = 0;
        try {
            byte[] bArr = new byte[50000];
            i4 = Exif.getOrientation(bArr, 0, bVar.read(bArr));
        } catch (Exception unused) {
        }
        bVar.reset();
        return c(BitmapFactory.decodeStream(bVar, null, options), i4);
    }

    public BitmapFactory.Options prepareBitmapOptions(InputStream inputStream, int i4, int i5) throws BitmapDecodeException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return d(options, i4, i5);
    }

    public static Bitmap loadBitmap(File file, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        int i4;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[50000];
                i4 = Exif.getOrientation(bArr, 0, fileInputStream.read(bArr));
            } catch (Exception unused) {
                fileInputStream2 = fileInputStream;
                fileInputStream = fileInputStream2;
                i4 = 0;
                StreamUtility.closeQuietly(fileInputStream);
                return c(BitmapFactory.decodeFile(file.toString(), options), i4);
            }
        } catch (Exception unused2) {
        }
        StreamUtility.closeQuietly(fileInputStream);
        return c(BitmapFactory.decodeFile(file.toString(), options), i4);
    }
}
