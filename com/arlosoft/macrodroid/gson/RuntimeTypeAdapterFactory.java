package com.arlosoft.macrodroid.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f12272a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12273b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Class<?>> f12274c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, String> f12275d = new LinkedHashMap();

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes3.dex */
    class a<R> extends TypeAdapter<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f12276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f12277b;

        a(Map map, Map map2) {
            this.f12276a = map;
            this.f12277b = map2;
        }

        @Override // com.google.gson.TypeAdapter
        public R read(JsonReader jsonReader) throws IOException {
            JsonElement parse = Streams.parse(jsonReader);
            JsonElement remove = parse.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.f12273b);
            if (remove != null) {
                String asString = remove.getAsString();
                TypeAdapter typeAdapter = (TypeAdapter) this.f12276a.get(asString);
                if (typeAdapter != null) {
                    return (R) typeAdapter.fromJsonTree(parse);
                }
                throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f12272a + " subtype named " + asString + "; did you forget to register a subtype?");
            }
            throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f12272a + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.f12273b);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, R r4) throws IOException {
            Class<?> cls = r4.getClass();
            String str = (String) RuntimeTypeAdapterFactory.this.f12275d.get(cls);
            TypeAdapter typeAdapter = (TypeAdapter) this.f12277b.get(cls);
            if (typeAdapter != null) {
                JsonObject asJsonObject = typeAdapter.toJsonTree(r4).getAsJsonObject();
                if (!asJsonObject.has(RuntimeTypeAdapterFactory.this.f12273b)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.add(RuntimeTypeAdapterFactory.this.f12273b, new JsonPrimitive(str));
                    for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
                        jsonObject.add(entry.getKey(), entry.getValue());
                    }
                    Streams.write(jsonObject, jsonWriter);
                    return;
                }
                throw new JsonParseException("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.f12273b);
            }
            throw new JsonParseException("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
        }
    }

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str != null && cls != null) {
            this.f12272a = cls;
            this.f12273b = str;
            return;
        }
        throw null;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.f12272a) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.f12274c.entrySet()) {
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), delegateAdapter);
            linkedHashMap2.put(entry.getValue(), delegateAdapter);
        }
        return new a(linkedHashMap, linkedHashMap2).nullSafe();
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls != null && str != null) {
            if (!this.f12275d.containsKey(cls) && !this.f12274c.containsKey(str)) {
                this.f12274c.put(str, cls);
                this.f12275d.put(cls, str);
                return this;
            }
            throw new IllegalArgumentException("types and labels must be unique");
        }
        throw null;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }
}
