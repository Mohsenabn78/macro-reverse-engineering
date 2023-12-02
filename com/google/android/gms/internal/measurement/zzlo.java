package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public class zzlo {
    private static final zzkn zzb = zzkn.zza;
    protected volatile zzmi zza;
    private volatile zzka zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzloVar = (zzlo) obj;
        zzmi zzmiVar = this.zza;
        zzmi zzmiVar2 = zzloVar.zza;
        if (zzmiVar == null && zzmiVar2 == null) {
            return zzb().equals(zzloVar.zzb());
        }
        if (zzmiVar != null && zzmiVar2 != null) {
            return zzmiVar.equals(zzmiVar2);
        }
        if (zzmiVar != null) {
            zzloVar.zzc(zzmiVar.zzbV());
            return zzmiVar.equals(zzloVar.zza);
        }
        zzc(zzmiVar2.zzbV());
        return this.zza.equals(zzmiVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzjx) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbz();
        }
        return 0;
    }

    public final zzka zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzka.zzb;
            } else {
                this.zzc = this.zza.zzbv();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzmi zzmiVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzmiVar;
                    this.zzc = zzka.zzb;
                } catch (zzll unused) {
                    this.zza = zzmiVar;
                    this.zzc = zzka.zzb;
                }
            }
        }
    }
}
