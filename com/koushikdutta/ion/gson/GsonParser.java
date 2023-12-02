package com.koushikdutta.ion.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public abstract class GsonParser<T extends JsonElement> implements AsyncParser<T> {

    /* renamed from: a  reason: collision with root package name */
    Charset f35873a;

    /* renamed from: b  reason: collision with root package name */
    Class<? extends JsonElement> f35874b;

    /* loaded from: classes6.dex */
    class a extends TransformFuture<T, ByteBufferList> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f35875i;

        a(String str) {
            this.f35875i = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(ByteBufferList byteBufferList) throws Exception {
            InputStreamReader inputStreamReader;
            JsonParser jsonParser = new JsonParser();
            ByteBufferListInputStream byteBufferListInputStream = new ByteBufferListInputStream(byteBufferList);
            if (GsonParser.this.f35873a != null) {
                inputStreamReader = new InputStreamReader(byteBufferListInputStream, GsonParser.this.f35873a);
            } else if (this.f35875i != null) {
                inputStreamReader = new InputStreamReader(byteBufferListInputStream, this.f35875i);
            } else {
                inputStreamReader = new InputStreamReader(byteBufferListInputStream);
            }
            JsonElement parse = jsonParser.parse(new JsonReader(inputStreamReader));
            if (!parse.isJsonNull() && !parse.isJsonPrimitive()) {
                if (GsonParser.this.f35874b.isInstance(parse)) {
                    setComplete(null, parse);
                    return;
                }
                throw new ClassCastException(parse.getClass().getCanonicalName() + " can not be casted to " + GsonParser.this.f35874b.getCanonicalName());
            }
            throw new JsonParseException("unable to parse json");
        }
    }

    public GsonParser(Class<? extends T> cls) {
        this.f35874b = cls;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return this.f35874b;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<T> parse(DataEmitter dataEmitter) {
        return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a(dataEmitter.charset()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.koushikdutta.async.parser.AsyncParser
    public /* bridge */ /* synthetic */ void write(DataSink dataSink, Object obj, CompletedCallback completedCallback) {
        write(dataSink, (DataSink) ((JsonElement) obj), completedCallback);
    }

    public void write(DataSink dataSink, T t3, CompletedCallback completedCallback) {
        new StringParser().write(dataSink, t3.toString(), completedCallback);
    }

    public GsonParser(Class<? extends T> cls, Charset charset) {
        this(cls);
        this.f35873a = charset;
    }
}
