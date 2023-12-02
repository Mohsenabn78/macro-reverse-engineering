package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgrm implements Iterator {
    private final ArrayDeque zza;
    private zzgnz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgrm(zzgoe zzgoeVar, zzgrl zzgrlVar) {
        zzgoe zzgoeVar2;
        if (zzgoeVar instanceof zzgro) {
            zzgro zzgroVar = (zzgro) zzgoeVar;
            ArrayDeque arrayDeque = new ArrayDeque(zzgroVar.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzgroVar);
            zzgoeVar2 = zzgroVar.zzd;
            this.zzb = zzb(zzgoeVar2);
            return;
        }
        this.zza = null;
        this.zzb = (zzgnz) zzgoeVar;
    }

    private final zzgnz zzb(zzgoe zzgoeVar) {
        while (zzgoeVar instanceof zzgro) {
            zzgro zzgroVar = (zzgro) zzgoeVar;
            this.zza.push(zzgroVar);
            zzgoeVar = zzgroVar.zzd;
        }
        return (zzgnz) zzgoeVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza */
    public final zzgnz next() {
        zzgnz zzgnzVar;
        zzgoe zzgoeVar;
        zzgnz zzgnzVar2 = this.zzb;
        if (zzgnzVar2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgnzVar = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    break;
                }
                zzgoeVar = ((zzgro) this.zza.pop()).zze;
                zzgnzVar = zzb(zzgoeVar);
            } while (zzgnzVar.zzd() == 0);
            this.zzb = zzgnzVar;
            return zzgnzVar2;
        }
        throw new NoSuchElementException();
    }
}
