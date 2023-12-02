package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzct {
    @Nullable
    public Object zzb;
    @Nullable
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzm = zzd.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzcs
    };

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzct.class.equals(obj.getClass())) {
            zzct zzctVar = (zzct) obj;
            if (zzfj.zzC(this.zzb, zzctVar.zzb) && zzfj.zzC(this.zzc, zzctVar.zzc) && this.zzd == zzctVar.zzd && this.zze == zzctVar.zze && this.zzg == zzctVar.zzg && zzfj.zzC(this.zzm, zzctVar.zzm)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        Object obj = this.zzb;
        int i4 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.zzc;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        int i5 = ((((hashCode + Opcodes.RSUB_INT_LIT8) * 31) + i4) * 31) + this.zzd;
        long j4 = this.zze;
        return (((((i5 * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzm.hashCode();
    }

    public final int zza(int i4) {
        return this.zzm.zza(i4).zzc;
    }

    public final int zzb() {
        int i4 = this.zzm.zzc;
        return 0;
    }

    public final int zzc(long j4) {
        return -1;
    }

    public final int zzd(long j4) {
        this.zzm.zzb(-1);
        return -1;
    }

    public final int zze(int i4) {
        return this.zzm.zza(i4).zza(-1);
    }

    public final int zzf(int i4, int i5) {
        return this.zzm.zza(i4).zza(i5);
    }

    public final int zzg() {
        int i4 = this.zzm.zze;
        return 0;
    }

    public final long zzh(int i4, int i5) {
        zzc zza2 = this.zzm.zza(i4);
        if (zza2.zzc != -1) {
            return zza2.zzf[i5];
        }
        return -9223372036854775807L;
    }

    public final long zzi(int i4) {
        long j4 = this.zzm.zza(i4).zzb;
        return 0L;
    }

    public final long zzj() {
        long j4 = this.zzm.zzd;
        return 0L;
    }

    public final long zzk(int i4) {
        long j4 = this.zzm.zza(i4).zzg;
        return 0L;
    }

    public final zzct zzl(@Nullable Object obj, @Nullable Object obj2, int i4, long j4, long j5, zzd zzdVar, boolean z3) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = 0;
        this.zze = j4;
        this.zzf = 0L;
        this.zzm = zzdVar;
        this.zzg = z3;
        return this;
    }

    public final boolean zzm(int i4) {
        zzb();
        if (i4 == -1) {
            this.zzm.zzb(-1);
            return false;
        }
        return false;
    }

    public final boolean zzn(int i4) {
        boolean z3 = this.zzm.zza(i4).zzh;
        return false;
    }
}
