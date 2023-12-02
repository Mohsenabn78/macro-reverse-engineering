package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzatp extends zzgpm implements zzgqx {
    private static final zzatp zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzatp zzatpVar = new zzatp();
        zzb = zzatpVar;
        zzgpm.zzaU(zzatp.class, zzatpVar);
    }

    private zzatp() {
    }

    public static zzato zze() {
        return (zzato) zzb.zzaA();
    }

    public static zzatp zzg() {
        return zzb;
    }

    public static zzatp zzh(zzgoe zzgoeVar) throws zzgpy {
        return (zzatp) zzgpm.zzaE(zzb, zzgoeVar);
    }

    public static zzatp zzi(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzatp) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzatp zzatpVar, String str) {
        str.getClass();
        zzatpVar.zzd |= 1;
        zzatpVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzatp zzatpVar, long j4) {
        zzatpVar.zzd |= 16;
        zzatpVar.zzi = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzatp zzatpVar, String str) {
        str.getClass();
        zzatpVar.zzd |= 2;
        zzatpVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzatp zzatpVar, long j4) {
        zzatpVar.zzd |= 4;
        zzatpVar.zzg = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzatp zzatpVar, long j4) {
        zzatpVar.zzd |= 8;
        zzatpVar.zzh = j4;
    }

    public final long zza() {
        return this.zzh;
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
                    return new zzato(null);
                }
                return new zzatp();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final String zzk() {
        return this.zze;
    }
}
