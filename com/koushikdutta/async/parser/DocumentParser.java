package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.http.body.DocumentBody;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.lang.reflect.Type;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/* loaded from: classes6.dex */
public class DocumentParser implements AsyncParser<Document> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends TransformFuture<Document, ByteBufferList> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(ByteBufferList byteBufferList) throws Exception {
            setComplete((a) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteBufferListInputStream(byteBufferList)));
        }
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return Document.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<Document> parse(DataEmitter dataEmitter) {
        return (Future) new ByteBufferListParser().parse(dataEmitter).then(new a());
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, Document document, CompletedCallback completedCallback) {
        new DocumentBody(document).write(null, dataSink, completedCallback);
    }
}
