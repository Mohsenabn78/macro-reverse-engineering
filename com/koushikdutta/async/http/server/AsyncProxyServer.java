package com.koushikdutta.async.http.server;

import android.net.Uri;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;

/* loaded from: classes6.dex */
public class AsyncProxyServer extends AsyncHttpServer {

    /* renamed from: g  reason: collision with root package name */
    AsyncHttpClient f35361g;

    /* loaded from: classes6.dex */
    class a implements HttpConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpServerResponse f35362a;

        a(AsyncHttpServerResponse asyncHttpServerResponse) {
            this.f35362a = asyncHttpServerResponse;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
            if (exc != null) {
                this.f35362a.code(500);
                this.f35362a.send(exc.getMessage());
                return;
            }
            this.f35362a.proxy(asyncHttpResponse);
        }
    }

    public AsyncProxyServer(AsyncServer asyncServer) {
        this.f35361g = new AsyncHttpClient(asyncServer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.http.server.AsyncHttpServer
    public void b(HttpServerRequestCallback httpServerRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        int i4;
        Uri parse;
        super.b(httpServerRequestCallback, asyncHttpServerRequest, asyncHttpServerResponse);
        if (httpServerRequestCallback != null) {
            return;
        }
        try {
            try {
                parse = Uri.parse(asyncHttpServerRequest.getPath());
            } catch (Exception unused) {
                String str = asyncHttpServerRequest.getHeaders().get("Host");
                if (str != null) {
                    String[] split = str.split(":", 2);
                    if (split.length == 2) {
                        str = split[0];
                        i4 = Integer.parseInt(split[1]);
                        parse = Uri.parse("http://" + str + ":" + i4 + asyncHttpServerRequest.getPath());
                    }
                }
                i4 = 80;
                parse = Uri.parse("http://" + str + ":" + i4 + asyncHttpServerRequest.getPath());
            }
            if (parse.getScheme() == null) {
                throw new Exception("no host or full uri provided");
            }
            this.f35361g.execute(new AsyncHttpRequest(parse, asyncHttpServerRequest.getMethod(), asyncHttpServerRequest.getHeaders()), new a(asyncHttpServerResponse));
        } catch (Exception e4) {
            asyncHttpServerResponse.code(500);
            asyncHttpServerResponse.send(e4.getMessage());
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServer
    protected boolean c(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return true;
    }
}
