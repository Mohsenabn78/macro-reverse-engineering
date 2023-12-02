package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class UrlEncodedContent extends AbstractHttpContent {

    /* renamed from: c  reason: collision with root package name */
    private Object f25856c;

    public UrlEncodedContent(Object obj) {
        super(UrlEncodedParser.MEDIA_TYPE);
        setData(obj);
    }

    private static boolean c(boolean z3, Writer writer, String str, Object obj) throws IOException {
        String obj2;
        if (obj != null && !Data.isNull(obj)) {
            if (z3) {
                z3 = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            if (obj instanceof Enum) {
                obj2 = FieldInfo.of((Enum) obj).getName();
            } else {
                obj2 = obj.toString();
            }
            String escapeUri = CharEscapers.escapeUri(obj2);
            if (escapeUri.length() != 0) {
                writer.write("=");
                writer.write(escapeUri);
            }
        }
        return z3;
    }

    public static UrlEncodedContent getContent(HttpRequest httpRequest) {
        HttpContent content = httpRequest.getContent();
        if (content != null) {
            return (UrlEncodedContent) content;
        }
        UrlEncodedContent urlEncodedContent = new UrlEncodedContent(new HashMap());
        httpRequest.setContent(urlEncodedContent);
        return urlEncodedContent;
    }

    public final Object getData() {
        return this.f25856c;
    }

    public UrlEncodedContent setData(Object obj) {
        this.f25856c = Preconditions.checkNotNull(obj);
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, b()));
        boolean z3 = true;
        for (Map.Entry<String, Object> entry : Data.mapOf(this.f25856c).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String escapeUri = CharEscapers.escapeUri(entry.getKey());
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    z3 = c(z3, bufferedWriter, escapeUri, value);
                } else {
                    for (Object obj : Types.iterableOf(value)) {
                        z3 = c(z3, bufferedWriter, escapeUri, obj);
                    }
                }
            }
        }
        bufferedWriter.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent
    public UrlEncodedContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }
}
