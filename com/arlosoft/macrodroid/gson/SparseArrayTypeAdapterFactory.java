package com.arlosoft.macrodroid.gson;

import android.util.SparseArray;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/* loaded from: classes3.dex */
public class SparseArrayTypeAdapterFactory implements TypeAdapterFactory {
    public static final SparseArrayTypeAdapterFactory INSTANCE = new SparseArrayTypeAdapterFactory();

    /* loaded from: classes3.dex */
    private static class a<E> extends TypeAdapter<SparseArray<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter<E> f12279a;

        public a(TypeAdapter<E> typeAdapter) {
            this.f12279a = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public SparseArray<E> read(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            SparseArray<E> sparseArray = new SparseArray<>();
            while (jsonReader.hasNext()) {
                sparseArray.append(Integer.parseInt(jsonReader.nextName()), this.f12279a.read(jsonReader));
            }
            jsonReader.endObject();
            return sparseArray;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(JsonWriter jsonWriter, SparseArray<E> sparseArray) throws IOException {
            jsonWriter.beginObject();
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                jsonWriter.name(Integer.toString(sparseArray.keyAt(i4)));
                this.f12279a.write(jsonWriter, sparseArray.valueAt(i4));
            }
            jsonWriter.endObject();
        }
    }

    private SparseArrayTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() != SparseArray.class) {
            return null;
        }
        return (TypeAdapter<T>) new a(gson.getAdapter(TypeToken.get(((ParameterizedType) typeToken.getType()).getActualTypeArguments()[0]))).nullSafe();
    }
}
