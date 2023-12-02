package com.google.android.gms.internal.mlkit_translate;

import java.util.Map;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzch implements Map.Entry {
    zzch zza;
    zzch zzb;
    zzch zzc;
    zzch zzd;
    zzch zze;
    final Object zzf;
    Object zzg;
    int zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzch() {
        this.zzf = null;
        this.zze = this;
        this.zzd = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzg;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzf;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzg;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        Object obj = this.zzf;
        int i4 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.zzg;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        return hashCode ^ i4;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.zzg;
        this.zzg = obj;
        return obj2;
    }

    public final String toString() {
        return this.zzf + "=" + this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzch(zzch zzchVar, Object obj, zzch zzchVar2, zzch zzchVar3) {
        this.zza = zzchVar;
        this.zzf = obj;
        this.zzh = 1;
        this.zzd = zzchVar2;
        this.zze = zzchVar3;
        zzchVar3.zzd = this;
        zzchVar2.zze = this;
    }
}
