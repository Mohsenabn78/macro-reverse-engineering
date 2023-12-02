package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzazn extends zzgpm implements zzgqx {
    private static final zzazn zzb;
    private int zzd;
    private int zzf;
    private int zzg;
    private long zzh;
    private long zzk;
    private int zzl;
    private zzgpv zze = zzgpm.zzaN();
    private String zzi = "";
    private String zzj = "";

    static {
        zzazn zzaznVar = new zzazn();
        zzb = zzaznVar;
        zzgpm.zzaU(zzazn.class, zzaznVar);
    }

    private zzazn() {
    }

    public static zzazj zza() {
        return (zzazj) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzazn zzaznVar, Iterable iterable) {
        zzgpv zzgpvVar = zzaznVar.zze;
        if (!zzgpvVar.zzc()) {
            zzaznVar.zze = zzgpm.zzaO(zzgpvVar);
        }
        zzgnn.zzav(iterable, zzaznVar.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzazn zzaznVar, int i4) {
        zzaznVar.zzd |= 1;
        zzaznVar.zzf = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzazn zzaznVar, int i4) {
        zzaznVar.zzd |= 2;
        zzaznVar.zzg = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzazn zzaznVar, long j4) {
        zzaznVar.zzd |= 4;
        zzaznVar.zzh = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzazn zzaznVar, String str) {
        str.getClass();
        zzaznVar.zzd |= 8;
        zzaznVar.zzi = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzazn zzaznVar, String str) {
        str.getClass();
        zzaznVar.zzd |= 16;
        zzaznVar.zzj = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzazn zzaznVar, long j4) {
        zzaznVar.zzd |= 32;
        zzaznVar.zzk = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzazn zzaznVar, int i4) {
        zzaznVar.zzd |= 64;
        zzaznVar.zzl = i4;
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
                    return new zzazj(null);
                }
                return new zzazn();
            }
            return zzgpm.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzd", "zze", zzazi.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }
}
