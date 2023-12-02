package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjc  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjc implements zzbl {
    private final zzsx zza;
    private final zzjd zzb;
    private final zziz zzc;
    private final zziy zzd;

    private zzjc(zzsx zzsxVar, zzjd zzjdVar, zziy zziyVar, zziz zzizVar) {
        this.zza = zzsxVar;
        this.zzb = zzjdVar;
        this.zzd = zziyVar;
        this.zzc = zzizVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjc zza(zzsx zzsxVar) throws GeneralSecurityException {
        if (!zzsxVar.zzg().zzp()) {
            zzsr zzb = zzsxVar.zzb();
            return new zzjc(zzsxVar, zzjf.zzb(zzb), zzjf.zzc(zzb), zzjf.zza(zzb));
        }
        throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
    }
}
