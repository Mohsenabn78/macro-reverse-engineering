package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes3.dex */
class g<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<g<?>>, FactoryPools.Poolable {
    private DataSource A;
    private DataFetcher<?> B;
    private volatile DataFetcherGenerator C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d  reason: collision with root package name */
    private final e f16961d;

    /* renamed from: e  reason: collision with root package name */
    private final Pools.Pool<g<?>> f16962e;

    /* renamed from: h  reason: collision with root package name */
    private GlideContext f16965h;

    /* renamed from: i  reason: collision with root package name */
    private Key f16966i;

    /* renamed from: j  reason: collision with root package name */
    private Priority f16967j;

    /* renamed from: k  reason: collision with root package name */
    private j f16968k;

    /* renamed from: l  reason: collision with root package name */
    private int f16969l;

    /* renamed from: m  reason: collision with root package name */
    private int f16970m;

    /* renamed from: n  reason: collision with root package name */
    private DiskCacheStrategy f16971n;

    /* renamed from: o  reason: collision with root package name */
    private Options f16972o;

    /* renamed from: p  reason: collision with root package name */
    private b<R> f16973p;

    /* renamed from: q  reason: collision with root package name */
    private int f16974q;

    /* renamed from: r  reason: collision with root package name */
    private h f16975r;

    /* renamed from: s  reason: collision with root package name */
    private EnumC0138g f16976s;

    /* renamed from: t  reason: collision with root package name */
    private long f16977t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f16978u;

    /* renamed from: v  reason: collision with root package name */
    private Object f16979v;

    /* renamed from: w  reason: collision with root package name */
    private Thread f16980w;

    /* renamed from: x  reason: collision with root package name */
    private Key f16981x;

    /* renamed from: y  reason: collision with root package name */
    private Key f16982y;

    /* renamed from: z  reason: collision with root package name */
    private Object f16983z;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.f<R> f16958a = new com.bumptech.glide.load.engine.f<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f16959b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final StateVerifier f16960c = StateVerifier.newInstance();

    /* renamed from: f  reason: collision with root package name */
    private final d<?> f16963f = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final f f16964g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16984a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16985b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f16986c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f16986c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16986c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            f16985b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16985b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16985b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16985b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16985b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EnumC0138g.values().length];
            f16984a = iArr3;
            try {
                iArr3[EnumC0138g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16984a[EnumC0138g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16984a[EnumC0138g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public interface b<R> {
        void a(g<?> gVar);

        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public final class c<Z> implements DecodePath.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f16987a;

        c(DataSource dataSource) {
            this.f16987a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.a
        @NonNull
        public Resource<Z> a(@NonNull Resource<Z> resource) {
            return g.this.r(this.f16987a, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private Key f16989a;

        /* renamed from: b  reason: collision with root package name */
        private ResourceEncoder<Z> f16990b;

        /* renamed from: c  reason: collision with root package name */
        private n<Z> f16991c;

        d() {
        }

        void a() {
            this.f16989a = null;
            this.f16990b = null;
            this.f16991c = null;
        }

        void b(e eVar, Options options) {
            GlideTrace.beginSection("DecodeJob.encode");
            try {
                eVar.a().put(this.f16989a, new com.bumptech.glide.load.engine.e(this.f16990b, this.f16991c, options));
            } finally {
                this.f16991c.d();
                GlideTrace.endSection();
            }
        }

        boolean c() {
            if (this.f16991c != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(Key key, ResourceEncoder<X> resourceEncoder, n<X> nVar) {
            this.f16989a = key;
            this.f16990b = resourceEncoder;
            this.f16991c = nVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public interface e {
        DiskCache a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16992a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16993b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16994c;

        f() {
        }

        private boolean a(boolean z3) {
            if ((this.f16994c || z3 || this.f16993b) && this.f16992a) {
                return true;
            }
            return false;
        }

        synchronized boolean b() {
            this.f16993b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f16994c = true;
            return a(false);
        }

        synchronized boolean d(boolean z3) {
            this.f16992a = true;
            return a(z3);
        }

        synchronized void e() {
            this.f16993b = false;
            this.f16992a = false;
            this.f16994c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0138g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes3.dex */
    public enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Pools.Pool<g<?>> pool) {
        this.f16961d = eVar;
        this.f16962e = pool;
    }

    private <Data> Resource<R> c(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> d4 = d(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                k("Decoded result " + d4, logTime);
            }
            return d4;
        } finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> Resource<R> d(Data data, DataSource dataSource) throws GlideException {
        return v(data, dataSource, (LoadPath<Data, ?, R>) this.f16958a.h(data.getClass()));
    }

    private void e() {
        Resource<R> resource;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j4 = this.f16977t;
            l("Retrieved data", j4, "data: " + this.f16983z + ", cache key: " + this.f16981x + ", fetcher: " + this.B);
        }
        try {
            resource = c(this.B, this.f16983z, this.A);
        } catch (GlideException e4) {
            e4.g(this.f16982y, this.A);
            this.f16959b.add(e4);
            resource = null;
        }
        if (resource != null) {
            n(resource, this.A);
        } else {
            u();
        }
    }

    private DataFetcherGenerator f() {
        int i4 = a.f16985b[this.f16975r.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f16975r);
                }
                return new r(this.f16958a, this);
            }
            return new com.bumptech.glide.load.engine.c(this.f16958a, this);
        }
        return new o(this.f16958a, this);
    }

    private h g(h hVar) {
        int i4 = a.f16985b[hVar.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    if (i4 == 5) {
                        if (this.f16971n.decodeCachedResource()) {
                            return h.RESOURCE_CACHE;
                        }
                        return g(h.RESOURCE_CACHE);
                    }
                    throw new IllegalArgumentException("Unrecognized stage: " + hVar);
                }
                return h.FINISHED;
            } else if (this.f16978u) {
                return h.FINISHED;
            } else {
                return h.SOURCE;
            }
        } else if (this.f16971n.decodeCachedData()) {
            return h.DATA_CACHE;
        } else {
            return g(h.DATA_CACHE);
        }
    }

    @NonNull
    private Options h(DataSource dataSource) {
        boolean z3;
        Options options = this.f16972o;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.f16958a.w()) {
            z3 = false;
        } else {
            z3 = true;
        }
        Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
        Boolean bool = (Boolean) options.get(option);
        if (bool != null && (!bool.booleanValue() || z3)) {
            return options;
        }
        Options options2 = new Options();
        options2.putAll(this.f16972o);
        options2.set(option, Boolean.valueOf(z3));
        return options2;
    }

    private int i() {
        return this.f16967j.ordinal();
    }

    private void k(String str, long j4) {
        l(str, j4, null);
    }

    private void l(String str, long j4, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j4));
        sb.append(", load key: ");
        sb.append(this.f16968k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
    }

    private void m(Resource<R> resource, DataSource dataSource) {
        x();
        this.f16973p.onResourceReady(resource, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n(Resource<R> resource, DataSource dataSource) {
        n nVar;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        if (this.f16963f.c()) {
            resource = n.b(resource);
            nVar = resource;
        } else {
            nVar = 0;
        }
        m(resource, dataSource);
        this.f16975r = h.ENCODE;
        try {
            if (this.f16963f.c()) {
                this.f16963f.b(this.f16961d, this.f16972o);
            }
            p();
        } finally {
            if (nVar != 0) {
                nVar.d();
            }
        }
    }

    private void o() {
        x();
        this.f16973p.onLoadFailed(new GlideException("Failed to load resource", new ArrayList(this.f16959b)));
        q();
    }

    private void p() {
        if (this.f16964g.b()) {
            t();
        }
    }

    private void q() {
        if (this.f16964g.c()) {
            t();
        }
    }

    private void t() {
        this.f16964g.e();
        this.f16963f.a();
        this.f16958a.a();
        this.D = false;
        this.f16965h = null;
        this.f16966i = null;
        this.f16972o = null;
        this.f16967j = null;
        this.f16968k = null;
        this.f16973p = null;
        this.f16975r = null;
        this.C = null;
        this.f16980w = null;
        this.f16981x = null;
        this.f16983z = null;
        this.A = null;
        this.B = null;
        this.f16977t = 0L;
        this.E = false;
        this.f16979v = null;
        this.f16959b.clear();
        this.f16962e.release(this);
    }

    private void u() {
        this.f16980w = Thread.currentThread();
        this.f16977t = LogTime.getLogTime();
        boolean z3 = false;
        while (!this.E && this.C != null && !(z3 = this.C.a())) {
            this.f16975r = g(this.f16975r);
            this.C = f();
            if (this.f16975r == h.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.f16975r == h.FINISHED || this.E) && !z3) {
            o();
        }
    }

    private <Data, ResourceType> Resource<R> v(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options h4 = h(dataSource);
        DataRewinder<Data> rewinder = this.f16965h.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, h4, this.f16969l, this.f16970m, new c(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void w() {
        int i4 = a.f16984a[this.f16976s.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    e();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.f16976s);
            }
            u();
            return;
        }
        this.f16975r = g(h.INITIALIZE);
        this.C = f();
        u();
    }

    private void x() {
        Throwable th;
        this.f16960c.throwIfRecycled();
        if (this.D) {
            if (this.f16959b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f16959b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    public void a() {
        this.E = true;
        DataFetcherGenerator dataFetcherGenerator = this.C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(@NonNull g<?> gVar) {
        int i4 = i() - gVar.i();
        if (i4 == 0) {
            return this.f16974q - gVar.f16974q;
        }
        return i4;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.f16960c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g<R> j(GlideContext glideContext, Object obj, j jVar, Key key, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z3, boolean z4, boolean z5, Options options, b<R> bVar, int i6) {
        this.f16958a.u(glideContext, obj, key, i4, i5, diskCacheStrategy, cls, cls2, priority, options, map, z3, z4, this.f16961d);
        this.f16965h = glideContext;
        this.f16966i = key;
        this.f16967j = priority;
        this.f16968k = jVar;
        this.f16969l = i4;
        this.f16970m = i5;
        this.f16971n = diskCacheStrategy;
        this.f16978u = z5;
        this.f16972o = options;
        this.f16973p = bVar;
        this.f16974q = i6;
        this.f16976s = EnumC0138g.INITIALIZE;
        this.f16979v = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.h(key, dataSource, dataFetcher.getDataClass());
        this.f16959b.add(glideException);
        if (Thread.currentThread() != this.f16980w) {
            this.f16976s = EnumC0138g.SWITCH_TO_SOURCE_SERVICE;
            this.f16973p.a(this);
            return;
        }
        u();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f16981x = key;
        this.f16983z = obj;
        this.B = dataFetcher;
        this.A = dataSource;
        this.f16982y = key2;
        if (Thread.currentThread() != this.f16980w) {
            this.f16976s = EnumC0138g.DECODE_DATA;
            this.f16973p.a(this);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            e();
        } finally {
            GlideTrace.endSection();
        }
    }

    @NonNull
    <Z> Resource<Z> r(DataSource dataSource, @NonNull Resource<Z> resource) {
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        Key dVar;
        Class<?> cls = resource.get().getClass();
        ResourceEncoder<Z> resourceEncoder = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation<Z> r4 = this.f16958a.r(cls);
            transformation = r4;
            resource2 = r4.transform(this.f16965h, resource, this.f16969l, this.f16970m);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.recycle();
        }
        if (this.f16958a.v(resource2)) {
            resourceEncoder = this.f16958a.n(resource2);
            encodeStrategy = resourceEncoder.getEncodeStrategy(this.f16972o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        ResourceEncoder resourceEncoder2 = resourceEncoder;
        if (this.f16971n.isResourceCacheable(!this.f16958a.x(this.f16981x), dataSource, encodeStrategy)) {
            if (resourceEncoder2 != null) {
                int i4 = a.f16986c[encodeStrategy.ordinal()];
                if (i4 != 1) {
                    if (i4 == 2) {
                        dVar = new p(this.f16958a.b(), this.f16981x, this.f16966i, this.f16969l, this.f16970m, transformation, cls, this.f16972o);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                } else {
                    dVar = new com.bumptech.glide.load.engine.d(this.f16981x, this.f16966i);
                }
                n b4 = n.b(resource2);
                this.f16963f.d(dVar, resourceEncoder2, b4);
                return b4;
            }
            throw new Registry.NoResultEncoderAvailableException(resource2.get().getClass());
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        this.f16976s = EnumC0138g.SWITCH_TO_SOURCE_SERVICE;
        this.f16973p.a(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.f16979v);
        DataFetcher<?> dataFetcher = this.B;
        try {
            try {
                if (this.E) {
                    o();
                    return;
                }
                w();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                GlideTrace.endSection();
            } catch (com.bumptech.glide.load.engine.b e4) {
                throw e4;
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DecodeJob threw unexpectedly, isCancelled: ");
                    sb.append(this.E);
                    sb.append(", stage: ");
                    sb.append(this.f16975r);
                }
                if (this.f16975r != h.ENCODE) {
                    this.f16959b.add(th);
                    o();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } finally {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z3) {
        if (this.f16964g.d(z3)) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        h g4 = g(h.INITIALIZE);
        if (g4 != h.RESOURCE_CACHE && g4 != h.DATA_CACHE) {
            return false;
        }
        return true;
    }
}
