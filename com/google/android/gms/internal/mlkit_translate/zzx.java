package com.google.android.gms.internal.mlkit_translate;

import java.util.Arrays;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzx {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzw zzc;

    public final zzx zza(Object obj, Object obj2) {
        int i4 = this.zzb + 1;
        int i5 = i4 + i4;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i5 > length) {
            this.zza = Arrays.copyOf(objArr, zzq.zzb(length, i5));
        }
        zzn.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i6 = this.zzb;
        int i7 = i6 + i6;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.zzb = i6 + 1;
        return this;
    }

    public final zzy zzb() {
        zzw zzwVar = this.zzc;
        if (zzwVar == null) {
            zzai zzi = zzai.zzi(this.zzb, this.zza, this);
            zzw zzwVar2 = this.zzc;
            if (zzwVar2 == null) {
                return zzi;
            }
            throw zzwVar2.zza();
        }
        throw zzwVar.zza();
    }
}
