package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzbv extends zzbu {
    private zzbv() {
        super();
    }

    private static <E> zzbh<E> zzc(Object obj, long j4) {
        return (zzbh) zzdy.zzp(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzbu
    public final void zzb(Object obj, long j4) {
        zzc(obj, j4).zzab();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.places.zzbu
    public final <E> void zzb(Object obj, Object obj2, long j4) {
        zzbh<E> zzc = zzc(obj, j4);
        zzbh<E> zzc2 = zzc(obj2, j4);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzbh<E> zzbhVar = zzc;
        zzbhVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzaa = zzc.zzaa();
            zzbh<E> zzbhVar2 = zzc;
            if (!zzaa) {
                zzbhVar2 = zzc.zzh(size2 + size);
            }
            zzbhVar2.addAll(zzc2);
            zzbhVar = zzbhVar2;
        }
        if (size > 0) {
            zzc2 = zzbhVar;
        }
        zzdy.zzb(obj, j4, zzc2);
    }
}
