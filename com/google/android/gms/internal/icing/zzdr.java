package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzdr extends zzds {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdr(zzdp zzdpVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzds
    public final void zza(Object obj, long j4) {
        ((zzdg) zzfn.zzn(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    @Override // com.google.android.gms.internal.icing.zzds
    public final <E> void zzb(Object obj, Object obj2, long j4) {
        zzdg<E> zzdgVar = (zzdg) zzfn.zzn(obj, j4);
        zzdg<E> zzdgVar2 = (zzdg) zzfn.zzn(obj2, j4);
        int size = zzdgVar.size();
        int size2 = zzdgVar2.size();
        zzdg<E> zzdgVar3 = zzdgVar;
        zzdgVar3 = zzdgVar;
        if (size > 0 && size2 > 0) {
            boolean zza = zzdgVar.zza();
            zzdg<E> zzdgVar4 = zzdgVar;
            if (!zza) {
                zzdgVar4 = zzdgVar.zze(size2 + size);
            }
            zzdgVar4.addAll(zzdgVar2);
            zzdgVar3 = zzdgVar4;
        }
        if (size > 0) {
            zzdgVar2 = zzdgVar3;
        }
        zzfn.zzo(obj, j4, zzdgVar2);
    }

    private zzdr() {
        super(null);
    }
}
