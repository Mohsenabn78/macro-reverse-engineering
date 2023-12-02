package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
@Deprecated
/* loaded from: classes5.dex */
public final class zzjk extends AbstractList implements RandomAccess, zzhg {
    private final zzhg zza;

    public zzjk(zzhg zzhgVar) {
        this.zza = zzhgVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        return ((zzhf) this.zza).get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzjj(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        return new zzji(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.recaptcha.internal.zzhg
    public final Object zzf(int i4) {
        return this.zza.zzf(i4);
    }

    @Override // com.google.android.recaptcha.internal.zzhg
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzhg
    public final void zzi(zzez zzezVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.recaptcha.internal.zzhg
    public final zzhg zze() {
        return this;
    }
}
