package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbt  reason: invalid package */
/* loaded from: classes4.dex */
final class zzbt {
    private static final Logger zza = Logger.getLogger(zzbt.class.getName());
    private final ConcurrentMap zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbt() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzbs zzf(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzbs) this.zzb.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
        r6.zzb.putIfAbsent(r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void zzg(com.google.android.gms.internal.p002firebaseauthapi.zzbs r7, boolean r8) throws java.security.GeneralSecurityException {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.firebase-auth-api.zzbo r0 = r7.zzb()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r0.zzc()     // Catch: java.lang.Throwable -> L6b
            java.util.concurrent.ConcurrentMap r1 = r6.zzb     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.internal.firebase-auth-api.zzbs r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzbs) r1     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L5b
            java.lang.Class r2 = r1.zzc()     // Catch: java.lang.Throwable -> L6b
            java.lang.Class r3 = r7.zzc()     // Catch: java.lang.Throwable -> L6b
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L6b
            if (r2 == 0) goto L22
            goto L5b
        L22:
            java.lang.String r8 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r8 = r8.concat(r0)     // Catch: java.lang.Throwable -> L6b
            java.util.logging.Logger r2 = com.google.android.gms.internal.p002firebaseauthapi.zzbt.zza     // Catch: java.lang.Throwable -> L6b
            java.util.logging.Level r3 = java.util.logging.Level.WARNING     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "com.google.crypto.tink.KeyManagerRegistry"
            java.lang.String r5 = "registerKeyManagerContainer"
            r2.logp(r3, r4, r5, r8)     // Catch: java.lang.Throwable -> L6b
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L6b
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L6b
            r3 = 0
            r2[r3] = r0     // Catch: java.lang.Throwable -> L6b
            java.lang.Class r0 = r1.zzc()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L6b
            r1 = 1
            r2[r1] = r0     // Catch: java.lang.Throwable -> L6b
            java.lang.Class r7 = r7.zzc()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L6b
            r0 = 2
            r2[r0] = r7     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            java.lang.String r7 = java.lang.String.format(r7, r2)     // Catch: java.lang.Throwable -> L6b
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L6b
            throw r8     // Catch: java.lang.Throwable -> L6b
        L5b:
            if (r8 != 0) goto L64
            java.util.concurrent.ConcurrentMap r8 = r6.zzb     // Catch: java.lang.Throwable -> L6b
            r8.putIfAbsent(r0, r7)     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r6)
            return
        L64:
            java.util.concurrent.ConcurrentMap r8 = r6.zzb     // Catch: java.lang.Throwable -> L6b
            r8.put(r0, r7)     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r6)
            return
        L6b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbt.zzg(com.google.android.gms.internal.firebase-auth-api.zzbs, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbo zza(String str, Class cls) throws GeneralSecurityException {
        zzbs zzf = zzf(str);
        if (zzf.zze().contains(cls)) {
            return zzf.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzf.zzc());
        Set<Class> zze = zzf.zze();
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (Class cls2 : zze) {
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
    public final zzbo zzb(String str) throws GeneralSecurityException {
        return zzf(str).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc(zzlt zzltVar, zzkm zzkmVar) throws GeneralSecurityException {
        Class zzd;
        if (zzhk.zza(1)) {
            if (zzhk.zza(zzkmVar.zzf())) {
                String zzd2 = zzltVar.zzd();
                String zzd3 = zzkmVar.zzd();
                if (this.zzb.containsKey(zzd2) && ((zzbs) this.zzb.get(zzd2)).zzd() != null && (zzd = ((zzbs) this.zzb.get(zzd2)).zzd()) != null && !zzd.getName().equals(zzkmVar.getClass().getName())) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    logger.logp(level, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + zzd2 + " with inconsistent public key type " + zzd3);
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzltVar.getClass().getName(), zzd.getName(), zzkmVar.getClass().getName()));
                }
                zzg(new zzbr(zzltVar, zzkmVar), true);
                zzg(new zzbq(zzkmVar), false);
            } else {
                String valueOf = String.valueOf(zzkmVar.getClass());
                throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
            }
        } else {
            String valueOf2 = String.valueOf(zzltVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf2 + " as it is not FIPS compatible.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzd(zzkm zzkmVar) throws GeneralSecurityException {
        if (zzhk.zza(zzkmVar.zzf())) {
            zzg(new zzbq(zzkmVar), false);
        } else {
            String valueOf = String.valueOf(zzkmVar.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zze(String str) {
        return this.zzb.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbt(zzbt zzbtVar) {
        this.zzb = new ConcurrentHashMap(zzbtVar.zzb);
    }
}
