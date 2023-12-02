package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzll  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzll {
    private final Class zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzll(Class cls, Class cls2, zzlk zzlkVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzll zzb(zzlj zzljVar, Class cls, Class cls2) {
        return new zzli(cls, cls2, zzljVar);
    }

    public abstract Object zza(zzbn zzbnVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
