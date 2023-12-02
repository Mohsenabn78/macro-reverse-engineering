package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgut extends zzgpm implements zzgqx {
    private static final zzgut zzb;
    private int zzd;
    private int zze;
    private zzgub zzg;
    private zzguf zzh;
    private int zzi;
    private int zzl;
    private byte zzn = 2;
    private String zzf = "";
    private zzgpr zzj = zzgpm.zzaJ();
    private String zzk = "";
    private zzgpv zzm = zzgpm.zzaN();

    static {
        zzgut zzgutVar = new zzgut();
        zzb = zzgutVar;
        zzgpm.zzaU(zzgut.class, zzgutVar);
    }

    private zzgut() {
    }

    public static zzgus zzc() {
        return (zzgus) zzb.zzaA();
    }

    public static /* synthetic */ void zzf(zzgut zzgutVar, int i4) {
        zzgutVar.zzd |= 1;
        zzgutVar.zze = i4;
    }

    public static /* synthetic */ void zzg(zzgut zzgutVar, String str) {
        str.getClass();
        zzgutVar.zzd |= 2;
        zzgutVar.zzf = str;
    }

    public static /* synthetic */ void zzh(zzgut zzgutVar, zzgub zzgubVar) {
        zzgubVar.getClass();
        zzgutVar.zzg = zzgubVar;
        zzgutVar.zzd |= 4;
    }

    public static /* synthetic */ void zzi(zzgut zzgutVar, String str) {
        str.getClass();
        zzgpv zzgpvVar = zzgutVar.zzm;
        if (!zzgpvVar.zzc()) {
            zzgutVar.zzm = zzgpm.zzaO(zzgpvVar);
        }
        zzgutVar.zzm.add(str);
    }

    public static /* synthetic */ void zzj(zzgut zzgutVar, int i4) {
        zzgutVar.zzl = i4 - 1;
        zzgutVar.zzd |= 64;
    }

    public final int zza() {
        return this.zzm.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    public final Object zzb(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            byte b4 = 1;
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            if (obj == null) {
                                b4 = 0;
                            }
                            this.zzn = b4;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzgus(null);
                }
                return new zzgut();
            }
            return zzgpm.zzaR(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzguq.zza, "zzm"});
        }
        return Byte.valueOf(this.zzn);
    }

    public final String zze() {
        return this.zzf;
    }
}
