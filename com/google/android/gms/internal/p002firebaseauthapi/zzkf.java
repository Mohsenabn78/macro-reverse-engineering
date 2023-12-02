package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkf  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzkf {
    private final zzwi zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkf(zzwi zzwiVar, Class cls, zzke zzkeVar) {
        this.zza = zzwiVar;
        this.zzb = cls;
    }

    public static zzkf zzb(zzkd zzkdVar, zzwi zzwiVar, Class cls) {
        return new zzkc(zzwiVar, cls, zzkdVar);
    }

    public abstract zzbn zza(zzlz zzlzVar, @Nullable zzcs zzcsVar) throws GeneralSecurityException;

    public final zzwi zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
