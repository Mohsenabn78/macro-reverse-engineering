package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzca  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzca {
    @GuardedBy("this")
    private final zztm zza;

    private zzca(zztm zztmVar) {
        this.zza = zztmVar;
    }

    public static zzca zze() {
        return new zzca(zztp.zzc());
    }

    public static zzca zzf(zzbz zzbzVar) {
        return new zzca((zztm) zzbzVar.zzc().zzu());
    }

    private final synchronized int zzg() {
        int zza;
        zza = zzmj.zza();
        while (zzj(zza)) {
            zza = zzmj.zza();
        }
        return zza;
    }

    private final synchronized zzto zzh(zztc zztcVar, zzui zzuiVar) throws GeneralSecurityException {
        zztn zzc;
        int zzg = zzg();
        if (zzuiVar != zzui.UNKNOWN_PREFIX) {
            zzc = zzto.zzc();
            zzc.zza(zztcVar);
            zzc.zzb(zzg);
            zzc.zzd(3);
            zzc.zzc(zzuiVar);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzto) zzc.zzi();
    }

    private final synchronized zzto zzi(zzth zzthVar) throws GeneralSecurityException {
        return zzh(zzcr.zzb(zzthVar), zzthVar.zze());
    }

    private final synchronized boolean zzj(int i4) {
        for (zzto zztoVar : this.zza.zze()) {
            if (zztoVar.zza() == i4) {
                return true;
            }
        }
        return false;
    }

    public final synchronized int zza(zzth zzthVar, boolean z3) throws GeneralSecurityException {
        zzto zzi;
        zzi = zzi(zzthVar);
        this.zza.zzb(zzi);
        return zzi.zza();
    }

    public final synchronized zzbz zzb() throws GeneralSecurityException {
        return zzbz.zza((zztp) this.zza.zzi());
    }

    public final synchronized zzca zzc(zzbv zzbvVar) throws GeneralSecurityException {
        zza(zzbvVar.zzc(), false);
        return this;
    }

    public final synchronized zzca zzd(int i4) throws GeneralSecurityException {
        for (int i5 = 0; i5 < this.zza.zza(); i5++) {
            zzto zzd = this.zza.zzd(i5);
            if (zzd.zza() == i4) {
                if (zzd.zzk() == 3) {
                    this.zza.zzc(i4);
                } else {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i4);
                }
            }
        }
        throw new GeneralSecurityException("key not found: " + i4);
        return this;
    }
}
