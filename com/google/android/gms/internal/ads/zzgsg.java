package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzgsg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzd(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i4, int i5);

    abstract void zzi(Object obj, int i4, long j4);

    abstract void zzj(Object obj, int i4, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(Object obj, int i4, zzgoe zzgoeVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i4, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(Object obj, zzgrh zzgrhVar) throws IOException {
        int zzd = zzgrhVar.zzd();
        int i4 = zzd >>> 3;
        int i5 = zzd & 7;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                zzh(obj, i4, zzgrhVar.zzf());
                                return true;
                            }
                            throw zzgpy.zza();
                        }
                        return false;
                    }
                    Object zzf = zzf();
                    int i6 = i4 << 3;
                    while (zzgrhVar.zzc() != Integer.MAX_VALUE && zzp(zzf, zzgrhVar)) {
                    }
                    if ((4 | i6) == zzgrhVar.zzd()) {
                        zzg(zzf);
                        zzj(obj, i4, zzf);
                        return true;
                    }
                    throw zzgpy.zzb();
                }
                zzk(obj, i4, zzgrhVar.zzp());
                return true;
            }
            zzi(obj, i4, zzgrhVar.zzk());
            return true;
        }
        zzl(obj, i4, zzgrhVar.zzl());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzq(zzgrh zzgrhVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzr(Object obj, zzgou zzgouVar) throws IOException;
}
