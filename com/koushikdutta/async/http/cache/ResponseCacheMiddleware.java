package com.koushikdutta.async.http.cache;

import android.net.Uri;
import android.util.Base64;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.SimpleMiddleware;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.Charsets;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheResponse;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
public class ResponseCacheMiddleware extends SimpleMiddleware {
    public static final String CACHE = "cache";
    public static final String CONDITIONAL_CACHE = "conditional-cache";
    public static final int ENTRY_BODY = 1;
    public static final int ENTRY_COUNT = 2;
    public static final int ENTRY_METADATA = 0;
    public static final String SERVED_FROM = "X-Served-From";

    /* renamed from: a  reason: collision with root package name */
    private boolean f35158a = true;

    /* renamed from: b  reason: collision with root package name */
    private int f35159b;

    /* renamed from: c  reason: collision with root package name */
    private int f35160c;

    /* renamed from: d  reason: collision with root package name */
    private FileCache f35161d;

    /* renamed from: e  reason: collision with root package name */
    private AsyncServer f35162e;

    /* renamed from: f  reason: collision with root package name */
    private int f35163f;

    /* renamed from: g  reason: collision with root package name */
    private int f35164g;

    /* renamed from: h  reason: collision with root package name */
    private int f35165h;

    /* renamed from: i  reason: collision with root package name */
    private int f35166i;

    /* loaded from: classes6.dex */
    public static class CacheData {

        /* renamed from: a  reason: collision with root package name */
        FileInputStream[] f35167a;

        /* renamed from: b  reason: collision with root package name */
        g f35168b;

        /* renamed from: c  reason: collision with root package name */
        long f35169c;

        /* renamed from: d  reason: collision with root package name */
        com.koushikdutta.async.http.cache.d f35170d;
    }

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f35171a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f35172b;

        a(AsyncHttpClientMiddleware.GetSocketData getSocketData, e eVar) {
            this.f35171a = getSocketData;
            this.f35172b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f35171a.connectCallback.onConnectCompleted(null, this.f35172b);
            this.f35172b.c();
        }
    }

    /* loaded from: classes6.dex */
    private static class b extends FilteredDataEmitter {

        /* renamed from: h  reason: collision with root package name */
        h f35174h;

        /* renamed from: i  reason: collision with root package name */
        ByteBufferList f35175i;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.DataEmitterBase
        public void a(Exception exc) {
            super.a(exc);
            if (exc != null) {
                b();
            }
        }

        public void b() {
            h hVar = this.f35174h;
            if (hVar != null) {
                hVar.a();
                this.f35174h = null;
            }
        }

        public void c() {
            h hVar = this.f35174h;
            if (hVar != null) {
                hVar.b();
                this.f35174h = null;
            }
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
        public void close() {
            b();
            super.close();
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = this.f35175i;
            if (byteBufferList2 != null) {
                super.onDataAvailable(dataEmitter, byteBufferList2);
                if (this.f35175i.remaining() > 0) {
                    return;
                }
                this.f35175i = null;
            }
            ByteBufferList byteBufferList3 = new ByteBufferList();
            try {
                try {
                    h hVar = this.f35174h;
                    if (hVar != null) {
                        FileOutputStream c4 = hVar.c(1);
                        if (c4 != null) {
                            while (!byteBufferList.isEmpty()) {
                                ByteBuffer remove = byteBufferList.remove();
                                try {
                                    ByteBufferList.writeOutputStream(c4, remove);
                                    byteBufferList3.add(remove);
                                } catch (Throwable th) {
                                    byteBufferList3.add(remove);
                                    throw th;
                                }
                            }
                        } else {
                            b();
                        }
                    }
                } catch (Exception unused) {
                    b();
                }
                super.onDataAvailable(dataEmitter, byteBufferList);
                if (this.f35174h != null && byteBufferList.remaining() > 0) {
                    ByteBufferList byteBufferList4 = new ByteBufferList();
                    this.f35175i = byteBufferList4;
                    byteBufferList.get(byteBufferList4);
                }
            } finally {
                byteBufferList.get(byteBufferList3);
                byteBufferList3.get(byteBufferList);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private static class c extends FilteredDataEmitter {

        /* renamed from: h  reason: collision with root package name */
        g f35176h;

        /* renamed from: j  reason: collision with root package name */
        private boolean f35178j;

        /* renamed from: l  reason: collision with root package name */
        boolean f35180l;

        /* renamed from: i  reason: collision with root package name */
        ByteBufferList f35177i = new ByteBufferList();

        /* renamed from: k  reason: collision with root package name */
        private Allocator f35179k = new Allocator();

        /* renamed from: m  reason: collision with root package name */
        Runnable f35181m = new a();

        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.close();
            }
        }

        public c(g gVar, long j4) {
            this.f35176h = gVar;
            this.f35179k.setCurrentAlloc((int) j4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.DataEmitterBase
        public void a(Exception exc) {
            if (!this.f35180l) {
                return;
            }
            StreamUtility.closeQuietly(this.f35176h.getBody());
            super.a(exc);
        }

        void b() {
            getServer().post(this.f35181m);
        }

        void c() {
            if (this.f35177i.remaining() > 0) {
                super.onDataAvailable(this, this.f35177i);
                if (this.f35177i.remaining() > 0) {
                    return;
                }
            }
            try {
                ByteBuffer allocate = this.f35179k.allocate();
                int read = this.f35176h.getBody().read(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (read == -1) {
                    ByteBufferList.reclaim(allocate);
                    this.f35180l = true;
                    a(null);
                    return;
                }
                this.f35179k.track(read);
                allocate.limit(read);
                this.f35177i.add(allocate);
                super.onDataAvailable(this, this.f35177i);
                if (this.f35177i.remaining() > 0) {
                    return;
                }
                getServer().postDelayed(this.f35181m, 10L);
            } catch (IOException e4) {
                this.f35180l = true;
                a(e4);
            }
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
        public void close() {
            if (getServer().getAffinity() != Thread.currentThread()) {
                getServer().post(new b());
                return;
            }
            this.f35177i.recycle();
            StreamUtility.closeQuietly(this.f35176h.getBody());
            super.close();
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
        public boolean isPaused() {
            return this.f35178j;
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
        public void resume() {
            this.f35178j = false;
            b();
        }
    }

    /* loaded from: classes6.dex */
    private class d extends e implements AsyncSSLSocket {
        public d(g gVar, long j4) {
            super(gVar, j4);
        }

        @Override // com.koushikdutta.async.AsyncSSLSocket
        public X509Certificate[] getPeerCertificates() {
            return null;
        }

        @Override // com.koushikdutta.async.AsyncSSLSocket
        public SSLEngine getSSLEngine() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class g extends CacheResponse {

        /* renamed from: a  reason: collision with root package name */
        private final f f35196a;

        /* renamed from: b  reason: collision with root package name */
        private final FileInputStream f35197b;

        public g(f fVar, FileInputStream fileInputStream) {
            this.f35196a = fVar;
            this.f35197b = fileInputStream;
        }

        @Override // java.net.CacheResponse
        /* renamed from: a */
        public FileInputStream getBody() {
            return this.f35197b;
        }

        @Override // java.net.CacheResponse
        public Map<String, List<String>> getHeaders() {
            return this.f35196a.f35192d.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        String f35198a;

        /* renamed from: b  reason: collision with root package name */
        File[] f35199b;

        /* renamed from: c  reason: collision with root package name */
        FileOutputStream[] f35200c = new FileOutputStream[2];

        /* renamed from: d  reason: collision with root package name */
        boolean f35201d;

        public h(String str) {
            this.f35198a = str;
            this.f35199b = ResponseCacheMiddleware.this.f35161d.getTempFiles(2);
        }

        void a() {
            StreamUtility.closeQuietly(this.f35200c);
            FileCache.removeFiles(this.f35199b);
            if (this.f35201d) {
                return;
            }
            ResponseCacheMiddleware.d(ResponseCacheMiddleware.this);
            this.f35201d = true;
        }

        void b() {
            StreamUtility.closeQuietly(this.f35200c);
            if (this.f35201d) {
                return;
            }
            ResponseCacheMiddleware.this.f35161d.commitTempFiles(this.f35198a, this.f35199b);
            ResponseCacheMiddleware.c(ResponseCacheMiddleware.this);
            this.f35201d = true;
        }

        FileOutputStream c(int i4) throws IOException {
            FileOutputStream[] fileOutputStreamArr = this.f35200c;
            if (fileOutputStreamArr[i4] == null) {
                fileOutputStreamArr[i4] = new FileOutputStream(this.f35199b[i4]);
            }
            return this.f35200c[i4];
        }
    }

    private ResponseCacheMiddleware() {
    }

    public static ResponseCacheMiddleware addCache(AsyncHttpClient asyncHttpClient, File file, long j4) throws IOException {
        for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : asyncHttpClient.getMiddleware()) {
            if (asyncHttpClientMiddleware instanceof ResponseCacheMiddleware) {
                throw new IOException("Response cache already added to http client");
            }
        }
        ResponseCacheMiddleware responseCacheMiddleware = new ResponseCacheMiddleware();
        responseCacheMiddleware.f35162e = asyncHttpClient.getServer();
        responseCacheMiddleware.f35161d = new FileCache(file, j4, false);
        asyncHttpClient.insertMiddleware(responseCacheMiddleware);
        return responseCacheMiddleware;
    }

    static /* synthetic */ int c(ResponseCacheMiddleware responseCacheMiddleware) {
        int i4 = responseCacheMiddleware.f35159b;
        responseCacheMiddleware.f35159b = i4 + 1;
        return i4;
    }

    static /* synthetic */ int d(ResponseCacheMiddleware responseCacheMiddleware) {
        int i4 = responseCacheMiddleware.f35160c;
        responseCacheMiddleware.f35160c = i4 + 1;
        return i4;
    }

    public void clear() {
        FileCache fileCache = this.f35161d;
        if (fileCache != null) {
            fileCache.clear();
        }
    }

    public int getCacheHitCount() {
        return this.f35164g;
    }

    public int getCacheStoreCount() {
        return this.f35166i;
    }

    public boolean getCaching() {
        return this.f35158a;
    }

    public int getConditionalCacheHitCount() {
        return this.f35163f;
    }

    public FileCache getFileCache() {
        return this.f35161d;
    }

    public int getNetworkCount() {
        return this.f35165h;
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        FileInputStream[] fileInputStreamArr;
        e eVar;
        com.koushikdutta.async.http.cache.c cVar = new com.koushikdutta.async.http.cache.c(getSocketData.request.getUri(), com.koushikdutta.async.http.cache.b.d(getSocketData.request.getHeaders().getMultiMap()));
        getSocketData.state.put("request-headers", cVar);
        if (this.f35161d != null && this.f35158a && !cVar.l()) {
            try {
                fileInputStreamArr = this.f35161d.get(FileCache.toKeyString(getSocketData.request.getUri()), 2);
                try {
                    if (fileInputStreamArr == null) {
                        this.f35165h++;
                        return null;
                    }
                    long available = fileInputStreamArr[1].available();
                    f fVar = new f(fileInputStreamArr[0]);
                    if (!fVar.d(getSocketData.request.getUri(), getSocketData.request.getMethod(), getSocketData.request.getHeaders().getMultiMap())) {
                        this.f35165h++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                    g gVar = new g(fVar, fileInputStreamArr[1]);
                    try {
                        Map<String, List<String>> headers = gVar.getHeaders();
                        FileInputStream body = gVar.getBody();
                        if (headers != null && body != null) {
                            com.koushikdutta.async.http.cache.b d4 = com.koushikdutta.async.http.cache.b.d(headers);
                            com.koushikdutta.async.http.cache.d dVar = new com.koushikdutta.async.http.cache.d(getSocketData.request.getUri(), d4);
                            d4.n("Content-Length", String.valueOf(available));
                            d4.m("Content-Encoding");
                            d4.m("Transfer-Encoding");
                            dVar.p(System.currentTimeMillis(), System.currentTimeMillis());
                            com.koushikdutta.async.http.cache.e g4 = dVar.g(System.currentTimeMillis(), cVar);
                            if (g4 == com.koushikdutta.async.http.cache.e.CACHE) {
                                getSocketData.request.logi("Response retrieved from cache");
                                if (fVar.c()) {
                                    eVar = new d(gVar, available);
                                } else {
                                    eVar = new e(gVar, available);
                                }
                                eVar.f35177i.add(ByteBuffer.wrap(d4.p().getBytes()));
                                this.f35162e.post(new a(getSocketData, eVar));
                                this.f35164g++;
                                getSocketData.state.put("socket-owner", this);
                                SimpleCancellable simpleCancellable = new SimpleCancellable();
                                simpleCancellable.setComplete();
                                return simpleCancellable;
                            } else if (g4 == com.koushikdutta.async.http.cache.e.CONDITIONAL_CACHE) {
                                getSocketData.request.logi("Response may be served from conditional cache");
                                CacheData cacheData = new CacheData();
                                cacheData.f35167a = fileInputStreamArr;
                                cacheData.f35169c = available;
                                cacheData.f35170d = dVar;
                                cacheData.f35168b = gVar;
                                getSocketData.state.put("cache-data", cacheData);
                                return null;
                            } else {
                                getSocketData.request.logd("Response can not be served from cache");
                                this.f35165h++;
                                StreamUtility.closeQuietly(fileInputStreamArr);
                                return null;
                            }
                        }
                        this.f35165h++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    } catch (Exception unused) {
                        this.f35165h++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                } catch (IOException unused2) {
                    this.f35165h++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
            } catch (IOException unused3) {
                fileInputStreamArr = null;
            }
        } else {
            this.f35165h++;
            return null;
        }
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDataOnRequestSentData onBodyDataOnRequestSentData) {
        if (((e) Util.getWrappedSocket(onBodyDataOnRequestSentData.socket, e.class)) != null) {
            onBodyDataOnRequestSentData.response.headers().set(SERVED_FROM, CACHE);
            return;
        }
        CacheData cacheData = (CacheData) onBodyDataOnRequestSentData.state.get("cache-data");
        com.koushikdutta.async.http.cache.b d4 = com.koushikdutta.async.http.cache.b.d(onBodyDataOnRequestSentData.response.headers().getMultiMap());
        d4.m("Content-Length");
        d4.o(String.format(Locale.ENGLISH, "%s %s %s", onBodyDataOnRequestSentData.response.protocol(), Integer.valueOf(onBodyDataOnRequestSentData.response.code()), onBodyDataOnRequestSentData.response.message()));
        com.koushikdutta.async.http.cache.d dVar = new com.koushikdutta.async.http.cache.d(onBodyDataOnRequestSentData.request.getUri(), d4);
        onBodyDataOnRequestSentData.state.put("response-headers", dVar);
        if (cacheData != null) {
            if (cacheData.f35170d.q(dVar)) {
                onBodyDataOnRequestSentData.request.logi("Serving response from conditional cache");
                com.koushikdutta.async.http.cache.d h4 = cacheData.f35170d.h(dVar);
                onBodyDataOnRequestSentData.response.headers(new Headers(h4.k().q()));
                onBodyDataOnRequestSentData.response.code(h4.k().h());
                onBodyDataOnRequestSentData.response.message(h4.k().i());
                onBodyDataOnRequestSentData.response.headers().set(SERVED_FROM, CONDITIONAL_CACHE);
                this.f35163f++;
                c cVar = new c(cacheData.f35168b, cacheData.f35169c);
                cVar.setDataEmitter(onBodyDataOnRequestSentData.bodyEmitter);
                onBodyDataOnRequestSentData.bodyEmitter = cVar;
                cVar.b();
                return;
            }
            onBodyDataOnRequestSentData.state.remove("cache-data");
            StreamUtility.closeQuietly(cacheData.f35167a);
        }
        if (!this.f35158a) {
            return;
        }
        com.koushikdutta.async.http.cache.c cVar2 = (com.koushikdutta.async.http.cache.c) onBodyDataOnRequestSentData.state.get("request-headers");
        if (cVar2 != null && dVar.m(cVar2) && onBodyDataOnRequestSentData.request.getMethod().equals("GET")) {
            String keyString = FileCache.toKeyString(onBodyDataOnRequestSentData.request.getUri());
            f fVar = new f(onBodyDataOnRequestSentData.request.getUri(), cVar2.f().f(dVar.l()), onBodyDataOnRequestSentData.request, dVar.k());
            b bVar = new b(null);
            h hVar = new h(keyString);
            try {
                fVar.f(hVar);
                hVar.c(1);
                bVar.f35174h = hVar;
                bVar.setDataEmitter(onBodyDataOnRequestSentData.bodyEmitter);
                onBodyDataOnRequestSentData.bodyEmitter = bVar;
                onBodyDataOnRequestSentData.state.put("body-cacher", bVar);
                onBodyDataOnRequestSentData.request.logd("Caching response");
                this.f35166i++;
                return;
            } catch (Exception unused) {
                hVar.a();
                this.f35165h++;
                return;
            }
        }
        this.f35165h++;
        onBodyDataOnRequestSentData.request.logd("Response is not cacheable");
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData) {
        FileInputStream[] fileInputStreamArr;
        CacheData cacheData = (CacheData) onResponseCompleteDataOnRequestSentData.state.get("cache-data");
        if (cacheData != null && (fileInputStreamArr = cacheData.f35167a) != null) {
            StreamUtility.closeQuietly(fileInputStreamArr);
        }
        e eVar = (e) Util.getWrappedSocket(onResponseCompleteDataOnRequestSentData.socket, e.class);
        if (eVar != null) {
            StreamUtility.closeQuietly(eVar.f35176h.getBody());
        }
        b bVar = (b) onResponseCompleteDataOnRequestSentData.state.get("body-cacher");
        if (bVar != null) {
            if (onResponseCompleteDataOnRequestSentData.exception != null) {
                bVar.b();
            } else {
                bVar.c();
            }
        }
    }

    public void removeFromCache(Uri uri) {
        getFileCache().remove(FileCache.toKeyString(uri));
    }

    public void setCaching(boolean z3) {
        this.f35158a = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f35189a;

        /* renamed from: b  reason: collision with root package name */
        private final com.koushikdutta.async.http.cache.b f35190b;

        /* renamed from: c  reason: collision with root package name */
        private final String f35191c;

        /* renamed from: d  reason: collision with root package name */
        private final com.koushikdutta.async.http.cache.b f35192d;

        /* renamed from: e  reason: collision with root package name */
        private final String f35193e;

        /* renamed from: f  reason: collision with root package name */
        private final Certificate[] f35194f;

        /* renamed from: g  reason: collision with root package name */
        private final Certificate[] f35195g;

        public f(InputStream inputStream) throws IOException {
            com.koushikdutta.async.http.cache.f fVar;
            Throwable th;
            try {
                fVar = new com.koushikdutta.async.http.cache.f(inputStream, Charsets.US_ASCII);
            } catch (Throwable th2) {
                fVar = null;
                th = th2;
            }
            try {
                this.f35189a = fVar.c();
                this.f35191c = fVar.c();
                this.f35190b = new com.koushikdutta.async.http.cache.b();
                int readInt = fVar.readInt();
                for (int i4 = 0; i4 < readInt; i4++) {
                    this.f35190b.c(fVar.c());
                }
                com.koushikdutta.async.http.cache.b bVar = new com.koushikdutta.async.http.cache.b();
                this.f35192d = bVar;
                bVar.o(fVar.c());
                int readInt2 = fVar.readInt();
                for (int i5 = 0; i5 < readInt2; i5++) {
                    this.f35192d.c(fVar.c());
                }
                this.f35193e = null;
                this.f35194f = null;
                this.f35195g = null;
                StreamUtility.closeQuietly(fVar, inputStream);
            } catch (Throwable th3) {
                th = th3;
                StreamUtility.closeQuietly(fVar, inputStream);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f35189a.startsWith("https://");
        }

        private void e(Writer writer, Certificate[] certificateArr) throws IOException {
            if (certificateArr == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificateArr.length) + '\n');
                for (Certificate certificate : certificateArr) {
                    writer.write(Base64.encodeToString(certificate.getEncoded(), 0) + '\n');
                }
            } catch (CertificateEncodingException e4) {
                throw new IOException(e4.getMessage());
            }
        }

        public boolean d(Uri uri, String str, Map<String, List<String>> map) {
            if (this.f35189a.equals(uri.toString()) && this.f35191c.equals(str) && new com.koushikdutta.async.http.cache.d(uri, this.f35192d).r(this.f35190b.q(), map)) {
                return true;
            }
            return false;
        }

        public void f(h hVar) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(hVar.c(0), Charsets.UTF_8));
            bufferedWriter.write(this.f35189a + '\n');
            bufferedWriter.write(this.f35191c + '\n');
            bufferedWriter.write(Integer.toString(this.f35190b.l()) + '\n');
            for (int i4 = 0; i4 < this.f35190b.l(); i4++) {
                bufferedWriter.write(this.f35190b.g(i4) + ": " + this.f35190b.k(i4) + '\n');
            }
            bufferedWriter.write(this.f35192d.j() + '\n');
            bufferedWriter.write(Integer.toString(this.f35192d.l()) + '\n');
            for (int i5 = 0; i5 < this.f35192d.l(); i5++) {
                bufferedWriter.write(this.f35192d.g(i5) + ": " + this.f35192d.k(i5) + '\n');
            }
            if (c()) {
                bufferedWriter.write(10);
                bufferedWriter.write(this.f35193e + '\n');
                e(bufferedWriter, this.f35194f);
                e(bufferedWriter, this.f35195g);
            }
            bufferedWriter.close();
        }

        public f(Uri uri, com.koushikdutta.async.http.cache.b bVar, AsyncHttpRequest asyncHttpRequest, com.koushikdutta.async.http.cache.b bVar2) {
            this.f35189a = uri.toString();
            this.f35190b = bVar;
            this.f35191c = asyncHttpRequest.getMethod();
            this.f35192d = bVar2;
            this.f35193e = null;
            this.f35194f = null;
            this.f35195g = null;
        }
    }

    /* loaded from: classes6.dex */
    private class e extends c implements AsyncSocket {

        /* renamed from: n  reason: collision with root package name */
        boolean f35185n;

        /* renamed from: o  reason: collision with root package name */
        boolean f35186o;

        /* renamed from: p  reason: collision with root package name */
        CompletedCallback f35187p;

        public e(g gVar, long j4) {
            super(gVar, j4);
            this.f35180l = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.http.cache.ResponseCacheMiddleware.c, com.koushikdutta.async.DataEmitterBase
        public void a(Exception exc) {
            super.a(exc);
            if (this.f35185n) {
                return;
            }
            this.f35185n = true;
            CompletedCallback completedCallback = this.f35187p;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            }
        }

        @Override // com.koushikdutta.async.http.cache.ResponseCacheMiddleware.c, com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
        public void close() {
            this.f35186o = false;
        }

        @Override // com.koushikdutta.async.DataSink
        public CompletedCallback getClosedCallback() {
            return this.f35187p;
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
        public AsyncServer getServer() {
            return ResponseCacheMiddleware.this.f35162e;
        }

        @Override // com.koushikdutta.async.DataSink
        public WritableCallback getWriteableCallback() {
            return null;
        }

        @Override // com.koushikdutta.async.DataSink
        public boolean isOpen() {
            return this.f35186o;
        }

        @Override // com.koushikdutta.async.DataSink
        public void setClosedCallback(CompletedCallback completedCallback) {
            this.f35187p = completedCallback;
        }

        @Override // com.koushikdutta.async.DataSink
        public void write(ByteBufferList byteBufferList) {
            byteBufferList.recycle();
        }

        @Override // com.koushikdutta.async.DataSink
        public void end() {
        }

        @Override // com.koushikdutta.async.DataSink
        public void setWriteableCallback(WritableCallback writableCallback) {
        }
    }
}
