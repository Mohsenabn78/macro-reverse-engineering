package com.google.android.gms.internal.mlkit_translate;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzaj extends zzaa {
    static final zzaj zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzaj(objArr, 0, objArr, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(Object[] objArr, int i4, Object[] objArr2, int i5, int i6) {
        this.zzb = objArr;
        this.zze = i4;
        this.zzc = objArr2;
        this.zzf = i5;
        this.zzg = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zza2 = zzo.zza(obj.hashCode());
        while (true) {
            int i4 = zza2 & this.zzf;
            Object obj2 = objArr[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i4 + 1;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    public final int zza(Object[] objArr, int i4) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    final int zzb() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa, com.google.android.gms.internal.mlkit_translate.zzr
    public final zzam zzd() {
        return zzg().listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzr
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa
    final zzv zzh() {
        return zzv.zzi(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzaa
    final boolean zzk() {
        return true;
    }
}
