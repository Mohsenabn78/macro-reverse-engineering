package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfe {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgfe() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgfe zza(zzgdn zzgdnVar) throws GeneralSecurityException {
        zzgfg zzgfgVar = new zzgfg(zzgdnVar.zzd(), zzgdnVar.zzc(), null);
        if (this.zzb.containsKey(zzgfgVar)) {
            zzgdn zzgdnVar2 = (zzgdn) this.zzb.get(zzgfgVar);
            if (!zzgdnVar2.equals(zzgdnVar) || !zzgdnVar.equals(zzgdnVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgfgVar.toString()));
            }
        } else {
            this.zzb.put(zzgfgVar, zzgdnVar);
        }
        return this;
    }

    public final zzgfe zzb(zzgdr zzgdrVar) throws GeneralSecurityException {
        zzgfi zzgfiVar = new zzgfi(zzgdrVar.zzb(), zzgdrVar.zzc(), null);
        if (this.zza.containsKey(zzgfiVar)) {
            zzgdr zzgdrVar2 = (zzgdr) this.zza.get(zzgfiVar);
            if (!zzgdrVar2.equals(zzgdrVar) || !zzgdrVar.equals(zzgdrVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgfiVar.toString()));
            }
        } else {
            this.zza.put(zzgfiVar, zzgdrVar);
        }
        return this;
    }

    public final zzgfe zzc(zzgek zzgekVar) throws GeneralSecurityException {
        zzgfg zzgfgVar = new zzgfg(zzgekVar.zzd(), zzgekVar.zzc(), null);
        if (this.zzd.containsKey(zzgfgVar)) {
            zzgek zzgekVar2 = (zzgek) this.zzd.get(zzgfgVar);
            if (!zzgekVar2.equals(zzgekVar) || !zzgekVar.equals(zzgekVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgfgVar.toString()));
            }
        } else {
            this.zzd.put(zzgfgVar, zzgekVar);
        }
        return this;
    }

    public final zzgfe zzd(zzgeo zzgeoVar) throws GeneralSecurityException {
        zzgfi zzgfiVar = new zzgfi(zzgeoVar.zzc(), zzgeoVar.zzd(), null);
        if (this.zzc.containsKey(zzgfiVar)) {
            zzgeo zzgeoVar2 = (zzgeo) this.zzc.get(zzgfiVar);
            if (!zzgeoVar2.equals(zzgeoVar) || !zzgeoVar.equals(zzgeoVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgfiVar.toString()));
            }
        } else {
            this.zzc.put(zzgfiVar, zzgeoVar);
        }
        return this;
    }

    public zzgfe(zzgfk zzgfkVar) {
        this.zza = new HashMap(zzgfk.zze(zzgfkVar));
        this.zzb = new HashMap(zzgfk.zzd(zzgfkVar));
        this.zzc = new HashMap(zzgfk.zzg(zzgfkVar));
        this.zzd = new HashMap(zzgfk.zzf(zzgfkVar));
    }
}
