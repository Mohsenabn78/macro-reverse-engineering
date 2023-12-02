package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkk extends zzgpm implements zzgqx {
    private static final zzgkk zzb;
    private String zzd = "";
    private zzgoe zze = zzgoe.zzb;
    private int zzf;

    static {
        zzgkk zzgkkVar = new zzgkk();
        zzb = zzgkkVar;
        zzgpm.zzaU(zzgkk.class, zzgkkVar);
    }

    private zzgkk() {
    }

    public static zzgkh zza() {
        return (zzgkh) zzb.zzaA();
    }

    public static zzgkk zze() {
        return zzb;
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
                    return new zzgkh(null);
                }
                return new zzgkk();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgkj zzc() {
        zzgkj zzgkjVar;
        int i4 = this.zzf;
        zzgkj zzgkjVar2 = zzgkj.UNKNOWN_KEYMATERIAL;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            zzgkjVar = null;
                        } else {
                            zzgkjVar = zzgkj.REMOTE;
                        }
                    } else {
                        zzgkjVar = zzgkj.ASYMMETRIC_PUBLIC;
                    }
                } else {
                    zzgkjVar = zzgkj.ASYMMETRIC_PRIVATE;
                }
            } else {
                zzgkjVar = zzgkj.SYMMETRIC;
            }
        } else {
            zzgkjVar = zzgkj.UNKNOWN_KEYMATERIAL;
        }
        if (zzgkjVar == null) {
            return zzgkj.UNRECOGNIZED;
        }
        return zzgkjVar;
    }

    public final zzgoe zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
