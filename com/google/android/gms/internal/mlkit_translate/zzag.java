package com.google.android.gms.internal.mlkit_translate;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzag extends zzaa {
    private final transient zzy zza;
    private final transient zzv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzy zzyVar, zzv zzvVar) {
        this.zza = zzyVar;
        this.zzb = zzvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    public final int zza(Object[] objArr, int i4) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr
    public final zzam zzd() {
        return this.zzb.listIterator(0);
    }
}
