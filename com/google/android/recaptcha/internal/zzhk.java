package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzhk extends zzhm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhk(zzhj zzhjVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final List zza(Object obj, long j4) {
        int i4;
        zzgv zzgvVar = (zzgv) zzjp.zzf(obj, j4);
        if (!zzgvVar.zzc()) {
            int size = zzgvVar.size();
            if (size == 0) {
                i4 = 10;
            } else {
                i4 = size + size;
            }
            zzgv zzd = zzgvVar.zzd(i4);
            zzjp.zzs(obj, j4, zzd);
            return zzd;
        }
        return zzgvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final void zzb(Object obj, long j4) {
        ((zzgv) zzjp.zzf(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final void zzc(Object obj, Object obj2, long j4) {
        zzgv zzgvVar = (zzgv) zzjp.zzf(obj, j4);
        zzgv zzgvVar2 = (zzgv) zzjp.zzf(obj2, j4);
        int size = zzgvVar.size();
        int size2 = zzgvVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgvVar.zzc()) {
                zzgvVar = zzgvVar.zzd(size2 + size);
            }
            zzgvVar.addAll(zzgvVar2);
        }
        if (size > 0) {
            zzgvVar2 = zzgvVar;
        }
        zzjp.zzs(obj, j4, zzgvVar2);
    }

    private zzhk() {
        super(null);
    }
}
