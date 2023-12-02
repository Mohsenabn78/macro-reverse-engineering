package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzcr {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzcr.class.getName());
    private static final AtomicReference zzc = new AtomicReference(new zzbt());
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzcr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static zzbo zza(String str) throws GeneralSecurityException {
        return ((zzbt) zzc.get()).zzb(str);
    }

    public static synchronized zztc zzb(zzth zzthVar) throws GeneralSecurityException {
        zztc zza2;
        synchronized (zzcr.class) {
            zzbo zzb2 = ((zzbt) zzc.get()).zzb(zzthVar.zzg());
            if (((Boolean) zze.get(zzthVar.zzg())).booleanValue()) {
                zza2 = zzb2.zza(zzthVar.zzf());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzthVar.zzg())));
            }
        }
        return zza2;
    }

    @Nullable
    public static Class zzc(Class cls) {
        try {
            return zzkw.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzd(String str, zzafy zzafyVar, Class cls) throws GeneralSecurityException {
        return ((zzbt) zzc.get()).zza(str, cls).zzb(zzafyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Map zze() {
        Map unmodifiableMap;
        synchronized (zzcr.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static synchronized void zzf(zzlt zzltVar, zzkm zzkmVar, boolean z3) throws GeneralSecurityException {
        synchronized (zzcr.class) {
            AtomicReference atomicReference = zzc;
            zzbt zzbtVar = new zzbt((zzbt) atomicReference.get());
            zzbtVar.zzc(zzltVar, zzkmVar);
            Map zzc2 = zzltVar.zza().zzc();
            String zzd2 = zzltVar.zzd();
            zzi(zzd2, zzc2, true);
            String zzd3 = zzkmVar.zzd();
            zzi(zzd3, Collections.emptyMap(), false);
            if (!((zzbt) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcq(zzltVar));
                zzj(zzltVar.zzd(), zzltVar.zza().zzc());
            }
            ConcurrentMap concurrentMap = zze;
            concurrentMap.put(zzd2, Boolean.TRUE);
            concurrentMap.put(zzd3, Boolean.FALSE);
            atomicReference.set(zzbtVar);
        }
    }

    public static synchronized void zzg(zzkm zzkmVar, boolean z3) throws GeneralSecurityException {
        synchronized (zzcr.class) {
            AtomicReference atomicReference = zzc;
            zzbt zzbtVar = new zzbt((zzbt) atomicReference.get());
            zzbtVar.zzd(zzkmVar);
            Map zzc2 = zzkmVar.zza().zzc();
            String zzd2 = zzkmVar.zzd();
            zzi(zzd2, zzc2, true);
            if (!((zzbt) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcq(zzkmVar));
                zzj(zzd2, zzkmVar.zza().zzc());
            }
            zze.put(zzd2, Boolean.TRUE);
            atomicReference.set(zzbtVar);
        }
    }

    public static synchronized void zzh(zzcn zzcnVar) throws GeneralSecurityException {
        synchronized (zzcr.class) {
            zzkw.zza().zzf(zzcnVar);
        }
    }

    private static synchronized void zzi(String str, Map map, boolean z3) throws GeneralSecurityException {
        synchronized (zzcr.class) {
            if (z3) {
                ConcurrentMap concurrentMap = zze;
                if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                }
                if (((zzbt) zzc.get()).zze(str)) {
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

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaii] */
    private static void zzj(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), zzbv.zzd(str, ((zzkk) entry.getValue()).zza.zzq(), ((zzkk) entry.getValue()).zzb));
        }
    }
}
