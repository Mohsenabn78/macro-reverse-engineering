package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajo  reason: invalid package */
/* loaded from: classes4.dex */
abstract class zzajo {
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
    public abstract void zzk(Object obj, int i4, zzafy zzafyVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i4, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(Object obj, zzait zzaitVar) throws IOException {
        int zzd = zzaitVar.zzd();
        int i4 = zzd >>> 3;
        int i5 = zzd & 7;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                zzh(obj, i4, zzaitVar.zzf());
                                return true;
                            }
                            throw zzahl.zza();
                        }
                        return false;
                    }
                    Object zzf = zzf();
                    int i6 = i4 << 3;
                    while (zzaitVar.zzc() != Integer.MAX_VALUE && zzp(zzf, zzaitVar)) {
                    }
                    if ((4 | i6) == zzaitVar.zzd()) {
                        zzg(zzf);
                        zzj(obj, i4, zzf);
                        return true;
                    }
                    throw zzahl.zzb();
                }
                zzk(obj, i4, zzaitVar.zzp());
                return true;
            }
            zzi(obj, i4, zzaitVar.zzk());
            return true;
        }
        zzl(obj, i4, zzaitVar.zzl());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzq(zzait zzaitVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzr(Object obj, zzagm zzagmVar) throws IOException;
}
