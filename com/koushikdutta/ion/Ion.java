package com.koushikdutta.ion;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.FileUtility;
import com.koushikdutta.async.util.HashList;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.LoadBuilder;
import com.koushikdutta.ion.conscrypt.ConscryptMiddleware;
import com.koushikdutta.ion.cookie.CookieMiddleware;
import com.koushikdutta.ion.d;
import com.koushikdutta.ion.loader.AssetLoader;
import com.koushikdutta.ion.loader.AsyncHttpRequestFactory;
import com.koushikdutta.ion.loader.ContentLoader;
import com.koushikdutta.ion.loader.FileLoader;
import com.koushikdutta.ion.loader.HttpLoader;
import com.koushikdutta.ion.loader.PackageIconLoader;
import com.koushikdutta.ion.loader.ResourceLoader;
import com.koushikdutta.ion.loader.VideoLoader;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;

/* loaded from: classes6.dex */
public class Ion {
    static ExecutorService C;
    static HashMap<String, Ion> D;
    private static Comparator<DeferredLoadBitmap> E;

    /* renamed from: a  reason: collision with root package name */
    AsyncHttpClient f35719a;

    /* renamed from: b  reason: collision with root package name */
    ConscryptMiddleware f35720b;

    /* renamed from: c  reason: collision with root package name */
    CookieMiddleware f35721c;

    /* renamed from: d  reason: collision with root package name */
    ResponseCacheMiddleware f35722d;

    /* renamed from: e  reason: collision with root package name */
    FileCache f35723e;

    /* renamed from: f  reason: collision with root package name */
    HttpLoader f35724f;

    /* renamed from: g  reason: collision with root package name */
    ContentLoader f35725g;

    /* renamed from: h  reason: collision with root package name */
    ResourceLoader f35726h;

    /* renamed from: i  reason: collision with root package name */
    AssetLoader f35727i;

    /* renamed from: j  reason: collision with root package name */
    VideoLoader f35728j;

    /* renamed from: k  reason: collision with root package name */
    PackageIconLoader f35729k;

    /* renamed from: l  reason: collision with root package name */
    FileLoader f35730l;

    /* renamed from: m  reason: collision with root package name */
    String f35731m;

    /* renamed from: n  reason: collision with root package name */
    int f35732n;

    /* renamed from: o  reason: collision with root package name */
    Gson f35733o;

    /* renamed from: p  reason: collision with root package name */
    String f35734p;

    /* renamed from: r  reason: collision with root package name */
    String f35736r;

    /* renamed from: u  reason: collision with root package name */
    IonBitmapCache f35739u;

    /* renamed from: v  reason: collision with root package name */
    Context f35740v;

    /* renamed from: z  reason: collision with root package name */
    static final Handler f35718z = new Handler(Looper.getMainLooper());
    static int A = Runtime.getRuntime().availableProcessors();
    static ExecutorService B = Executors.newFixedThreadPool(4);

    /* renamed from: q  reason: collision with root package name */
    ArrayList<Loader> f35735q = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    HashList<FutureCallback<BitmapInfo>> f35737s = new HashList<>();

    /* renamed from: t  reason: collision with root package name */
    Config f35738t = new Config();

    /* renamed from: w  reason: collision with root package name */
    IonImageViewRequestBuilder f35741w = new IonImageViewRequestBuilder(this);

    /* renamed from: x  reason: collision with root package name */
    private Runnable f35742x = new b();

    /* renamed from: y  reason: collision with root package name */
    WeakHashMap<Object, c> f35743y = new WeakHashMap<>();

    /* loaded from: classes6.dex */
    public class Config {

        /* renamed from: a  reason: collision with root package name */
        AsyncHttpRequestFactory f35744a = new a();

        /* loaded from: classes6.dex */
        class a implements AsyncHttpRequestFactory {
            a() {
            }

            @Override // com.koushikdutta.ion.loader.AsyncHttpRequestFactory
            public AsyncHttpRequest createAsyncHttpRequest(Uri uri, String str, Headers headers) {
                AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(uri, str, headers);
                if (!TextUtils.isEmpty(Ion.this.f35734p)) {
                    asyncHttpRequest.getHeaders().set("User-Agent", Ion.this.f35734p);
                }
                return asyncHttpRequest;
            }
        }

        public Config() {
        }

        public Config addLoader(int i4, Loader loader) {
            Ion.this.f35735q.add(i4, loader);
            return this;
        }

        public SSLContext createSSLContext(String str) throws NoSuchAlgorithmException {
            Ion.this.f35720b.initialize();
            return SSLContext.getInstance(str);
        }

        public void disableProxy() {
            Ion.this.f35719a.getSocketMiddleware().disableProxy();
        }

        public void disableSecureProxy() {
            Ion.this.f35719a.getSSLSocketMiddleware().disableProxy();
        }

        public AsyncHttpRequestFactory getAsyncHttpRequestFactory() {
            return this.f35744a;
        }

        public ContentLoader getContentLoader() {
            return Ion.this.f35725g;
        }

        public FileLoader getFileLoader() {
            return Ion.this.f35730l;
        }

        public synchronized Gson getGson() {
            Ion ion = Ion.this;
            if (ion.f35733o == null) {
                ion.f35733o = new Gson();
            }
            return Ion.this.f35733o;
        }

        public HttpLoader getHttpLoader() {
            return Ion.this.f35724f;
        }

        public List<Loader> getLoaders() {
            return Ion.this.f35735q;
        }

        public PackageIconLoader getPackageIconLoader() {
            return Ion.this.f35729k;
        }

        public ResponseCacheMiddleware getResponseCache() {
            return Ion.this.f35722d;
        }

        public VideoLoader getVideoLoader() {
            return Ion.this.f35728j;
        }

        public Config insertLoader(Loader loader) {
            Ion.this.f35735q.add(0, loader);
            return this;
        }

        public void proxy(String str, int i4) {
            Ion.this.f35719a.getSocketMiddleware().enableProxy(str, i4);
        }

        public void proxySecure(String str, int i4) {
            Ion.this.f35719a.getSSLSocketMiddleware().enableProxy(str, i4);
        }

        public Config setAsyncHttpRequestFactory(AsyncHttpRequestFactory asyncHttpRequestFactory) {
            this.f35744a = asyncHttpRequestFactory;
            return this;
        }

        public void setGson(Gson gson) {
            Ion.this.f35733o = gson;
        }

        public Config setLogging(String str, int i4) {
            Ion ion = Ion.this;
            ion.f35731m = str;
            ion.f35732n = i4;
            return this;
        }

        public String userAgent() {
            return Ion.this.f35734p;
        }

        public Config addLoader(Loader loader) {
            Ion.this.f35735q.add(loader);
            return this;
        }

        public Config userAgent(String str) {
            Ion.this.f35734p = str;
            return this;
        }
    }

    /* loaded from: classes6.dex */
    static class a implements Comparator<DeferredLoadBitmap> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DeferredLoadBitmap deferredLoadBitmap, DeferredLoadBitmap deferredLoadBitmap2) {
            int i4 = deferredLoadBitmap.f35697e;
            int i5 = deferredLoadBitmap2.f35697e;
            if (i4 == i5) {
                return 0;
            }
            if (i4 < i5) {
                return 1;
            }
            return -1;
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.koushikdutta.ion.b.g(Ion.this)) {
                return;
            }
            ArrayList arrayList = null;
            for (String str : Ion.this.f35737s.keySet()) {
                Object tag = Ion.this.f35737s.tag(str);
                if (tag instanceof DeferredLoadBitmap) {
                    DeferredLoadBitmap deferredLoadBitmap = (DeferredLoadBitmap) tag;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(deferredLoadBitmap);
                }
            }
            if (arrayList == null) {
                return;
            }
            Collections.sort(arrayList, Ion.E);
            Iterator it = arrayList.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                DeferredLoadBitmap deferredLoadBitmap2 = (DeferredLoadBitmap) it.next();
                Ion.this.f35737s.tag(deferredLoadBitmap2.f35780a, null);
                Ion.this.f35737s.tag(deferredLoadBitmap2.f35696d.f35791b, null);
                deferredLoadBitmap2.f35696d.c();
                i4++;
                if (i4 > 5) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends WeakHashMap<Future, Boolean> {
        c() {
        }
    }

    static {
        ExecutorService newFixedThreadPool;
        int i4 = A;
        if (i4 > 2) {
            newFixedThreadPool = Executors.newFixedThreadPool(i4 - 1);
        } else {
            newFixedThreadPool = Executors.newFixedThreadPool(1);
        }
        C = newFixedThreadPool;
        D = new HashMap<>();
        E = new a();
    }

    private Ion(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f35740v = applicationContext;
        this.f35736r = str;
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient(new AsyncServer("ion-" + str));
        this.f35719a = asyncHttpClient;
        asyncHttpClient.getSSLSocketMiddleware().setHostnameVerifier(new BrowserCompatHostnameVerifier());
        this.f35719a.getSSLSocketMiddleware().setSpdyEnabled(false);
        AsyncHttpClient asyncHttpClient2 = this.f35719a;
        ConscryptMiddleware conscryptMiddleware = new ConscryptMiddleware(applicationContext, this.f35719a.getSSLSocketMiddleware());
        this.f35720b = conscryptMiddleware;
        asyncHttpClient2.insertMiddleware(conscryptMiddleware);
        File file = new File(applicationContext.getCacheDir(), str);
        try {
            this.f35722d = ResponseCacheMiddleware.addCache(this.f35719a, file, 10485760L);
        } catch (IOException e4) {
            k.a("unable to set up response cache, clearing", e4);
            FileUtility.deleteDirectory(file);
            try {
                this.f35722d = ResponseCacheMiddleware.addCache(this.f35719a, file, 10485760L);
            } catch (IOException unused) {
                k.a("unable to set up response cache, failing", e4);
            }
        }
        this.f35723e = new FileCache(new File(applicationContext.getFilesDir(), str), Long.MAX_VALUE, false);
        b();
        this.f35719a.getSocketMiddleware().setConnectAllAddresses(true);
        this.f35719a.getSSLSocketMiddleware().setConnectAllAddresses(true);
        this.f35739u = new IonBitmapCache(this);
        Config configure = configure();
        VideoLoader videoLoader = new VideoLoader();
        this.f35728j = videoLoader;
        Config addLoader = configure.addLoader(videoLoader);
        PackageIconLoader packageIconLoader = new PackageIconLoader();
        this.f35729k = packageIconLoader;
        Config addLoader2 = addLoader.addLoader(packageIconLoader);
        HttpLoader httpLoader = new HttpLoader();
        this.f35724f = httpLoader;
        Config addLoader3 = addLoader2.addLoader(httpLoader);
        ContentLoader contentLoader = new ContentLoader();
        this.f35725g = contentLoader;
        Config addLoader4 = addLoader3.addLoader(contentLoader);
        ResourceLoader resourceLoader = new ResourceLoader();
        this.f35726h = resourceLoader;
        Config addLoader5 = addLoader4.addLoader(resourceLoader);
        AssetLoader assetLoader = new AssetLoader();
        this.f35727i = assetLoader;
        Config addLoader6 = addLoader5.addLoader(assetLoader);
        FileLoader fileLoader = new FileLoader();
        this.f35730l = fileLoader;
        addLoader6.addLoader(fileLoader);
    }

    private void b() {
        AsyncHttpClient asyncHttpClient = this.f35719a;
        CookieMiddleware cookieMiddleware = new CookieMiddleware(this);
        this.f35721c = cookieMiddleware;
        asyncHttpClient.insertMiddleware(cookieMiddleware);
    }

    public static ExecutorService getBitmapLoadExecutorService() {
        return C;
    }

    public static Ion getDefault(Context context) {
        return getInstance(context, "ion");
    }

    public static Ion getInstance(Context context, String str) {
        if (context != null) {
            Ion ion = D.get(str);
            if (ion == null) {
                HashMap<String, Ion> hashMap = D;
                Ion ion2 = new Ion(context, str);
                hashMap.put(str, ion2);
                return ion2;
            }
            return ion;
        }
        throw new NullPointerException("Can not pass null context in to retrieve ion instance");
    }

    public static ExecutorService getIoExecutorService() {
        return B;
    }

    public static LoadBuilder<Builders.Any.B> with(Context context) {
        return getDefault(context).build(context);
    }

    public LoadBuilder<Builders.Any.B> build(Context context) {
        return new l(d.a(context), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Future future, Object obj) {
        c cVar;
        if (obj != null && future != null && !future.isDone() && !future.isCancelled()) {
            synchronized (this) {
                cVar = this.f35743y.get(obj);
                if (cVar == null) {
                    cVar = new c();
                    this.f35743y.put(obj, cVar);
                }
            }
            cVar.put(future, Boolean.TRUE);
        }
    }

    public FileCacheStore cache(String str) {
        return new FileCacheStore(this, this.f35722d.getFileCache(), str);
    }

    public void cancelAll(Object obj) {
        c remove;
        synchronized (this) {
            remove = this.f35743y.remove(obj);
        }
        if (remove == null) {
            return;
        }
        for (Future future : remove.keySet()) {
            if (future != null) {
                future.cancel();
            }
        }
    }

    public Config configure() {
        return this.f35738t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Handler handler = f35718z;
        handler.removeCallbacks(this.f35742x);
        handler.post(this.f35742x);
    }

    public void dump() {
        this.f35739u.dump();
        String str = this.f35731m;
        Log.i(str, "Pending bitmaps: " + this.f35737s.size());
        String str2 = this.f35731m;
        Log.i(str2, "Groups: " + this.f35743y.size());
        Iterator<c> it = this.f35743y.values().iterator();
        while (it.hasNext()) {
            String str3 = this.f35731m;
            Log.i(str3, "Group size: " + it.next().size());
        }
    }

    public IonBitmapCache getBitmapCache() {
        return this.f35739u;
    }

    public FileCache getCache() {
        return this.f35722d.getFileCache();
    }

    public ConscryptMiddleware getConscryptMiddleware() {
        return this.f35720b;
    }

    public Context getContext() {
        return this.f35740v;
    }

    public CookieMiddleware getCookieMiddleware() {
        return this.f35721c;
    }

    public AsyncHttpClient getHttpClient() {
        return this.f35719a;
    }

    public String getName() {
        return this.f35736r;
    }

    public int getPendingRequestCount(Object obj) {
        synchronized (this) {
            c cVar = this.f35743y.get(obj);
            int i4 = 0;
            if (cVar == null) {
                return 0;
            }
            for (Future future : cVar.keySet()) {
                if (!future.isCancelled() && !future.isDone()) {
                    i4++;
                }
            }
            return i4;
        }
    }

    public AsyncServer getServer() {
        return this.f35719a.getServer();
    }

    public FileCache getStore() {
        return this.f35723e;
    }

    public FileCacheStore store(String str) {
        return new FileCacheStore(this, this.f35723e, str);
    }

    @TargetApi(13)
    public static LoadBuilder<Builders.Any.B> with(Fragment fragment) {
        return getDefault(fragment.getActivity()).build(fragment);
    }

    public LoadBuilder<Builders.Any.B> build(Fragment fragment) {
        return new l(new d.c(fragment), this);
    }

    public static LoadBuilder<Builders.Any.B> with(androidx.fragment.app.Fragment fragment) {
        return getDefault(fragment.getActivity()).build(fragment);
    }

    public LoadBuilder<Builders.Any.B> build(androidx.fragment.app.Fragment fragment) {
        return new l(new d.g(fragment), this);
    }

    public static Builders.IV.F<? extends Builders.IV.F<?>> with(ImageView imageView) {
        return getDefault(imageView.getContext()).build(imageView);
    }

    public Builders.IV.F<? extends Builders.IV.F<?>> build(ImageView imageView) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f35741w.g();
            IonImageViewRequestBuilder ionImageViewRequestBuilder = this.f35741w;
            ionImageViewRequestBuilder.f35887b = this;
            return ionImageViewRequestBuilder.m(imageView);
        }
        throw new IllegalStateException("must be called from UI thread");
    }

    public void cancelAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f35743y.keySet());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cancelAll(it.next());
        }
    }

    public void cancelAll(Context context) {
        cancelAll((Object) context);
    }
}
