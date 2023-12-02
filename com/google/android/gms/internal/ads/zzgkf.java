package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkf extends zzgpm implements zzgqx {
    private static final zzgkf zzb;
    private int zzd;
    private int zze;

    static {
        zzgkf zzgkfVar = new zzgkf();
        zzb = zzgkfVar;
        zzgpm.zzaU(zzgkf.class, zzgkfVar);
    }

    private zzgkf() {
    }

    public static zzgke zzc() {
        return (zzgke) zzb.zzaA();
    }

    public static zzgkf zze() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

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
                    return new zzgke(null);
                }
                return new zzgkf();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final int zzg() {
        int i4 = this.zzd;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    i5 = 5;
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                i5 = 0;
                            } else {
                                i5 = 7;
                            }
                        } else {
                            i5 = 6;
                        }
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
