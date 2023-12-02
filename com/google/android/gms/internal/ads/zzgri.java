package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgri extends zzgnw {
    final zzgrm zza;
    zzgny zzb = zzb();
    final /* synthetic */ zzgro zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgri(zzgro zzgroVar) {
        this.zzc = zzgroVar;
        this.zza = new zzgrm(zzgroVar, null);
    }

    private final zzgny zzb() {
        zzgrm zzgrmVar = this.zza;
        if (zzgrmVar.hasNext()) {
            return zzgrmVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgny
    public final byte zza() {
        zzgny zzgnyVar = this.zzb;
        if (zzgnyVar != null) {
            byte zza = zzgnyVar.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza;
        }
        throw new NoSuchElementException();
    }
}
