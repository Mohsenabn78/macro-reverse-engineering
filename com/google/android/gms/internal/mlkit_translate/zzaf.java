package com.google.android.gms.internal.mlkit_translate;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzaf extends zzaa {
    private final transient zzy zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzy zzyVar, Object[] objArr, int i4, int i5) {
        this.zza = zzyVar;
        this.zzb = objArr;
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    public final int zza(Object[] objArr, int i4) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr
    public final zzam zzd() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa
    final zzv zzh() {
        return new zzae(this);
    }
}
