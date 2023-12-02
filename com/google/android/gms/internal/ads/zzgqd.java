package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgqd extends zzgno implements RandomAccess, zzgqe {
    @Deprecated
    public static final zzgqe zza;
    private static final zzgqd zzb;
    private final List zzc;

    static {
        zzgqd zzgqdVar = new zzgqd(false);
        zzb = zzgqdVar;
        zza = zzgqdVar;
    }

    public zzgqd() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgoe) {
            return ((zzgoe) obj).zzx(zzgpw.zzb);
        }
        return zzgpw.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i4, Object obj) {
        zzbH();
        this.zzc.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        zzbH();
        if (collection instanceof zzgqe) {
            collection = ((zzgqe) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbH();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zzbH();
        Object remove = this.zzc.remove(i4);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        zzbH();
        return zzj(this.zzc.set(i4, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgpv
    public final /* bridge */ /* synthetic */ zzgpv zzd(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzc);
            return new zzgqd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzgqe
    public final zzgqe zze() {
        if (zzc()) {
            return new zzgsl(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgqe
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
        if (obj instanceof zzgoe) {
            zzgoe zzgoeVar = (zzgoe) obj;
            String zzx = zzgoeVar.zzx(zzgpw.zzb);
            if (zzgoeVar.zzp()) {
                this.zzc.set(i4, zzx);
            }
            return zzx;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgpw.zzd(bArr);
        if (zzgsv.zzi(bArr)) {
            this.zzc.set(i4, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgqe
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgqe
    public final void zzi(zzgoe zzgoeVar) {
        zzbH();
        this.zzc.add(zzgoeVar);
        ((AbstractList) this).modCount++;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgqd(int i4) {
        super(true);
        ArrayList arrayList = new ArrayList(i4);
        this.zzc = arrayList;
    }

    private zzgqd(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzgqd(boolean z3) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzgno, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
