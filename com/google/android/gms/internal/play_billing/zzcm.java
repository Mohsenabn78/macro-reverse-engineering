package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzcm extends zzal implements RandomAccess, zzcn {
    @Deprecated
    public static final zzcn zza;
    private static final zzcm zzb;
    private final List zzc;

    static {
        zzcm zzcmVar = new zzcm(false);
        zzb = zzcmVar;
        zza = zzcmVar;
    }

    public zzcm() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzba) {
            return ((zzba) obj).zzm(zzcg.zzb);
        }
        return zzcg.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i4, Object obj) {
        zza();
        this.zzc.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        zza();
        if (collection instanceof zzcn) {
            collection = ((zzcn) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zza();
        Object remove = this.zzc.remove(i4);
        ((AbstractList) this).modCount++;
        return zzi(remove);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        zza();
        return zzi(this.zzc.set(i4, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcf
    public final /* bridge */ /* synthetic */ zzcf zzd(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzc);
            return new zzcm(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcn
    public final zzcn zze() {
        if (zzc()) {
            return new zzel(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcn
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
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            String zzm = zzbaVar.zzm(zzcg.zzb);
            if (zzbaVar.zzi()) {
                this.zzc.set(i4, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzcg.zzd(bArr);
        if (zzev.zzd(bArr)) {
            this.zzc.set(i4, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcn
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcm(int i4) {
        super(true);
        ArrayList arrayList = new ArrayList(i4);
        this.zzc = arrayList;
    }

    private zzcm(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzcm(boolean z3) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
