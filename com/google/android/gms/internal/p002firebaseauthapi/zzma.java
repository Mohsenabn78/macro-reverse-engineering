package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzma {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzma() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzma zza(zzkf zzkfVar) throws GeneralSecurityException {
        zzmc zzmcVar = new zzmc(zzkfVar.zzd(), zzkfVar.zzc(), null);
        if (this.zzb.containsKey(zzmcVar)) {
            zzkf zzkfVar2 = (zzkf) this.zzb.get(zzmcVar);
            if (!zzkfVar2.equals(zzkfVar) || !zzkfVar.equals(zzkfVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzmcVar.toString()));
            }
        } else {
            this.zzb.put(zzmcVar, zzkfVar);
        }
        return this;
    }

    public final zzma zzb(zzkj zzkjVar) throws GeneralSecurityException {
        zzme zzmeVar = new zzme(zzkjVar.zzb(), zzkjVar.zzc(), null);
        if (this.zza.containsKey(zzmeVar)) {
            zzkj zzkjVar2 = (zzkj) this.zza.get(zzmeVar);
            if (!zzkjVar2.equals(zzkjVar) || !zzkjVar.equals(zzkjVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzmeVar.toString()));
            }
        } else {
            this.zza.put(zzmeVar, zzkjVar);
        }
        return this;
    }

    public final zzma zzc(zzld zzldVar) throws GeneralSecurityException {
        zzmc zzmcVar = new zzmc(zzldVar.zzd(), zzldVar.zzc(), null);
        if (this.zzd.containsKey(zzmcVar)) {
            zzld zzldVar2 = (zzld) this.zzd.get(zzmcVar);
            if (!zzldVar2.equals(zzldVar) || !zzldVar.equals(zzldVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzmcVar.toString()));
            }
        } else {
            this.zzd.put(zzmcVar, zzldVar);
        }
        return this;
    }

    public final zzma zzd(zzlh zzlhVar) throws GeneralSecurityException {
        zzme zzmeVar = new zzme(zzlhVar.zzc(), zzlhVar.zzd(), null);
        if (this.zzc.containsKey(zzmeVar)) {
            zzlh zzlhVar2 = (zzlh) this.zzc.get(zzmeVar);
            if (!zzlhVar2.equals(zzlhVar) || !zzlhVar.equals(zzlhVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzmeVar.toString()));
            }
        } else {
            this.zzc.put(zzmeVar, zzlhVar);
        }
        return this;
    }

    public zzma(zzmg zzmgVar) {
        this.zza = new HashMap(zzmg.zze(zzmgVar));
        this.zzb = new HashMap(zzmg.zzd(zzmgVar));
        this.zzc = new HashMap(zzmg.zzg(zzmgVar));
        this.zzd = new HashMap(zzmg.zzf(zzmgVar));
    }
}
