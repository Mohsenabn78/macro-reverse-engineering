package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzazi extends zzgpm implements zzgqx {
    private static final zzgps zzb = new zzazg();
    private static final zzazi zzd;
    private int zze;
    private long zzf;
    private int zzg;
    private long zzh;
    private long zzi;
    private zzgpr zzj = zzgpm.zzaJ();
    private zzazd zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private long zzr;

    static {
        zzazi zzaziVar = new zzazi();
        zzd = zzaziVar;
        zzgpm.zzaU(zzazi.class, zzaziVar);
    }

    private zzazi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzA(zzazi zzaziVar, int i4) {
        zzaziVar.zzm = i4 - 1;
        zzaziVar.zze |= 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzB(zzazi zzaziVar, int i4) {
        zzaziVar.zzn = i4 - 1;
        zzaziVar.zze |= 128;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzC(zzazi zzaziVar, int i4) {
        zzaziVar.zzp = i4 - 1;
        zzaziVar.zze |= 512;
    }

    public static zzazh zzg() {
        return (zzazh) zzd.zzaA();
    }

    public static zzazi zzi(byte[] bArr) throws zzgpy {
        return (zzazi) zzgpm.zzaF(zzd, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzazi zzaziVar, long j4) {
        zzaziVar.zze |= 1;
        zzaziVar.zzf = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzazi zzaziVar, long j4) {
        zzaziVar.zze |= 4;
        zzaziVar.zzh = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzazi zzaziVar, long j4) {
        zzaziVar.zze |= 8;
        zzaziVar.zzi = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzazi zzaziVar, Iterable iterable) {
        zzgpr zzgprVar = zzaziVar.zzj;
        if (!zzgprVar.zzc()) {
            zzaziVar.zzj = zzgpm.zzaK(zzgprVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzaziVar.zzj.zzh(((zzaxx) it.next()).zza());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzazi zzaziVar, zzazd zzazdVar) {
        zzazdVar.getClass();
        zzaziVar.zzk = zzazdVar;
        zzaziVar.zze |= 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzazi zzaziVar, int i4) {
        zzaziVar.zze |= 256;
        zzaziVar.zzo = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzazi zzaziVar, zzazm zzazmVar) {
        zzaziVar.zzq = zzazmVar.zza();
        zzaziVar.zze |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzazi zzaziVar, long j4) {
        zzaziVar.zze |= 2048;
        zzaziVar.zzr = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzy(zzazi zzaziVar, int i4) {
        zzaziVar.zzg = i4 - 1;
        zzaziVar.zze |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzz(zzazi zzaziVar, int i4) {
        zzaziVar.zzl = i4 - 1;
        zzaziVar.zze |= 32;
    }

    public final int zza() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    protected final Object zzb(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zzd;
                    }
                    return new zzazh(null);
                }
                return new zzazi();
            }
            zzgpq zzgpqVar = zzaym.zza;
            return zzgpm.zzaR(zzd, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zze", "zzf", "zzg", zzgpqVar, "zzh", "zzi", "zzj", zzaxw.zza, "zzk", "zzl", zzgpqVar, "zzm", zzgpqVar, "zzn", zzgpqVar, "zzo", "zzp", zzgpqVar, "zzq", zzazl.zza, "zzr"});
        }
        return (byte) 1;
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzazd zzf() {
        zzazd zzazdVar = this.zzk;
        if (zzazdVar == null) {
            return zzazd.zzd();
        }
        return zzazdVar;
    }

    public final zzazm zzj() {
        zzazm zzb2 = zzazm.zzb(this.zzq);
        if (zzb2 == null) {
            return zzazm.UNSPECIFIED;
        }
        return zzb2;
    }

    public final List zzk() {
        return new zzgpt(this.zzj, zzb);
    }

    public final int zzt() {
        int zza = zzayn.zza(this.zzm);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzu() {
        int zza = zzayn.zza(this.zzn);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzv() {
        int zza = zzayn.zza(this.zzp);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzw() {
        int zza = zzayn.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzx() {
        int zza = zzayn.zza(this.zzl);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
