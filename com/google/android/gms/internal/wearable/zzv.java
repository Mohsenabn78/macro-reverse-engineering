package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzv extends zzbv implements zzdd {
    private static final zzv zzb;
    private int zze;
    private zzu zzg;
    private byte zzh = 2;
    private int zzf = 1;

    static {
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzbv.zzZ(zzv.class, zzvVar);
    }

    private zzv() {
    }

    public static zzp zza() {
        return (zzp) zzb.zzN();
    }

    public static zzv zzd() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzv zzvVar, zzu zzuVar) {
        zzuVar.getClass();
        zzvVar.zzg = zzuVar;
        zzvVar.zze |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzv zzvVar, int i4) {
        zzvVar.zzf = i4;
        zzvVar.zze |= 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzbv
    public final Object zzG(int i4, Object obj, Object obj2) {
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
                            this.zzh = b4;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzp(null);
                }
                return new zzv();
            }
            return zzbv.zzY(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᐉ\u0001", new Object[]{"zze", "zzf", zzr.zza, "zzg"});
        }
        return Byte.valueOf(this.zzh);
    }

    public final zzu zzb() {
        zzu zzuVar = this.zzg;
        if (zzuVar == null) {
            return zzu.zzj();
        }
        return zzuVar;
    }

    public final int zzf() {
        int zza = zzs.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
