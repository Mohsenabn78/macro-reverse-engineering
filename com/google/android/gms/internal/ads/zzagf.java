package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagf {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfa zzf;
    private final zzfa zzg;
    private int zzh;
    private int zzi;

    public zzagf(zzfa zzfaVar, zzfa zzfaVar2, boolean z3) throws zzcd {
        this.zzg = zzfaVar;
        this.zzf = zzfaVar2;
        this.zze = z3;
        zzfaVar2.zzF(12);
        this.zza = zzfaVar2.zzn();
        zzfaVar.zzF(12);
        this.zzi = zzfaVar.zzn();
        zzaba.zzb(zzfaVar.zze() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long zzs;
        int i4 = this.zzb + 1;
        this.zzb = i4;
        if (i4 == this.zza) {
            return false;
        }
        if (this.zze) {
            zzs = this.zzf.zzt();
        } else {
            zzs = this.zzf.zzs();
        }
        this.zzd = zzs;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzn();
            this.zzg.zzG(4);
            int i5 = -1;
            int i6 = this.zzi - 1;
            this.zzi = i6;
            if (i6 > 0) {
                i5 = (-1) + this.zzg.zzn();
            }
            this.zzh = i5;
        }
        return true;
    }
}
