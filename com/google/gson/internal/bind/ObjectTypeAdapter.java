package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    private static final TypeAdapterFactory f32702c = a(ToNumberPolicy.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final Gson f32703a;

    /* renamed from: b  reason: collision with root package name */
    private final ToNumberStrategy f32704b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32706a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f32706a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32706a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32706a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32706a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32706a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32706a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static TypeAdapterFactory a(final ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Object.class) {
                    return null;
                }
                return new ObjectTypeAdapter(gson, ToNumberStrategy.this);
            }
        };
    }

    private Object b(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = AnonymousClass2.f32706a[jsonToken.ordinal()];
        if (i4 != 3) {
            if (i4 != 4) {
                if (i4 != 5) {
                    if (i4 == 6) {
                        jsonReader.nextNull();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            return this.f32704b.readNumber(jsonReader);
        }
        return jsonReader.nextString();
    }

    private Object c(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = AnonymousClass2.f32706a[jsonToken.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
        jsonReader.beginArray();
        return new ArrayList();
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.DOUBLE) {
            return f32702c;
        }
        return a(toNumberStrategy);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        String str;
        boolean z3;
        JsonToken peek = jsonReader.peek();
        Object c4 = c(jsonReader, peek);
        if (c4 == null) {
            return b(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (c4 instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Object c5 = c(jsonReader, peek2);
                if (c5 != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (c5 == null) {
                    c5 = b(jsonReader, peek2);
                }
                if (c4 instanceof List) {
                    ((List) c4).add(c5);
                } else {
                    ((Map) c4).put(str, c5);
                }
                if (z3) {
                    arrayDeque.addLast(c4);
                    c4 = c5;
                }
            } else {
                if (c4 instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return c4;
                }
                c4 = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.f32703a.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, obj);
    }

    private ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.f32703a = gson;
        this.f32704b = toNumberStrategy;
    }
}
