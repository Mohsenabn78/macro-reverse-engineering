package com.google.api.client.json;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class JsonObjectParser implements ObjectParser {

    /* renamed from: a  reason: collision with root package name */
    private final JsonFactory f25891a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f25892b;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final JsonFactory f25893a;

        /* renamed from: b  reason: collision with root package name */
        Collection<String> f25894b = Sets.newHashSet();

        public Builder(JsonFactory jsonFactory) {
            this.f25893a = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        }

        public JsonObjectParser build() {
            return new JsonObjectParser(this);
        }

        public final JsonFactory getJsonFactory() {
            return this.f25893a;
        }

        public final Collection<String> getWrapperKeys() {
            return this.f25894b;
        }

        public Builder setWrapperKeys(Collection<String> collection) {
            this.f25894b = collection;
            return this;
        }
    }

    public JsonObjectParser(JsonFactory jsonFactory) {
        this(new Builder(jsonFactory));
    }

    private void a(JsonParser jsonParser) throws IOException {
        boolean z3;
        if (this.f25892b.isEmpty()) {
            return;
        }
        try {
            if (jsonParser.skipToKey(this.f25892b) != null && jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "wrapper key(s) not found: %s", this.f25892b);
        } catch (Throwable th) {
            jsonParser.close();
            throw th;
        }
    }

    public final JsonFactory getJsonFactory() {
        return this.f25891a;
    }

    public Set<String> getWrapperKeys() {
        return Collections.unmodifiableSet(this.f25892b);
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) parseAndClose(inputStream, charset, (Type) cls);
    }

    protected JsonObjectParser(Builder builder) {
        this.f25891a = builder.f25893a;
        this.f25892b = new HashSet(builder.f25894b);
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) throws IOException {
        JsonParser createJsonParser = this.f25891a.createJsonParser(inputStream, charset);
        a(createJsonParser);
        return createJsonParser.parse(type, true);
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T parseAndClose(Reader reader, Class<T> cls) throws IOException {
        return (T) parseAndClose(reader, (Type) cls);
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(Reader reader, Type type) throws IOException {
        JsonParser createJsonParser = this.f25891a.createJsonParser(reader);
        a(createJsonParser);
        return createJsonParser.parse(type, true);
    }
}
