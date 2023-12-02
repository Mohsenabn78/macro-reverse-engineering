package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: d  reason: collision with root package name */
    private static final Writer f32687d = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i4, int i5) {
            throw new AssertionError();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final JsonPrimitive f32688e = new JsonPrimitive("closed");

    /* renamed from: a  reason: collision with root package name */
    private final List<JsonElement> f32689a;

    /* renamed from: b  reason: collision with root package name */
    private String f32690b;

    /* renamed from: c  reason: collision with root package name */
    private JsonElement f32691c;

    public JsonTreeWriter() {
        super(f32687d);
        this.f32689a = new ArrayList();
        this.f32691c = JsonNull.INSTANCE;
    }

    private JsonElement b() {
        List<JsonElement> list = this.f32689a;
        return list.get(list.size() - 1);
    }

    private void c(JsonElement jsonElement) {
        if (this.f32690b != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) b()).add(this.f32690b, jsonElement);
            }
            this.f32690b = null;
        } else if (this.f32689a.isEmpty()) {
            this.f32691c = jsonElement;
        } else {
            JsonElement b4 = b();
            if (b4 instanceof JsonArray) {
                ((JsonArray) b4).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        c(jsonArray);
        this.f32689a.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        c(jsonObject);
        this.f32689a.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f32689a.isEmpty()) {
            this.f32689a.add(f32688e);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (!this.f32689a.isEmpty() && this.f32690b == null) {
            if (b() instanceof JsonArray) {
                List<JsonElement> list = this.f32689a;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (!this.f32689a.isEmpty() && this.f32690b == null) {
            if (b() instanceof JsonObject) {
                List<JsonElement> list = this.f32689a;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public JsonElement get() {
        if (this.f32689a.isEmpty()) {
            return this.f32691c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f32689a);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter jsonValue(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (!this.f32689a.isEmpty() && this.f32690b == null) {
            if (b() instanceof JsonObject) {
                this.f32690b = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        c(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        c(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z3) throws IOException {
        c(new JsonPrimitive(Boolean.valueOf(z3)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        c(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(float f4) throws IOException {
        if (!isLenient() && (Float.isNaN(f4) || Float.isInfinite(f4))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f4);
        }
        c(new JsonPrimitive(Float.valueOf(f4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d4) throws IOException {
        if (!isLenient() && (Double.isNaN(d4) || Double.isInfinite(d4))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d4);
        }
        c(new JsonPrimitive(Double.valueOf(d4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j4) throws IOException {
        c(new JsonPrimitive(Long.valueOf(j4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }
}
