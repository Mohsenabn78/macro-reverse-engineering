package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwd implements zzgwr, zzgvy {
    private static final Object zza = new Object();
    private volatile zzgwr zzb;
    private volatile Object zzc = zza;

    private zzgwd(zzgwr zzgwrVar) {
        this.zzb = zzgwrVar;
    }

    public static zzgvy zza(zzgwr zzgwrVar) {
        if (zzgwrVar instanceof zzgvy) {
            return (zzgvy) zzgwrVar;
        }
        zzgwrVar.getClass();
        return new zzgwd(zzgwrVar);
    }

    public static zzgwr zzc(zzgwr zzgwrVar) {
        if (zzgwrVar instanceof zzgwd) {
            return zzgwrVar;
        }
        return new zzgwd(zzgwrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
