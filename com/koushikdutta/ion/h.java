package com.koushikdutta.ion;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;

/* compiled from: InputStreamParser.java */
/* loaded from: classes6.dex */
class h implements AsyncParser<InputStream> {

    /* compiled from: InputStreamParser.java */
    /* loaded from: classes6.dex */
    class a extends TransformFuture<InputStream, ByteBufferList> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(ByteBufferList byteBufferList) throws Exception {
            setComplete((a) new ByteBufferListInputStream(byteBufferList));
        }
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    /* renamed from: a */
    public void write(DataSink dataSink, InputStream inputStream, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return InputStream.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<InputStream> parse(DataEmitter dataEmitter) {
        return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a());
    }
}
