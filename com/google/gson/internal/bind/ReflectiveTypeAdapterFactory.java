package com.google.gson.internal.bind;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ConstructorConstructor f32707a;

    /* renamed from: b  reason: collision with root package name */
    private final FieldNamingStrategy f32708b;

    /* renamed from: c  reason: collision with root package name */
    private final Excluder f32709c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f32710d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ReflectionAccessFilter> f32711e;

    /* loaded from: classes5.dex */
    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        final Map<String, BoundField> f32721a;

        Adapter(Map<String, BoundField> map) {
            this.f32721a = map;
        }

        abstract A a();

        abstract T b(A a4);

        abstract void c(A a4, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A a4 = a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.f32721a.get(jsonReader.nextName());
                    if (boundField != null && boundField.f32726e) {
                        c(a4, jsonReader, boundField);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return b(a4);
            } catch (IllegalAccessException e4) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e4);
            } catch (IllegalStateException e5) {
                throw new JsonSyntaxException(e5);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t3) throws IOException {
            if (t3 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.f32721a.values()) {
                    boundField.c(jsonWriter, t3);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e4) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class BoundField {

        /* renamed from: a  reason: collision with root package name */
        final String f32722a;

        /* renamed from: b  reason: collision with root package name */
        final Field f32723b;

        /* renamed from: c  reason: collision with root package name */
        final String f32724c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f32725d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f32726e;

        protected BoundField(String str, Field field, boolean z3, boolean z4) {
            this.f32722a = str;
            this.f32723b = field;
            this.f32724c = field.getName();
            this.f32725d = z3;
            this.f32726e = z4;
        }

        abstract void a(JsonReader jsonReader, int i4, Object[] objArr) throws IOException, JsonParseException;

        abstract void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    /* loaded from: classes5.dex */
    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e  reason: collision with root package name */
        static final Map<Class<?>, Object> f32728e = f();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor<T> f32729b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f32730c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Integer> f32731d;

        RecordAdapter(Class<T> cls, Map<String, BoundField> map, boolean z3) {
            super(map);
            this.f32731d = new HashMap();
            Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.f32729b = canonicalRecordConstructor;
            if (z3) {
                ReflectiveTypeAdapterFactory.b(null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i4 = 0; i4 < recordComponentNames.length; i4++) {
                this.f32731d.put(recordComponentNames[i4], Integer.valueOf(i4));
            }
            Class<?>[] parameterTypes = this.f32729b.getParameterTypes();
            this.f32730c = new Object[parameterTypes.length];
            for (int i5 = 0; i5 < parameterTypes.length; i5++) {
                this.f32730c[i5] = f32728e.get(parameterTypes[i5]);
            }
        }

        private static Map<Class<?>, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: d */
        public Object[] a() {
            return (Object[]) this.f32730c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: e */
        public T b(Object[] objArr) {
            try {
                return this.f32729b.newInstance(objArr);
            } catch (IllegalAccessException e4) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e4);
            } catch (IllegalArgumentException e5) {
                e = e5;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f32729b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e6) {
                e = e6;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f32729b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f32729b) + "' with args " + Arrays.toString(objArr), e7.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: g */
        public void c(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer num = this.f32731d.get(boundField.f32724c);
            if (num != null) {
                boundField.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.f32729b) + "' for field with name '" + boundField.f32724c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.f32707a = constructorConstructor;
        this.f32708b = fieldNamingStrategy;
        this.f32709c = excluder;
        this.f32710d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f32711e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void b(Object obj, M m4) {
        if (Modifier.isStatic(m4.getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(m4, obj)) {
            return;
        }
        String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(m4, true);
        throw new JsonIOException(accessibleObjectDescription + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField c(final Gson gson, Field field, final Method method, String str, final TypeToken<?> typeToken, boolean z3, boolean z4, final boolean z5) {
        final boolean z6;
        TypeAdapter<?> typeAdapter;
        final boolean z7;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z6 = true;
        } else {
            z6 = false;
        }
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) {
            typeAdapter = this.f32710d.a(this.f32707a, gson, typeToken, jsonAdapter);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        return new BoundField(str, field, z3, z4) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void a(JsonReader jsonReader, int i4, Object[] objArr) throws IOException, JsonParseException {
                Object read = typeAdapter2.read(jsonReader);
                if (read == null && isPrimitive) {
                    throw new JsonParseException("null is not allowed as value for record component '" + this.f32724c + "' of primitive type; at path " + jsonReader.getPath());
                }
                objArr[i4] = read;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    if (z5) {
                        ReflectiveTypeAdapterFactory.b(obj, this.f32723b);
                    } else if (z6) {
                        String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(this.f32723b, false);
                        throw new JsonIOException("Cannot set value of 'static final' " + accessibleObjectDescription);
                    }
                    this.f32723b.set(obj, read);
                }
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                Object obj2;
                TypeAdapter typeAdapterRuntimeTypeWrapper;
                if (!this.f32725d) {
                    return;
                }
                if (z5) {
                    Method method2 = method;
                    if (method2 == null) {
                        ReflectiveTypeAdapterFactory.b(obj, this.f32723b);
                    } else {
                        ReflectiveTypeAdapterFactory.b(obj, method2);
                    }
                }
                Method method3 = method;
                if (method3 != null) {
                    try {
                        obj2 = method3.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e4) {
                        String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(method, false);
                        throw new JsonIOException("Accessor " + accessibleObjectDescription + " threw exception", e4.getCause());
                    }
                } else {
                    obj2 = this.f32723b.get(obj);
                }
                if (obj2 == obj) {
                    return;
                }
                jsonWriter.name(this.f32722a);
                if (z7) {
                    typeAdapterRuntimeTypeWrapper = typeAdapter2;
                } else {
                    typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType());
                }
                typeAdapterRuntimeTypeWrapper.write(jsonWriter, obj2);
            }
        };
    }

    private Map<String, BoundField> d(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z3, boolean z4) {
        boolean z5;
        Method method;
        BoundField boundField;
        int i4;
        int i5;
        boolean z6;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        boolean z7 = z3;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z8 = true;
            boolean z9 = false;
            if (cls2 != cls && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.f32711e, cls2);
                if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls2 + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z10 = z7;
            int length = declaredFields.length;
            int i6 = 0;
            while (i6 < length) {
                Field field = declaredFields[i6];
                boolean f4 = reflectiveTypeAdapterFactory.f(field, z8);
                boolean f5 = reflectiveTypeAdapterFactory.f(field, z9);
                if (!f4 && !f5) {
                    i4 = i6;
                    i5 = length;
                } else {
                    BoundField boundField2 = null;
                    if (z4) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            method = null;
                            z5 = false;
                        } else {
                            Method accessor = ReflectionHelper.getAccessor(cls2, field);
                            if (!z10) {
                                ReflectionHelper.makeAccessible(accessor);
                            }
                            if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                                throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(accessor, z9) + " is not supported");
                            }
                            z5 = f5;
                            method = accessor;
                        }
                    } else {
                        z5 = f5;
                        method = null;
                    }
                    if (!z10 && method == null) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> e4 = reflectiveTypeAdapterFactory.e(field);
                    int size = e4.size();
                    int i7 = 0;
                    while (i7 < size) {
                        String str = e4.get(i7);
                        if (i7 != 0) {
                            z6 = false;
                        } else {
                            z6 = f4;
                        }
                        int i8 = i7;
                        BoundField boundField3 = boundField2;
                        int i9 = size;
                        List<String> list = e4;
                        Field field2 = field;
                        int i10 = i6;
                        int i11 = length;
                        BoundField boundField4 = (BoundField) linkedHashMap.put(str, c(gson, field, method, str, TypeToken.get(resolve), z6, z5, z10));
                        if (boundField3 == null) {
                            boundField2 = boundField4;
                        } else {
                            boundField2 = boundField3;
                        }
                        i7 = i8 + 1;
                        f4 = z6;
                        i6 = i10;
                        size = i9;
                        e4 = list;
                        field = field2;
                        length = i11;
                    }
                    Field field3 = field;
                    i4 = i6;
                    i5 = length;
                    if (boundField2 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + boundField.f32722a + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(boundField.f32723b) + " and " + ReflectionHelper.fieldToString(field3));
                    }
                }
                i6 = i4 + 1;
                length = i5;
                z9 = false;
                z8 = true;
                reflectiveTypeAdapterFactory = this;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            z7 = z10;
        }
        return linkedHashMap;
    }

    private List<String> e(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f32708b.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean f(Field field, boolean z3) {
        if (!this.f32709c.excludeClass(field.getType(), z3) && !this.f32709c.excludeField(field, z3)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z3;
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.f32711e, rawType);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (ReflectionHelper.isRecord(rawType)) {
                return new RecordAdapter(rawType, d(gson, typeToken, rawType, z3, true), z3);
            }
            return new FieldReflectionAdapter(this.f32707a.get(typeToken), d(gson, typeToken, rawType, z3, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* loaded from: classes5.dex */
    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b  reason: collision with root package name */
        private final ObjectConstructor<T> f32727b;

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            super(map);
            this.f32727b = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T a() {
            return this.f32727b.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void c(T t3, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.b(jsonReader, t3);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T b(T t3) {
            return t3;
        }
    }
}
