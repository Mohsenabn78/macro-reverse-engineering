package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkw extends zzgpm implements zzgqx {
    private static final zzgkw zzb;
    private zzgkk zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgkw zzgkwVar = new zzgkw();
        zzb = zzgkwVar;
        zzgpm.zzaU(zzgkw.class, zzgkwVar);
    }

    private zzgkw() {
    }

    public static zzgkv zzd() {
        return (zzgkv) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzgkw zzgkwVar, zzgkk zzgkkVar) {
        zzgkkVar.getClass();
        zzgkwVar.zzd = zzgkkVar;
    }

    public final int zza() {
        return this.zzf;
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
                    return new zzgkv(null);
                }
                return new zzgkw();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final zzgkk zzc() {
        zzgkk zzgkkVar = this.zzd;
        if (zzgkkVar == null) {
            return zzgkk.zze();
        }
        return zzgkkVar;
    }

    public final zzglq zzf() {
        zzglq zzb2 = zzglq.zzb(this.zzg);
        if (zzb2 == null) {
            return zzglq.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final boolean zzj() {
        if (this.zzd != null) {
            return true;
        }
        return false;
    }

    public final int zzk() {
        int i4 = this.zze;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        i5 = 0;
                    } else {
                        i5 = 5;
                    }
                } else {
                    i5 = 4;
                }
            } else {
                i5 = 3;
            }
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }
}
