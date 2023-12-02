package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgez {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzgez(zzgev zzgevVar, zzgey zzgeyVar) {
        Map map;
        Map map2;
        map = zzgevVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgevVar.zzb;
        this.zzb = new HashMap(map2);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzfyn) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzfxn zzfxnVar, Class cls) throws GeneralSecurityException {
        zzgex zzgexVar = new zzgex(zzfxnVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgexVar)) {
            return ((zzges) this.zza.get(zzgexVar)).zza(zzfxnVar);
        }
        String obj = zzgexVar.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzfym zzfymVar, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzfyn zzfynVar = (zzfyn) this.zzb.get(cls);
            if (zzfymVar.zzc().equals(zzfynVar.zza()) && zzfynVar.zza().equals(zzfymVar.zzc())) {
                return zzfynVar.zzc(zzfymVar);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
