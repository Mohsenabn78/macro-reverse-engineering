package com.google.api.client.json.jackson2;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public final class JacksonFactory extends JsonFactory {

    /* renamed from: a  reason: collision with root package name */
    private final com.fasterxml.jackson.core.JsonFactory f25899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.api.client.json.jackson2.JacksonFactory$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25900a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f25900a = iArr;
            try {
                iArr[JsonToken.END_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25900a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25900a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25900a[JsonToken.START_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25900a[JsonToken.VALUE_FALSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25900a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25900a[JsonToken.VALUE_NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25900a[JsonToken.VALUE_STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25900a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25900a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25900a[JsonToken.FIELD_NAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes5.dex */
    static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        static final JacksonFactory f25901a = new JacksonFactory();

        InstanceHolder() {
        }
    }

    public JacksonFactory() {
        com.fasterxml.jackson.core.JsonFactory jsonFactory = new com.fasterxml.jackson.core.JsonFactory();
        this.f25899a = jsonFactory;
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.api.client.json.JsonToken c(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (AnonymousClass1.f25900a[jsonToken.ordinal()]) {
            case 1:
                return com.google.api.client.json.JsonToken.END_ARRAY;
            case 2:
                return com.google.api.client.json.JsonToken.START_ARRAY;
            case 3:
                return com.google.api.client.json.JsonToken.END_OBJECT;
            case 4:
                return com.google.api.client.json.JsonToken.START_OBJECT;
            case 5:
                return com.google.api.client.json.JsonToken.VALUE_FALSE;
            case 6:
                return com.google.api.client.json.JsonToken.VALUE_TRUE;
            case 7:
                return com.google.api.client.json.JsonToken.VALUE_NULL;
            case 8:
                return com.google.api.client.json.JsonToken.VALUE_STRING;
            case 9:
                return com.google.api.client.json.JsonToken.VALUE_NUMBER_FLOAT;
            case 10:
                return com.google.api.client.json.JsonToken.VALUE_NUMBER_INT;
            case 11:
                return com.google.api.client.json.JsonToken.FIELD_NAME;
            default:
                return com.google.api.client.json.JsonToken.NOT_AVAILABLE;
        }
    }

    public static JacksonFactory getDefaultInstance() {
        return InstanceHolder.f25901a;
    }

    @Override // com.google.api.client.json.JsonFactory
    public com.google.api.client.json.JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset) throws IOException {
        return new JacksonGenerator(this, this.f25899a.createJsonGenerator(outputStream, JsonEncoding.UTF8));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(Reader reader) throws IOException {
        Preconditions.checkNotNull(reader);
        return new JacksonParser(this, this.f25899a.createJsonParser(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public com.google.api.client.json.JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        return new JacksonGenerator(this, this.f25899a.createJsonGenerator(writer));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return new JacksonParser(this, this.f25899a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream, Charset charset) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return new JacksonParser(this, this.f25899a.createJsonParser(inputStream));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(String str) throws IOException {
        Preconditions.checkNotNull(str);
        return new JacksonParser(this, this.f25899a.createJsonParser(str));
    }
}
