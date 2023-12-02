package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
/* loaded from: classes5.dex */
public class MockJsonGenerator extends JsonGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final JsonFactory f26044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MockJsonGenerator(JsonFactory jsonFactory) {
        this.f26044a = jsonFactory;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public JsonFactory getFactory() {
        return this.f26044a;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(double d4) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(float f4) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(int i4) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(long j4) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(String str) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void close() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void flush() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndArray() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndObject() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNull() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartArray() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartObject() throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeBoolean(boolean z3) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeFieldName(String str) throws IOException {
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeString(String str) throws IOException {
    }
}
