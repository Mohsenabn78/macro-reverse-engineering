package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final Pools.Pool<SingleRequest<?>> C = FactoryPools.threadSafe(150, new a());
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    @Nullable
    private RuntimeException B;

    /* renamed from: a  reason: collision with root package name */
    private boolean f17440a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f17441b;

    /* renamed from: c  reason: collision with root package name */
    private final StateVerifier f17442c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private RequestListener<R> f17443d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator f17444e;

    /* renamed from: f  reason: collision with root package name */
    private Context f17445f;

    /* renamed from: g  reason: collision with root package name */
    private GlideContext f17446g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Object f17447h;

    /* renamed from: i  reason: collision with root package name */
    private Class<R> f17448i;

    /* renamed from: j  reason: collision with root package name */
    private BaseRequestOptions<?> f17449j;

    /* renamed from: k  reason: collision with root package name */
    private int f17450k;

    /* renamed from: l  reason: collision with root package name */
    private int f17451l;

    /* renamed from: m  reason: collision with root package name */
    private Priority f17452m;

    /* renamed from: n  reason: collision with root package name */
    private Target<R> f17453n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private List<RequestListener<R>> f17454o;

    /* renamed from: p  reason: collision with root package name */
    private Engine f17455p;

    /* renamed from: q  reason: collision with root package name */
    private TransitionFactory<? super R> f17456q;

    /* renamed from: r  reason: collision with root package name */
    private Executor f17457r;

    /* renamed from: s  reason: collision with root package name */
    private Resource<R> f17458s;

    /* renamed from: t  reason: collision with root package name */
    private Engine.LoadStatus f17459t;

    /* renamed from: u  reason: collision with root package name */
    private long f17460u;
    @GuardedBy("this")

    /* renamed from: v  reason: collision with root package name */
    private b f17461v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f17462w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f17463x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f17464y;

    /* renamed from: z  reason: collision with root package name */
    private int f17465z;

    /* loaded from: classes3.dex */
    class a implements FactoryPools.Factory<SingleRequest<?>> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: a */
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    SingleRequest() {
        String str;
        if (D) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.f17441b = str;
        this.f17442c = StateVerifier.newInstance();
    }

    private void a() {
        if (!this.f17440a) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
            return false;
        }
        return true;
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return false;
        }
        return true;
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
            return false;
        }
        return true;
    }

    private void e() {
        a();
        this.f17442c.throwIfRecycled();
        this.f17453n.removeCallback(this);
        Engine.LoadStatus loadStatus = this.f17459t;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.f17459t = null;
        }
    }

    private Drawable f() {
        if (this.f17462w == null) {
            Drawable errorPlaceholder = this.f17449j.getErrorPlaceholder();
            this.f17462w = errorPlaceholder;
            if (errorPlaceholder == null && this.f17449j.getErrorId() > 0) {
                this.f17462w = l(this.f17449j.getErrorId());
            }
        }
        return this.f17462w;
    }

    private Drawable g() {
        if (this.f17464y == null) {
            Drawable fallbackDrawable = this.f17449j.getFallbackDrawable();
            this.f17464y = fallbackDrawable;
            if (fallbackDrawable == null && this.f17449j.getFallbackId() > 0) {
                this.f17464y = l(this.f17449j.getFallbackId());
            }
        }
        return this.f17464y;
    }

    private Drawable h() {
        if (this.f17463x == null) {
            Drawable placeholderDrawable = this.f17449j.getPlaceholderDrawable();
            this.f17463x = placeholderDrawable;
            if (placeholderDrawable == null && this.f17449j.getPlaceholderId() > 0) {
                this.f17463x = l(this.f17449j.getPlaceholderId());
            }
        }
        return this.f17463x;
    }

    private synchronized void i(Context context, GlideContext glideContext, Object obj, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i4, int i5, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.f17445f = context;
        this.f17446g = glideContext;
        this.f17447h = obj;
        this.f17448i = cls;
        this.f17449j = baseRequestOptions;
        this.f17450k = i4;
        this.f17451l = i5;
        this.f17452m = priority;
        this.f17453n = target;
        this.f17443d = requestListener;
        this.f17454o = list;
        this.f17444e = requestCoordinator;
        this.f17455p = engine;
        this.f17456q = transitionFactory;
        this.f17457r = executor;
        this.f17461v = b.PENDING;
        if (this.B == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null && requestCoordinator.isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    private synchronized boolean k(SingleRequest<?> singleRequest) {
        boolean z3;
        int size;
        int size2;
        synchronized (singleRequest) {
            List<RequestListener<R>> list = this.f17454o;
            z3 = false;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            List<RequestListener<?>> list2 = singleRequest.f17454o;
            if (list2 == null) {
                size2 = 0;
            } else {
                size2 = list2.size();
            }
            if (size == size2) {
                z3 = true;
            }
        }
        return z3;
    }

    private Drawable l(@DrawableRes int i4) {
        Resources.Theme theme;
        if (this.f17449j.getTheme() != null) {
            theme = this.f17449j.getTheme();
        } else {
            theme = this.f17445f.getTheme();
        }
        return DrawableDecoderCompat.getDrawable(this.f17446g, i4, theme);
    }

    private void m(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.f17441b);
    }

    private static int n(int i4, float f4) {
        if (i4 != Integer.MIN_VALUE) {
            return Math.round(f4 * i4);
        }
        return i4;
    }

    private void o() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i4, int i5, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        SingleRequest<?> acquire = C.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.i(context, glideContext, obj, cls, baseRequestOptions, i4, i5, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
        return acquire;
    }

    private void p() {
        RequestCoordinator requestCoordinator = this.f17444e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    private synchronized void q(GlideException glideException, int i4) {
        boolean z3;
        this.f17442c.throwIfRecycled();
        glideException.setOrigin(this.B);
        int logLevel = this.f17446g.getLogLevel();
        if (logLevel <= i4) {
            Log.w("Glide", "Load failed for " + this.f17447h + " with size [" + this.f17465z + "x" + this.A + "]", glideException);
            if (logLevel <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.f17459t = null;
        this.f17461v = b.FAILED;
        boolean z4 = true;
        this.f17440a = true;
        List<RequestListener<R>> list = this.f17454o;
        if (list != null) {
            z3 = false;
            for (RequestListener<R> requestListener : list) {
                z3 |= requestListener.onLoadFailed(glideException, this.f17447h, this.f17453n, j());
            }
        } else {
            z3 = false;
        }
        RequestListener<R> requestListener2 = this.f17443d;
        if (requestListener2 == null || !requestListener2.onLoadFailed(glideException, this.f17447h, this.f17453n, j())) {
            z4 = false;
        }
        if (!(z3 | z4)) {
            t();
        }
        this.f17440a = false;
        o();
    }

    private synchronized void r(Resource<R> resource, R r4, DataSource dataSource) {
        boolean z3;
        boolean j4 = j();
        this.f17461v = b.COMPLETE;
        this.f17458s = resource;
        if (this.f17446g.getLogLevel() <= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r4.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(dataSource);
            sb.append(" for ");
            sb.append(this.f17447h);
            sb.append(" with size [");
            sb.append(this.f17465z);
            sb.append("x");
            sb.append(this.A);
            sb.append("] in ");
            sb.append(LogTime.getElapsedMillis(this.f17460u));
            sb.append(" ms");
        }
        boolean z4 = true;
        this.f17440a = true;
        List<RequestListener<R>> list = this.f17454o;
        if (list != null) {
            z3 = false;
            for (RequestListener<R> requestListener : list) {
                z3 |= requestListener.onResourceReady(r4, this.f17447h, this.f17453n, dataSource, j4);
            }
        } else {
            z3 = false;
        }
        RequestListener<R> requestListener2 = this.f17443d;
        if (requestListener2 == null || !requestListener2.onResourceReady(r4, this.f17447h, this.f17453n, dataSource, j4)) {
            z4 = false;
        }
        if (!(z4 | z3)) {
            this.f17453n.onResourceReady(r4, this.f17456q.build(dataSource, j4));
        }
        this.f17440a = false;
        p();
    }

    private void s(Resource<?> resource) {
        this.f17455p.release(resource);
        this.f17458s = null;
    }

    private synchronized void t() {
        Drawable drawable;
        if (!c()) {
            return;
        }
        if (this.f17447h == null) {
            drawable = g();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = f();
        }
        if (drawable == null) {
            drawable = h();
        }
        this.f17453n.onLoadFailed(drawable);
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void begin() {
        int i4;
        a();
        this.f17442c.throwIfRecycled();
        this.f17460u = LogTime.getLogTime();
        if (this.f17447h == null) {
            if (Util.isValidDimensions(this.f17450k, this.f17451l)) {
                this.f17465z = this.f17450k;
                this.A = this.f17451l;
            }
            if (g() == null) {
                i4 = 5;
            } else {
                i4 = 3;
            }
            q(new GlideException("Received null model"), i4);
            return;
        }
        b bVar = this.f17461v;
        b bVar2 = b.RUNNING;
        if (bVar != bVar2) {
            if (bVar == b.COMPLETE) {
                onResourceReady(this.f17458s, DataSource.MEMORY_CACHE);
                return;
            }
            b bVar3 = b.WAITING_FOR_SIZE;
            this.f17461v = bVar3;
            if (Util.isValidDimensions(this.f17450k, this.f17451l)) {
                onSizeReady(this.f17450k, this.f17451l);
            } else {
                this.f17453n.getSize(this);
            }
            b bVar4 = this.f17461v;
            if ((bVar4 == bVar2 || bVar4 == bVar3) && c()) {
                this.f17453n.onLoadStarted(h());
            }
            if (D) {
                m("finished run method in " + LogTime.getElapsedMillis(this.f17460u));
            }
            return;
        }
        throw new IllegalArgumentException("Cannot restart a running request");
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void clear() {
        a();
        this.f17442c.throwIfRecycled();
        b bVar = this.f17461v;
        b bVar2 = b.CLEARED;
        if (bVar == bVar2) {
            return;
        }
        e();
        Resource<R> resource = this.f17458s;
        if (resource != null) {
            s(resource);
        }
        if (b()) {
            this.f17453n.onLoadCleared(h());
        }
        this.f17461v = bVar2;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.f17442c;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isCleared() {
        boolean z3;
        if (this.f17461v == b.CLEARED) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isComplete() {
        boolean z3;
        if (this.f17461v == b.COMPLETE) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isEquivalentTo(Request request) {
        boolean z3 = false;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        SingleRequest<?> singleRequest = (SingleRequest) request;
        synchronized (singleRequest) {
            if (this.f17450k == singleRequest.f17450k && this.f17451l == singleRequest.f17451l && Util.bothModelsNullEquivalentOrEquals(this.f17447h, singleRequest.f17447h) && this.f17448i.equals(singleRequest.f17448i) && this.f17449j.equals(singleRequest.f17449j) && this.f17452m == singleRequest.f17452m && k(singleRequest)) {
                z3 = true;
            }
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isFailed() {
        boolean z3;
        if (this.f17461v == b.FAILED) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isRunning() {
        boolean z3;
        b bVar = this.f17461v;
        if (bVar != b.RUNNING) {
            if (bVar != b.WAITING_FOR_SIZE) {
                z3 = false;
            }
        }
        z3 = true;
        return z3;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onLoadFailed(GlideException glideException) {
        q(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onResourceReady(Resource<?> resource, DataSource dataSource) {
        Object obj;
        String str;
        this.f17442c.throwIfRecycled();
        this.f17459t = null;
        if (resource == null) {
            onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.f17448i + " inside, but instead got null."));
            return;
        }
        Object obj2 = resource.get();
        if (obj2 != null && this.f17448i.isAssignableFrom(obj2.getClass())) {
            if (!d()) {
                s(resource);
                this.f17461v = b.COMPLETE;
                return;
            }
            r(resource, obj2, dataSource);
            return;
        }
        s(resource);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f17448i);
        sb.append(" but instead got ");
        if (obj2 != null) {
            obj = obj2.getClass();
        } else {
            obj = "";
        }
        sb.append(obj);
        sb.append("{");
        sb.append(obj2);
        sb.append("} inside Resource{");
        sb.append(resource);
        sb.append("}.");
        if (obj2 != null) {
            str = "";
        } else {
            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        }
        sb.append(str);
        onLoadFailed(new GlideException(sb.toString()));
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public synchronized void onSizeReady(int i4, int i5) {
        try {
            this.f17442c.throwIfRecycled();
            boolean z3 = D;
            if (z3) {
                m("Got onSizeReady in " + LogTime.getElapsedMillis(this.f17460u));
            }
            if (this.f17461v != b.WAITING_FOR_SIZE) {
                return;
            }
            b bVar = b.RUNNING;
            this.f17461v = bVar;
            float sizeMultiplier = this.f17449j.getSizeMultiplier();
            this.f17465z = n(i4, sizeMultiplier);
            this.A = n(i5, sizeMultiplier);
            if (z3) {
                m("finished setup for calling load in " + LogTime.getElapsedMillis(this.f17460u));
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f17459t = this.f17455p.load(this.f17446g, this.f17447h, this.f17449j.getSignature(), this.f17465z, this.A, this.f17449j.getResourceClass(), this.f17448i, this.f17452m, this.f17449j.getDiskCacheStrategy(), this.f17449j.getTransformations(), this.f17449j.isTransformationRequired(), this.f17449j.a(), this.f17449j.getOptions(), this.f17449j.isMemoryCacheable(), this.f17449j.getUseUnlimitedSourceGeneratorsPool(), this.f17449j.getUseAnimationPool(), this.f17449j.getOnlyRetrieveFromCache(), this, this.f17457r);
                if (this.f17461v != bVar) {
                    this.f17459t = null;
                }
                if (z3) {
                    m("finished onSizeReady in " + LogTime.getElapsedMillis(this.f17460u));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void recycle() {
        a();
        this.f17445f = null;
        this.f17446g = null;
        this.f17447h = null;
        this.f17448i = null;
        this.f17449j = null;
        this.f17450k = -1;
        this.f17451l = -1;
        this.f17453n = null;
        this.f17454o = null;
        this.f17443d = null;
        this.f17444e = null;
        this.f17456q = null;
        this.f17459t = null;
        this.f17462w = null;
        this.f17463x = null;
        this.f17464y = null;
        this.f17465z = -1;
        this.A = -1;
        this.B = null;
        C.release(this);
    }
}
