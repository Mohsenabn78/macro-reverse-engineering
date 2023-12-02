package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzth  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzth extends zzahd implements zzaij {
    private static final zzth zzb;
    private String zzd = "";
    private zzafy zze = zzafy.zzb;
    private int zzf;

    static {
        zzth zzthVar = new zzth();
        zzb = zzthVar;
        zzahd.zzH(zzth.class, zzthVar);
    }

    private zzth() {
    }

    public static zztg zza() {
        return (zztg) zzb.zzt();
    }

    public static zzth zzc() {
        return zzb;
    }

    public static zzth zzd(byte[] bArr, zzagq zzagqVar) throws zzahl {
        return (zzth) zzahd.zzz(zzb, bArr, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzth zzthVar, String str) {
        str.getClass();
        zzthVar.zzd = str;
    }

    public final zzui zze() {
        zzui zzb2 = zzui.zzb(this.zzf);
        if (zzb2 == null) {
            return zzui.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final zzafy zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahd
    public final Object zzj(int i4, Object obj, Object obj2) {
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
                    return new zztg(null);
                }
                return new zzth();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
