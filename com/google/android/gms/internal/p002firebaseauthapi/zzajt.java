package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajt  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzajt extends AbstractList implements RandomAccess, zzahq {
    private final zzahq zza;

    public zzajt(zzahq zzahqVar) {
        this.zza = zzahqVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        return ((zzahp) this.zza).get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzajs(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        return new zzajr(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final Object zzf(int i4) {
        return this.zza.zzf(i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final void zzi(zzafy zzafyVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahq
    public final zzahq zze() {
        return this;
    }
}
