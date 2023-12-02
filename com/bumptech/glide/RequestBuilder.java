package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions O = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Context A;
    private final RequestManager B;
    private final Class<TranscodeType> C;
    private final Glide D;
    private final GlideContext E;
    @NonNull
    private TransitionOptions<?, ? super TranscodeType> F;
    @Nullable
    private Object G;
    @Nullable
    private List<RequestListener<TranscodeType>> H;
    @Nullable
    private RequestBuilder<TranscodeType> I;
    @Nullable
    private RequestBuilder<TranscodeType> J;
    @Nullable
    private Float K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16626a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16627b;

        static {
            int[] iArr = new int[Priority.values().length];
            f16627b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16627b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16627b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16627b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f16626a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16626a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16626a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16626a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16626a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16626a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16626a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16626a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.L = true;
        this.D = glide;
        this.B = requestManager;
        this.C = cls;
        this.A = context;
        this.F = requestManager.c(cls);
        this.E = glide.d();
        r(requestManager.a());
        apply((BaseRequestOptions<?>) requestManager.b());
    }

    private Request m(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return n(target, requestListener, null, this.F, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
    }

    private Request n(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i4, int i5, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.J != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request o4 = o(target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i4, i5, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return o4;
        }
        int overrideWidth = this.J.getOverrideWidth();
        int overrideHeight = this.J.getOverrideHeight();
        if (Util.isValidDimensions(i4, i5) && !this.J.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.J;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.setRequests(o4, requestBuilder.n(target, requestListener, errorRequestCoordinator, requestBuilder.F, requestBuilder.getPriority(), overrideWidth, overrideHeight, this.J, executor));
        return errorRequestCoordinator3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.BaseRequestOptions] */
    private Request o(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i4, int i5, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        TransitionOptions<?, ? super TranscodeType> transitionOptions2;
        Priority q4;
        RequestBuilder<TranscodeType> requestBuilder = this.I;
        if (requestBuilder != null) {
            if (!this.N) {
                TransitionOptions<?, ? super TranscodeType> transitionOptions3 = requestBuilder.F;
                if (requestBuilder.L) {
                    transitionOptions2 = transitionOptions;
                } else {
                    transitionOptions2 = transitionOptions3;
                }
                if (requestBuilder.isPrioritySet()) {
                    q4 = this.I.getPriority();
                } else {
                    q4 = q(priority);
                }
                Priority priority2 = q4;
                int overrideWidth = this.I.getOverrideWidth();
                int overrideHeight = this.I.getOverrideHeight();
                if (Util.isValidDimensions(i4, i5) && !this.I.isValidOverride()) {
                    overrideWidth = baseRequestOptions.getOverrideWidth();
                    overrideHeight = baseRequestOptions.getOverrideHeight();
                }
                int i6 = overrideWidth;
                int i7 = overrideHeight;
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
                Request w3 = w(target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i4, i5, executor);
                this.N = true;
                RequestBuilder<TranscodeType> requestBuilder2 = this.I;
                Request n4 = requestBuilder2.n(target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority2, i6, i7, requestBuilder2, executor);
                this.N = false;
                thumbnailRequestCoordinator.setRequests(w3, n4);
                return thumbnailRequestCoordinator;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.K != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator);
            thumbnailRequestCoordinator2.setRequests(w(target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i4, i5, executor), w(target, requestListener, baseRequestOptions.mo4145clone().sizeMultiplier(this.K.floatValue()), thumbnailRequestCoordinator2, transitionOptions, q(priority), i4, i5, executor));
            return thumbnailRequestCoordinator2;
        } else {
            return w(target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i4, i5, executor);
        }
    }

    @NonNull
    private Priority q(@NonNull Priority priority) {
        int i4 = a.f16627b[priority.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + getPriority());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void r(List<RequestListener<Object>> list) {
        for (RequestListener<Object> requestListener : list) {
            addListener(requestListener);
        }
    }

    private <Y extends Target<TranscodeType>> Y s(@NonNull Y y3, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.checkNotNull(y3);
        if (this.M) {
            Request m4 = m(y3, requestListener, baseRequestOptions, executor);
            Request request = y3.getRequest();
            if (m4.isEquivalentTo(request) && !u(baseRequestOptions, request)) {
                m4.recycle();
                if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                    request.begin();
                }
                return y3;
            }
            this.B.clear((Target<?>) y3);
            y3.setRequest(m4);
            this.B.e(y3, m4);
            return y3;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean u(BaseRequestOptions<?> baseRequestOptions, Request request) {
        if (!baseRequestOptions.isMemoryCacheable() && request.isComplete()) {
            return true;
        }
        return false;
    }

    @NonNull
    private RequestBuilder<TranscodeType> v(@Nullable Object obj) {
        this.G = obj;
        this.M = true;
        return this;
    }

    private Request w(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i4, int i5, Executor executor) {
        Context context = this.A;
        GlideContext glideContext = this.E;
        return SingleRequest.obtain(context, glideContext, this.G, this.C, baseRequestOptions, i4, i5, priority, target, requestListener, this.H, requestCoordinator, glideContext.getEngine(), transitionOptions.a(), executor);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(requestListener);
        }
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(@NonNull BaseRequestOptions baseRequestOptions) {
        return apply((BaseRequestOptions<?>) baseRequestOptions);
    }

    @CheckResult
    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(@NonNull Y y3) {
        return (Y) p().into((RequestBuilder<File>) y3);
    }

    @NonNull
    public RequestBuilder<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.J = requestBuilder;
        return this;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y into(@NonNull Y y3) {
        return (Y) t(y3, null, Executors.mainThreadExecutor());
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        this.H = null;
        return addListener(requestListener);
    }

    @NonNull
    @CheckResult
    protected RequestBuilder<File> p() {
        return new RequestBuilder(File.class, this).apply((BaseRequestOptions<?>) O);
    }

    @NonNull
    public Target<TranscodeType> preload(int i4, int i5) {
        return into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.B, i4, i5));
    }

    @NonNull
    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    <Y extends Target<TranscodeType>> Y t(@NonNull Y y3, @Nullable RequestListener<TranscodeType> requestListener, Executor executor) {
        return (Y) s(y3, requestListener, this, executor);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.I = requestBuilder;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.F = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
        this.L = false;
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.checkNotNull(baseRequestOptions);
        return (RequestBuilder) super.apply(baseRequestOptions);
    }

    @CheckResult
    @Deprecated
    public FutureTarget<File> downloadOnly(int i4, int i5) {
        return p().submit(i4, i5);
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> into(@NonNull ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        Util.assertMainThread();
        Preconditions.checkNotNull(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.f16626a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = mo4145clone().optionalCenterCrop();
                    break;
                case 2:
                    requestBuilder = mo4145clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = mo4145clone().optionalFitCenter();
                    break;
                case 6:
                    requestBuilder = mo4145clone().optionalCenterInside();
                    break;
            }
            return (ViewTarget) s(this.E.buildImageViewTarget(imageView, this.C), null, requestBuilder, Executors.mainThreadExecutor());
        }
        requestBuilder = this;
        return (ViewTarget) s(this.E.buildImageViewTarget(imageView, this.C), null, requestBuilder, Executors.mainThreadExecutor());
    }

    @NonNull
    public FutureTarget<TranscodeType> submit(int i4, int i5) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i4, i5);
        return (FutureTarget) t(requestFutureTarget, requestFutureTarget, Executors.directExecutor());
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArr != null && requestBuilderArr.length != 0) {
            for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
                RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
                if (requestBuilder2 != null) {
                    requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
                }
            }
            return thumbnail(requestBuilder);
        }
        return thumbnail((RequestBuilder) null);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: clone */
    public RequestBuilder<TranscodeType> mo4145clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.mo4145clone();
        requestBuilder.F = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.F.m4164clone();
        return requestBuilder;
    }

    @NonNull
    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<TranscodeType> thumbnail(float f4) {
        if (f4 >= 0.0f && f4 <= 1.0f) {
            this.K = Float.valueOf(f4);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4151load(@Nullable Object obj) {
        return v(obj);
    }

    @SuppressLint({"CheckResult"})
    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.D, requestBuilder.B, cls, requestBuilder.A);
        this.G = requestBuilder.G;
        this.M = requestBuilder.M;
        apply((BaseRequestOptions<?>) requestBuilder);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4146load(@Nullable Bitmap bitmap) {
        return v(bitmap).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4147load(@Nullable Drawable drawable) {
        return v(drawable).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4152load(@Nullable String str) {
        return v(str);
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i4, int i5) {
        return submit(i4, i5);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4148load(@Nullable Uri uri) {
        return v(uri);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4149load(@Nullable File file) {
        return v(file);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4150load(@Nullable @DrawableRes @RawRes Integer num) {
        return v(num).apply((BaseRequestOptions<?>) RequestOptions.signatureOf(ApplicationVersionSignature.obtain(this.A)));
    }

    @CheckResult
    @Deprecated
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4153load(@Nullable URL url) {
        return v(url);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<TranscodeType> m4154load(@Nullable byte[] bArr) {
        RequestBuilder<TranscodeType> v3 = v(bArr);
        if (!v3.isDiskCacheStrategySet()) {
            v3 = v3.apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return !v3.isSkipMemoryCacheSet() ? v3.apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true)) : v3;
    }
}
