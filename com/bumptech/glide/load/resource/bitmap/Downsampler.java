package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f17236f;

    /* renamed from: g  reason: collision with root package name */
    private static final DecodeCallbacks f17237g;

    /* renamed from: h  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f17238h;

    /* renamed from: i  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f17239i;

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f17240a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f17241b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f17242c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f17243d;

    /* renamed from: e  reason: collision with root package name */
    private final b f17244e = b.a();

    /* loaded from: classes3.dex */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f17236f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f17237g = new a();
        f17238h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f17239i = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f17243d = list;
        this.f17241b = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.f17240a = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.f17242c = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int a(double d4) {
        int h4 = h(d4);
        int p4 = p(h4 * d4);
        return p((d4 / (p4 / h4)) * p4);
    }

    private void b(InputStream inputStream, DecodeFormat decodeFormat, boolean z3, boolean z4, BitmapFactory.Options options, int i4, int i5) {
        boolean z5;
        Bitmap.Config config;
        if (this.f17244e.c(i4, i5, options, decodeFormat, z3, z4)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            try {
                z5 = ImageHeaderParserUtils.getType(this.f17243d, inputStream, this.f17242c).hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable("Downsampler", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header, format ");
                    sb.append(decodeFormat);
                }
                z5 = false;
            }
            if (z5) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i4, int i5, int i6, int i7, int i8, BitmapFactory.Options options) throws IOException {
        float scaleFactor;
        int min;
        int i9;
        int floor;
        double floor2;
        int i10;
        if (i5 > 0 && i6 > 0) {
            if (i4 != 90 && i4 != 270) {
                scaleFactor = downsampleStrategy.getScaleFactor(i5, i6, i7, i8);
            } else {
                scaleFactor = downsampleStrategy.getScaleFactor(i6, i5, i7, i8);
            }
            if (scaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i5, i6, i7, i8);
                if (sampleSizeRounding != null) {
                    float f4 = i5;
                    float f5 = i6;
                    int p4 = i5 / p(scaleFactor * f4);
                    int p5 = i6 / p(scaleFactor * f5);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (sampleSizeRounding == sampleSizeRounding2) {
                        min = Math.max(p4, p5);
                    } else {
                        min = Math.min(p4, p5);
                    }
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 <= 23 && f17236f.contains(options.outMimeType)) {
                        i9 = 1;
                    } else {
                        int max = Math.max(1, Integer.highestOneBit(min));
                        if (sampleSizeRounding == sampleSizeRounding2 && max < 1.0f / scaleFactor) {
                            i9 = max << 1;
                        } else {
                            i9 = max;
                        }
                    }
                    options.inSampleSize = i9;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(i9, 8);
                        floor = (int) Math.ceil(f4 / min2);
                        i10 = (int) Math.ceil(f5 / min2);
                        int i12 = i9 / 8;
                        if (i12 > 0) {
                            floor /= i12;
                            i10 /= i12;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                                if (i5 % i9 == 0 && i6 % i9 == 0) {
                                    floor = i5 / i9;
                                    i10 = i6 / i9;
                                } else {
                                    int[] i13 = i(inputStream, options, decodeCallbacks, bitmapPool);
                                    floor = i13[0];
                                    i10 = i13[1];
                                }
                            } else if (i11 >= 24) {
                                float f6 = i9;
                                floor = Math.round(f4 / f6);
                                i10 = Math.round(f5 / f6);
                            } else {
                                float f7 = i9;
                                floor = (int) Math.floor(f4 / f7);
                                floor2 = Math.floor(f5 / f7);
                            }
                        } else {
                            float f8 = i9;
                            floor = (int) Math.floor(f4 / f8);
                            floor2 = Math.floor(f5 / f8);
                        }
                        i10 = (int) floor2;
                    }
                    double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, i10, i7, i8);
                    options.inTargetDensity = a(scaleFactor2);
                    options.inDensity = h(scaleFactor2);
                    if (k(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Calculate scaling, source: [");
                        sb.append(i5);
                        sb.append("x");
                        sb.append(i6);
                        sb.append("], target: [");
                        sb.append(i7);
                        sb.append("x");
                        sb.append(i8);
                        sb.append("], power of two scaled: [");
                        sb.append(floor);
                        sb.append("x");
                        sb.append(i10);
                        sb.append("], exact scale factor: ");
                        sb.append(scaleFactor);
                        sb.append(", power of 2 sample size: ");
                        sb.append(i9);
                        sb.append(", adjusted scale factor: ");
                        sb.append(scaleFactor2);
                        sb.append(", target density: ");
                        sb.append(options.inTargetDensity);
                        sb.append(", density: ");
                        sb.append(options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i5 + "x" + i6 + "], target: [" + i7 + "x" + i8 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to determine dimensions for: ");
            sb2.append(imageType);
            sb2.append(" with target [");
            sb2.append(i7);
            sb2.append("x");
            sb2.append(i8);
            sb2.append("]");
        }
    }

    private Bitmap d(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z3, int i4, int i5, boolean z4, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z5;
        int i6;
        int i7;
        int i8;
        float f4;
        int round;
        int round2;
        long logTime = LogTime.getLogTime();
        int[] i9 = i(inputStream, options, decodeCallbacks, this.f17240a);
        int i10 = i9[0];
        int i11 = i9[1];
        String str = options.outMimeType;
        if (i10 != -1 && i11 != -1) {
            z5 = z3;
        } else {
            z5 = false;
        }
        int orientation = ImageHeaderParserUtils.getOrientation(this.f17243d, inputStream, this.f17242c);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        if (i4 == Integer.MIN_VALUE) {
            i6 = i10;
        } else {
            i6 = i4;
        }
        if (i5 == Integer.MIN_VALUE) {
            i7 = i11;
        } else {
            i7 = i5;
        }
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.f17243d, inputStream, this.f17242c);
        c(type, inputStream, decodeCallbacks, this.f17240a, downsampleStrategy, exifOrientationDegrees, i10, i11, i6, i7, options);
        b(inputStream, decodeFormat, z5, isExifOrientationRequired, options, i6, i7);
        int i12 = options.inSampleSize;
        if (r(type)) {
            if (i10 >= 0 && i11 >= 0 && z4) {
                round = i6;
                round2 = i7;
            } else {
                if (k(options)) {
                    f4 = options.inTargetDensity / options.inDensity;
                } else {
                    f4 = 1.0f;
                }
                int i13 = options.inSampleSize;
                float f5 = i13;
                round = Math.round(((int) Math.ceil(i10 / f5)) * f4);
                round2 = Math.round(((int) Math.ceil(i11 / f5)) * f4);
                if (Log.isLoggable("Downsampler", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(round);
                    sb.append("x");
                    sb.append(round2);
                    sb.append("] for source [");
                    sb.append(i10);
                    sb.append("x");
                    sb.append(i11);
                    sb.append("], sampleSize: ");
                    sb.append(i13);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f4);
                }
            }
            if (round > 0 && round2 > 0) {
                q(options, this.f17240a, round, round2);
            }
        }
        Bitmap e4 = e(inputStream, options, decodeCallbacks, this.f17240a);
        decodeCallbacks.onDecodeComplete(this.f17240a, e4);
        if (Log.isLoggable("Downsampler", 2)) {
            i8 = orientation;
            l(i10, i11, str, options, e4, i4, i5, logTime);
        } else {
            i8 = orientation;
        }
        if (e4 != null) {
            e4.setDensity(this.f17241b.densityDpi);
            Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.f17240a, e4, i8);
            if (!e4.equals(rotateImageExif)) {
                this.f17240a.put(e4);
                return rotateImageExif;
            }
            return rotateImageExif;
        }
        return null;
    }

    private static Bitmap e(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(MediaHttpUploader.DEFAULT_CHUNK_SIZE);
        } else {
            decodeCallbacks.onObtainBounds();
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                TransformationUtils.getBitmapDrawableLock().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e4) {
                IOException m4 = m(e4, i4, i5, str, options);
                Log.isLoggable("Downsampler", 3);
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        bitmapPool.put(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap e5 = e(inputStream, options, decodeCallbacks, bitmapPool);
                        TransformationUtils.getBitmapDrawableLock().unlock();
                        return e5;
                    } catch (IOException unused) {
                        throw m4;
                    }
                }
                throw m4;
            }
        } catch (Throwable th) {
            TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String f(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options g() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = f17239i;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                o(poll);
            }
        }
        return poll;
    }

    private static int h(double d4) {
        if (d4 > 1.0d) {
            d4 = 1.0d / d4;
        }
        return (int) Math.round(d4 * 2.147483647E9d);
    }

    private static int[] i(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        e(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String j(BitmapFactory.Options options) {
        return f(options.inBitmap);
    }

    private static boolean k(BitmapFactory.Options options) {
        int i4;
        int i5 = options.inTargetDensity;
        if (i5 > 0 && (i4 = options.inDensity) > 0 && i5 != i4) {
            return true;
        }
        return false;
    }

    private static void l(int i4, int i5, String str, BitmapFactory.Options options, Bitmap bitmap, int i6, int i7, long j4) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoded ");
        sb.append(f(bitmap));
        sb.append(" from [");
        sb.append(i4);
        sb.append("x");
        sb.append(i5);
        sb.append("] ");
        sb.append(str);
        sb.append(" with inBitmap ");
        sb.append(j(options));
        sb.append(" for [");
        sb.append(i6);
        sb.append("x");
        sb.append(i7);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(LogTime.getElapsedMillis(j4));
    }

    private static IOException m(IllegalArgumentException illegalArgumentException, int i4, int i5, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i4 + ", outHeight: " + i5 + ", outMimeType: " + str + ", inBitmap: " + j(options), illegalArgumentException);
    }

    private static void n(BitmapFactory.Options options) {
        o(options);
        Queue<BitmapFactory.Options> queue = f17239i;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void o(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int p(double d4) {
        return (int) (d4 + 0.5d);
    }

    @TargetApi(26)
    private static void q(BitmapFactory.Options options, BitmapPool bitmapPool, int i4, int i5) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config3 = options.inPreferredConfig;
            config2 = Bitmap.Config.HARDWARE;
            if (config3 != config2) {
                config = options.outConfig;
            } else {
                return;
            }
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i4, i5, config);
    }

    private boolean r(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i4, int i5, Options options) throws IOException {
        return decode(inputStream, i4, i5, options, f17237g);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i4, int i5, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f17242c.get(65536, byte[].class);
        BitmapFactory.Options g4 = g();
        g4.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(d(inputStream, g4, downsampleStrategy, decodeFormat, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i4, i5, booleanValue, decodeCallbacks), this.f17240a);
        } finally {
            n(g4);
            this.f17242c.put(bArr);
        }
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    /* loaded from: classes3.dex */
    class a implements DecodeCallbacks {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }
    }
}
