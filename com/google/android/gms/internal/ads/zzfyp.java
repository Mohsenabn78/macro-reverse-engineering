package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfyp {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzfyp.class.getName());
    private static final AtomicReference zzc = new AtomicReference(new zzfxr());
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzfyp() {
    }

    public static synchronized zzgkk zza(zzgkp zzgkpVar) throws GeneralSecurityException {
        zzgkk zza2;
        synchronized (zzfyp.class) {
            zzfxo zzb2 = ((zzfxr) zzc.get()).zzb(zzgkpVar.zzh());
            if (((Boolean) zze.get(zzgkpVar.zzh())).booleanValue()) {
                zza2 = zzb2.zza(zzgkpVar.zzg());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzgkpVar.zzh())));
            }
        }
        return zza2;
    }

    @Nullable
    public static Class zzb(Class cls) {
        try {
            return zzgee.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzc(String str, zzgoe zzgoeVar, Class cls) throws GeneralSecurityException {
        return ((zzfxr) zzc.get()).zza(str, cls).zzb(zzgoeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Map zzd() {
        Map unmodifiableMap;
        synchronized (zzfyp.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, com.google.android.gms.internal.ads.zzgqw] */
    public static synchronized void zze(zzgdu zzgduVar, boolean z3) throws GeneralSecurityException {
        synchronized (zzfyp.class) {
            AtomicReference atomicReference = zzc;
            zzfxr zzfxrVar = new zzfxr((zzfxr) atomicReference.get());
            zzfxrVar.zzc(zzgduVar);
            Map zzc2 = zzgduVar.zza().zzc();
            String zzd2 = zzgduVar.zzd();
            zzg(zzd2, zzc2, true);
            if (!((zzfxr) atomicReference.get()).zzd(zzd2)) {
                zzd.put(zzd2, new zzfyo(zzgduVar));
                for (Map.Entry entry : zzgduVar.zza().zzc().entrySet()) {
                    zzg.put((String) entry.getKey(), zzfxt.zzb(zzd2, ((zzgds) entry.getValue()).zza.zzax(), ((zzgds) entry.getValue()).zzb));
                }
            }
            zze.put(zzd2, Boolean.TRUE);
            zzc.set(zzfxrVar);
        }
    }

    public static synchronized void zzf(zzfyn zzfynVar) throws GeneralSecurityException {
        synchronized (zzfyp.class) {
            zzgee.zza().zzf(zzfynVar);
        }
    }

    private static synchronized void zzg(String str, Map map, boolean z3) throws GeneralSecurityException {
        synchronized (zzfyp.class) {
            ConcurrentMap concurrentMap = zze;
            if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            if (((zzfxr) zzc.get()).zzd(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!zzg.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (zzg.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                    }
                }
            }
        }
    }
}
