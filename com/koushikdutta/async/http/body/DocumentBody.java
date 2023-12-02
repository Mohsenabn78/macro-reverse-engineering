package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.DocumentParser;
import com.koushikdutta.async.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/* loaded from: classes6.dex */
public class DocumentBody implements AsyncHttpRequestBody<Document> {
    public static final String CONTENT_TYPE = "application/xml";

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f35101a;

    /* renamed from: b  reason: collision with root package name */
    Document f35102b;

    /* loaded from: classes6.dex */
    class a implements FutureCallback<Document> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35103a;

        a(CompletedCallback completedCallback) {
            this.f35103a = completedCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, Document document) {
            DocumentBody.this.f35102b = document;
            this.f35103a.onCompleted(exc);
        }
    }

    public DocumentBody() {
        this(null);
    }

    private void a() {
        if (this.f35101a != null) {
            return;
        }
        try {
            DOMSource dOMSource = new DOMSource(this.f35102b);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            this.f35101a = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f35101a, Charsets.UTF_8);
            newTransformer.transform(dOMSource, new StreamResult(outputStreamWriter));
            outputStreamWriter.flush();
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return CONTENT_TYPE;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        a();
        return this.f35101a.size();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        new DocumentParser().parse(dataEmitter).setCallback(new a(completedCallback));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        a();
        Util.writeAll(dataSink, this.f35101a.toByteArray(), completedCallback);
    }

    public DocumentBody(Document document) {
        this.f35102b = document;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Document get() {
        return this.f35102b;
    }
}
