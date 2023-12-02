package com.koushikdutta.async.util;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f35687a;

    /* renamed from: b  reason: collision with root package name */
    private long f35688b;

    /* renamed from: c  reason: collision with root package name */
    private long f35689c;

    /* renamed from: d  reason: collision with root package name */
    private int f35690d;

    /* renamed from: e  reason: collision with root package name */
    private int f35691e;

    /* renamed from: f  reason: collision with root package name */
    private int f35692f;

    /* renamed from: g  reason: collision with root package name */
    private int f35693g;

    /* renamed from: h  reason: collision with root package name */
    private int f35694h;

    public LruCache(long j4) {
        if (j4 > 0) {
            this.f35689c = j4;
            this.f35687a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private long c(K k4, V v3) {
        long d4 = d(k4, v3);
        if (d4 >= 0) {
            return d4;
        }
        throw new IllegalStateException("Negative size: " + k4 + "=" + v3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(long r7) {
        /*
            r6 = this;
        L0:
            monitor-enter(r6)
            long r0 = r6.f35688b     // Catch: java.lang.Throwable -> L79
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L5a
            java.util.LinkedHashMap<K, V> r0 = r6.f35687a     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L17
            long r0 = r6.f35688b     // Catch: java.lang.Throwable -> L79
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L5a
        L17:
            long r0 = r6.f35688b     // Catch: java.lang.Throwable -> L79
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L58
            java.util.LinkedHashMap<K, V> r0 = r6.f35687a     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L26
            goto L58
        L26:
            java.util.LinkedHashMap<K, V> r0 = r6.f35687a     // Catch: java.lang.Throwable -> L79
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L79
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L79
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L79
            java.util.LinkedHashMap<K, V> r2 = r6.f35687a     // Catch: java.lang.Throwable -> L79
            r2.remove(r1)     // Catch: java.lang.Throwable -> L79
            long r2 = r6.f35688b     // Catch: java.lang.Throwable -> L79
            long r4 = r6.c(r1, r0)     // Catch: java.lang.Throwable -> L79
            long r2 = r2 - r4
            r6.f35688b = r2     // Catch: java.lang.Throwable -> L79
            int r2 = r6.f35692f     // Catch: java.lang.Throwable -> L79
            r3 = 1
            int r2 = r2 + r3
            r6.f35692f = r2     // Catch: java.lang.Throwable -> L79
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            r2 = 0
            r6.b(r3, r1, r0, r2)
            goto L0
        L58:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            return
        L5a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r8.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.Class r0 = r6.getClass()     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L79
            r8.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = ".sizeOf() is reporting inconsistent results!"
            r8.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L79
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L79
            throw r7     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.util.LruCache.e(long):void");
    }

    protected V a(K k4) {
        return null;
    }

    public final synchronized int createCount() {
        return this.f35691e;
    }

    protected long d(K k4, V v3) {
        return 1L;
    }

    public final void evictAll() {
        e(-1L);
    }

    public final synchronized int evictionCount() {
        return this.f35692f;
    }

    public final V get(K k4) {
        V put;
        if (k4 != null) {
            synchronized (this) {
                V v3 = this.f35687a.get(k4);
                if (v3 != null) {
                    this.f35693g++;
                    return v3;
                }
                this.f35694h++;
                V a4 = a(k4);
                if (a4 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f35691e++;
                    put = this.f35687a.put(k4, a4);
                    if (put != null) {
                        this.f35687a.put(k4, put);
                    } else {
                        this.f35688b += c(k4, a4);
                    }
                }
                if (put != null) {
                    b(false, k4, a4, put);
                    return put;
                }
                e(this.f35689c);
                return a4;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int hitCount() {
        return this.f35693g;
    }

    public final synchronized long maxSize() {
        return this.f35689c;
    }

    public final synchronized int missCount() {
        return this.f35694h;
    }

    public final V put(K k4, V v3) {
        V put;
        if (k4 != null && v3 != null) {
            synchronized (this) {
                this.f35690d++;
                this.f35688b += c(k4, v3);
                put = this.f35687a.put(k4, v3);
                if (put != null) {
                    this.f35688b -= c(k4, put);
                }
            }
            if (put != null) {
                b(false, k4, put, v3);
            }
            e(this.f35689c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized int putCount() {
        return this.f35690d;
    }

    public final V remove(K k4) {
        V remove;
        if (k4 != null) {
            synchronized (this) {
                remove = this.f35687a.remove(k4);
                if (remove != null) {
                    this.f35688b -= c(k4, remove);
                }
            }
            if (remove != null) {
                b(false, k4, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void setMaxSize(long j4) {
        this.f35689c = j4;
    }

    public final synchronized long size() {
        return this.f35688b;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.f35687a);
    }

    public final synchronized String toString() {
        int i4;
        int i5 = this.f35693g;
        int i6 = this.f35694h + i5;
        if (i6 != 0) {
            i4 = (i5 * 100) / i6;
        } else {
            i4 = 0;
        }
        return String.format(Locale.ENGLISH, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Long.valueOf(this.f35689c), Integer.valueOf(this.f35693g), Integer.valueOf(this.f35694h), Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z3, K k4, V v3, V v4) {
    }
}
