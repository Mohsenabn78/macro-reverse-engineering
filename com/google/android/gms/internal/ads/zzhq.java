package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzhq extends zzcw {
    private final int zzc;
    private final zzvi zzd;

    public zzhq(boolean z3, zzvi zzviVar) {
        this.zzd = zzviVar;
        this.zzc = zzviVar.zzc();
    }

    private final int zzw(int i4, boolean z3) {
        if (z3) {
            return this.zzd.zzd(i4);
        }
        if (i4 >= this.zzc - 1) {
            return -1;
        }
        return i4 + 1;
    }

    private final int zzx(int i4, boolean z3) {
        if (z3) {
            return this.zzd.zze(i4);
        }
        if (i4 <= 0) {
            return -1;
        }
        return i4 - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zza(Object obj) {
        int zza;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        if (zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1) {
            return -1;
        }
        return zzs(zzp) + zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzct zzd(int i4, zzct zzctVar, boolean z3) {
        int zzq = zzq(i4);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i4 - zzs(zzq), zzctVar, z3);
        zzctVar.zzd += zzt;
        if (z3) {
            Object zzv = zzv(zzq);
            Object obj = zzctVar.zzc;
            obj.getClass();
            zzctVar.zzc = Pair.create(zzv, obj);
        }
        return zzctVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzcv zze(int i4, zzcv zzcvVar, long j4) {
        int zzr = zzr(i4);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i4 - zzt, zzcvVar, j4);
        Object zzv = zzv(zzr);
        if (!zzcv.zza.equals(zzcvVar.zzc)) {
            zzv = Pair.create(zzv, zzcvVar.zzc);
        }
        zzcvVar.zzc = zzv;
        zzcvVar.zzo += zzs;
        zzcvVar.zzp += zzs;
        return zzcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final Object zzf(int i4) {
        int zzq = zzq(i4);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i4 - zzs(zzq)));
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzg(boolean z3) {
        int i4;
        if (this.zzc == 0) {
            return -1;
        }
        if (z3) {
            i4 = this.zzd.zza();
        } else {
            i4 = 0;
        }
        while (zzu(i4).zzo()) {
            i4 = zzw(i4, z3);
            if (i4 == -1) {
                return -1;
            }
        }
        return zzt(i4) + zzu(i4).zzg(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzh(boolean z3) {
        int i4;
        int i5 = this.zzc;
        if (i5 == 0) {
            return -1;
        }
        if (z3) {
            i4 = this.zzd.zzb();
        } else {
            i4 = i5 - 1;
        }
        while (zzu(i4).zzo()) {
            i4 = zzx(i4, z3);
            if (i4 == -1) {
                return -1;
            }
        }
        return zzt(i4) + zzu(i4).zzh(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzj(int i4, int i5, boolean z3) {
        int i6;
        int zzr = zzr(i4);
        int zzt = zzt(zzr);
        zzcw zzu = zzu(zzr);
        int i7 = i4 - zzt;
        if (i5 == 2) {
            i6 = 0;
        } else {
            i6 = i5;
        }
        int zzj = zzu.zzj(i7, i6, z3);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z3);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z3);
        }
        if (zzw != -1) {
            return zzt(zzw) + zzu(zzw).zzg(z3);
        }
        if (i5 != 2) {
            return -1;
        }
        return zzg(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzk(int i4, int i5, boolean z3) {
        int zzr = zzr(i4);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i4 - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx == -1) {
            return -1;
        }
        return zzt(zzx) + zzu(zzx).zzh(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzct zzn(Object obj, zzct zzctVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzctVar);
        zzctVar.zzd += zzt;
        zzctVar.zzc = obj;
        return zzctVar;
    }

    protected abstract int zzp(Object obj);

    protected abstract int zzq(int i4);

    protected abstract int zzr(int i4);

    protected abstract int zzs(int i4);

    protected abstract int zzt(int i4);

    protected abstract zzcw zzu(int i4);

    protected abstract Object zzv(int i4);
}
