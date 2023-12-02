package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.hippo.quickjs.android.TypeAdapter;
import java.lang.reflect.Type;

/* compiled from: JSValueAdapter.java */
/* loaded from: classes6.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    static final TypeAdapter.Factory f34088a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final TypeAdapter<JSValue> f34089b = new b();

    /* compiled from: JSValueAdapter.java */
    /* loaded from: classes6.dex */
    static class a implements TypeAdapter.Factory {
        a() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter.Factory
        @Nullable
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == JSValue.class) {
                return i.f34089b;
            }
            return null;
        }
    }

    /* compiled from: JSValueAdapter.java */
    /* loaded from: classes6.dex */
    static class b extends TypeAdapter<JSValue> {
        b() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if (jSValue != null) {
                return jSValue;
            }
            throw new NullPointerException("value == null");
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public JSValue fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return jSValue;
        }
    }
}
