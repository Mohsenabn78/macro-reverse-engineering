package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzco extends zzcq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzco(zzcn zzcnVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.wearable.zzcq
    public final void zza(Object obj, long j4) {
        ((zzcc) zzeo.zzf(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.wearable.zzcq
    public final void zzb(Object obj, Object obj2, long j4) {
        zzcc zzccVar = (zzcc) zzeo.zzf(obj, j4);
        zzcc zzccVar2 = (zzcc) zzeo.zzf(obj2, j4);
        int size = zzccVar.size();
        int size2 = zzccVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzccVar.zzc()) {
                zzccVar = zzccVar.zzd(size2 + size);
            }
            zzccVar.addAll(zzccVar2);
        }
        if (size > 0) {
            zzccVar2 = zzccVar;
        }
        zzeo.zzs(obj, j4, zzccVar2);
    }

    private zzco() {
        super(null);
    }
}
