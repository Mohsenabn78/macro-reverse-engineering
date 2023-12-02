package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GlideContext extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    static final TransitionOptions<?, ?> f16591j = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f16592a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f16593b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageViewTargetFactory f16594c;

    /* renamed from: d  reason: collision with root package name */
    private final RequestOptions f16595d;

    /* renamed from: e  reason: collision with root package name */
    private final List<RequestListener<Object>> f16596e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f16597f;

    /* renamed from: g  reason: collision with root package name */
    private final Engine f16598g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16599h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16600i;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, boolean z3, int i4) {
        super(context.getApplicationContext());
        this.f16592a = arrayPool;
        this.f16593b = registry;
        this.f16594c = imageViewTargetFactory;
        this.f16595d = requestOptions;
        this.f16596e = list;
        this.f16597f = map;
        this.f16598g = engine;
        this.f16599h = z3;
        this.f16600i = i4;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> buildImageViewTarget(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f16594c.buildTarget(imageView, cls);
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.f16592a;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.f16596e;
    }

    public RequestOptions getDefaultRequestOptions() {
        return this.f16595d;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.f16597f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.f16597f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) f16591j : transitionOptions;
    }

    @NonNull
    public Engine getEngine() {
        return this.f16598g;
    }

    public int getLogLevel() {
        return this.f16600i;
    }

    @NonNull
    public Registry getRegistry() {
        return this.f16593b;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.f16599h;
    }
}
