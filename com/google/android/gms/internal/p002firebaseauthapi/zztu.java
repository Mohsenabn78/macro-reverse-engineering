package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zztu extends zzahd implements zzaij {
    private static final zztu zzb;
    private int zzd;
    private zzahi zze = zzahd.zzA();

    static {
        zztu zztuVar = new zztu();
        zzb = zztuVar;
        zzahd.zzH(zztu.class, zztuVar);
    }

    private zztu() {
    }

    public static zztr zza() {
        return (zztr) zzb.zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zztu zztuVar, zztt zzttVar) {
        zzttVar.getClass();
        zzahi zzahiVar = zztuVar.zze;
        if (!zzahiVar.zzc()) {
            zztuVar.zze = zzahd.zzB(zzahiVar);
        }
        zztuVar.zze.add(zzttVar);
    }

    public final zztt zzb(int i4) {
        return (zztt) this.zze.get(0);
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
                    return new zztr(null);
                }
                return new zztu();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zztt.class});
        }
        return (byte) 1;
    }
}
