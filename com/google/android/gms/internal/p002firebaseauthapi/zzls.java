package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzls */
/* loaded from: classes4.dex */
public final class zzls {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzls(zzlo zzloVar, zzlr zzlrVar) {
        Map map;
        Map map2;
        map = zzloVar.zza;
        this.zza = new HashMap(map);
        map2 = zzloVar.zzb;
        this.zzb = new HashMap(map2);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzcn) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzbn zzbnVar, Class cls) throws GeneralSecurityException {
        zzlq zzlqVar = new zzlq(zzbnVar.getClass(), cls, null);
        if (this.zza.containsKey(zzlqVar)) {
            return ((zzll) this.zza.get(zzlqVar)).zza(zzbnVar);
        }
        String obj = zzlqVar.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzcm zzcmVar, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzcn zzcnVar = (zzcn) this.zzb.get(cls);
            if (zzcmVar.zzc().equals(zzcnVar.zza()) && zzcnVar.zza().equals(zzcmVar.zzc())) {
                return zzcnVar.zzc(zzcmVar);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
