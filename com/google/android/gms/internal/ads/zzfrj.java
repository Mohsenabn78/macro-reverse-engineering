package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfrj extends zzfqw {
    final /* synthetic */ zzfrl zza;
    private final Object zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfrj(zzfrl zzfrlVar, int i4) {
        this.zza = zzfrlVar;
        Object[] objArr = zzfrlVar.zzb;
        objArr.getClass();
        this.zzb = objArr[i4];
        this.zzc = i4;
    }

    private final void zza() {
        int zzq;
        int i4 = this.zzc;
        if (i4 != -1 && i4 < this.zza.size()) {
            Object obj = this.zzb;
            zzfrl zzfrlVar = this.zza;
            int i5 = this.zzc;
            Object[] objArr = zzfrlVar.zzb;
            objArr.getClass();
            if (zzfpc.zza(obj, objArr[i5])) {
                return;
            }
        }
        zzq = this.zza.zzq(this.zzb);
        this.zzc = zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzfqw, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfqw, java.util.Map.Entry
    public final Object getValue() {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.get(this.zzb);
        }
        zza();
        int i4 = this.zzc;
        if (i4 == -1) {
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        return objArr[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzfqw, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.put(this.zzb, obj);
        }
        zza();
        int i4 = this.zzc;
        if (i4 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        objArr.getClass();
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }
}
