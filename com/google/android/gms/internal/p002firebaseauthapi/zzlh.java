package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlh  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzlh {
    private final Class zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlh(Class cls, Class cls2, zzlg zzlgVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzlh zzb(zzlf zzlfVar, Class cls, Class cls2) {
        return new zzle(cls, cls2, zzlfVar);
    }

    public abstract zzlz zza(zzcf zzcfVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
