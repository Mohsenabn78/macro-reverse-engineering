package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class ByteBufferListParser implements AsyncParser<ByteBufferList> {

    /* loaded from: classes6.dex */
    class a extends SimpleFuture<ByteBufferList> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ DataEmitter f35630i;

        a(DataEmitter dataEmitter) {
            this.f35630i = dataEmitter;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void a() {
            this.f35630i.close();
        }
    }

    /* loaded from: classes6.dex */
    class b implements DataCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f35632a;

        b(ByteBufferList byteBufferList) {
            this.f35632a = byteBufferList;
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byteBufferList.get(this.f35632a);
        }
    }

    /* loaded from: classes6.dex */
    class c implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35634a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f35635b;

        c(SimpleFuture simpleFuture, ByteBufferList byteBufferList) {
            this.f35634a = simpleFuture;
            this.f35635b = byteBufferList;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                this.f35634a.setComplete(exc);
                return;
            }
            try {
                this.f35634a.setComplete((SimpleFuture) this.f35635b);
            } catch (Exception e4) {
                this.f35634a.setComplete(e4);
            }
        }
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return ByteBufferList.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<ByteBufferList> parse(DataEmitter dataEmitter) {
        ByteBufferList byteBufferList = new ByteBufferList();
        a aVar = new a(dataEmitter);
        dataEmitter.setDataCallback(new b(byteBufferList));
        dataEmitter.setEndCallback(new c(aVar, byteBufferList));
        return aVar;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, ByteBufferList byteBufferList, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, byteBufferList, completedCallback);
    }
}
