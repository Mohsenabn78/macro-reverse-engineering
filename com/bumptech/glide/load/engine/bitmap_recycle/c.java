package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes3.dex */
class c<K extends e, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f16869a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f16870b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes3.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f16871a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f16872b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f16873c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f16874d;

        a() {
            this(null);
        }

        public void a(V v3) {
            if (this.f16872b == null) {
                this.f16872b = new ArrayList();
            }
            this.f16872b.add(v3);
        }

        @Nullable
        public V b() {
            int c4 = c();
            if (c4 > 0) {
                return this.f16872b.remove(c4 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f16872b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k4) {
            this.f16874d = this;
            this.f16873c = this;
            this.f16871a = k4;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16869a;
        aVar.f16874d = aVar2;
        aVar.f16873c = aVar2.f16873c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16869a;
        aVar.f16874d = aVar2.f16874d;
        aVar.f16873c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f16874d;
        aVar2.f16873c = aVar.f16873c;
        aVar.f16873c.f16874d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f16873c.f16874d = aVar;
        aVar.f16874d.f16873c = aVar;
    }

    @Nullable
    public V a(K k4) {
        a<K, V> aVar = this.f16870b.get(k4);
        if (aVar == null) {
            aVar = new a<>(k4);
            this.f16870b.put(k4, aVar);
        } else {
            k4.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k4, V v3) {
        a<K, V> aVar = this.f16870b.get(k4);
        if (aVar == null) {
            aVar = new a<>(k4);
            c(aVar);
            this.f16870b.put(k4, aVar);
        } else {
            k4.a();
        }
        aVar.a(v3);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f16869a.f16874d; !aVar.equals(this.f16869a); aVar = aVar.f16874d) {
            V v3 = (V) aVar.b();
            if (v3 != null) {
                return v3;
            }
            e(aVar);
            this.f16870b.remove(aVar.f16871a);
            ((e) aVar.f16871a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f16869a.f16873c;
        boolean z3 = false;
        while (!aVar.equals(this.f16869a)) {
            sb.append('{');
            sb.append(aVar.f16871a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f16873c;
            z3 = true;
        }
        if (z3) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
