package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes5.dex */
public class MultipartContent extends AbstractHttpContent {

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Part> f25842c;

    /* loaded from: classes5.dex */
    public static final class Part {

        /* renamed from: a  reason: collision with root package name */
        HttpContent f25843a;

        /* renamed from: b  reason: collision with root package name */
        HttpHeaders f25844b;

        /* renamed from: c  reason: collision with root package name */
        HttpEncoding f25845c;

        public Part() {
            this(null);
        }

        public HttpContent getContent() {
            return this.f25843a;
        }

        public HttpEncoding getEncoding() {
            return this.f25845c;
        }

        public HttpHeaders getHeaders() {
            return this.f25844b;
        }

        public Part setContent(HttpContent httpContent) {
            this.f25843a = httpContent;
            return this;
        }

        public Part setEncoding(HttpEncoding httpEncoding) {
            this.f25845c = httpEncoding;
            return this;
        }

        public Part setHeaders(HttpHeaders httpHeaders) {
            this.f25844b = httpHeaders;
            return this;
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            setHeaders(httpHeaders);
            setContent(httpContent);
        }
    }

    public MultipartContent() {
        super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
        this.f25842c = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultipartContent addPart(Part part) {
        this.f25842c.add(Preconditions.checkNotNull(part));
        return this;
    }

    public final String getBoundary() {
        return getMediaType().getParameter("boundary");
    }

    public final Collection<Part> getParts() {
        return Collections.unmodifiableCollection(this.f25842c);
    }

    @Override // com.google.api.client.http.AbstractHttpContent, com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        Iterator<Part> it = this.f25842c.iterator();
        while (it.hasNext()) {
            if (!it.next().f25843a.retrySupported()) {
                return false;
            }
        }
        return true;
    }

    public MultipartContent setBoundary(String str) {
        getMediaType().setParameter("boundary", (String) Preconditions.checkNotNull(str));
        return this;
    }

    public MultipartContent setContentParts(Collection<? extends HttpContent> collection) {
        this.f25842c = new ArrayList<>(collection.size());
        for (HttpContent httpContent : collection) {
            addPart(new Part(httpContent));
        }
        return this;
    }

    public MultipartContent setParts(Collection<Part> collection) {
        this.f25842c = new ArrayList<>(collection);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.api.client.http.HttpEncodingStreamingContent] */
    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        long j4;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, b());
        String boundary = getBoundary();
        Iterator<Part> it = this.f25842c.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            HttpHeaders acceptEncoding = new HttpHeaders().setAcceptEncoding(null);
            HttpHeaders httpHeaders = next.f25844b;
            if (httpHeaders != null) {
                acceptEncoding.fromHttpHeaders(httpHeaders);
            }
            acceptEncoding.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set("Content-Transfer-Encoding", (Object) null);
            HttpContent httpContent = next.f25843a;
            if (httpContent != null) {
                acceptEncoding.set("Content-Transfer-Encoding", (Object) Arrays.asList("binary"));
                acceptEncoding.setContentType(httpContent.getType());
                HttpEncoding httpEncoding = next.f25845c;
                if (httpEncoding == null) {
                    j4 = httpContent.getLength();
                } else {
                    acceptEncoding.setContentEncoding(httpEncoding.getName());
                    ?? httpEncodingStreamingContent = new HttpEncodingStreamingContent(httpContent, httpEncoding);
                    long computeLength = AbstractHttpContent.computeLength(httpContent);
                    httpContent = httpEncodingStreamingContent;
                    j4 = computeLength;
                }
                if (j4 != -1) {
                    acceptEncoding.setContentLength(Long.valueOf(j4));
                }
            } else {
                httpContent = null;
            }
            outputStreamWriter.write(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
            outputStreamWriter.write(boundary);
            outputStreamWriter.write("\r\n");
            HttpHeaders.serializeHeadersForMultipartRequests(acceptEncoding, null, null, outputStreamWriter);
            if (httpContent != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                httpContent.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        outputStreamWriter.write(boundary);
        outputStreamWriter.write(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent
    public MultipartContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }
}
