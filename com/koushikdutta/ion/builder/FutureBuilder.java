package com.koushikdutta.ion.builder;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.future.ResponseFuture;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.w3c.dom.Document;

/* loaded from: classes6.dex */
public interface FutureBuilder extends BitmapFutureBuilder, ImageViewFutureBuilder, GsonFutureBuilder {
    <T> ResponseFuture<T> as(AsyncParser<T> asyncParser);

    ResponseFuture<byte[]> asByteArray();

    ResponseFuture<DataEmitter> asDataEmitter();

    ResponseFuture<Document> asDocument();

    ResponseFuture<InputStream> asInputStream();

    ResponseFuture<String> asString();

    ResponseFuture<String> asString(Charset charset);

    FutureBuilder group(Object obj);

    Builders.Any.BF<? extends Builders.Any.BF<?>> withBitmap();

    ResponseFuture<File> write(File file);

    <T extends OutputStream> ResponseFuture<T> write(T t3);

    <T extends OutputStream> ResponseFuture<T> write(T t3, boolean z3);
}
