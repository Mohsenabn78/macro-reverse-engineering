package com.google.gson;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class GsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Excluder f32575a;

    /* renamed from: b  reason: collision with root package name */
    private LongSerializationPolicy f32576b;

    /* renamed from: c  reason: collision with root package name */
    private FieldNamingStrategy f32577c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, InstanceCreator<?>> f32578d;

    /* renamed from: e  reason: collision with root package name */
    private final List<TypeAdapterFactory> f32579e;

    /* renamed from: f  reason: collision with root package name */
    private final List<TypeAdapterFactory> f32580f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32581g;

    /* renamed from: h  reason: collision with root package name */
    private String f32582h;

    /* renamed from: i  reason: collision with root package name */
    private int f32583i;

    /* renamed from: j  reason: collision with root package name */
    private int f32584j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f32585k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f32586l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f32587m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f32588n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f32589o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32590p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f32591q;

    /* renamed from: r  reason: collision with root package name */
    private ToNumberStrategy f32592r;

    /* renamed from: s  reason: collision with root package name */
    private ToNumberStrategy f32593s;

    /* renamed from: t  reason: collision with root package name */
    private final LinkedList<ReflectionAccessFilter> f32594t;

    public GsonBuilder() {
        this.f32575a = Excluder.DEFAULT;
        this.f32576b = LongSerializationPolicy.DEFAULT;
        this.f32577c = FieldNamingPolicy.IDENTITY;
        this.f32578d = new HashMap();
        this.f32579e = new ArrayList();
        this.f32580f = new ArrayList();
        this.f32581g = false;
        this.f32582h = Gson.f32544z;
        this.f32583i = 2;
        this.f32584j = 2;
        this.f32585k = false;
        this.f32586l = false;
        this.f32587m = true;
        this.f32588n = false;
        this.f32589o = false;
        this.f32590p = false;
        this.f32591q = true;
        this.f32592r = Gson.B;
        this.f32593s = Gson.C;
        this.f32594t = new LinkedList<>();
    }

    private void a(String str, int i4, int i5, List<TypeAdapterFactory> list) {
        TypeAdapterFactory typeAdapterFactory;
        TypeAdapterFactory typeAdapterFactory2;
        boolean z3 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory typeAdapterFactory3 = null;
        if (str != null && !str.trim().isEmpty()) {
            typeAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(str);
            if (z3) {
                typeAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(str);
                typeAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(str);
            }
            typeAdapterFactory2 = null;
        } else if (i4 != 2 && i5 != 2) {
            TypeAdapterFactory createAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(i4, i5);
            if (z3) {
                typeAdapterFactory3 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(i4, i5);
                TypeAdapterFactory createAdapterFactory2 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(i4, i5);
                typeAdapterFactory = createAdapterFactory;
                typeAdapterFactory2 = createAdapterFactory2;
            } else {
                typeAdapterFactory = createAdapterFactory;
                typeAdapterFactory2 = null;
            }
        } else {
            return;
        }
        list.add(typeAdapterFactory);
        if (z3) {
            list.add(typeAdapterFactory3);
            list.add(typeAdapterFactory2);
        }
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.f32575a = this.f32575a.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter reflectionAccessFilter) {
        Objects.requireNonNull(reflectionAccessFilter);
        this.f32594t.addFirst(reflectionAccessFilter);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.f32575a = this.f32575a.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> arrayList = new ArrayList<>(this.f32579e.size() + this.f32580f.size() + 3);
        arrayList.addAll(this.f32579e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f32580f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f32582h, this.f32583i, this.f32584j, arrayList);
        return new Gson(this.f32575a, this.f32577c, new HashMap(this.f32578d), this.f32581g, this.f32585k, this.f32589o, this.f32587m, this.f32588n, this.f32590p, this.f32586l, this.f32591q, this.f32576b, this.f32582h, this.f32583i, this.f32584j, new ArrayList(this.f32579e), new ArrayList(this.f32580f), arrayList, this.f32592r, this.f32593s, new ArrayList(this.f32594t));
    }

    public GsonBuilder disableHtmlEscaping() {
        this.f32587m = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.f32575a = this.f32575a.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.f32591q = false;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.f32585k = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        Objects.requireNonNull(iArr);
        this.f32575a = this.f32575a.withModifiers(iArr);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.f32575a = this.f32575a.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.f32589o = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z3;
        Objects.requireNonNull(type);
        boolean z4 = obj instanceof JsonSerializer;
        if (!z4 && !(obj instanceof JsonDeserializer) && !(obj instanceof InstanceCreator) && !(obj instanceof TypeAdapter)) {
            z3 = false;
        } else {
            z3 = true;
        }
        C$Gson$Preconditions.checkArgument(z3);
        if (obj instanceof InstanceCreator) {
            this.f32578d.put(type, (InstanceCreator) obj);
        }
        if (z4 || (obj instanceof JsonDeserializer)) {
            this.f32579e.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f32579e.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeAdapterFactory);
        this.f32579e.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z3;
        Objects.requireNonNull(cls);
        boolean z4 = obj instanceof JsonSerializer;
        if (!z4 && !(obj instanceof JsonDeserializer) && !(obj instanceof TypeAdapter)) {
            z3 = false;
        } else {
            z3 = true;
        }
        C$Gson$Preconditions.checkArgument(z3);
        if ((obj instanceof JsonDeserializer) || z4) {
            this.f32580f.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f32579e.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.f32581g = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.f32586l = true;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.f32582h = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        Objects.requireNonNull(exclusionStrategyArr);
        for (ExclusionStrategy exclusionStrategy : exclusionStrategyArr) {
            this.f32575a = this.f32575a.withExclusionStrategy(exclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        return setFieldNamingStrategy(fieldNamingPolicy);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        Objects.requireNonNull(fieldNamingStrategy);
        this.f32577c = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.f32590p = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        Objects.requireNonNull(longSerializationPolicy);
        this.f32576b = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        Objects.requireNonNull(toNumberStrategy);
        this.f32593s = toNumberStrategy;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        Objects.requireNonNull(toNumberStrategy);
        this.f32592r = toNumberStrategy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.f32588n = true;
        return this;
    }

    public GsonBuilder setVersion(double d4) {
        if (!Double.isNaN(d4) && d4 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.f32575a = this.f32575a.withVersion(d4);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d4);
    }

    public GsonBuilder setDateFormat(int i4) {
        this.f32583i = i4;
        this.f32582h = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i4, int i5) {
        this.f32583i = i4;
        this.f32584j = i5;
        this.f32582h = null;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonBuilder(Gson gson) {
        this.f32575a = Excluder.DEFAULT;
        this.f32576b = LongSerializationPolicy.DEFAULT;
        this.f32577c = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.f32578d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f32579e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f32580f = arrayList2;
        this.f32581g = false;
        this.f32582h = Gson.f32544z;
        this.f32583i = 2;
        this.f32584j = 2;
        this.f32585k = false;
        this.f32586l = false;
        this.f32587m = true;
        this.f32588n = false;
        this.f32589o = false;
        this.f32590p = false;
        this.f32591q = true;
        this.f32592r = Gson.B;
        this.f32593s = Gson.C;
        LinkedList<ReflectionAccessFilter> linkedList = new LinkedList<>();
        this.f32594t = linkedList;
        this.f32575a = gson.f32550f;
        this.f32577c = gson.f32551g;
        hashMap.putAll(gson.f32552h);
        this.f32581g = gson.f32553i;
        this.f32585k = gson.f32554j;
        this.f32589o = gson.f32555k;
        this.f32587m = gson.f32556l;
        this.f32588n = gson.f32557m;
        this.f32590p = gson.f32558n;
        this.f32586l = gson.f32559o;
        this.f32576b = gson.f32564t;
        this.f32582h = gson.f32561q;
        this.f32583i = gson.f32562r;
        this.f32584j = gson.f32563s;
        arrayList.addAll(gson.f32565u);
        arrayList2.addAll(gson.f32566v);
        this.f32591q = gson.f32560p;
        this.f32592r = gson.f32567w;
        this.f32593s = gson.f32568x;
        linkedList.addAll(gson.f32569y);
    }
}
