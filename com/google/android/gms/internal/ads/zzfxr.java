package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxr {
    private static final Logger zza = Logger.getLogger(zzfxr.class.getName());
    private final ConcurrentMap zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfxr() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzfxq zze(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzfxq) this.zzb.get(str);
    }

    private final synchronized void zzf(zzfxq zzfxqVar, boolean z3) throws GeneralSecurityException {
        String zzc = zzfxqVar.zza().zzc();
        zzfxq zzfxqVar2 = (zzfxq) this.zzb.get(zzc);
        if (zzfxqVar2 != null && !zzfxqVar2.zza.getClass().equals(zzfxqVar.zza.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(zzc));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", zzc, zzfxqVar2.zza.getClass().getName(), zzfxqVar.zza.getClass().getName()));
        }
        this.zzb.putIfAbsent(zzc, zzfxqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfxo zza(String str, Class cls) throws GeneralSecurityException {
        zzfxq zze = zze(str);
        if (zze.zza.zzl().contains(cls)) {
            try {
                return new zzfxp(zze.zza, cls);
            } catch (IllegalArgumentException e4) {
                throw new GeneralSecurityException("Primitive type not supported", e4);
            }
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zze.zza.getClass());
        Set<Class> zzl = zze.zza.zzl();
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (Class cls2 : zzl) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z3 = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfxo zzb(String str) throws GeneralSecurityException {
        return zze(str).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc(zzgdu zzgduVar) throws GeneralSecurityException {
        if (zzgdh.zza(zzgduVar.zzf())) {
            zzf(new zzfxq(zzgduVar), false);
        } else {
            String valueOf = String.valueOf(zzgduVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        return this.zzb.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfxr(zzfxr zzfxrVar) {
        this.zzb = new ConcurrentHashMap(zzfxrVar.zzb);
    }
}
