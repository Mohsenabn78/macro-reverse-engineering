package com.google.api.client.json;

import com.google.api.client.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public abstract class JsonFactory {
    private ByteArrayOutputStream a(Object obj, boolean z3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator createJsonGenerator = createJsonGenerator(byteArrayOutputStream, Charsets.UTF_8);
        if (z3) {
            createJsonGenerator.enablePrettyPrint();
        }
        createJsonGenerator.serialize(obj);
        createJsonGenerator.flush();
        return byteArrayOutputStream;
    }

    private String b(Object obj, boolean z3) throws IOException {
        return a(obj, z3).toString("UTF-8");
    }

    public abstract JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset) throws IOException;

    public abstract JsonGenerator createJsonGenerator(Writer writer) throws IOException;

    public final JsonObjectParser createJsonObjectParser() {
        return new JsonObjectParser(this);
    }

    public abstract JsonParser createJsonParser(InputStream inputStream) throws IOException;

    public abstract JsonParser createJsonParser(InputStream inputStream, Charset charset) throws IOException;

    public abstract JsonParser createJsonParser(Reader reader) throws IOException;

    public abstract JsonParser createJsonParser(String str) throws IOException;

    public final <T> T fromInputStream(InputStream inputStream, Class<T> cls) throws IOException {
        return (T) createJsonParser(inputStream).parseAndClose((Class<Object>) cls);
    }

    public final <T> T fromReader(Reader reader, Class<T> cls) throws IOException {
        return (T) createJsonParser(reader).parseAndClose((Class<Object>) cls);
    }

    public final <T> T fromString(String str, Class<T> cls) throws IOException {
        return (T) createJsonParser(str).parse((Class<Object>) cls);
    }

    public final byte[] toByteArray(Object obj) throws IOException {
        return a(obj, false).toByteArray();
    }

    public final String toPrettyString(Object obj) throws IOException {
        return b(obj, true);
    }

    public final String toString(Object obj) throws IOException {
        return b(obj, false);
    }

    public final <T> T fromInputStream(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) createJsonParser(inputStream, charset).parseAndClose((Class<Object>) cls);
    }
}
