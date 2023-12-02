package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaj  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaj extends zzag {
    public zzaj() {
        super(4);
    }

    public final zzaj zzb(Object obj) {
        int i4 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i4) {
            this.zza = Arrays.copyOf(objArr, zzah.zza(length, i4));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i5 = this.zzb;
        this.zzb = i5 + 1;
        objArr2[i5] = obj;
        return this;
    }

    public final zzam zzc() {
        this.zzc = true;
        return zzam.zzg(this.zza, this.zzb);
    }
}
