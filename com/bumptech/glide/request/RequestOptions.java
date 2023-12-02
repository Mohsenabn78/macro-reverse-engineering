package com.bumptech.glide.request;

import android.graphics.Bitmap;
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
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* loaded from: classes3.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @Nullable
    private static RequestOptions A;
    @Nullable
    private static RequestOptions B;
    @Nullable
    private static RequestOptions C;
    @Nullable
    private static RequestOptions D;
    @Nullable
    private static RequestOptions E;
    @Nullable
    private static RequestOptions F;
    @Nullable
    private static RequestOptions G;
    @Nullable
    private static RequestOptions H;

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        if (E == null) {
            E = new RequestOptions().centerCrop().autoClone();
        }
        return E;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        if (D == null) {
            D = new RequestOptions().centerInside().autoClone();
        }
        return D;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        if (F == null) {
            F = new RequestOptions().circleCrop().autoClone();
        }
        return F;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i4) {
        return new RequestOptions().encodeQuality(i4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        if (C == null) {
            C = new RequestOptions().fitCenter().autoClone();
        }
        return C;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j4) {
        return new RequestOptions().frame(j4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        if (H == null) {
            H = new RequestOptions().dontAnimate().autoClone();
        }
        return H;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        if (G == null) {
            G = new RequestOptions().dontTransform().autoClone();
        }
        return G;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t3) {
        return new RequestOptions().set(option, t3);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return new RequestOptions().override(i4, i5);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        return new RequestOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        return new RequestOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return new RequestOptions().sizeMultiplier(f4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z3) {
        if (z3) {
            if (A == null) {
                A = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return A;
        }
        if (B == null) {
            B = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return B;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i4) {
        return new RequestOptions().timeout(i4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i4) {
        return new RequestOptions().error(i4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(@IntRange(from = 0) int i4) {
        return overrideOf(i4, i4);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i4) {
        return new RequestOptions().placeholder(i4);
    }
}
