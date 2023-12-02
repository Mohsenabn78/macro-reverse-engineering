package com.google.android.recaptcha.internal;

import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
abstract class zzjf {
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
    public abstract void zzk(Object obj, int i4, zzez zzezVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i4, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzp(Object obj, zzjx zzjxVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzq(Object obj, zzjx zzjxVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(Object obj, zzik zzikVar) throws IOException {
        int zzd = zzikVar.zzd();
        int i4 = zzd >>> 3;
        int i5 = zzd & 7;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                zzh(obj, i4, zzikVar.zzf());
                                return true;
                            }
                            throw zzgy.zza();
                        }
                        return false;
                    }
                    Object zzf = zzf();
                    int i6 = i4 << 3;
                    while (zzikVar.zzc() != Integer.MAX_VALUE && zzr(zzf, zzikVar)) {
                    }
                    if ((4 | i6) == zzikVar.zzd()) {
                        zzg(zzf);
                        zzj(obj, i4, zzf);
                        return true;
                    }
                    throw zzgy.zzb();
                }
                zzk(obj, i4, zzikVar.zzp());
                return true;
            }
            zzi(obj, i4, zzikVar.zzk());
            return true;
        }
        zzl(obj, i4, zzikVar.zzl());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzs(zzik zzikVar);
}
