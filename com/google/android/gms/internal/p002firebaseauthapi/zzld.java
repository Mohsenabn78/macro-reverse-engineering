package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzld  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzld {
    private final zzwi zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzld(zzwi zzwiVar, Class cls, zzlc zzlcVar) {
        this.zza = zzwiVar;
        this.zzb = cls;
    }

    public static zzld zzb(zzlb zzlbVar, zzwi zzwiVar, Class cls) {
        return new zzla(zzwiVar, cls, zzlbVar);
    }

    public abstract zzcf zza(zzlz zzlzVar) throws GeneralSecurityException;

    public final zzwi zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
