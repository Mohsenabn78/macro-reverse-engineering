package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
/* loaded from: classes5.dex */
public class MockJsonParser extends JsonParser {

    /* renamed from: c  reason: collision with root package name */
    private boolean f26045c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonFactory f26046d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MockJsonParser(JsonFactory jsonFactory) {
        this.f26046d = jsonFactory;
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() throws IOException {
        this.f26045c = true;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() throws IOException {
        return (byte) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() throws IOException {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory getFactory() {
        return this.f26046d;
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() throws IOException {
        return 0.0f;
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() throws IOException {
        return 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() throws IOException {
        return (short) 0;
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() throws IOException {
        return null;
    }

    public boolean isClosed() {
        return this.f26045c;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() throws IOException {
        return null;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() throws IOException {
        return null;
    }
}
