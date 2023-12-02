package com.koushikdutta.async.http;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;

/* loaded from: classes6.dex */
public class SimpleMiddleware implements AsyncHttpClientMiddleware {
    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public boolean exchangeHeaders(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        return false;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        return null;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDataOnRequestSentData onBodyDataOnRequestSentData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedDataOnRequestSentData onHeadersReceivedDataOnRequestSentData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequest(AsyncHttpClientMiddleware.OnRequestData onRequestData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData) {
    }
}
