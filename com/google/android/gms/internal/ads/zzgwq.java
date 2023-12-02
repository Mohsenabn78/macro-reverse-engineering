package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwq implements zzgwr {
    private static final Object zza = new Object();
    private volatile zzgwr zzb;
    private volatile Object zzc = zza;

    private zzgwq(zzgwr zzgwrVar) {
        this.zzb = zzgwrVar;
    }

    public static zzgwr zza(zzgwr zzgwrVar) {
        if (!(zzgwrVar instanceof zzgwq) && !(zzgwrVar instanceof zzgwd)) {
            return new zzgwq(zzgwrVar);
        }
        return zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj == zza) {
            zzgwr zzgwrVar = this.zzb;
            if (zzgwrVar == null) {
                return this.zzc;
            }
            Object zzb = zzgwrVar.zzb();
            this.zzc = zzb;
            this.zzb = null;
            return zzb;
        }
        return obj;
    }
}
