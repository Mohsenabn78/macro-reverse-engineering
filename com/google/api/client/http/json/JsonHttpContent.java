package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class JsonHttpContent extends AbstractHttpContent {

    /* renamed from: c  reason: collision with root package name */
    private final Object f25887c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonFactory f25888d;

    /* renamed from: e  reason: collision with root package name */
    private String f25889e;

    public JsonHttpContent(JsonFactory jsonFactory, Object obj) {
        super(Json.MEDIA_TYPE);
        this.f25888d = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        this.f25887c = Preconditions.checkNotNull(obj);
    }

    public final Object getData() {
        return this.f25887c;
    }

    public final JsonFactory getJsonFactory() {
        return this.f25888d;
    }

    public final String getWrapperKey() {
        return this.f25889e;
    }

    public JsonHttpContent setWrapperKey(String str) {
        this.f25889e = str;
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        JsonGenerator createJsonGenerator = this.f25888d.createJsonGenerator(outputStream, b());
        if (this.f25889e != null) {
            createJsonGenerator.writeStartObject();
            createJsonGenerator.writeFieldName(this.f25889e);
        }
        createJsonGenerator.serialize(this.f25887c);
        if (this.f25889e != null) {
            createJsonGenerator.writeEndObject();
        }
        createJsonGenerator.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent
    public JsonHttpContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }
}
