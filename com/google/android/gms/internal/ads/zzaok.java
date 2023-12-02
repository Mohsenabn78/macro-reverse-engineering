package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaok extends zzgpm implements zzgqx {
    private static final zzaok zzb;
    private int zzd;
    private long zzt;
    private long zzu;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private int zzk = 1000;
    private long zzl = -1;
    private long zzm = -1;
    private long zzn = -1;
    private int zzo = 1000;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;

    static {
        zzaok zzaokVar = new zzaok();
        zzb = zzaokVar;
        zzgpm.zzaU(zzaok.class, zzaokVar);
    }

    private zzaok() {
    }

    public static zzaoj zza() {
        return (zzaoj) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 1;
        zzaokVar.zze = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 2;
        zzaokVar.zzf = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 4;
        zzaokVar.zzg = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 8;
        zzaokVar.zzh = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzaok zzaokVar) {
        zzaokVar.zzd &= -9;
        zzaokVar.zzh = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 16;
        zzaokVar.zzi = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 32;
        zzaokVar.zzj = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 128;
        zzaokVar.zzl = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 256;
        zzaokVar.zzm = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 512;
        zzaokVar.zzn = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 2048;
        zzaokVar.zzp = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 4096;
        zzaokVar.zzq = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 8192;
        zzaokVar.zzr = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 16384;
        zzaokVar.zzs = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 32768;
        zzaokVar.zzt = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 65536;
        zzaokVar.zzu = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzt(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 131072;
        zzaokVar.zzv = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzu(zzaok zzaokVar, long j4) {
        zzaokVar.zzd |= 262144;
        zzaokVar.zzw = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzv(zzaok zzaokVar, int i4) {
        zzaokVar.zzk = i4 - 1;
        zzaokVar.zzd |= 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzw(zzaok zzaokVar, int i4) {
        zzaokVar.zzo = i4 - 1;
        zzaokVar.zzd |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgpm
    public final Object zzb(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zzaoj(null);
                }
                return new zzaok();
            }
            zzgpq zzgpqVar = zzaot.zza;
            return zzgpm.zzaR(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzgpqVar, "zzl", "zzm", "zzn", "zzo", zzgpqVar, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        }
        return (byte) 1;
    }
}
