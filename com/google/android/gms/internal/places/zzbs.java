package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzbs extends zzq<String> implements zzbr, RandomAccess {
    private static final zzbs zzjy;
    private static final zzbr zzjz;
    private final List<Object> zzka;

    static {
        zzbs zzbsVar = new zzbs();
        zzjy = zzbsVar;
        zzbsVar.zzab();
        zzjz = zzbsVar;
    }

    public zzbs() {
        this(10);
    }

    private static String zzf(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzw) {
            return ((zzw) obj).zzad();
        }
        return zzbd.zzf((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        zzac();
        this.zzka.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzac();
        this.zzka.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        Object obj = this.zzka.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzw) {
            zzw zzwVar = (zzw) obj;
            String zzad = zzwVar.zzad();
            if (zzwVar.zzae()) {
                this.zzka.set(i4, zzad);
            }
            return zzad;
        }
        byte[] bArr = (byte[]) obj;
        String zzf = zzbd.zzf(bArr);
        if (zzbd.zze(bArr)) {
            this.zzka.set(i4, zzf);
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        zzac();
        return zzf(this.zzka.set(i4, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzka.size();
    }

    @Override // com.google.android.gms.internal.places.zzq, com.google.android.gms.internal.places.zzbh
    public final /* bridge */ /* synthetic */ boolean zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final Object zzae(int i4) {
        return this.zzka.get(i4);
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final List<?> zzby() {
        return Collections.unmodifiableList(this.zzka);
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final zzbr zzbz() {
        if (zzaa()) {
            return new zzdt(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzka);
            return new zzbs(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public zzbs(int i4) {
        this(new ArrayList(i4));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection<? extends String> collection) {
        zzac();
        if (collection instanceof zzbr) {
            collection = ((zzbr) collection).zzby();
        }
        boolean addAll = this.zzka.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        zzac();
        Object remove = this.zzka.remove(i4);
        ((AbstractList) this).modCount++;
        return zzf(remove);
    }

    private zzbs(ArrayList<Object> arrayList) {
        this.zzka = arrayList;
    }
}
