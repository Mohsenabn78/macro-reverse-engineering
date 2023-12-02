package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

/* loaded from: classes5.dex */
public class GenericJson extends GenericData {

    /* renamed from: c  reason: collision with root package name */
    private JsonFactory f25890c;

    public final JsonFactory getFactory() {
        return this.f25890c;
    }

    public final void setFactory(JsonFactory jsonFactory) {
        this.f25890c = jsonFactory;
    }

    public String toPrettyString() throws IOException {
        JsonFactory jsonFactory = this.f25890c;
        if (jsonFactory != null) {
            return jsonFactory.toPrettyString(this);
        }
        return super.toString();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        JsonFactory jsonFactory = this.f25890c;
        if (jsonFactory != null) {
            try {
                return jsonFactory.toString(this);
            } catch (IOException e4) {
                throw Throwables.propagate(e4);
            }
        }
        return super.toString();
    }

    @Override // com.google.api.client.util.GenericData
    public GenericJson set(String str, Object obj) {
        return (GenericJson) super.set(str, obj);
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericJson clone() {
        return (GenericJson) super.clone();
    }
}
