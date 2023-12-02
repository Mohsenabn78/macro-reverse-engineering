package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonSerializer<T> f32732a;

    /* renamed from: b  reason: collision with root package name */
    private final JsonDeserializer<T> f32733b;

    /* renamed from: c  reason: collision with root package name */
    final Gson f32734c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeToken<T> f32735d;

    /* renamed from: e  reason: collision with root package name */
    private final TypeAdapterFactory f32736e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeTypeAdapter<T>.GsonContextImpl f32737f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32738g;

    /* renamed from: h  reason: collision with root package name */
    private volatile TypeAdapter<T> f32739h;

    /* loaded from: classes5.dex */
    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f32734c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f32734c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f32734c.toJsonTree(obj, type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        private final TypeToken<?> f32741a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f32742b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f32743c;

        /* renamed from: d  reason: collision with root package name */
        private final JsonSerializer<?> f32744d;

        /* renamed from: e  reason: collision with root package name */
        private final JsonDeserializer<?> f32745e;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z3, Class<?> cls) {
            JsonSerializer<?> jsonSerializer;
            boolean z4;
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.f32744d = jsonSerializer;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.f32745e = jsonDeserializer;
            if (jsonSerializer == null && jsonDeserializer == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            C$Gson$Preconditions.checkArgument(z4);
            this.f32741a = typeToken;
            this.f32742b = z3;
            this.f32743c = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom;
            TypeToken<?> typeToken2 = this.f32741a;
            if (typeToken2 != null) {
                if (!typeToken2.equals(typeToken) && (!this.f32742b || this.f32741a.getType() != typeToken.getRawType())) {
                    isAssignableFrom = false;
                } else {
                    isAssignableFrom = true;
                }
            } else {
                isAssignableFrom = this.f32743c.isAssignableFrom(typeToken.getRawType());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f32744d, this.f32745e, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory, boolean z3) {
        this.f32737f = new GsonContextImpl();
        this.f32732a = jsonSerializer;
        this.f32733b = jsonDeserializer;
        this.f32734c = gson;
        this.f32735d = typeToken;
        this.f32736e = typeAdapterFactory;
        this.f32738g = z3;
    }

    private TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.f32739h;
        if (typeAdapter == null) {
            TypeAdapter<T> delegateAdapter = this.f32734c.getDelegateAdapter(this.f32736e, this.f32735d);
            this.f32739h = delegateAdapter;
            return delegateAdapter;
        }
        return typeAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        boolean z3;
        if (typeToken.getType() == typeToken.getRawType()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return new SingleTypeFactory(obj, typeToken, z3, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.f32732a != null) {
            return this;
        }
        return a();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f32733b == null) {
            return a().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (this.f32738g && parse.isJsonNull()) {
            return null;
        }
        return this.f32733b.deserialize(parse, this.f32735d.getType(), this.f32737f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t3) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f32732a;
        if (jsonSerializer == null) {
            a().write(jsonWriter, t3);
        } else if (this.f32738g && t3 == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t3, this.f32735d.getType(), this.f32737f), jsonWriter);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }
}
