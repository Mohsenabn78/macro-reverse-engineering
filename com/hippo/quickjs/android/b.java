package com.hippo.quickjs.android;

import com.hippo.quickjs.android.TypeAdapter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes6.dex */
class b extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapter.Factory f34074c = new TypeAdapter.Factory() { // from class: com.hippo.quickjs.android.a
        @Override // com.hippo.quickjs.android.TypeAdapter.Factory
        public final TypeAdapter create(TypeAdapter.Depot depot, Type type) {
            TypeAdapter b4;
            b4 = b.b(depot, type);
            return b4;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f34075a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<Object> f34076b;

    private b(Class<?> cls, TypeAdapter<Object> typeAdapter) {
        this.f34075a = cls;
        this.f34076b = typeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeAdapter b(TypeAdapter.Depot depot, Type type) {
        Type e4 = m.e(type);
        if (e4 == null) {
            return null;
        }
        return new b(m.l(e4), depot.getAdapter(e4)).nullable();
    }

    @Override // com.hippo.quickjs.android.TypeAdapter
    public Object fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
        JSArray jSArray = (JSArray) jSValue.cast(JSArray.class);
        int length = jSArray.getLength();
        Object newInstance = Array.newInstance(this.f34075a, length);
        for (int i4 = 0; i4 < length; i4++) {
            Array.set(newInstance, i4, this.f34076b.fromJSValue(depot, context, jSArray.getProperty(i4)));
        }
        return newInstance;
    }

    @Override // com.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        JSArray createJSArray = context.createJSArray();
        int length = Array.getLength(obj);
        for (int i4 = 0; i4 < length; i4++) {
            createJSArray.setProperty(i4, this.f34076b.toJSValue(depot, context, Array.get(obj, i4)));
        }
        return createJSArray;
    }
}
