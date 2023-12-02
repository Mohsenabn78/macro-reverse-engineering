package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

@Beta
/* loaded from: classes5.dex */
public class MockJsonFactory extends JsonFactory {
    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset) throws IOException {
        return new MockJsonGenerator(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        return new MockJsonGenerator(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream, Charset charset) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(String str) throws IOException {
        return new MockJsonParser(this);
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(Reader reader) throws IOException {
        return new MockJsonParser(this);
    }
}
