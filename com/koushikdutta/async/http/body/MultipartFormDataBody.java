package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Continuation;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.BoundaryEmitter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes6.dex */
public class MultipartFormDataBody extends BoundaryEmitter implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "multipart/form-data";

    /* renamed from: j  reason: collision with root package name */
    LineEmitter f35116j;

    /* renamed from: k  reason: collision with root package name */
    Headers f35117k;

    /* renamed from: l  reason: collision with root package name */
    ByteBufferList f35118l;

    /* renamed from: m  reason: collision with root package name */
    String f35119m;

    /* renamed from: n  reason: collision with root package name */
    String f35120n = "multipart/form-data";

    /* renamed from: o  reason: collision with root package name */
    MultipartCallback f35121o;

    /* renamed from: p  reason: collision with root package name */
    int f35122p;

    /* renamed from: q  reason: collision with root package name */
    int f35123q;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<Part> f35124r;

    /* loaded from: classes6.dex */
    public interface MultipartCallback {
        void onPart(Part part);
    }

    /* loaded from: classes6.dex */
    class a implements LineEmitter.StringCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Headers f35125a;

        /* renamed from: com.koushikdutta.async.http.body.MultipartFormDataBody$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0189a implements DataCallback {
            C0189a() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                byteBufferList.get(MultipartFormDataBody.this.f35118l);
            }
        }

        a(Headers headers) {
            this.f35125a = headers;
        }

        @Override // com.koushikdutta.async.LineEmitter.StringCallback
        public void onStringAvailable(String str) {
            if (!"\r".equals(str)) {
                this.f35125a.addLine(str);
                return;
            }
            MultipartFormDataBody.this.d();
            MultipartFormDataBody multipartFormDataBody = MultipartFormDataBody.this;
            multipartFormDataBody.f35116j = null;
            multipartFormDataBody.setDataCallback(null);
            Part part = new Part(this.f35125a);
            MultipartCallback multipartCallback = MultipartFormDataBody.this.f35121o;
            if (multipartCallback != null) {
                multipartCallback.onPart(part);
            }
            if (MultipartFormDataBody.this.getDataCallback() == null) {
                if (part.isFile()) {
                    MultipartFormDataBody.this.setDataCallback(new DataCallback.NullDataCallback());
                    return;
                }
                MultipartFormDataBody.this.f35119m = part.getName();
                MultipartFormDataBody.this.f35118l = new ByteBufferList();
                MultipartFormDataBody.this.setDataCallback(new C0189a());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35128a;

        b(CompletedCallback completedCallback) {
            this.f35128a = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            this.f35128a.onCompleted(exc);
        }
    }

    /* loaded from: classes6.dex */
    class c implements ContinuationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataSink f35130a;

        c(DataSink dataSink) {
            this.f35130a = dataSink;
        }

        @Override // com.koushikdutta.async.callback.ContinuationCallback
        public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
            byte[] bytes = "\r\n".getBytes();
            Util.writeAll(this.f35130a, bytes, completedCallback);
            MultipartFormDataBody.this.f35122p += bytes.length;
        }
    }

    /* loaded from: classes6.dex */
    class d implements ContinuationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Part f35132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DataSink f35133b;

        d(Part part, DataSink dataSink) {
            this.f35132a = part;
            this.f35133b = dataSink;
        }

        @Override // com.koushikdutta.async.callback.ContinuationCallback
        public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
            long length = this.f35132a.length();
            if (length >= 0) {
                MultipartFormDataBody multipartFormDataBody = MultipartFormDataBody.this;
                multipartFormDataBody.f35122p = (int) (multipartFormDataBody.f35122p + length);
            }
            this.f35132a.write(this.f35133b, completedCallback);
        }
    }

    /* loaded from: classes6.dex */
    class e implements ContinuationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Part f35135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DataSink f35136b;

        e(Part part, DataSink dataSink) {
            this.f35135a = part;
            this.f35136b = dataSink;
        }

        @Override // com.koushikdutta.async.callback.ContinuationCallback
        public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
            byte[] bytes = this.f35135a.getRawHeaders().toPrefixString(MultipartFormDataBody.this.getBoundaryStart()).getBytes();
            Util.writeAll(this.f35136b, bytes, completedCallback);
            MultipartFormDataBody.this.f35122p += bytes.length;
        }
    }

    /* loaded from: classes6.dex */
    class f implements ContinuationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataSink f35138a;

        f(DataSink dataSink) {
            this.f35138a = dataSink;
        }

        @Override // com.koushikdutta.async.callback.ContinuationCallback
        public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
            byte[] bytes = MultipartFormDataBody.this.getBoundaryEnd().getBytes();
            Util.writeAll(this.f35138a, bytes, completedCallback);
            MultipartFormDataBody.this.f35122p += bytes.length;
        }
    }

    public MultipartFormDataBody(String[] strArr) {
        for (String str : strArr) {
            String[] split = str.split("=");
            if (split.length == 2 && "boundary".equals(split[0])) {
                setBoundary(split[1]);
                return;
            }
        }
        a(new Exception("No boundary found for multipart/form-data"));
    }

    public void addFilePart(String str, File file) {
        addPart(new FilePart(str, file));
    }

    public void addPart(Part part) {
        if (this.f35124r == null) {
            this.f35124r = new ArrayList<>();
        }
        this.f35124r.add(part);
    }

    public void addStringPart(String str, String str2) {
        addPart(new StringPart(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.http.server.BoundaryEmitter
    public void b() {
        super.b();
        d();
    }

    @Override // com.koushikdutta.async.http.server.BoundaryEmitter
    protected void c() {
        Headers headers = new Headers();
        LineEmitter lineEmitter = new LineEmitter();
        this.f35116j = lineEmitter;
        lineEmitter.setLineCallback(new a(headers));
        setDataCallback(this.f35116j);
    }

    void d() {
        if (this.f35118l == null) {
            return;
        }
        if (this.f35117k == null) {
            this.f35117k = new Headers();
        }
        this.f35117k.add(this.f35119m, this.f35118l.peekString());
        this.f35119m = null;
        this.f35118l = null;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        return this.f35120n + "; boundary=" + getBoundary();
    }

    public String getField(String str) {
        Headers headers = this.f35117k;
        if (headers == null) {
            return null;
        }
        return headers.get(str);
    }

    public MultipartCallback getMultipartCallback() {
        return this.f35121o;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        Iterator<Part> it = this.f35124r.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Part next = it.next();
            String prefixString = next.getRawHeaders().toPrefixString(getBoundaryStart());
            if (next.length() == -1) {
                return -1;
            }
            i4 = (int) (i4 + next.length() + prefixString.getBytes().length + 2);
        }
        int length = i4 + getBoundaryEnd().getBytes().length;
        this.f35123q = length;
        return length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        setDataEmitter(dataEmitter);
        setEndCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return false;
    }

    public void setContentType(String str) {
        this.f35120n = str;
    }

    public void setMultipartCallback(MultipartCallback multipartCallback) {
        this.f35121o = multipartCallback;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f35124r == null) {
            return;
        }
        Continuation continuation = new Continuation(new b(completedCallback));
        Iterator<Part> it = this.f35124r.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            continuation.add(new e(next, dataSink)).add(new d(next, dataSink)).add(new c(dataSink));
        }
        continuation.add(new f(dataSink));
        continuation.start();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Multimap get() {
        return new Multimap(this.f35117k.getMultiMap());
    }

    public MultipartFormDataBody() {
    }
}
