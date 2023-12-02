package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public abstract class TypeAdapter<T> {

    /* loaded from: classes6.dex */
    public interface Context {
        JSArray createJSArray();

        JSBoolean createJSBoolean(boolean z3);

        JSFunction createJSFunction(Object obj, Method method);

        JSFunction createJSFunctionS(Class cls, Method method);

        JSNull createJSNull();

        JSNumber createJSNumber(double d4);

        JSNumber createJSNumber(int i4);

        JSObject createJSObject();

        JSObject createJSObject(Object obj);

        JSString createJSString(String str);

        JSUndefined createJSUndefined();
    }

    /* loaded from: classes6.dex */
    public interface Depot {
        <T> TypeAdapter<T> getAdapter(Type type);
    }

    /* loaded from: classes6.dex */
    public interface Factory {
        @Nullable
        TypeAdapter<?> create(Depot depot, Type type);
    }

    /* loaded from: classes6.dex */
    private static class a<T> extends TypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter<T> f34073a;

        a(TypeAdapter<T> typeAdapter) {
            this.f34073a = typeAdapter;
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        public T fromJSValue(Depot depot, Context context, JSValue jSValue) {
            if (!(jSValue instanceof JSNull) && !(jSValue instanceof JSUndefined)) {
                return this.f34073a.fromJSValue(depot, context, jSValue);
            }
            return null;
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        public JSValue toJSValue(Depot depot, Context context, T t3) {
            if (t3 == null) {
                return context.createJSNull();
            }
            return this.f34073a.toJSValue(depot, context, t3);
        }
    }

    public abstract T fromJSValue(Depot depot, Context context, JSValue jSValue);

    public final TypeAdapter<T> nullable() {
        return new a(this);
    }

    public abstract JSValue toJSValue(Depot depot, Context context, T t3);
}
