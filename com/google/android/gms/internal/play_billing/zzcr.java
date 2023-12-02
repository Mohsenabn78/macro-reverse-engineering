package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzcr extends zzct {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcr(zzcq zzcqVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzct
    public final void zza(Object obj, long j4) {
        ((zzcf) zzeq.zzf(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzct
    public final void zzb(Object obj, Object obj2, long j4) {
        zzcf zzcfVar = (zzcf) zzeq.zzf(obj, j4);
        zzcf zzcfVar2 = (zzcf) zzeq.zzf(obj2, j4);
        int size = zzcfVar.size();
        int size2 = zzcfVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzcfVar.zzc()) {
                zzcfVar = zzcfVar.zzd(size2 + size);
            }
            zzcfVar.addAll(zzcfVar2);
        }
        if (size > 0) {
            zzcfVar2 = zzcfVar;
        }
        zzeq.zzs(obj, j4, zzcfVar2);
    }

    private zzcr() {
        super(null);
    }
}
