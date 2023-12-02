package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader f32598a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f32599b;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z3;
        synchronized (this.f32599b) {
            try {
                try {
                    try {
                        if (this.f32598a.peek() != JsonToken.END_DOCUMENT) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } catch (MalformedJsonException e4) {
                        throw new JsonSyntaxException(e4);
                    }
                } catch (IOException e5) {
                    throw new JsonIOException(e5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.f32598a = jsonReader;
        jsonReader.setLenient(true);
        this.f32599b = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.f32598a);
            } catch (OutOfMemoryError e4) {
                throw new JsonParseException("Failed parsing JSON source to Json", e4);
            } catch (StackOverflowError e5) {
                throw new JsonParseException("Failed parsing JSON source to Json", e5);
            }
        }
        throw new NoSuchElementException();
    }
}
