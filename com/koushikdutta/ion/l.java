package com.koushikdutta.ion;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.DataTrackingEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.body.DocumentBody;
import com.koushikdutta.async.http.body.FileBody;
import com.koushikdutta.async.http.body.FilePart;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.body.Part;
import com.koushikdutta.async.http.body.StreamBody;
import com.koushikdutta.async.http.body.StringBody;
import com.koushikdutta.async.http.body.UrlEncodedFormBody;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.DocumentParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.FileDataSink;
import com.koushikdutta.async.stream.OutputStreamDataSink;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LocallyCachedStatus;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.FutureBuilder;
import com.koushikdutta.ion.builder.LoadBuilder;
import com.koushikdutta.ion.future.ImageViewFuture;
import com.koushikdutta.ion.future.ResponseFuture;
import com.koushikdutta.ion.gson.GsonArrayParser;
import com.koushikdutta.ion.gson.GsonBody;
import com.koushikdutta.ion.gson.GsonObjectParser;
import com.koushikdutta.ion.gson.GsonSerializer;
import com.koushikdutta.ion.gson.PojoBody;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IonRequestBuilder.java */
/* loaded from: classes6.dex */
public class l implements Builders.Any.B, Builders.Any.F, Builders.Any.M, Builders.Any.U, LoadBuilder<Builders.Any.B> {
    ProgressDialog A;
    ProgressCallback B;
    HeadersCallback C;

    /* renamed from: a  reason: collision with root package name */
    Ion f35938a;

    /* renamed from: b  reason: collision with root package name */
    com.koushikdutta.ion.d f35939b;

    /* renamed from: e  reason: collision with root package name */
    String f35942e;

    /* renamed from: f  reason: collision with root package name */
    boolean f35943f;

    /* renamed from: g  reason: collision with root package name */
    Headers f35944g;

    /* renamed from: h  reason: collision with root package name */
    boolean f35945h;

    /* renamed from: i  reason: collision with root package name */
    Multimap f35946i;

    /* renamed from: k  reason: collision with root package name */
    AsyncHttpRequestBody f35948k;

    /* renamed from: m  reason: collision with root package name */
    j f35950m;

    /* renamed from: n  reason: collision with root package name */
    WeakReference<ProgressBar> f35951n;

    /* renamed from: o  reason: collision with root package name */
    WeakReference<ProgressDialog> f35952o;

    /* renamed from: p  reason: collision with root package name */
    ProgressCallback f35953p;

    /* renamed from: q  reason: collision with root package name */
    ProgressCallback f35954q;

    /* renamed from: r  reason: collision with root package name */
    Multimap f35955r;

    /* renamed from: s  reason: collision with root package name */
    MultipartFormDataBody f35956s;

    /* renamed from: t  reason: collision with root package name */
    String f35957t;

    /* renamed from: u  reason: collision with root package name */
    int f35958u;

    /* renamed from: v  reason: collision with root package name */
    ArrayList<WeakReference<Object>> f35959v;

    /* renamed from: w  reason: collision with root package name */
    String f35960w;

    /* renamed from: x  reason: collision with root package name */
    int f35961x;

    /* renamed from: y  reason: collision with root package name */
    ProgressCallback f35962y;

    /* renamed from: z  reason: collision with root package name */
    ProgressBar f35963z;

    /* renamed from: c  reason: collision with root package name */
    Handler f35940c = Ion.f35718z;

    /* renamed from: d  reason: collision with root package name */
    String f35941d = "GET";

    /* renamed from: j  reason: collision with root package name */
    int f35947j = 30000;

    /* renamed from: l  reason: collision with root package name */
    boolean f35949l = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f35964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f35965b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f35966c;

        a(i iVar, Exception exc, Object obj) {
            this.f35964a = iVar;
            this.f35965b = exc;
            this.f35966c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            String c4 = l.this.f35939b.c();
            if (c4 != null) {
                AsyncHttpRequest asyncHttpRequest = this.f35964a.f35997i;
                asyncHttpRequest.logd("context has died: " + c4);
                this.f35964a.cancelSilently();
                return;
            }
            Exception exc = this.f35965b;
            if (exc != null) {
                this.f35964a.setComplete(exc);
            } else {
                this.f35964a.setComplete((i) this.f35966c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class b implements ProgressCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f35968a;

        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f35970a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f35971b;

            a(long j4, long j5) {
                this.f35970a = j4;
                this.f35971b = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.f35968a.isCancelled() && !b.this.f35968a.isDone()) {
                    l.this.B.onProgress(this.f35970a, this.f35971b);
                }
            }
        }

        b(i iVar) {
            this.f35968a = iVar;
        }

        @Override // com.koushikdutta.ion.ProgressCallback
        public void onProgress(long j4, long j5) {
            int i4 = (int) ((((float) j4) / ((float) j5)) * 100.0f);
            ProgressBar progressBar = l.this.f35963z;
            if (progressBar != null) {
                progressBar.setProgress(i4);
            }
            ProgressDialog progressDialog = l.this.A;
            if (progressDialog != null) {
                progressDialog.setProgress(i4);
            }
            ProgressCallback progressCallback = l.this.f35962y;
            if (progressCallback != null) {
                progressCallback.onProgress(j4, j5);
            }
            if (l.this.B != null) {
                AsyncServer.post(Ion.f35718z, new a(j4, j5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        AsyncHttpRequest f35973a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f35974b = this;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f35975c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35976d;

        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        class a implements FutureCallback<AsyncHttpRequest> {
            a() {
            }

            @Override // com.koushikdutta.async.future.FutureCallback
            /* renamed from: a */
            public void onCompleted(Exception exc, AsyncHttpRequest asyncHttpRequest) {
                if (exc != null) {
                    c.this.f35976d.setComplete(exc);
                    return;
                }
                c cVar = c.this;
                cVar.f35973a = asyncHttpRequest;
                cVar.f35974b.run();
            }
        }

        c(AsyncHttpRequest asyncHttpRequest, SimpleFuture simpleFuture) {
            this.f35975c = asyncHttpRequest;
            this.f35976d = simpleFuture;
            this.f35973a = asyncHttpRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Future<AsyncHttpRequest> I = l.this.I(this.f35973a);
            if (I == null) {
                this.f35976d.setComplete((SimpleFuture) this.f35973a);
            } else {
                I.setCallback(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class d implements FutureCallback<AsyncHttpRequest> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f35979a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f35980b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                l.this.q(dVar.f35980b, dVar.f35979a);
            }
        }

        d(i iVar, AsyncHttpRequest asyncHttpRequest) {
            this.f35979a = iVar;
            this.f35980b = asyncHttpRequest;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpRequest asyncHttpRequest) {
            if (exc != null) {
                this.f35979a.setComplete(exc);
                return;
            }
            this.f35979a.f35998j = asyncHttpRequest;
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                AsyncServer.post(Ion.f35718z, new a());
            } else {
                l.this.q(this.f35980b, this.f35979a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class e<T> extends i<T> {

        /* renamed from: p  reason: collision with root package name */
        i<T> f35983p;

        /* renamed from: q  reason: collision with root package name */
        final /* synthetic */ boolean f35984q;

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ DataSink f35985r;

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ Object f35986s;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class a implements CompletedCallback {
            a() {
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                e eVar = e.this;
                l.this.y(eVar.f35983p, exc, eVar.f35986s);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Runnable runnable, boolean z3, DataSink dataSink, Object obj) {
            super(runnable);
            this.f35984q = z3;
            this.f35985r = dataSink;
            this.f35986s = obj;
            this.f35983p = this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void b() {
            super.b();
            if (this.f35984q) {
                this.f35985r.end();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: m */
        public void k(Loader.LoaderEmitter loaderEmitter) throws Exception {
            super.m(loaderEmitter);
            Util.pump(this.f36002n, this.f35985r, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class f<T> extends i<T> {

        /* renamed from: p  reason: collision with root package name */
        i<T> f35989p;

        /* renamed from: q  reason: collision with root package name */
        final /* synthetic */ AsyncParser f35990q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class a implements FutureCallback<T> {
            a() {
            }

            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, T t3) {
                f fVar = f.this;
                l.this.y(fVar.f35989p, exc, t3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Runnable runnable, AsyncParser asyncParser) {
            super(runnable);
            this.f35990q = asyncParser;
            this.f35989p = this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: m */
        public void k(Loader.LoaderEmitter loaderEmitter) throws Exception {
            super.m(loaderEmitter);
            this.f35990q.parse(this.f36002n).setCallback(new a());
        }
    }

    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    class g implements AsyncParser<byte[]> {

        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        class a extends TransformFuture<byte[], ByteBufferList> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.koushikdutta.async.future.TransformFuture
            /* renamed from: l */
            public void k(ByteBufferList byteBufferList) throws Exception {
                setComplete((a) byteBufferList.getAllByteArray());
            }
        }

        g() {
        }

        @Override // com.koushikdutta.async.parser.AsyncParser
        /* renamed from: a */
        public void write(DataSink dataSink, byte[] bArr, CompletedCallback completedCallback) {
            new ByteBufferListParser().write(dataSink, new ByteBufferList(bArr), completedCallback);
        }

        @Override // com.koushikdutta.async.parser.AsyncParser
        public Type getType() {
            return byte[].class;
        }

        @Override // com.koushikdutta.async.parser.AsyncParser
        public Future<byte[]> parse(DataEmitter dataEmitter) {
            return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f35995a;

        h(File file) {
            this.f35995a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f35995a.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class i<T> extends TransformFuture<T, Loader.LoaderEmitter> implements ResponseFuture<T> {

        /* renamed from: i  reason: collision with root package name */
        AsyncHttpRequest f35997i;

        /* renamed from: j  reason: collision with root package name */
        AsyncHttpRequest f35998j;

        /* renamed from: k  reason: collision with root package name */
        ResponseServedFrom f35999k;

        /* renamed from: l  reason: collision with root package name */
        Runnable f36000l;

        /* renamed from: m  reason: collision with root package name */
        HeadersResponse f36001m;

        /* renamed from: n  reason: collision with root package name */
        DataEmitter f36002n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class a implements FutureCallback<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SimpleFuture f36004a;

            a(SimpleFuture simpleFuture) {
                this.f36004a = simpleFuture;
            }

            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, T t3) {
                i iVar = i.this;
                if (iVar.f36002n != null) {
                    this.f36004a.setComplete((SimpleFuture) iVar.l(exc, t3));
                } else {
                    this.f36004a.setComplete(exc, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ HeadersResponse f36006a;

            b(HeadersResponse headersResponse) {
                this.f36006a = headersResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.C.onHeaders(this.f36006a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: IonRequestBuilder.java */
        /* loaded from: classes6.dex */
        public class c implements DataTrackingEmitter.DataTracker {

            /* renamed from: a  reason: collision with root package name */
            int f36008a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f36009b;

            /* compiled from: IonRequestBuilder.java */
            /* loaded from: classes6.dex */
            class a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ int f36011a;

                a(int i4) {
                    this.f36011a = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ProgressDialog progressDialog;
                    ProgressBar progressBar;
                    if (!i.this.isCancelled() && !i.this.isDone()) {
                        WeakReference<ProgressBar> weakReference = l.this.f35951n;
                        if (weakReference != null && (progressBar = weakReference.get()) != null) {
                            progressBar.setProgress(this.f36011a);
                        }
                        WeakReference<ProgressDialog> weakReference2 = l.this.f35952o;
                        if (weakReference2 != null && (progressDialog = weakReference2.get()) != null) {
                            progressDialog.setProgress(this.f36011a);
                        }
                    }
                }
            }

            /* compiled from: IonRequestBuilder.java */
            /* loaded from: classes6.dex */
            class b implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ int f36013a;

                b(int i4) {
                    this.f36013a = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!i.this.isCancelled() && !i.this.isDone()) {
                        c cVar = c.this;
                        l.this.f35954q.onProgress(this.f36013a, cVar.f36009b);
                    }
                }
            }

            c(long j4) {
                this.f36009b = j4;
            }

            @Override // com.koushikdutta.async.DataTrackingEmitter.DataTracker
            public void onData(int i4) {
                if (l.this.f35939b.c() != null) {
                    i.this.f35997i.logd("context has died, cancelling");
                    i.this.cancelSilently();
                    return;
                }
                int i5 = (int) ((i4 / ((float) this.f36009b)) * 100.0f);
                l lVar = l.this;
                if ((lVar.f35951n != null || lVar.f35952o != null) && i5 != this.f36008a) {
                    AsyncServer.post(Ion.f35718z, new a(i5));
                }
                this.f36008a = i5;
                ProgressCallback progressCallback = l.this.f35953p;
                if (progressCallback != null) {
                    progressCallback.onProgress(i4, this.f36009b);
                }
                if (l.this.f35954q != null) {
                    AsyncServer.post(Ion.f35718z, new b(i4));
                }
            }
        }

        public i(Runnable runnable) {
            this.f36000l = runnable;
            l.this.f35938a.c(this, l.this.f35939b.b());
            ArrayList<WeakReference<Object>> arrayList = l.this.f35959v;
            if (arrayList == null) {
                return;
            }
            Iterator<WeakReference<Object>> it = arrayList.iterator();
            while (it.hasNext()) {
                Object obj = it.next().get();
                if (obj != null) {
                    l.this.f35938a.c(this, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void a() {
            super.a();
            DataEmitter dataEmitter = this.f36002n;
            if (dataEmitter != null) {
                dataEmitter.close();
            }
            Runnable runnable = this.f36000l;
            if (runnable != null) {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        public void j(Exception exc) {
            l.this.y(this, exc, null);
        }

        public Response<T> l(Exception exc, T t3) {
            return new Response<>(this.f35998j, this.f35999k, this.f36001m, exc, t3);
        }

        protected void m(Loader.LoaderEmitter loaderEmitter) throws Exception {
            DataTrackingEmitter dataTrackingEmitter;
            this.f36002n = loaderEmitter.getDataEmitter();
            this.f35999k = loaderEmitter.getServedFrom();
            this.f36001m = loaderEmitter.getHeaders();
            this.f35998j = loaderEmitter.getRequest();
            if (l.this.C != null) {
                AsyncServer.post(l.this.f35940c, new b(loaderEmitter.getHeaders()));
            }
            long length = loaderEmitter.length();
            DataEmitter dataEmitter = this.f36002n;
            if (!(dataEmitter instanceof DataTrackingEmitter)) {
                dataTrackingEmitter = new FilteredDataEmitter();
                dataTrackingEmitter.setDataEmitter(this.f36002n);
            } else {
                dataTrackingEmitter = (DataTrackingEmitter) dataEmitter;
            }
            this.f36002n = dataTrackingEmitter;
            dataTrackingEmitter.setDataTracker(new c(length));
        }

        @Override // com.koushikdutta.ion.future.ResponseFuture
        public Future<Response<T>> withResponse() {
            SimpleFuture simpleFuture = new SimpleFuture();
            setCallback((FutureCallback) new a(simpleFuture));
            simpleFuture.setParent((Cancellable) this);
            return simpleFuture;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonRequestBuilder.java */
    /* loaded from: classes6.dex */
    public interface j {
        boolean a(AsyncHttpRequest asyncHttpRequest);
    }

    public l(com.koushikdutta.ion.d dVar, Ion ion) {
        String c4 = dVar.c();
        if (c4 != null) {
            Log.w("Ion", "Building request with dead context: " + c4);
        }
        this.f35938a = ion;
        this.f35939b = dVar;
    }

    private Uri A() {
        Uri uri;
        try {
            if (this.f35946i != null) {
                Uri.Builder buildUpon = Uri.parse(this.f35942e).buildUpon();
                for (String str : this.f35946i.keySet()) {
                    for (String str2 : this.f35946i.get(str)) {
                        buildUpon = buildUpon.appendQueryParameter(str, str2);
                    }
                }
                uri = buildUpon.build();
            } else {
                uri = Uri.parse(this.f35942e);
            }
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null || uri.getScheme() == null) {
            return null;
        }
        return uri;
    }

    private <T> l J(AsyncHttpRequestBody<T> asyncHttpRequestBody) {
        if (!this.f35943f) {
            this.f35941d = "POST";
        }
        this.f35948k = asyncHttpRequestBody;
        return this;
    }

    private Headers n() {
        Uri parse;
        if (this.f35944g == null) {
            Headers headers = new Headers();
            this.f35944g = headers;
            String str = this.f35942e;
            if (str == null) {
                parse = null;
            } else {
                parse = Uri.parse(str);
            }
            AsyncHttpRequest.setDefaultHeaders(headers, parse);
        }
        return this.f35944g;
    }

    private <T> void o(i<T> iVar) {
        Uri A = A();
        if (A == null) {
            iVar.setComplete(new Exception("Invalid URI"));
            return;
        }
        AsyncHttpRequest z3 = z(A);
        iVar.f35997i = z3;
        p(iVar, z3);
    }

    private <T> void p(i<T> iVar, AsyncHttpRequest asyncHttpRequest) {
        AsyncHttpRequestBody asyncHttpRequestBody = this.f35948k;
        if (asyncHttpRequestBody != null && (this.B != null || this.f35963z != null || this.f35962y != null || this.A != null)) {
            asyncHttpRequest.setBody(new o(asyncHttpRequestBody, new b(iVar)));
        }
        H(asyncHttpRequest, iVar);
    }

    private l u(String str, String str2) {
        this.f35941d = str;
        if (!TextUtils.isEmpty(str2) && str2.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str2 = new File(str2).toURI().toString();
        }
        this.f35942e = str2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void y(i<T> iVar, Exception exc, T t3) {
        a aVar = new a(iVar, exc, t3);
        Handler handler = this.f35940c;
        if (handler == null) {
            this.f35938a.f35719a.getServer().post(aVar);
        } else {
            AsyncServer.post(handler, aVar);
        }
    }

    private AsyncHttpRequest z(Uri uri) {
        AsyncHttpRequest createAsyncHttpRequest = this.f35938a.configure().getAsyncHttpRequestFactory().createAsyncHttpRequest(uri, this.f35941d, this.f35944g);
        createAsyncHttpRequest.setFollowRedirect(this.f35949l);
        createAsyncHttpRequest.setBody(this.f35948k);
        Ion ion = this.f35938a;
        createAsyncHttpRequest.setLogging(ion.f35731m, ion.f35732n);
        String str = this.f35957t;
        if (str != null) {
            createAsyncHttpRequest.setLogging(str, this.f35958u);
        }
        createAsyncHttpRequest.enableProxy(this.f35960w, this.f35961x);
        createAsyncHttpRequest.setTimeout(this.f35947j);
        createAsyncHttpRequest.logd("preparing request");
        return createAsyncHttpRequest;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: B */
    public l progress(ProgressCallback progressCallback) {
        this.f35953p = progressCallback;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: C */
    public l progressBar(ProgressBar progressBar) {
        this.f35951n = new WeakReference<>(progressBar);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: D */
    public l progressDialog(ProgressDialog progressDialog) {
        this.f35952o = new WeakReference<>(progressDialog);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: E */
    public l progressHandler(ProgressCallback progressCallback) {
        this.f35954q = progressCallback;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: F */
    public l proxy(String str, int i4) {
        this.f35960w = str;
        this.f35961x = i4;
        return this;
    }

    Future<AsyncHttpRequest> G(AsyncHttpRequest asyncHttpRequest) {
        SimpleFuture simpleFuture = new SimpleFuture();
        new c(asyncHttpRequest, simpleFuture).run();
        return simpleFuture;
    }

    <T> void H(AsyncHttpRequest asyncHttpRequest, i<T> iVar) {
        G(asyncHttpRequest).setCallback(new d(iVar, asyncHttpRequest));
    }

    <T> Future<AsyncHttpRequest> I(AsyncHttpRequest asyncHttpRequest) {
        Iterator<Loader> it = this.f35938a.f35735q.iterator();
        while (it.hasNext()) {
            Future<AsyncHttpRequest> resolve = it.next().resolve(this.f35939b.b(), this.f35938a, asyncHttpRequest);
            if (resolve != null) {
                return resolve;
            }
        }
        return null;
    }

    @Override // com.koushikdutta.ion.builder.UrlEncodedBuilder
    /* renamed from: K */
    public l setBodyParameter(String str, String str2) {
        if (this.f35955r == null) {
            Multimap multimap = new Multimap();
            this.f35955r = multimap;
            J(new UrlEncodedFormBody(multimap));
        }
        if (str2 != null) {
            this.f35955r.add(str, str2);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.UrlEncodedBuilder
    /* renamed from: L */
    public l setBodyParameters(Map<String, List<String>> map) {
        if (this.f35955r == null) {
            Multimap multimap = new Multimap();
            this.f35955r = multimap;
            J(new UrlEncodedFormBody(multimap));
        }
        this.f35955r.putAll(map);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: M */
    public Builders.Any.F setByteArrayBody(byte[] bArr) {
        if (bArr != null) {
            J(new StreamBody(new ByteArrayInputStream(bArr), bArr.length));
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: N */
    public Builders.Any.F setDocumentBody(Document document) {
        J(new DocumentBody(document));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: O */
    public Builders.Any.F setFileBody(File file) {
        J(new FileBody(file));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: P */
    public l setHandler(Handler handler) {
        this.f35940c = handler;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: Q */
    public l setHeader(String str, String str2) {
        if (str2 == null) {
            n().removeAll(str);
        } else {
            n().set(str, str2);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: R */
    public Builders.Any.B setHeader(NameValuePair... nameValuePairArr) {
        Headers n4 = n();
        for (NameValuePair nameValuePair : nameValuePairArr) {
            n4.set(nameValuePair.getName(), nameValuePair.getValue());
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: S */
    public l setJsonArrayBody(JsonArray jsonArray) {
        return J(new GsonBody(this.f35938a.configure().getGson(), jsonArray));
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: T */
    public l setJsonObjectBody(JsonObject jsonObject) {
        return J(new GsonBody(this.f35938a.configure().getGson(), jsonObject));
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: U */
    public l setJsonPojoBody(Object obj) {
        J(new PojoBody(this.f35938a.configure().getGson(), obj, null));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: V */
    public l setJsonPojoBody(Object obj, TypeToken typeToken) {
        J(new PojoBody(this.f35938a.configure().getGson(), obj, typeToken));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: W */
    public l setLogging(String str, int i4) {
        this.f35957t = str;
        this.f35958u = i4;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: X */
    public l setMultipartContentType(String str) {
        if (this.f35956s == null) {
            MultipartFormDataBody multipartFormDataBody = new MultipartFormDataBody();
            this.f35956s = multipartFormDataBody;
            J(multipartFormDataBody);
        }
        this.f35956s.setContentType(str);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: Y */
    public l setMultipartFile(String str, File file) {
        return setMultipartFile(str, null, file);
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: Z */
    public l setMultipartFile(String str, String str2, File file) {
        if (this.f35956s == null) {
            MultipartFormDataBody multipartFormDataBody = new MultipartFormDataBody();
            this.f35956s = multipartFormDataBody;
            J(multipartFormDataBody);
        }
        FilePart filePart = new FilePart(str, file);
        if (str2 == null) {
            str2 = AsyncHttpServer.tryGetContentType(file.getAbsolutePath());
        }
        if (str2 != null) {
            filePart.setContentType(str2);
        }
        this.f35956s.addPart(filePart);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: a0 */
    public l setMultipartParameter(String str, String str2) {
        if (this.f35956s == null) {
            MultipartFormDataBody multipartFormDataBody = new MultipartFormDataBody();
            this.f35956s = multipartFormDataBody;
            J(multipartFormDataBody);
        }
        if (str2 != null) {
            this.f35956s.addStringPart(str, str2);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public <T> ResponseFuture<T> as(AsyncParser<T> asyncParser) {
        return k(asyncParser);
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public Future<Bitmap> asBitmap() {
        return new IonImageViewRequestBuilder(this).asBitmap();
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<byte[]> asByteArray() {
        return k(new g());
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public BitmapInfo asCachedBitmap() {
        return new IonImageViewRequestBuilder(this).asCachedBitmap();
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<DataEmitter> asDataEmitter() {
        return k(new com.koushikdutta.ion.e());
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<Document> asDocument() {
        return k(new DocumentParser());
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<InputStream> asInputStream() {
        return k(new com.koushikdutta.ion.h());
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public ResponseFuture<JsonArray> asJsonArray() {
        return k(new GsonArrayParser());
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public ResponseFuture<JsonObject> asJsonObject() {
        return k(new GsonObjectParser());
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<String> asString() {
        return k(new StringParser());
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: b */
    public l addHeader(String str, String str2) {
        if (str2 != null) {
            n().add(str, str2);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: b0 */
    public l setMultipartParameters(Map<String, List<String>> map) {
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                if (str2 != null) {
                    setMultipartParameter(str, str2);
                }
            }
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: c */
    public l addHeaders(Map<String, List<String>> map) {
        if (map == null) {
            return this;
        }
        Headers n4 = n();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            n4.addAll(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: c0 */
    public l setStringBody(String str) {
        return J(new StringBody(str));
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: d */
    public l addMultipartParts(Iterable<Part> iterable) {
        if (this.f35956s == null) {
            MultipartFormDataBody multipartFormDataBody = new MultipartFormDataBody();
            this.f35956s = multipartFormDataBody;
            J(multipartFormDataBody);
        }
        for (Part part : iterable) {
            this.f35956s.addPart(part);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: d0 */
    public l setTimeout(int i4) {
        this.f35947j = i4;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.MultipartBodyBuilder
    /* renamed from: e */
    public Builders.Any.M addMultipartParts(Part... partArr) {
        if (this.f35956s == null) {
            MultipartFormDataBody multipartFormDataBody = new MultipartFormDataBody();
            this.f35956s = multipartFormDataBody;
            J(multipartFormDataBody);
        }
        for (Part part : partArr) {
            this.f35956s.addPart(part);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: e0 */
    public Builders.Any.B uploadProgress(ProgressCallback progressCallback) {
        this.f35962y = progressCallback;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: f */
    public l addQueries(Map<String, List<String>> map) {
        if (this.f35946i == null) {
            this.f35946i = new Multimap();
        }
        this.f35946i.putAll(map);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: f0 */
    public Builders.Any.B uploadProgressBar(ProgressBar progressBar) {
        this.f35963z = progressBar;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: g */
    public l addQuery(String str, String str2) {
        if (str2 == null) {
            return this;
        }
        if (this.f35946i == null) {
            this.f35946i = new Multimap();
        }
        this.f35946i.add(str, str2);
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: g0 */
    public Builders.Any.B uploadProgressDialog(ProgressDialog progressDialog) {
        this.A = progressDialog;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public FutureBuilder group(Object obj) {
        if (this.f35959v == null) {
            this.f35959v = new ArrayList<>();
        }
        this.f35959v.add(new WeakReference<>(obj));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: h */
    public l basicAuthentication(String str, String str2) {
        return setHeader("Authorization", "Basic " + Base64.encodeToString(String.format("%s:%s", str, str2).getBytes(), 2));
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: h0 */
    public Builders.Any.B uploadProgressHandler(ProgressCallback progressCallback) {
        this.B = progressCallback;
        return this;
    }

    <T> i<T> i(DataSink dataSink, boolean z3, T t3) {
        return j(dataSink, z3, t3, null);
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: i0 */
    public l userAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        return setHeader("User-Agent", str);
    }

    @Override // com.koushikdutta.ion.builder.ImageViewFutureBuilder
    public ImageViewFuture intoImageView(ImageView imageView) {
        return new IonImageViewRequestBuilder(this).m(imageView).intoImageView(imageView);
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public LocallyCachedStatus isLocallyCached() {
        return new IonImageViewRequestBuilder(this).isLocallyCached();
    }

    <T> i<T> j(DataSink dataSink, boolean z3, T t3, Runnable runnable) {
        e eVar = new e(runnable, z3, dataSink, t3);
        o(eVar);
        return eVar;
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    /* renamed from: j0 */
    public IonImageViewRequestBuilder withBitmap() {
        return new IonImageViewRequestBuilder(this);
    }

    <T> ResponseFuture<T> k(AsyncParser<T> asyncParser) {
        return l(asyncParser, null);
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    /* renamed from: k0 */
    public i<File> write(File file) {
        return j(new FileDataSink(this.f35938a.getServer(), file), true, file, new h(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> ResponseFuture<T> l(AsyncParser<T> asyncParser, Runnable runnable) {
        AsyncHttpRequest asyncHttpRequest;
        Uri A = A();
        if (A != null) {
            asyncHttpRequest = z(A);
            Type type = asyncParser.getType();
            Iterator<Loader> it = this.f35938a.f35735q.iterator();
            while (it.hasNext()) {
                ResponseFuture<T> load = it.next().load(this.f35938a, asyncHttpRequest, type);
                if (load != null) {
                    return load;
                }
            }
        } else {
            asyncHttpRequest = null;
        }
        f fVar = new f(runnable, asyncParser);
        if (A == null) {
            fVar.setComplete(new Exception("Invalid URI"));
            return fVar;
        }
        fVar.f35997i = asyncHttpRequest;
        o(fVar);
        return fVar;
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: m */
    public l followRedirect(boolean z3) {
        this.f35949l = z3;
        return this;
    }

    <T> void q(AsyncHttpRequest asyncHttpRequest, i<T> iVar) {
        j jVar = this.f35950m;
        if (jVar == null || jVar.a(asyncHttpRequest)) {
            v(asyncHttpRequest, iVar);
        }
    }

    @Override // com.koushikdutta.ion.builder.LoadBuilder
    /* renamed from: r */
    public l load(File file) {
        u(null, file.toURI().toString());
        return this;
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public void removeCachedBitmap() {
        new IonImageViewRequestBuilder(this).removeCachedBitmap();
    }

    @Override // com.koushikdutta.ion.builder.LoadBuilder
    /* renamed from: s */
    public l load(String str) {
        return u("GET", str);
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    public Builders.Any.F setStreamBody(InputStream inputStream) {
        J(new StreamBody(inputStream, -1));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.LoadBuilder
    /* renamed from: t */
    public l load(String str, String str2) {
        this.f35943f = true;
        return u(str, str2);
    }

    <T> void v(AsyncHttpRequest asyncHttpRequest, i<T> iVar) {
        Iterator<Loader> it = this.f35938a.f35735q.iterator();
        while (it.hasNext()) {
            Loader next = it.next();
            Future<DataEmitter> load = next.load(this.f35938a, asyncHttpRequest, iVar);
            if (load != null) {
                asyncHttpRequest.logi("Using loader: " + next);
                iVar.setParent((Cancellable) load);
                return;
            }
        }
        iVar.setComplete(new Exception("Unknown uri scheme"));
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: w */
    public Builders.Any.B noCache() {
        this.f35945h = true;
        return setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    /* renamed from: x */
    public Builders.Any.B onHeaders(HeadersCallback headersCallback) {
        this.C = headersCallback;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public <T> ResponseFuture<T> as(Class<T> cls) {
        return k(new GsonSerializer(this.f35938a.configure().getGson(), cls));
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public ResponseFuture<JsonArray> asJsonArray(Charset charset) {
        return k(new GsonArrayParser(charset));
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public ResponseFuture<JsonObject> asJsonObject(Charset charset) {
        return k(new GsonObjectParser(charset));
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public ResponseFuture<String> asString(Charset charset) {
        return k(new StringParser(charset));
    }

    @Override // com.koushikdutta.ion.builder.RequestBuilder
    public Builders.Any.F setStreamBody(InputStream inputStream, int i4) {
        J(new StreamBody(inputStream, i4));
        return this;
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public <F extends OutputStream> ResponseFuture<F> write(F f4, boolean z3) {
        return i(new OutputStreamDataSink(this.f35938a.getServer(), f4), z3, f4);
    }

    @Override // com.koushikdutta.ion.builder.GsonFutureBuilder
    public <T> ResponseFuture<T> as(TypeToken<T> typeToken) {
        return k(new GsonSerializer(this.f35938a.configure().getGson(), typeToken));
    }

    @Override // com.koushikdutta.ion.builder.FutureBuilder
    public <F extends OutputStream> ResponseFuture<F> write(F f4) {
        return i(new OutputStreamDataSink(this.f35938a.getServer(), f4), true, f4);
    }
}
