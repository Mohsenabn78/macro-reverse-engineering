package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgeg {
    private static final zzgeg zza;
    private final AtomicReference zzb = new AtomicReference(new zzgfk(new zzgfe(), null));

    static {
        try {
            zzgeg zzgegVar = new zzgeg();
            zzgegVar.zzf(new zzgdo(zzgdw.class, zzgfa.class, new zzgdp() { // from class: com.google.android.gms.internal.ads.zzgef
            }));
            zza = zzgegVar;
        } catch (Exception e4) {
            throw new zzgfl(e4);
        }
    }

    public static zzgeg zzc() {
        return zza;
    }

    public final zzfxn zza(zzgfa zzgfaVar, @Nullable zzfyq zzfyqVar) throws GeneralSecurityException {
        if (!((zzgfk) this.zzb.get()).zzh(zzgfaVar)) {
            return new zzgdw(zzgfaVar, zzfyqVar);
        }
        return ((zzgfk) this.zzb.get()).zza(zzgfaVar, zzfyqVar);
    }

    public final zzfyf zzb(zzgfd zzgfdVar) throws GeneralSecurityException {
        return ((zzgfk) this.zzb.get()).zzb(zzgfdVar);
    }

    public final zzgfd zzd(zzfyf zzfyfVar, Class cls) throws GeneralSecurityException {
        return ((zzgfk) this.zzb.get()).zzc(zzfyfVar, cls);
    }

    public final synchronized void zze(zzgdn zzgdnVar) throws GeneralSecurityException {
        zzgfe zzgfeVar = new zzgfe((zzgfk) this.zzb.get());
        zzgfeVar.zza(zzgdnVar);
        this.zzb.set(new zzgfk(zzgfeVar, null));
    }

    public final synchronized void zzf(zzgdr zzgdrVar) throws GeneralSecurityException {
        zzgfe zzgfeVar = new zzgfe((zzgfk) this.zzb.get());
        zzgfeVar.zzb(zzgdrVar);
        this.zzb.set(new zzgfk(zzgfeVar, null));
    }

    public final synchronized void zzg(zzgek zzgekVar) throws GeneralSecurityException {
        zzgfe zzgfeVar = new zzgfe((zzgfk) this.zzb.get());
        zzgfeVar.zzc(zzgekVar);
        this.zzb.set(new zzgfk(zzgfeVar, null));
    }

    public final synchronized void zzh(zzgeo zzgeoVar) throws GeneralSecurityException {
        zzgfe zzgfeVar = new zzgfe((zzgfk) this.zzb.get());
        zzgfeVar.zzd(zzgeoVar);
        this.zzb.set(new zzgfk(zzgfeVar, null));
    }

    public final boolean zzi(zzgfd zzgfdVar) {
        return ((zzgfk) this.zzb.get()).zzi(zzgfdVar);
    }
}
