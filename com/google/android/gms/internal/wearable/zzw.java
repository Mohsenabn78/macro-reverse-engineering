package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzw extends zzbv implements zzdd {
    private static final zzw zzb;
    private int zze;
    private zzv zzg;
    private byte zzh = 2;
    private String zzf = "";

    static {
        zzw zzwVar = new zzw();
        zzb = zzwVar;
        zzbv.zzZ(zzw.class, zzwVar);
    }

    private zzw() {
    }

    public static zzo zza() {
        return (zzo) zzb.zzN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzw zzwVar, String str) {
        str.getClass();
        zzwVar.zze |= 1;
        zzwVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzw zzwVar, zzv zzvVar) {
        zzvVar.getClass();
        zzwVar.zzg = zzvVar;
        zzwVar.zze |= 2;
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
                    return new zzo(null);
                }
                return new zzw();
            }
            return zzbv.zzY(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        return Byte.valueOf(this.zzh);
    }

    public final zzv zzb() {
        zzv zzvVar = this.zzg;
        if (zzvVar == null) {
            return zzv.zzd();
        }
        return zzvVar;
    }

    public final String zzd() {
        return this.zzf;
    }
}
