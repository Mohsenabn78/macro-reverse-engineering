package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzw {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzv zzc;

    public final zzw zza(Object obj, Object obj2) {
        int i4 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i5 = i4 + i4;
        if (i5 > length) {
            int i6 = length + (length >> 1) + 1;
            if (i6 < i5) {
                int highestOneBit = Integer.highestOneBit(i5 - 1);
                i6 = highestOneBit + highestOneBit;
            }
            if (i6 < 0) {
                i6 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i6);
        }
        zzp.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i7 = this.zzb;
        int i8 = i7 + i7;
        objArr2[i8] = obj;
        objArr2[i8 + 1] = obj2;
        this.zzb = i7 + 1;
        return this;
    }

    public final zzx zzb() {
        zzv zzvVar = this.zzc;
        if (zzvVar == null) {
            zzaf zzf = zzaf.zzf(this.zzb, this.zza, this);
            zzv zzvVar2 = this.zzc;
            if (zzvVar2 == null) {
                return zzf;
            }
            throw zzvVar2.zza();
        }
        throw zzvVar.zza();
    }
}
