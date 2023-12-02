package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonWriter;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
@TargetApi(11)
/* loaded from: classes5.dex */
class AndroidJsonGenerator extends JsonGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final JsonWriter f25541a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidJsonFactory f25542b;

    /* loaded from: classes5.dex */
    static final class StringNumber extends Number {
        private static final long serialVersionUID = 1;
        private final String encodedValue;

        StringNumber(String str) {
            this.encodedValue = str;
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return 0.0f;
        }

        @Override // java.lang.Number
        public int intValue() {
            return 0;
        }

        @Override // java.lang.Number
        public long longValue() {
            return 0L;
        }

        public String toString() {
            return this.encodedValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidJsonGenerator(AndroidJsonFactory androidJsonFactory, JsonWriter jsonWriter) {
        this.f25542b = androidJsonFactory;
        this.f25541a = jsonWriter;
        jsonWriter.setLenient(true);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void close() throws IOException {
        this.f25541a.close();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void enablePrettyPrint() throws IOException {
        this.f25541a.setIndent("  ");
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void flush() throws IOException {
        this.f25541a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public JsonFactory getFactory() {
        return this.f25542b;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeBoolean(boolean z3) throws IOException {
        this.f25541a.value(z3);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndArray() throws IOException {
        this.f25541a.endArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndObject() throws IOException {
        this.f25541a.endObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        this.f25541a.name(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNull() throws IOException {
        this.f25541a.nullValue();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(int i4) throws IOException {
        this.f25541a.value(i4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartArray() throws IOException {
        this.f25541a.beginArray();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartObject() throws IOException {
        this.f25541a.beginObject();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeString(String str) throws IOException {
        this.f25541a.value(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(long j4) throws IOException {
        this.f25541a.value(j4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.f25541a.value(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(double d4) throws IOException {
        this.f25541a.value(d4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(float f4) throws IOException {
        this.f25541a.value(f4);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.f25541a.value(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(String str) throws IOException {
        this.f25541a.value(new StringNumber(str));
    }
}
