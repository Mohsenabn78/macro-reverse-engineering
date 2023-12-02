package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcgo {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgo(int i4, int i5, int i6) {
        this.zzc = i4;
        this.zzb = i5;
        this.zza = i6;
    }

    public static zzcgo zza() {
        return new zzcgo(0, 0, 0);
    }

    public static zzcgo zzb(int i4, int i5) {
        return new zzcgo(1, i4, i5);
    }

    public static zzcgo zzc(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        if (zzqVar.zzd) {
            return new zzcgo(3, 0, 0);
        }
        if (zzqVar.zzi) {
            return new zzcgo(2, 0, 0);
        }
        if (zzqVar.zzh) {
            return zza();
        }
        return zzb(zzqVar.zzf, zzqVar.zzc);
    }

    public static zzcgo zzd() {
        return new zzcgo(5, 0, 0);
    }

    public static zzcgo zze() {
        return new zzcgo(4, 0, 0);
    }

    public final boolean zzf() {
        if (this.zzc == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        if (this.zzc == 2) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (this.zzc == 5) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if (this.zzc == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzj() {
        if (this.zzc == 4) {
            return true;
        }
        return false;
    }
}
