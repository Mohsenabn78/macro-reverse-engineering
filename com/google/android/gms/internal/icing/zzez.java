package com.google.android.gms.internal.icing;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public class zzez<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private boolean zzd;
    private volatile zzey zze;
    private List<zzew> zzb = Collections.emptyList();
    private Map<K, V> zzc = Collections.emptyMap();
    private Map<K, V> zzf = Collections.emptyMap();

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzk(int i4) {
        zzm();
        V v3 = (V) this.zzb.remove(i4).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzn().entrySet().iterator();
            List<zzew> list = this.zzb;
            Map.Entry<K, V> next = it.next();
            list.add(new zzew(this, next.getKey(), next.getValue()));
            it.remove();
        }
        return v3;
    }

    private final int zzl(K k4) {
        int size = this.zzb.size() - 1;
        int i4 = 0;
        if (size >= 0) {
            int compareTo = k4.compareTo(this.zzb.get(size).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            int compareTo2 = k4.compareTo(this.zzb.get(i5).zza());
            if (compareTo2 < 0) {
                size = i5 - 1;
            } else if (compareTo2 > 0) {
                i4 = i5 + 1;
            } else {
                return i5;
            }
        }
        return -(i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm() {
        if (!this.zzd) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private final SortedMap<K, V> zzn() {
        zzm();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzm();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzl(comparable) < 0 && !this.zzc.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzey(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzez)) {
            return super.equals(obj);
        }
        zzez zzezVar = (zzez) obj;
        int size = size();
        if (size != zzezVar.size()) {
            return false;
        }
        int zzc = zzc();
        if (zzc == zzezVar.zzc()) {
            for (int i4 = 0; i4 < zzc; i4++) {
                if (!zzd(i4).equals(zzezVar.zzd(i4))) {
                    return false;
                }
            }
            if (zzc == size) {
                return true;
            }
            return this.zzc.equals(zzezVar.zzc);
        }
        return entrySet().equals(zzezVar.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return (V) this.zzb.get(zzl).getValue();
        }
        return this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int zzc = zzc();
        int i4 = 0;
        for (int i5 = 0; i5 < zzc; i5++) {
            i4 += this.zzb.get(i5).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i4 + this.zzc.hashCode();
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzm();
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return (V) zzk(zzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = unmodifiableMap;
            if (this.zzf.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = unmodifiableMap2;
            this.zzd = true;
        }
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzd(int i4) {
        return this.zzb.get(i4);
    }

    public final Iterable<Map.Entry<K, V>> zze() {
        if (this.zzc.isEmpty()) {
            return zzev.zza();
        }
        return this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zzf */
    public final V put(K k4, V v3) {
        zzm();
        int zzl = zzl(k4);
        if (zzl >= 0) {
            return (V) this.zzb.get(zzl).setValue(v3);
        }
        zzm();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i4 = -(zzl + 1);
        if (i4 >= this.zza) {
            return zzn().put(k4, v3);
        }
        int size = this.zzb.size();
        int i5 = this.zza;
        if (size == i5) {
            zzew remove = this.zzb.remove(i5 - 1);
            zzn().put((K) remove.zza(), (V) remove.getValue());
        }
        this.zzb.add(i4, new zzew(this, k4, v3));
        return null;
    }
}
