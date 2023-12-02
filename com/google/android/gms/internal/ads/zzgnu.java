package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgnu extends zzgnw {
    final /* synthetic */ zzgoe zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgnu(zzgoe zzgoeVar) {
        this.zza = zzgoeVar;
        this.zzc = zzgoeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zzc) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgny
    public final byte zza() {
        int i4 = this.zzb;
        if (i4 < this.zzc) {
            this.zzb = i4 + 1;
            return this.zza.zzb(i4);
        }
        throw new NoSuchElementException();
    }
}
