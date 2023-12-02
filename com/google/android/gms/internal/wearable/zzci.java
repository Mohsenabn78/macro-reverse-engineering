package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class zzci {
    private static final zzbj zzb = zzbj.zza();
    protected volatile zzdc zza;
    private volatile zzaw zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzci)) {
            return false;
        }
        zzci zzciVar = (zzci) obj;
        zzdc zzdcVar = this.zza;
        zzdc zzdcVar2 = zzciVar.zza;
        if (zzdcVar == null && zzdcVar2 == null) {
            return zzb().equals(zzciVar.zzb());
        }
        if (zzdcVar != null && zzdcVar2 != null) {
            return zzdcVar.equals(zzdcVar2);
        }
        if (zzdcVar != null) {
            zzciVar.zzc(zzdcVar.zzac());
            return zzdcVar.equals(zzciVar.zza);
        }
        zzc(zzdcVar2.zzac());
        return this.zza.equals(zzdcVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzat) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzM();
        }
        return 0;
    }

    public final zzaw zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzaw.zzb;
            } else {
                this.zzc = this.zza.zzI();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzdc zzdcVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzdcVar;
                    this.zzc = zzaw.zzb;
                } catch (zzcf unused) {
                    this.zza = zzdcVar;
                    this.zzc = zzaw.zzb;
                }
            }
        }
    }
}
