package com.koushikdutta.async.http.server;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocketImpl;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.util.StreamUtility;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;

@TargetApi(5)
/* loaded from: classes6.dex */
public class AsyncHttpServer {

    /* renamed from: e  reason: collision with root package name */
    static Hashtable<String, String> f35289e = new Hashtable<>();

    /* renamed from: f  reason: collision with root package name */
    private static Hashtable<Integer, String> f35290f;

    /* renamed from: c  reason: collision with root package name */
    CompletedCallback f35293c;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<AsyncServerSocket> f35291a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ListenCallback f35292b = new a();

    /* renamed from: d  reason: collision with root package name */
    final Hashtable<String, ArrayList<g>> f35294d = new Hashtable<>();

    /* loaded from: classes6.dex */
    public interface WebSocketRequestCallback {
        void onConnected(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ListenCallback {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0192a extends AsyncHttpServerRequestImpl {

            /* renamed from: p  reason: collision with root package name */
            HttpServerRequestCallback f35296p;

            /* renamed from: q  reason: collision with root package name */
            String f35297q;

            /* renamed from: r  reason: collision with root package name */
            String f35298r;

            /* renamed from: s  reason: collision with root package name */
            boolean f35299s;

            /* renamed from: t  reason: collision with root package name */
            boolean f35300t;

            /* renamed from: u  reason: collision with root package name */
            AsyncHttpServerResponseImpl f35301u;

            /* renamed from: v  reason: collision with root package name */
            boolean f35302v;

            /* renamed from: w  reason: collision with root package name */
            final /* synthetic */ AsyncSocket f35303w;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0193a implements CompletedCallback {
                C0193a() {
                }

                @Override // com.koushikdutta.async.callback.CompletedCallback
                public void onCompleted(Exception exc) {
                    C0192a.this.resume();
                    if (exc != null) {
                        C0192a.this.a(exc);
                        return;
                    }
                    C0192a c0192a = C0192a.this;
                    c0192a.f35302v = true;
                    c0192a.f();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$a$a$b */
            /* loaded from: classes6.dex */
            public class b extends AsyncHttpServerResponseImpl {
                b(AsyncSocket asyncSocket, AsyncHttpServerRequestImpl asyncHttpServerRequestImpl) {
                    super(asyncSocket, asyncHttpServerRequestImpl);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponseImpl
                public void b() {
                    super.b();
                    this.f35344c.setEndCallback(null);
                    C0192a c0192a = C0192a.this;
                    c0192a.f35299s = true;
                    c0192a.l();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponseImpl
                public void c(Exception exc) {
                    super.c(exc);
                    if (exc != null) {
                        C0192a.this.f35303w.setDataCallback(new DataCallback.NullDataCallback());
                        C0192a.this.f35303w.setEndCallback(new CompletedCallback.NullCompletedCallback());
                        C0192a.this.f35303w.close();
                    }
                }
            }

            /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$a$a$c */
            /* loaded from: classes6.dex */
            class c extends DataCallback.NullDataCallback {
                c() {
                }

                @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
                public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                    super.onDataAvailable(dataEmitter, byteBufferList);
                    C0192a.this.f35334j.close();
                }
            }

            C0192a(AsyncSocket asyncSocket) {
                this.f35303w = asyncSocket;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l() {
                if (this.f35300t && this.f35299s) {
                    if (HttpUtil.isKeepAlive(Protocol.HTTP_1_1, getHeaders())) {
                        a.this.onAccepted(this.f35303w);
                    } else {
                        this.f35303w.close();
                    }
                }
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl
            protected void f() {
                Headers headers = getHeaders();
                if (!this.f35302v && "100-continue".equals(headers.get("Expect"))) {
                    pause();
                    Util.writeAll(this.f35334j, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new C0193a());
                    return;
                }
                String[] split = getStatusLine().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                String str = split[1];
                this.f35297q = str;
                this.f35298r = str.split("\\?")[0];
                this.f35338n = split[0];
                synchronized (AsyncHttpServer.this.f35294d) {
                    ArrayList<g> arrayList = AsyncHttpServer.this.f35294d.get(this.f35338n);
                    if (arrayList != null) {
                        Iterator<g> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            g next = it.next();
                            Matcher matcher = next.f35330a.matcher(this.f35298r);
                            if (matcher.matches()) {
                                this.f35335k = matcher;
                                this.f35296p = next.f35331b;
                                break;
                            }
                        }
                    }
                }
                b bVar = new b(this.f35303w, this);
                this.f35301u = bVar;
                boolean c4 = AsyncHttpServer.this.c(this, bVar);
                if (this.f35296p == null && !c4) {
                    this.f35301u.code(404);
                    this.f35301u.end();
                } else if (!getBody().readFullyOnRequest()) {
                    AsyncHttpServer.this.b(this.f35296p, this, this.f35301u);
                } else if (this.f35300t) {
                    AsyncHttpServer.this.b(this.f35296p, this, this.f35301u);
                }
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
            public String getPath() {
                return this.f35298r;
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
            public Multimap getQuery() {
                String[] split = this.f35297q.split("\\?", 2);
                if (split.length < 2) {
                    return new Multimap();
                }
                return Multimap.parseQuery(split[1]);
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl
            protected AsyncHttpRequestBody h(Headers headers) {
                return AsyncHttpServer.this.d(headers);
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl, com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (this.f35301u.code() == 101) {
                    return;
                }
                this.f35300t = true;
                super.onCompleted(exc);
                this.f35334j.setDataCallback(new c());
                l();
                if (getBody().readFullyOnRequest()) {
                    AsyncHttpServer.this.b(this.f35296p, this, this.f35301u);
                }
            }
        }

        a() {
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onAccepted(AsyncSocket asyncSocket) {
            new C0192a(asyncSocket).i(asyncSocket);
            asyncSocket.resume();
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServer.this.e(exc);
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onListening(AsyncServerSocket asyncServerSocket) {
            AsyncHttpServer.this.f35291a.add(asyncServerSocket);
        }
    }

    /* loaded from: classes6.dex */
    class b implements ListenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f35308a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SSLContext f35309b;

        /* loaded from: classes6.dex */
        class a implements AsyncSSLSocketWrapper.HandshakeCallback {
            a() {
            }

            @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
            public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                if (asyncSSLSocket != null) {
                    AsyncHttpServer.this.f35292b.onAccepted(asyncSSLSocket);
                }
            }
        }

        b(int i4, SSLContext sSLContext) {
            this.f35308a = i4;
            this.f35309b = sSLContext;
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onAccepted(AsyncSocket asyncSocket) {
            AsyncSSLSocketWrapper.handshake(asyncSocket, null, this.f35308a, this.f35309b.createSSLEngine(), null, null, false, new a());
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServer.this.f35292b.onCompleted(exc);
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onListening(AsyncServerSocket asyncServerSocket) {
            AsyncHttpServer.this.f35292b.onListening(asyncServerSocket);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements HttpServerRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebSocketRequestCallback f35313b;

        c(String str, WebSocketRequestCallback webSocketRequestCallback) {
            this.f35312a = str;
            this.f35313b = webSocketRequestCallback;
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            String str = asyncHttpServerRequest.getHeaders().get("Connection");
            boolean z3 = false;
            if (str != null) {
                String[] split = str.split(",");
                int length = split.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    } else if (HttpHeaders.UPGRADE.equalsIgnoreCase(split[i4].trim())) {
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if ("websocket".equalsIgnoreCase(asyncHttpServerRequest.getHeaders().get(HttpHeaders.UPGRADE)) && z3) {
                if (!TextUtils.equals(this.f35312a, asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_PROTOCOL))) {
                    asyncHttpServerResponse.code(404);
                    asyncHttpServerResponse.end();
                    return;
                }
                this.f35313b.onConnected(new WebSocketImpl(asyncHttpServerRequest, asyncHttpServerResponse), asyncHttpServerRequest);
                return;
            }
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        }
    }

    /* loaded from: classes6.dex */
    class d implements HttpServerRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f35315a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35316b;

        /* loaded from: classes6.dex */
        class a implements CompletedCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AsyncHttpServerResponse f35318a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InputStream f35319b;

            a(AsyncHttpServerResponse asyncHttpServerResponse, InputStream inputStream) {
                this.f35318a = asyncHttpServerResponse;
                this.f35319b = inputStream;
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                this.f35318a.end();
                StreamUtility.closeQuietly(this.f35319b);
            }
        }

        d(Context context, String str) {
            this.f35315a = context;
            this.f35316b = str;
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            Object obj;
            String replaceAll = asyncHttpServerRequest.getMatcher().replaceAll("");
            Context context = this.f35315a;
            Pair<Integer, InputStream> assetStream = AsyncHttpServer.getAssetStream(context, this.f35316b + replaceAll);
            if (assetStream != null && (obj = assetStream.second) != null) {
                InputStream inputStream = (InputStream) obj;
                asyncHttpServerResponse.getHeaders().set("Content-Length", String.valueOf(assetStream.first));
                asyncHttpServerResponse.code(200);
                Headers headers = asyncHttpServerResponse.getHeaders();
                headers.add("Content-Type", AsyncHttpServer.getContentType(this.f35316b + replaceAll));
                Util.pump(inputStream, asyncHttpServerResponse, new a(asyncHttpServerResponse, inputStream));
                return;
            }
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        }
    }

    /* loaded from: classes6.dex */
    class e implements HttpServerRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f35321a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35322b;

        e(Context context, String str) {
            this.f35321a = context;
            this.f35322b = str;
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            Object obj;
            String replaceAll = asyncHttpServerRequest.getMatcher().replaceAll("");
            Context context = this.f35321a;
            Pair<Integer, InputStream> assetStream = AsyncHttpServer.getAssetStream(context, this.f35322b + replaceAll);
            if (assetStream != null && (obj = assetStream.second) != null) {
                StreamUtility.closeQuietly((InputStream) obj);
                asyncHttpServerResponse.getHeaders().set("Content-Length", String.valueOf(assetStream.first));
                asyncHttpServerResponse.code(200);
                Headers headers = asyncHttpServerResponse.getHeaders();
                headers.add("Content-Type", AsyncHttpServer.getContentType(this.f35322b + replaceAll));
                asyncHttpServerResponse.writeHead();
                asyncHttpServerResponse.end();
                return;
            }
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements HttpServerRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f35324a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f35325b;

        /* loaded from: classes6.dex */
        class a implements Comparator<File> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        }

        /* loaded from: classes6.dex */
        class b implements CompletedCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AsyncHttpServerResponse f35328a;

            b(AsyncHttpServerResponse asyncHttpServerResponse) {
                this.f35328a = asyncHttpServerResponse;
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                this.f35328a.end();
            }
        }

        f(File file, boolean z3) {
            this.f35324a = file;
            this.f35325b = z3;
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            File[] listFiles;
            File file = new File(this.f35324a, asyncHttpServerRequest.getMatcher().replaceAll(""));
            if (file.isDirectory() && this.f35325b) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        arrayList.add(file2);
                    } else {
                        arrayList2.add(file2);
                    }
                }
                a aVar = new a();
                Collections.sort(arrayList, aVar);
                Collections.sort(arrayList2, aVar);
                arrayList2.addAll(0, arrayList);
            } else if (!file.isFile()) {
                asyncHttpServerResponse.code(404);
                asyncHttpServerResponse.end();
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    asyncHttpServerResponse.code(200);
                    Util.pump(fileInputStream, asyncHttpServerResponse, new b(asyncHttpServerResponse));
                } catch (FileNotFoundException unused) {
                    asyncHttpServerResponse.code(404);
                    asyncHttpServerResponse.end();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        Pattern f35330a;

        /* renamed from: b  reason: collision with root package name */
        HttpServerRequestCallback f35331b;

        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        f35290f = hashtable;
        hashtable.put(200, "OK");
        f35290f.put(202, "Accepted");
        f35290f.put(206, "Partial Content");
        f35290f.put(101, "Switching Protocols");
        f35290f.put(301, "Moved Permanently");
        f35290f.put(302, "Found");
        f35290f.put(404, "Not Found");
    }

    public AsyncHttpServer() {
        f35289e.put("js", "application/javascript");
        f35289e.put("json", "application/json");
        f35289e.put("png", "image/png");
        f35289e.put(ImageUtils.JPG_FILE_EXTENSION, ImageUtils.MIME_TYPE_JPEG);
        f35289e.put("html", "text/html");
        f35289e.put("css", "text/css");
        f35289e.put("mp4", "video/mp4");
        f35289e.put("mov", "video/quicktime");
        f35289e.put("wmv", "video/x-ms-wmv");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Exception exc) {
        CompletedCallback completedCallback = this.f35293c;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public static Pair<Integer, InputStream> getAssetStream(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            return new Pair<>(Integer.valueOf(open.available()), open);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String getContentType(String str) {
        String tryGetContentType = tryGetContentType(str);
        if (tryGetContentType != null) {
            return tryGetContentType;
        }
        return "text/plain";
    }

    public static String getResponseCodeDescription(int i4) {
        String str = f35290f.get(Integer.valueOf(i4));
        if (str == null) {
            return "Unknown";
        }
        return str;
    }

    public static String tryGetContentType(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String str2 = f35289e.get(str.substring(lastIndexOf + 1));
            if (str2 != null) {
                return str2;
            }
            return null;
        }
        return null;
    }

    public void addAction(String str, String str2, HttpServerRequestCallback httpServerRequestCallback) {
        g gVar = new g(null);
        gVar.f35330a = Pattern.compile("^" + str2);
        gVar.f35331b = httpServerRequestCallback;
        synchronized (this.f35294d) {
            ArrayList<g> arrayList = this.f35294d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f35294d.put(str, arrayList);
            }
            arrayList.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(HttpServerRequestCallback httpServerRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        if (httpServerRequestCallback != null) {
            httpServerRequestCallback.onRequest(asyncHttpServerRequest, asyncHttpServerResponse);
        }
    }

    protected boolean c(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return false;
    }

    protected AsyncHttpRequestBody d(Headers headers) {
        return new UnknownRequestBody(headers.get("Content-Type"));
    }

    public void directory(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        addAction("GET", str, new d(applicationContext, str2));
        addAction("HEAD", str, new e(applicationContext, str2));
    }

    public void get(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("GET", str, httpServerRequestCallback);
    }

    public CompletedCallback getErrorCallback() {
        return this.f35293c;
    }

    public ListenCallback getListenCallback() {
        return this.f35292b;
    }

    public AsyncServerSocket listen(AsyncServer asyncServer, int i4) {
        return asyncServer.listen(null, i4, this.f35292b);
    }

    public void listenSecure(int i4, SSLContext sSLContext) {
        AsyncServer.getDefault().listen(null, i4, new b(i4, sSLContext));
    }

    public void post(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("POST", str, httpServerRequestCallback);
    }

    public void removeAction(String str, String str2) {
        synchronized (this.f35294d) {
            ArrayList<g> arrayList = this.f35294d.get(str);
            if (arrayList == null) {
                return;
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (str2.equals(arrayList.get(i4).f35330a.toString())) {
                    arrayList.remove(i4);
                    return;
                }
            }
        }
    }

    public void setErrorCallback(CompletedCallback completedCallback) {
        this.f35293c = completedCallback;
    }

    public void stop() {
        ArrayList<AsyncServerSocket> arrayList = this.f35291a;
        if (arrayList != null) {
            Iterator<AsyncServerSocket> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    public void websocket(String str, WebSocketRequestCallback webSocketRequestCallback) {
        websocket(str, null, webSocketRequestCallback);
    }

    public AsyncServerSocket listen(int i4) {
        return listen(AsyncServer.getDefault(), i4);
    }

    public void websocket(String str, String str2, WebSocketRequestCallback webSocketRequestCallback) {
        get(str, new c(str2, webSocketRequestCallback));
    }

    public void directory(String str, File file) {
        directory(str, file, false);
    }

    public void directory(String str, File file, boolean z3) {
        addAction("GET", str, new f(file, z3));
    }
}
