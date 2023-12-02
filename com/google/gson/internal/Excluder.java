package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();

    /* renamed from: d  reason: collision with root package name */
    private boolean f32630d;

    /* renamed from: a  reason: collision with root package name */
    private double f32627a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f32628b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32629c = true;

    /* renamed from: e  reason: collision with root package name */
    private List<ExclusionStrategy> f32631e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List<ExclusionStrategy> f32632f = Collections.emptyList();

    private boolean b(Class<?> cls) {
        if (this.f32627a != -1.0d && !i((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.f32629c && e(cls)) {
            return true;
        }
        return d(cls);
    }

    private boolean c(Class<?> cls, boolean z3) {
        List<ExclusionStrategy> list;
        if (z3) {
            list = this.f32631e;
        } else {
            list = this.f32632f;
        }
        for (ExclusionStrategy exclusionStrategy : list) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls) && !f(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean e(Class<?> cls) {
        if (cls.isMemberClass() && !f(cls)) {
            return true;
        }
        return false;
    }

    private boolean f(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean g(Since since) {
        if (since == null) {
            return true;
        }
        if (this.f32627a >= since.value()) {
            return true;
        }
        return false;
    }

    private boolean h(Until until) {
        if (until == null) {
            return true;
        }
        if (this.f32627a < until.value()) {
            return true;
        }
        return false;
    }

    private boolean i(Since since, Until until) {
        if (g(since) && h(until)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final boolean z3;
        final boolean z4;
        Class<? super T> rawType = typeToken.getRawType();
        boolean b4 = b(rawType);
        if (!b4 && !c(rawType, true)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!b4 && !c(rawType, false)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z3 && !z4) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1

            /* renamed from: a  reason: collision with root package name */
            private TypeAdapter<T> f32633a;

            private TypeAdapter<T> a() {
                TypeAdapter<T> typeAdapter = this.f32633a;
                if (typeAdapter == null) {
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.f32633a = delegateAdapter;
                    return delegateAdapter;
                }
                return typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (z4) {
                    jsonReader.skipValue();
                    return null;
                }
                return a().read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t3) throws IOException {
                if (z3) {
                    jsonWriter.nullValue();
                } else {
                    a().write(jsonWriter, t3);
                }
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.f32629c = false;
        return clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z3) {
        if (!b(cls) && !c(cls, z3)) {
            return false;
        }
        return true;
    }

    public boolean excludeField(Field field, boolean z3) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.f32628b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f32627a != -1.0d && !i((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f32630d && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z3 ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.f32629c && e(field.getType())) || d(field.getType())) {
            return true;
        }
        if (z3) {
            list = this.f32631e;
        } else {
            list = this.f32632f;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy exclusionStrategy : list) {
                if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.f32630d = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z3, boolean z4) {
        Excluder clone = clone();
        if (z3) {
            ArrayList arrayList = new ArrayList(this.f32631e);
            clone.f32631e = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z4) {
            ArrayList arrayList2 = new ArrayList(this.f32632f);
            clone.f32632f = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.f32628b = 0;
        for (int i4 : iArr) {
            clone.f32628b = i4 | clone.f32628b;
        }
        return clone;
    }

    public Excluder withVersion(double d4) {
        Excluder clone = clone();
        clone.f32627a = d4;
        return clone;
    }
}
