package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class zzbcr {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbcr(String str, Object obj, int i4) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i4;
    }

    public static zzbcr zza(String str, double d4) {
        return new zzbcr(str, Double.valueOf(d4), 3);
    }

    public static zzbcr zzb(String str, long j4) {
        return new zzbcr(str, Long.valueOf(j4), 2);
    }

    public static zzbcr zzc(String str, String str2) {
        return new zzbcr(str, str2, 4);
    }

    public static zzbcr zzd(String str, boolean z3) {
        return new zzbcr(str, Boolean.valueOf(z3), 1);
    }

    public final Object zze() {
        zzbdu zza = zzbdw.zza();
        if (zza == null) {
            if (zzbdw.zzb() != null) {
                zzbdw.zzb().zza();
            }
            return this.zzb;
        }
        int i4 = this.zzc - 1;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return zza.zzd(this.zza, (String) this.zzb);
                }
                return zza.zzb(this.zza, ((Double) this.zzb).doubleValue());
            }
            return zza.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        return zza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
    }
}
