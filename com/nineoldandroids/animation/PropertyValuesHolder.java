package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes6.dex */
public class PropertyValuesHolder implements Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final TypeEvaluator f36331k = new IntEvaluator();

    /* renamed from: l  reason: collision with root package name */
    private static final TypeEvaluator f36332l = new FloatEvaluator();

    /* renamed from: m  reason: collision with root package name */
    private static Class[] f36333m;

    /* renamed from: n  reason: collision with root package name */
    private static Class[] f36334n;

    /* renamed from: o  reason: collision with root package name */
    private static Class[] f36335o;

    /* renamed from: p  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f36336p;

    /* renamed from: q  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f36337q;

    /* renamed from: a  reason: collision with root package name */
    String f36338a;

    /* renamed from: b  reason: collision with root package name */
    protected Property f36339b;

    /* renamed from: c  reason: collision with root package name */
    Method f36340c;

    /* renamed from: d  reason: collision with root package name */
    private Method f36341d;

    /* renamed from: e  reason: collision with root package name */
    Class f36342e;

    /* renamed from: f  reason: collision with root package name */
    com.nineoldandroids.animation.c f36343f;

    /* renamed from: g  reason: collision with root package name */
    final ReentrantReadWriteLock f36344g;

    /* renamed from: h  reason: collision with root package name */
    final Object[] f36345h;

    /* renamed from: i  reason: collision with root package name */
    private TypeEvaluator f36346i;

    /* renamed from: j  reason: collision with root package name */
    private Object f36347j;

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f36333m = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f36334n = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f36335o = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f36336p = new HashMap<>();
        f36337q = new HashMap<>();
    }

    static String c(String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            char upperCase = Character.toUpperCase(str2.charAt(0));
            String substring = str2.substring(1);
            return str + upperCase + substring;
        }
        return str;
    }

    private Method d(Class cls, String str, Class cls2) {
        Class<?>[] clsArr;
        String c4 = c(str, this.f36338a);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(c4, null);
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(c4, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f36338a + ": " + e4);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            if (this.f36342e.equals(Float.class)) {
                clsArr = f36333m;
            } else if (this.f36342e.equals(Integer.class)) {
                clsArr = f36334n;
            } else {
                clsArr = this.f36342e.equals(Double.class) ? f36335o : new Class[]{this.f36342e};
            }
            for (Class<?> cls3 : clsArr) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(c4, clsArr2);
                        this.f36342e = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                    }
                } catch (NoSuchMethodException unused3) {
                    method = cls.getDeclaredMethod(c4, clsArr2);
                    method.setAccessible(true);
                    this.f36342e = cls3;
                    return method;
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f36338a + " with value type " + this.f36342e);
        }
        return method;
    }

    private void h(Class cls) {
        this.f36341d = k(cls, f36337q, "get", null);
    }

    private Method k(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method;
        try {
            this.f36344g.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            if (hashMap2 != null) {
                method = hashMap2.get(this.f36338a);
            } else {
                method = null;
            }
            if (method == null) {
                method = d(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f36338a, method);
            }
            return method;
        } finally {
            this.f36344g.writeLock().unlock();
        }
    }

    private void m(Object obj, Keyframe keyframe) {
        Property property = this.f36339b;
        if (property != null) {
            keyframe.setValue(property.get(obj));
        }
        try {
            if (this.f36341d == null) {
                h(obj.getClass());
            }
            keyframe.setValue(this.f36341d.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e4) {
            Log.e("PropertyValuesHolder", e4.toString());
        } catch (InvocationTargetException e5) {
            Log.e("PropertyValuesHolder", e5.toString());
        }
    }

    public static PropertyValuesHolder ofFloat(String str, float... fArr) {
        return new b(str, fArr);
    }

    public static PropertyValuesHolder ofInt(String str, int... iArr) {
        return new c(str, iArr);
    }

    public static PropertyValuesHolder ofKeyframe(String str, Keyframe... keyframeArr) {
        com.nineoldandroids.animation.c e4 = com.nineoldandroids.animation.c.e(keyframeArr);
        if (e4 instanceof com.nineoldandroids.animation.b) {
            return new c(str, (com.nineoldandroids.animation.b) e4);
        }
        if (e4 instanceof com.nineoldandroids.animation.a) {
            return new b(str, (com.nineoldandroids.animation.a) e4);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.f36343f = e4;
        propertyValuesHolder.f36342e = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f4) {
        this.f36347j = this.f36343f.b(f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b() {
        return this.f36347j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        TypeEvaluator typeEvaluator;
        if (this.f36346i == null) {
            Class cls = this.f36342e;
            if (cls == Integer.class) {
                typeEvaluator = f36331k;
            } else if (cls == Float.class) {
                typeEvaluator = f36332l;
            } else {
                typeEvaluator = null;
            }
            this.f36346i = typeEvaluator;
        }
        TypeEvaluator typeEvaluator2 = this.f36346i;
        if (typeEvaluator2 != null) {
            this.f36343f.g(typeEvaluator2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Object obj) {
        Property property = this.f36339b;
        if (property != null) {
            property.set(obj, b());
        }
        if (this.f36340c != null) {
            try {
                this.f36345h[0] = b();
                this.f36340c.invoke(obj, this.f36345h);
            } catch (IllegalAccessException e4) {
                Log.e("PropertyValuesHolder", e4.toString());
            } catch (InvocationTargetException e5) {
                Log.e("PropertyValuesHolder", e5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Object obj) {
        ArrayList<Keyframe> arrayList = this.f36343f.f36391e;
        m(obj, arrayList.get(arrayList.size() - 1));
    }

    public String getPropertyName() {
        return this.f36338a;
    }

    void i(Class cls) {
        this.f36340c = k(cls, f36336p, "set", this.f36342e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Object obj) {
        Property property = this.f36339b;
        if (property != null) {
            try {
                property.get(obj);
                Iterator<Keyframe> it = this.f36343f.f36391e.iterator();
                while (it.hasNext()) {
                    Keyframe next = it.next();
                    if (!next.hasValue()) {
                        next.setValue(this.f36339b.get(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f36339b.getName() + ") on target object " + obj + ". Trying reflection instead");
                this.f36339b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f36340c == null) {
            i(cls);
        }
        Iterator<Keyframe> it2 = this.f36343f.f36391e.iterator();
        while (it2.hasNext()) {
            Keyframe next2 = it2.next();
            if (!next2.hasValue()) {
                if (this.f36341d == null) {
                    h(cls);
                }
                try {
                    next2.setValue(this.f36341d.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Object obj) {
        m(obj, this.f36343f.f36391e.get(0));
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.f36346i = typeEvaluator;
        this.f36343f.g(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        this.f36342e = Float.TYPE;
        this.f36343f = com.nineoldandroids.animation.c.c(fArr);
    }

    public void setIntValues(int... iArr) {
        this.f36342e = Integer.TYPE;
        this.f36343f = com.nineoldandroids.animation.c.d(iArr);
    }

    public void setKeyframes(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.f36342e = keyframeArr[0].getType();
        for (int i4 = 0; i4 < length; i4++) {
            keyframeArr2[i4] = keyframeArr[i4];
        }
        this.f36343f = new com.nineoldandroids.animation.c(keyframeArr2);
    }

    public void setObjectValues(Object... objArr) {
        this.f36342e = objArr[0].getClass();
        this.f36343f = com.nineoldandroids.animation.c.f(objArr);
    }

    public void setProperty(Property property) {
        this.f36339b = property;
    }

    public void setPropertyName(String str) {
        this.f36338a = str;
    }

    public String toString() {
        return this.f36338a + ": " + this.f36343f.toString();
    }

    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... fArr) {
        return new b(property, fArr);
    }

    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... iArr) {
        return new c(property, iArr);
    }

    @Override // 
    /* renamed from: clone */
    public PropertyValuesHolder mo4177clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.f36338a = this.f36338a;
            propertyValuesHolder.f36339b = this.f36339b;
            propertyValuesHolder.f36343f = this.f36343f.clone();
            propertyValuesHolder.f36346i = this.f36346i;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    private PropertyValuesHolder(String str) {
        this.f36340c = null;
        this.f36341d = null;
        this.f36343f = null;
        this.f36344g = new ReentrantReadWriteLock();
        this.f36345h = new Object[1];
        this.f36338a = str;
    }

    /* loaded from: classes6.dex */
    static class b extends PropertyValuesHolder {

        /* renamed from: r  reason: collision with root package name */
        private FloatProperty f36348r;

        /* renamed from: s  reason: collision with root package name */
        com.nineoldandroids.animation.a f36349s;

        /* renamed from: t  reason: collision with root package name */
        float f36350t;

        public b(String str, com.nineoldandroids.animation.a aVar) {
            super(str);
            this.f36342e = Float.TYPE;
            this.f36343f = aVar;
            this.f36349s = aVar;
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void a(float f4) {
            this.f36350t = this.f36349s.i(f4);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        Object b() {
            return Float.valueOf(this.f36350t);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void f(Object obj) {
            FloatProperty floatProperty = this.f36348r;
            if (floatProperty != null) {
                floatProperty.setValue(obj, this.f36350t);
                return;
            }
            Property property = this.f36339b;
            if (property != null) {
                property.set(obj, Float.valueOf(this.f36350t));
            } else if (this.f36340c != null) {
                try {
                    this.f36345h[0] = Float.valueOf(this.f36350t);
                    this.f36340c.invoke(obj, this.f36345h);
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void i(Class cls) {
            if (this.f36339b != null) {
                return;
            }
            super.i(cls);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        /* renamed from: n */
        public b mo4177clone() {
            b bVar = (b) super.mo4177clone();
            bVar.f36349s = (com.nineoldandroids.animation.a) bVar.f36343f;
            return bVar;
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.f36349s = (com.nineoldandroids.animation.a) this.f36343f;
        }

        public b(Property property, com.nineoldandroids.animation.a aVar) {
            super(property);
            this.f36342e = Float.TYPE;
            this.f36343f = aVar;
            this.f36349s = aVar;
            if (property instanceof FloatProperty) {
                this.f36348r = (FloatProperty) this.f36339b;
            }
        }

        public b(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        public b(Property property, float... fArr) {
            super(property);
            setFloatValues(fArr);
            if (property instanceof FloatProperty) {
                this.f36348r = (FloatProperty) this.f36339b;
            }
        }
    }

    /* loaded from: classes6.dex */
    static class c extends PropertyValuesHolder {

        /* renamed from: r  reason: collision with root package name */
        private IntProperty f36351r;

        /* renamed from: s  reason: collision with root package name */
        com.nineoldandroids.animation.b f36352s;

        /* renamed from: t  reason: collision with root package name */
        int f36353t;

        public c(String str, com.nineoldandroids.animation.b bVar) {
            super(str);
            this.f36342e = Integer.TYPE;
            this.f36343f = bVar;
            this.f36352s = bVar;
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void a(float f4) {
            this.f36353t = this.f36352s.i(f4);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        Object b() {
            return Integer.valueOf(this.f36353t);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void f(Object obj) {
            IntProperty intProperty = this.f36351r;
            if (intProperty != null) {
                intProperty.setValue(obj, this.f36353t);
                return;
            }
            Property property = this.f36339b;
            if (property != null) {
                property.set(obj, Integer.valueOf(this.f36353t));
            } else if (this.f36340c != null) {
                try {
                    this.f36345h[0] = Integer.valueOf(this.f36353t);
                    this.f36340c.invoke(obj, this.f36345h);
                } catch (IllegalAccessException e4) {
                    Log.e("PropertyValuesHolder", e4.toString());
                } catch (InvocationTargetException e5) {
                    Log.e("PropertyValuesHolder", e5.toString());
                }
            }
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        void i(Class cls) {
            if (this.f36339b != null) {
                return;
            }
            super.i(cls);
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        /* renamed from: n */
        public c mo4177clone() {
            c cVar = (c) super.mo4177clone();
            cVar.f36352s = (com.nineoldandroids.animation.b) cVar.f36343f;
            return cVar;
        }

        @Override // com.nineoldandroids.animation.PropertyValuesHolder
        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.f36352s = (com.nineoldandroids.animation.b) this.f36343f;
        }

        public c(Property property, com.nineoldandroids.animation.b bVar) {
            super(property);
            this.f36342e = Integer.TYPE;
            this.f36343f = bVar;
            this.f36352s = bVar;
            if (property instanceof IntProperty) {
                this.f36351r = (IntProperty) this.f36339b;
            }
        }

        public c(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        public c(Property property, int... iArr) {
            super(property);
            setIntValues(iArr);
            if (property instanceof IntProperty) {
                this.f36351r = (IntProperty) this.f36339b;
            }
        }
    }

    public static <V> PropertyValuesHolder ofObject(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... keyframeArr) {
        com.nineoldandroids.animation.c e4 = com.nineoldandroids.animation.c.e(keyframeArr);
        if (e4 instanceof com.nineoldandroids.animation.b) {
            return new c(property, (com.nineoldandroids.animation.b) e4);
        }
        if (e4 instanceof com.nineoldandroids.animation.a) {
            return new b(property, (com.nineoldandroids.animation.a) e4);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.f36343f = e4;
        propertyValuesHolder.f36342e = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    private PropertyValuesHolder(Property property) {
        this.f36340c = null;
        this.f36341d = null;
        this.f36343f = null;
        this.f36344g = new ReentrantReadWriteLock();
        this.f36345h = new Object[1];
        this.f36339b = property;
        if (property != null) {
            this.f36338a = property.getName();
        }
    }
}
