package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.util.UntypedHashtable;

/* loaded from: classes6.dex */
public interface AsyncHttpClientMiddleware {

    /* loaded from: classes6.dex */
    public static class GetSocketData extends OnRequestData {
        public ConnectCallback connectCallback;
        public String protocol;
        public Cancellable socketCancellable;
    }

    /* loaded from: classes6.dex */
    public static class OnBodyDataOnRequestSentData extends OnHeadersReceivedDataOnRequestSentData {
        public DataEmitter bodyEmitter;
    }

    /* loaded from: classes6.dex */
    public static class OnExchangeHeaderData extends GetSocketData {
        public CompletedCallback receiveHeadersCallback;
        public ResponseHead response;
        public CompletedCallback sendHeadersCallback;
        public AsyncSocket socket;
    }

    /* loaded from: classes6.dex */
    public static class OnHeadersReceivedDataOnRequestSentData extends OnRequestSentData {
    }

    /* loaded from: classes6.dex */
    public static class OnRequestData {
        public AsyncHttpRequest request;
        public UntypedHashtable state = new UntypedHashtable();
    }

    /* loaded from: classes6.dex */
    public static class OnRequestSentData extends OnExchangeHeaderData {
    }

    /* loaded from: classes6.dex */
    public static class OnResponseCompleteDataOnRequestSentData extends OnBodyDataOnRequestSentData {
        public Exception exception;
    }

    /* loaded from: classes6.dex */
    public interface ResponseHead {
        int code();

        ResponseHead code(int i4);

        DataEmitter emitter();

        ResponseHead emitter(DataEmitter dataEmitter);

        ResponseHead headers(Headers headers);

        Headers headers();

        ResponseHead message(String str);

        String message();

        ResponseHead protocol(String str);

        String protocol();

        DataSink sink();

        ResponseHead sink(DataSink dataSink);

        AsyncSocket socket();
    }

    boolean exchangeHeaders(OnExchangeHeaderData onExchangeHeaderData);

    Cancellable getSocket(GetSocketData getSocketData);

    void onBodyDecoder(OnBodyDataOnRequestSentData onBodyDataOnRequestSentData);

    void onHeadersReceived(OnHeadersReceivedDataOnRequestSentData onHeadersReceivedDataOnRequestSentData);

    void onRequest(OnRequestData onRequestData);

    void onRequestSent(OnRequestSentData onRequestSentData);

    void onResponseComplete(OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData);
}
