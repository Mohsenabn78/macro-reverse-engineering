package com.google.android.gms.internal.nearby;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzsu extends zzso {
    public zzsu() {
        super(4);
    }

    public final zzsu zza(Object obj) {
        obj.getClass();
        int i4 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i4) {
            int i5 = length + (length >> 1) + 1;
            if (i5 < i4) {
                int highestOneBit = Integer.highestOneBit(i4 - 1);
                i5 = highestOneBit + highestOneBit;
            }
            if (i5 < 0) {
                i5 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i5);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        objArr2[i6] = obj;
        return this;
    }

    public final zzsv zzb() {
        zzsv zzl;
        int i4 = this.zzb;
        if (i4 != 0) {
            if (i4 != 1) {
                zzl = zzsv.zzl(i4, this.zza);
                this.zzb = zzl.size();
                this.zzc = true;
                return zzl;
            }
            Object obj = this.zza[0];
            obj.getClass();
            return new zzta(obj);
        }
        return zzsz.zza;
    }
}
