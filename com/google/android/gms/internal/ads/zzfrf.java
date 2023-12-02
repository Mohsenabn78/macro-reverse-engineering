package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfrf extends AbstractSet {
    final /* synthetic */ zzfrl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfrf(zzfrl zzfrlVar) {
        this.zza = zzfrlVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        int zzq;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zzq = this.zza.zzq(entry.getKey());
            if (zzq != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzfpc.zza(objArr[zzq], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfrl zzfrlVar = this.zza;
        Map zzj = zzfrlVar.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzfrd(zzfrlVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        int zzp;
        int i4;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfrl zzfrlVar = this.zza;
        if (!zzfrlVar.zzo()) {
            zzp = zzfrlVar.zzp();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object zzh = zzfrl.zzh(this.zza);
            zzfrl zzfrlVar2 = this.zza;
            int[] iArr = zzfrlVar2.zza;
            iArr.getClass();
            Object[] objArr = zzfrlVar2.zzb;
            objArr.getClass();
            Object[] objArr2 = zzfrlVar2.zzc;
            objArr2.getClass();
            int zzb = zzfrm.zzb(key, value, zzp, zzh, iArr, objArr, objArr2);
            if (zzb == -1) {
                return false;
            }
            this.zza.zzn(zzb, zzp);
            zzfrl zzfrlVar3 = this.zza;
            i4 = zzfrlVar3.zzg;
            zzfrlVar3.zzg = i4 - 1;
            this.zza.zzl();
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
