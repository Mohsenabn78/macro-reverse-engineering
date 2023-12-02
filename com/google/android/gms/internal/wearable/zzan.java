package com.google.android.gms.internal.wearable;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzan extends zzap {
    final /* synthetic */ zzaw zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzaw zzawVar) {
        this.zza = zzawVar;
        this.zzc = zzawVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zzc) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.wearable.zzar
    public final byte zza() {
        int i4 = this.zzb;
        if (i4 < this.zzc) {
            this.zzb = i4 + 1;
            return this.zza.zzb(i4);
        }
        throw new NoSuchElementException();
    }
}
