package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class GsonSerializer<T> implements AsyncParser<T> {

    /* renamed from: a  reason: collision with root package name */
    Gson f35877a;

    /* renamed from: b  reason: collision with root package name */
    Type f35878b;

    /* loaded from: classes6.dex */
    class a extends TransformFuture<T, ByteBufferList> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(ByteBufferList byteBufferList) throws Exception {
            setComplete((a) GsonSerializer.this.f35877a.fromJson(new JsonReader(new InputStreamReader(new ByteBufferListInputStream(byteBufferList))), GsonSerializer.this.f35878b));
        }
    }

    public GsonSerializer(Gson gson, Class<T> cls) {
        this.f35877a = gson;
        this.f35878b = cls;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return this.f35878b;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<T> parse(DataEmitter dataEmitter) {
        return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a());
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, T t3, CompletedCallback completedCallback) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        this.f35877a.toJson(t3, this.f35878b, outputStreamWriter);
        try {
            outputStreamWriter.flush();
            Util.writeAll(dataSink, byteArrayOutputStream.toByteArray(), completedCallback);
        } catch (Exception e4) {
            throw new AssertionError(e4);
        }
    }

    public GsonSerializer(Gson gson, TypeToken<T> typeToken) {
        this.f35877a = gson;
        this.f35878b = typeToken.getType();
    }
}
