package com.google.android.gms.internal.mlkit_translate;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
abstract class zzcg implements Iterator {
    zzch zza;
    zzch zzb = null;
    int zzc;
    final /* synthetic */ zzci zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcg(zzci zzciVar) {
        this.zzd = zzciVar;
        this.zza = zzciVar.zze.zzd;
        this.zzc = zzciVar.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zza != this.zzd.zze) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzch zzchVar = this.zzb;
        if (zzchVar != null) {
            this.zzd.zze(zzchVar, true);
            this.zzb = null;
            this.zzc = this.zzd.zzd;
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzch zza() {
        zzch zzchVar = this.zza;
        zzci zzciVar = this.zzd;
        if (zzchVar != zzciVar.zze) {
            if (zzciVar.zzd == this.zzc) {
                this.zza = zzchVar.zzd;
                this.zzb = zzchVar;
                return zzchVar;
            }
            throw new ConcurrentModificationException();
        }
        throw new NoSuchElementException();
    }
}
