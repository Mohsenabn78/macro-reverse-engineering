package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgx {
    private final zzfhe zza;
    private final zzfhe zzb;
    private final zzfhb zzc;
    private final zzfhd zzd;

    private zzfgx(zzfhb zzfhbVar, zzfhd zzfhdVar, zzfhe zzfheVar, zzfhe zzfheVar2, boolean z3) {
        this.zzc = zzfhbVar;
        this.zzd = zzfhdVar;
        this.zza = zzfheVar;
        if (zzfheVar2 == null) {
            this.zzb = zzfhe.NONE;
        } else {
            this.zzb = zzfheVar2;
        }
    }

    public static zzfgx zza(zzfhb zzfhbVar, zzfhd zzfhdVar, zzfhe zzfheVar, zzfhe zzfheVar2, boolean z3) {
        zzfid.zzb(zzfhdVar, "ImpressionType is null");
        zzfid.zzb(zzfheVar, "Impression owner is null");
        if (zzfheVar != zzfhe.NONE) {
            if (zzfhbVar == zzfhb.DEFINED_BY_JAVASCRIPT && zzfheVar == zzfhe.NATIVE) {
                throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
            }
            if (zzfhdVar == zzfhd.DEFINED_BY_JAVASCRIPT && zzfheVar == zzfhe.NATIVE) {
                throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
            }
            return new zzfgx(zzfhbVar, zzfhdVar, zzfheVar, zzfheVar2, true);
        }
        throw new IllegalArgumentException("Impression owner is none");
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfib.zze(jSONObject, "impressionOwner", this.zza);
        zzfib.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfib.zze(jSONObject, "creativeType", this.zzc);
        zzfib.zze(jSONObject, "impressionType", this.zzd);
        zzfib.zze(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
