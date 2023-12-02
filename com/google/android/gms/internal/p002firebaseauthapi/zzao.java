package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzao {
    Object[] zza;
    int zzb;
    zzan zzc;

    public zzao() {
        this(4);
    }

    private final void zzb(int i4) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i5 = i4 + i4;
        if (i5 > length) {
            this.zza = Arrays.copyOf(objArr, zzah.zza(length, i5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzao zza(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzb(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            zzb(this.zzb + 1);
            zzae.zza(key, value);
            Object[] objArr = this.zza;
            int i4 = this.zzb;
            int i5 = i4 + i4;
            objArr[i5] = key;
            objArr[i5 + 1] = value;
            this.zzb = i4 + 1;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(int i4) {
        this.zza = new Object[i4 + i4];
        this.zzb = 0;
    }
}
