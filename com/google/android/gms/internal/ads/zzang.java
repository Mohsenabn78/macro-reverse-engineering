package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzang extends zzgpm implements zzgqx {
    private static final zzang zzb;
    private int zzd;
    private long zzf;
    private long zzj;
    private long zzk;
    private long zzm;
    private int zzq;
    private String zze = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzl = "";
    private String zzn = "";
    private String zzo = "";
    private zzgpv zzp = zzgpm.zzaN();

    static {
        zzang zzangVar = new zzang();
        zzb = zzangVar;
        zzgpm.zzaU(zzang.class, zzangVar);
    }

    private zzang() {
    }

    public static zzanc zza() {
        return (zzanc) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzang zzangVar, long j4) {
        zzangVar.zzd |= 2;
        zzangVar.zzf = j4;
    }

    public static /* synthetic */ void zze(zzang zzangVar, String str) {
        str.getClass();
        zzangVar.zzd |= 4;
        zzangVar.zzg = str;
    }

    public static /* synthetic */ void zzf(zzang zzangVar, String str) {
        str.getClass();
        zzangVar.zzd |= 8;
        zzangVar.zzh = str;
    }

    public static /* synthetic */ void zzg(zzang zzangVar, String str) {
        zzangVar.zzd |= 16;
        zzangVar.zzi = str;
    }

    public static /* synthetic */ void zzh(zzang zzangVar, String str) {
        zzangVar.zzd |= 1024;
        zzangVar.zzo = str;
    }

    public static /* synthetic */ void zzi(zzang zzangVar, String str) {
        str.getClass();
        zzangVar.zzd |= 1;
        zzangVar.zze = str;
    }

    public static /* synthetic */ void zzj(zzang zzangVar, int i4) {
        zzangVar.zzq = i4 - 1;
        zzangVar.zzd |= 2048;
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
                    return new zzanc(null);
                }
                return new zzang();
            }
            return zzgpm.zzaR(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzane.class, "zzq", zzanf.zza});
        }
        return (byte) 1;
    }
}
