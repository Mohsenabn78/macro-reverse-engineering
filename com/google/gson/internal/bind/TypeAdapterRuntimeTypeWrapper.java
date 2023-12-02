package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f32746a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<T> f32747b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f32748c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f32746a = gson;
        this.f32747b = typeAdapter;
        this.f32748c = type;
    }

    private static Type a(Type type, Object obj) {
        if (obj != null) {
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }

    private static boolean b(TypeAdapter<?> typeAdapter) {
        TypeAdapter<T> serializationDelegate;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (serializationDelegate = ((SerializationDelegatingTypeAdapter) typeAdapter).getSerializationDelegate()) != typeAdapter) {
            typeAdapter = serializationDelegate;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        return this.f32747b.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t3) throws IOException {
        TypeAdapter<T> typeAdapter = this.f32747b;
        Type a4 = a(this.f32748c, t3);
        if (a4 != this.f32748c) {
            typeAdapter = this.f32746a.getAdapter(TypeToken.get(a4));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !b(this.f32747b)) {
                typeAdapter = this.f32747b;
            }
        }
        typeAdapter.write(jsonWriter, t3);
    }
}
