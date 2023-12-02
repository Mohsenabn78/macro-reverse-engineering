package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: classes2.dex */
public final class Utils {
    public static final int SECOND_IN_NANOS = 1000000000;

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f1867a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Path> f1868b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Path> f1869c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<float[]> f1870d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final float f1871e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: f  reason: collision with root package name */
    private static float f1872f = -1.0f;

    /* loaded from: classes2.dex */
    class a extends ThreadLocal<PathMeasure> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* loaded from: classes2.dex */
    class b extends ThreadLocal<Path> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: classes2.dex */
    class c extends ThreadLocal<Path> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: classes2.dex */
    class d extends ThreadLocal<float[]> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public float[] initialValue() {
            return new float[4];
        }
    }

    private Utils() {
    }

    public static void applyTrimPathIfNeeded(Path path, @Nullable TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((FloatKeyframeAnimation) trimPathContent.getStart()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getEnd()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getOffset()).getFloatValue() / 360.0f);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f4 = pointF.x;
            float f5 = pointF2.x;
            float f6 = pointF2.y;
            path.cubicTo(pointF3.x + f4, pointF.y + pointF3.y, f5 + pointF4.x, f6 + pointF4.y, f5, f6);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float dpScale() {
        if (f1872f == -1.0f) {
            f1872f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f1872f;
    }

    public static float getAnimationScale(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = f1870d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f4 = f1871e;
        fArr[2] = f4;
        fArr[3] = f4;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float[] fArr = f1870d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static int hashFor(float f4, float f5, float f6, float f7) {
        int i4;
        if (f4 != 0.0f) {
            i4 = (int) (527 * f4);
        } else {
            i4 = 17;
        }
        if (f5 != 0.0f) {
            i4 = (int) (i4 * 31 * f5);
        }
        if (f6 != 0.0f) {
            i4 = (int) (i4 * 31 * f6);
        }
        if (f7 != 0.0f) {
            return (int) (i4 * 31 * f7);
        }
        return i4;
    }

    public static boolean isAtLeastVersion(int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 < i7) {
            return false;
        }
        if (i4 > i7) {
            return true;
        }
        if (i5 < i8) {
            return false;
        }
        if (i5 <= i8 && i6 < i9) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkException(Throwable th) {
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static Bitmap renderPath(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        LPaint lPaint = new LPaint();
        lPaint.setAntiAlias(true);
        lPaint.setColor(-16776961);
        canvas.drawPath(path, lPaint);
        return createBitmap;
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i4, int i5) {
        if (bitmap.getWidth() == i4 && bitmap.getHeight() == i5) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i4, i5, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int i4) {
        L.beginSection("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i4);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.endSection("Utils#saveLayer");
    }

    public static void applyTrimPathIfNeeded(Path path, float f4, float f5, float f6) {
        L.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f1867a.get();
        Path path2 = f1868b.get();
        Path path3 = f1869c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f4 == 1.0f && f5 == 0.0f) {
            L.endSection("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f5 - f4) - 1.0f) >= 0.01d) {
            float f7 = f4 * length;
            float f8 = f5 * length;
            float f9 = f6 * length;
            float min = Math.min(f7, f8) + f9;
            float max = Math.max(f7, f8) + f9;
            if (min >= length && max >= length) {
                min = MiscUtils.b(min, length);
                max = MiscUtils.b(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.b(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.b(max, length);
            }
            int i4 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i4 == 0) {
                path.reset();
                L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (i4 >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.endSection("applyTrimPathIfNeeded");
        } else {
            L.endSection("applyTrimPathIfNeeded");
        }
    }
}
