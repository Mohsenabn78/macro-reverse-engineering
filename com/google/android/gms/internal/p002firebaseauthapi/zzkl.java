package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzkl {
    private final Class zza;

    public zzkl(Class cls) {
        this.zza = cls;
    }

    public abstract zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException;

    public abstract zzaii zzb(zzafy zzafyVar) throws zzahl;

    public Map zzc() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void zzd(zzaii zzaiiVar) throws GeneralSecurityException;
}
