package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzfrh implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzfrl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfrh(zzfrl zzfrlVar, zzfrg zzfrgVar) {
        int i4;
        this.zze = zzfrlVar;
        i4 = zzfrlVar.zzf;
        this.zzb = i4;
        this.zzc = zzfrlVar.zze();
        this.zzd = -1;
    }

    private final void zzb() {
        int i4;
        i4 = this.zze.zzf;
        if (i4 == this.zzb) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzc >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (hasNext()) {
            int i4 = this.zzc;
            this.zzd = i4;
            Object zza = zza(i4);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z3;
        zzb();
        if (this.zzd >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzi(z3, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzfrl zzfrlVar = this.zze;
        int i4 = this.zzd;
        Object[] objArr = zzfrlVar.zzb;
        objArr.getClass();
        zzfrlVar.remove(objArr[i4]);
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i4);
}
