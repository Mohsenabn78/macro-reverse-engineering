package com.google.android.gms.internal.nearby;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzta extends zzsv {
    final transient Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzta(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.nearby.zzsv, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.nearby.zzsv, com.google.android.gms.internal.nearby.zzsq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzsw(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    @Override // com.google.android.gms.internal.nearby.zzsq
    final int zza(Object[] objArr, int i4) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.nearby.zzsv, com.google.android.gms.internal.nearby.zzsq
    public final zzst zzd() {
        return zzst.zzl(this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzsv, com.google.android.gms.internal.nearby.zzsq
    public final zztb zze() {
        return new zzsw(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzsq
    public final boolean zzf() {
        throw null;
    }
}
