package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaim  reason: invalid package */
/* loaded from: classes4.dex */
final class zzaim implements zzaiu {
    private final zzaii zza;
    private final zzajo zzb;
    private final boolean zzc;
    private final zzagr zzd;

    private zzaim(zzajo zzajoVar, zzagr zzagrVar, zzaii zzaiiVar) {
        this.zzb = zzajoVar;
        this.zzc = zzagrVar.zzh(zzaiiVar);
        this.zzd = zzagrVar;
        this.zza = zzaiiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaim zzc(zzajo zzajoVar, zzagr zzagrVar, zzaii zzaiiVar) {
        return new zzaim(zzajoVar, zzagrVar, zzaiiVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final int zza(Object obj) {
        zzajo zzajoVar = this.zzb;
        int zzb = zzajoVar.zzb(zzajoVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final Object zze() {
        zzaii zzaiiVar = this.zza;
        if (zzaiiVar instanceof zzahd) {
            return ((zzahd) zzaiiVar).zzw();
        }
        return zzaiiVar.zzC().zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzg(Object obj, Object obj2) {
        zzaiw.zzq(this.zzb, obj, obj2);
        if (!this.zzc) {
            return;
        }
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzh(Object obj, zzait zzaitVar, zzagq zzagqVar) throws IOException {
        boolean zzO;
        zzajo zzajoVar = this.zzb;
        zzagr zzagrVar = this.zzd;
        Object zzc = zzajoVar.zzc(obj);
        zzagv zzb = zzagrVar.zzb(obj);
        while (zzaitVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzaitVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzc2 = zzagrVar.zzc(zzagqVar, this.zza, zzd >>> 3);
                        if (zzc2 != null) {
                            zzagrVar.zzf(zzaitVar, zzc2, zzagqVar, zzb);
                        } else {
                            zzO = zzajoVar.zzp(zzc, zzaitVar);
                        }
                    } else {
                        zzO = zzaitVar.zzO();
                    }
                    if (!zzO) {
                        return;
                    }
                } else {
                    Object obj2 = null;
                    zzafy zzafyVar = null;
                    int i4 = 0;
                    while (zzaitVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzaitVar.zzd();
                        if (zzd2 == 16) {
                            i4 = zzaitVar.zzj();
                            obj2 = zzagrVar.zzc(zzagqVar, this.zza, i4);
                        } else if (zzd2 == 26) {
                            if (obj2 != null) {
                                zzagrVar.zzf(zzaitVar, obj2, zzagqVar, zzb);
                            } else {
                                zzafyVar = zzaitVar.zzp();
                            }
                        } else if (!zzaitVar.zzO()) {
                            break;
                        }
                    }
                    if (zzaitVar.zzd() == 12) {
                        if (zzafyVar != null) {
                            if (obj2 != null) {
                                zzagrVar.zzg(zzafyVar, obj2, zzagqVar, zzb);
                            } else {
                                zzajoVar.zzk(zzc, i4, zzafyVar);
                            }
                        }
                    } else {
                        throw zzahl.zzb();
                    }
                }
            } finally {
                zzajoVar.zzn(obj, zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzi(Object obj, byte[] bArr, int i4, int i5, zzafl zzaflVar) throws IOException {
        zzahd zzahdVar = (zzahd) obj;
        if (zzahdVar.zzc == zzajp.zzc()) {
            zzahdVar.zzc = zzajp.zzf();
        }
        zzaha zzahaVar = (zzaha) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiu
    public final void zzm(Object obj, zzagm zzagmVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
