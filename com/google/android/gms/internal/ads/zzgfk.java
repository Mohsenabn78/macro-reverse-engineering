package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfk {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzgfk(zzgfe zzgfeVar, zzgfj zzgfjVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzgfeVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgfeVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzgfeVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzgfeVar.zzd;
        this.zzd = new HashMap(map4);
    }

    public final zzfxn zza(zzgfd zzgfdVar, @Nullable zzfyq zzfyqVar) throws GeneralSecurityException {
        zzgfg zzgfgVar = new zzgfg(zzgfdVar.getClass(), zzgfdVar.zzd(), null);
        if (this.zzb.containsKey(zzgfgVar)) {
            return ((zzgdn) this.zzb.get(zzgfgVar)).zza(zzgfdVar, zzfyqVar);
        }
        String obj = zzgfgVar.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzfyf zzb(zzgfd zzgfdVar) throws GeneralSecurityException {
        zzgfg zzgfgVar = new zzgfg(zzgfdVar.getClass(), zzgfdVar.zzd(), null);
        if (this.zzd.containsKey(zzgfgVar)) {
            return ((zzgek) this.zzd.get(zzgfgVar)).zza(zzgfdVar);
        }
        String obj = zzgfgVar.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzgfd zzc(zzfyf zzfyfVar, Class cls) throws GeneralSecurityException {
        zzgfi zzgfiVar = new zzgfi(zzfyfVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzgfiVar)) {
            return ((zzgeo) this.zzc.get(zzgfiVar)).zza(zzfyfVar);
        }
        String obj = zzgfiVar.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzh(zzgfd zzgfdVar) {
        return this.zzb.containsKey(new zzgfg(zzgfdVar.getClass(), zzgfdVar.zzd(), null));
    }

    public final boolean zzi(zzgfd zzgfdVar) {
        return this.zzd.containsKey(new zzgfg(zzgfdVar.getClass(), zzgfdVar.zzd(), null));
    }
}
