package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzahp extends zzafj implements RandomAccess, zzahq {
    @Deprecated
    public static final zzahq zza;
    private static final zzahp zzb;
    private final List zzc;

    static {
        zzahp zzahpVar = new zzahp(false);
        zzb = zzahpVar;
        zza = zzahpVar;
    }

    public zzahp() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzafy) {
            return ((zzafy) obj).zzo(zzahj.zzb);
        }
        return zzahj.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i4, Object obj) {
        zza();
        this.zzc.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        zza();
        if (collection instanceof zzahq) {
            collection = ((zzahq) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zza();
        Object remove = this.zzc.remove(i4);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        zza();
        return zzj(this.zzc.set(i4, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final /* bridge */ /* synthetic */ zzahi zzd(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzc);
            return new zzahp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final zzahq zze() {
        if (zzc()) {
            return new zzajt(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
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
        if (obj instanceof zzafy) {
            zzafy zzafyVar = (zzafy) obj;
            String zzo = zzafyVar.zzo(zzahj.zzb);
            if (zzafyVar.zzk()) {
                this.zzc.set(i4, zzo);
            }
            return zzo;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzahj.zzd(bArr);
        if (zzakd.zze(bArr)) {
            this.zzc.set(i4, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final void zzi(zzafy zzafyVar) {
        zza();
        this.zzc.add(zzafyVar);
        ((AbstractList) this).modCount++;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzahp(int i4) {
        super(true);
        ArrayList arrayList = new ArrayList(i4);
        this.zzc = arrayList;
    }

    private zzahp(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzahp(boolean z3) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
