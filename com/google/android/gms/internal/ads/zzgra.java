package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgra implements zzgrp {
    private final zzgqw zza;
    private final zzgsg zzb;
    private final boolean zzc;
    private final zzgoz zzd;

    private zzgra(zzgsg zzgsgVar, zzgoz zzgozVar, zzgqw zzgqwVar) {
        this.zzb = zzgsgVar;
        this.zzc = zzgozVar.zzh(zzgqwVar);
        this.zzd = zzgozVar;
        this.zza = zzgqwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgra zzc(zzgsg zzgsgVar, zzgoz zzgozVar, zzgqw zzgqwVar) {
        return new zzgra(zzgsgVar, zzgozVar, zzgqwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final int zza(Object obj) {
        zzgsg zzgsgVar = this.zzb;
        int zzb = zzgsgVar.zzb(zzgsgVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final Object zze() {
        zzgqw zzgqwVar = this.zza;
        if (zzgqwVar instanceof zzgpm) {
            return ((zzgpm) zzgqwVar).zzaD();
        }
        return zzgqwVar.zzaP().zzan();
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzg(Object obj, Object obj2) {
        zzgrr.zzC(this.zzb, obj, obj2);
        if (!this.zzc) {
            return;
        }
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzh(Object obj, zzgrh zzgrhVar, zzgoy zzgoyVar) throws IOException {
        boolean zzO;
        zzgsg zzgsgVar = this.zzb;
        zzgoz zzgozVar = this.zzd;
        Object zzc = zzgsgVar.zzc(obj);
        zzgpd zzb = zzgozVar.zzb(obj);
        while (zzgrhVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzgrhVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzc2 = zzgozVar.zzc(zzgoyVar, this.zza, zzd >>> 3);
                        if (zzc2 != null) {
                            zzgozVar.zzf(zzgrhVar, zzc2, zzgoyVar, zzb);
                        } else {
                            zzO = zzgsgVar.zzp(zzc, zzgrhVar);
                        }
                    } else {
                        zzO = zzgrhVar.zzO();
                    }
                    if (!zzO) {
                        return;
                    }
                } else {
                    Object obj2 = null;
                    zzgoe zzgoeVar = null;
                    int i4 = 0;
                    while (zzgrhVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzgrhVar.zzd();
                        if (zzd2 == 16) {
                            i4 = zzgrhVar.zzj();
                            obj2 = zzgozVar.zzc(zzgoyVar, this.zza, i4);
                        } else if (zzd2 == 26) {
                            if (obj2 != null) {
                                zzgozVar.zzf(zzgrhVar, obj2, zzgoyVar, zzb);
                            } else {
                                zzgoeVar = zzgrhVar.zzp();
                            }
                        } else if (!zzgrhVar.zzO()) {
                            break;
                        }
                    }
                    if (zzgrhVar.zzd() == 12) {
                        if (zzgoeVar != null) {
                            if (obj2 != null) {
                                zzgozVar.zzg(zzgoeVar, obj2, zzgoyVar, zzb);
                            } else {
                                zzgsgVar.zzk(zzc, i4, zzgoeVar);
                            }
                        }
                    } else {
                        throw zzgpy.zzb();
                    }
                }
            } finally {
                zzgsgVar.zzn(obj, zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzi(Object obj, byte[] bArr, int i4, int i5, zzgnq zzgnqVar) throws IOException {
        zzgpm zzgpmVar = (zzgpm) obj;
        if (zzgpmVar.zzc == zzgsh.zzc()) {
            zzgpmVar.zzc = zzgsh.zzf();
        }
        zzgpj zzgpjVar = (zzgpj) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
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

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrp
    public final void zzm(Object obj, zzgou zzgouVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
