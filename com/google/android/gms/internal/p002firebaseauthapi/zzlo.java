package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlo  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzlo {
    private final Map zza;
    private final Map zzb;

    private zzlo() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzlo zza(zzll zzllVar) throws GeneralSecurityException {
        zzlq zzlqVar = new zzlq(zzllVar.zzc(), zzllVar.zzd(), null);
        if (this.zza.containsKey(zzlqVar)) {
            zzll zzllVar2 = (zzll) this.zza.get(zzlqVar);
            if (!zzllVar2.equals(zzllVar) || !zzllVar.equals(zzllVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzlqVar.toString()));
            }
        } else {
            this.zza.put(zzlqVar, zzllVar);
        }
        return this;
    }

    public final zzlo zzb(zzcn zzcnVar) throws GeneralSecurityException {
        if (zzcnVar != null) {
            Map map = this.zzb;
            Class zzb = zzcnVar.zzb();
            if (map.containsKey(zzb)) {
                zzcn zzcnVar2 = (zzcn) this.zzb.get(zzb);
                if (!zzcnVar2.equals(zzcnVar) || !zzcnVar.equals(zzcnVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb.toString()));
                }
            } else {
                this.zzb.put(zzb, zzcnVar);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlo(zzln zzlnVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlo(zzls zzlsVar, zzln zzlnVar) {
        this.zza = new HashMap(zzls.zzd(zzlsVar));
        this.zzb = new HashMap(zzls.zze(zzlsVar));
    }
}
