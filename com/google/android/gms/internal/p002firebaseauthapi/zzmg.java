package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg */
/* loaded from: classes4.dex */
public final class zzmg {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzmg(zzma zzmaVar, zzmf zzmfVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzmaVar.zza;
        this.zza = new HashMap(map);
        map2 = zzmaVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzmaVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzmaVar.zzd;
        this.zzd = new HashMap(map4);
    }

    public final zzbn zza(zzlz zzlzVar, @Nullable zzcs zzcsVar) throws GeneralSecurityException {
        zzmc zzmcVar = new zzmc(zzlzVar.getClass(), zzlzVar.zzd(), null);
        if (this.zzb.containsKey(zzmcVar)) {
            return ((zzkf) this.zzb.get(zzmcVar)).zza(zzlzVar, zzcsVar);
        }
        String obj = zzmcVar.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzcf zzb(zzlz zzlzVar) throws GeneralSecurityException {
        zzmc zzmcVar = new zzmc(zzlzVar.getClass(), zzlzVar.zzd(), null);
        if (this.zzd.containsKey(zzmcVar)) {
            return ((zzld) this.zzd.get(zzmcVar)).zza(zzlzVar);
        }
        String obj = zzmcVar.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzlz zzc(zzcf zzcfVar, Class cls) throws GeneralSecurityException {
        zzme zzmeVar = new zzme(zzcfVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzmeVar)) {
            return ((zzlh) this.zzc.get(zzmeVar)).zza(zzcfVar);
        }
        String obj = zzmeVar.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzh(zzlz zzlzVar) {
        return this.zzb.containsKey(new zzmc(zzlzVar.getClass(), zzlzVar.zzd(), null));
    }

    public final boolean zzi(zzlz zzlzVar) {
        return this.zzd.containsKey(new zzmc(zzlzVar.getClass(), zzlzVar.zzd(), null));
    }
}
