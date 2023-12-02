package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes3.dex */
public class JsonParserDelegate extends JsonParser {

    /* renamed from: b  reason: collision with root package name */
    protected JsonParser f17892b;

    public JsonParserDelegate(JsonParser jsonParser) {
        this.f17892b = jsonParser;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.f17892b.canUseSchema(formatSchema);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        this.f17892b.clearCurrentToken();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17892b.close();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser disable(JsonParser.Feature feature) {
        this.f17892b.disable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser enable(JsonParser.Feature feature) {
        this.f17892b.enable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        return this.f17892b.getBigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        return this.f17892b.getBinaryValue(base64Variant);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean getBooleanValue() throws IOException, JsonParseException {
        return this.f17892b.getBooleanValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte getByteValue() throws IOException, JsonParseException {
        return this.f17892b.getByteValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this.f17892b.getCodec();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return this.f17892b.getCurrentLocation();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException, JsonParseException {
        return this.f17892b.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this.f17892b.getCurrentToken();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        return this.f17892b.getDecimalValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException, JsonParseException {
        return this.f17892b.getDoubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return this.f17892b.getEmbeddedObject();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException, JsonParseException {
        return this.f17892b.getFloatValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this.f17892b.getInputSource();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException, JsonParseException {
        return this.f17892b.getIntValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this.f17892b.getLastClearedToken();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException, JsonParseException {
        return this.f17892b.getLongValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
        return this.f17892b.getNumberType();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException, JsonParseException {
        return this.f17892b.getNumberValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return this.f17892b.getParsingContext();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public FormatSchema getSchema() {
        return this.f17892b.getSchema();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public short getShortValue() throws IOException, JsonParseException {
        return this.f17892b.getShortValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException, JsonParseException {
        return this.f17892b.getText();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException, JsonParseException {
        return this.f17892b.getTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException, JsonParseException {
        return this.f17892b.getTextLength();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException, JsonParseException {
        return this.f17892b.getTextOffset();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return this.f17892b.getTokenLocation();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean() throws IOException, JsonParseException {
        return this.f17892b.getValueAsBoolean();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble() throws IOException, JsonParseException {
        return this.f17892b.getValueAsDouble();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException, JsonParseException {
        return this.f17892b.getValueAsInt();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() throws IOException, JsonParseException {
        return this.f17892b.getValueAsLong();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException, JsonParseException {
        return this.f17892b.getValueAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this.f17892b.hasCurrentToken();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return this.f17892b.hasTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isClosed() {
        return this.f17892b.isClosed();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isEnabled(JsonParser.Feature feature) {
        return this.f17892b.isEnabled(feature);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException, JsonParseException {
        return this.f17892b.nextToken();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException, JsonParseException {
        return this.f17892b.nextValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        this.f17892b.overrideCurrentName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException, JsonParseException {
        return this.f17892b.readBinaryValue(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean requiresCustomCodec() {
        return this.f17892b.requiresCustomCodec();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this.f17892b.setCodec(objectCodec);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setSchema(FormatSchema formatSchema) {
        this.f17892b.setSchema(formatSchema);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException, JsonParseException {
        this.f17892b.skipChildren();
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return this.f17892b.version();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z3) throws IOException, JsonParseException {
        return this.f17892b.getValueAsBoolean(z3);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d4) throws IOException, JsonParseException {
        return this.f17892b.getValueAsDouble(d4);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i4) throws IOException, JsonParseException {
        return this.f17892b.getValueAsInt(i4);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j4) throws IOException, JsonParseException {
        return this.f17892b.getValueAsLong(j4);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException, JsonParseException {
        return this.f17892b.getValueAsString(str);
    }
}
