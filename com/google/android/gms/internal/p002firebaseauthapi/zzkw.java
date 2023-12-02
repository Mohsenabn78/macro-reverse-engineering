package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzkw {
    private static final zzkw zza = new zzkw();
    private final AtomicReference zzb = new AtomicReference(new zzls(new zzlo(null), null));

    zzkw() {
    }

    public static zzkw zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzls) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzbn zzbnVar, Class cls) throws GeneralSecurityException {
        return ((zzls) this.zzb.get()).zzb(zzbnVar, cls);
    }

    public final Object zzd(zzcm zzcmVar, Class cls) throws GeneralSecurityException {
        return ((zzls) this.zzb.get()).zzc(zzcmVar, cls);
    }

    public final synchronized void zze(zzll zzllVar) throws GeneralSecurityException {
        zzlo zzloVar = new zzlo((zzls) this.zzb.get(), null);
        zzloVar.zza(zzllVar);
        this.zzb.set(new zzls(zzloVar, null));
    }

    public final synchronized void zzf(zzcn zzcnVar) throws GeneralSecurityException {
        zzlo zzloVar = new zzlo((zzls) this.zzb.get(), null);
        zzloVar.zzb(zzcnVar);
        this.zzb.set(new zzls(zzloVar, null));
    }
}
