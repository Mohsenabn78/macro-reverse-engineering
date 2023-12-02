package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzir  reason: invalid package */
/* loaded from: classes4.dex */
final class zzir implements zzbl {
    final zzcm zza;
    private final zzon zzb;

    public zzir(zzcm zzcmVar) {
        zzon zzonVar;
        this.zza = zzcmVar;
        if (zzcmVar.zzf()) {
            zzonVar = zzkv.zza().zzb().zza(zzks.zza(zzcmVar), "hybrid_encrypt", "encrypt");
        } else {
            zzonVar = zzks.zza;
        }
        this.zzb = zzonVar;
    }
}
