package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.hippo.quickjs.android.TypeAdapter;
import java.lang.reflect.Type;

/* compiled from: StandardTypeAdapters.java */
/* loaded from: classes6.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    static final TypeAdapter.Factory f34095a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final TypeAdapter<Void> f34096b = new d();

    /* renamed from: c  reason: collision with root package name */
    private static final TypeAdapter<Boolean> f34097c = new e();

    /* renamed from: d  reason: collision with root package name */
    private static final TypeAdapter<Byte> f34098d = new f();

    /* renamed from: e  reason: collision with root package name */
    private static final TypeAdapter<Character> f34099e = new g();

    /* renamed from: f  reason: collision with root package name */
    private static final TypeAdapter<Short> f34100f = new h();

    /* renamed from: g  reason: collision with root package name */
    private static final TypeAdapter<Integer> f34101g = new i();

    /* renamed from: h  reason: collision with root package name */
    private static final TypeAdapter<Long> f34102h = new j();

    /* renamed from: i  reason: collision with root package name */
    private static final TypeAdapter<Float> f34103i = new k();

    /* renamed from: j  reason: collision with root package name */
    private static final TypeAdapter<Double> f34104j = new a();

    /* renamed from: k  reason: collision with root package name */
    private static final TypeAdapter<String> f34105k = new b();

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class a extends TypeAdapter<Double> {
        a() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Double fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Double.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getDouble());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Double d4) {
            return context.createJSNumber(d4.doubleValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class b extends TypeAdapter<String> {
        b() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public String fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return ((JSString) jSValue.cast(JSString.class)).getString();
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, String str) {
            return context.createJSString(str);
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class c implements TypeAdapter.Factory {
        c() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter.Factory
        @Nullable
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == Void.TYPE) {
                return l.f34096b;
            }
            if (type == Boolean.TYPE) {
                return l.f34097c;
            }
            if (type == Byte.TYPE) {
                return l.f34098d;
            }
            if (type == Character.TYPE) {
                return l.f34099e;
            }
            if (type == Short.TYPE) {
                return l.f34100f;
            }
            if (type == Integer.TYPE) {
                return l.f34101g;
            }
            if (type == Long.TYPE) {
                return l.f34102h;
            }
            if (type == Float.TYPE) {
                return l.f34103i;
            }
            if (type == Double.TYPE) {
                return l.f34104j;
            }
            if (type == Void.class) {
                return l.f34096b;
            }
            if (type == Boolean.class) {
                return l.f34097c.nullable();
            }
            if (type == Byte.class) {
                return l.f34098d.nullable();
            }
            if (type == Character.class) {
                return l.f34099e.nullable();
            }
            if (type == Short.class) {
                return l.f34100f.nullable();
            }
            if (type == Integer.class) {
                return l.f34101g.nullable();
            }
            if (type == Long.class) {
                return l.f34102h.nullable();
            }
            if (type == Float.class) {
                return l.f34103i.nullable();
            }
            if (type == Double.class) {
                return l.f34104j.nullable();
            }
            if (type == String.class) {
                return l.f34105k.nullable();
            }
            return null;
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class d extends TypeAdapter<Void> {
        d() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Void fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if (!(jSValue instanceof JSNull) && !(jSValue instanceof JSUndefined)) {
                throw new JSDataException("excepted: JSNull or JSUndefined, actual: " + jSValue.getClass().getSimpleName());
            }
            return null;
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Void r32) {
            return context.createJSNull();
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class e extends TypeAdapter<Boolean> {
        e() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Boolean fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Boolean bool) {
            return context.createJSBoolean(bool.booleanValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class f extends TypeAdapter<Byte> {
        f() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Byte fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Byte.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getByte());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Byte b4) {
            return context.createJSNumber((int) b4.byteValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class g extends TypeAdapter<Character> {
        g() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Character fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            String string = ((JSString) jSValue.cast(JSString.class)).getString();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new JSDataException("Can't treat \"" + string + "\" as char");
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Character ch) {
            return context.createJSString(ch.toString());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class h extends TypeAdapter<Short> {
        h() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Short fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Short.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getShort());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Short sh) {
            return context.createJSNumber((int) sh.shortValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class i extends TypeAdapter<Integer> {
        i() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Integer fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Integer.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getInt());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Integer num) {
            return context.createJSNumber(num.intValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class j extends TypeAdapter<Long> {
        j() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Long fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Long.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getLong());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Long l4) {
            return context.createJSNumber(l4.longValue());
        }
    }

    /* compiled from: StandardTypeAdapters.java */
    /* loaded from: classes6.dex */
    static class k extends TypeAdapter<Float> {
        k() {
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: a */
        public Float fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Float.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getFloat());
        }

        @Override // com.hippo.quickjs.android.TypeAdapter
        /* renamed from: b */
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Float f4) {
            return context.createJSNumber(f4.floatValue());
        }
    }
}
