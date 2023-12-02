package com.koushikdutta.async.http.server;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AsyncHttpServerResponseImpl implements AsyncHttpServerResponse {

    /* renamed from: c  reason: collision with root package name */
    AsyncSocket f35344c;

    /* renamed from: d  reason: collision with root package name */
    AsyncHttpServerRequestImpl f35345d;

    /* renamed from: f  reason: collision with root package name */
    DataSink f35347f;

    /* renamed from: g  reason: collision with root package name */
    WritableCallback f35348g;

    /* renamed from: h  reason: collision with root package name */
    boolean f35349h;

    /* renamed from: i  reason: collision with root package name */
    boolean f35350i;

    /* renamed from: k  reason: collision with root package name */
    CompletedCallback f35352k;

    /* renamed from: a  reason: collision with root package name */
    private Headers f35342a = new Headers();

    /* renamed from: b  reason: collision with root package name */
    private long f35343b = -1;

    /* renamed from: e  reason: collision with root package name */
    boolean f35346e = false;

    /* renamed from: j  reason: collision with root package name */
    int f35351j = 200;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f35353a;

        /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServerResponseImpl$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0194a implements Runnable {
            RunnableC0194a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WritableCallback writeableCallback = AsyncHttpServerResponseImpl.this.getWriteableCallback();
                if (writeableCallback != null) {
                    writeableCallback.onWriteable();
                }
            }
        }

        a(boolean z3) {
            this.f35353a = z3;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                AsyncHttpServerResponseImpl.this.c(exc);
                return;
            }
            if (this.f35353a) {
                ChunkedOutputFilter chunkedOutputFilter = new ChunkedOutputFilter(AsyncHttpServerResponseImpl.this.f35344c);
                chunkedOutputFilter.setMaxBuffer(0);
                AsyncHttpServerResponseImpl.this.f35347f = chunkedOutputFilter;
            } else {
                AsyncHttpServerResponseImpl asyncHttpServerResponseImpl = AsyncHttpServerResponseImpl.this;
                asyncHttpServerResponseImpl.f35347f = asyncHttpServerResponseImpl.f35344c;
            }
            AsyncHttpServerResponseImpl asyncHttpServerResponseImpl2 = AsyncHttpServerResponseImpl.this;
            asyncHttpServerResponseImpl2.f35347f.setClosedCallback(asyncHttpServerResponseImpl2.f35352k);
            AsyncHttpServerResponseImpl asyncHttpServerResponseImpl3 = AsyncHttpServerResponseImpl.this;
            asyncHttpServerResponseImpl3.f35352k = null;
            asyncHttpServerResponseImpl3.f35347f.setWriteableCallback(asyncHttpServerResponseImpl3.f35348g);
            AsyncHttpServerResponseImpl asyncHttpServerResponseImpl4 = AsyncHttpServerResponseImpl.this;
            asyncHttpServerResponseImpl4.f35348g = null;
            if (asyncHttpServerResponseImpl4.f35349h) {
                asyncHttpServerResponseImpl4.end();
            } else {
                asyncHttpServerResponseImpl4.getServer().post(new RunnableC0194a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements CompletedCallback {
        b() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServerResponseImpl.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f35357a;

        c(InputStream inputStream) {
            this.f35357a = inputStream;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            StreamUtility.closeQuietly(this.f35357a);
            AsyncHttpServerResponseImpl.this.b();
        }
    }

    /* loaded from: classes6.dex */
    class d implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpResponse f35359a;

        d(AsyncHttpResponse asyncHttpResponse) {
            this.f35359a = asyncHttpResponse;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            this.f35359a.setEndCallback(new CompletedCallback.NullCompletedCallback());
            this.f35359a.setDataCallback(new DataCallback.NullDataCallback());
            AsyncHttpServerResponseImpl.this.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncHttpServerResponseImpl(AsyncSocket asyncSocket, AsyncHttpServerRequestImpl asyncHttpServerRequestImpl) {
        this.f35344c = asyncSocket;
        this.f35345d = asyncHttpServerRequestImpl;
        if (HttpUtil.isKeepAlive(Protocol.HTTP_1_1, asyncHttpServerRequestImpl.getHeaders())) {
            this.f35342a.set("Connection", "Keep-Alive");
        }
    }

    void a() {
        boolean z3;
        boolean z4;
        if (this.f35346e) {
            return;
        }
        this.f35346e = true;
        String str = this.f35342a.get("Transfer-Encoding");
        if ("".equals(str)) {
            this.f35342a.removeAll("Transfer-Encoding");
        }
        if (("Chunked".equalsIgnoreCase(str) || str == null) && !"close".equalsIgnoreCase(this.f35342a.get("Connection"))) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f35343b < 0) {
            String str2 = this.f35342a.get("Content-Length");
            if (!TextUtils.isEmpty(str2)) {
                this.f35343b = Long.valueOf(str2).longValue();
            }
        }
        if (this.f35343b < 0 && z3) {
            this.f35342a.set("Transfer-Encoding", "Chunked");
            z4 = true;
        } else {
            z4 = false;
        }
        Util.writeAll(this.f35344c, this.f35342a.toPrefixString(String.format(Locale.ENGLISH, "HTTP/1.1 %s %s", Integer.valueOf(this.f35351j), AsyncHttpServer.getResponseCodeDescription(this.f35351j))).getBytes(), new a(z4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f35350i = true;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public AsyncHttpServerResponse code(int i4) {
        this.f35351j = i4;
        return this;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse, com.koushikdutta.async.DataSink
    public void end() {
        if (this.f35349h) {
            return;
        }
        this.f35349h = true;
        boolean z3 = this.f35346e;
        if (z3 && this.f35347f == null) {
            return;
        }
        if (!z3) {
            this.f35342a.remove("Transfer-Encoding");
        }
        DataSink dataSink = this.f35347f;
        if (dataSink instanceof ChunkedOutputFilter) {
            ((ChunkedOutputFilter) dataSink).setMaxBuffer(Integer.MAX_VALUE);
            this.f35347f.write(new ByteBufferList());
            b();
        } else if (!this.f35346e) {
            if (!this.f35345d.getMethod().equalsIgnoreCase("HEAD")) {
                send("text/html", "");
                return;
            }
            writeHead();
            b();
        } else {
            b();
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        DataSink dataSink = this.f35347f;
        if (dataSink != null) {
            return dataSink.getClosedCallback();
        }
        return this.f35352k;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public Headers getHeaders() {
        return this.f35342a;
    }

    @Override // com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f35344c.getServer();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public AsyncSocket getSocket() {
        return this.f35344c;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        DataSink dataSink = this.f35347f;
        if (dataSink != null) {
            return dataSink.getWriteableCallback();
        }
        return this.f35348g;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        DataSink dataSink = this.f35347f;
        if (dataSink != null) {
            return dataSink.isOpen();
        }
        return this.f35344c.isOpen();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse, com.koushikdutta.async.callback.CompletedCallback
    public void onCompleted(Exception exc) {
        end();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void proxy(AsyncHttpResponse asyncHttpResponse) {
        code(asyncHttpResponse.code());
        asyncHttpResponse.headers().removeAll("Transfer-Encoding");
        asyncHttpResponse.headers().removeAll("Content-Encoding");
        asyncHttpResponse.headers().removeAll("Connection");
        getHeaders().addAll(asyncHttpResponse.headers());
        asyncHttpResponse.headers().set("Connection", "close");
        Util.pump(asyncHttpResponse, this, new d(asyncHttpResponse));
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void redirect(String str) {
        code(302);
        this.f35342a.set(HttpHeaders.LOCATION, str);
        end();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str, byte[] bArr) {
        this.f35343b = bArr.length;
        this.f35342a.set("Content-Length", Integer.toString(bArr.length));
        this.f35342a.set("Content-Type", str);
        Util.writeAll(this, bArr, new b());
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void sendFile(File file) {
        try {
            if (this.f35342a.get("Content-Type") == null) {
                this.f35342a.set("Content-Type", AsyncHttpServer.getContentType(file.getAbsolutePath()));
            }
            sendStream(new BufferedInputStream(new FileInputStream(file), 64000), file.length());
        } catch (FileNotFoundException unused) {
            code(404);
            end();
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void sendStream(InputStream inputStream, long j4) {
        long j5 = j4 - 1;
        String str = this.f35345d.getHeaders().get(HttpHeaders.RANGE);
        long j6 = 0;
        if (str != null) {
            String[] split = str.split("=");
            if (split.length == 2 && "bytes".equals(split[0])) {
                String[] split2 = split[1].split("-");
                try {
                    if (split2.length <= 2) {
                        if (!TextUtils.isEmpty(split2[0])) {
                            j6 = Long.parseLong(split2[0]);
                        }
                        if (split2.length == 2 && !TextUtils.isEmpty(split2[1])) {
                            j5 = Long.parseLong(split2[1]);
                        }
                        code(206);
                        getHeaders().set(HttpHeaders.CONTENT_RANGE, String.format(Locale.ENGLISH, "bytes %d-%d/%d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)));
                    } else {
                        throw new MalformedRangeException();
                    }
                } catch (Exception unused) {
                    code(416);
                    end();
                    return;
                }
            } else {
                code(416);
                end();
                return;
            }
        }
        try {
            if (j6 == inputStream.skip(j6)) {
                long j7 = (j5 - j6) + 1;
                this.f35343b = j7;
                this.f35342a.set("Content-Length", String.valueOf(j7));
                this.f35342a.set(HttpHeaders.ACCEPT_RANGES, "bytes");
                if (this.f35345d.getMethod().equals("HEAD")) {
                    writeHead();
                    b();
                    return;
                }
                Util.pump(inputStream, this.f35343b, this, new c(inputStream));
                return;
            }
            throw new StreamSkipException("skip failed to skip requested amount");
        } catch (Exception unused2) {
            code(500);
            end();
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        DataSink dataSink = this.f35347f;
        if (dataSink != null) {
            dataSink.setClosedCallback(completedCallback);
        } else {
            this.f35352k = completedCallback;
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void setContentType(String str) {
        this.f35342a.set("Content-Type", str);
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        DataSink dataSink = this.f35347f;
        if (dataSink != null) {
            dataSink.setWriteableCallback(writableCallback);
        } else {
            this.f35348g = writableCallback;
        }
    }

    public String toString() {
        if (this.f35342a == null) {
            return super.toString();
        }
        return this.f35342a.toPrefixString(String.format(Locale.ENGLISH, "HTTP/1.1 %s %s", Integer.valueOf(this.f35351j), AsyncHttpServer.getResponseCodeDescription(this.f35351j)));
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        DataSink dataSink;
        if (!this.f35346e) {
            a();
        }
        if (byteBufferList.remaining() == 0 || (dataSink = this.f35347f) == null) {
            return;
        }
        dataSink.write(byteBufferList);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void writeHead() {
        a();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public int code() {
        return this.f35351j;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str, String str2) {
        try {
            send(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str) {
        String str2 = this.f35342a.get("Content-Type");
        if (str2 == null) {
            str2 = "text/html; charset=utf-8";
        }
        send(str2, str);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(JSONObject jSONObject) {
        send("application/json; charset=utf-8", jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Exception exc) {
    }
}
