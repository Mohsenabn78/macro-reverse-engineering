package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
final class JacksonGenerator extends JsonGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonGenerator f25902a;

    /* renamed from: b  reason: collision with root package name */
    private final JacksonFactory f25903b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JacksonGenerator(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonGenerator jsonGenerator) {
        this.f25903b = jacksonFactory;
        this.f25902a = jsonGenerator;
    }

    @Override // com.google.api.client.json.JsonGenerator
    /* renamed from: b */
    public JacksonFactory getFactory() {
        return this.f25903b;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void close() throws IOException {
        this.f25902a.close();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void enablePrettyPrint() throws IOException {
        this.f25902a.useDefaultPrettyPrinter();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void flush() throws IOException {
        this.f25902a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeBoolean(boolean z3) throws IOException {
        this.f25902a.writeBoolean(z3);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndArray() throws IOException {
        this.f25902a.writeEndArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndObject() throws IOException {
        this.f25902a.writeEndObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        this.f25902a.writeFieldName(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNull() throws IOException {
        this.f25902a.writeNull();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(int i4) throws IOException {
        this.f25902a.writeNumber(i4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartArray() throws IOException {
        this.f25902a.writeStartArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartObject() throws IOException {
        this.f25902a.writeStartObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeString(String str) throws IOException {
        this.f25902a.writeString(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(long j4) throws IOException {
        this.f25902a.writeNumber(j4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.f25902a.writeNumber(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(double d4) throws IOException {
        this.f25902a.writeNumber(d4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(float f4) throws IOException {
        this.f25902a.writeNumber(f4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.f25902a.writeNumber(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(String str) throws IOException {
        this.f25902a.writeNumber(str);
    }
}
