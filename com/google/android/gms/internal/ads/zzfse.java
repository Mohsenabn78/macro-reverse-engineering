package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfse {
    Object[] zza;
    int zzb;
    zzfsd zzc;

    public zzfse() {
        this(4);
    }

    private final void zzd(int i4) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i5 = i4 + i4;
        if (i5 > length) {
            this.zza = Arrays.copyOf(objArr, zzfrw.zze(length, i5));
        }
    }

    public final zzfse zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfqz.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i4 = this.zzb;
        int i5 = i4 + i4;
        objArr[i5] = obj;
        objArr[i5 + 1] = obj2;
        this.zzb = i4 + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzfse zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfsf zzc() {
        zzfsd zzfsdVar = this.zzc;
        if (zzfsdVar == null) {
            zzftr zzj = zzftr.zzj(this.zzb, this.zza, this);
            zzfsd zzfsdVar2 = this.zzc;
            if (zzfsdVar2 == null) {
                return zzj;
            }
            throw zzfsdVar2.zza();
        }
        throw zzfsdVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfse(int i4) {
        this.zza = new Object[i4 + i4];
        this.zzb = 0;
    }
}
