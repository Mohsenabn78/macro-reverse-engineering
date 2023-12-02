package com.hippo.quickjs.android;

import com.hippo.quickjs.android.JSRuntime;
import com.hippo.quickjs.android.QuickJS;
import com.hippo.quickjs.android.TypeAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class QuickJS implements TypeAdapter.Depot {

    /* renamed from: c  reason: collision with root package name */
    private static final List<TypeAdapter.Factory> f34069c;

    /* renamed from: a  reason: collision with root package name */
    private final List<TypeAdapter.Factory> f34070a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Type, TypeAdapter<?>> f34071b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<TypeAdapter.Factory> f34072a = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TypeAdapter c(Type type, TypeAdapter typeAdapter, TypeAdapter.Depot depot, Type type2) {
            if (m.j(type, type2)) {
                return typeAdapter;
            }
            return null;
        }

        public QuickJS build() {
            return new QuickJS(this);
        }

        public <T> Builder registerTypeAdapter(final Type type, final TypeAdapter<T> typeAdapter) {
            return registerTypeAdapterFactory(new TypeAdapter.Factory() { // from class: com.hippo.quickjs.android.k
                @Override // com.hippo.quickjs.android.TypeAdapter.Factory
                public final TypeAdapter create(TypeAdapter.Depot depot, Type type2) {
                    TypeAdapter c4;
                    c4 = QuickJS.Builder.c(type, typeAdapter, depot, type2);
                    return c4;
                }
            });
        }

        public Builder registerTypeAdapterFactory(TypeAdapter.Factory factory) {
            this.f34072a.add(factory);
            return this;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f34069c = arrayList;
        arrayList.add(l.f34095a);
        arrayList.add(i.f34088a);
        arrayList.add(b.f34074c);
        arrayList.add(e.f34082c);
        System.loadLibrary("quickjs-android");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createContext(long j4);

    static native long createRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArray(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueBoolean(long j4, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFloat64(long j4, double d4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunction(long j4, JSContext jSContext, Object obj, String str, String str2, Type type, Type[] typeArr, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunctionS(long j4, JSContext jSContext, String str, String str2, String str3, Type type, Type[] typeArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueInt(long j4, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueJavaObject(long j4, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueNull(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueObject(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long[] createValuePromise(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueString(long j4, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueUndefined(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j4, long j5, int i4, long j6, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j4, long j5, String str, long j6, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyContext(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyRuntime(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyValue(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long evaluate(long j4, String str, String str2, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int executePendingJob(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native JSException getException(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getGlobalObject(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean getValueBoolean(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native double getValueFloat64(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueInt(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object getValueJavaObject(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j4, long j5, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j4, long j5, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getValueString(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueTag(long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long invokeValueFunction(long j4, long j5, long j6, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueArray(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueFunction(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeInterruptHandler(long j4, JSRuntime.InterruptHandler interruptHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeMallocLimit(long j4, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j4, long j5, int i4, long j6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j4, long j5, String str, long j6);

    public JSRuntime createJSRuntime() {
        long createRuntime = createRuntime();
        if (createRuntime != 0) {
            return new JSRuntime(createRuntime, this);
        }
        throw new IllegalStateException("Cannot create JSRuntime instance");
    }

    @Override // com.hippo.quickjs.android.TypeAdapter.Depot
    public <T> TypeAdapter<T> getAdapter(Type type) {
        Type o4 = m.o(m.g(type));
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.f34071b.get(o4);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        int size = this.f34070a.size();
        for (int i4 = 0; i4 < size; i4++) {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter<T>) this.f34070a.get(i4).create(this, o4);
            if (typeAdapter2 != null) {
                this.f34071b.put(o4, typeAdapter2);
                return typeAdapter2;
            }
        }
        throw new IllegalArgumentException("Can't find TypeAdapter for " + type);
    }

    private QuickJS(Builder builder) {
        int size = builder.f34072a.size();
        List<TypeAdapter.Factory> list = f34069c;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.f34072a);
        arrayList.addAll(list);
        this.f34070a = Collections.unmodifiableList(arrayList);
        this.f34071b = new ConcurrentHashMap();
    }
}
