package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzfj extends zzcb implements zzdg {
    private static final zzfj zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        zzfj zzfjVar = new zzfj();
        zzb = zzfjVar;
        zzcb.zzo(zzfj.class, zzfjVar);
    }

    private zzfj() {
    }

    public static zzfh zzu() {
        return (zzfh) zzb.zze();
    }

    public static /* synthetic */ void zzw(zzfj zzfjVar, int i4) {
        zzfjVar.zzd |= 1;
        zzfjVar.zze = i4;
    }

    public static /* synthetic */ void zzx(zzfj zzfjVar, String str) {
        str.getClass();
        zzfjVar.zzd |= 2;
        zzfjVar.zzf = str;
    }

    public static /* synthetic */ void zzy(zzfj zzfjVar, int i4) {
        zzfjVar.zzg = i4 - 1;
        zzfjVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcb
    public final Object zzt(int i4, Object obj, Object obj2) {
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
                    return new zzfh(null);
                }
                return new zzfj();
            }
            return zzcb.zzl(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004ဌ\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzfi.zza, "zzh"});
        }
        return (byte) 1;
    }
}
