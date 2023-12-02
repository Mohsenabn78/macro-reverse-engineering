package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f17577a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f17578b;

    /* renamed from: c  reason: collision with root package name */
    private long f17579c;

    /* renamed from: d  reason: collision with root package name */
    private long f17580d;

    public LruCache(long j4) {
        this.f17578b = j4;
        this.f17579c = j4;
    }

    private void a() {
        d(this.f17579c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(@Nullable Y y3) {
        return 1;
    }

    public void clearMemory() {
        d(0L);
    }

    public synchronized boolean contains(@NonNull T t3) {
        return this.f17577a.containsKey(t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void d(long j4) {
        while (this.f17580d > j4) {
            Iterator<Map.Entry<T, Y>> it = this.f17577a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f17580d -= b(value);
            T key = next.getKey();
            it.remove();
            c(key, value);
        }
    }

    @Nullable
    public synchronized Y get(@NonNull T t3) {
        return this.f17577a.get(t3);
    }

    public synchronized long getCurrentSize() {
        return this.f17580d;
    }

    public synchronized long getMaxSize() {
        return this.f17579c;
    }

    @Nullable
    public synchronized Y put(@NonNull T t3, @Nullable Y y3) {
        long b4 = b(y3);
        if (b4 >= this.f17579c) {
            c(t3, y3);
            return null;
        }
        if (y3 != null) {
            this.f17580d += b4;
        }
        Y put = this.f17577a.put(t3, y3);
        if (put != null) {
            this.f17580d -= b(put);
            if (!put.equals(y3)) {
                c(t3, put);
            }
        }
        a();
        return put;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t3) {
        Y remove;
        remove = this.f17577a.remove(t3);
        if (remove != null) {
            this.f17580d -= b(remove);
        }
        return remove;
    }

    public synchronized void setSizeMultiplier(float f4) {
        if (f4 >= 0.0f) {
            this.f17579c = Math.round(((float) this.f17578b) * f4);
            a();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    protected void c(@NonNull T t3, @Nullable Y y3) {
    }
}
