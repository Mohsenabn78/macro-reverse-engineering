package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class UrlEncodedFormBody implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /* renamed from: a  reason: collision with root package name */
    private Multimap f35151a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f35152b;

    /* loaded from: classes6.dex */
    class a implements DataCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f35153a;

        a(ByteBufferList byteBufferList) {
            this.f35153a = byteBufferList;
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byteBufferList.get(this.f35153a);
        }
    }

    /* loaded from: classes6.dex */
    class b implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35155a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f35156b;

        b(CompletedCallback completedCallback, ByteBufferList byteBufferList) {
            this.f35155a = completedCallback;
            this.f35156b = byteBufferList;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                this.f35155a.onCompleted(exc);
                return;
            }
            try {
                UrlEncodedFormBody.this.f35151a = Multimap.parseUrlEncoded(this.f35156b.readString());
                this.f35155a.onCompleted(null);
            } catch (Exception e4) {
                this.f35155a.onCompleted(e4);
            }
        }
    }

    public UrlEncodedFormBody(Multimap multimap) {
        this.f35151a = multimap;
    }

    private void b() {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<NameValuePair> it = this.f35151a.iterator();
            boolean z3 = true;
            while (it.hasNext()) {
                NameValuePair next = it.next();
                if (next.getValue() != null) {
                    if (!z3) {
                        sb.append(Typography.amp);
                    }
                    sb.append(URLEncoder.encode(next.getName(), "UTF-8"));
                    sb.append(SignatureVisitor.INSTANCEOF);
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    z3 = false;
                }
            }
            this.f35152b = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (this.f35152b == null) {
            b();
        }
        return this.f35152b.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        ByteBufferList byteBufferList = new ByteBufferList();
        dataEmitter.setDataCallback(new a(byteBufferList));
        dataEmitter.setEndCallback(new b(completedCallback, byteBufferList));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f35152b == null) {
            b();
        }
        Util.writeAll(dataSink, this.f35152b, completedCallback);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Multimap get() {
        return this.f35151a;
    }

    public UrlEncodedFormBody(List<NameValuePair> list) {
        this.f35151a = new Multimap(list);
    }

    public UrlEncodedFormBody() {
    }
}
