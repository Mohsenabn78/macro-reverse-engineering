package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
final class JacksonParser extends JsonParser {

    /* renamed from: c  reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonParser f25904c;

    /* renamed from: d  reason: collision with root package name */
    private final JacksonFactory f25905d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JacksonParser(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.f25905d = jacksonFactory;
        this.f25904c = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() throws IOException {
        this.f25904c.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.f25904c.getBigIntegerValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() throws IOException {
        return this.f25904c.getByteValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() throws IOException {
        return this.f25904c.getCurrentName();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return JacksonFactory.c(this.f25904c.getCurrentToken());
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.f25904c.getDecimalValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() throws IOException {
        return this.f25904c.getDoubleValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() throws IOException {
        return this.f25904c.getFloatValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() throws IOException {
        return this.f25904c.getIntValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() throws IOException {
        return this.f25904c.getLongValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() throws IOException {
        return this.f25904c.getShortValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() throws IOException {
        return this.f25904c.getText();
    }

    @Override // com.google.api.client.json.JsonParser
    /* renamed from: h */
    public JacksonFactory getFactory() {
        return this.f25905d;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() throws IOException {
        return JacksonFactory.c(this.f25904c.nextToken());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() throws IOException {
        this.f25904c.skipChildren();
        return this;
    }
}
