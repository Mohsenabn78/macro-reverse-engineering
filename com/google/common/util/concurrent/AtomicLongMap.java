package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class AtomicLongMap<K> implements Serializable {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient Map<K, Long> f28389a;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    private Map<K, Long> a() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>(this) { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            @Override // com.google.common.base.Function
            /* renamed from: a */
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k4, long j4) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k4);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k4, new AtomicLong(j4))) == null) {
                return j4;
            }
            while (true) {
                long j5 = atomicLong.get();
                if (j5 == 0) {
                    break;
                }
                long j6 = j5 + j4;
                if (atomicLong.compareAndSet(j5, j6)) {
                    return j6;
                }
            }
        } while (!this.map.replace(k4, atomicLong, new AtomicLong(j4)));
        return j4;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.f28389a;
        if (map == null) {
            Map<K, Long> a4 = a();
            this.f28389a = a4;
            return a4;
        }
        return map;
    }

    boolean b(K k4, long j4) {
        AtomicLong atomicLong = this.map.get(k4);
        if (atomicLong == null) {
            return false;
        }
        long j5 = atomicLong.get();
        if (j5 != j4) {
            return false;
        }
        if (j5 != 0 && !atomicLong.compareAndSet(j5, 0L)) {
            return false;
        }
        this.map.remove(k4, atomicLong);
        return true;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k4) {
        return addAndGet(k4, -1L);
    }

    public long get(K k4) {
        AtomicLong atomicLong = this.map.get(k4);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k4, long j4) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k4);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k4, new AtomicLong(j4))) == null) {
                return 0L;
            }
            while (true) {
                long j5 = atomicLong.get();
                if (j5 == 0) {
                    break;
                } else if (atomicLong.compareAndSet(j5, j5 + j4)) {
                    return j5;
                }
            }
        } while (!this.map.replace(k4, atomicLong, new AtomicLong(j4)));
        return 0L;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k4) {
        return getAndAdd(k4, -1L);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k4) {
        return getAndAdd(k4, 1L);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k4) {
        return addAndGet(k4, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k4, long j4) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k4);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k4, new AtomicLong(j4))) == null) {
                return 0L;
            }
            while (true) {
                long j5 = atomicLong.get();
                if (j5 == 0) {
                    break;
                } else if (atomicLong.compareAndSet(j5, j4)) {
                    return j5;
                }
            }
        } while (!this.map.replace(k4, atomicLong, new AtomicLong(j4)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    @CanIgnoreReturnValue
    public long remove(K k4) {
        long j4;
        AtomicLong atomicLong = this.map.get(k4);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j4 = atomicLong.get();
            if (j4 == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j4, 0L));
        this.map.remove(k4, atomicLong);
        return j4;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    public boolean removeIfZero(K k4) {
        return b(k4, 0L);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        long j4 = 0;
        for (AtomicLong atomicLong : this.map.values()) {
            j4 += atomicLong.get();
        }
        return j4;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }
}
