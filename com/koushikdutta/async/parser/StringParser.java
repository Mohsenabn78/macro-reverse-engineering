package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class StringParser implements AsyncParser<String> {

    /* renamed from: a  reason: collision with root package name */
    Charset f35640a;

    /* loaded from: classes6.dex */
    class a extends TransformFuture<String, ByteBufferList> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f35641i;

        a(String str) {
            this.f35641i = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(ByteBufferList byteBufferList) throws Exception {
            String str;
            Charset charset = StringParser.this.f35640a;
            if (charset == null && (str = this.f35641i) != null) {
                charset = Charset.forName(str);
            }
            setComplete((a) byteBufferList.readString(charset));
        }
    }

    public StringParser() {
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return String.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<String> parse(DataEmitter dataEmitter) {
        return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a(dataEmitter.charset()));
    }

    public StringParser(Charset charset) {
        this.f35640a = charset;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, String str, CompletedCallback completedCallback) {
        new ByteBufferListParser().write(dataSink, new ByteBufferList(str.getBytes()), completedCallback);
    }
}
