package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    private final c<a, Object> f16836a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16837b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f16838c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.a<?>> f16839d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16840e;

    /* renamed from: f  reason: collision with root package name */
    private int f16841f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        private final b f16842a;

        /* renamed from: b  reason: collision with root package name */
        int f16843b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f16844c;

        a(b bVar) {
            this.f16842a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
        public void a() {
            this.f16842a.c(this);
        }

        void b(int i4, Class<?> cls) {
            this.f16843b = i4;
            this.f16844c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f16843b != aVar.f16843b || this.f16844c != aVar.f16844c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i4;
            int i5 = this.f16843b * 31;
            Class<?> cls = this.f16844c;
            if (cls != null) {
                i4 = cls.hashCode();
            } else {
                i4 = 0;
            }
            return i5 + i4;
        }

        public String toString() {
            return "Key{size=" + this.f16843b + "array=" + this.f16844c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b extends com.bumptech.glide.load.engine.bitmap_recycle.b<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i4, Class<?> cls) {
            a b4 = b();
            b4.b(i4, cls);
            return b4;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.f16836a = new c<>();
        this.f16837b = new b();
        this.f16838c = new HashMap();
        this.f16839d = new HashMap();
        this.f16840e = 4194304;
    }

    private void a(int i4, Class<?> cls) {
        NavigableMap<Integer, Integer> h4 = h(cls);
        Integer num = h4.get(Integer.valueOf(i4));
        if (num != null) {
            if (num.intValue() == 1) {
                h4.remove(Integer.valueOf(i4));
                return;
            } else {
                h4.put(Integer.valueOf(i4), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i4 + ", this: " + this);
    }

    private void b() {
        c(this.f16840e);
    }

    private void c(int i4) {
        while (this.f16841f > i4) {
            Object f4 = this.f16836a.f();
            Preconditions.checkNotNull(f4);
            com.bumptech.glide.load.engine.bitmap_recycle.a d4 = d(f4);
            this.f16841f -= d4.getArrayLength(f4) * d4.getElementSizeInBytes();
            a(d4.getArrayLength(f4), f4.getClass());
            if (Log.isLoggable(d4.getTag(), 2)) {
                d4.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(d4.getArrayLength(f4));
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> d(T t3) {
        return e(t3.getClass());
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> e(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (com.bumptech.glide.load.engine.bitmap_recycle.a<T>) this.f16839d.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f16839d.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    @Nullable
    private <T> T f(a aVar) {
        return (T) this.f16836a.a(aVar);
    }

    private <T> T g(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> e4 = e(cls);
        T t3 = (T) f(aVar);
        if (t3 != null) {
            this.f16841f -= e4.getArrayLength(t3) * e4.getElementSizeInBytes();
            a(e4.getArrayLength(t3), cls);
        }
        if (t3 == null) {
            if (Log.isLoggable(e4.getTag(), 2)) {
                e4.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append("Allocated ");
                sb.append(aVar.f16843b);
                sb.append(" bytes");
            }
            return e4.newArray(aVar.f16843b);
        }
        return t3;
    }

    private NavigableMap<Integer, Integer> h(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f16838c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f16838c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean i() {
        int i4 = this.f16841f;
        if (i4 != 0 && this.f16840e / i4 < 2) {
            return false;
        }
        return true;
    }

    private boolean j(int i4) {
        if (i4 <= this.f16840e / 2) {
            return true;
        }
        return false;
    }

    private boolean k(int i4, Integer num) {
        if (num != null && (i() || num.intValue() <= i4 * 8)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        c(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i4, Class<T> cls) {
        a e4;
        Integer ceilingKey = h(cls).ceilingKey(Integer.valueOf(i4));
        if (k(i4, ceilingKey)) {
            e4 = this.f16837b.e(ceilingKey.intValue(), cls);
        } else {
            e4 = this.f16837b.e(i4, cls);
        }
        return (T) g(e4, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i4, Class<T> cls) {
        return (T) g(this.f16837b.e(i4, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t3, Class<T> cls) {
        put(t3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i4) {
        try {
            if (i4 >= 40) {
                clearMemory();
            } else if (i4 >= 20 || i4 == 15) {
                c(this.f16840e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t3) {
        Class<?> cls = t3.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> e4 = e(cls);
        int arrayLength = e4.getArrayLength(t3);
        int elementSizeInBytes = e4.getElementSizeInBytes() * arrayLength;
        if (j(elementSizeInBytes)) {
            a e5 = this.f16837b.e(arrayLength, cls);
            this.f16836a.d(e5, t3);
            NavigableMap<Integer, Integer> h4 = h(cls);
            Integer num = h4.get(Integer.valueOf(e5.f16843b));
            Integer valueOf = Integer.valueOf(e5.f16843b);
            int i4 = 1;
            if (num != null) {
                i4 = 1 + num.intValue();
            }
            h4.put(valueOf, Integer.valueOf(i4));
            this.f16841f += elementSizeInBytes;
            b();
        }
    }

    public LruArrayPool(int i4) {
        this.f16836a = new c<>();
        this.f16837b = new b();
        this.f16838c = new HashMap();
        this.f16839d = new HashMap();
        this.f16840e = i4;
    }
}
