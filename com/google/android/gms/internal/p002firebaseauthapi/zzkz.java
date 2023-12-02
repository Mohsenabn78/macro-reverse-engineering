package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzkz {
    private static final zzkz zza = (zzkz) zzmi.zza(new zzmh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmh
        public final Object zza() {
            zzkz zzkzVar = new zzkz();
            zzkzVar.zzf(new zzkg(zzko.class, zzlu.class, new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzky
            }));
            return zzkzVar;
        }
    });
    private final AtomicReference zzb = new AtomicReference(new zzmg(new zzma(), null));

    public static zzkz zzc() {
        return zza;
    }

    public final zzbn zza(zzlu zzluVar, @Nullable zzcs zzcsVar) throws GeneralSecurityException {
        if (!((zzmg) this.zzb.get()).zzh(zzluVar)) {
            return new zzko(zzluVar, zzcsVar);
        }
        return ((zzmg) this.zzb.get()).zza(zzluVar, zzcsVar);
    }

    public final zzcf zzb(zzlz zzlzVar) throws GeneralSecurityException {
        return ((zzmg) this.zzb.get()).zzb(zzlzVar);
    }

    public final zzlz zzd(zzcf zzcfVar, Class cls) throws GeneralSecurityException {
        return ((zzmg) this.zzb.get()).zzc(zzcfVar, cls);
    }

    public final synchronized void zze(zzkf zzkfVar) throws GeneralSecurityException {
        zzma zzmaVar = new zzma((zzmg) this.zzb.get());
        zzmaVar.zza(zzkfVar);
        this.zzb.set(new zzmg(zzmaVar, null));
    }

    public final synchronized void zzf(zzkj zzkjVar) throws GeneralSecurityException {
        zzma zzmaVar = new zzma((zzmg) this.zzb.get());
        zzmaVar.zzb(zzkjVar);
        this.zzb.set(new zzmg(zzmaVar, null));
    }

    public final synchronized void zzg(zzld zzldVar) throws GeneralSecurityException {
        zzma zzmaVar = new zzma((zzmg) this.zzb.get());
        zzmaVar.zzc(zzldVar);
        this.zzb.set(new zzmg(zzmaVar, null));
    }

    public final synchronized void zzh(zzlh zzlhVar) throws GeneralSecurityException {
        zzma zzmaVar = new zzma((zzmg) this.zzb.get());
        zzmaVar.zzd(zzlhVar);
        this.zzb.set(new zzmg(zzmaVar, null));
    }

    public final boolean zzi(zzlz zzlzVar) {
        return ((zzmg) this.zzb.get()).zzi(zzlzVar);
    }
}
