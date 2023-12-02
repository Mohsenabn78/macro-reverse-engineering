package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzaq {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzap zzc;

    public final zzaq zza(Object obj, Object obj2) {
        int i4 = this.zzb + 1;
        int i5 = i4 + i4;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i5 > length) {
            this.zza = Arrays.copyOf(objArr, zzaj.zzb(length, i5));
        }
        zzaf.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i6 = this.zzb;
        int i7 = i6 + i6;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.zzb = i6 + 1;
        return this;
    }

    public final zzar zzb() {
        zzap zzapVar = this.zzc;
        if (zzapVar == null) {
            zzaz zzg = zzaz.zzg(this.zzb, this.zza, this);
            zzap zzapVar2 = this.zzc;
            if (zzapVar2 == null) {
                return zzg;
            }
            throw zzapVar2.zza();
        }
        throw zzapVar.zza();
    }
}
