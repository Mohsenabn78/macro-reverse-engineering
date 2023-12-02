package com.google.android.gms.internal.wearable;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcj extends zzah implements RandomAccess, zzck {
    public static final zzck zza;
    private static final zzcj zzb;
    private final List zzc;

    static {
        zzcj zzcjVar = new zzcj(10);
        zzb = zzcjVar;
        zzcjVar.zzb();
        zza = zzcjVar;
    }

    public zzcj() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaw) {
            return ((zzaw) obj).zzp(zzcd.zzb);
        }
        return zzcd.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i4, Object obj) {
        zzad();
        this.zzc.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        zzad();
        if (collection instanceof zzck) {
            collection = ((zzck) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzad();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zzad();
        Object remove = this.zzc.remove(i4);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        zzad();
        return zzj(this.zzc.set(i4, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.wearable.zzcc
    public final /* bridge */ /* synthetic */ zzcc zzd(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzc);
            return new zzcj(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final zzck zze() {
        if (zzc()) {
            return new zzej(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final Object zzf(int i4) {
        return this.zzc.get(i4);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg */
    public final String get(int i4) {
        Object obj = this.zzc.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaw) {
            zzaw zzawVar = (zzaw) obj;
            String zzp = zzawVar.zzp(zzcd.zzb);
            if (zzawVar.zzj()) {
                this.zzc.set(i4, zzp);
            }
            return zzp;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzcd.zzh(bArr);
        if (zzcd.zzi(bArr)) {
            this.zzc.set(i4, zzh);
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final void zzi(zzaw zzawVar) {
        zzad();
        this.zzc.add(zzawVar);
        ((AbstractList) this).modCount++;
    }

    public zzcj(int i4) {
        this.zzc = new ArrayList(i4);
    }

    private zzcj(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
