package com.koushikdutta.async.http;

import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import java.io.IOException;

/* loaded from: classes6.dex */
public class HttpTransportMiddleware extends SimpleMiddleware {

    /* loaded from: classes6.dex */
    class a implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35030a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BufferedDataSink f35031b;

        a(CompletedCallback completedCallback, BufferedDataSink bufferedDataSink) {
            this.f35030a = completedCallback;
            this.f35031b = bufferedDataSink;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            Util.end(this.f35030a, exc);
            BufferedDataSink bufferedDataSink = this.f35031b;
            if (bufferedDataSink != null) {
                bufferedDataSink.forceBuffering(false);
                this.f35031b.setMaxBuffer(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements LineEmitter.StringCallback {

        /* renamed from: a  reason: collision with root package name */
        Headers f35033a = new Headers();

        /* renamed from: b  reason: collision with root package name */
        String f35034b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnExchangeHeaderData f35035c;

        b(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
            this.f35035c = onExchangeHeaderData;
        }

        @Override // com.koushikdutta.async.LineEmitter.StringCallback
        public void onStringAvailable(String str) {
            String str2;
            DataEmitter bodyDecoder;
            try {
                String trim = str.trim();
                if (this.f35034b == null) {
                    this.f35034b = trim;
                } else if (!TextUtils.isEmpty(trim)) {
                    this.f35033a.addLine(trim);
                } else {
                    String[] split = this.f35034b.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 3);
                    if (split.length >= 2) {
                        this.f35035c.response.headers(this.f35033a);
                        String str3 = split[0];
                        this.f35035c.response.protocol(str3);
                        this.f35035c.response.code(Integer.parseInt(split[1]));
                        AsyncHttpClientMiddleware.ResponseHead responseHead = this.f35035c.response;
                        if (split.length == 3) {
                            str2 = split[2];
                        } else {
                            str2 = "";
                        }
                        responseHead.message(str2);
                        this.f35035c.receiveHeadersCallback.onCompleted(null);
                        AsyncSocket socket = this.f35035c.response.socket();
                        if (socket == null) {
                            return;
                        }
                        if ("HEAD".equalsIgnoreCase(this.f35035c.request.getMethod())) {
                            bodyDecoder = HttpUtil.a.c(socket.getServer(), null);
                        } else {
                            bodyDecoder = HttpUtil.getBodyDecoder(socket, Protocol.get(str3), this.f35033a, false);
                        }
                        this.f35035c.response.emitter(bodyDecoder);
                        return;
                    }
                    throw new Exception(new IOException("Not HTTP"));
                }
            } catch (Exception e4) {
                this.f35035c.receiveHeadersCallback.onCompleted(e4);
            }
        }
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public boolean exchangeHeaders(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        boolean z3;
        BufferedDataSink bufferedDataSink;
        BufferedDataSink bufferedDataSink2;
        Protocol protocol = Protocol.get(onExchangeHeaderData.protocol);
        if (protocol != null && protocol != Protocol.HTTP_1_0 && protocol != Protocol.HTTP_1_1) {
            return super.exchangeHeaders(onExchangeHeaderData);
        }
        AsyncHttpRequest asyncHttpRequest = onExchangeHeaderData.request;
        AsyncHttpRequestBody body = asyncHttpRequest.getBody();
        if (body != null) {
            if (body.length() >= 0) {
                asyncHttpRequest.getHeaders().set("Content-Length", String.valueOf(body.length()));
                onExchangeHeaderData.response.sink(onExchangeHeaderData.socket);
            } else if ("close".equals(asyncHttpRequest.getHeaders().get("Connection"))) {
                onExchangeHeaderData.response.sink(onExchangeHeaderData.socket);
            } else {
                asyncHttpRequest.getHeaders().set("Transfer-Encoding", "Chunked");
                onExchangeHeaderData.response.sink(new ChunkedOutputFilter(onExchangeHeaderData.socket));
            }
        }
        String prefixString = asyncHttpRequest.getHeaders().toPrefixString(asyncHttpRequest.getRequestLine().toString());
        byte[] bytes = prefixString.getBytes();
        if (body != null && body.length() >= 0 && body.length() + bytes.length < 1024) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            BufferedDataSink bufferedDataSink3 = new BufferedDataSink(onExchangeHeaderData.response.sink());
            bufferedDataSink3.forceBuffering(true);
            onExchangeHeaderData.response.sink(bufferedDataSink3);
            bufferedDataSink = bufferedDataSink3;
            bufferedDataSink2 = bufferedDataSink3;
        } else {
            bufferedDataSink = null;
            bufferedDataSink2 = onExchangeHeaderData.socket;
        }
        asyncHttpRequest.logv("\n" + prefixString);
        Util.writeAll(bufferedDataSink2, bytes, new a(onExchangeHeaderData.sendHeadersCallback, bufferedDataSink));
        b bVar = new b(onExchangeHeaderData);
        LineEmitter lineEmitter = new LineEmitter();
        onExchangeHeaderData.socket.setDataCallback(lineEmitter);
        lineEmitter.setLineCallback(bVar);
        return true;
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
        Protocol protocol = Protocol.get(onRequestSentData.protocol);
        if ((protocol == null || protocol == Protocol.HTTP_1_0 || protocol == Protocol.HTTP_1_1) && (onRequestSentData.response.sink() instanceof ChunkedOutputFilter)) {
            onRequestSentData.response.sink().end();
        }
    }
}
