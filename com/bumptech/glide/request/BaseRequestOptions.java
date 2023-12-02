package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f17400a;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Drawable f17404e;

    /* renamed from: f  reason: collision with root package name */
    private int f17405f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f17406g;

    /* renamed from: h  reason: collision with root package name */
    private int f17407h;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17412m;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Drawable f17414o;

    /* renamed from: p  reason: collision with root package name */
    private int f17415p;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17419t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private Resources.Theme f17420u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f17421v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f17422w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f17423x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f17425z;

    /* renamed from: b  reason: collision with root package name */
    private float f17401b = 1.0f;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private DiskCacheStrategy f17402c = DiskCacheStrategy.AUTOMATIC;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private Priority f17403d = Priority.NORMAL;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17408i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f17409j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f17410k = -1;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private Key f17411l = EmptySignature.obtain();

    /* renamed from: n  reason: collision with root package name */
    private boolean f17413n = true;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private Options f17416q = new Options();
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f17417r = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private Class<?> f17418s = Object.class;

    /* renamed from: y  reason: collision with root package name */
    private boolean f17424y = true;

    private boolean b(int i4) {
        return c(this.f17400a, i4);
    }

    private static boolean c(int i4, int i5) {
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    private T d(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return g(downsampleStrategy, transformation, false);
    }

    @NonNull
    private T f(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return g(downsampleStrategy, transformation, true);
    }

    @NonNull
    private T g(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z3) {
        T e4;
        if (z3) {
            e4 = k(downsampleStrategy, transformation);
        } else {
            e4 = e(downsampleStrategy, transformation);
        }
        e4.f17424y = true;
        return e4;
    }

    @NonNull
    private T i() {
        if (!this.f17419t) {
            return h();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f17424y;
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.f17421v) {
            return (T) mo4145clone().apply(baseRequestOptions);
        }
        if (c(baseRequestOptions.f17400a, 2)) {
            this.f17401b = baseRequestOptions.f17401b;
        }
        if (c(baseRequestOptions.f17400a, 262144)) {
            this.f17422w = baseRequestOptions.f17422w;
        }
        if (c(baseRequestOptions.f17400a, 1048576)) {
            this.f17425z = baseRequestOptions.f17425z;
        }
        if (c(baseRequestOptions.f17400a, 4)) {
            this.f17402c = baseRequestOptions.f17402c;
        }
        if (c(baseRequestOptions.f17400a, 8)) {
            this.f17403d = baseRequestOptions.f17403d;
        }
        if (c(baseRequestOptions.f17400a, 16)) {
            this.f17404e = baseRequestOptions.f17404e;
            this.f17405f = 0;
            this.f17400a &= -33;
        }
        if (c(baseRequestOptions.f17400a, 32)) {
            this.f17405f = baseRequestOptions.f17405f;
            this.f17404e = null;
            this.f17400a &= -17;
        }
        if (c(baseRequestOptions.f17400a, 64)) {
            this.f17406g = baseRequestOptions.f17406g;
            this.f17407h = 0;
            this.f17400a &= -129;
        }
        if (c(baseRequestOptions.f17400a, 128)) {
            this.f17407h = baseRequestOptions.f17407h;
            this.f17406g = null;
            this.f17400a &= -65;
        }
        if (c(baseRequestOptions.f17400a, 256)) {
            this.f17408i = baseRequestOptions.f17408i;
        }
        if (c(baseRequestOptions.f17400a, 512)) {
            this.f17410k = baseRequestOptions.f17410k;
            this.f17409j = baseRequestOptions.f17409j;
        }
        if (c(baseRequestOptions.f17400a, 1024)) {
            this.f17411l = baseRequestOptions.f17411l;
        }
        if (c(baseRequestOptions.f17400a, 4096)) {
            this.f17418s = baseRequestOptions.f17418s;
        }
        if (c(baseRequestOptions.f17400a, 8192)) {
            this.f17414o = baseRequestOptions.f17414o;
            this.f17415p = 0;
            this.f17400a &= -16385;
        }
        if (c(baseRequestOptions.f17400a, 16384)) {
            this.f17415p = baseRequestOptions.f17415p;
            this.f17414o = null;
            this.f17400a &= -8193;
        }
        if (c(baseRequestOptions.f17400a, 32768)) {
            this.f17420u = baseRequestOptions.f17420u;
        }
        if (c(baseRequestOptions.f17400a, 65536)) {
            this.f17413n = baseRequestOptions.f17413n;
        }
        if (c(baseRequestOptions.f17400a, 131072)) {
            this.f17412m = baseRequestOptions.f17412m;
        }
        if (c(baseRequestOptions.f17400a, 2048)) {
            this.f17417r.putAll(baseRequestOptions.f17417r);
            this.f17424y = baseRequestOptions.f17424y;
        }
        if (c(baseRequestOptions.f17400a, 524288)) {
            this.f17423x = baseRequestOptions.f17423x;
        }
        if (!this.f17413n) {
            this.f17417r.clear();
            this.f17412m = false;
            this.f17400a = this.f17400a & (-2049) & (-131073);
            this.f17424y = true;
        }
        this.f17400a |= baseRequestOptions.f17400a;
        this.f17416q.putAll(baseRequestOptions.f17416q);
        return i();
    }

    @NonNull
    public T autoClone() {
        if (this.f17419t && !this.f17421v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f17421v = true;
        return lock();
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        return k(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        return f(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        return k(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> cls) {
        if (this.f17421v) {
            return (T) mo4145clone().decode(cls);
        }
        this.f17418s = (Class) Preconditions.checkNotNull(cls);
        this.f17400a |= 4096;
        return i();
    }

    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.f17421v) {
            return (T) mo4145clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.f17402c = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.f17400a |= 4;
        return i();
    }

    @NonNull
    @CheckResult
    public T dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        if (this.f17421v) {
            return (T) mo4145clone().dontTransform();
        }
        this.f17417r.clear();
        this.f17412m = false;
        this.f17413n = false;
        this.f17400a = (this.f17400a & (-2049) & (-131073)) | 65536;
        this.f17424y = true;
        return i();
    }

    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    @NonNull
    final T e(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f17421v) {
            return (T) mo4145clone().e(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return j(transformation, false);
    }

    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, to = 100) int i4) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i4));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f17401b, this.f17401b) != 0 || this.f17405f != baseRequestOptions.f17405f || !Util.bothNullOrEqual(this.f17404e, baseRequestOptions.f17404e) || this.f17407h != baseRequestOptions.f17407h || !Util.bothNullOrEqual(this.f17406g, baseRequestOptions.f17406g) || this.f17415p != baseRequestOptions.f17415p || !Util.bothNullOrEqual(this.f17414o, baseRequestOptions.f17414o) || this.f17408i != baseRequestOptions.f17408i || this.f17409j != baseRequestOptions.f17409j || this.f17410k != baseRequestOptions.f17410k || this.f17412m != baseRequestOptions.f17412m || this.f17413n != baseRequestOptions.f17413n || this.f17422w != baseRequestOptions.f17422w || this.f17423x != baseRequestOptions.f17423x || !this.f17402c.equals(baseRequestOptions.f17402c) || this.f17403d != baseRequestOptions.f17403d || !this.f17416q.equals(baseRequestOptions.f17416q) || !this.f17417r.equals(baseRequestOptions.f17417r) || !this.f17418s.equals(baseRequestOptions.f17418s) || !Util.bothNullOrEqual(this.f17411l, baseRequestOptions.f17411l) || !Util.bothNullOrEqual(this.f17420u, baseRequestOptions.f17420u)) {
            return false;
        }
        return true;
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable drawable) {
        if (this.f17421v) {
            return (T) mo4145clone().error(drawable);
        }
        this.f17404e = drawable;
        this.f17405f = 0;
        this.f17400a = (this.f17400a | 16) & (-33);
        return i();
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable drawable) {
        if (this.f17421v) {
            return (T) mo4145clone().fallback(drawable);
        }
        this.f17414o = drawable;
        this.f17415p = 0;
        this.f17400a = (this.f17400a | 8192) & (-16385);
        return i();
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        return f(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return (T) set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long j4) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j4));
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.f17402c;
    }

    public final int getErrorId() {
        return this.f17405f;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.f17404e;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.f17414o;
    }

    public final int getFallbackId() {
        return this.f17415p;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.f17423x;
    }

    @NonNull
    public final Options getOptions() {
        return this.f17416q;
    }

    public final int getOverrideHeight() {
        return this.f17409j;
    }

    public final int getOverrideWidth() {
        return this.f17410k;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.f17406g;
    }

    public final int getPlaceholderId() {
        return this.f17407h;
    }

    @NonNull
    public final Priority getPriority() {
        return this.f17403d;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.f17418s;
    }

    @NonNull
    public final Key getSignature() {
        return this.f17411l;
    }

    public final float getSizeMultiplier() {
        return this.f17401b;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.f17420u;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.f17417r;
    }

    public final boolean getUseAnimationPool() {
        return this.f17425z;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.f17422w;
    }

    public int hashCode() {
        return Util.hashCode(this.f17420u, Util.hashCode(this.f17411l, Util.hashCode(this.f17418s, Util.hashCode(this.f17417r, Util.hashCode(this.f17416q, Util.hashCode(this.f17403d, Util.hashCode(this.f17402c, Util.hashCode(this.f17423x, Util.hashCode(this.f17422w, Util.hashCode(this.f17413n, Util.hashCode(this.f17412m, Util.hashCode(this.f17410k, Util.hashCode(this.f17409j, Util.hashCode(this.f17408i, Util.hashCode(this.f17414o, Util.hashCode(this.f17415p, Util.hashCode(this.f17406g, Util.hashCode(this.f17407h, Util.hashCode(this.f17404e, Util.hashCode(this.f17405f, Util.hashCode(this.f17401b)))))))))))))))))))));
    }

    public final boolean isDiskCacheStrategySet() {
        return b(4);
    }

    public final boolean isLocked() {
        return this.f17419t;
    }

    public final boolean isMemoryCacheable() {
        return this.f17408i;
    }

    public final boolean isPrioritySet() {
        return b(8);
    }

    public final boolean isSkipMemoryCacheSet() {
        return b(256);
    }

    public final boolean isTransformationAllowed() {
        return this.f17413n;
    }

    public final boolean isTransformationRequired() {
        return this.f17412m;
    }

    public final boolean isTransformationSet() {
        return b(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.f17410k, this.f17409j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T j(@NonNull Transformation<Bitmap> transformation, boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().j(transformation, z3);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z3);
        l(Bitmap.class, transformation, z3);
        l(Drawable.class, drawableTransformation, z3);
        l(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z3);
        l(GifDrawable.class, new GifDrawableTransformation(transformation), z3);
        return i();
    }

    @NonNull
    @CheckResult
    final T k(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f17421v) {
            return (T) mo4145clone().k(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    @NonNull
    <Y> T l(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation, boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().l(cls, transformation, z3);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.f17417r.put(cls, transformation);
        this.f17413n = true;
        int i4 = this.f17400a | 2048 | 65536;
        this.f17400a = i4;
        this.f17424y = false;
        if (z3) {
            this.f17400a = i4 | 131072;
            this.f17412m = true;
        }
        return i();
    }

    @NonNull
    public T lock() {
        this.f17419t = true;
        return h();
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().onlyRetrieveFromCache(z3);
        }
        this.f17423x = z3;
        this.f17400a |= 524288;
        return i();
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        return e(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        return d(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        return e(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        return d(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return j(transformation, false);
    }

    @NonNull
    @CheckResult
    public T override(int i4, int i5) {
        if (this.f17421v) {
            return (T) mo4145clone().override(i4, i5);
        }
        this.f17410k = i4;
        this.f17409j = i5;
        this.f17400a |= 512;
        return i();
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable drawable) {
        if (this.f17421v) {
            return (T) mo4145clone().placeholder(drawable);
        }
        this.f17406g = drawable;
        this.f17407h = 0;
        this.f17400a = (this.f17400a | 64) & (-129);
        return i();
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority priority) {
        if (this.f17421v) {
            return (T) mo4145clone().priority(priority);
        }
        this.f17403d = (Priority) Preconditions.checkNotNull(priority);
        this.f17400a |= 8;
        return i();
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull Option<Y> option, @NonNull Y y3) {
        if (this.f17421v) {
            return (T) mo4145clone().set(option, y3);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(y3);
        this.f17416q.set(option, y3);
        return i();
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull Key key) {
        if (this.f17421v) {
            return (T) mo4145clone().signature(key);
        }
        this.f17411l = (Key) Preconditions.checkNotNull(key);
        this.f17400a |= 1024;
        return i();
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f17421v) {
            return (T) mo4145clone().sizeMultiplier(f4);
        }
        if (f4 >= 0.0f && f4 <= 1.0f) {
            this.f17401b = f4;
            this.f17400a |= 2;
            return i();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().skipMemoryCache(true);
        }
        this.f17408i = !z3;
        this.f17400a |= 256;
        return i();
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme theme) {
        if (this.f17421v) {
            return (T) mo4145clone().theme(theme);
        }
        this.f17420u = theme;
        this.f17400a |= 32768;
        return i();
    }

    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int i4) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i4));
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap> transformation) {
        return j(transformation, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return j(new MultiTransformation(transformationArr), true);
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().useAnimationPool(z3);
        }
        this.f17425z = z3;
        this.f17400a |= 1048576;
        return i();
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z3) {
        if (this.f17421v) {
            return (T) mo4145clone().useUnlimitedSourceGeneratorsPool(z3);
        }
        this.f17422w = z3;
        this.f17400a |= 262144;
        return i();
    }

    @Override // 
    @CheckResult
    /* renamed from: clone */
    public T mo4145clone() {
        try {
            T t3 = (T) super.clone();
            Options options = new Options();
            t3.f17416q = options;
            options.putAll(this.f17416q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t3.f17417r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f17417r);
            t3.f17419t = false;
            t3.f17421v = false;
            return t3;
        } catch (CloneNotSupportedException e4) {
            throw new RuntimeException(e4);
        }
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return l(cls, transformation, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return j(new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform(transformationArr[0]);
        }
        return i();
    }

    @NonNull
    @CheckResult
    public T override(int i4) {
        return override(i4, i4);
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return l(cls, transformation, true);
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int i4) {
        if (this.f17421v) {
            return (T) mo4145clone().error(i4);
        }
        this.f17405f = i4;
        this.f17404e = null;
        this.f17400a = (this.f17400a | 32) & (-17);
        return i();
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int i4) {
        if (this.f17421v) {
            return (T) mo4145clone().fallback(i4);
        }
        this.f17415p = i4;
        this.f17414o = null;
        this.f17400a = (this.f17400a | 16384) & (-8193);
        return i();
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int i4) {
        if (this.f17421v) {
            return (T) mo4145clone().placeholder(i4);
        }
        this.f17407h = i4;
        this.f17406g = null;
        this.f17400a = (this.f17400a | 128) & (-65);
        return i();
    }

    private T h() {
        return this;
    }
}
