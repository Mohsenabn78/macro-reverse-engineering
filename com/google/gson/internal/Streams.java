package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z3;
        try {
            try {
                jsonReader.peek();
                z3 = false;
                try {
                    return TypeAdapters.JSON_ELEMENT.read(jsonReader);
                } catch (EOFException e4) {
                    e = e4;
                    if (z3) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e5) {
                throw new JsonSyntaxException(e5);
            } catch (IOException e6) {
                throw new JsonIOException(e6);
            } catch (NumberFormatException e7) {
                throw new JsonSyntaxException(e7);
            }
        } catch (EOFException e8) {
            e = e8;
            z3 = true;
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AppendableWriter extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f32661a;

        /* renamed from: b  reason: collision with root package name */
        private final CurrentWrite f32662b = new CurrentWrite();

        /* loaded from: classes5.dex */
        private static class CurrentWrite implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f32663a;

            /* renamed from: b  reason: collision with root package name */
            private String f32664b;

            private CurrentWrite() {
            }

            void a(char[] cArr) {
                this.f32663a = cArr;
                this.f32664b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i4) {
                return this.f32663a[i4];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f32663a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i4, int i5) {
                return new String(this.f32663a, i4, i5 - i4);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f32664b == null) {
                    this.f32664b = new String(this.f32663a);
                }
                return this.f32664b;
            }
        }

        AppendableWriter(Appendable appendable) {
            this.f32661a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i4, int i5) throws IOException {
            this.f32662b.a(cArr);
            this.f32661a.append(this.f32662b, i4, i5 + i4);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f32661a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i4) throws IOException {
            this.f32661a.append((char) i4);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i4, int i5) throws IOException {
            this.f32661a.append(charSequence, i4, i5);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i4, int i5) throws IOException {
            Objects.requireNonNull(str);
            this.f32661a.append(str, i4, i5 + i4);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
