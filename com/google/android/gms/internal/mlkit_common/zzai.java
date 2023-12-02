package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
class zzai extends zzaj {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(int i4) {
    }

    private final void zzc(int i4) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i4) {
            this.zza = Arrays.copyOf(objArr, zzaj.zzb(length, i4));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzai zza(Object obj) {
        obj.getClass();
        zzc(this.zzb + 1);
        Object[] objArr = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        objArr[i4] = obj;
        return this;
    }
}
